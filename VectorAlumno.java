/**
* nombreClase: VectorAlumno.java
* descripción:
*
*
* @autores PEREDA CARRANZA, Jose Carlos Enrique
* 			  ARAUJO TEJADA, Gustavo Reinaldo
* @date: 10 set. 2024
* @version 1
*/
package Clases;


public class VectorAlumno {
	private Alumno x[];

	public VectorAlumno() {
		x = new Alumno[0];
	}
	public VectorAlumno(Alumno va[]){
		x = va;
	}
	public void agregarAlumno(){
		int i;
		i = x.length;
		Alumno a = new Alumno();
		redimensionar1();
		a.leerAlumno();
		x[i] = a;
	}

	public Alumno[] leerVector(){
		int i,n;
		Alumno a = new Alumno();
		System.out.print("Numero de alumnos para el vector ---> ");
		n = Leer.datoInt();
		Alumno v[]=new Alumno[n];

		for(i=0;i<n;i=i+1){
			System.out.println("Alumno "+(i+1)+": ");
			a.leerAlumno();
			v[i]=a;
		}
		return v;
	}

	public void insertarxPos(Alumno dato, int posi){
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
		Alumno y[]=new Alumno[n];
		for(int i = 0 ; i < x.length;i++){
			y[i] = x[i];
		}
		x=y;
	}

	public void mostrarVector(){
		if(x.length > 0){
			for(int i=0;i<x.length;i=i+1){
				System.out.printf("%4d %-15d %6s %-10f %10b\n", i + 1, x[i].getCod(), x[i].getNom(), x[i].getNota(), x[i].getEstado());
			}
		}
		else{
			System.out.println("Vector vacio...");
		}
	}

