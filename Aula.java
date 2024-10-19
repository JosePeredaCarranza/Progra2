/**
* nombreClase : Aula.java
* descripción :
*
*
* @autor HUANACUNI GOMEZ, Jean Carlos Josue
* 		 PEREDA CARRANZA, Jose Carlos Enrique
* @date: 18-10-2024
* @version 2
*/
package paqG01Proyectov3;

public class Aula {
	private int cod;
	private int horaUso;
	private int cap;
	private boolean disponible;
	
	public Aula() {
    }
	public Aula(int vcod, int vhoraUso, int vcap, boolean vdisponible) {
		cod=vcod;
		horaUso=vhoraUso;
		cap=vcap;
		disponible=vdisponible;
    }
	
	public void setCod(int vcod){
		cod=vcod;
	}
	public void setHoraUso(int vhoraUso){
		horaUso=vhoraUso;
	}
	public void setCap(int vcap){
		cap=vcap;
	}
	public void setDisponible(boolean vdisponible){
		disponible=vdisponible;
	}
	
	public int getCod(){
		return cod;
	}
	public int getHoraUso(){
		return horaUso;
	}
	public int getCap(){
		return cap;
	}
	public boolean getDisponible(){
		return disponible;
	}
	
	public Aula leerAula() {
	   	int vcod, vhora, vcap;	
	   	boolean vdisponible;
	   	System.out.print("Ingrese el codigo del aula: ");
	   	vcod = Leer.datoInt();
	   	setCod(vcod);
	   	System.out.print("Ingrese el numero de horas de uso del aula: ");
	   	vhora = Leer.datoInt();
	   	setHoraUso(vhora);
	    System.out.print("Ingrese la capacidad del aula: ");
	   	vcap = Leer.datoInt();
	   	setCap(vcap);
	   	System.out.print("Ingrese la disponibilidad del aula: ");
	   	vdisponible = Leer.datoBoolean();
	   	setDisponible(vdisponible);
	   	return this;
	}
	public void escribirAula(){
		System.out.printf("%8d %5d %5d %b\n",cod,horaUso,cap,disponible);
	}
	public void escribirAula(Aula a){
		System.out.printf("%8d %5d %5d %b\n",a.getCod(),a.getHoraUso(),a.getCap(),a.getDisponible());
	}
	public void mostrarAula(){
		 System.out.println("Codigo de aula  : " + cod);
		 System.out.println("Tiempo de uso   : " + horaUso);
		 System.out.println("Capacidad       : " + cap);
		 System.out.println("Disponibilidad  : " + disponible);
	}
	public void mostrarAula(Aula a){
		 System.out.println("Codigo de aula  : " + a.getCod());
		 System.out.println("Tiempo de uso   : " + a.getHoraUso());
		 System.out.println("Capacidad       : " + a.getCap());
		 System.out.println("Disponibilidad  : " + a.getDisponible());
	}
	 
	public String toString(){
		String cad=null;
		cad=String.format("%8d %5d %5d %b",cod,horaUso,cap,disponible);
		return cad;
	}
}
