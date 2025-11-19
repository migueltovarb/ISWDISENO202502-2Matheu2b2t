package vehiculos.vehiculos.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import vehiculos.vehiculos.entities.Vehicle;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {

    boolean existsByPlateIgnoreCase(String plate);

    Optional<Vehicle> findByPlateIgnoreCase(String plate);
}
