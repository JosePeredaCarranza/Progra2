/**
* nombreClase: VectorDocente.java
* descripción:
*
*
* @autores PEREDA CARRANZA, Jose Carlos Enrique
* 			  ARAUJO TEJADA, Gustavo Reinaldo
* @date: 14 set. 2024
* @version 1
*/
package Clases.Progra2;

public class VectorDocente {
	private Docente x[];

	public VectorDocente() {
		x = new Docente[0];
	}
	public VectorDocente(Docente va[]){
		x = va;
	}
	public void agregarDocente(){
		int i;
		i = x.length;
		Docente a = new Docente();
		redimensionar1();
		a.leerDocente();
		x[i] = a;
	}

	public Docente[] leerVector(){
		int i,n;
		Docente a = new Docente();
		System.out.print("Numero de Docentes para el vector ---> ");
		n = Leer.datoInt();
		Docente v[]=new Docente[n];

		for(i=0;i<n;i=i+1){
			System.out.println("Docente "+(i+1)+": ");
			a.leerDocente();
			v[i]=a;
		}
		return v;
	}

	public void insertarxPos(Docente dato, int posi){
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
		Docente y[]=new Docente[n];
		for(int i = 0 ; i < x.length;i++){
			y[i] = x[i];
		}
		x=y;
	}

	public void mostrarVector(){
		if(x.length > 0){
			for(int i=0;i<x.length;i=i+1){
				System.out.printf("%4d %-15s %6d %-10s %10s\n", i + 1, x[i].getNombre(), x[i].getID(), x[i].getArea(), x[i].getTipoDeContrato());
			}
		}
		else{
			System.out.println("Vector vacio...");
		}
	}

