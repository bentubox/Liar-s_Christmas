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

public class IntroSequence extends AEvent{

	private final static int X = 0;
	private final static int Y = 0;
	private final static String image = AssetList.EVENTPLACEHOLDER.toString();
	private final static String name = "Your Sinking Car.";

	public IntroSequence(AssetManager assetManager) {
		super(assetManager, name, X, Y, (Texture) assetManager.get(image));

	}

	@Override
	public void onClick(StateManager stateManager) {

	}
	
	@Override
	public void onMove(String start, String end, APlayer schmuck, final StateManager stateManager) {
		
		
		Table notif = new Table();
		Label content = new Label("This is where the introduction cutscene would be if we had made it yet",	stateManager.getSkin());
		TextButton next = new TextButton("Next", stateManager.getSkin());
		next.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stateManager.getNotificationManager().nextNotification();
			}
	    });
		notif.add(content);
		notif.row();
		notif.add(next);
		stateManager.getNotificationManager().addNotification(notif);
		
		Table notif2 = new Table();
		Label content2 = new Label("Testing multi stage notifications",	stateManager.getSkin());
		TextButton next2 = new TextButton("Next", stateManager.getSkin());
		next2.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stateManager.getNotificationManager().nextNotification();
			}
	    });
		notif2.add(content2);
		notif2.row();
		notif2.add(next2);
		stateManager.getNotificationManager().addNotification(notif2);
		
		Table notif3 = new Table();
		Label content3 = new Label("Ay carambas",	stateManager.getSkin());
		TextButton next3 = new TextButton("Next", stateManager.getSkin());
		next3.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stateManager.getNotificationManager().nextNotification();
			}
	    });
		notif3.add(content3);
		notif3.row();
		notif3.add(next3);
		stateManager.getNotificationManager().addNotification(notif3);
		
		stateManager.getSceneManager().getScene("Sodden Lot").getEvents().remove(this);
	}
}
