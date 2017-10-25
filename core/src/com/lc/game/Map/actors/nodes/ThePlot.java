package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class ThePlot extends Node{
	
	public ThePlot(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Plot", 1120, 500, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"Overgrown Dormitory"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
