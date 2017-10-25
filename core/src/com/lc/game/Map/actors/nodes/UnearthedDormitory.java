package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class UnearthedDormitory extends Node{
	
	public UnearthedDormitory(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "Unearthed Dormitory", 1350, 675, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"Abandoned Mining Village"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
