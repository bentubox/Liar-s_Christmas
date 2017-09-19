package com.lc.game.Title;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AView;
import com.lc.game.Manager.StateManager;
import com.lc.game.Title.actors.TitleBackdrop;

/**
 * Game startup view.
 */
public class TitleView extends AView{
	
	public TitleView(AssetManager assetManager, StateManager stateManager) {
		super(assetManager, stateManager);
		addActor(new TitleBackdrop(assetManager));
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setType() {
		VIEW_TYPE = "TITLE";		
	}
}
