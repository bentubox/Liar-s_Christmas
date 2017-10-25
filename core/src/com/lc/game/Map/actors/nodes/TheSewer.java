package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class TheSewer extends Node{

	public TheSewer(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Sewer", 1500, 1060, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Trough",
				"Unclean Dormitory"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
