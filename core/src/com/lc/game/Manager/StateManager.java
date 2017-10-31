package com.lc.game.Manager;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.Map.MapState;
import com.lc.game.Scene.SceneState;

public class StateManager {
	
	//The mapState manages all map-related properties of the game.
	private MapState mapState;
	
	//The sceneState manages all scene-related properties of the game
	private SceneState sceneState;
	
	public StateManager() {
		
	}
	
	public void initStates(AssetManager assetManager) {
		mapState = new MapState(assetManager, this);
		sceneState  = new SceneState(assetManager, this);
	}

	public MapState getMapState() {
		return mapState;
	}

	public SceneState getSceneState() {
		return sceneState;
	}	
}
