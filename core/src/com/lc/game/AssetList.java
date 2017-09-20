package com.lc.game;

import com.badlogic.gdx.graphics.Texture;

public enum AssetList {
	
	//List of Assets.
	TITLE_CARD("ornament_title.jpg", Texture.class),
	BUTLER_FONT("fonts/butler.fnt", null),
	LEARNING_FONT("fonts/learning_curve.fnt", null),
	MAP("lolitsrice_placeholder.png", Texture.class),
	MAP_NODE("node.png", Texture.class);
	
	//Enum constructor and methods.
	private String pathname;
    private Class<?> type;
    
    AssetList(String s, Class<?> c) {
        this.pathname = s;
        this.type = c;
    }

    @Override
    public String toString() {
        return this.pathname;
    }

    public Class<?> getType() { 
    	return type; 
    }
}
