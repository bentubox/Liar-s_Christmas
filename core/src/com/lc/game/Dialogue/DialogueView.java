package com.lc.game.Dialogue;

import java.io.File;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.lc.game.AView;
import com.lc.game.LiarGame;
import com.lc.game.Dialogue.actors.Backdrop;
import com.lc.game.Dialogue.actors.DialogueBox;
import com.lc.game.Dialogue.actors.Speaker;
import com.lc.game.Manager.StateManager;
import com.lc.game.Title.TitleView;

public class DialogueView extends AView{

	private ScriptLoader loader;
	private Backdrop backdrop;
	private DialogueBox dialogueBox;
	private Speaker[] speakerArray;
	
	public DialogueView(AssetManager assetManager, StateManager stateManager, Viewport viewport, Batch batch) {
		super(assetManager, stateManager, viewport, batch);
		loader = new ScriptLoader(stateManager);
		
		backdrop = new Backdrop(assetManager);
		dialogueBox = new DialogueBox(assetManager);
		
		addActor(backdrop);
		addActor(dialogueBox);
//		loadDialogue(new File(AssetList.SCRIPT_TEST.toString()));
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	public void loadDialogue(File file) {
		loader.load(file);
		
		for (Speaker s : speakerArray) {
			addActor(s);
		}
	}

	@Override
	protected void setType() {
		VIEW_TYPE = "DIALOGUE";
	}
	
	@Override
	public boolean keyDown(int keyCode) {
        boolean isHandled = false;

        if (keyCode == Input.Keys.ESCAPE) {
            LiarGame.getViewManager().createView(TitleView.class, assetManager, stateManager);
        }

        return isHandled;
    }
}
