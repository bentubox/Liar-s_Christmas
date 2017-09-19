package com.lc.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Basic template Actor class for game.
 */
public abstract class AChristmasActor extends Actor{

	//Reference to asset manager for obtaining assets.
	protected AssetManager assetManager;
	
	public AChristmasActor(AssetManager assetManager) {
		this.assetManager = assetManager;
	}
	
	public AssetManager getAssetManager() {
		return assetManager;
	}

	public void setAssetManager(AssetManager assetManager) {
		this.assetManager = assetManager;
	}
}
