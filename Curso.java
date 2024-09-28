/**
* nombreClase: Curso.java
* descripción:
*
*
* @autores PEREDA CARRANZA, Jose Carlos Enrique
* 			  ARAUJO TEJADA, Gustavo Reinaldo
* @date: 14 set. 2024
* @version 1
*/
package Clases;

public class Curso {
   // Atributos
   private int codigo;
   private String asignatura;
   private int creditos;
   private String docenteAsignado;

   public Curso() {
   }

   public Curso(int codigo, String asignatura, int creditos, String docenteAsignado) {
       this.codigo = codigo;
       this.asignatura = asignatura;
       this.creditos = creditos;
       this.docenteAsignado = docenteAsignado;
   }
   public Curso leerCurso(){
		int codigo,creditos;
		String asignatura,docenteAsignado;

		Curso c=new Curso();
		System.out.print("Asignatura ---> ");
		asignatura=Leer.dato();
		c.setAsignatura(asignatura);

		System.out.print("Codigo ---> ");
		codigo=Leer.datoInt();
		c.setCodigo(codigo);

		System.out.print("Creditos   ---> ");
		creditos=Leer.datoInt();
		c.setCreditos(creditos);
		
		System.out.print("Docente asignado   ---> ");
		docenteAsignado = Leer.dato();
		c.setDocenteAsignado(docenteAsignado);
		return c;
   }
   public void setCodigo(int codigo) {
       this.codigo = codigo;
   }

   public void setAsignatura(String asignatura) {
       this.asignatura = asignatura;
   }

   public void setCreditos(int creditos) {
       this.creditos = creditos;
   }

   public void setDocenteAsignado(String docenteAsignado) {
       this.docenteAsignado = docenteAsignado;
   }

   public int getCodigo() {
       return codigo;
   }

   public String getAsignatura() {
       return asignatura;
   }

   public int getCreditos() {
       return creditos;
   }

   public String getDocenteAsignado() {
       return docenteAsignado;
   }

   public void mostrarCurso() {
       System.out.printf("%-6d %-25s %5d %-20s\n", getCodigo(), getAsignatura(), getCreditos(), getDocenteAsignado());
   }

   @Override
   public String toString() {
       return String.format("%-6d %-25s %5d %-20s", getCodigo(), getAsignatura(), getCreditos(), getDocenteAsignado());
   }
}