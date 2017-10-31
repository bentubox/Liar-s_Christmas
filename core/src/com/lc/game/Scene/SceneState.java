package com.lc.game.Scene;

import java.util.HashMap;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.Manager.StateManager;
import com.lc.game.Scene.scenes.*;

public class SceneState {

	private HashMap<String, Scene> scenes;
	
	public SceneState(AssetManager assetManager, StateManager stateManager) {
		
		scenes = new HashMap<String, Scene>();
		
		scenes.put("Sodden Lot", new SoddenLot(assetManager));
		scenes.put("Sunken Dormitory", new SunkenDormitory(assetManager));
		scenes.put("The Fountain", new Fountain(assetManager));
		scenes.put("The Mangroves", new Mangroves(assetManager));
		scenes.put("The Glade", new Glade(assetManager));
	}

	public Scene getScene(String name) {
		if (scenes.get(name) != null) {
			return scenes.get(name);
		} else {
			return scenes.get("Sodden Lot");
		}
		
	}
	
	public HashMap<String, Scene> getScenes() {
		return scenes;
	}

	public void setScenes(HashMap<String, Scene> scenes) {
		this.scenes = scenes;
	}
	
}
