package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class SunkenDormitory extends Node{
	
	public SunkenDormitory(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "Sunken Dormitory", 1650, 1125, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Glade",
				"The Fountain",
				"Sodden Lot"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
