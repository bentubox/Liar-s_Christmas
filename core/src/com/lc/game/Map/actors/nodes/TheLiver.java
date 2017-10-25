package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class TheLiver extends Node{

	public TheLiver(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Liver", 1245, 1185, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Stomach",
				"The Spleen"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
