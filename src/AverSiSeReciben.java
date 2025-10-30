

import java.util.*;

public class AverSiSeReciben {

    /**
     * Asigna franjas horarias a materias usando un coloreo greedy.
     * Ningún par de materias que comparten al menos un estudiante
     * puede tener la misma franja.
     *
     * @param materias lista de materias disponibles
     * @param estudiantes mapa: estudiante -> lista de materias que cursa
     * @return mapa materia -> número de franja asignada
     */
    public static Map<String, Integer> aVerSiSeReciben(List<String> materias,
                                                       Map<String, List<String>> estudiantes) {

        // Grafo: materia -> conjunto de materias con conflicto (adyacentes)
        Map<String, Set<String>> grafo = new HashMap<>();

        // Inicializo el grafo con nodos vacíos
        for (String materia : materias) {
            grafo.put(materia, new HashSet<>());
        }

        // Construyo las aristas del grafo:
        // Si un estudiante cursa dos materias, se conectan entre sí
        for (List<String> materiasDeAlumno : estudiantes.values()) {
            for (int i = 0; i < materiasDeAlumno.size(); i++) {
                for (int j = i + 1; j < materiasDeAlumno.size(); j++) {
                    String m1 = materiasDeAlumno.get(i);
                    String m2 = materiasDeAlumno.get(j);

                    // Agrego arista bidireccional
                    grafo.get(m1).add(m2);
                    grafo.get(m2).add(m1);
                }
            }
        }

        // ---- Etapa de asignación de franjas (coloreo greedy simple) ----
        Map<String, Integer> franjaPorMateria = new HashMap<>();

        for (String materia : materias) {
            // Colores/franjas ya usados por materias vecinas
            Set<Integer> usadas = new HashSet<>();
            for (String vecino : grafo.get(materia)) {
                if (franjaPorMateria.containsKey(vecino)) {
                    usadas.add(franjaPorMateria.get(vecino));
                }
            }

            // Busco el color/franja más bajo disponible
            int color = 1;
            while (usadas.contains(color)) {
                color++;
            }

            franjaPorMateria.put(materia, color);
        }

        return franjaPorMateria;
    }

    // --- Ejemplo de uso ---
    public static void main(String[] args) {
        List<String> materias = Arrays.asList("MatA", "MatB", "MatC", "MatD", "MatE");

        Map<String, List<String>> estudiantes = new HashMap<>();
        estudiantes.put("Juan", Arrays.asList("MatA", "MatB", "MatC"));
        estudiantes.put("Ana", Arrays.asList("MatB", "MatD"));
        estudiantes.put("Luis", Arrays.asList("MatA", "MatD"));
        estudiantes.put("Sofía", Arrays.asList("MatE"));

        Map<String, Integer> resultado = aVerSiSeReciben(materias, estudiantes);

        System.out.println("Asignación de franjas horarias:");
        for (Map.Entry<String, Integer> entry : resultado.entrySet()) {
            System.out.println(entry.getKey() + " → Franja " + entry.getValue());
        }
    }
}
