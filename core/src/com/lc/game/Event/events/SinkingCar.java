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

public class SinkingCar extends AEvent{

	private final static int X = 500;
	private final static int Y = 500;
	private final static String image = AssetList.EVENTPLACEHOLDER.toString();
	private final static String name = "Your Sinking Car.";

	public SinkingCar(AssetManager assetManager) {
		super(assetManager, name, X, Y, (Texture) assetManager.get(image));

	}

	@Override
	public void onClick(final StateManager stateManager) {

		Table notif = new Table();
		Label content = new Label("Take a thing", stateManager.getSkin());
		TextButton option1 = new TextButton("Your Pocketknife", stateManager.getSkin());
		option1.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stateManager.getNotificationManager().nextNotification();
			}
	    });
		TextButton option2 = new TextButton("Your Cellphone", stateManager.getSkin());
		option2.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stateManager.getNotificationManager().nextNotification();
			}
	    });
		TextButton option3 = new TextButton("Your Lighter", stateManager.getSkin());
		option3.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stateManager.getNotificationManager().nextNotification();
			}
	    });
		TextButton option4 = new TextButton("Your Air Freshener", stateManager.getSkin());
		option4.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stateManager.getNotificationManager().nextNotification();
			}
	    });
		notif.add(content);
		notif.row();
		notif.add(option1);
		notif.row();
		notif.add(option2);
		notif.row();
		notif.add(option3);
		notif.row();
		notif.add(option4);
		stateManager.getNotificationManager().addNotification(notif);
	}

}
