package com.lc.game.Scene.scenes;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AssetList;
import com.lc.game.Event.AEvent;
import com.lc.game.Event.events.IntroSequence;
import com.lc.game.Event.events.SinkingCar;
import com.lc.game.Event.events.WarpSoddenLotSunkenDorm;
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
				new IntroSequence(assetManager),
				new WarpSoddenLotSunkenDorm(assetManager)
		});
	}
}