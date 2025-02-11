package com.starjavawars.application.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starjavawars.application.ports.input.RadarServiceInputPort;
import com.starjavawars.application.ports.output.RadarRepositoryOutputPort;
import com.starjavawars.application.utils.DistanceCalculator;
import com.starjavawars.domain.exception.InvalidTargetException;
import com.starjavawars.domain.mapper.RadarMapper;
import com.starjavawars.domain.model.EnemyType;
import com.starjavawars.domain.model.Protocol;
import com.starjavawars.domain.model.Scan;
import com.starjavawars.domain.model.Target;
import com.starjavawars.infraestructure.apirest.dto.RadarRequest;

@Service
public class RadarService implements RadarServiceInputPort {

	@Autowired
	RadarRepositoryOutputPort radarRepositoryOutputPort;

	@Override
	public Target determineTarget(RadarRequest radarRequest) {
		List<Scan> scans = radarRequest.getScan();
		List<Protocol> protocols = radarRequest.getProtocols();

		// Lógica de selección de objetivo basada en los protocolos solicitados
		List<Scan> validScans = filterValidScans(scans);
		validScans = applyProtocols(validScans, protocols);

		if (validScans.isEmpty()) {
			throw new InvalidTargetException("No valid target found after applying protocols: " + protocols);
		}

		// Guarda el escaneo en la base de datos
		Scan selectedScan = validScans.get(0);
		radarRepositoryOutputPort.saveScan(selectedScan);

		// Convertir el scan seleccionado en un Target
		return RadarMapper.toTarget(selectedScan);
	}

	// Filtra distancia y enemigos válidos
	private List<Scan> filterValidScans(List<Scan> scans) {
		return scans.stream().filter(scan -> DistanceCalculator.calculateDistance(scan.getCoordinates()) <= 100)
				.filter(scan -> scan.getEnemies().getType() == EnemyType.SOLDIER
						|| scan.getEnemies().getType() == EnemyType.MECH)
				.collect(Collectors.toList());
	}

	// Aplicar los protocolos
	private List<Scan> applyProtocols(List<Scan> scans, List<Protocol> protocols) {
		// Verificar protocolos conflictivos
		checkForConflictingProtocols(protocols);

		if (protocols.contains(Protocol.AVOID_MECH)) {
			scans = scans.stream().filter(scan -> scan.getEnemies().getType() != EnemyType.MECH)
					.collect(Collectors.toList());
		}

		if (protocols.contains(Protocol.PRIORITIZE_MECH)) {
			List<Scan> mechScans = scans.stream().filter(scan -> scan.getEnemies().getType() == EnemyType.MECH)
					.collect(Collectors.toList());

			if (!mechScans.isEmpty()) {
				scans = mechScans;
			}
		}

		if (protocols.contains(Protocol.AVOID_CROSSFIRE)) {
			scans = scans.stream().filter(scan -> scan.getAllies() == null || scan.getAllies() == 0)
					.collect(Collectors.toList());
		}

		if (protocols.contains(Protocol.ASSIST_ALLIES)) {
			scans = scans.stream().filter(scan -> scan.getAllies() != null && scan.getAllies() > 0)
					.collect(Collectors.toList());
		}

		if (protocols.contains(Protocol.CLOSEST_ENEMIES) || protocols.contains(Protocol.FURTHEST_ENEMIES)) {
			scans.sort(Comparator.comparingDouble(scan -> DistanceCalculator.calculateDistance(scan.getCoordinates())));

			if (protocols.contains(Protocol.FURTHEST_ENEMIES)) {
				Collections.reverse(scans);
			}
		}

		return scans;
	}

	// Verificar protocolos conflictivos
	private void checkForConflictingProtocols(List<Protocol> protocols) {
		if (protocols.contains(Protocol.ASSIST_ALLIES) && protocols.contains(Protocol.AVOID_CROSSFIRE)) {
			throw new InvalidTargetException(
					"Conflicting protocols: ASSIST_ALLIES and AVOID_CROSSFIRE cannot be applied together.");
		}
		if (protocols.contains(Protocol.PRIORITIZE_MECH) && protocols.contains(Protocol.AVOID_MECH)) {
			throw new InvalidTargetException(
					"Conflicting protocols: PRIORITIZE_MECH and AVOID_MECH cannot be applied together.");
		}
		if (protocols.contains(Protocol.CLOSEST_ENEMIES) && protocols.contains(Protocol.FURTHEST_ENEMIES)) {
			throw new InvalidTargetException(
					"Conflicting protocols: CLOSEST_ENEMIES and FURTHEST_ENEMIES cannot be applied together.");
		}
	}
}