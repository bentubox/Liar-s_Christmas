package com.lc.game.Scene;

import java.util.HashMap;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.Manager.StateManager;
import com.lc.game.Scene.scenes.*;

public class SceneState {

	private HashMap<String, Scene> scenes;
	
	public SceneState(AssetManager assetManager, StateManager stateManager) {
		
		scenes = new HashMap<String, Scene>();
		
		scenes.put("Sodden Lot", new SoddenLotScene(assetManager));
		scenes.put("Sunken Dormitory", new SunkenDormitoryScene(assetManager));
	}

	public HashMap<String, Scene> getScenes() {
		return scenes;
	}

	public void setScenes(HashMap<String, Scene> scenes) {
		this.scenes = scenes;
	}
	
}
