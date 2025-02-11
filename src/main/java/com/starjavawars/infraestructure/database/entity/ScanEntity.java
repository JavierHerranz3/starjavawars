package com.starjavawars.infraestructure.database.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.starjavawars.domain.model.Coordinates;
import com.starjavawars.domain.model.Enemy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "scans")
public class ScanEntity {
	@Id
	private String id;
	private Integer allies;
	private Coordinates coordinates;
	private Enemy enemies;

}
