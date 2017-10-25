package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class BefouledDormitory extends Node{

	public BefouledDormitory(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "Befouled Dormitory", 1500, 1200, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Sluice"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
