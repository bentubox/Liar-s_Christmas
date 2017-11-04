package com.lc.game.Manager;

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
import com.lc.game.Map.actors.Edge;
import com.lc.game.Map.actors.MapBackdrop;
import com.lc.game.Map.actors.Node;

/**
 * 
 * @author Zachary Tu
 * Manager for managing node and edges in the map
 */
public class MapManager {
	
//	private AssetManager assetManager;
	private StateManager stateManager;
	
	//These two maps contain information about all nodes/edges in the game. They are initialized on game start.
	private HashMap<String, Node> nodeMap;
	private HashMap<String, Edge> edgeMap;
	
	//This is the string name of the node that the player is currently in.
	private String currentNode, safeNode;

	public MapManager(AssetManager assetManager, StateManager stateManager) {
//		this.assetManager = assetManager;
		this.stateManager = stateManager;
		MapBackdrop map = new MapBackdrop(assetManager);
		
		//Add nodes and edges.
		nodeMap = new HashMap<String, Node>();
		edgeMap = new HashMap<String, Edge>();

		//Read node and connection info from json file.
		JsonReader json = new JsonReader();
		JsonValue base = json.parse(Gdx.files.internal("MapInfo.json"));
		
		for (JsonValue node : base) {
			
			//Create node from info drawn from json file. First, compile neighbor data.
			final Map<String, Integer> neighbors = new HashMap<String, Integer>();
			
			for (JsonValue neighbor : node.get("Connections")) {
				neighbors.put(neighbor.getString("Neighbor"), neighbor.getInt("Distance"));
			}
			
			//Create the node and add it to nodemap. addNode also updates edgemap simultaneously.
			addNode(new Node(assetManager, node.getString("Name"), node.getString("Area"), node.getString("Description"),
					node.getInt("XCoord"), node.getInt("YCoord"), map) {
				
				//Upon initialization of new nodes, we give them all the same inputlistener.
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

		//This is run at the start of the game, so move to first node in the game. Change this later when saves are implemented.
		moveTo("Sodden Lot");
		safeNode = "Sunken Dormitory";
	}
	
	/**
	 * This is run whenever a node is created. 
	 * It adds the node to the map and adds all corresponding edges that have not already been added.
	 * @param newNode: The node that is being added to nodeMap
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
	 * This is run when the player moves from one node to another.
	 * This only handles setting nodes as explored/discovered/current by the player. 
	 * @param nodeName: The name of the node that the player is moving towards.
	 */
	public void moveTo(String nodeName) {
		Node newNode = nodeMap.get(nodeName);
		
		if (newNode != null) {
			newNode.setDiscovered(true);
			newNode.setExplored(true);
			
			stateManager.getSceneManager().eventOnMove(currentNode, nodeName, stateManager.getPlayer());
			
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

	public String getSafeNode() {
		return safeNode;
	}

	public void setSafeNode(String safeNode) {
		this.safeNode = safeNode;
	}
}
