package com.starjavawars.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Scan {
	private Coordinates coordinates;
	private Enemy enemies;
	private Integer allies;

}
