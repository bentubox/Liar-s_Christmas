package com.lc.game.Map.actors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
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
	private String name, area;
	
	/**
	 * showName: Player is mousing over the node; name is shown.
	 * visible: Player can see the node but has not necessarily explored it yet.
	 * explored: Player has visited the node before. These are always visible.
	 */
	private boolean showName, discovered, explored;
	private static float nameScale = 0.3f;
	private AChristmasActor followMe;
	private int relX, relY;
	
	//Array of neighboring node names with travel times.
	private Map<String, Integer> neighbors;

	//Array of outgoing edges, built from neighbors when map is generated.
	private ArrayList<Edge> connections;
	
	public Node(AssetManager assetManager, String name, String area, int relX, int relY, AChristmasActor map) {
		super(assetManager,(int) map.getX() + relX, (int)map.getY() + relY);
		nodeIcon = getAssetManager().get(AssetList.MAP_NODE.toString());
		this.name = name;
		this.area = area;
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
		setDiscovered(false);
		setExplored(false);
		
		this.relX = relX;
		this.relY = relY;
		this.followMe = map;
		
		this.neighbors = new HashMap<String, Integer>();
		this.connections = new ArrayList<Edge>();
		initNeighbors();
	}
	
	protected abstract void initNeighbors();

	@Override
	public void act(float delta) {
		super.act(delta);
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
	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}


	public boolean isShowName() {
		return showName;
	}

	public void setShowName(boolean showName) {
		this.showName = showName;
	}
	
	public boolean isDiscovered() {
		return discovered;
	}

	public void setDiscovered(boolean discovered) {
		this.discovered = discovered;
	}

	public boolean isExplored() {
		return explored;
	}

	public void setExplored(boolean explored) {
		this.explored = explored;
	}

	public ArrayList<Edge> getConnections() {
		return connections;
	}

	public Map<String, Integer> getNeighbors() {
		return neighbors;
	}
	
	protected void setNeighbors(Map<String, Integer> neighbors) {
		this.neighbors = neighbors;
	}
}
