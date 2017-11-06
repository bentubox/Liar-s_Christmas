package com.lc.game.Scene.scenes;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AssetList;
import com.lc.game.Event.AEvent;
import com.lc.game.Event.events.SinkingCar;
import com.lc.game.Event.events.StandardComposite;
import com.lc.game.Event.events.StandardFlavorMove;
import com.lc.game.Event.events.StandardWarp;
import com.lc.game.GlobalActors.Player.APlayer;
import com.lc.game.Manager.StateManager;
import com.lc.game.Scene.Scene;

public class SoddenLot extends Scene {
	
	final static String backdrop = AssetList.SCENESODDENLOT.toString();
	
	public SoddenLot(AssetManager assetManager) {
		super(assetManager, backdrop);
	}
	
	@Override
	public void init() {
		addEvent(new AEvent[]{
				new SinkingCar(assetManager),
				new StandardComposite(assetManager, 0, 0, "Intro Sequence", new AEvent[] {
						new StandardFlavorMove(assetManager, 0, 0, "", "This is where the introduction cutscene would be if we had made it yet"),
						new StandardFlavorMove(assetManager, 0, 0, "", "Testing multi stage composite notifications"),
						new StandardFlavorMove(assetManager, 0, 0, "", "Ay carambas")
				}) {
					public void onMove(String start, String end, APlayer schmuck, final StateManager stateManager) {
						super.onMove(start, end, schmuck, stateManager);
						stateManager.getSceneManager().getScene("Sodden Lot").getEvents().remove(this);
					}
				},
				new StandardWarp(assetManager, 900, 300, "A muddy path", "TEMP", "Sunken Dormitory")
		});
	}
}
