package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.models.entities.Farm;

/**
 * FarmDTO class.
 */
public record FarmDto(Integer id, String name, Double size) {

  public Farm dtoToFarm() {
    return new Farm(id, name, size);
  }
}
