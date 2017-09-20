package com.lc.game.Map.actors;

import java.util.ArrayList;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.lc.game.AChristmasActor;
import com.lc.game.AssetList;
import com.lc.game.LiarGame;

/**
 * Actor representing a map node in the overworld.
 * Can be bound to another Actor (the map) to follow it's movements.
 * Can be extended to create specific map locations.
 */
public abstract class Node extends AChristmasActor{

	private BitmapFont font;
	private Color color;
	private GlyphLayout layout;
	
	private Texture nodeIcon;
	private String name;
	
	private boolean showName;
	private static float nameScale = 0.3f;
	private AChristmasActor followMe;
	private InputListener nodeListener;
	private int relX, relY;
	
	private ArrayList<Edge> connections;

	public Node(AssetManager assetManager, String name, int relX, int relY, AChristmasActor map) {
		super(assetManager,(int) map.getX() + relX, (int)map.getY() + relY);
		nodeIcon = getAssetManager().get(AssetList.MAP_NODE.toString());
		this.name = name;
		setWidth(nodeIcon.getWidth());
		setHeight(nodeIcon.getHeight());
		updateHitBox();
		
		font = LiarGame.SYSTEM_FONT_TEXT;
		color = LiarGame.DEFAULT_TEXT_COLOR;
		font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		font.getData().setScale(nameScale);
		layout = new GlyphLayout(font, name);
		font.getData().setScale(1.0f);

		setShowName(false);
		
		nodeListener = new InputListener() {
			@Override
			public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
				super.enter(event, y, y, pointer, fromActor);
				setShowName(true);
			}

			@Override
			public void exit (InputEvent event, float x, float y, int pointer, Actor toActor) {
				super.exit(event, x, y, pointer, toActor);
				setShowName(false);
			}
		};
		addListener(nodeListener);
		
		this.relX = relX;
		this.relY = relY;
		followMe = map;
		
		initConnections();
	}
	
	private void initConnections() {
		connections = new ArrayList<Edge>();
	}

	@Override
	public void act(float delta) {
		setX(followMe.getX() + relX);
		setY(followMe.getY() + relY);
		updateHitBox();
	}

	@Override
	public void draw(Batch batch, float alpha) {
		batch.draw(nodeIcon, getX(), getY());
		if(showName) {
			font.setColor(color);
			font.getData().setScale(nameScale);
			font.draw(batch, this.name, getCenterX() - layout.width / 2, getCenterY() + getHeight());
			font.getData().setScale(1.0f);
			font.setColor(LiarGame.DEFAULT_TEXT_COLOR);	
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isShowName() {
		return showName;
	}

	public void setShowName(boolean showName) {
		this.showName = showName;
	}

	public ArrayList<Edge> getConnections() {
		return connections;
	}
}
