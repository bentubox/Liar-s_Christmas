package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class ReclamationPlant extends Node{

	public ReclamationPlant(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "Reclamation Plant", 1340, 1000, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"Unclean Dormitory",
				"The Vault"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
