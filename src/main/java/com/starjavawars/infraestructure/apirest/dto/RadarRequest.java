package com.starjavawars.infraestructure.apirest.dto;

import java.util.List;

import com.starjavawars.domain.model.Protocol;
import com.starjavawars.domain.model.Scan;

import lombok.Data;

@Data
public class RadarRequest {
	private List<Protocol> protocols;
	private List<Scan> scan;
}
