package poo.universidad;

public class Principal {

	public static void main(String[] args) {
		Grado cdia = new Grado();
		cdia.setNombre("Ciencia de datos");
		
		Grado inf = new Grado();
		inf.setNombre("Infomática");
		
		Asignatura calculo = new Asignatura("Calculo", "0001", 1, 6);
		Asignatura prog = new Asignatura("Programacion", "0002", 1, 6);
		Asignatura ico = new Asignatura("ICO", "0003", 1, 6);
		Asignatura algebra = new Asignatura("Algebra", "0004", 1, 6);
		Asignatura electronica = new Asignatura("Electronica", "0005", 1, 6);
		Asignatura fundamentos = new Asignatura("Fundamentos Físicos", "0006", 1, 6);
		Asignatura ade = new Asignatura("ADE", "0007", 1, 6);
		
		Estudiante estudiante1 = new Estudiante();
		
		estudiante1.setNombre("Ane López");
		estudiante1.setDni("12345678Z");
		estudiante1.setCurso(1);
		estudiante1.getMatricula().add(calculo);
		estudiante1.getMatricula().add(prog);
		estudiante1.getMatricula().add(ico);
		estudiante1.getMatricula().add(algebra);
		estudiante1.getMatricula().add(electronica);
		
		cdia.getEstudiantes().add(estudiante1);

		Estudiante estudiante2 = new Estudiante();
		
		estudiante2.setNombre("Jon García");
		estudiante2.setDni("999123123B");
		estudiante2.setCurso(1);
		estudiante2.getMatricula().add(calculo);
		estudiante2.getMatricula().add(prog);
		estudiante2.getMatricula().add(ico);
		estudiante2.getMatricula().add(algebra);
		estudiante2.getMatricula().add(ade);
		estudiante2.getMatricula().add(fundamentos);
		
		inf.getEstudiantes().add(estudiante2);
		
		calculo.setNombre("Cálculo");
		
		System.out.println(cdia);
	}

}
