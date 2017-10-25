package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class TheFountain extends Node{

	public TheFountain(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Fountain", 1600, 1125, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"Sunken Dormitory",
				"The Mangroves",
				"The Trough"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
