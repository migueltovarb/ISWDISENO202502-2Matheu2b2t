import { useState } from 'react'
import { Alert } from '../components/Alert'
import { VehicleForm } from '../components/VehicleForm'
import { VehicleTable } from '../components/VehicleTable'
import { useVehicles } from '../hooks/useVehicles'
import type { VehiclePayload } from '../services/vehicleService'
import { apiBaseUrl } from '../services/vehicleService'

export function VehiclesPage() {
  const {
    vehicles,
    selectedVehicle,
    loading,
    error,
    statusMessage,
    create,
    update,
    remove,
    selectVehicle,
    clearSelection,
    clearStatus,
    setError,
  } = useVehicles()
  const [submitting, setSubmitting] = useState(false)

  async function handleSubmit(payload: VehiclePayload) {
    setSubmitting(true)
    setError(null)
    try {
      if (selectedVehicle?.id) {
        await update(selectedVehicle.id, payload)
      } else {
        await create(payload)
      }
    } catch (err) {
      setError(
        err instanceof Error ? err.message : 'No se pudo guardar el vehículo',
      )
    } finally {
      setSubmitting(false)
    }
  }

  async function handleDelete(id: string) {
    const confirmed = window.confirm('¿Seguro que deseas eliminar este vehículo?')
    if (!confirmed) return
    try {
      await remove(id)
    } catch (err) {
      setError(err instanceof Error ? err.message : 'No se pudo eliminar el vehículo')
    }
  }

  return (
    <div className="layout">
      <header className="header">
        <div>
          <p className="eyebrow">Gestión de vehículos</p>
          <h1>Vehículos en flota</h1>
          <p className="muted">
            API base: <code>{apiBaseUrl()}</code>
          </p>
        </div>
        <div className="badge">MongoDB + Spring Boot</div>
      </header>

      {error && <Alert message={error} type="error" onClose={() => setError(null)} />}
      {statusMessage && (
        <Alert message={statusMessage} type="success" onClose={clearStatus} />
      )}

      <section>
        <h2>{selectedVehicle ? 'Editar vehículo' : 'Agregar vehículo'}</h2>
        <VehicleForm
          initialData={selectedVehicle}
          onSubmit={handleSubmit}
          onCancel={clearSelection}
          submitting={submitting}
        />
      </section>

      <section>
        <div className="section-header">
          <h2>Listado</h2>
          <button className="ghost" onClick={clearSelection} disabled={!selectedVehicle}>
            Limpiar selección
          </button>
        </div>
        {loading ? (
          <p>Cargando vehículos...</p>
        ) : (
          <VehicleTable vehicles={vehicles} onSelect={selectVehicle} onDelete={handleDelete} />
        )}
      </section>
    </div>
  )
}
