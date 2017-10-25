package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class TheFurnace extends Node{

	public TheFurnace(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Furnace", 1010, 875, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"Immolated Dormitory"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
