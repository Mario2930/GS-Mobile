import api from "./api";
import { Sensor } from "../interfaces/sensor";

export async function listarSensores(): Promise<Sensor[]> {
  const response = await api.get<Sensor[]>("/sensores");
  return response.data;
}

export async function criarSensor(sensor: Omit<Sensor, "id">): Promise<Sensor> {
  const response = await api.post<Sensor>("/sensores", sensor);
  return response.data;
}