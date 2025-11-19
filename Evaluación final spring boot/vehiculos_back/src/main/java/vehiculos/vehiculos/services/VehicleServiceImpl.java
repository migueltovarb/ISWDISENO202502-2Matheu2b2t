package vehiculos.vehiculos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vehiculos.vehiculos.dtos.VehicleRequest;
import vehiculos.vehiculos.dtos.VehicleResponse;
import vehiculos.vehiculos.entities.Vehicle;
import vehiculos.vehiculos.exception.DuplicateResourceException;
import vehiculos.vehiculos.exception.ResourceNotFoundException;
import vehiculos.vehiculos.repositories.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repository;

    public VehicleServiceImpl(VehicleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<VehicleResponse> findAll() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public VehicleResponse findById(String id) {
        Vehicle vehicle = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehículo no encontrado"));
        return toResponse(vehicle);
    }

    @Override
    public VehicleResponse create(VehicleRequest request) {
        if (repository.existsByPlateIgnoreCase(request.getPlate())) {
            throw new DuplicateResourceException("Ya existe un vehículo con esa placa");
        }

        Vehicle vehicle = new Vehicle();
        applyRequestToEntity(request, vehicle);
        vehicle.markCreated();
        repository.save(vehicle);
        return toResponse(vehicle);
    }

    @Override
    public VehicleResponse update(String id, VehicleRequest request) {
        Vehicle vehicle = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehículo no encontrado"));

        Optional<Vehicle> plateOwner = repository.findByPlateIgnoreCase(request.getPlate());
        if (plateOwner.isPresent() && !plateOwner.get().getId().equals(id)) {
            throw new DuplicateResourceException("Ya existe un vehículo con esa placa");
        }

        applyRequestToEntity(request, vehicle);
        vehicle.markUpdated();
        repository.save(vehicle);
        return toResponse(vehicle);
    }

    @Override
    public void delete(String id) {
        Vehicle vehicle = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehículo no encontrado"));
        repository.delete(vehicle);
    }

    private void applyRequestToEntity(VehicleRequest request, Vehicle vehicle) {
        vehicle.setPlate(request.getPlate());
        vehicle.setBrand(request.getBrand());
        vehicle.setModel(request.getModel());
        vehicle.setColor(request.getColor());
        vehicle.setYear(request.getYear());
        vehicle.setType(request.getType());
        vehicle.setDescription(request.getDescription());
    }

    private VehicleResponse toResponse(Vehicle vehicle) {
        return new VehicleResponse(
                vehicle.getId(),
                vehicle.getPlate(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getColor(),
                vehicle.getYear(),
                vehicle.getType(),
                vehicle.getDescription(),
                vehicle.getCreatedAt(),
                vehicle.getUpdatedAt());
    }
}
