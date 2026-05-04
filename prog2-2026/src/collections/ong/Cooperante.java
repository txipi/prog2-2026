package collections.ong;

class Cooperante {

    private String dni;
    private String nombre;
    private Area especialidad;
    private int experiencia;

    public Cooperante(String dni, String nombre, Area especialidad, int experiencia) {
        this.dni = dni;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.experiencia = experiencia;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public Area getEspecialidad() {
        return especialidad;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecialidad(Area especialidad) {
        this.especialidad = especialidad;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public String toString() {
        return nombre + " (" + dni + ") - " + especialidad +
               " - " + experiencia + " años exp.";
    }
}

