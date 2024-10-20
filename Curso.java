/**
* nombreClase : Curso.java
* descripción :
*
*
* @autor HUANACUNI GOMEZ, Jean Carlos Josue
* 		 PEREDA CARRANZA, Jose Carlos Enrique
* @date: 18-10-2024
* @version 2
*/
package paqG01Proyectov3;
import java.util.Random;

public class Curso {
	private int codCurso;
	private NombreCurso nombre;
	private int seccion;
	private Docente docente;
	private Alumno[] alumnos;
	private double pc[];
	private double eparcial;
	private double efinal;
	private int dimAl;
	private final static int minAl=5;
	private final static int maxAl=8;
	private final static int numPrac=10;

	public Curso() {
    }
	public Curso(int vcodCurso, NombreCurso vNombre, int vseccion, Alumno[] valumnos, 
					double vpc[], double veparcial, double vefinal) {
		codCurso=vcodCurso;
		nombre=vNombre;
		seccion=vseccion;
		alumnos=valumnos;
		pc=vpc;
		eparcial=veparcial;
		efinal=vefinal;
	}
	
	public void setCodCurso(int vcodCurso){
		codCurso=vcodCurso;
	}
	public void setNombre(NombreCurso vNombre){
		nombre=vNombre;
	}
	public void setSeccion(int vSeccion){
		seccion=vSeccion;
	}
	public void setDocente(Docente vDocente){
		docente=vDocente;
	}
	public void setAlumnos(Alumno[] val){
		alumnos=val;
	}
	public void setPc(double vpc[]){
		pc=vpc;
	}
	public void setParcial(double veparcial){
		eparcial=veparcial;
	}
	public void setFinal(double vefinal){
		efinal=vefinal;
	}
	
	public int getVacante(){
		return maxAl-dimAl;
	}
	public int getDimAl(){
		return dimAl;
	}
	public int getCodCurso(){
		return codCurso;
	}
	public NombreCurso getNombre(){
		return nombre;
	}
	public int getSeccion(){
		return seccion;
	}
	public Docente getDocente(){
		return docente;
	}
	public Alumno[] getAlumnos(){
		return alumnos;
	}
	public double[] getPc(){
		return pc;
	}
	public double getParcial(){
		return eparcial;
	}
	public double getFinal(){
		return efinal;
	}
	
	public Curso leerCurso(){
		int vcodCurso;
		NombreCurso vnombre;
		int vseccion;
		Docente vdocente;
		
		System.out.print("Ingrese el codigo del curso: ");
		vcodCurso = Leer.datoInt();
		setCodCurso(vcodCurso);
	   	
		System.out.println("Seleccione el nombre del curso: ");
	    for (int i = 0; i < NombreCurso.values().length; i++) {
	        System.out.println((i + 1) + ". " + NombreCurso.values()[i].getNombre());
	    }
	    int opcionNombre = Leer.datoInt();
	    while (opcionNombre < 1 || opcionNombre > NombreCurso.values().length) {
	        System.out.println("Opción inválida. Ingrese un número entre 1 y " + NombreCurso.values().length + ": ");
	        opcionNombre = Leer.datoInt();
	    }	    
	    vnombre = NombreCurso.values()[opcionNombre - 1];
	    setNombre(vnombre);
	    
		System.out.print("Ingrese la seccion del curso: ");
		vseccion = Leer.datoInt();
		setSeccion(vseccion);
		
		System.out.println("Ingrese el docente: ");
		Docente aux = new Docente();
		vdocente = aux.leerPersona();
		setDocente(vdocente);
		
		//LEER ALUMNOS
		System.out.println("Ingrese la cantidad de alumnos en la sección (entre " + minAl + " y " + maxAl + "): ");
        dimAl = Leer.datoInt();
        while (dimAl < minAl || dimAl > maxAl) {
            System.out.println("Cantidad inválida. Ingrese un número entre " + minAl + " y " + maxAl + ": ");
            dimAl = Leer.datoInt();
        }
        Alumno[] vAl =new Alumno[dimAl];
        Alumno temp = new Alumno();
        for (int i = 0; i < dimAl; i++) {
        	System.out.println("\t\t ALUMNO " + i+1);
        	vAl[i] = temp.leerPersona();
        }
        setAlumnos(vAl);
		
        generarNotasAleatorias();
	   	
		return this;
	}
    public void generarNotasAleatorias() {
        Random rand = new Random();
        for (Alumno alum : alumnos) {
            double[] practicas = new double[numPrac];
            for (int i = 0; i < numPrac; i++) {
                practicas[i] = rand.nextDouble() * 20;
            }
            setPc(practicas);
        }
        eparcial = rand.nextDouble() * 20;
        efinal = rand.nextDouble() * 20;
    }
    public void agregarAlumno(Alumno A){
		if(dimAl+1>=maxAl) {
			System.out.println("Curso lleno...");
		}
		else {
			redimensionar(dimAl+1,1);
			alumnos[dimAl-1]=new Alumno();
			alumnos[dimAl-1]=A;
		}
	}
	public void redimensionar(int tam,int n){
		int i;
		Alumno[] Aux=new Alumno[tam];
		for(i=0;i<tam-n;i++ ){
			Aux[i]=alumnos[i];
		}
		dimAl=tam;
		alumnos=Aux;
	}
    public double calcularPromedioAlumno() {
        double promPracticas;
        Random rand = new Random();
    	double sumaPracticas = 0;
        double pracMenor = 21;
        for (int i = 0; i < pc.length; i++) {
            sumaPracticas = sumaPracticas + pc[i];
            if(pc[i]<=pracMenor) {
            	pracMenor =pc[i];
            }
        }
        sumaPracticas = sumaPracticas - pracMenor;
        promPracticas = sumaPracticas / numPrac-1;
        eparcial = rand.nextDouble() * 20;
        efinal = rand.nextDouble() * 20;
        double promedioFinal = (promPracticas + eparcial + efinal)/3;
        return promedioFinal;
    }
    public void mejorPromedioCurso() {
        double mejorPromedio = 0;
        Alumno mejorAlumno = null;

        for (int i = 0; i < alumnos.length; i++) {
            Alumno alumno = alumnos[i];
            double promedio = calcularPromedioAlumno();
            if (promedio > mejorPromedio) {
                mejorPromedio = promedio;
                mejorAlumno = alumno;
            }
        }
        System.out.println("El mejor promedio del curso es: " + mejorPromedio + " - Alumno: " + mejorAlumno.getNombre());
    }
    
