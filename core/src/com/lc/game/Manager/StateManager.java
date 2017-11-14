package com.lc.game.Manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.lc.game.AssetList;
import com.lc.game.GlobalActors.Player.APlayer;

/**
 * The StateManager manages all game related whatever.
 * ATM it holds a bunch of different managers that separate stored information. This isn't really necessary and we can combine them
 * later if we feel like it.
 * @author Zachary Tu
 *
 */
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

	}
	
	public void initStates(AssetManager assetManager) {
		
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
	
	public Skin getSkin() {
		return skin;
	}

	public MapManager getMapManager() {
		return mapManager;
	}

	public SceneManager getSceneManager() {
		return sceneManager;
	}
	
	public TimeManager getTimeManager() {
		return timeManager;
	}
	
	public NotificationManager getNotificationManager() {
		return notificationManager;
	}
	
	public ItemManager getItemManager() {
		return itemManager;
	}

	public APlayer getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}
}
