package com.lc.game.Event;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.lc.game.AChristmasActor;
import com.lc.game.Scene.SceneView;

public abstract class AEvent extends AChristmasActor {

	//Reference to asset manager for obtaining assets.
	protected AssetManager assetManager;
		
	//This is the image that represents the event in the sceneview
	private Texture image;
	
	public AEvent(AssetManager assetManager, int X, int Y, Texture image) {
		super(assetManager, X, Y);
		this.setImage(image);

		setWidth(image.getWidth());
		setHeight(image.getHeight());
		updateHitBox();
	}
	
	@Override
	public void draw(Batch batch, float alpha) {
		batch.draw(image, getX(), getY());
	}
	
	//This will be run when the event is clicked in the sceneview
	public abstract void onClick(SceneView sceneView);

	//This is run every time a moment passes in the game.
	public void onTimePass() {
		
	}

	//This is run every time a person moves from one node to another
	public void onMove() {
		
	}

	public Texture getImage() {
		return image;
	}

	public void setImage(Texture image) {
		this.image = image;
	}
}
