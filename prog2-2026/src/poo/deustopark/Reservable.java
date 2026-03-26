package poo.deustopark;

public interface Reservable {
	public boolean reservar(Visitante v);
	public boolean cancelar(Visitante v);
}
