package com.lc.game;

import com.badlogic.gdx.graphics.Texture;

public enum AssetList {
	
	//List of Assets.
	TITLE_CARD("ornament_title.jpg", Texture.class),
	BUTLER_FONT("fonts/butler.fnt", null),
	LEARNING_FONT("fonts/learning_curve.fnt", null),
	MAP("map/lolitsrice_placeholder.png", Texture.class),
	MAP_NODE("map/node.png", Texture.class),
	
	BACKGROUND_PLACEHOLDER("background/background_placeholder.jpg", Texture.class),
	PORTRAIT_PLACEHOLDER_COOPER("portrait/ref_placeholder_cooper.jpg", Texture.class),
	PORTRAIT_PLACEHOLDER_RITA("portrait/ref_placeholder_rita.jpg", Texture.class),
	PORTRAIT_PLACEHOLDER_ROBBART("portrait/ref_placeholder_robbart.jpg", Texture.class),
	PORTRAIT_PLACEHOLDER_TATE("portrait/ref_placeholder_tate.jpg", Texture.class),
	SCRIPT_TEST("script/test_0.script", null);
	
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
