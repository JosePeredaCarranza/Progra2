/**
* nombreClase: VectorAula.java
* descripción:
*
*
* @autores PEREDA CARRANZA, Jose Carlos Enrique
* 			  ARAUJO TEJADA, Gustavo Reinaldo
* @date: 10 set. 2024
* @version 1
*/
package Clases.Progra2;

public class VectorAula{
	private Aula x[];

	public VectorAula() {
		x = new Aula[0];
	}
	public VectorAula(Aula va[]){
		x = va;
	}
	public void agregarAula(){
		int i;
		i = x.length;
		Aula a = new Aula();
		redimensionar1();
		a.leerAula();
		x[i] = a;
	}

	public Aula[] leerVector(){
		int i,n;
		Aula a = new Aula();
		System.out.print("Numero de aulas para el vector ---> ");
		n = Leer.datoInt();
		Aula v[]=new Aula[n];

		for(i=0;i<n;i=i+1){
			System.out.println("Aula "+(i+1)+": ");
			a.leerAula();
			v[i]=a;
		}
		return v;
	}

	public void insertarxPos(Aula dato, int posi){
		int i;
		redimensionar1();
		i = x.length-1;
		if(posi >= 0 && posi < x.length){
			while(i > posi){
				x[i] = x[i-1];
				i = i-1;
			}
			x[posi] = dato;
		}
		else{
			System.out.println("Dimension o Posicion fuera de Rango");
		}
	}

	private void redimensionar1() {
		int n=x.length;
		n=n+1;
		Aula y[]=new Aula[n];
		for(int i = 0 ; i < x.length;i++){
			y[i] = x[i];
		}
		x=y;
	}

	public void mostrarVector(){
		if(x.length > 0){
			for(int i=0;i<x.length;i=i+1){
				System.out.printf("%4d %-15d %6s %-10s %10b\n", i + 1, x[i].getCapacidad(), x[i].getTequipo(), x[i].getPabellon(), x[i].getDisponible());
			}
		}
		else{
			System.out.println("Vector vacio...");
		}
	}

	public void mostrarVector(Aula v[]){
		if(v.length > 0){
			encabezado1();
			encabezado2();
			for(int i = 0; i < v.length - 1 ; i++){
				System.out.printf("%4d %-15d %6s %-10s %10b\n", i + 1, x[i].getCapacidad(), x[i].getTequipo(), x[i].getPabellon(), x[i].getDisponible());
			}
			raya1();
		}
		else{
			System.out.println("Vector vacio...");
		}
	}

	public void raya1(){
		int i;
		for(i=0;i<40;){
		System.out.print("-");
		i=i+1;
		}
		System.out.print("\n");
	}
	public void raya2(){
		int i;
		for(i=0;i<40;){
		System.out.print("=");
		i=i+1;
		}
		System.out.print("\n");
	}

	public void encabezado1(){
		String t1="RELACION DE AulaS EN STOCK";
		System.out.printf("\t\t%s\n",t1);
	}
	public void encabezado2(){
		String s1="No";
		String s2="CAPACIDAD";
		String s3="TIPO DE EQUIPO";
		String s4="PABELLON";
		String s5="DISPONIBLE";
		raya2();
		System.out.printf("%3s %8s %12s %10s %14s\n",s1,s2,s3,s4,s5);
		raya1();
	}
	@Override
	public String toString(){
		String cad="";
		int dx=x.length;
		for(int i=0;i<dx;){
			cad=cad+String.format("%4d %-15d %6s %-10s %10b\n", i + 1, x[i].getCapacidad(), x[i].getTequipo(), x[i].getPabellon(), x[i].getDisponible());
			i=i+1;
		}
		return(cad);
	} 
	//Ordenamiento usando el algoritmo quicksort usamos el parametro opc para elegir el atributo a ordenar
	public static void quickSort(Aula[] arr, int low, int high,int opc) {
      if (low < high) {
      	switch(opc) {
      		case 1:
      			int pi = sortAulaxTequipo(arr, low, high);
               quickSort(arr, low, pi - 1,opc);
               quickSort(arr, pi + 1, high,opc);
               break;
      		case 2:
      			int pi1 = sortAulaxCapacidad(arr, low, high);
               quickSort(arr, low, pi1 - 1,opc);
               quickSort(arr, pi1 + 1, high,opc);
               break;
      		case 3:
      			int pi2 = sortAulaxPabellon(arr, low, high);
               quickSort(arr, low, pi2 - 1,opc);
               quickSort(arr, pi2 + 1, high,opc);
               break;
      		case 4:
      			int pi3 = sortAulaxDisponible(arr, low, high);
               quickSort(arr, low, pi3 - 1,opc);
               quickSort(arr, pi3 + 1, high,opc);
               break;
      	}
      }
  }

