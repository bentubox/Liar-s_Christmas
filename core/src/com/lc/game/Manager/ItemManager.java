package com.lc.game.Manager;

import java.util.HashMap;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.Inventory.Item;

public class ItemManager {

	private HashMap<Item, Integer> playerBag;
	
	public ItemManager(AssetManager assetManager, StateManager stateManager) {
		this.playerBag = new HashMap<Item, Integer>();
	}
	
	public void changeItemNum(Item i, int change) {
		
		int count = 0;
		
		if (playerBag.get(i) != null) {
			count = playerBag.get(i);
		}
		
		count += change;
		
		if (count <= 0) {
			playerBag.remove(i);
		} else {
			playerBag.put(i, count);
		}
	}
	
	public int getCount(Item i) {
		int count = 0;
		
		if (playerBag.get(i) != null) {
			count = playerBag.get(i);
		}
		
		return count;
	}
}
