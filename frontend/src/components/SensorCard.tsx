import React from "react";
import { View, Text, StyleSheet } from "react-native";
import { Sensor } from "../interfaces/sensor";

interface Props {
  sensor: Sensor;
}

export default function SensorCard({ sensor }: Props) {
  return (
    <View style={styles.card}>
      <Text style={styles.titulo}>📡 {sensor.nome}</Text>
      <Text style={styles.info}>Tipo: {sensor.tipo}</Text>
      <Text style={styles.info}>Local: {sensor.localizacaoModulo}</Text>
      <View style={[styles.badge, { backgroundColor: sensor.ativo ? "#4CAF50" : "#F44336" }]}>
        <Text style={styles.badgeText}>{sensor.ativo ? "ATIVO" : "INATIVO"}</Text>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  card: { backgroundColor: "#fff", padding: 16, borderRadius: 8, marginBottom: 12, elevation: 2 },
  titulo: { fontSize: 16, fontWeight: "bold", color: "#333", marginBottom: 4 },
  info: { fontSize: 14, color: "#666", marginBottom: 2 },
  badge: { alignSelf: "flex-start", marginTop: 8, paddingHorizontal: 8, paddingVertical: 4, borderRadius: 4 },
  badgeText: { color: "#fff", fontSize: 12, fontWeight: "bold" }
});