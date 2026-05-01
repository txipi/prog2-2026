package collections.urgencias;

class Paciente {
    private String nombre;
    private int edad;
    private Gravedad gravedad;
    private Especialidad especialidad;

    public Paciente(String nombre, int edad, Gravedad gravedad, Especialidad especialidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.gravedad = gravedad;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Gravedad getGravedad() {
        return gravedad;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setGravedad(Gravedad gravedad) {
        this.gravedad = gravedad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años, " + gravedad + ", " + especialidad + ")";
    }
}
