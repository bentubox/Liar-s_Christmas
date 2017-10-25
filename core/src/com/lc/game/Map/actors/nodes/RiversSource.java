package com.lc.game.Map.actors.nodes;

import java.util.Arrays;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;
import com.lc.game.Map.actors.Node;

public class RiversSource extends Node{
	
	public RiversSource(AssetManager assetManager, AChristmasActor map) {
		super(assetManager, "River's Source", 1420, 745, map);
	}

	@Override
	protected void initNeighbors() {
		String[] nArray = { 
				"The Lift",
				"The Peaks"
			};
		setNeighbors(Arrays.asList(nArray));
	}
}
