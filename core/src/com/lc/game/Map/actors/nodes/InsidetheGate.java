package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class InsidetheGate extends Node{
	
	public InsidetheGate(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "Inside the Gate", 1420, 875, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"Outside the Gate"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
