package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class TheLift extends Node{
	
	public TheLift(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Lift", 1525, 800, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Cliff"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
