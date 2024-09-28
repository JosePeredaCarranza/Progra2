package Clases;

public class TMain {
	public static void main(String args[]) {
		Alumno prueba = new Alumno("76905373","PEREDA","CARRANZA","Jose",20,"Masculino",23200044,14,true);
		Alumno prueba1 = new Alumno("73232233","HUANACUNI","GOMEZ","Jean",19,"Masculino",23200181,13,true);
		//prueba.mostrarAlu();
		VectorAlumno a=new VectorAlumno();
		Alumno valum [] = new Alumno[12];
		a.agregarAlumno(prueba);
		a.agregarAlumno(prueba1);
		a.mostrarVector();
		//valum = a.leerVector();
		a.mostrarVector(valum);
	}
}
