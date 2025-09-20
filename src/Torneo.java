import java.util.List;

public class Torneo {

    public static Luchador torneoSinEquipos(List<Luchador> luchadores) {
        MaxHeap<Luchador> heapLuchadores = new MaxHeap<>();

        // Insertamos todos los luchadores iniciales
        for (Luchador luchador : luchadores) {
            heapLuchadores.insert(new Tuple<>(luchador, 1));
        }

        // Mientras haya luchadores en el heap
        while (heapLuchadores.peek() != null) {
            // Extraemos el más fuerte
            Luchador luchador1 = heapLuchadores.extractMax().dato;

            // Si no queda otro, ese es el ganador
            if (heapLuchadores.peek() == null) {
                return luchador1;
            }

            // Extraemos el segundo más fuerte
            Luchador luchador2 = heapLuchadores.extractMax().dato;

            // Caso empate: ambos mueren, no se reinserta nadie
            if (luchador1.getFuerza() == luchador2.getFuerza()) {
                continue;
            }

            // Calculamos la fuerza restante y el ganador
            int nuevaFuerza = Math.abs(luchador1.getFuerza() - luchador2.getFuerza());
            String nombreGanador = luchador1.getFuerza() > luchador2.getFuerza()
                    ? luchador1.getNombre()
                    : luchador2.getNombre();

            // Reinserto al ganador con su fuerza reducida
            heapLuchadores.insert(new Tuple<>(new Luchador(nuevaFuerza, nombreGanador), 1));
        }

        // Si no quedó ninguno, todos murieron
        return null;
    }
}
