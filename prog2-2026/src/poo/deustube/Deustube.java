package poo.deustube;

import java.util.ArrayList;

public class Deustube {

	public static void mostrarVideos(ArrayList<Canal> canales) {
		/*
		 * for canal in canales:
		 *   for video in canal["videos"]:
		 *     print(video)
		 */
		for (Canal canal : canales) {
			for (Video video : canal.getVideos()) {
				System.out.println(video);
			}
		}
	}
	
	public static int contarLikes(Canal canal) {
		/*
		 * def contarLikes(canal: dict) -> int:
		 *   total : int = 0
		 *   for video in canal["videos"]:
		 *     total = total + video["likes"]
		 *   return total
		 */
		int total = 0;
		for (Video video : canal.getVideos()) {
			total += video.getLikes();
		}
		return total;
	}
	
	public static Canal buscarMasLikes(ArrayList<Canal> canales) {
		/*
		 * def buscarMasLikes(list[dict] canales) -> dict:
		 *   mayor = canales[0]
		 *   for canal in canales:
		 *     if (contarLikes(canal) > contarLikes(mayor)):
		 *       mayor = canal
		 *   return mayor  
		 */
		Canal mayor = canales.get(0);
		for (Canal canal : canales) {
			if (contarLikes(canal) > contarLikes(mayor)) {
				mayor = canal;
			}
		}
		return mayor;
	}
	
	public static double getDuracionTotal(ArrayList<Canal> canales) {
		double total = 0;
		
		for (Canal canal : canales) {
			for (Video video : canal.getVideos()) {
				total += video.getDuracion();
			}
		}
		
		return total;
	}
	
	public static void mostrarCanalesSeguidos(String usuario, ArrayList<Canal> canales) {
		for (Canal canal : canales) {
			// Si el usuario está en la lista de seguidores de este canal, lo imprimimos
			// if (usuario in canal["seguidores"]):
			if (canal.getSeguidores().contains(usuario)) {
				System.out.println(canal.getTitulo());
			}
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Canal> canales = new ArrayList<Canal>();
		
		// al menos 3 canales con al menos 5 seguidores y 5 vídeos cada uno
		
		for (int i = 0; i < 3; i++) {
			Canal canal = new Canal();
			canal.setUsuario("usuario-"+(i+1));
			canal.setTitulo("El canal de usuario-"+(i+1));
			for (int j = 0; j < 5; j++) {
				canal.getSeguidores().add("seguidor-"+(j+1));
			}
			for (int j = 0; j < 5; j++) {
				Video video = new Video("id"+j, "Video random "+j, Math.random() * 120, i*j, 0);
				canal.getVideos().add(video);
			}
			canales.add(canal);
		}

		System.out.println(canales);
		
		mostrarVideos(canales);
		
		System.out.println("Canal con más likes: " + buscarMasLikes(canales));
		
		System.out.println("Total de segundos en Deustube: " + getDuracionTotal(canales));
		
		mostrarCanalesSeguidos("seguidor-3", canales);
	}

}
