package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class TheVault extends Node{

	public TheVault(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "The Vault", 1300, 1075, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Heap",
				"Reclamation Plant"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
