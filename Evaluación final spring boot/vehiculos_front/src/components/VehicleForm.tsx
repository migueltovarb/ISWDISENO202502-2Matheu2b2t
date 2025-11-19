import type React from 'react'
import { useEffect, useState } from 'react'
import type { Vehicle, VehiclePayload } from '../services/vehicleService'

type VehicleFormProps = {
  initialData?: Vehicle | null
  onSubmit: (payload: VehiclePayload) => Promise<void>
  onCancel?: () => void
  submitting?: boolean
}

const initialState: VehiclePayload = {
  plate: '',
  brand: '',
  model: '',
  color: '',
  year: new Date().getFullYear(),
  type: '',
  description: '',
}

export function VehicleForm({
  initialData,
  onSubmit,
  onCancel,
  submitting,
}: VehicleFormProps) {
  const [form, setForm] = useState<VehiclePayload>(initialState)

  useEffect(() => {
    if (initialData) {
      setForm({
        plate: initialData.plate,
        brand: initialData.brand,
        model: initialData.model,
        color: initialData.color,
        year: initialData.year,
        type: initialData.type,
        description: initialData.description || '',
      })
    } else {
      setForm(initialState)
    }
  }, [initialData])

  function handleChange(
    event: React.ChangeEvent<HTMLInputElement | HTMLSelectElement | HTMLTextAreaElement>,
  ) {
    const { name, value } = event.target
    setForm((prev) => ({
      ...prev,
      [name]: name === 'year' ? Number(value) : value,
    }))
  }

  async function handleSubmit(event: React.FormEvent) {
    event.preventDefault()
    await onSubmit(form)
    setForm(initialState)
  }

  return (
    <form className="card" onSubmit={handleSubmit}>
      <div className="form-grid">
        <label>
          Placa*
          <input
            name="plate"
            value={form.plate}
            onChange={handleChange}
            required
            maxLength={12}
            placeholder="ABC-123"
          />
        </label>
        <label>
          Marca*
          <input
            name="brand"
            value={form.brand}
            onChange={handleChange}
            required
            placeholder="Toyota"
          />
        </label>
        <label>
          Modelo*
          <input
            name="model"
            value={form.model}
            onChange={handleChange}
            required
            placeholder="Corolla"
          />
        </label>
        <label>
          Color*
          <input
            name="color"
            value={form.color}
            onChange={handleChange}
            required
            placeholder="Rojo"
          />
        </label>
        <label>
          Año*
          <input
            name="year"
            type="number"
            value={form.year}
            onChange={handleChange}
            required
            min={1900}
            max={2100}
          />
        </label>
        <label>
          Tipo*
          <select name="type" value={form.type} onChange={handleChange} required>
            <option value="">Selecciona una opción</option>
            <option value="Auto">Auto</option>
            <option value="Camioneta">Camioneta</option>
            <option value="Moto">Moto</option>
            <option value="SUV">SUV</option>
            <option value="Camión">Camión</option>
          </select>
        </label>
      </div>

      <label>
        Descripción
        <textarea
          name="description"
          value={form.description}
          onChange={handleChange}
          maxLength={255}
          placeholder="Notas adicionales"
        />
      </label>

      <div className="form-actions">
        <button type="submit" className="primary" disabled={submitting}>
          {initialData ? 'Actualizar vehículo' : 'Guardar vehículo'}
        </button>
        {initialData && (
          <button type="button" onClick={onCancel} className="ghost">
            Cancelar
          </button>
        )}
      </div>
    </form>
  )
}
