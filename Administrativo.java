/**
* nombreClase: Administrativo.java
* descripción:
*
*
* @autores PEREDA CARRANZA, Jose Carlos Enrique
* 			  ARAUJO TEJADA, Gustavo Reinaldo
* @date: 10 set. 2024
* @version 1
*/
package Clases;

public class Administrativo {
	private String nombre;
	private int id;
	private String cargo;
	private String email;
	public Administrativo(){
	}
	public Administrativo(String nombre){
		this.nombre = nombre;
		id = 0;
		cargo = null;
		email = null;
	}
	public Administrativo(String nombre, int id){
		this.nombre = nombre;
		this.id = id;
		cargo = null;
		email = null;
	}
	public Administrativo(String nombre, int id, String cargo){
		this.nombre = nombre;
		this.id = id;
		this.cargo = cargo;
		email = null;
	}
	public Administrativo(String nombre, int id, String cargo, String email){
		this.nombre = nombre;
		this.id = id;
		this.cargo = cargo;
		this.email = email;
	}
	//Setters
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	public void setId(int id){
   	this.id = id;
   }
	public void setCargo(String cargo){
	   this.cargo = cargo;
	}
	public void setEmail(String email){
	   this.email = email;
	}
	//Getters
	public String getNombre(){
		return nombre;
	}
	public int getId(){
		return id;
	}
	public String getCargo(){
		return cargo;
	}
	public String getEmail(){
		return email;
	}
	public Administrativo leerAdministrativo(){
		String nombre;
		int id;
		String cargo;
		String email;
		Administrativo a=new Administrativo();
		System.out.print("Nombre ---> ");
		nombre = Leer.dato();
		a.setNombre(nombre);

		System.out.print("Identificación ---> ");
		id=Leer.datoInt();
		a.setId(id);

		System.out.print("Cargo   ---> ");
		cargo = Leer.dato();
		a.setCargo(cargo);
		
		System.out.print("Email   ---> ");
		email = Leer.dato();
		a.setEmail(email);
		return a;
	}
	public void mostrarAdministrativo(){
	   System.out.printf("%6s %-15d%10s%14s\n",nombre,id,cargo,email);
	}
	public void mostrarAdministrativo(Administrativo x){
	   System.out.println(x.toString());
	}
	public String toString(){
		String cad=null;
	   cad=String.format("%6s %-15d%10s%14s\n",nombre,id,cargo,email);
	   return(cad);
	}
}
