package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class UnusedRooms extends Node{

	public UnusedRooms(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "Unused Rooms", 1365, 1185, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Heap"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
