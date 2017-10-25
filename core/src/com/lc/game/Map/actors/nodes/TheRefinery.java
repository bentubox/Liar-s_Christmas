package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class TheRefinery extends Node{

	public TheRefinery(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Refinery", 1000, 925, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Furnace",
				"The Chimney"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
