package com.lc.game.Map;

import java.util.HashMap;

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
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.lc.game.AView;
import com.lc.game.AssetList;
import com.lc.game.LiarGame;
import com.lc.game.Manager.StateManager;
import com.lc.game.Map.actors.Edge;
import com.lc.game.Map.actors.MapBackdrop;
import com.lc.game.Map.actors.Node;
import com.lc.game.Scene.SceneView;
import com.lc.game.Title.TitleView;

public class MapView extends AView {

	private MapBackdrop map;
	private HashMap<String, Node> nodeMap;
	private HashMap<String, Edge> edgeMap;
	
	private Skin skin;
	
	private Table nodeOptionMenu;
	
	private static float MIN_ZOOM = 1.6f;
	private static float MAX_ZOOM = 0.5f;
	
	public MapView(AssetManager assetManager, StateManager stateManager, Viewport viewport, Batch batch) {
		super(assetManager, stateManager, viewport, batch);
		setMap(new MapBackdrop(assetManager));
		addActor(getMap());
		
		//font things eventually. also, we will eventually load the skin in the state instead of the view.
		/*FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/butler.fnt"));
		FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();

		params.size = 24;
		params.color = Color.BLACK;*/
		BitmapFont font24 = new BitmapFont();
	       
		this.skin = new Skin();
		this.skin.addRegions((TextureAtlas) getAssetManager().get(AssetList.UISKINATL.toString()));
		this.skin.add("default-font", font24);
		this.skin.load(Gdx.files.internal("ui/uiskin.json"));
		
		//Add nodes and edges.
		nodeMap = new HashMap<String, Node>();
		edgeMap = new HashMap<String, Edge>();
	}

	@Override
	public void init() {
		// TODO: Initialize map nodes according to visited/discovered status and map zoom level.
		
		for (Node n : stateManager.getMapState().getNodeMap().values()) {
			final Node node = n;

			if (n.isDiscovered()) {
				n.addListener( new InputListener() {
					
					@Override
					public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
						
						nodeClicked(node);
						return super.touchDown(event, x, y, pointer, button);
					}
				});
				nodeMap.put(n.getName(), n);
			}
			if (n.getName().equals(stateManager.getMapState().getCurrentNode())) {
				LiarGame.moveCamera(n.getCenterX(), n.getCenterY());
			}
		}
		for (Edge e : stateManager.getMapState().getEdgeMap().values()) {
			if (nodeMap.values().contains(e.getE0()) && nodeMap.values().contains(e.getE1())) {
				edgeMap.put(e.getId(), e);
			}
		}
		
		for(Edge e : edgeMap.values()) {
			addActor(e);
		}
		for(Node n : nodeMap.values()) {
			addActor(n);
		}
	}

	@Override
	protected void setType() {
		VIEW_TYPE = "MAP";
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
	
	@Override
	public boolean scrolled(int amount) {
		if(amount > 0 && LiarGame.getCurrentZoom() + 0.1f < MIN_ZOOM) {
			LiarGame.zoomCamera(0.1f);
			return true;
		} else if (amount < 0 && LiarGame.getCurrentZoom() - 0.1f > MAX_ZOOM) {
			LiarGame.zoomCamera(-0.1f);
			return true;
		}
		return false;
	}

	public void addNode(Node newNode) {
		for(String n : newNode.getNeighbors().keySet()) {
			Node neighbor = nodeMap.get(n);
			if(neighbor != null) {
				Edge newEdge = new Edge(neighbor.getAssetManager(), newNode, neighbor);
				newNode.getConnections().add(newEdge);
				neighbor.getConnections().add(newEdge);
				edgeMap.put(newEdge.getId(), newEdge);
			}
		}
		nodeMap.put(newNode.getName(), newNode);
	}
		
	public void nodeClicked(Node n) {
		
		if (nodeOptionMenu != null) {
			nodeOptionMenu.remove();
		}
		
		nodeOptionMenu = new Table();
		
		Label name = new Label("Node: " + n.getName(), skin);

		TextButton info = new TextButton("Information", skin);
	    info.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				
			}
	    });
	    
	    nodeOptionMenu.add(name);
	    nodeOptionMenu.row();
	    nodeOptionMenu.add(info);
	    nodeOptionMenu.row();
	    
	    boolean adjacent = false;
	    int distance = 0;
	    
	    for (String s : n.getNeighbors().keySet()) {
	    	 if (stateManager.getMapState().getCurrentNode().equals(s)) {
	 	    	adjacent = true;
	 	    	distance = n.getNeighbors().get(s);
	 	    }
	    }
	    if (adjacent) {
	    	final Node node = n; 
	    	
	    	TextButton move = new TextButton("Move: (" + distance + ")", skin);
	    		    	
		    move.addListener(new ClickListener() {
		    	
		    	@Override
				public void clicked(InputEvent event, float x, float y) {
					stateManager.getMapState().moveTo(node.getName());
			        LiarGame.getViewManager().createView(SceneView.class, assetManager, stateManager);
				}
		    	
		    });
		    
		    nodeOptionMenu.add(move);

	    }
	    nodeOptionMenu.setPosition(0, 1000);
	    nodeOptionMenu.addAction(Actions.moveTo(n.getX(), n.getCenterY() + 100,.5f,Interpolation.pow5Out));
	    
		addActor(nodeOptionMenu);
	}
	
	public MapBackdrop getMap() {
		return map;
	}

	public void setMap(MapBackdrop map) {
		this.map = map;
	}
}
