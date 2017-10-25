package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class TheStomach extends Node{

	public TheStomach(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Stomach", 1200, 1085, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Vault",
				"The Spleen",
				"The Liver"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
