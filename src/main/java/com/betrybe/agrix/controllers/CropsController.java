package com.betrybe.agrix.controller;

import com.betrybe.agrix.controllers.dto.CropDto;
import com.betrybe.agrix.exception.NotFound;
import com.betrybe.agrix.service.CropsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for class crops.
 */
@RestController
@RequestMapping("/crops")
public class CropsController {

  private final CropsService cropsService;

  @Autowired
  public CropsController(CropsService cropsService) {
    this.cropsService = cropsService;
  }

  /**
   * Rota get all Crops.
   */
  @GetMapping
  public ResponseEntity<List<CropDto>> getAllCrops() {
    List<CropDto> crops = cropsService.getAllCrops();
    return new ResponseEntity<>(crops, HttpStatus.OK);
  }

  /**
   * Rota get Crop by id.
   */
  @GetMapping("/{id}")
  public ResponseEntity<?> getCropById(@PathVariable Integer id) {
    try {
      CropDto cropDto = cropsService.getCropById(id);
      return ResponseEntity.status(HttpStatus.OK).body(cropDto);
    } catch (NotFound e) {
      return ResponseEntity.status(e.getStatus()).body(e.getMessage());
    }
  }
}