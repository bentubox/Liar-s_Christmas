package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class TheOverlook extends Node{
	
	public TheOverlook(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Overlook", 1565, 965, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Mangroves",
				"Founder's Court"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
