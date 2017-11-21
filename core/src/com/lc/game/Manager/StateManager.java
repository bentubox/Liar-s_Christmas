package com.lc.game.Manager;


import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.Map.MapState;
import com.lc.game.Scene.SceneState;

public class StateManager {
	
	//The map manager manages all map-related properties of the game. (Nodes and node properties)
	private MapManager mapManager;
	
	//The scene manager manages all scene-related properties of the game. (What events does each scene hold?)
	private SceneManager sceneManager;
	
	//The time manager manages time. (Adventures left + days. This also processes time-change effects of everything.)
	private TimeManager timeManager;
	
	//The Schmuck manager manages schmucks. (statuses + properties of the schmucks)
	//does not exist yet
	
	//The notif manager manages notifications. a "notification" is just any window that pops up at any time for any purpose.
	private NotificationManager notificationManager;
	
	//The item manager manages items. atm this only includes the player inventory but will eventually account for global items.
	private ItemManager itemManager;
	
	private Skin skin;
	
	public StateManager() {
		
		BitmapFont font24 = new BitmapFont();
		this.skin = new Skin();
		this.skin.addRegions((TextureAtlas) assetManager.get(AssetList.UISKINATL.toString()));
		this.skin.add("default-font", font24);
		this.skin.load(Gdx.files.internal("ui/uiskin.json"));
		
		notificationManager = new NotificationManager(assetManager, this);
		sceneManager  = new SceneManager(assetManager, this);
		mapManager = new MapManager(assetManager, this);
		timeManager  = new TimeManager(assetManager, this);
		itemManager = new ItemManager(assetManager, this);
		
		mapManager.moveTo("Sodden Lot");
	}
	
	public void initStates(AssetManager assetManager) {
		mapState = new MapState(assetManager, this);
		sceneState  = new SceneState(assetManager, this);
	}

	public MapState getMapState() {
		return mapState;
	}
	
	public ItemManager getItemManager() {
		return itemManager;
	}

	public SceneState getSceneState() {
		return sceneState;
	}	
}
