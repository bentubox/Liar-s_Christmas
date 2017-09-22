package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class TheGlade extends Node{

	public TheGlade(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Glade", 1650, 1030, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"Sunken Dormitory"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
