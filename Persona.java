/**
* nombreClase : Persona.java
* descripción :
*
*
* @autor HUANACUNI GOMEZ, Jean Carlos Josue
* @date: 24-09-2024
* @version 1
*/
package Clases;

public class Persona {
	protected String dni;
	protected String apat;
	protected String amat;
	protected String nombre;
	protected int edad;
	protected String sexo;

	public Persona(){
	}
	public Persona(String vdni, String vapat,String vamat, String vnom, int vedad, String vsexo){
		dni=vdni;
		apat=vapat;
		amat=vamat;
		nombre=vnom;
		edad=vedad;
		sexo=vsexo;
	}
	public void setDni(String vdni){
		dni=vdni;
	}
	public void setApat(String vapat){
		apat = vapat;
	}
	public void setAmat(String vamat){
		amat = vamat;
	}
	public void setNombre(String vnom){
		nombre = vnom;
	}
	public void setEdad(int vedad){
		edad = vedad;
	}
	public void setSexo(String vsexo){
		sexo = vsexo;
	}
	
	public String getDni(){
	  	return dni;
	}
	public String getApat(){
	  	return apat;
	}
	public String getAmat(){
	  	return amat;
	}
	public String getNombre(){
	  	return nombre;
	}
	public int getEdad(){
	  	return edad;
	}
	public String getSexo(){
	  	return sexo;
	}
	
   	public Persona leerPersona(){
		String vdni,vapat,vamat,vnom,vsexo;
		int vedad;

		System.out.print("D N I      : ");
		vdni= Leer.dato();
		setDni(vdni);
		
		System.out.print("A. Paterno : ");
		vapat= Leer.dato();
		setApat(vapat);
		System.out.print("A. Materno : ");
		vamat= Leer.dato();
		setAmat(vamat);
		System.out.print("Nombre     : ");
		vnom= Leer.dato();
		setNombre(vnom);
		System.out.print("Edad       : ");
		vedad= Leer.datoInt();
		setEdad(vedad);
		System.out.print("Sexo       : ");
		vsexo= Leer.dato();
		setSexo(vsexo);

		return(this);
   }
   public void mostrarPersona(Persona x){
	   System.out.println(x.toString());
   }
	public void mostrarPersona(){
		System.out.println("DNI        : " + dni);
		System.out.println("A. paterno : " + apat);
		System.out.println("A. paterno : " + amat);
		System.out.println("Nombre     : " + nombre);
		System.out.println("Edad       : " + edad);
		System.out.printf("Sexo       : %s\n",sexo);
	}

	public String toString(){
		String cad="";
		cad=String.format("%12s %-15s %-15s %-15s %5d %-10s",dni,apat,amat,nombre,edad,sexo);
		return cad;
	}
}
