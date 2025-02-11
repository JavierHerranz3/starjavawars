package com.starjavawars.application.ports.input;

import com.starjavawars.domain.model.Target;
import com.starjavawars.infraestructure.apirest.dto.RadarRequest;

public interface RadarServiceInputPort {

	Target determineTarget(RadarRequest radarRequest);

}
