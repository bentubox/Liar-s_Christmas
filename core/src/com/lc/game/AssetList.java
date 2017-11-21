package com.lc.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

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
	SCRIPT_TEST("script/test_0.script", null),

	SCENE1TEST("scenes/Scene1Test.png", Texture.class),
	SCENE2TEST("scenes/Scene2Test.png", Texture.class),
	
	UISKINIMG("ui/uiskin.png", Texture.class),
	UISKINATL("ui/uiskin.atlas", TextureAtlas.class),
	
	EVENTPLACEHOLDER("eventPlaceholder.gif", Texture.class),

	SCENESODDENLOT("scenes/SceneSoddenLot.gif", Texture.class),
	SCENESUNKENDORM("scenes/SceneSunkenDorm.gif", Texture.class),
	SCENEMANGROVES("scenes/SceneMangroves.png", Texture.class),
	SCENEFOUNTAIN("scenes/SceneFountain.gif", Texture.class),	
	SCENEGLADE("scenes/SceneGlade.png", Texture.class),
	SCENESEWER("scenes/SceneSewer.jpg", Texture.class),
	SCENETROUGH("scenes/SceneTrough.gif", Texture.class),
	SCENESLUICE("scenes/SceneSluice.png", Texture.class),
	SCENECLOT("scenes/SceneClot.jpg", Texture.class),
	SCENEUNCLEANDORM("scenes/SceneUncleanDorm.jpg", Texture.class),
	SCENEHEAP("scenes/SceneHeap.gif", Texture.class),
	SCENEVAULT("scenes/SceneVault.gif", Texture.class),
	SCENERECLAMATIONPLANT("scenes/SceneReclamationPlant.jpg", Texture.class),
	SCENEUNUSEDROOMS("scenes/SceneUnusedRooms.png", Texture.class);
	
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
