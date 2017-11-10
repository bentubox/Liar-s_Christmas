package com.lc.game.Notification;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.lc.game.AView;
import com.lc.game.LiarGame;
import com.lc.game.Manager.StateManager;

public class NotificationView extends AView{

	private Table currentNotification;
	
	private AView background;
	
	public NotificationView(AssetManager assetManager, StateManager stateManager, Viewport viewport, Batch batch) {
		super(assetManager, stateManager, viewport, batch);
		this.background = stateManager.getNotificationManager().getBackground();
	}

	@Override
	public void init() {
		currentNotification = stateManager.getNotificationManager().getLastNotification();

		currentNotification.toFront();
		currentNotification.setPosition(LiarGame.getCameraViewportWidth() / 2 - currentNotification.getWidth() / 2, 0);
		currentNotification.addAction(Actions.moveTo(LiarGame.getCameraViewportWidth() / 2 - currentNotification.getWidth() / 2,
				LiarGame.getCameraViewportHeight() / 2, .5f, Interpolation.pow5Out));
		addActor(currentNotification);
	}

	@Override
	public void draw() {
		background.draw();
		super.draw();
	}

	@Override
	protected void setType() {
		VIEW_TYPE = "NOTIFICATION";		
	}
}
