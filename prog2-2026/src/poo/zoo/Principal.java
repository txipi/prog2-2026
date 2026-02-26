package poo.zoo;

public class Principal {

	public static void main(String[] args) {
		Ave truz = new Ave("Truz", 0.5, false);
		Ave triz = new Ave(truz);
		triz.setNombre("Triz");
		Ave nada = new Ave();
		
		System.out.println(truz);
		System.out.println(triz);
		System.out.println(nada);
		
		
		Zoo zooBilbao = new Zoo();
		zooBilbao.setNombre("Zoo de Bilbao");
		
		System.out.println(zooBilbao);
		zooBilbao.getAnimales().add(truz);
		zooBilbao.getAnimales().add(triz);
		System.out.println(zooBilbao);
		
		if (truz instanceof Ave) {
			System.out.println("Truz es un ave");
		}
		
		if (truz instanceof Animal) {
			System.out.println("Truz es un animal");
		}
		
		if (truz instanceof Object) {
			System.out.println("Truz es un objeto de Java");
		}
		
		Mamifero leon = new Mamifero("Leoncio", 3, 3);
		zooBilbao.getAnimales().add(leon);
	}

}
