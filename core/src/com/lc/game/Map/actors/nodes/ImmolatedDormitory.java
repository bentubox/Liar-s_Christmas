package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class ImmolatedDormitory extends Node{

	public ImmolatedDormitory(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "Immolated Dormitory", 1110, 900, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Generator",
				"The Furnace"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
