package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class TheTrough extends Node{

	public TheTrough(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Trough", 1500, 1125, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Fountain",
				"The Sluice",
				"The Sewer"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
