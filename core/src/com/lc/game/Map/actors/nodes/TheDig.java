package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class TheDig extends Node{
	
	public TheDig(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Dig", 1310, 600, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"Unearthed Dormitory",
				"Abandoned Mining Village",
				"The Sepulchre"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
