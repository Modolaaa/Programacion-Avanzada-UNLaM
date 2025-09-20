public class Tuple<T extends Comparable<T>> implements Comparable<Tuple<T>> {
    private static int contador = 0;
    public int conteo;
    public int prioridad;
    public T dato;

    public Tuple(T dato, int prioridad) {
        this.conteo = contador++;
        this.prioridad = prioridad;
        this.dato = dato;
    }

    @Override
    public int compareTo(Tuple<T> otro) {
        // Primero comparar prioridad
        int cmp = Integer.compare(this.prioridad, otro.prioridad);

        if (cmp != 0) {
            return cmp;
        }

        // Si prioridad es igual, comparar por dato
        cmp = this.dato.compareTo(otro.dato);

        if (cmp != 0) {
            return cmp;
        }

        // Como último criterio, usar conteo (para desempate)
        return Integer.compare(this.conteo, otro.conteo);
    }

    @Override
    public String toString() {
        return "(" + dato + ", prioridad=" + prioridad + ", conteo=" + conteo + ")";
    }
}
