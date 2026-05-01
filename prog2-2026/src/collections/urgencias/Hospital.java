package collections.urgencias;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Hospital {
    private LinkedList<Paciente> pacientes;
    private ArrayList<Especialista> especialistas;
    private HashMap<Especialidad, ArrayList<Especialista>> especialistasPorEspecialidad;

    public Hospital() {
        pacientes = new LinkedList<Paciente>();
        especialistas = new ArrayList<Especialista>();
        especialistasPorEspecialidad = new HashMap<Especialidad, ArrayList<Especialista>>();
    }

    public LinkedList<Paciente> getPacientes() {
        return pacientes;
    }

    public ArrayList<Especialista> getEspecialistas() {
        return especialistas;
    }

    public HashMap<Especialidad, ArrayList<Especialista>> getEspecialistasPorEspecialidad() {
        return especialistasPorEspecialidad;
    }

    public void setPacientes(LinkedList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public void setEspecialistas(ArrayList<Especialista> especialistas) {
        this.especialistas = especialistas;
    }

    public void setEspecialistasPorEspecialidad(
            HashMap<Especialidad, ArrayList<Especialista>> especialistasPorEspecialidad) {
        this.especialistasPorEspecialidad = especialistasPorEspecialidad;
    }

    public void addPaciente(Paciente p) {
        pacientes.add(p);
    }

    public void addEspecialista(Especialista e) {
        especialistas.add(e);
    }

    @Override
    public String toString() {
        return "Hospital -> Pacientes pendientes: " + pacientes.size()
                + " | Especialistas: " + especialistas.size()
                + " | Especialidades clasificadas: "
                + especialistasPorEspecialidad.size();
    }
}
