export interface AlertaCritico {
  id: number;
  nivel: string;
  descricao: string;
  dataAlerta: string; // O LocalDateTime do Java chega como string ISO 8601 no front
  resolvido: boolean;
}