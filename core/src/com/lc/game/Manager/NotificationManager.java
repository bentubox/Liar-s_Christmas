package com.lc.game.Manager;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Queue;
import com.lc.game.AView;
import com.lc.game.LiarGame;
import com.lc.game.Notification.NotificationView;

public class NotificationManager {

	private StateManager stateManager;
	private AssetManager assetManager;
	
	private Queue<Table> notifications;

	private AView background;

	public NotificationManager(AssetManager assetManager, StateManager stateManager) {
		this.assetManager = assetManager;
		this.stateManager = stateManager;
		notifications = new Queue<Table>();
	}

	public Table getLastNotification() {
		if (notifications.size > 0) {
			return notifications.first();
		}
		return null;
	}	
	
	public void addNotification(Table newNotif) {
		notifications.addLast(newNotif);
		if (notifications.size == 1) {
			background = ViewManager.getCurrentView();
			LiarGame.getViewManager().createView(NotificationView.class, assetManager, stateManager);
		}
	}
	
	public void nextNotification() {
		notifications.removeFirst();
		if (getLastNotification() != null) {
			LiarGame.getViewManager().createView(NotificationView.class, assetManager, stateManager);
		} else {
			LiarGame.getViewManager().createView(background.getClass(), assetManager, stateManager);
		}
	}

	public AView getBackground() {
		return background;
	}

	public void setBackground(AView background) {
		this.background = background;
	}
	
}
