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
package Clases.Progra2;
 

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
		a.leerPersona();
		x[i] = a;
	}
	public void agregarAlumno(Alumno a){
		int i;
		i = x.length;
		redimensionar1();
		x[i] = a;
	}

	public Alumno[] leerVector(){
		int i,n;
		System.out.print("Numero de alumnos para el vector ---> ");
		n = Leer.datoInt();
		Alumno v[]=new Alumno[n];

		for(i=0;i<n;i=i+1){
			System.out.println("Alumno "+(i+1)+": ");
			Alumno a = new Alumno();
			a.leerPersona();
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
			encabezado1();
			encabezado2();
			for(int i=0;i<x.length;i=i+1){
				System.out.printf("%5d",i+1);
				System.out.println(x[i]);
			}
			raya1();
		}
		else{
			System.out.println("Vector vacio...");
		}
	}

	public void mostrarVector(Alumno v[]){
		if(v.length > 0 && v[0] != null){
			encabezado1();
			encabezado2();
			for(int i = 0; i < v.length ; i++){
				System.out.printf("%5d",i+1);
				System.out.println(v[i]);
			}
			raya1();
		}
		else{
			System.out.println("Vector vacio...");
		}
	}

	public void raya1(){
		int i;
		for(i=0;i<105;){
		System.out.print("-");
		i=i+1;
		}
		System.out.print("\n");
	}
	public void raya2(){
		int i;
		for(i=0;i<105;){
		System.out.print("=");
		i=i+1;
		}
		System.out.print("\n");
	}

	public void encabezado1(){
		String t1="RELACION DE ALUMNOS";
		System.out.printf("\t\t\t\t\t%s\n",t1);
	}
	public void encabezado2(){
		String s1="No";
		String s2="DNI";
		String s3="A.Paterno";
		String s4="A.Materno";
		String s5="Nombre";
		String s6="Edad";
		String s7="Sexo";
		String s8="Codigo";
		String s9="Nota";
		String s10="Estado";
		raya2();
		System.out.printf("%5s %8s %9s %10s %7s %9s %3s %12s %12s %15s\n",s1,s2,s3,s4,s5,s6,s7,s8,s9,s10);
		raya1();
	}
	@Override
	public String toString(){
		String cad="";
		int dx=x.length;
		for(int i=0;i<dx;){
			cad=cad+String.format("%4d %-15d %6s %-10f %10b\n", i + 1, x[i].getCod(), x[i].getNombre(), x[i].getNota(), x[i].getEstado());
			i=i+1;
		}
		return(cad);
	} 
	//Ordenamiento usando el algoritmo quicksort usamos el parametro opc para elegir el atributo a ordenar
	public static void quickSort(Alumno[] arr, int low, int high,int opc) {
      if (low < high) {
    	  int pi = 0;
    	  switch(opc) {
      		case 1:
      			pi = sortAlumnoxDNI(arr, low, high);
      			break;
      		case 2:
      			pi = sortAlumnoxAPaterno(arr, low, high);
      			break;
      		case 3:
      			pi = sortAlumnoxAMaterno(arr, low, high);
    			break;
      		case 4:
      			pi = sortAlumnoxNombre(arr, low, high);
     			break;
      		case 5:
      			pi = sortAlumnoxEdad(arr, low, high);
      			break;
      		case 6:
      			pi = sortAlumnoxSexo(arr, low, high);
      			break;
      		case 7:
      			pi = sortAlumnoxCodigo(arr, low, high);
      			break;
      		case 8:
      			pi = sortAlumnoxNota(arr, low, high);
      			break;
      		case 9:
      			pi = sortAlumnoxEstado(arr, low, high);
      			break;
    	  }
    	  quickSort(arr, low, pi - 1,opc);
    	  quickSort(arr, pi + 1, high,opc);
      }
	}
	private static int sortAlumnoxDNI(Alumno []arr,int low,int high) {
		Alumno pivot = arr[high];
	      int i = low - 1;

	      for (int j = low; j < high; j++) {
	          if (arr[j].getDni().compareTo(pivot.getDni()) <= 0) {
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
	private static int sortAlumnoxAPaterno(Alumno []arr,int low,int high) {
		Alumno pivot = arr[high];
		int i = low - 1;
		
		for (int j = low; j < high; j++) {
			if (arr[j].getApat().compareTo(pivot.getApat()) <= 0) {
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
	private static int sortAlumnoxAMaterno(Alumno []arr,int low,int high) {
		Alumno pivot = arr[high];
		int i = low - 1;
		
		for (int j = low; j < high; j++) {
			if (arr[j].getAmat().compareTo(pivot.getAmat()) <= 0) {
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
	private static int sortAlumnoxNombre(Alumno[] arr, int low, int high) {
      Alumno pivot = arr[high];
      int i = low - 1;

      for (int j = low; j < high; j++) {
          if (arr[j].getNombre().compareTo(pivot.getNombre()) <= 0) {
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
	private static int sortAlumnoxEdad(Alumno[] arr, int low, int high) {
		Alumno pivot = arr[high];
		int i = low - 1;
		
		for (int j = low; j < high; j++) {
			if (arr[j].getEdad() < pivot.getEdad()) {
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
	private static int sortAlumnoxSexo(Alumno[] arr, int low, int high) {
	      Alumno pivot = arr[high];
	      int i = low - 1;

	      for (int j = low; j < high; j++) {
	          if (arr[j].getSexo().compareTo(pivot.getSexo()) <= 0) {
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
  public void quickSort(int low, int high, int opc) {
      if (low < high) {
          int pi = 0;
          switch (opc) {
          	case 1:
    			pi = sortAlumnoxDNI( low, high);
    			break;
    		case 2:
    			pi = sortAlumnoxAPaterno( low, high);
    			break;
    		case 3:
    			pi = sortAlumnoxAMaterno( low, high);
    			break;
    		case 4:
    			pi = sortAlumnoxNombre( low, high);
    			break;
    		case 5:
    			pi = sortAlumnoxEdad( low, high);
    			break;
    		case 6:
    			pi = sortAlumnoxSexo( low, high);
    			break;
    		case 7:
    			pi = sortAlumnoxCodigo( low, high);
    			break;
    		case 8:
    			pi = sortAlumnoxNota( low, high);
    			break;
    		case 9:
    			pi = sortAlumnoxEstado( low, high);
    			break;
          }
          quickSort(low, pi - 1, opc);
          quickSort(pi + 1, high, opc);
      }
  }
  private int sortAlumnoxDNI(int low, int high) {
      Alumno pivot = x[high];
      int i = low - 1;

      for (int j = low; j < high; j++) {
          if (x[j].getDni().compareTo(pivot.getDni()) <= 0) {
              i++;
              swap(i, j);
          }
      }
      swap(i + 1, high);
      return i + 1;
  }
  private int sortAlumnoxAPaterno(int low, int high) {
      Alumno pivot = x[high];
      int i = low - 1;

      for (int j = low; j < high; j++) {
          if (x[j].getApat().compareTo(pivot.getApat()) <= 0) {
              i++;
              swap(i, j);
          }
      }
      swap(i + 1, high);
      return i + 1;
  }
  private int sortAlumnoxAMaterno(int low, int high) {
      Alumno pivot = x[high];
      int i = low - 1;

      for (int j = low; j < high; j++) {
          if (x[j].getAmat().compareTo(pivot.getAmat()) <= 0) {
              i++;
              swap(i, j);
          }
      }
      swap(i + 1, high);
      return i + 1;
  }
  private int sortAlumnoxNombre(int low, int high) {
      Alumno pivot = x[high];
      int i = low - 1;

      for (int j = low; j < high; j++) {
          if (x[j].getNombre().compareTo(pivot.getNombre()) <= 0) {
              i++;
              swap(i, j);
          }
      }
      swap(i + 1, high);
      return i + 1;
  }
  private int sortAlumnoxEdad(int low, int high) {
      Alumno pivot = x[high];
      int i = low - 1;

      for (int j = low; j < high; j++) {
          if (x[j].getEdad() < pivot.getEdad()) {
              i++;
              swap(i, j);
          }
      }
      swap(i + 1, high);
      return i + 1;
  }
  private int sortAlumnoxSexo(int low, int high) {
      Alumno pivot = x[high];
      int i = low - 1;

      for (int j = low; j < high; j++) {
          if (x[j].getSexo().compareTo(pivot.getSexo()) <= 0) {
              i++;
              swap(i, j);
          }
      }
      swap(i + 1, high);
      return i + 1;
  }
  private int sortAlumnoxCodigo(int low, int high) {
      Alumno pivot = x[high];
      int i = low - 1;

      for (int j = low; j < high; j++) {
          if (x[j].getCod() < pivot.getCod()) {
              i++;
              swap(i, j);
          }
      }
      swap(i + 1, high);
      return i + 1;
  }

  private int sortAlumnoxNota(int low, int high) {
      Alumno pivot = x[high];
      int i = low - 1;

      for (int j = low; j < high; j++) {
          if (x[j].getNota() < pivot.getNota()) {
              i++;
              swap(i, j);
          }
      }
      swap(i + 1, high);
      return i + 1;
  }

  	private int sortAlumnoxEstado(int low, int high) {
      Alumno pivot = x[high];
      int i = low - 1;

      for (int j = low; j < high; j++) {
          if (x[j].getEstado() == pivot.getEstado()) {
              i++;
              swap(i, j);
          }
      }
      swap(i + 1, high);
      return i + 1;
  	}

  	private void swap(int i, int j) {
  		Alumno temp = x[i];
  		x[i] = x[j];
  		x[j] = temp;
  	}
  	public Alumno buscarAlumnoxDNI(String nombre) {
  		int dx,i;
  		dx = x.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(nombre.equals(x[i].getDni())) {
  					return x[i];
  				}
  			}		
  		}
  		return null;
  	}
  	public int buscarPosAlumnoxDNI(String nombre) {
  		int dx,i;
  		dx = x.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(nombre.equals(x[i].getDni())) {
  					return i;
  				}
  			}		
  		}
  		return 0;
  	}
  	public Alumno buscarAlumnoxDNI(Alumno a[], String nombre) {
  	  int dx,i;
  	  dx = a.length;
  	  if(dx == 0 ) {
  		  System.out.println("Vector vacio");
  	  }
  	  else {
  		  for(i = 0 ; i < dx ;i++) {
  			  if(nombre.equals(a[i].getDni())) {
  				  return a[i];
  				}
  			}		
  		}
  		return null;
  	}
  	public int buscarPosAlumnoxDNI(Alumno a[], String nombre) {
  		int dx,i;
  		dx = a.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(nombre.equals(a[i].getDni())) {
  					return i;
  				}
  			}		
  		}
  		return 0;
  	}
  	public Alumno[] buscarAlumnoxAPaterno(String nombre) {
  	  int dx,i;
  	  dx = x.length;
  	  if(dx == 0 ) {
  		  System.out.println("Vector vacio");
  	  }
  	  else {
  		  for(i = 0 ; i < dx ;i++) {
  			  if(nombre.equals(x[i].getApat())) {
  				  return x[i];
  				}
  			}		
  		}
  		return null;
  	}
  	public int[] buscarPosAlumnoxAPaterno(String nombre) {
  		int dx,i;
  		dx = x.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(nombre.equals(x[i].getApat())) {
  					return x[i];
  				}
  			}		
  		}
  		return null;
  	}
  	public Alumno[] buscarAlumnoxAMaterno(String nombre) {
  	  int dx,i;
  	  dx = x.length;
  	  if(dx == 0 ) {
  		  System.out.println("Vector vacio");
  	  }
  	  else {
  		  for(i = 0 ; i < dx ;i++) {
  			  if(nombre.equals(x[i].getAmat())) {
  				  return x[i];
  				}
  			}		
  		}
  		return null;
  	}
  	public int[] buscarPosAlumnoxAMaterno(String nombre) {
  		int dx,i;
  		dx = x.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(nombre.equals(x[i].getAmat())) {
  					return x[i];
  				}
  			}		
  		}
  		return null;
  	}
  	public Alumno[] buscarAlumnoxAPaterno(Alumno a[], String nombre) {
  		int dx,i;
  		dx = a.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(nombre.equals(a[i].getApat())) {
  					return a[i];
  				}
  			}		
  		}
  		return null;
  	}
  	public int[] buscarPosAlumnoxAPaterno(Alumno a[], String nombre) {
  		int dx,i;
  		dx = a.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(nombre.equals(a[i].getApat())) {
  					return a[i];
  				}
  			}		
  		}
  		return null;
  	}
  	public Alumno[] buscarAlumnoxAMaterno(Alumno a[], String nombre) {
  		int dx,i;
  		dx = a.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(nombre.equals(a[i].getAmat())) {
  					return a[i];
  				}
  			}		
  		}
  		return null;
  	}
  	public int[] buscarPosAlumnoxAMaterno(Alumno a[], String nombre) {
  		int dx,i;
  		dx = a.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(nombre.equals(a[i].getAmat())) {
  					return a[i];
  				}
  			}		
  		}
  		return null;
  	}
  	public Alumno[] buscarAlumnoxNombre(Alumno a[], String nombre) {
	  int dx,i;
	  dx = a.length;
	  if(dx == 0 ) {
		  System.out.println("Vector vacio");
	  }
	  else {
		  for(i = 0 ; i < dx ;i++) {
			  if(nombre.equals(a[i].getNombre())) {
				  return a[i];
				}
			}		
		}
		return null;
	}
  	public int[] buscarPosAlumnoxNombre(Alumno a[], String nombre) {
  		int dx,i;
  		dx = a.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(nombre.equals(a[i].getNombre())) {
  					return a[i];
  				}
  			}		
  		}
  		return null;
  	}
  	public Alumno[] buscarAlumnoxNombre(String nombre) {
  		int dx,i;
  		dx = x.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(nombre.equals(x[i].getNombre())) {
  					return x[i];
  				}
  			}		
  		}
  		return null;
  	}
  	public int[] buscarPosAlumnoxNombre(String nombre) {
  		int dx,i;
  		dx = x.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(nombre.equals(x[i].getNombre())) {
  					return x[i];
  				}
  			}		
  		}
  		return null;
  	}
  	public Alumno[] buscarAlumnoxEdad(Alumno a[], int cod) {
		int dx,i;
		dx = a.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		else {
			for(i = 0 ; i < dx ;i++) {
				if(cod == a[i].getEdad()) {
					return a[i];
				}
			}
		}
		return null;
	}
  	public int[] buscarPosAlumnoxEdad(Alumno a[], int cod) {
  		int dx,i;
  		dx = a.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(cod == a[i].getEdad()) {
  					return a[i];
  				}
  			}
  		}
  		return null;
  	}
  	public Alumno[] buscarAlumnoxEdad(int cod) {
  		int dx,i;
  		dx = x.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(cod == x[i].getEdad()) {
  					return x[i];
  				}
  			}
  		}
  		return null;
  	}
  	public int[] buscarPosAlumnoxEdad(int cod) {
  		int dx,i;
  		dx = x.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(cod == x[i].getEdad()) {
  					return x[i];
  				}
  			}
  		}
  		return null;
  	}
  	public Alumno[] buscarAlumnoxSexo(Alumno a[], String nombre) {
    	  int dx,i;
    	  dx = a.length;
    	  if(dx == 0 ) {
    		  System.out.println("Vector vacio");
    	  }
    	  else {
    		  for(i = 0 ; i < dx ;i++) {
    			  if(nombre.equals(a[i].getSexo())) {
    				  return a[i];
    				}
    			}		
    		}
    		return null;
    	}
  	public int[] buscarPosAlumnoxSexo(Alumno a[], String nombre) {
  		int dx,i;
  		dx = a.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(nombre.equals(a[i].getSexo())) {
  					return a[i];
  				}
  			}		
  		}
  		return null;
  	}
  	public Alumno[] buscarAlumnoxSexo(String nombre) {
  		int dx,i;
  		dx = x.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(nombre.equals(x[i].getSexo())) {
  					return x[i];
  				}
  			}		
  		}
  		return null;
  	}
  	public int[] buscarPosAlumnoxSexo(String nombre) {
  		int dx,i;
  		dx = x.length;
  		if(dx == 0 ) {
  			System.out.println("Vector vacio");
  		}
  		else {
  			for(i = 0 ; i < dx ;i++) {
  				if(nombre.equals(x[i].getSexo())) {
  					return x[i];
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
	public int buscarPosAlumnoxCod(Alumno a[], int cod) {
		int dx,i;
		dx = a.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		else {
			for(i = 0 ; i < dx ;i++) {
				if(cod == a[i].getCod()) {
					return i;
				}
			}
		}
		return 0;
	}
	public Alumno buscarAlumnoxCod(int cod) {
		int dx,i;
		dx = x.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		else {
			for(i = 0 ; i < dx ;i++) {
				if(cod == x[i].getCod()) {
					return x[i];
				}
			}
		}
		return null;
	}
	public int buscarPosAlumnoxCod(int cod) {
		int dx,i;
		dx = x.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		else {
			for(i = 0 ; i < dx ;i++) {
				if(cod == x[i].getCod()) {
					return i;
				}
			}
		}
		return 0;
	}
	public Alumno[] buscarAlumnoxNota(Alumno a[], int nota) {
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
	public int[] buscarPosAlumnoxNota(Alumno a[], int nota) {
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
	public Alumno[] buscarAlumnoxNota(int nota) {
		int dx,i;
		dx = x.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		else {
			for(i = 0 ; i < dx ;i++) {
				if(nota == x[i].getNota()) {
					return x[i];
				}
			}
		}
		return null;
	}
	public int[] buscarPosAlumnoxNota(int nota) {
		int dx,i;
		dx = x.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		else {
			for(i = 0 ; i < dx ;i++) {
				if(nota == x[i].getNota()) {
					return x[i];
				}
			}
		}
		return null;
	}
	public Alumno[] buscarAlumnoxEstado(Alumno a[], boolean estado) {
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
	public int[] buscarPosAlumnoxEstado(Alumno a[], boolean estado) {
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
	public Alumno[] buscarAlumnoxEstado(boolean estado) {
		int dx,i;
		dx = x.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		else {
			for(i = 0 ; i < dx ;i++) {
				if(estado == x[i].getEstado()) {
					return x[i];
				}
			}
		}
		return null;
	}
	public int[] buscarPosAlumnoxEstado(boolean estado) {
		int dx,i;
		dx = x.length;
		if(dx == 0 ) {
			System.out.println("Vector vacio");
		}
		else {
			for(i = 0 ; i < dx ;i++) {
				if(estado == x[i].getEstado()) {
					return x[i];
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
		Alumno temp = new Alumno();
		do {
			if(opc == 1) {
				flag = true;
			}
			if(opc == 2 || flag) {
				System.out.print("Codigo ---> ");
				codigo = Leer.datoInt();
				temp.setCod(codigo);
			}
			if(opc == 3 || flag) {
				System.out.print("Nombre ---> ");
				nombre=Leer.dato();
				temp.setNombre(nombre);
			}
			if(opc == 4 || flag) {
				System.out.print("Nota   ---> ");
				nota = Leer.datoFloat();
				temp.setNota(nota);
			}
			if(opc == 5 || flag) {
				System.out.print("Estado   ---> ");
				estado = Leer.datoBoolean();
				temp.setEstado(estado);
			}
			System.out.println("Esta seguro de editar? Si[1] No[2]: ");
			opc = Leer.datoInt();	
		}while(opc == 1 || opc ==2);
		return edit;
	}
	public int getDimension() {
		return this.x.length;
	}
	
}