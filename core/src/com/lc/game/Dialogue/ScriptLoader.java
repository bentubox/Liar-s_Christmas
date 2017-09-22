package com.lc.game.Dialogue;

import com.lc.game.Manager.StateManager;

/**
 * Dialogue utility for parsing script files in accordance to the game state.
 */
public class ScriptLoader {

	private StateManager stateManager;
	
	public ScriptLoader(StateManager stateManager) {
		this.stateManager = stateManager;
	}
}
