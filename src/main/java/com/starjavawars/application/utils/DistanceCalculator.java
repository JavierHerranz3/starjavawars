package com.starjavawars.application.utils;

import com.starjavawars.domain.model.Coordinates;

public class DistanceCalculator {
	public static double calculateDistance(Coordinates coordinates) {
		return Math.sqrt(Math.pow(coordinates.getX(), 2) + Math.pow(coordinates.getY(), 2));
	}
}
