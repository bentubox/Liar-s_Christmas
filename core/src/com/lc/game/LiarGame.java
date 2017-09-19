package com.lc.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
//import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.lc.game.Manager.StateManager;
import com.lc.game.Manager.ViewManager;
import com.lc.game.Title.TitleView;

public class LiarGame extends ApplicationAdapter {
	
	SpriteBatch batch;
	private static int DEFAULT_WIDTH = 1600;
	private static int DEFAULT_HEIGHT = 900;
	
	public static int CONFIG_WIDTH;
	public static int CONFIG_HEIGHT;
	
	private static OrthographicCamera camera;
    public static FitViewport viewport;
    
    private static ViewManager viewManager;
    private static StateManager stateManager;
    private static AssetManager assetManager;

//	private static FPSLogger fpsLogger = new FPSLogger();
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		
		CONFIG_WIDTH = DEFAULT_WIDTH;
		CONFIG_HEIGHT = DEFAULT_HEIGHT;
						
		camera = new OrthographicCamera(CONFIG_WIDTH, CONFIG_HEIGHT);
        camera.setToOrtho(false, CONFIG_WIDTH, CONFIG_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        viewport = new FitViewport(CONFIG_WIDTH, CONFIG_HEIGHT, camera);
        viewport.apply();
        
        Gdx.graphics.setWindowedMode(CONFIG_WIDTH, CONFIG_HEIGHT);
       
        assetManager = new AssetManager(new InternalFileHandleResolver());
        loadAssets();

        stateManager = new StateManager();
        viewManager = new ViewManager(assetManager, stateManager);
        
        viewManager.createView(TitleView.class, assetManager, stateManager);
                
	}
	
	@Override
	public void resize(int width, int height) {
	    viewport.update(width, height, true);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
		ViewManager.getCurrentView().getViewport().update(width, height);
		viewport.apply();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		ViewManager.getCurrentView().act();
		batch.begin();
		ViewManager.getCurrentView().draw();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
	
	public void loadAssets() {
        for (AssetList asset: AssetList.values()) {
            if (asset.getType() != null) {
                assetManager.load(asset.toString(), asset.getType());
            }
        }

        assetManager.finishLoading();
    }
}
