import { useEffect, useState } from 'react'
import type { Vehicle, VehiclePayload } from '../services/vehicleService'
import {
  createVehicle,
  deleteVehicle,
  fetchVehicles,
  updateVehicle,
} from '../services/vehicleService'

export function useVehicles() {
  const [vehicles, setVehicles] = useState<Vehicle[]>([])
  const [selectedVehicle, setSelectedVehicle] = useState<Vehicle | null>(null)
  const [loading, setLoading] = useState<boolean>(true)
  const [error, setError] = useState<string | null>(null)
  const [statusMessage, setStatusMessage] = useState<string | null>(null)

  useEffect(() => {
    loadVehicles()
  }, [])

  async function loadVehicles() {
    setLoading(true)
    setError(null)
    try {
      const data = await fetchVehicles()
      setVehicles(
        data.sort((a, b) => (b.createdAt || '').localeCompare(a.createdAt || '')),
      )
    } catch (err) {
      setError(err instanceof Error ? err.message : 'No se pudieron cargar los vehículos')
    } finally {
      setLoading(false)
    }
  }

  async function handleCreate(payload: VehiclePayload) {
    setError(null)
    const vehicle = await createVehicle(payload)
    setVehicles((prev) => [vehicle, ...prev])
    setStatusMessage('Vehículo creado con éxito')
  }

  async function handleUpdate(id: string, payload: VehiclePayload) {
    setError(null)
    const updated = await updateVehicle(id, payload)
    setVehicles((prev) => prev.map((v) => (v.id === id ? updated : v)))
    setSelectedVehicle(null)
    setStatusMessage('Vehículo actualizado')
  }

  async function handleDelete(id: string) {
    setError(null)
    await deleteVehicle(id)
    setVehicles((prev) => prev.filter((v) => v.id !== id))
    if (selectedVehicle?.id === id) {
      setSelectedVehicle(null)
    }
    setStatusMessage('Vehículo eliminado')
  }

  function selectVehicle(vehicle: Vehicle) {
    setSelectedVehicle(vehicle)
    setStatusMessage(null)
  }

  function clearSelection() {
    setSelectedVehicle(null)
  }

  function clearStatus() {
    setStatusMessage(null)
  }

  return {
    vehicles,
    selectedVehicle,
    loading,
    error,
    statusMessage,
    loadVehicles,
    create: handleCreate,
    update: handleUpdate,
    remove: handleDelete,
    selectVehicle,
    clearSelection,
    clearStatus,
    setError,
  }
}
