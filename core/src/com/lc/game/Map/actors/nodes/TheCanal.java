package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class TheCanal extends Node{

	public TheCanal(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Canal", 1225, 950, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"Reclamation Plant",
				"The Generator",
				"The Power Grid"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
