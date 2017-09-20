package com.lc.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Color;
//import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
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
	
	private static boolean DEBUG = true;
	
	private static OrthographicCamera camera;
    public static FitViewport viewport;
	private static ShapeRenderer shapeRenderer;
    
    private static ViewManager viewManager;
    private static StateManager stateManager;
    private static AssetManager assetManager;
    
    public static BitmapFont SYSTEM_FONT_TITLE, SYSTEM_FONT_TEXT;
    public static Color DEFAULT_TEXT_COLOR;

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
        
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.setProjectionMatrix(camera.combined);
        
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
		ViewManager.getCurrentView().draw();
		if (DEBUG) {
			shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
			Array<Actor> actors = ViewManager.getCurrentView().getActors();
			for (Actor a : actors) {
				if (a instanceof AChristmasActor && ((AChristmasActor) a).getHitBox() != null) {
					shapeRenderer.polygon(((AChristmasActor) a).getHitBox().getTransformedVertices());
				}
			}
			shapeRenderer.end();
		}
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
	
	public void loadAssets() {
        
		SYSTEM_FONT_TITLE = new BitmapFont(Gdx.files.internal(AssetList.LEARNING_FONT.toString()), false);
		SYSTEM_FONT_TEXT = new BitmapFont(Gdx.files.internal(AssetList.BUTLER_FONT.toString()), false);
		DEFAULT_TEXT_COLOR = Color.BLACK;
		
		for (AssetList asset: AssetList.values()) {
            if (asset.getType() != null) {
                assetManager.load(asset.toString(), asset.getType());
            }
        }

        assetManager.finishLoading();
    }
	
	//Exposes ViewManager so that it can be utilized by other views.
	public static ViewManager getViewManager() {
		return viewManager;
	}
	
	//Exposes camera for use by other classes.
	public static OrthographicCamera getCamera() {
		return camera;
	}
}
