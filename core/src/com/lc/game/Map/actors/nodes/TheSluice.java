package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class TheSluice extends Node{

	public TheSluice(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Sluice", 1550, 1175, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Trough"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
