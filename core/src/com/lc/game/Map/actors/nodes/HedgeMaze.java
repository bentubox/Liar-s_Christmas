package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class HedgeMaze extends Node{
	
	public HedgeMaze(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "Hedge Maze", 1170, 450, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Plot"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
