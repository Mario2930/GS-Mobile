import React from "react";
import { View, Text, StyleSheet } from "react-native";
import { AlertaCritico } from "../interfaces/alertaCritico";

interface Props {
  alerta: AlertaCritico;
}

export default function AlertaCard({ alerta }: Props) {
  const isResolvido = alerta.resolvido;
  
  return (
    <View style={[styles.card, { borderColor: isResolvido ? "#4CAF50" : "#F44336", borderWidth: 2 }]}>
      <Text style={styles.titulo}>⚠️ ALERTA {alerta.nivel}</Text>
      <Text style={styles.descricao}>{alerta.descricao}</Text>
      <Text style={styles.info}>Data: {new Date(alerta.dataAlerta).toLocaleString()}</Text>
      <Text style={[styles.status, { color: isResolvido ? "#4CAF50" : "#F44336" }]}>
        {isResolvido ? "RESOLVIDO" : "REQUER ATENÇÃO IMEDIATA"}
      </Text>
    </View>
  );
}

const styles = StyleSheet.create({
  card: { backgroundColor: "#fff", padding: 16, borderRadius: 8, marginBottom: 12 },
  titulo: { fontSize: 16, fontWeight: "bold", color: "#333", marginBottom: 4 },
  descricao: { fontSize: 14, color: "#444", marginBottom: 8, fontStyle: "italic" },
  info: { fontSize: 12, color: "#888", marginBottom: 4 },
  status: { fontSize: 14, fontWeight: "bold", marginTop: 4 }
});