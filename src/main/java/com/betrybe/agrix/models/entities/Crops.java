package com.betrybe.agrix.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "crops")
public class Crops {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private int plantedArea;

  @ManyToOne
  private Farm farm; // Represents the farm associated with this crop

  public Crops() {
    // Default constructor required by JPA
  }

  public Crops(Long id, String name, int plantedArea) {
    this.id = id;
    this.name = name;
    this.plantedArea = plantedArea;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPlantedArea() {
    return plantedArea;
  }

  public void setPlantedArea(int plantedArea) {
    this.plantedArea = plantedArea;
  }

  public Farm getFarm() {
    return farm;
  }

  public void setFarm(Farm farm) {
    this.farm = farm;
  }
}
