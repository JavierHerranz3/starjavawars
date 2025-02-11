package com.starjavawars.domain.mapper;

import org.springframework.stereotype.Component;

import com.starjavawars.domain.model.Scan;
import com.starjavawars.domain.model.Target;

@Component
public class RadarMapper {
	public static Target toTarget(Scan scan) {
		return new Target(scan.getCoordinates().getX(), scan.getCoordinates().getY());
	}
}
