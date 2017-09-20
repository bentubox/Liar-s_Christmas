package com.lc.game.Title;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.lc.game.AChristmasActor;
import com.lc.game.AView;
import com.lc.game.LiarGame;
import com.lc.game.Dialogue.DialogueView;
import com.lc.game.GlobalActors.Text;
import com.lc.game.Manager.StateManager;
import com.lc.game.Map.MapView;
import com.lc.game.Title.actors.TitleBackdrop;

/**
 * Game startup view.
 */
public class TitleView extends AView{
	
	//Temporary links to other modules for testing.
	private AChristmasActor mapOption, dialogueOption;
	
	public TitleView(AssetManager assetManager, StateManager stateManager) {
		super(assetManager, stateManager);
		addActor(new TitleBackdrop(assetManager));
		addActor(new Text(assetManager, "Liar's Christmas", 100, LiarGame.CONFIG_HEIGHT - 100, true));
		mapOption = new Text(assetManager, "MAP", 150, LiarGame.CONFIG_HEIGHT - 180);
		dialogueOption = new Text(assetManager, "DIALOGUE", 150, LiarGame.CONFIG_HEIGHT - 220);
		
		mapOption.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	            LiarGame.getViewManager().createView(MapView.class, getAssetManager(), getStateManager());
	        }
	    });
		mapOption.setScale(0.5f);
		
		dialogueOption.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	            LiarGame.getViewManager().createView(DialogueView.class, getAssetManager(), getStateManager());
	        }
	    });
		dialogueOption.setScale(0.5f);
		
		addActor(mapOption);
		addActor(dialogueOption);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setType() {
		VIEW_TYPE = "TITLE";		
	}
	
	@Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }
}
