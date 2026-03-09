package poo.ludo;

public class Libro extends Recurso implements Reservable {
	protected String titulo; 
	protected String autoria;
	protected String genero;
	
	@Override
	public boolean reservar(Usuaria usuaria) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean anular(Usuaria usuaria) {
		// TODO Auto-generated method stub
		return false;
	}
}
