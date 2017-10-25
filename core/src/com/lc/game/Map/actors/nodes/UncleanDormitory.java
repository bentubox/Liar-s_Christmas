package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class UncleanDormitory extends Node{

	public UncleanDormitory(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "Unclean Dormitory", 1430, 1050, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Sewer",
				"The Heap",
				"Reclamation Plant"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
