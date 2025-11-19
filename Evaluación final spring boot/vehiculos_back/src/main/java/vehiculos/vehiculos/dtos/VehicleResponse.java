package vehiculos.vehiculos.dtos;

import java.time.LocalDateTime;

public class VehicleResponse {

    private String id;
    private String plate;
    private String brand;
    private String model;
    private String color;
    private Integer year;
    private String type;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public VehicleResponse() {
        // default constructor
    }

    public VehicleResponse(String id, String plate, String brand, String model, String color, Integer year,
            String type, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.type = type;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
