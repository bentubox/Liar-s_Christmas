package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class ThePowerGrid extends Node{

	public ThePowerGrid(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Power Grid", 1200, 1000, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Canal",
				"The Generator"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