	public void mostrarVector(Alumno v[]){
		if(v.length > 0){
			encabezado1();
			encabezado2();
			for(int i = 0; i < v.length - 1 ; i++){
				System.out.printf("%4d %-15d %6s %-10f %10b\n", i + 1, x[i].getCod(), x[i].getNom(), x[i].getNota(), x[i].getEstado());
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
		String t1="RELACION DE ALUMNOS";
		System.out.printf("\t\t%s\n",t1);
	}
	public void encabezado2(){
		String s1="No";
		String s2="CODIGO";
		String s3="NOMBRE";
		String s4="NOTA";
		String s5="ESTADO";
		raya2();
		System.out.printf("%3s %8s %12s %10s %14s\n",s1,s2,s3,s4,s5);
		raya1();
	}
	@Override
	public String toString(){
		String cad="";
		int dx=x.length;
		for(int i=0;i<dx;){
			cad=cad+String.format("%4d %-15d %6s %-10f %10b\n", i + 1, x[i].getCod(), x[i].getNom(), x[i].getNota(), x[i].getEstado());
			i=i+1;
		}
		return(cad);
	} 
	//Ordenamiento usando el algoritmo quicksort usamos el parametro opc para elegir el atributo a ordenar
	public static void quickSort(Alumno[] arr, int low, int high,int opc) {
      if (low < high) {
      	switch(opc) {
      		case 1:
      			int pi = sortAlumnoxNombre(arr, low, high);
               quickSort(arr, low, pi - 1,opc);
               quickSort(arr, pi + 1, high,opc);
               break;
      		case 2:
      			int pi1 = sortAlumnoxCodigo(arr, low, high);
               quickSort(arr, low, pi1 - 1,opc);
               quickSort(arr, pi1 + 1, high,opc);
               break;
      		case 3:
      			int pi2 = sortAlumnoxNota(arr, low, high);
               quickSort(arr, low, pi2 - 1,opc);
               quickSort(arr, pi2 + 1, high,opc);
               break;
      		case 4:
      			int pi3 = sortAlumnoxEstado(arr, low, high);
               quickSort(arr, low, pi3 - 1,opc);
               quickSort(arr, pi3 + 1, high,opc);
               break;
      	}
      }
  }

  private static int sortAlumnoxNombre(Alumno[] arr, int low, int high) {
      Alumno pivot = arr[high];
      int i = low - 1;

      for (int j = low; j < high; j++) {
          if (arr[j].getNom().compareTo(pivot.getNom()) <= 0) {
              i++;
              Alumno temp = arr[i];
              arr[i] = arr[j];
              arr[j] = temp;
          }
      }

      Alumno temp = arr[i + 1];
      arr[i + 1] = arr[high];
      arr[high] = temp;

      return i + 1;
  }
  private static int sortAlumnoxCodigo(Alumno[] arr, int low, int high) {
	  Alumno pivot = arr[high];
	  int i = low - 1;
	  
	  for (int j = low; j < high; j++) {
		  if (arr[j].getCod() < pivot.getCod()) {
			  i++;
			  Alumno temp = arr[i];
			  arr[i] = arr[j];
			  arr[j] = temp;
		  }
	  }
	  
	  Alumno temp = arr[i + 1];
	  arr[i + 1] = arr[high];
	  arr[high] = temp;
	  
	  return i + 1;
  }
  private static int sortAlumnoxNota(Alumno[] arr, int low, int high) {
	  Alumno pivot = arr[high];
	  int i = low - 1;
	  
	  for (int j = low; j < high; j++) {
		  if (arr[j].getNota() < pivot.getNota()) {
			  i++;
			  Alumno temp = arr[i];
			  arr[i] = arr[j];
			  arr[j] = temp;
		  }
	  }
	  
	  Alumno temp = arr[i + 1];
	  arr[i + 1] = arr[high];
	  arr[high] = temp;
	  
	  return i + 1;
  }
  
  private static int sortAlumnoxEstado(Alumno[] arr, int low, int high) {
	  Alumno pivot = arr[high];
	  int i = low - 1;
	  
	  for (int j = low; j < high; j++) {
		  if (arr[j].getEstado() == pivot.getEstado()) {
			  i++;
			  Alumno temp = arr[i];
			  arr[i] = arr[j];
			  arr[j] = temp;
		  }
	  }
	  Alumno temp = arr[i + 1];
	  arr[i + 1] = arr[high];
	  arr[high] = temp;
	  return i + 1;
  }
  public Alumno buscarAlumnoxNombre(Alumno a[], String nombre) {
	  int dx,i;
	  dx = a.length;
	  if(dx == 0 ) {
		  System.out.println("Vector vacio");
	  }
	  else {
		  for(i = 0 ; i < dx ;i++) {
			  if(nombre.equals(a[i].getNom())) {
				  return a[i];
				}
			}		
		}
		return null;
	}
	public Alumno buscarAlumnoxCod(Alumno a[], int cod) {
		int dx,i;
		dx = a.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		else {
			for(i = 0 ; i < dx ;i++) {
				if(cod == a[i].getCod()) {
					return a[i];
				}
			}
		}
		return null;
	}
	public Alumno buscarAlumnoxNota(Alumno a[], int nota) {
		int dx,i;
		dx = a.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		else {
			for(i = 0 ; i < dx ;i++) {
				if(nota == a[i].getNota()) {
					return a[i];
				}
			}
		}
		return null;
	}
	public Alumno buscarAlumnoxEstado(Alumno a[], boolean estado) {
		int dx,i;
		dx = a.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		else {
			for(i = 0 ; i < dx ;i++) {
				if(estado == a[i].getEstado()) {
					return a[i];
				}
			}
		}
		return null;
	}
	public void redimensionar(int nl) {
	    Alumno[] nuevoArray = new Alumno[nl];
	    for (int i = 0; i < nl; i++) {
	        nuevoArray[i] = x[i];
	    }
	    x = nuevoArray;
	}
	public Alumno[] eliminarAlumnoxPos(Alumno a[], int pos) {
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
	public Alumno editarAlumno(Alumno edit,int opc) {
		boolean flag = false;
		int codigo;
		String nombre;
		float nota;
		boolean estado;
		if(opc == 1) {
			flag = true;
		}
		if(opc == 2 || flag) {
			System.out.print("Codigo ---> ");
			codigo = Leer.datoInt();
			edit.setCod(codigo);
		}
		if(opc == 3 || flag) {
			System.out.print("Nombre ---> ");
			nombre=Leer.dato();
			edit.setNom(nombre);
		}
		if(opc == 4 || flag) {
			System.out.print("Nota   ---> ");
			nota = Leer.datoFloat();
			edit.setNota(nota);
		}
		if(opc == 5 || flag) {
			System.out.print("Estado   ---> ");
			estado = Leer.datoBoolean();
			edit.setEstado(estado);
		}
		return edit;
	}
	
}