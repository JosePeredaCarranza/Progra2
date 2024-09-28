/**
* nombreClase: Alumno.java
* descripción:
*
*
* @autores PEREDA CARRANZA, Jose Carlos Enrique
* 			  ARAUJO TEJADA, Gustavo Reinaldo
* @date: 10 set. 2024
* @version 1
*/
package Clases;


public class Alumno {
	private int cod;
	private String nom;
	private float nota;
	private boolean estado;
	public Alumno(){
	}
	public Alumno(int vcod){
		cod=vcod;
		nom=null;
		nota=0.0F;
		estado = true;
	}
	public Alumno(int vcod, String vnom){
		cod=vcod;
		nom=vnom;
		nota=0.0F;
		estado = true;
	}
	public Alumno(int vcod, String vnom, float vnota) {
		cod=vcod;
		nom=vnom;
		nota=vnota;
		estado = true;
   }
	public Alumno(int vcod, String vnom, float vnota, boolean vestado) {
		cod=vcod;
		nom=vnom;
		nota=vnota;
		estado = vestado;
	}

   public void setCod(int vcod){
   	cod=vcod;
   }
   public void setNom(String vnom){
   	nom=vnom;
   }
   public void setNota(float vnota){
   	nota=vnota;
   }
   public void setEstado(boolean vestado){
   	estado = vestado;
   }

   public int getCod(){
   	return cod;
   }
   public String getNom(){
   	return nom;
   }
   public float getNota(){
   	return nota;
   }
   public boolean getEstado(){
   	return estado;
   }
   public Alumno leerAlumno(){
		int codigo;
		String nombre;
		float nota;
		boolean estado;
		Alumno a=new Alumno();
		System.out.print("Codigo ---> ");
		codigo=Leer.datoInt();
		a.setCod(codigo);

		System.out.print("Nombre ---> ");
		nombre=Leer.dato();
		a.setNom(nombre);

		System.out.print("Nota   ---> ");
		nota=Leer.datoFloat();
		a.setNota(nota);
		
		System.out.print("Estado   ---> ");
		estado=Leer.datoBoolean();
		a.setEstado(estado);
		return a;
	}
   public void mostrarAlu(){
   	System.out.printf("%6d %-15s%10.1f%14b\n",cod,nom,nota,estado);
   }
   public void mostrarAlu(Alumno x){
   	System.out.println(x.toString());
   }
   public String toString(){
   	String cad=null;
   	cad=String.format("%6d %-15s%10.1f%14b\n",cod,nom,nota,estado);
   	return(cad);
   }
}