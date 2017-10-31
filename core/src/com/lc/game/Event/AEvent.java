package com.lc.game.Event;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.lc.game.AChristmasActor;
import com.lc.game.Manager.StateManager;

public abstract class AEvent extends AChristmasActor {

	//Reference to asset manager for obtaining assets.
	protected AssetManager assetManager;
		
	//Reference to game state manager.
	protected StateManager stateManager;
	
	private Texture image;
	
	public AEvent(AssetManager assetManager, String name, String area, int X, int Y, Texture image) {
		super(assetManager, X, Y);
		this.setImage(image);

	}
	
	protected abstract void clicked();

	public void onTimePass() {
		
	}

	public void onMove() {
		
	}

	public Texture getImage() {
		return image;
	}

	public void setImage(Texture image) {
		this.image = image;
	}
}
