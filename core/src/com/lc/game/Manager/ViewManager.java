package com.lc.game.Manager;

import java.lang.reflect.InvocationTargetException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.lc.game.AView;
import com.lc.game.Title.TitleView;

/**
 * Manager for creating and switching between game views.
 */
public class ViewManager {
	private static AView currentView;
	private static Viewport viewport;
	private static Batch batch;
	
	public ViewManager(AssetManager assetManager, StateManager stateManager, Viewport viewport, Batch batch) {
		currentView = new TitleView(assetManager, stateManager, viewport, batch);
		ViewManager.viewport = viewport;
		ViewManager.batch = batch;
	}
	
	public void createView(Class<?> type, AssetManager assetManager, StateManager stateManager) {
        try {
            setCurrentView((AView) type.getConstructor(AssetManager.class, StateManager.class, Viewport.class, Batch.class).newInstance(assetManager, stateManager, viewport, batch));
    		Gdx.input.setInputProcessor(currentView);
            currentView.init();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

	public static AView getCurrentView() {
		return currentView;
	}

	public static void setCurrentView(AView currentView) {
		ViewManager.currentView = currentView;
	}
}
