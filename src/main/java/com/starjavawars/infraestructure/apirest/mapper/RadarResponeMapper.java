package com.starjavawars.infraestructure.apirest.mapper;

import com.starjavawars.domain.model.Target;
import com.starjavawars.infraestructure.apirest.dto.RadarResponse;

public class RadarResponeMapper {
	public static RadarResponse toRadarResponse(Target target) {
		return new RadarResponse(target.getX(), target.getY());
	}
}
