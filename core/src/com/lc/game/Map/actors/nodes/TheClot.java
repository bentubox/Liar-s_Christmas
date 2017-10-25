package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class TheClot extends Node{

	public TheClot(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Clot", 1450, 1250, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"Befouled Dormitory"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
