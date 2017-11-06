package com.lc.game.Map;

import java.util.HashMap;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Batch;
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
import com.lc.game.LiarGame;
import com.lc.game.Manager.StateManager;
import com.lc.game.Map.actors.Edge;
import com.lc.game.Map.actors.MapBackdrop;
import com.lc.game.Map.actors.Node;
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
	       
		this.skin = stateManager.getSkin();
		
		//Add nodes and edges.
		nodeMap = new HashMap<String, Node>();
		edgeMap = new HashMap<String, Edge>();
	}

	@Override
	public void init() {
		
		//We make a mini-map from the map created in mapState based on what the player has seen.
		for (Node n : stateManager.getMapManager().getNodeMap().values()) {
			final Node node = n;

			if (n.isDiscovered()) {
				
				//Give each node the added functionality of registering mouse clicks.
				n.addListener( new InputListener() {
					
					@Override
					public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
						
						nodeClicked(node);
						return super.touchDown(event, x, y, pointer, button);
					}
				});
				nodeMap.put(n.getName(), n);
			}
			
			//Move camera to zoom in on current node.
			if (n.getName().equals(stateManager.getMapManager().getCurrentNode())) {
				LiarGame.moveCamera(n.getCenterX(), n.getCenterY());
			}
		}
		
		//Likewise, discovered edges are copied afresh from mapstate every time the mapview is pulled up.
		for (Edge e : stateManager.getMapManager().getEdgeMap().values()) {
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

	/**
	 * This addNode works identically to the one in mapState. Could probably code this more efficiently.
	 * @param newNode: The node being added to nodeMap.
	 */
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
	
	/**
	 * This is run when a node is clicked. Generate a list of options the player has for interacting with the node and display.
	 * ATm, the player can only read info or move.
	 * @param n: The node that the player just clicked
	 */
	public void nodeClicked(Node n) {
		
		//The info for only one node is visible at a time.
		if (nodeOptionMenu != null) {
			nodeOptionMenu.remove();
		}
		
		nodeOptionMenu = new Table();
		
		Label name = new Label("Node: " + n.getName() + ". " + stateManager.getTimeManager().getTimeLeft() + "  turns left.",
				skin);

		//Display info about the node. Currently does nothing, but will eventually display the Description property of the node.
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
	    
	    //Detect whether the node clicked is one movement away from the player. If so, provide the move option and give the distance.
	    boolean adjacent = false;
	    int distance = 0;
	    
	    for (String s : n.getNeighbors().keySet()) {
	    	 if (stateManager.getMapManager().getCurrentNode().equals(s)) {
	 	    	adjacent = true;
	 	    	distance = n.getNeighbors().get(s);
	 	    }
	    }
	    
	    if (adjacent) {
	    	final Node node = n;
	    	final int dist = distance;
	    	
	    	TextButton move = new TextButton("Move: (" + distance + ")", skin);
	    	
	    	//Clicking move moves the player to the node and opens up the new node's sceneview.
		    move.addListener(new ClickListener() {
		    	
		    	@Override
				public void clicked(InputEvent event, float x, float y) {
		    		stateManager.getTimeManager().timeIncrement(-dist);
					stateManager.getMapManager().moveTo(node.getName());
				}
		    	
		    });
		    
		    nodeOptionMenu.add(move);
		    nodeOptionMenu.row();
	    }
	    
	    //The cancel button simply makes the option menu go away
    	TextButton cancel = new TextButton("Cancel", skin);
	    cancel.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				nodeOptionMenu.addAction(Actions.moveTo(0, 1000, .5f, Interpolation.pow5Out));
			}
	    });
	    nodeOptionMenu.add(cancel);
	    nodeOptionMenu.row();
	    
	    //Make the options appear off screen and move in.
	    nodeOptionMenu.setPosition(0, 1000);
	    nodeOptionMenu.addAction(Actions.moveTo(n.getX(), n.getCenterY() + 100, .5f, Interpolation.pow5Out));
	    
		addActor(nodeOptionMenu);
	}
	
	public MapBackdrop getMap() {
		return map;
	}

	public void setMap(MapBackdrop map) {
		this.map = map;
	}
}
