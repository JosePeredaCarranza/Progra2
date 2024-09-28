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
package Clases.Progra2;


public class Alumno extends Persona{
	private int cod;
	private double nota;
	private boolean estado;
	public Alumno(){
		super();
	}
	public Alumno(String dni,String apat,String amat,String nombre,int edad,String sexo,int vcod, double vnota, boolean vestado) {
		super(dni,apat,amat,nombre,edad,sexo);
		cod=vcod;
		nota=vnota;
		estado = vestado;
	}

   public void setCod(int vcod){
   	cod=vcod;
   }
   public void setNota(double vnota){
   	nota=vnota;
   }
   public void setEstado(boolean vestado){
   	estado = vestado;
   }

   public int getCod(){
   	return cod;
   }
   public double getNota(){
   	return nota;
   }
   public boolean getEstado(){
   	return estado;
   }
   public Persona leerPersona(){
	   super.leerPersona();
	   int codigo;
	   double nota;
	   boolean estado;
	   System.out.print("Codigo ---> ");
	   codigo=Leer.datoInt();
	   setCod(codigo);
	   
	   System.out.print("Nota   ---> ");
	   nota=Leer.datoDouble();
	   setNota(nota);
		
	   System.out.print("Estado   ---> ");
	   estado=Leer.datoBoolean();
	   setEstado(estado);
	   return (this);
	}
   public void mostrarAlu(){
	   super.mostrarPersona();
	   System.out.println("Codigo     : " + cod);
		System.out.println("Nota       : " + nota);
		System.out.println("Estado     : " + estado);
   }
   public void mostrarAlu(Alumno x){
	   super.mostrarPersona();
	   System.out.println(x.toString());
   }
   public String toString(){
	   String cad=null;
	   String superclase = super.toString();
	   cad=String.format(" %s %6d %10.1f%14b\n",superclase,cod,nota,estado);
	   return(cad);
   }
}