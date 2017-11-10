package com.lc.game.Event.events;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.lc.game.AssetList;
import com.lc.game.Event.AEvent;
import com.lc.game.Manager.StateManager;

public class StandardWarp extends AEvent{

	private final static String image = AssetList.EVENTPLACEHOLDER.toString();
	private String name;
	private String text;
	private String location;

	public StandardWarp(AssetManager assetManager, int x, int y, String name, String text, String location) {
		super(assetManager, name, x, y, (Texture) assetManager.get(image));
		this.name = name;
		this.text = text;
		this.location = location;
	}

	@Override
	public void onClick(final StateManager stateManager) {
		Table notif = new Table();
		
		int cost = stateManager.getMapManager().distanceTo(location);
		
		Label title = new Label(name, stateManager.getSkin());
		Label content = new Label(text, stateManager.getSkin());
		
		TextButton yes = new TextButton("Travel? Costs: " + cost +" Adventure(s)", stateManager.getSkin());
		yes.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stateManager.getMapManager().moveTo(location);
				stateManager.getNotificationManager().nextNotification();
			}
	    });
		
		TextButton no = new TextButton("Never Mind", stateManager.getSkin());
		no.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stateManager.getNotificationManager().nextNotification();
			}
	    });
		notif.add(title);
		notif.row();
		notif.add(content);
		notif.row();
		notif.add(yes);
		notif.row();
		notif.add(no);
		stateManager.getNotificationManager().addNotification(notif);
	}
	
}
