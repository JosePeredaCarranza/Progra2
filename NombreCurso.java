/**
* nombreClase : NombreCurso.java
* descripción :
*
*
* @autor HUANACUNI GOMEZ, Jean Carlos Josue
* 		 PEREDA CARRANZA, Jose Carlos Enrique
* @date: 19-10-2024
* @version 1
*/
package paqG01Proyectov3;

public enum NombreCurso {
	PROGRAMACION_I("Programacion de Computadoras I"),
    PROGRAMACION_II("Programacion de Computadoras II"),
    CALCULO_I("Cslculo I"),
    FISICA_I("Fisica I"),
    ESTADISTICA_I("Estadistica I");

    private String nombreCurso;
    
    private NombreCurso(String nombre) {
        this.nombreCurso = nombre;
    }

    public String getNombre() {
        return nombreCurso;
    }
    
    public String toString(){
		String cad="";
		cad=String.format("%s",nombreCurso);
		return cad;
	}
}
