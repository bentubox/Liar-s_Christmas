package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class TheGenerator extends Node{

	public TheGenerator(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Generator", 1185, 915, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Canal",
				"The Power Grid",
				"The Reservoir"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
