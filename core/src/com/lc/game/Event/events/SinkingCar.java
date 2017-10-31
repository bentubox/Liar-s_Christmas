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
import com.lc.game.Scene.SceneView;

public class SinkingCar extends AEvent{

	private final static int X = 500;
	private final static int Y = 500;
	private final static String image = AssetList.EVENTPLACEHOLDER.toString();
	
	public SinkingCar(AssetManager assetManager) {
		super(assetManager, X, Y, (Texture) assetManager.get(image));

	}

	@Override
	public void onClick(SceneView sceneView) {
		Table options = new Table();
		Label title = new Label("Retrieve Item?", sceneView.getSkin());

		TextButton option1 = new TextButton("Grab your Pocketknife", sceneView.getSkin());
		option1.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				
			}
	    });
		
		TextButton option2 = new TextButton("Grab your Lighter", sceneView.getSkin());
		option1.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				
			}
	    });
		
		TextButton option3 = new TextButton("Grab your Cellphone", sceneView.getSkin());
		option1.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				
			}
	    });
	    
		options.add(title);
		options.row();
		options.add(option1);
		options.row();
		options.add(option2);
		options.row();
		options.add(option3);
		options.row();
		sceneView.produceOptions(options);

	}

}
