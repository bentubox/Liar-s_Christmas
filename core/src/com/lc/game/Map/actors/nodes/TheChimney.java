package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class TheChimney extends Node{

	public TheChimney(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Chimney", 910, 955, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Refinery"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
