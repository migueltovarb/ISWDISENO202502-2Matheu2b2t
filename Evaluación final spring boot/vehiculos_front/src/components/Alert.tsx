type AlertProps = {
  message: string
  type?: 'error' | 'success' | 'info'
  onClose?: () => void
}

export function Alert({ message, type = 'info', onClose }: AlertProps) {
  return (
    <div className={`alert ${type}`}>
      <span>{message}</span>
      {onClose && (
        <button className="ghost small" onClick={onClose}>
          ×
        </button>
      )}
    </div>
  )
}
