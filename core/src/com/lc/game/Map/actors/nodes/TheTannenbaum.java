package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class TheTannenbaum extends Node{
	
	public TheTannenbaum(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Tannenbaum", 1220, 500, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"Overgrown Dormitory",
				"The Sepulchre"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
