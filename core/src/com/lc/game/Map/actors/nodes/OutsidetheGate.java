package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class OutsidetheGate extends Node{
	
	public OutsidetheGate(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "Outside the Gate", 1450, 900, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"Founder's Court",
				"Inside the Gate"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
