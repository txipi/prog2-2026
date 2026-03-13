package poo.deustotravel;

import java.util.ArrayList;
import java.util.Arrays;

public class DeustoTravel {

	public static void main(String[] args) {
		ArrayList<Transporte> transportes = new ArrayList<>();

        // Añadiendo Avionetas (Capacidad, Peso en kg, Ratio de planeo)
		transportes.add(new Avioneta(4, 1100.0, 9.5));
		transportes.add(new Avioneta(6, 1600.5, 10.2));
		transportes.add(new Avioneta(2, 750.0, 8.0));
		transportes.add(new Avioneta(8, 2200.0, 12.0));
		transportes.add(new Avioneta(5, 1350.0, 11.1));

        // Añadiendo Barcos (Capacidad, Calado en metros, ¿Es diesel?)
		transportes.add(new Barco(12, 0.8, false)); // Lancha rápida (gasolina)
		transportes.add(new Barco(25, 1.5, true));  // Catamarán pequeño
		transportes.add(new Barco(40, 2.2, true));  // Barco de avistamiento
		transportes.add(new Barco(10, 0.6, false)); // Bote de recreo
		transportes.add(new Barco(50, 2.8, true));  // Ferry turístico
		
		// Tramos Aéreos (Usando Avionetas de transportes)
        Trayecto tAereo_TFE_LPA = new Trayecto(28.48, -16.34, 27.93, -15.38, 110.0, transportes.get(1));
        Trayecto tAereo_LPA_FUE = new Trayecto(27.93, -15.38, 28.45, -13.86, 160.0, transportes.get(3));
        Trayecto tAereo_TFE_VDE = new Trayecto(28.48, -16.34, 27.81, -17.88, 175.0, transportes.get(4));
        Trayecto tAereo_FUE_ACE = new Trayecto(28.45, -13.86, 28.95, -13.60, 60.0, transportes.get(0));

        // Tramos Marítimos (Usando Barcos de transportes)
        Trayecto tMar_Corralejo_Lobos = new Trayecto(28.73, -13.86, 28.75, -13.82, 5.0, transportes.get(8));
        Trayecto tMar_PlayaBlanca_Lobos = new Trayecto(28.86, -13.83, 28.75, -13.82, 15.0, transportes.get(5));
        Trayecto tMar_LosGigantes_Avistamiento = new Trayecto(28.02, -16.71, 28.00, -16.80, 12.0, transportes.get(7));
        Trayecto tMar_SCTenerife_Agaete = new Trayecto(28.47, -16.24, 28.10, -15.70, 70.0, transportes.get(9));
        Trayecto tMar_Arguineguin_PuertoMogan = new Trayecto(27.75, -15.60, 27.81, -15.76, 18.0, transportes.get(6));

        ArrayList<Excursion> excursiones = new ArrayList<>();

        // 1. Combinada: Tenerife -> Gran Canaria (Aire) + Costa Mogán (Mar)
        excursiones.add(new Excursion("Pack Capitales y Costa", 
            new ArrayList<>(Arrays.asList(tAereo_TFE_LPA, tMar_Arguineguin_PuertoMogan)), true));

        // 2. Gran Tour Oriental: GC -> Fuerteventura -> Lanzarote (Todo Aire)
        excursiones.add(new Excursion("Triángulo Oriental Aéreo", 
            new ArrayList<>(Arrays.asList(tAereo_LPA_FUE, tAereo_FUE_ACE)), false));

        // 3. Ruta de Volcanes y Lobos: Lanzarote -> Fuerteventura -> Isla de Lobos
        excursiones.add(new Excursion("Expedición Volcán y Arena", 
            new ArrayList<>(Arrays.asList(tAereo_FUE_ACE, tMar_Corralejo_Lobos)), true));

        // 4. Salto de Islas VIP: Tenerife -> El Hierro -> Tenerife (Aire + Mar local)
        excursiones.add(new Excursion("El Hierro Relax", 
            new ArrayList<>(Arrays.asList(tAereo_TFE_VDE, tMar_LosGigantes_Avistamiento)), true));

        // 5. Inter-Island Express: GC -> Tenerife -> GC (Barco Ferry)
        excursiones.add(new Excursion("Ferry Day Trip", 
            new ArrayList<>(Arrays.asList(tMar_SCTenerife_Agaete, tMar_SCTenerife_Agaete)), false));

        // 6. Super Tour (3 trayectos): Tenerife -> GC -> Fuerteventura -> Lobos
        excursiones.add(new Excursion("Transcanaria Este", 
            new ArrayList<>(Arrays.asList(tAereo_TFE_LPA, tAereo_LPA_FUE, tMar_Corralejo_Lobos)), true));

        // 7. Aventura en el Estrecho: Lanzarote -> Lobos -> Fuerteventura
        excursiones.add(new Excursion("Cruce de la Bocaina", 
            new ArrayList<>(Arrays.asList(tMar_PlayaBlanca_Lobos, tMar_Corralejo_Lobos)), true));

        // 8. Safari Fotográfico: Avistamiento + Costa Sur Tenerife
        excursiones.add(new Excursion("Safari Azul Tenerife", 
            new ArrayList<>(Arrays.asList(tMar_LosGigantes_Avistamiento, tMar_LosGigantes_Avistamiento)), false));

        // 9. Tour 4 Islas (4 trayectos): El Hierro -> Tenerife -> GC -> Fuerteventura
        excursiones.add(new Excursion("Mega Tour 4 Islas", 
            new ArrayList<>(Arrays.asList(tAereo_TFE_VDE, tAereo_TFE_LPA, tAereo_LPA_FUE)), true));

        // 10. Conexión Playa: Mogán -> GC -> Fuerteventura
        excursiones.add(new Excursion("Sol y Playa Connect", 
            new ArrayList<>(Arrays.asList(tMar_Arguineguin_PuertoMogan, tAereo_LPA_FUE)), false));

        // 11. La Graciosa Experience (Simulado con tramos similares)
        excursiones.add(new Excursion("Norte Salvaje", 
            new ArrayList<>(Arrays.asList(tAereo_FUE_ACE, tMar_PlayaBlanca_Lobos)), true));

        // 12. Circuito Occidental: Tenerife -> El Hierro (Aire) + Salto Aéreo
        excursiones.add(new Excursion("Ruta del Meridiano", 
            new ArrayList<>(Arrays.asList(tAereo_TFE_VDE, tAereo_TFE_VDE)), false));

        // 13. Full Day Marítimo: Agaete -> Tenerife -> Avistamiento
        excursiones.add(new Excursion("Día de Océano", 
            new ArrayList<>(Arrays.asList(tMar_SCTenerife_Agaete, tMar_LosGigantes_Avistamiento)), true));

        // 14. Tour de Lujo (5 trayectos): Una odisea completa
        excursiones.add(new Excursion("La Gran Odisea Canaria", 
            new ArrayList<>(Arrays.asList(tAereo_TFE_VDE, tAereo_TFE_LPA, tAereo_LPA_FUE, tAereo_FUE_ACE, tMar_Corralejo_Lobos)), true));

        // 15. Short Hop: Fuerteventura -> Lanzarote -> Fuerteventura
        excursiones.add(new Excursion("Salto del Chinijo", 
            new ArrayList<>(Arrays.asList(tAereo_FUE_ACE, tAereo_FUE_ACE)), false));
        
        ArrayList<Guia> guias = new ArrayList<>();
        
        guias.add(new Guia("Aday Santana", 120.50, 8, true));     // Senderismo en Anaga
        guias.add(new Guia("Idaira Ruiz", 250.00, 20, false));    // Tour cultural Las Palmas
        guias.add(new Guia("Yeray Díaz", 85.00, 4, true));        // Guía privado Timanfaya
        guias.add(new Guia("Naira Betancort", 150.00, 12, true)); // Ruta de los volcanes
        guias.add(new Guia("Jonay Perdomo", 300.00, 25, false));  // Grupo grande Teide
        guias.add(new Guia("Yaiza Martín", 110.00, 6, true));     // Avistamiento desde costa
        guias.add(new Guia("Gara López", 95.00, 5, true));        // Cueva de los Verdes
        guias.add(new Guia("Rayco Torres", 180.00, 15, false));   // Garajonay profundo
        guias.add(new Guia("Guacimara Gil", 210.00, 18, true));   // Tour histórico La Laguna
        guias.add(new Guia("Nauzet Sosa", 135.00, 10, false));    // Salinas de Fuencaliente

        System.out.println(transportes);
        
        System.out.println(guias);
        
        System.out.println(Excursion.getExcursionMasCara(excursiones));
	}

}
