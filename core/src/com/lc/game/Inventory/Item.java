package com.lc.game.Inventory;

import java.awt.image.BufferedImage;

import com.badlogic.gdx.assets.AssetManager;
import com.lc.game.AChristmasActor;

public abstract class Item extends AChristmasActor{

	private String name;
	private BufferedImage icon;
	
	public Item(AssetManager assetManager, BufferedImage icon) {
		super(assetManager);
		this.icon = icon;

	}

	public String getName() {
		return name;
	}	
}
