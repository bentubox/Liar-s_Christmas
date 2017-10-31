package com.lc.game.Scene;
import java.util.ArrayList;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.lc.game.AChristmasActor;
import com.lc.game.Event.AEvent;

public class Scene extends AChristmasActor{
	
	private Texture backdrop;	
	
	private ArrayList<AEvent> events;
	
	public Scene(AssetManager assetManager, String backdrop) {
		super(assetManager);
		this.backdrop = getAssetManager().get(backdrop);
		this.backdrop.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		
		setX(0);
		setY(0);
		
		setWidth(this.backdrop.getWidth());
		setHeight(this.backdrop.getHeight());
		updateHitBox();
		
		events = new ArrayList<AEvent>();
		
	}

	@Override
    public void draw(Batch batch, float alpha) {
        batch.draw(backdrop, getX(), getY());
    }
	
	public Texture getBackdrop() {
		return backdrop;
	}

	public void setBackdrop(Texture backdrop) {
		this.backdrop = backdrop;
	}

	public ArrayList<AEvent> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<AEvent> events) {
		this.events = events;
	}
	
}
