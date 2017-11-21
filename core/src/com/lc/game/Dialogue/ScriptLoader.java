package com.lc.game.Dialogue;

import java.io.File;
import java.io.FileReader;

import com.lc.game.Manager.StateManager;

/**
 * Dialogue utility for parsing script files in accordance to the game state.
 */
public class ScriptLoader {

	private StateManager stateManager;
	
	public ScriptLoader(StateManager stateManager) {
		this.stateManager = stateManager;
//		parser = new JSONParser();
	}
	
	public Script load(File file) {
		//TODO: Load from JSON script file. StateManager is queried for dynamic scripts.
		
		FileReader scriptInput;
		Script script =null;
		
		return script;
	}
	
	private Script handleError() {
		//TODO: Initialize dummy script on load error.
		return Script.DUMMY;
	}
}
