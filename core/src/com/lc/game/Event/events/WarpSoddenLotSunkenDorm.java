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

public class WarpSoddenLotSunkenDorm extends AEvent{

	private final static int X = 900;
	private final static int Y = 300;
	private final static String image = AssetList.EVENTPLACEHOLDER.toString();
	private final static String name = "A Familiar Looking Building.";

	public WarpSoddenLotSunkenDorm(AssetManager assetManager) {
		super(assetManager, name, X, Y, (Texture) assetManager.get(image));

	}

	@Override
	public void onClick(final StateManager stateManager) {
		Table notif = new Table();
		Label content = new Label("Travel here?",stateManager.getSkin());
		TextButton yes = new TextButton("Yea", stateManager.getSkin());
		yes.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stateManager.getMapManager().moveTo("Sunken Dormitory");
				stateManager.getNotificationManager().nextNotification();
			}
	    });
		TextButton no = new TextButton("Nah", stateManager.getSkin());
		no.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				stateManager.getNotificationManager().nextNotification();
			}
	    });
		notif.add(content);
		notif.row();
		notif.add(yes);
		notif.row();
		notif.add(no);
		stateManager.getNotificationManager().addNotification(notif);
	}
	
}
