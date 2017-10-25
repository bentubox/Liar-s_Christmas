package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class ThePeaks extends Node{
	
	public ThePeaks(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Peaks", 1450, 675, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"River's Source",
				"The Lift"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
