/**
* nombreClase: Docente.java
* descripción:
*
*
* @autores PEREDA CARRANZA, Jose Carlos Enrique
* 			  ARAUJO TEJADA, Gustavo Reinaldo
* @date: 14 set. 2024
* @version 1
*/
package Clases.Progra2;

public class Docente {
   // Atributos
   private String nombre;
   private int ID;
   private String area;
   private String tipoDeContrato;

   // Constructor vacío
   public Docente() {
   }

   public Docente(String nombre) {
       this.nombre = nombre;
       this.ID = 0;
       this.area = null;
       this.tipoDeContrato = null;
   }
   public Docente leerDocente(){
		int ID;
		String nombre,area,tipoDeContrato;

		Docente a=new Docente();
		System.out.print("Nombre ---> ");
		nombre=Leer.dato();
		a.setNombre(nombre);

		System.out.print("ID ---> ");
		ID=Leer.datoInt();
		a.setID(ID);

		System.out.print("Area   ---> ");
		area=Leer.dato();
		a.setArea(area);
		
		System.out.print("Tipo de contrato   ---> ");
		tipoDeContrato = Leer.dato();
		a.setTipoDeContrato(tipoDeContrato);
		return a;
	}
   // Constructor con dos parámetros
   public Docente(String nombre, int ID) {
       this.nombre = nombre;
       this.ID = ID;
       this.area = null;
       this.tipoDeContrato = null;
   }

   // Constructor con tres parámetros
   public Docente(String nombre, int ID, String area) {
       this.nombre = nombre;
       this.ID = ID;
       this.area = area;
       this.tipoDeContrato = null;
   }

   // Constructor completo con todos los parámetros
   public Docente(String nombre, int ID, String area, String tipoDeContrato) {
       this.nombre = nombre;
       this.ID = ID;
       this.area = area;
       this.tipoDeContrato = tipoDeContrato;
   }

   // Métodos setters
   public void setNombre(String nombre) {
       this.nombre = nombre;
   }

   public void setID(int ID) {
       this.ID = ID;
   }

   public void setArea(String area) {
       this.area = area;
   }

   public void setTipoDeContrato(String tipoDeContrato) {
       this.tipoDeContrato = tipoDeContrato;
   }

   // Métodos getters
   public String getNombre() {
       return nombre;
   }

   public int getID() {
       return ID;
   }

   public String getArea() {
       return area;
   }

   public String getTipoDeContrato() {
       return tipoDeContrato;
   }

   // Método para mostrar información del docente
   public void mostrarDocente() {
       System.out.printf("%-15s %6d %-20s %-15s\n", nombre, ID, area, tipoDeContrato);
   }

   // Sobrecarga del método para mostrar información de otro docente
   public void mostrarDocente(Docente x) {
       System.out.println(x.toString());
   }

   // Método toString sobrescrito
   @Override
   public String toString() {
       return String.format("%-15s %6d %-20s %-15s", nombre, ID, area, tipoDeContrato);
   }
}