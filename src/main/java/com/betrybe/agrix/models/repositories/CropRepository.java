package com.betrybe.agrix.models.repositories;

import com.betrybe.agrix.models.entities.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Farm Repository.
 */
public interface CropRepository extends JpaRepository<Crop, Integer> {

}
