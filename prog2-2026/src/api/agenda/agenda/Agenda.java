package api.agenda.agenda;

import java.util.ArrayList;
import java.util.Date;

import api.agenda.db.Guardar;

public class Agenda {
	protected String nombre;
	protected ArrayList<Contacto> contactos;
	protected Guardar db;
	protected Date fecha;
	
}
