import java.util.List;
import java.util.ArrayList;
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

    public static String torneoConEquipos(List<LuchadorConEquipo> luchadores){
        MaxHeap<LuchadorConEquipo> heapLuchadores = new MaxHeap<>();

        for (LuchadorConEquipo luchador : luchadores){
            heapLuchadores.insert(new Tuple<>(luchador,1));
        }
        LuchadorConEquipo luchador1 = heapLuchadores.peek().dato;
        while(heapLuchadores.peek() != null){
            luchador1 = heapLuchadores.extractMax().dato;
            ArrayList<LuchadorConEquipo> luchadoresDelMismoEquipo = new ArrayList<>();
            while(heapLuchadores.peek()!=null){
                LuchadorConEquipo luchador2 = heapLuchadores.extractMax().dato;
                if(luchador1.getEquipo().equals(luchador2.getEquipo())){
                    luchadoresDelMismoEquipo.add(luchador2);
                }
                else{
                    luchador1.luchar(luchador2);

                    if(luchador1.getFuerza() != 0) {
                        heapLuchadores.insert(new Tuple<>(luchador1, 1));
                    }

                    for(LuchadorConEquipo luchador : luchadoresDelMismoEquipo){
                        heapLuchadores.insert(new Tuple<>(luchador,1));
                    }

                    break;
                }
            }
        }
        return luchador1!=null? luchador1.getEquipo(): null;
    }
}
