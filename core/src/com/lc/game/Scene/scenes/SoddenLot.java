package com.lc.game.Scene.scenes;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AssetList;
import com.lc.game.Scene.Scene;

public class SoddenLot extends Scene {
	
	final static String backdrop = AssetList.SCENESODDENLOT.toString();
	
	public SoddenLot(AssetManager assetManager) {
		super(assetManager, backdrop);
	}
}
