package com.lc.game.Manager;

import java.lang.reflect.InvocationTargetException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AView;
import com.lc.game.Title.TitleView;

/**
 * Manager for creating and switching between game views.
 */
public class ViewManager {
	private static AView currentView;
	
	public ViewManager(AssetManager assetManager, StateManager stateManager) {
		currentView = new TitleView(assetManager, stateManager);
	}
	
	public void createView(Class<?> type, AssetManager assetManager, StateManager stateManager) {
        try {
            setCurrentView((AView) type.getConstructor(AssetManager.class, StateManager.class).newInstance(assetManager, stateManager));
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
