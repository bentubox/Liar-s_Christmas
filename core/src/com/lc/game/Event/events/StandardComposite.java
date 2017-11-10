package com.lc.game.Event.events;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.lc.game.AssetList;
import com.lc.game.Event.AEvent;
import com.lc.game.GlobalActors.Player.APlayer;
import com.lc.game.Manager.StateManager;

public class StandardComposite extends AEvent{

	private final static String image = AssetList.EVENTPLACEHOLDER.toString();
	AEvent[] events;
	
	public StandardComposite(AssetManager assetManager, int x, int y, String name, AEvent... events) {
		super(assetManager, name, x, y, (Texture) assetManager.get(image));
		this.events = events;
	}

	@Override
	public void onClick(final StateManager stateManager) {
		for (AEvent event : events) {
			event.onClick(stateManager);
		}
	}
	
	@Override
	public void onTimePass(StateManager stateManager, int elapse) {
		for (AEvent event : events) {
			event.onTimePass(stateManager, elapse);
		}
	}

	@Override
	public void onMove(String start, String end, APlayer schmuck, StateManager stateManager) {
		for (AEvent event : events) {
			event.onMove(start, end, schmuck, stateManager);
		}
	}
	
}
