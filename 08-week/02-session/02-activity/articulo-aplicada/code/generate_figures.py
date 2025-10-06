#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Generador de Gráficas para Plantilla LaTeX - Ingeniería de Software
Versión adaptada para UrbanTracker: incluye diagramas de problema-solución y arquitectura MQTT.
"""

import matplotlib.pyplot as plt
from matplotlib import rcParams
import os

# Configuración global
plt.style.use('default')
rcParams['font.family'] = 'serif'
rcParams['font.size'] = 10
rcParams['axes.labelsize'] = 11
rcParams['axes.titlesize'] = 12
rcParams['savefig.dpi'] = 300
rcParams['savefig.bbox'] = 'tight'
rcParams['savefig.pad_inches'] = 0.1

# Crear carpetas necesarias
graphics_dir = 'graphics'
os.makedirs(graphics_dir, exist_ok=True)
os.makedirs('tables', exist_ok=True)

def generar_problema_solucion():
    """Genera un diagrama del problema y propuesta de solución"""
    fig, ax = plt.subplots(figsize=(8, 5))
    ax.set_xlim(0, 10)
    ax.set_ylim(0, 6)
    ax.axis('off')

    elementos = {
        "Problema:\nTransporte urbano\nsin control de rutas\npérdida de tiempo": (2, 4.5),
        "Propuesta:\nApp con SIG, GPS Android,\nMaps y Firebase": (5, 3),
        "Funcionalidad:\nLocalización en tiempo real\nHorarios optimizados": (8, 1.5)
    }

    for texto, (x, y) in elementos.items():
        ax.add_patch(plt.Rectangle((x-1.4, y-0.6), 2.8, 1.2, color="#FFF3CD", ec="black"))
        ax.text(x, y, texto, ha='center', va='center', fontsize=9, fontweight='bold')

    ax.annotate("", xy=(3.4, 3), xytext=(2.5, 4.2),
                arrowprops=dict(arrowstyle="->", lw=2))
    ax.annotate("", xy=(6.5, 1.8), xytext=(5.5, 2.7),
                arrowprops=dict(arrowstyle="->", lw=2))

    plt.title("Figura 1. Problema y propuesta de solución", fontsize=12)
    plt.tight_layout()
    plt.savefig(f'{graphics_dir}/problema_solucion.pdf', format='pdf')
    plt.savefig(f'{graphics_dir}/problema_solucion.png', format='png')
    plt.close()
    print("✓ Generada: problema_solucion.pdf/png")

def generar_arquitectura_mqtt():
    """Genera un diagrama de arquitectura simple del sistema UrbanTracker"""
    fig, ax = plt.subplots(figsize=(9, 5))
    ax.set_xlim(0, 10)
    ax.set_ylim(0, 5)
    ax.axis('off')

    boxes = {
        'Usuario': (1, 2.5),
        'App Android': (3, 2.5),
        'Servicio MQTT': (5, 2.5),
        'Dispositivo SisMo': (7, 2.5),
        'Motocicleta': (9, 2.5)
    }

    for label, (x, y) in boxes.items():
        ax.add_patch(plt.Rectangle((x-0.6, y-0.4), 1.2, 0.8, fill=True, color="#AEEAF7", ec="black"))
        ax.text(x, y, label, ha='center', va='center', fontsize=10, fontweight='bold')

    coords = list(boxes.values())
    for i in range(len(coords)-1):
        x1, y1 = coords[i]
        x2, y2 = coords[i+1]
        ax.annotate("", xy=(x2-0.7, y2), xytext=(x1+0.7, y1),
                    arrowprops=dict(arrowstyle="->", lw=2, color="black"))
        ax.annotate("", xy=(x1+0.7, y1-0.2), xytext=(x2-0.7, y2-0.2),
                    arrowprops=dict(arrowstyle="->", lw=1.5, color="gray", linestyle="--"))

    plt.title("Figura 2. Arquitectura general de comunicación (UrbanTracker)", fontsize=12)
    plt.tight_layout()
    plt.savefig(f'{graphics_dir}/arquitectura_mqtt.pdf', format='pdf')
    plt.savefig(f'{graphics_dir}/arquitectura_mqtt.png', format='png')
    plt.close()
    print("✓ Generada: arquitectura_mqtt.pdf/png")

def generar_tabla_frameworks():
    """Genera una tabla LaTeX con comparación de frameworks"""
    tabla_latex = r"""
\begin{table}[htbp]
\centering
\caption{Comparación de Frameworks de Desarrollo Web}
\label{tab:frameworks}
\begin{tabular}{lccccc}
\toprule
\textbf{Framework} & \textbf{Lenguaje} & \textbf{Performance} & \textbf{Curva Aprendizaje} & \textbf{Comunidad} & \textbf{Puntuación} \\
\midrule
React & JavaScript & Alta & Media & Excelente & 9.2 \\
Angular & TypeScript & Alta & Alta & Excelente & 8.7 \\
Vue.js & JavaScript & Alta & Baja & Buena & 8.9 \\
Django & Python & Media & Media & Excelente & 8.5 \\
Spring Boot & Java & Alta & Alta & Excelente & 8.8 \\
Laravel & PHP & Media & Baja & Buena & 8.1 \\
Express.js & JavaScript & Alta & Baja & Buena & 8.3 \\
\bottomrule
\end{tabular}
\end{table}
"""
    os.makedirs('tables', exist_ok=True)
    with open(f'tables/frameworks_comparison.tex', 'w', encoding='utf-8') as f:
        f.write(tabla_latex.strip())
    print("✓ Generada: frameworks_comparison.tex")

def main():
    """Función principal para generar todas las gráficas"""
    print("🎨 Generando gráficas para plantilla LaTeX...")
    print("=" * 50)
    try:
        generar_problema_solucion()
        generar_arquitectura_mqtt()
        generar_tabla_frameworks()

        print("=" * 50)
        print("✅ ¡Todas las gráficas y tablas fueron generadas exitosamente!")
        print("\nArchivos generados:")
        print("📊 Gráficas PDF/PNG: graphics/")
        print("📋 Tabla LaTeX: tables/frameworks_comparison.tex")

    except Exception as e:
        print(f"❌ Error al generar gráficas: {e}")
        raise

if __name__ == "__main__":
    main()
