package com.starjavawars.infraestructure.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starjavawars.application.ports.input.RadarServiceInputPort;
import com.starjavawars.domain.model.Target;
import com.starjavawars.infraestructure.apirest.dto.RadarRequest;
import com.starjavawars.infraestructure.apirest.dto.RadarResponse;
import com.starjavawars.infraestructure.apirest.mapper.RadarResponeMapper;
import com.starjavawars.infraestructure.database.service.RadarPersistenceService;

@RestController
@RequestMapping("/radar")
public class RadarController {

	@Autowired
	RadarServiceInputPort radarService;
	@Autowired
	RadarPersistenceService radarPersistenceService;

	@PostMapping
	public ResponseEntity<RadarResponse> determineTarget(@RequestBody RadarRequest radarRequest) {

		Target target = radarService.determineTarget(radarRequest);

		RadarResponse radarResponse = RadarResponeMapper.toRadarResponse(target);

		return ResponseEntity.ok(radarResponse);
	}
}
