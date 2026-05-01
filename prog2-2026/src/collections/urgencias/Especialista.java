package collections.urgencias;

import java.util.LinkedList;

class Especialista {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private Especialidad especialidad;
    private int horas;
    private LinkedList<Paciente> pacientes;

    public Especialista(String nombre, Especialidad especialidad, int horas) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.horas = horas;
        this.pacientes = new LinkedList<Paciente>();
    }

    public String getNombre() {
        return nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public int getHoras() {
        return horas;
    }

    public LinkedList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public void setPacientes(LinkedList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public void addPaciente(Paciente p) {
        pacientes.add(p);
    }

    @Override
    public String toString() {
        return nombre + " - " + especialidad +
               " | Horas trabajadas: " + horas +
               " | Pacientes en cola: " + pacientes.size();
    }
}
