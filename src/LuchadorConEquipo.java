public class LuchadorConEquipo implements Comparable<LuchadorConEquipo>{
    private int fuerza;
    private String nombre;
    private String nombreEquipo;

    public LuchadorConEquipo(int fuerza, String nombre, String nombreEquipo){
        this.fuerza = fuerza;
        this.nombre = nombre;
        this.nombreEquipo = nombreEquipo;
    }

    public int getFuerza(){
        return this.fuerza;
    }
    public String getNombre(){
        return this.nombre;
    }

    public String getEquipo(){
        return this.nombreEquipo;
    }

    public void luchar (LuchadorConEquipo o ){
        this.fuerza -= o.getFuerza();
    }

    @Override
    public int compareTo(LuchadorConEquipo o) {
        return Integer.compare(this.fuerza, o.getFuerza());
    }
}
