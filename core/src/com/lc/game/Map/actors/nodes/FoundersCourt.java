package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class FoundersCourt extends Node{
	
	public FoundersCourt(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "Founder's Court", 1500, 920, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Overlook",
				"Outside the Gate"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
