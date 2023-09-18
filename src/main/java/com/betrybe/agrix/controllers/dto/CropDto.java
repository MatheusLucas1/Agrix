package com.betrybe.agrix.controllers.dto;

/**
 * Dto for crop.
 */
public record CropDto(Integer id, String name, Double plantedArea, Integer farmId) {

}