package com.lc.game.Inventory;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.lc.game.AView;
import com.lc.game.Manager.StateManager;

public class InventoryView extends AView{

	public InventoryView(AssetManager assetManager, StateManager stateManager, Viewport viewport, Batch batch) {
		super(assetManager, stateManager, viewport, batch);
		
	}

	@Override
	public void init() {
		
		
	}

	@Override
	protected void setType() {
		VIEW_TYPE = "INVENTORY";
		
	}

}
