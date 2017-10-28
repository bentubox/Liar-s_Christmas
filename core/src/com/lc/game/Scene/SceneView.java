package com.lc.game.Scene;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.lc.game.AChristmasActor;
import com.lc.game.AView;
import com.lc.game.LiarGame;
import com.lc.game.GlobalActors.Text;
import com.lc.game.Manager.StateManager;
import com.lc.game.Map.MapView;
import com.lc.game.Title.TitleView;

public class SceneView extends AView{

	//Temporary links to other modules for testing.
	private AChristmasActor mapOption, titleOption;
	
	public SceneView(AssetManager assetManager, StateManager stateManager, Viewport viewport, Batch batch) {
		super(assetManager, stateManager, viewport, batch);
		
		String currentNode = stateManager.getMapState().getCurrentNode();
		
		Scene currentScene = stateManager.getSceneState().getScenes().get(currentNode);
		if (currentScene != null) {
			addActor(currentScene);
		}
		
		mapOption = new Text(assetManager, "MAP", 150, 180);
		titleOption = new Text(assetManager, "TITLE", 150, 220);

		mapOption.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	            LiarGame.getViewManager().createView(MapView.class, getAssetManager(), getStateManager());
	        }
	    });
		mapOption.setScale(0.5f);
		
		titleOption.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	            LiarGame.getViewManager().createView(TitleView.class, getAssetManager(), getStateManager());
	        }
	    });
		titleOption.setScale(0.5f);
		
		addActor(mapOption);
		addActor(titleOption);
		
	}

	@Override
	public void init() {
		
	}

	@Override
	protected void setType() {
		VIEW_TYPE = "SCENE";
	}
	
	@Override
	public boolean keyDown(int keyCode) {
        boolean isHandled = false;

        if (keyCode == Input.Keys.ESCAPE) {
        	//Reset zoom.
        	LiarGame.resetCamera();
            LiarGame.getViewManager().createView(TitleView.class, assetManager, stateManager);
            isHandled = true;
        }

        return isHandled;
    }

}
