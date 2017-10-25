package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class TheHeap extends Node{

	public TheHeap(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Heap", 1365, 1100, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"Unclean Dormitory",
				"Unused Rooms",
				"The Vault"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
