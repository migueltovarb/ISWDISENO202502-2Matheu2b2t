package vehiculos.vehiculos.services;

import java.util.List;

import vehiculos.vehiculos.dtos.VehicleRequest;
import vehiculos.vehiculos.dtos.VehicleResponse;

public interface VehicleService {

    List<VehicleResponse> findAll();

    VehicleResponse findById(String id);

    VehicleResponse create(VehicleRequest request);

    VehicleResponse update(String id, VehicleRequest request);

    void delete(String id);
}
