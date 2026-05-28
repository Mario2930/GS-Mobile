import api from "./api";
import { SistemaMonitorado } from "../interfaces/sistemaMonitorado";

export async function listarSistemas(): Promise<SistemaMonitorado[]> {
  const response = await api.get<SistemaMonitorado[]>("/sistemas");
  return response.data;
}