/**
* nombreClase: Leer.java
* descripción:
*
*
* @autores PEREDA CARRANZA, Jose Carlos Enrique
* 			  ARAUJO TEJADA, Gustavo Reinaldo
* @date: 10 set. 2024
* @version 1
*/
package Clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Leer {	
	public static String dato(){
		String sdato=" ";
		try{
			//definir un flujo de caracteres de entrada: flujoE
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader flujoE=new BufferedReader(isr);
			//Leer.la entrada finaliza al pulsar la tecla entrar
			sdato =flujoE.readLine();
		}
		catch(IOException e){
			System.err.println("error: "+e.getMessage());
		}
		return sdato;//devolver el dato tecleado
	}
	public static int datoInt(){
		try{
			return Integer.parseInt(dato());
		}
		catch(NumberFormatException e){
			return Integer.MAX_VALUE;//valor mas pequeno
		}
	}
	public static float datoFloat() {
	    try {
	        return Float.parseFloat(dato());
	    } catch (NumberFormatException e) {
	        return Float.NaN; // No es un número: valor float especial
	    }
	}
	public static double datoDouble() {
	    try {
	        return Double.parseDouble(dato());
	    } catch (NumberFormatException e) {
	        return Double.NaN; // No es un número: valor double especial
	    }
	}
	public static boolean datoBoolean(){
      while (true) {
          String sdato = dato().toLowerCase();
          if (sdato.equals("true") || sdato.equals("false")) {
              return Boolean.parseBoolean(sdato);
          } else {
              System.out.println("Por favor, ingrese 'true' o 'false'.");
          }
      }
  }
	
}