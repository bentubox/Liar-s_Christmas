package com.lc.game.Map;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.lc.game.Manager.StateManager;
import com.lc.game.Map.actors.Edge;
import com.lc.game.Map.actors.MapBackdrop;
import com.lc.game.Map.actors.Node;

/**
 * 
 * @author Zachary Tu
 * Manager for managing node and edges in the map
 */
public class MapState {
	
//	private AssetManager assetManager;
//	private StateManager stateManager;
	
	private HashMap<String, Node> nodeMap;
	private HashMap<String, Edge> edgeMap;
	
	private String currentNode;

	public MapState(AssetManager assetManager, StateManager stateManager) {
//		this.assetManager = assetManager;
//		this.stateManager = stateManager;
		MapBackdrop map = new MapBackdrop(assetManager);
		
		//Add nodes and edges.
		nodeMap = new HashMap<String, Node>();
		edgeMap = new HashMap<String, Edge>();

		JsonReader json = new JsonReader();
		JsonValue base = json.parse(Gdx.files.internal("MapInfo.json"));
		
		for (JsonValue node : base) {
			final Map<String, Integer> neighbors = new HashMap<String, Integer>();
			
			for (JsonValue neighbor : node.get("Connections")) {
				neighbors.put(neighbor.getString("Neighbor"), neighbor.getInt("Distance"));
			}
			addNode(new Node(assetManager, node.getString("Name"), node.getString("Area"), node.getInt("XCoord"), 
					node.getInt("YCoord"), map) {
				
				{
					addListener( new InputListener() {
						@Override
						public void enter (InputEvent event, float x, float y, int pointer, Actor fromActor) {
							super.enter(event, y, y, pointer, fromActor);
							if(pointer == -1) {
								setShowName(true);
								for(Edge e : getConnections()) {
									e.setDrawEdge(true);
								}
							}
						}

						@Override
						public void exit (InputEvent event, float x, float y, int pointer, Actor toActor) {
							super.exit(event, x, y, pointer, toActor);
							if(pointer == -1) {
								setShowName(false);
								for(Edge e : getConnections()) {
									e.setDrawEdge(false);
								}
							}
						}
					});

					//This makes the node blink if it currently occupied by the player.
					this.addAction(Actions.forever(Actions.sequence(
							Actions.run(new Runnable() {
								@Override
								public void run() {
									Actions.delay(5f);
								}
							}),
							Actions.delay(.3f),
							Actions.run(new Runnable() {
								@Override
								public void run() {
									if (isVisible() && getName().equals(currentNode)) {
										setVisible(false);
									} else if (!isVisible()) {
										setVisible(true);
									}
								}
							})
					)));
				}
				
				@Override
				protected void initNeighbors() {
					setNeighbors(neighbors);
				}
				
				@Override
				public void draw(Batch batch, float alpha) {
					
					if (isDiscovered()) {
						super.draw(batch, alpha);
					}
				}
			});
		}

		moveTo("Sodden Lot");
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
	
	public void moveTo(String nodeName) {
		Node newNode = nodeMap.get(nodeName);
		
		if (newNode != null) {
			newNode.setDiscovered(true);
			newNode.setExplored(true);
			
			currentNode = nodeName;
			
			for(String n : newNode.getNeighbors().keySet()) {
				Node neighbor = nodeMap.get(n);
				if (neighbor != null) {
					if (!neighbor.isDiscovered()) {
						neighbor.setDiscovered(true);
					}
				}
			}
		}
	}

	public HashMap<String, Node> getNodeMap() {
		return nodeMap;
	}

	public void setNodeMap(HashMap<String, Node> nodeMap) {
		this.nodeMap = nodeMap;
	}

	public HashMap<String, Edge> getEdgeMap() {
		return edgeMap;
	}

	public void setEdgeMap(HashMap<String, Edge> edgeMap) {
		this.edgeMap = edgeMap;
	}

	public String getCurrentNode() {
		return currentNode;
	}

	public void setCurrentNode(String currentNode) {
		this.currentNode = currentNode;
	}
}