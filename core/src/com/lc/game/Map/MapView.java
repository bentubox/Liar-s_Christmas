package com.lc.game.Map;

import java.util.HashMap;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.lc.game.AView;
import com.lc.game.LiarGame;
import com.lc.game.Manager.StateManager;
import com.lc.game.Map.actors.Edge;
import com.lc.game.Map.actors.MapBackdrop;
import com.lc.game.Map.actors.Node;
import com.lc.game.Map.actors.nodes.SunkenDormitory;
import com.lc.game.Map.actors.nodes.TheGlade;
import com.lc.game.Title.TitleView;

public class MapView extends AView{

	private MapBackdrop map;
	private HashMap<String, Node> nodeMap;
	private HashMap<String, Edge> edgeMap;
	
	private static float MIN_ZOOM = 1.6f;
	private static float MAX_ZOOM = 0.5f;
	
	public MapView(AssetManager assetManager, StateManager stateManager, Viewport viewport, Batch batch) {
		super(assetManager, stateManager, viewport, batch);
		map = new MapBackdrop(assetManager);
		addActor(map);
		
		//Add nodes and edges.
		nodeMap = new HashMap<String, Node>();
		edgeMap = new HashMap<String, Edge>();
		
		addNode(new SunkenDormitory(assetManager, map));		
		addNode(new TheGlade(assetManager, map));

		for(Edge e : edgeMap.values()) {
			addActor(e);
		}
		for(Node n : nodeMap.values()) {
			addActor(n);
		}
	}

	@Override
	public void init() {
		// TODO: Initialize map nodes according to visited/discovered status and map zoom level.
		
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
	
	private void addNode(Node newNode) {
		for(String n : newNode.getNeighbors()) {
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
}
