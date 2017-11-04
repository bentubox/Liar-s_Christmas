package com.lc.game.Event;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.lc.game.AChristmasActor;
import com.lc.game.GlobalActors.Player.APlayer;
import com.lc.game.Manager.StateManager;

public abstract class AEvent extends AChristmasActor {

	//Reference to asset manager for obtaining assets.
	protected AssetManager assetManager;
		
	//This is the image that represents the event in the sceneview
	private Texture image;
	
	//This is the string that appears if you mouse over the event.
	private String name;
	
	public AEvent(AssetManager assetManager, String name, int X, int Y, Texture image) {
		super(assetManager, X, Y);
		this.setImage(image);
		this.name = name; 
		setWidth(image.getWidth());
		setHeight(image.getHeight());
		updateHitBox();
	}
	
	@Override
	public void draw(Batch batch, float alpha) {
		batch.draw(image, getX(), getY());
	}
	
	//This will be run when the event is clicked in the sceneview
	public abstract void onClick(final StateManager stateManager);

	//This is run every time a moment passes in the game.
	public void onTimePass(StateManager stateManager, int elapse) {
		
	}

	//This is run every time a person moves from one node to another
	public void onMove(String start, String end, APlayer schmuck, StateManager stateManager) {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Texture getImage() {
		return image;
	}

	public void setImage(Texture image) {
		this.image = image;
	}
}
