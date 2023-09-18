package com.betrybe.agrix.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "farms")
public class Farm {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private int size;

  @OneToMany(mappedBy = "farm")
  // Specify the property name in Crop class representing the relationship
  @JsonIgnore
  private List<Crops> crops;

  public Farm(Long id, String name, int size, List<Crops> crop) {
    // Default constructor required by JPA
  }

  public Farm(Long id, String name, int size) {
    this.id = id;
    this.name = name;
    this.size = size;
  }

  public List<Crops> getCrops() {
    return crops;
  }

  public void setCrops(List<Crops> crops) {
    this.crops = crops;
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

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }
}
