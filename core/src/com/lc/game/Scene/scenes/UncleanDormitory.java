package com.lc.game.Scene.scenes;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AssetList;
import com.lc.game.Event.AEvent;
import com.lc.game.Scene.Scene;

public class UncleanDormitory extends Scene {
	
	final static String backdrop = AssetList.SCENEUNCLEANDORM.toString();
	
	public UncleanDormitory(AssetManager assetManager) {
		super(assetManager, backdrop);
		
	}

	@Override
	public void init() {
		addEvent(new AEvent[]{

		});
	}
}
