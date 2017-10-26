package com.lc.game.Manager;

import com.lc.game.Map.MapView;

/**
 * 
 * @author Zachary Tu
 * Manager for managing node and edges in the map
 */
public class MapManager {
	
	private MapView mapView;
	
	public MapManager(MapView mapView) {
		this.mapView = mapView;
	}
	
	
	
	

	public MapView getMapView() {
		return mapView;
	}
}
