public class Luchador implements Comparable<Luchador>{
    private int fuerza;
    private String nombre;
    public Luchador(int fuerza, String nombre){
        this.fuerza = fuerza;
        this.nombre = nombre;
    }

    public int getFuerza(){
        return this.fuerza;
    }
    public String getNombre(){
        return this.nombre;
    }


    public void luchar(Luchador o){
        this.fuerza -= o.fuerza;
    }
    @Override
    public int compareTo(Luchador o) {
        return Integer.compare(this.fuerza,o.fuerza);
    }
}
