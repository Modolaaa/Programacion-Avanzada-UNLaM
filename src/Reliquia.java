public class Reliquia implements Comparable<Reliquia>{

    public int fuerza;
    public String nombre;
    
    public Reliquia(int fuerza, String nombre){
        this.fuerza = fuerza;
        this.nombre = nombre; 
    }

    @Override
    public int compareTo(Reliquia o) {
        return Integer.compare(this.fuerza, o.fuerza);
    }
}
