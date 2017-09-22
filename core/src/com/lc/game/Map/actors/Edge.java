package com.lc.game.Map.actors;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.lc.game.AChristmasActor;
import com.lc.game.LiarGame;

/**
 * Actor representing a connection between overworld nodes.
 */
public class Edge extends AChristmasActor{

	private Node e0, e1;
	private ShapeRenderer edgeRenderer;
	private boolean drawEdge;
	private String id;
	
	public Edge(AssetManager assetManager, Node first, Node second) {
		super(assetManager);
		e0 = first;
		e1 = second;
		this.id = first.getName() + "_" + second.getName();
		setDrawEdge(false);
		edgeRenderer = new ShapeRenderer();
		edgeRenderer.setProjectionMatrix(LiarGame.getProjectionMatrix());
	}

	public Node getE0() {
		return e0;
	}

	public void setE0(Node e0) {
		this.e0 = e0;
	}

	public Node getE1() {
		return e1;
	}

	public void setE1(Node e1) {
		this.e1 = e1;
	}
	
	@Override
    public void draw(Batch batch, float alpha) {
		if(isDrawEdge()) {
			//Suspend batch.
			batch.end();
			edgeRenderer.begin(ShapeRenderer.ShapeType.Filled);
			edgeRenderer.setColor(Color.YELLOW);
			edgeRenderer.rectLine(e0.getCenterX(), e0.getCenterY(), e1.getCenterX(), e1.getCenterY(), 8);
			edgeRenderer.end();
			//Resume batch.
			batch.begin();
		}
    }

	public boolean isDrawEdge() {
		return drawEdge;
	}

	public void setDrawEdge(boolean drawEdge) {
		this.drawEdge = drawEdge;
		if(this.drawEdge) {
			edgeRenderer.setProjectionMatrix(LiarGame.getProjectionMatrix());
		}
	}

	public ShapeRenderer getEdgeRenderer() {
		return edgeRenderer;
	}

	public String getId() {
		return id;
	}
}