	public void encabezado0() {
		for(int i = 0; i<60; i++) {
			System.out.printf("=");
		}
		System.out.println();
	}
	public void encabezado2() {
		for(int i = 0; i<60; i++) {
			System.out.printf("-");
		}
		System.out.println();
	}
	public void encabezado1() {
		String cod = "COD. CURSO";
		String nom = "NOMBRE. CURSO";
		String sec = "SECCION";
		String prof = "PROFESOR";
		String alum = "ALUMNOS MATRICULADOS";
		encabezado0();
		System.out.printf("%-10s %-15s %-8s %25s %-22s \n", cod,nom,sec,prof,alum);
		encabezado2();
	}
	public void escribirCurso() {
		String cad2=String.format("%s %s %s",docente.apat,docente.amat,docente.nombre);
		encabezado1();
		System.out.printf("%5d %-15s %5d %s { %s }",codCurso,nombre,seccion,cad2,alumnos);
		encabezado2();
	}
	public void escribirCurso(Curso a) {
		String cad2=String.format("%s %s %s",a.getDocente().getApat(),
				a.getDocente().getAmat(),a.getDocente().getNombre());
		encabezado1();
		System.out.printf("%5d %-15s %5d %s { %s }",a.getCodCurso(),a.getNombre(),
				a.getSeccion(),cad2,a.getAlumnos());
		encabezado2();
	}
	public void mostrarCurso(){
		System.out.println("Cod Curso    : " + codCurso);
		System.out.println("Nombre curso : " + nombre);
		System.out.println("Seccion      : " + seccion);
		System.out.println("Profesor     : " + docente.apat + docente.amat + docente.nombre);
		System.out.println("Alumnos      : " + alumnosdelCuso());
	}
	public void mostrarCurso(Curso a){
		System.out.println("Cod Curso    : " + a.getCodCurso());
		System.out.println("Nombre curso : " + a.getNombre());
		System.out.println("Seccion      : " + a.getSeccion());
		System.out.println("Profesor     : " + a.getDocente().getApat() + a.getDocente().getAmat()
				+ a.getDocente().getNombre());
		System.out.println("Alumnos      : " + a.alumnosdelCuso());
	}
	public String alumnosdelCuso() {
		String cad=null;
		String cad1=null;
		cad = String.format("{");
		for(int i=0; i<alumnos.length;i++) {
			cad1 = String.format("%s %s %s ",alumnos[i].getApat(),alumnos[i].getAmat(),alumnos[i].getNombre());
			if(i<alumnos.length) {
				cad = cad  + cad1 + ",";
			}
			else {
				cad = cad  + cad1;
			}
		}
		return cad + "}";
	}
	public String toString(){
		String cad=null;
		String cad2=null;
		cad2=String.format("%s %s %s",docente.apat,docente.amat,docente.nombre);
		cad=String.format("%8d %-15s %5d %s %s",codCurso,nombre,seccion,cad2,alumnosdelCuso());
		return cad;
	}
}
