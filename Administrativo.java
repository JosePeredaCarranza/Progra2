/**
* nombreClase : Administrativo.java
* descripción :
*
*
* @autor HUANACUNI GOMEZ, Jean Carlos Josue
* 		 PEREDA CARRANZA, Jose Carlos Enrique
* @date: 28-09-2024
* @version 2
*/
package Clases.Progra2;

public class Administrativo extends Persona {
	private int codAdm;
	private String area;
	private float pago;

	public Administrativo() {
		super();
	}
	public Administrativo(String vdni, String vapat,String vamat, String vnom, int vedad, String vsexo, int vcodAdm, String vArea, float vpago){
	   super(vdni, vapat,vamat, vnom, vedad, vsexo);
	   codAdm=vcodAdm;
	   area=vArea;
	   pago=vpago;
	}
	void setCodAdm(int vcodAdm){
	   codAdm=vcodAdm;
	}
	void setArea(String varea){
	   area=varea;
	}
	void setPago(float vpago){
	   pago=vpago;
	}

	public int getCodAdm(){
		return codAdm;
	}
	public String getArea(){
		return area;
	}
	public float getPago(){
		return pago;
	}

	public Persona leerPersona(){
		super.leerPersona();
		int vcodAdm;
		String vArea;
		float vpago;

		System.out.print("codigo de Adm.   : ");
		vcodAdm= Leer.datoInt();
		setCodAdm(vcodAdm);
		System.out.print("area             : ");
		vArea= Leer.dato();
		setArea(vArea);
		System.out.print("pago             : ");
		vpago= Leer.datoFloat();
		setPago(vpago);
		return (this);
	}
	public void escribirPersona(){
		super.escribirPersona();
		System.out.printf("%10d %-15s %10.2f\n",codAdm,area,pago);
	}
	public void mostrarPersona(){
		super.mostrarPersona();
		System.out.println("codigoAdm  : " + codAdm);
		System.out.println("area    : " + area);
		System.out.printf("pago       : %10.2f\n", pago);
	}
	public String toString(){
		String cad="";
		cad=super.toString()+String.format("%10d %-15s %10.2f\n",codAdm,area,pago);
		return cad;
	}
}
