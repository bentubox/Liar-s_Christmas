package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class TheSepulchre extends Node{
	
	public TheSepulchre(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Sepulchre", 1320, 550, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Tannenbaum"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
