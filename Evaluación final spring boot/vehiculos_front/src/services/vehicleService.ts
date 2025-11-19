export interface Vehicle {
  id?: string
  plate: string
  brand: string
  model: string
  color: string
  year: number
  type: string
  description?: string
  createdAt?: string
  updatedAt?: string
}

export type VehiclePayload = Omit<Vehicle, 'id' | 'createdAt' | 'updatedAt'>

const API_BASE_URL =
  import.meta.env.VITE_API_BASE_URL || 'http://localhost:8080'

async function handleResponse<T>(response: Response): Promise<T> {
  if (!response.ok) {
    try {
      const body = await response.json()
      const message = body.message || JSON.stringify(body)
      throw new Error(message)
    } catch (error) {
      const message =
        error instanceof Error ? error.message : 'Error al procesar la respuesta'
      throw new Error(message)
    }
  }
  return response.json() as Promise<T>
}

export async function fetchVehicles(): Promise<Vehicle[]> {
  const response = await fetch(`${API_BASE_URL}/api/vehicles`)
  return handleResponse<Vehicle[]>(response)
}

export async function createVehicle(payload: VehiclePayload): Promise<Vehicle> {
  const response = await fetch(`${API_BASE_URL}/api/vehicles`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(payload),
  })
  return handleResponse<Vehicle>(response)
}

export async function updateVehicle(
  id: string,
  payload: VehiclePayload,
): Promise<Vehicle> {
  const response = await fetch(`${API_BASE_URL}/api/vehicles/${id}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(payload),
  })
  return handleResponse<Vehicle>(response)
}

export async function deleteVehicle(id: string): Promise<void> {
  const response = await fetch(`${API_BASE_URL}/api/vehicles/${id}`, {
    method: 'DELETE',
  })
  if (!response.ok) {
    const body = await response.json().catch(() => null)
    const message = body?.message || 'No se pudo eliminar el vehículo'
    throw new Error(message)
  }
}

export function apiBaseUrl(): string {
  return API_BASE_URL
}
