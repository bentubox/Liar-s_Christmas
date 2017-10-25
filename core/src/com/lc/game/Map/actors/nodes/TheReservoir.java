package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class TheReservoir extends Node{

	public TheReservoir(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Reservoir", 1240, 865, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Generator"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
