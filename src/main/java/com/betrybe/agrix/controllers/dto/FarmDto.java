package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.models.entities.Crops;
import com.betrybe.agrix.models.entities.Farm;
import java.util.List;

/**
 * FarmDTO class.
 */
public record FarmDto(Long id, String name, int size, List<Crops> crop) {

  public Farm dtoToFarm() {
    return new Farm(id, name, size, crop);
  }
}
