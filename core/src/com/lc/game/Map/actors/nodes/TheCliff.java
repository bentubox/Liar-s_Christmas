package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class TheCliff extends Node{
	
	public TheCliff(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Cliff", 1565, 865, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Overlook",
				"The Lift"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
