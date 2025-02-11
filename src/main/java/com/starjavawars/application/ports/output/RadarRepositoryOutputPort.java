package com.starjavawars.application.ports.output;

import com.starjavawars.domain.model.Scan;

public interface RadarRepositoryOutputPort {

	String saveScan(Scan selectedScan);

}
