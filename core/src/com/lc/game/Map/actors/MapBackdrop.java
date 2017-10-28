package com.lc.game.Map.actors;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.lc.game.AChristmasActor;
import com.lc.game.AssetList;
import com.lc.game.LiarGame;
import com.sun.javafx.geom.Point2D;

public class MapBackdrop extends AChristmasActor{

	private Texture mapTexture;
	
	public MapBackdrop(AssetManager assetManager) {
		super(assetManager);
		mapTexture = getAssetManager().get(AssetList.MAP.toString());
		mapTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		
		setX(0);
		setY(0);
		
		setWidth(mapTexture.getWidth());
		setHeight(mapTexture.getHeight());
		updateHitBox();
		
		addListener(new DragListener() {
			Point2D dragStart = new Point2D(0, 0);
			
			@Override
			public void dragStart(InputEvent event, float x, float y, int pointer) {
				dragStart.setLocation(x, y);
			}
			
			@Override
			public void drag(InputEvent event, float x, float y, int pointer) {
				LiarGame.moveCamera(dragStart.x - x, dragStart.y - y);
		    }
		});
	}
	
	@Override
	public void act(float delta) {
		//Return camera to bounds.
		
		if(mapTexture.getWidth() < LiarGame.getCameraViewportWidth() * LiarGame.getCurrentZoom()) {
			float leftBound = mapTexture.getWidth() - (LiarGame.getCameraViewportWidth() * LiarGame.getCurrentZoom()) / 2;
			float rightBound = (LiarGame.getCameraViewportWidth() * LiarGame.getCurrentZoom()) / 2;
			if(LiarGame.getCameraPosition().x < leftBound) {
				LiarGame.moveCamera(leftBound - LiarGame.getCameraPosition().x, 0);
			} else if (LiarGame.getCameraPosition().x > rightBound) {
				LiarGame.moveCamera(rightBound - LiarGame.getCameraPosition().x, 0);
			}
		} else {
			float leftBound = (LiarGame.getCameraViewportWidth() * LiarGame.getCurrentZoom()) / 2;
			float rightBound = mapTexture.getWidth() - (LiarGame.getCameraViewportWidth() * LiarGame.getCurrentZoom()) / 2;
			if(LiarGame.getCameraPosition().x < leftBound) {
				LiarGame.moveCamera(leftBound - LiarGame.getCameraPosition().x, 0);
			} else if (LiarGame.getCameraPosition().x > rightBound) {
				LiarGame.moveCamera(rightBound - LiarGame.getCameraPosition().x, 0);
			}
		}
		
		if(mapTexture.getHeight() < LiarGame.getCameraViewportHeight() * LiarGame.getCurrentZoom()) {
			float lowerBound = mapTexture.getHeight() - (LiarGame.getCameraViewportHeight() * LiarGame.getCurrentZoom()) / 2;
			float upperBound = (LiarGame.getCameraViewportHeight() * LiarGame.getCurrentZoom()) / 2;
			if(LiarGame.getCameraPosition().y < lowerBound) {
				LiarGame.moveCamera(0, lowerBound - LiarGame.getCameraPosition().y);
			} else if (LiarGame.getCameraPosition().y > upperBound) {
				LiarGame.moveCamera(0, upperBound - LiarGame.getCameraPosition().y);
			}
		} else {
			float lowerBound = (LiarGame.getCameraViewportHeight() * LiarGame.getCurrentZoom()) / 2;
			float upperBound = mapTexture.getHeight() - (LiarGame.getCameraViewportHeight() * LiarGame.getCurrentZoom()) / 2;
			if(LiarGame.getCameraPosition().y < lowerBound) {
				LiarGame.moveCamera(0, lowerBound - LiarGame.getCameraPosition().y);
			} else if (LiarGame.getCameraPosition().y > upperBound) {
				LiarGame.moveCamera(0, upperBound - LiarGame.getCameraPosition().y);
			}
		}
	}
	
	@Override
    public void draw(Batch batch, float alpha) {
        batch.draw(mapTexture, getX(), getY());
    }
}
