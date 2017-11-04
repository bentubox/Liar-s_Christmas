package com.lc.game.Manager;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.Event.AEvent;
import com.lc.game.GlobalActors.Player.APlayer;
import com.lc.game.Scene.Scene;
import com.lc.game.Scene.scenes.*;

/**
 * The SceneState manages all global scene-related properties.
 * At the start of a game, it initializes the scenes of every node in the map, creating all starting events.
 * @author Zachary Tu
 *
 */
public class SceneManager {

	public StateManager stateManager;
	
	//This maps to each node name the scene that appears there.
	private HashMap<String, Scene> scenes;
	
	public SceneManager(AssetManager assetManager, StateManager stateManager) {
		this.stateManager = stateManager;
		
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
	
	public void eventTimePass(int elapse) {
		
		for (Scene scene : scenes.values()) {
			
			final ArrayList<AEvent> events = new ArrayList<AEvent>();
			for (AEvent event: scene.getEvents()) {
				events.add(event);
			}
			
			for (AEvent event : events) {
				event.onTimePass(stateManager, elapse);
			}
		}
	}
	
	public void eventOnMove(String start, String end, APlayer schmuck) {
		for (Scene scene : scenes.values()) {
			
			final ArrayList<AEvent> events = new ArrayList<AEvent>();
			for (AEvent event: scene.getEvents()) {
				events.add(event);
			}
			
			for (AEvent event : events) {
				event.onMove(start, end, schmuck, stateManager);
			}
		}
	}
}
