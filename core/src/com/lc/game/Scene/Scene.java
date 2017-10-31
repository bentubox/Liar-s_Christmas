package com.lc.game.Scene;
import java.util.ArrayList;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.lc.game.AChristmasActor;
import com.lc.game.Event.AEvent;

/**
 * A Scene is the main view of the game that offers player-view of current node location.
 * It contains a list of events of the node and holds the main point-and-click part of the game
 * @author Zachary Tu
 *
 */
public abstract class Scene extends AChristmasActor{
	
	//The image background of the scene.
	private Texture backdrop;	
	
	//List of events currently in the scene
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
		
		init();
	}
	
	public abstract void init();

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
	
	public void addEvent(AEvent... events) {
		for (AEvent event : events) {
			this.events.add(event);
		}
	}
	
}
