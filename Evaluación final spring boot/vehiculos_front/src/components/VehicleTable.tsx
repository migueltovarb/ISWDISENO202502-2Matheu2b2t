import type { Vehicle } from '../services/vehicleService'

type VehicleTableProps = {
  vehicles: Vehicle[]
  onSelect: (vehicle: Vehicle) => void
  onDelete: (id: string) => void
}

export function VehicleTable({ vehicles, onSelect, onDelete }: VehicleTableProps) {
  if (vehicles.length === 0) {
    return <p className="muted">No hay vehículos registrados aún.</p>
  }

  return (
    <div className="table-container">
      <table>
        <thead>
          <tr>
            <th>Placa</th>
            <th>Marca</th>
            <th>Modelo</th>
            <th>Color</th>
            <th>Año</th>
            <th>Tipo</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          {vehicles.map((vehicle) => (
            <tr key={vehicle.id}>
              <td>{vehicle.plate}</td>
              <td>{vehicle.brand}</td>
              <td>{vehicle.model}</td>
              <td>{vehicle.color}</td>
              <td>{vehicle.year}</td>
              <td>{vehicle.type}</td>
              <td className="table-actions">
                <button onClick={() => onSelect(vehicle)} title="Editar">
                  Editar
                </button>
                <button className="danger" onClick={() => onDelete(vehicle.id!)}>
                  Eliminar
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}
