package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class CentralCourt extends Node{
	
	public CentralCourt(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "Central Court", 1330, 845, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"Inside the Gate"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
