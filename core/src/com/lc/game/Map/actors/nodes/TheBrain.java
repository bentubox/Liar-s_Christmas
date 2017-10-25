package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class TheBrain extends Node{

	public TheBrain(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Brain", 1100, 1115, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Spleen"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
