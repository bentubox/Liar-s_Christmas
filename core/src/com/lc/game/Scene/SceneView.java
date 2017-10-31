package com.lc.game.Scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.lc.game.AChristmasActor;
import com.lc.game.AView;
import com.lc.game.AssetList;
import com.lc.game.LiarGame;
import com.lc.game.Event.AEvent;
import com.lc.game.GlobalActors.Text;
import com.lc.game.Manager.StateManager;
import com.lc.game.Map.MapView;
import com.lc.game.Title.TitleView;

/**
 * The sceneview is created whenever the player looks at the scene of the current node.
 * It pulls information about of the current scene from the sceneState.
 * @author Zachary Tu
 *
 */
public class SceneView extends AView{

	//Temporary links to other modules for testing.
	private AChristmasActor mapOption, titleOption;
	
	private Skin skin;
	
	//This option menu is modified by events and gives the player a custom set of options.
	private Table eventOptionMenu;
	
	public SceneView(AssetManager assetManager, StateManager stateManager, Viewport viewport, Batch batch) {
		super(assetManager, stateManager, viewport, batch);
		
		BitmapFont font24 = new BitmapFont();
	       
		this.skin = new Skin();
		this.skin.addRegions((TextureAtlas) getAssetManager().get(AssetList.UISKINATL.toString()));
		this.skin.add("default-font", font24);
		this.skin.load(Gdx.files.internal("ui/uiskin.json"));
		
		String currentNode = stateManager.getMapState().getCurrentNode();
		
		//Acquire the current scene from the stateManager.
		Scene currentScene = stateManager.getSceneState().getScene(currentNode);
		if (currentScene != null) {
			addActor(currentScene);
			
			//Add all the events that are currently in the scene.
			for (AEvent event : currentScene.getEvents()) {
				
				final AEvent eventFin = event;
				
				//Add the functionality to all events to call functions on this view when clicked.
				event.addListener(new InputListener() {
					
					@Override
					public boolean touchDown(InputEvent e, float x, float y, int pointer, int button) {
						eventClicked(eventFin);
						return true;
					}
				});
				
				addActor(event);
			}
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
	
	/**
	 * When an event is clicked, run its on-click method passing it this view
	 * @param event: The event that was clicked by the player
	 */
	public void eventClicked(AEvent event) {
		event.onClick(this);
	}

	/**
	 * When an event or anything else pops an option menu, it must call this function on the sceneView
	 * @param table: The option menu that will appear.
	 */
	public void produceOptions(Table table) {
		if (eventOptionMenu != null) {
			eventOptionMenu.remove();
		}
		
		eventOptionMenu = table;
		
		if (eventOptionMenu != null) {
			eventOptionMenu.setPosition(0, 1000);
			eventOptionMenu.addAction(Actions.moveTo(500, 500,.5f,Interpolation.pow5Out));
			    
			addActor(eventOptionMenu);
		}
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

	public Skin getSkin() {
		return skin;
	}

	public Table getNodeOptionMenu() {
		return eventOptionMenu;
	}

	public void setNodeOptionMenu(Table eventOptionMenu) {
		this.eventOptionMenu = eventOptionMenu;
	}
	
	

}