	public void mostrarVector(Docente v[]){
		if(v.length > 0){
			encabezado1();
			encabezado2();
			for(int i = 0; i < v.length - 1 ; i++){
				System.out.printf("%4d %-15s %6d %-10s %10s\n", i + 1, x[i].getNombre(), x[i].getID(), x[i].getArea(), x[i].getTipoDeContrato());
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
		String t1="RELACION DE DocenteS";
		System.out.printf("\t\t%s\n",t1);
	}
	public void encabezado2(){
		String s1="No";
		String s2="Nombre";
		String s3="ID";
		String s4="CREDITOS";
		String s5="DOCENTE ASIGNADO";
		raya2();
		System.out.printf("%3s %8s %12s %10s %14s\n",s1,s2,s3,s4,s5);
		raya1();
	}
	@Override
	public String toString(){
		String cad="";
		int dx=x.length;
		for(int i=0;i<dx;){
			cad=cad+String.format("%4d %-15s %6d %-10s %10s\n", i + 1, x[i].getNombre(), x[i].getID(), x[i].getArea(), x[i].getTipoDeContrato());
			i=i+1;
		}
		return(cad);
	} 
	//Ordenamiento usando el algoritmo quicksort usamos el parametro opc para elegir el atributo a ordenar
	public static void quickSort(Docente[] arr, int low, int high,int opc) {
      if (low < high) {
      	switch(opc) {
      		case 1:
      			int pi = sortDocentexNombre(arr, low, high);
               quickSort(arr, low, pi - 1,opc);
               quickSort(arr, pi + 1, high,opc);
      		case 2:
      			int pi1 = sortDocentexID(arr, low, high);
               quickSort(arr, low, pi1 - 1,opc);
               quickSort(arr, pi1 + 1, high,opc);
      		case 3:
      			int pi2 = sortDocentexArea(arr, low, high);
               quickSort(arr, low, pi2 - 1,opc);
               quickSort(arr, pi2 + 1, high,opc);
      		case 4:
      			int pi3 = sortDocentextipoDeContrato(arr, low, high);
               quickSort(arr, low, pi3 - 1,opc);
               quickSort(arr, pi3 + 1, high,opc);
      	}
      }
  }

  private static int sortDocentexNombre(Docente[] arr, int low, int high) {
      Docente pivot = arr[high];
      int i = low - 1;

      for (int j = low; j < high; j++) {
          if (arr[j].getNombre().compareTo(pivot.getNombre()) <= 0) {
              i++;
              Docente temp = arr[i];
              arr[i] = arr[j];
              arr[j] = temp;
          }
      }

      Docente temp = arr[i + 1];
      arr[i + 1] = arr[high];
      arr[high] = temp;

      return i + 1;
  }
  private static int sortDocentexID(Docente[] arr, int low, int high) {
	  Docente pivot = arr[high];
	  int i = low - 1;
	  
	  for (int j = low; j < high; j++) {
		  if (arr[j].getID() < pivot.getID()) {
			  i++;
			  Docente temp = arr[i];
			  arr[i] = arr[j];
			  arr[j] = temp;
		  }
	  }
	  
	  Docente temp = arr[i + 1];
	  arr[i + 1] = arr[high];
	  arr[high] = temp;
	  
	  return i + 1;
  }
  private static int sortDocentexArea(Docente[] arr, int low, int high) {
	  Docente pivot = arr[high];
	  int i = low - 1;
	  
	  for (int j = low; j < high; j++) {
		  if (arr[j].getArea().compareTo(pivot.getArea() ) <=0 ) {
			  i++;
			  Docente temp = arr[i];
			  arr[i] = arr[j];
			  arr[j] = temp;
		  }
	  }
	  
	  Docente temp = arr[i + 1];
	  arr[i + 1] = arr[high];
	  arr[high] = temp;
	  
	  return i + 1;
  }
  private static int sortDocentextipoDeContrato(Docente[] arr, int low, int high) {
	  Docente pivot = arr[high];
	  int i = low - 1;
	  
	  for (int j = low; j < high; j++) {
		  if (arr[j].getTipoDeContrato().compareTo(pivot.getTipoDeContrato()) <= 0) {
			  i++;
			  Docente temp = arr[i];
			  arr[i] = arr[j];
			  arr[j] = temp;
		  }
	  }
	  Docente temp = arr[i + 1];
	  arr[i + 1] = arr[high];
	  arr[high] = temp;
	  return i + 1;
  }
  public Docente buscarDocentexNombre(Docente a[], String Nombre) {
	  int dx,i;
	  dx = a.length;
	  if(dx == 0 ) {
		  System.out.println("Vector vacio");
	  }
	  else {
		  for(i = 0 ; i < dx ;i++) {
			  if(Nombre.equals(a[i].getNombre())) {
				  return a[i];
				}
			}		
		}
		return null;
	}
	public Docente buscarDocentexID(Docente a[], int id) {
		int dx,i;
		dx = a.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		else {
			for(i = 0 ; i < dx ;i++) {
				if(id == a[i].getID()) {
					return a[i];
				}
			}
		}
		return null;
	}
	public Docente buscarDocentexArea(Docente a[], String area) {
		int dx,i;
		dx = a.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		else {
			for(i = 0 ; i < dx ;i++) {
				if(area == a[i].getArea()) {
					return a[i];
				}
			}
		}
		return null;
	}
	public Docente buscarDocentextipoDeContrato(Docente a[], String tipoDeContrato) {
		int dx,i;
		dx = a.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		else {
			for(i = 0 ; i < dx ;i++) {
				if(tipoDeContrato.equals(a[i].getTipoDeContrato())) {
					return a[i];
				}
			}
		}
		return null;
	}
	public void redimensionar(int nl) {
	    Docente[] nuevoArray = new Docente[nl];
	    for (int i = 0; i < nl; i++) {
	        nuevoArray[i] = x[i];
	    }
	    x = nuevoArray;
	}
	public Docente[] eliminarDocentexPos(Docente a[], int pos) {
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
	public Docente editarDocente(Docente edit,int opc) {
		boolean flag = false;
		String Nombre;
		int ID;
		String area;
		String tipoDeContrato;
		if(opc == 1) {
			flag = true;
		}
		if(opc == 2 || flag) {
			System.out.print("Nombre ---> ");
			Nombre = Leer.dato();
			edit.setNombre(Nombre);
		}
		if(opc == 3 || flag) {
			System.out.print("ID ---> ");
			ID=Leer.datoInt();
			edit.setID(ID);
		}
		if(opc == 4 || flag) {
			System.out.print("Area   ---> ");
			area = Leer.dato();
			edit.setArea(area);
		}
		if(opc == 5 || flag) {
			System.out.print("Email   ---> ");
			tipoDeContrato = Leer.dato();
			edit.setTipoDeContrato(tipoDeContrato);
		}
		return edit;
	}
	
}
