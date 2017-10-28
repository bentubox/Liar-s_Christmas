package com.lc.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.lc.game.Manager.StateManager;

/**
 * Abstract extension of Stage class for different game views.
 */
public abstract class AView extends Stage {
	
	//Reference to asset manager for obtaining assets.
	protected AssetManager assetManager;
	
	//Reference to game state manager.
	protected StateManager stateManager;
	
	protected String VIEW_TYPE = "DEFAULT";

	public AView(AssetManager assetManager, StateManager stateManager, Viewport viewport, Batch batch) {
		super(viewport, batch);
		this.assetManager = assetManager;
		this.stateManager = stateManager;
		setType();
	}
	
	public abstract void init();
		
	protected abstract void setType();
	
	public String toString() {
		return VIEW_TYPE;
	}
	
	public AssetManager getAssetManager() {
		return assetManager;
	}

	public StateManager getStateManager() {
		return stateManager;
	}
}
