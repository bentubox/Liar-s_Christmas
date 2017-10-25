package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class TheSpleen extends Node{

	public TheSpleen(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Spleen", 1175, 1140, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Liver",
				"The Stomach",
				"The Brain"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
