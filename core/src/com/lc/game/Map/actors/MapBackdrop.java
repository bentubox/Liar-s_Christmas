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
				//Calculate intended drag.
				Point2D deltaDrag = new Point2D(x - dragStart.x, y - dragStart.y);
				//Check bounds to disable excess dragging.
				if((getX() > 0 && deltaDrag.x > 0) || 
						(getX() + mapTexture.getWidth() < LiarGame.CONFIG_WIDTH && deltaDrag.x < 0) ||
						(getY() > 0 && deltaDrag.y > 0) ||
						(getY() + mapTexture.getHeight() < LiarGame.CONFIG_HEIGHT && deltaDrag.y < 0)) {
					dragStart.setLocation(x, y);
				}
				
				//Recalculate actual drag.
				deltaDrag.setLocation(new Point2D(x - dragStart.x, y - dragStart.y));
				moveBy(deltaDrag.x, deltaDrag.y);
				
				//Return to bounds if exceeded.
				if(getX() > 0 && deltaDrag.x > 0) {
					setX(0);
				} else if(getX() + mapTexture.getWidth() < LiarGame.CONFIG_WIDTH && deltaDrag.x < 0) {
					setX(LiarGame.CONFIG_WIDTH - mapTexture.getWidth());
				}
				if(getY() > 0 && deltaDrag.y > 0) {
					setY(0);
				} else if(getY() + mapTexture.getHeight() < LiarGame.CONFIG_HEIGHT && deltaDrag.y < 0) {
					setY(LiarGame.CONFIG_HEIGHT - mapTexture.getHeight());
				}
		    	updateHitBox();
		    }
		});
	}
	
	@Override
    public void draw(Batch batch, float alpha) {
        batch.draw(mapTexture, getX(), getY());
    }
}
