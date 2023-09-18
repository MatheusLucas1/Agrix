package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.FarmDto;
import com.betrybe.agrix.controllers.dto.ResponseDto;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.service.FarmService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FarmController class.
 */
@RestController
@RequestMapping(value = "/farms")
public class FarmController {

  private final FarmService farmService;

  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  /**
   * createFarm class.
   */
  @PostMapping()
  public ResponseEntity<ResponseDto<Farm>> createFarm(@RequestBody FarmDto farmDto) {
    Farm newFarm = farmService.insertFarm(farmDto.dtoToFarm());
    ResponseDto<Farm> responseDto = new ResponseDto<>("farm created!", newFarm);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
  }

  /**
   * getAllFarms class.
   */
  @GetMapping()
  public List<FarmDto> getAllFarms() {
    List<Farm> allFarms = farmService.getAllFarms();
    return allFarms.stream()
        .map((farm) -> new FarmDto(farm.getId(), farm.getName(), farm.getSize(), farm.getCrops()))
        .collect(Collectors.toList());
  }

  /**
   * getFarmById class.
   */
  @GetMapping("/{farmId}")
  public ResponseEntity<ResponseDto<Farm>> getFarmById(@PathVariable Long farmId) {
    Optional<Farm> optionalFarm = farmService.getFarmById(farmId);
    if (optionalFarm.isEmpty()) {
      ResponseDto<Farm> responseDto = new ResponseDto<>(
          String.format("Fazenda não encontrada!", farmId), null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
    }
    ResponseDto<Farm> responseDto = new ResponseDto<>("Fazenda encontrada com sucesso!",
        optionalFarm.get());
    return ResponseEntity.ok(responseDto);
  }
}
