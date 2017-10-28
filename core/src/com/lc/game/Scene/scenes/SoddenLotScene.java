package com.lc.game.Scene.scenes;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AssetList;
import com.lc.game.Scene.Scene;

public class SoddenLotScene extends Scene {
	
	final static String backdrop = AssetList.SCENE1TEST.toString();
	
	public SoddenLotScene(AssetManager assetManager) {
		super(assetManager, backdrop);
	}
}
