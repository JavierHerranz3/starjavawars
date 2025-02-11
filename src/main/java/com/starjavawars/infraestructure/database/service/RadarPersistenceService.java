package com.starjavawars.infraestructure.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.starjavawars.application.ports.output.RadarRepositoryOutputPort;
import com.starjavawars.domain.model.Scan;
import com.starjavawars.infraestructure.database.entity.ScanEntity;
import com.starjavawars.infraestructure.database.mapper.RadarEntityMapper;
import com.starjavawars.infraestructure.database.repository.RadarMongoRepository;

@Service
public class RadarPersistenceService implements RadarRepositoryOutputPort {

	@Autowired
	RadarMongoRepository radarMongoRepository;
	@Autowired
	RadarEntityMapper radarEntityMapper;

	@CacheEvict(value = "scan", allEntries = true)
	public String saveScan(Scan scan) {
		ScanEntity selectedScan = radarEntityMapper.toEntity(scan);
		return radarMongoRepository.save(selectedScan).getId();
	}

}
