package com.lc.game.Manager;


/**
 * Stores game state information.
 */
import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.Map.MapState;
import com.lc.game.Scene.SceneState;

public class StateManager {
	
	private MapState mapState;
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

	private int turnNumber;

	public int getTurnNumber() {
		return turnNumber;
	}

	public void setTurnNumber(int turnNumber) {
		this.turnNumber = turnNumber;
	}
	public SceneState getSceneState() {
		return sceneState;
	}	
}
