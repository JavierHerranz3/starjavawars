package com.starjavawars.infraestructure.apirest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RadarResponse {
	private int x;
	private int y;
}
