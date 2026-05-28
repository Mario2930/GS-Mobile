import React, { useState, useEffect } from "react";
import { View, Text, StyleSheet, ScrollView, ActivityIndicator } from "react-native";
import { StatusBar } from "expo-status-bar";

import { Sensor } from "./src/interfaces/sensor";
import { SistemaMonitorado } from "./src/interfaces/sistemaMonitorado";
import { AlertaCritico } from "./src/interfaces/alertaCritico";

import { listarSensores } from "./src/services/sensorService";
import { listarSistemas } from "./src/services/sistemaService";
import { listarAlertas } from "./src/services/alertaService";

import SensorCard from "./src/components/SensorCard";
import SistemaCard from "./src/components/SistemaCard";
import AlertaCard from "./src/components/AlertaCard";

export default function App() {
  const [sensores, setSensores] = useState<Sensor[]>([]);
  const [sistemas, setSistemas] = useState<SistemaMonitorado[]>([]);
  const [alertas, setAlertas] = useState<AlertaCritico[]>([]);
  const [carregando, setCarregando] = useState(true);

  useEffect(() => {
    carregarDashboard();
  }, []);

  async function carregarDashboard() {
    try {
      setCarregando(true);
      const [dadosSensores, dadosSistemas, dadosAlertas] = await Promise.all([
        listarSensores(),
        listarSistemas(),
        listarAlertas()
      ]);
      setSensores(dadosSensores);
      setSistemas(dadosSistemas);
      setAlertas(dadosAlertas);
    } catch (error) {
      console.error("Erro ao carregar dados da missão:", error);
    } finally {
      setCarregando(false);
    }
  }

  if (carregando) {
    return (
      <View style={styles.center}>
        <ActivityIndicator size="large" color="#fff" />
        <Text style={styles.loadingText}>Conectando ao Controle da Missão...</Text>
      </View>
    );
  }

  return (
    <View style={styles.container}>
      <StatusBar style="light" />
      <ScrollView contentContainerStyle={styles.scrollContent}>
        
        <View style={styles.header}>
          <Text style={styles.tituloPrincipal}>Painel de Controle Espacial</Text>
          <Text style={styles.subtitulo}>Status da Missão: ONLINE</Text>
        </View>

        <Text style={styles.secaoTitulo}>Alertas Críticos</Text>
        {alertas.map(alerta => (
          <AlertaCard key={alerta.id} alerta={alerta} />
        ))}

        <Text style={styles.secaoTitulo}>Sistemas Vitais</Text>
        {sistemas.map(sistema => (
          <SistemaCard key={sistema.id} sistema={sistema} />
        ))}

        <Text style={styles.secaoTitulo}>Leitura de Sensores</Text>
        {sensores.map(sensor => (
          <SensorCard key={sensor.id} sensor={sensor} />
        ))}

      </ScrollView>
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, backgroundColor: "#0b132b" },
  center: { flex: 1, justifyContent: "center", alignItems: "center", backgroundColor: "#0b132b" },
  loadingText: { color: "#fff", marginTop: 16, fontSize: 16 },
  scrollContent: { padding: 20, paddingTop: 60, paddingBottom: 40 },
  header: { alignItems: "center", marginBottom: 24, borderBottomWidth: 1, borderBottomColor: "#1c2541", paddingBottom: 16 },
  tituloPrincipal: { fontSize: 24, fontWeight: "bold", color: "#fff", textAlign: "center" },
  subtitulo: { fontSize: 16, color: "#4CAF50", marginTop: 8, fontWeight: "bold" },
  secaoTitulo: { fontSize: 18, fontWeight: "bold", color: "#5bc0be", marginTop: 16, marginBottom: 12 }
});