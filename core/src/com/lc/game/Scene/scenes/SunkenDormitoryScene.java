package com.lc.game.Scene.scenes;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AssetList;
import com.lc.game.Scene.Scene;

public class SunkenDormitoryScene extends Scene {
	
	final static String backdrop = AssetList.SCENE2TEST.toString();
	
	public SunkenDormitoryScene(AssetManager assetManager) {
		super(assetManager, backdrop);
	}
}
