package com.lc.game.Map;

import java.util.ArrayList;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
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
	private ArrayList<Node> nodeArray;
	private ArrayList<Edge> edgeArray;
	
	public MapView(AssetManager assetManager, StateManager stateManager) {
		super(assetManager, stateManager);
		map = new MapBackdrop(assetManager);
		addActor(map);
		
		//Add nodes.
		nodeArray = new ArrayList<Node>();
		nodeArray.add(new SunkenDormitory(assetManager, map));
		nodeArray.add(new TheGlade(assetManager, map));
		
		//Add edges.
		edgeArray = new ArrayList<Edge>();
		edgeArray.add(new Edge(assetManager, nodeArray.get(0), nodeArray.get(1)));
		
		for(Edge e : edgeArray) {
			addActor(e);
		}
		for(Node n : nodeArray) {
			addActor(n);
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setType() {
		VIEW_TYPE = "MAP";
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