  private static int sortAulaxTequipo(Aula[] arr, int low, int high) {
      Aula pivot = arr[high];
      int i = low - 1;

      for (int j = low; j < high; j++) {
          if (arr[j].getTequipo().compareTo(pivot.getTequipo()) <= 0) {
              i++;
              Aula temp = arr[i];
              arr[i] = arr[j];
              arr[j] = temp;
          }
      }

      Aula temp = arr[i + 1];
      arr[i + 1] = arr[high];
      arr[high] = temp;

      return i + 1;
  }
  private static int sortAulaxCapacidad(Aula[] arr, int low, int high) {
	  Aula pivot = arr[high];
	  int i = low - 1;
	  
	  for (int j = low; j < high; j++) {
		  if (arr[j].getCapacidad() < pivot.getCapacidad()) {
			  i++;
			  Aula temp = arr[i];
			  arr[i] = arr[j];
			  arr[j] = temp;
		  }
	  }
	  
	  Aula temp = arr[i + 1];
	  arr[i + 1] = arr[high];
	  arr[high] = temp;
	  
	  return i + 1;
  }
  private static int sortAulaxPabellon(Aula[] arr, int low, int high) {
	  Aula pivot = arr[high];
	  int i = low - 1;
	  
	  for (int j = low; j < high; j++) {
		  if (arr[j].getPabellon().compareTo(pivot.getPabellon()) <= 0) {
			  i++;
			  Aula temp = arr[i];
			  arr[i] = arr[j];
			  arr[j] = temp;
		  }
	  }
	  
	  Aula temp = arr[i + 1];
	  arr[i + 1] = arr[high];
	  arr[high] = temp;
	  
	  return i + 1;
  }
  private static int sortAulaxDisponible(Aula[] arr, int low, int high) {
	  Aula pivot = arr[high];
	  int i = low - 1;
	  
	  for (int j = low; j < high; j++) {
		  if (arr[j].getDisponible() == pivot.getDisponible()) {
			  i++;
			  Aula temp = arr[i];
			  arr[i] = arr[j];
			  arr[j] = temp;
		  }
	  }
	  Aula temp = arr[i + 1];
	  arr[i + 1] = arr[high];
	  arr[high] = temp;
	  return i + 1;
  }
  public Aula buscarAulaxTequipo(Aula a[], String tequipo) {
	  int dx,i;
	  dx = a.length;
	  if(dx == 0 ) {
		  System.out.println("Vector vacio");
	  }
	  else {
		  for(i = 0 ; i < dx ;i++) {
			  if(tequipo.equals(a[i].getTequipo())) {
				  return a[i];
				}
			}		
		}
		return null;
	}
	public Aula buscarAulaxCapacidad(Aula a[], int capacidad) {
		int dx,i;
		dx = a.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		else {
			for(i = 0 ; i < dx ;i++) {
				if(capacidad == a[i].getCapacidad()) {
					return a[i];
				}
			}
		}
		return null;
	}
	public Aula buscarAulaxPabellon(Aula a[], String pabellon) {
		int dx,i;
		dx = a.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		else {
			for(i = 0 ; i < dx ;i++) {
				if(pabellon.equals(a[i].getPabellon())) {
					return a[i];
				}
				
			}
			
		}
		return null;
	}
	public Aula buscarAulaxDisponible(Aula a[], boolean disponible) {
		int dx,i;
		dx = a.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		else {
			for(i = 0 ; i < dx ;i++) {
				if(disponible == a[i].getDisponible()) {
					return a[i];
				}
			}
		}
		return null;
	}
	public void redimensionar(int nl) {
	    Aula[] nuevoArray = new Aula[nl];
	    for (int i = 0; i < nl; i++) {
	        nuevoArray[i] = x[i];
	    }
	    x = nuevoArray;
	}
	public Aula[] eliminarAulaxPos(Aula a[], int pos) {
		int dx,i;
		dx = a.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		if(pos >= 0 && pos < dx){
			for(i = pos ; i < dx - 1 ;i++) {
				a[i] = a[i + 1]; 
			}
			redimensionar(dx - 1);
		}else {
			 System.out.println("Posicion fuera de rango");
	       return a;
		}
		return a;		
	}
	public Aula editarAula(Aula edit,int opc) {
		boolean flag = false;
		int capacidad;
		String tequipo;
		String pabellon;
		boolean disponible;
		if(opc == 1) {
			flag = true;
		}
		if(opc == 2 || flag) {
			System.out.print("Capacidad ---> ");
			capacidad = Leer.datoInt();
			edit.setCapacidad(capacidad);
		}
		if(opc == 3 || flag) {
			System.out.print("Tipo de equipo ---> ");
			tequipo = Leer.dato();
			edit.setTequipo(tequipo);
		}
		if(opc == 4 || flag) {
			System.out.print("Pabellon   ---> ");
			pabellon = Leer.dato();
			edit.setPabellon(pabellon);
		}
		if(opc == 5 || flag) {
			System.out.print("Disponible   ---> ");
			disponible = Leer.datoBoolean();
			edit.setDisponible(disponible);
		}
		return edit;
	}
}