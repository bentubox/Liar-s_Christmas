package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class AbandonedMiningVillage extends Node{
	
	public AbandonedMiningVillage(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "Abandoned Mining Village", 1400, 600, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Peaks",
				"Unearthed Dormitory"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
