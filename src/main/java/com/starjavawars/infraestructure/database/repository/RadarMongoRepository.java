package com.starjavawars.infraestructure.database.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.starjavawars.infraestructure.database.entity.ScanEntity;

public interface RadarMongoRepository extends MongoRepository<ScanEntity, String> {

}
