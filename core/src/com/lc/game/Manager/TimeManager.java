package com.lc.game.Manager;

import com.badlogic.gdx.assets.AssetManager;

public class TimeManager {


//	private AssetManager assetManager;
	private StateManager stateManager;
	
	private int timeLeft, dayTime, dayNum;

	public TimeManager(AssetManager assetManager, StateManager stateManager) {
//		this.assetManager = assetManager;
		this.stateManager = stateManager;
		this.dayTime = 40;
		this.timeLeft = dayTime;
		this.dayNum = 1;
	}
	
	public void timeIncrement(int timeChange) {
		timeLeft += timeChange;

		stateManager.getSceneManager().eventTimePass(timeChange);

		if (timeLeft <= 0) {
			dayPass();
		}
		
	}
	
	public void dayPass() {
		dayNum++;
		timeLeft = dayTime;
		stateManager.getMapManager().moveTo(stateManager.getMapManager().getSafeNode());
	}

	public int getTimeLeft() {
		return timeLeft;
	}

	public void setTimeLeft(int timeLeft) {
		this.timeLeft = timeLeft;
	}

	public int getDayNum() {
		return dayNum;
	}

	public void setDayNum(int dayNum) {
		this.dayNum = dayNum;
	}

	public int getDayTime() {
		return dayTime;
	}

	public void setDayTime(int dayTime) {
		this.dayTime = dayTime;
	}
}
