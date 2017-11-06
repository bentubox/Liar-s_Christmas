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
import com.lc.game.GlobalActors.Player.APlayer;
import com.lc.game.Manager.StateManager;

public class StandardFlavorMove extends AEvent{

	private final static String image = AssetList.EVENTPLACEHOLDER.toString();
	private String name;
	private String text;

	public StandardFlavorMove(AssetManager assetManager, int x, int y, String name, String text) {
		super(assetManager, name, x, y, (Texture) assetManager.get(image));
		this.name = name;
		this.text = text;
	}
	
	@Override
	public void onMove(String start, String end, APlayer schmuck, final StateManager stateManager) {
		Table notif = new Table();
		
		Label title = new Label(name, stateManager.getSkin());
		Label content = new Label(text, stateManager.getSkin());
		
		TextButton next = new TextButton("Next", stateManager.getSkin());
		next.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stateManager.getNotificationManager().nextNotification();
			}
	    });
		notif.add(title);
		notif.row();
		notif.add(content);
		notif.row();
		notif.add(next);
		stateManager.getNotificationManager().addNotification(notif);
	}
	
}
