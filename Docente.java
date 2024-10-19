/**
* nombreClase : Docente.java
* descripción :
*
*
* @autor HUANACUNI GOMEZ, Jean Carlos Josue
* 		 PEREDA CARRANZA, Jose Carlos Enrique
* @date: 18-10-2024
* @version 3
*/
package paqG01Proyectov3;

public class Docente extends Persona {
	private int id;
	private String curso;
	private int seccion;
	
	public Docente(){
		super();
	}
	public Docente(String dni,String apat,String amat,String nombre,int edad,String sexo,int vid, String vcurso, int vseccion) {
		super(dni,apat,amat,nombre,edad,sexo);
		id = vid;
		curso = vcurso;
		seccion = vseccion;
	}

	public void setId(int vcod){
		id = vcod;
	}
	public void setCurso(String vcurso){
		curso = vcurso;
	}
	public void setSeccion(int vseccion){
		seccion = vseccion;
	}
	public int getId(){
		return id;
	}
	public String getCurso(){
		return curso;
	}
	public int getSeccion(){
		return seccion;
	}
   
	public Persona leerPersona(){
		super.leerPersona();
		int vid, vseccion;
		String vcurso;
		System.out.print("Id          : ");
		vid=Leer.datoInt();
		setId(vid);
		System.out.print("Curso       : ");
		vcurso=Leer.dato();
		setCurso(vcurso);
		System.out.print("Seccion     : ");
		vseccion=Leer.datoInt();
		setSeccion(vseccion);
	   
		return this;
	}
	public void escribirPersona(){
		super.escribirPersona();
		System.out.printf("%5d %-20s %5d\n",id,curso,seccion);
	}
	public void escribirPersona(Docente a){
		super.escribirPersona();
		System.out.printf("%5d %-20s %5d\n",a.getId(),a.getCurso(),a.getSeccion());
	}
	public void mostrarPersona(){
		super.mostrarPersona();
		System.out.println("Id          : " + id);
		System.out.println("Curso       : " + curso);
		System.out.println("Seccion     : " + seccion);
	}
	public void mostrarPersona(Docente a){
		super.mostrarPersona();
		System.out.println("Id          : " + a.getId());
		System.out.println("Curso       : " + a.getCurso());
		System.out.println("Seccion     : " + a.getSeccion());
	}
	public String toString(){
		String cad=null;
		String superclase = super.toString();
		cad=String.format(" %s %5d %-20s %5d\n",superclase,id,curso,seccion);
		return(cad);
	}	
}
