package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class OvergrownDormitory extends Node{
	
	public OvergrownDormitory(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "Overgrown Dormitory", 1160, 525, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Tannenbaum",
				"The Plot"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
