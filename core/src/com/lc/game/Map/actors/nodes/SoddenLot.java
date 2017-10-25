package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class SoddenLot extends Node{

	public SoddenLot(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "Sodden Lot", 1720, 1100, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"Sunken Dormitory"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
