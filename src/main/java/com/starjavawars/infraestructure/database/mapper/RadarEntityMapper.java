package com.starjavawars.infraestructure.database.mapper;

import org.springframework.stereotype.Component;

import com.starjavawars.domain.model.Scan;
import com.starjavawars.infraestructure.database.entity.ScanEntity;

@Component
public class RadarEntityMapper {

	public ScanEntity toEntity(Scan scan) {
		ScanEntity scanEntity = new ScanEntity();
		scanEntity.setCoordinates(scan.getCoordinates());
		scanEntity.setEnemies(scan.getEnemies());
		scanEntity.setAllies(scan.getAllies());
		return scanEntity;
	}

	public ScanEntity save(ScanEntity selectedScan) {
		// TODO Auto-generated method stub
		return null;
	}
}
