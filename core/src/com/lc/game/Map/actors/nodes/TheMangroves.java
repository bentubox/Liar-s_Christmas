package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class TheMangroves extends Node{
	
	public TheMangroves(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Mangroves", 1625, 1050, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Fountain"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
