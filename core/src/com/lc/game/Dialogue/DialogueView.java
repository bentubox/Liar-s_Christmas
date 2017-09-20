package com.lc.game.Dialogue;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AView;
import com.lc.game.LiarGame;
import com.lc.game.Manager.StateManager;
import com.lc.game.Title.TitleView;

public class DialogueView extends AView{

	public DialogueView(AssetManager assetManager, StateManager stateManager) {
		super(assetManager, stateManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setType() {
		VIEW_TYPE = "DIALOGUE";
	}
	
	@Override
	public boolean keyDown(int keyCode) {
        boolean isHandled = false;

        if (keyCode == Input.Keys.ESCAPE) {
            LiarGame.getViewManager().createView(TitleView.class, assetManager, stateManager);
        }

        return isHandled;
    }
}
