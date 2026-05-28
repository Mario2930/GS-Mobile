import React from "react";
import { View, Text, StyleSheet } from "react-native";
import { SistemaMonitorado } from "../interfaces/sistemaMonitorado";

interface Props {
  sistema: SistemaMonitorado;
}

export default function SistemaCard({ sistema }: Props) {
  return (
    <View style={styles.card}>
      <Text style={styles.titulo}>⚙️ {sistema.nome}</Text>
      <Text style={styles.info}>Responsável: {sistema.responsavel}</Text>
      <Text style={styles.status}>Status: {sistema.status}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  card: { backgroundColor: "#e3f2fd", padding: 16, borderRadius: 8, marginBottom: 12 },
  titulo: { fontSize: 16, fontWeight: "bold", color: "#1565c0", marginBottom: 4 },
  info: { fontSize: 14, color: "#555", marginBottom: 4 },
  status: { fontSize: 14, fontWeight: "bold", color: "#0d47a1" }
});