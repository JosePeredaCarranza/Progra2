///**
//* nombreClase: VectorAdministrativo.java
//* descripción:
//*
//*
//* @autores PEREDA CARRANZA, Jose Carlos Enrique
//* 			  ARAUJO TEJADA, Gustavo Reinaldo
//* @date: 10 set. 2024
//* @version 1
//*/
//package Clases.Progra2;
//
//public class VectorAdministrativo {
//	private Administrativo x[];
//
//	public VectorAdministrativo() {
//		x = new Administrativo[0];
//	}
//	public VectorAdministrativo(Administrativo va[]){
//		x = va;
//	}
//	public void agregarAdministrativo(){
//		int i;
//		i = x.length;
//		Administrativo a = new Administrativo();
//		redimensionar1();
//		a.leerPersona();
//		x[i] = a;
//	}
//
//	public Administrativo[] leerVector(){
//		int i,n;
//		Administrativo a = new Administrativo();
//		System.out.print("Numero de Administrativos para el vector ---> ");
//		n = Leer.datoInt();
//		Administrativo v[]=new Administrativo[n];
//
//		for(i=0;i<n;i=i+1){
//			System.out.println("Administrativo "+(i+1)+": ");
//			a.leerPersona();
//			v[i]=a;
//		}
//		return v;
//	}
//
//	public void insertarxPos(Administrativo dato, int posi){
//		int i;
//		redimensionar1();
//		i = x.length-1;
//		if(posi >= 0 && posi < x.length){
//			while(i > posi){
//				x[i] = x[i-1];
//				i = i-1;
//			}
//			x[posi] = dato;
//		}
//		else{
//			System.out.println("Dimension o Posicion fuera de Rango");
//		}
//	}
//
//	private void redimensionar1() {
//		int n=x.length;
//		n=n+1;
//		Administrativo y[]=new Administrativo[n];
//		for(int i = 0 ; i < x.length;i++){
//			y[i] = x[i];
//		}
//		x=y;
//	}
//
//	public void mostrarVector(){
//		if(x.length > 0){
//			for(int i=0;i<x.length;i=i+1){
//				System.out.printf("%4d %-15s %6d %-10s %10s\n", i + 1, x[i].getNombre(), x[i].getId(), x[i].getCargo(), x[i].getEmail());
//			}
//		}
//		else{
//			System.out.println("Vector vacio...");
//		}
//	}
//
//	public void mostrarVector(Administrativo v[]){
//		if(v.length > 0){
//			encabezado1();
//			encabezado2();
//			for(int i = 0; i < v.length - 1 ; i++){
//				System.out.printf("%4d %-15s %6d %-10s %10s\n", i + 1, x[i].getNombre(), x[i].getId(), x[i].getCargo(), x[i].getEmail());
//			}
//			raya1();
//		}
//		else{
//			System.out.println("Vector vacio...");
//		}
//	}
//
//	public void raya1(){
//		int i;
//		for(i=0;i<40;){
//		System.out.print("-");
//		i=i+1;
//		}
//		System.out.print("\n");
//	}
//	public void raya2(){
//		int i;
//		for(i=0;i<40;){
//		System.out.print("=");
//		i=i+1;
//		}
//		System.out.print("\n");
//	}
//
//	public void encabezado1(){
//		String t1="RELACION DE ADMINISTRATIVOS";
//		System.out.printf("\t\t%s\n",t1);
//	}
//	public void encabezado2(){
//		String s1="No";
//		String s2="NOMBRE";
//		String s3="ID";
//		String s4="CARGO";
//		String s5="EMAIL";
//		raya2();
//		System.out.printf("%3s %8s %12s %10s %14s\n",s1,s2,s3,s4,s5);
//		raya1();
//	}
//	@Override
//	public String toString(){
//		String cad="";
//		int dx=x.length;
//		for(int i=0;i<dx;){
//			cad=cad+String.format("%4d %-15s %6d %-10s %10s\n", i + 1, x[i].getNombre(), x[i].getId(), x[i].getCargo(), x[i].getEmail());
//			i=i+1;
//		}
//		return(cad);
//	} 
//	//Ordenamiento usando el algoritmo quicksort usamos el parametro opc para elegir el atributo a ordenar
//	public static void quickSort(Administrativo[] arr, int low, int high,int opc) {
//      if (low < high) {
//      	switch(opc) {
//      		case 1:
//      			int pi = sortAdministrativoxNombre(arr, low, high);
//               quickSort(arr, low, pi - 1,opc);
//               quickSort(arr, pi + 1, high,opc);
//               break;
//      		case 2:
//      			int pi1 = sortAdministrativoxId(arr, low, high);
//               quickSort(arr, low, pi1 - 1,opc);
//               quickSort(arr, pi1 + 1, high,opc);
//               break;
//      		case 3:
//      			int pi2 = sortAdministrativoxCargo(arr, low, high);
//               quickSort(arr, low, pi2 - 1,opc);
//               quickSort(arr, pi2 + 1, high,opc);
//               break;
//      		case 4:
//      			int pi3 = sortAdministrativoxEmail(arr, low, high);
//               quickSort(arr, low, pi3 - 1,opc);
//               quickSort(arr, pi3 + 1, high,opc);
//               break;
//      	}
//      }
//  }
//
//  private static int sortAdministrativoxNombre(Administrativo[] arr, int low, int high) {
//      Administrativo pivot = arr[high];
//      int i = low - 1;
//
//      for (int j = low; j < high; j++) {
//          if (arr[j].getNombre().compareTo(pivot.getNombre()) <= 0) {
//              i++;
//              Administrativo temp = arr[i];
//              arr[i] = arr[j];
//              arr[j] = temp;
//          }
//      }
//
//      Administrativo temp = arr[i + 1];
//      arr[i + 1] = arr[high];
//      arr[high] = temp;
//
//      return i + 1;
//  }
//  private static int sortAdministrativoxId(Administrativo[] arr, int low, int high) {
//	  Administrativo pivot = arr[high];
//	  int i = low - 1;
//	  
//	  for (int j = low; j < high; j++) {
//		  if (arr[j].getId() < pivot.getId()) {
//			  i++;
//			  Administrativo temp = arr[i];
//			  arr[i] = arr[j];
//			  arr[j] = temp;
//		  }
//	  }
//	  
//	  Administrativo temp = arr[i + 1];
//	  arr[i + 1] = arr[high];
//	  arr[high] = temp;
//	  
//	  return i + 1;
//  }
//  private static int sortAdministrativoxCargo(Administrativo[] arr, int low, int high) {
//	  Administrativo pivot = arr[high];
//	  int i = low - 1;
//	  
//	  for (int j = low; j < high; j++) {
//		  if (arr[j].getCargo().compareTo(pivot.getCargo()) <= 0) {
//			  i++;
//			  Administrativo temp = arr[i];
//			  arr[i] = arr[j];
//			  arr[j] = temp;
//		  }
//	  }
//	  
//	  Administrativo temp = arr[i + 1];
//	  arr[i + 1] = arr[high];
//	  arr[high] = temp;
//	  
//	  return i + 1;
//  }
//  private static int sortAdministrativoxEmail(Administrativo[] arr, int low, int high) {
//	  Administrativo pivot = arr[high];
//	  int i = low - 1;
//	  
//	  for (int j = low; j < high; j++) {
//		  if (arr[j].getEmail().compareTo(pivot.getEmail()) <= 0) {
//			  i++;
//			  Administrativo temp = arr[i];
//			  arr[i] = arr[j];
//			  arr[j] = temp;
//		  }
//	  }
//	  Administrativo temp = arr[i + 1];
//	  arr[i + 1] = arr[high];
//	  arr[high] = temp;
//	  return i + 1;
//  }
//  public Administrativo buscarAdministrativoxNombre(Administrativo a[], String nombre) {
//	  int dx,i;
//	  dx = a.length;
//	  if(dx == 0 ) {
//		  System.out.println("Vector vacio");
//	  }
//	  else {
//		  for(i = 0 ; i < dx ;i++) {
//			  if(nombre.equals(a[i].getNombre())) {
//				  return a[i];
//				}
//			}		
//		}
//		return null;
//	}
//	public Administrativo buscarAdministrativoxId(Administrativo a[], int id) {
//		int dx,i;
//		dx = a.length;
//		if(dx == 0 ) {
//			System.out.println("Vector vacio");
//		}
//		else {
//			for(i = 0 ; i < dx ;i++) {
//				if(id == a[i].getId()) {
//					return a[i];
//				}
//			}
//		}
//		return null;
//	}
//	public Administrativo buscarAdministrativoxCargo(Administrativo a[], String cargo) {
//		int dx,i;
//		dx = a.length;
//		if(dx == 0 ) {
//			System.out.println("Vector vacio");
//		}
//		else {
//			for(i = 0 ; i < dx ;i++) {
//				if(cargo.equals(a[i].getCargo())) {
//					return a[i];
//				}
//				
//			}
//			
//		}
//		return null;
//	}
//	public Administrativo buscarAdministrativoxEmail(Administrativo a[], String email) {
//		int dx,i;
//		dx = a.length;
//		if(dx == 0 ) {
//			System.out.println("Vector vacio");
//		}
//		else {
//			for(i = 0 ; i < dx ;i++) {
//				if(email.equals(a[i].getEmail())) {
//					return a[i];
//				}
//			}
//		}
//		return null;
//	}
//	public void redimensionar(int nl) {
//	    Administrativo[] nuevoArray = new Administrativo[nl];
//	    for (int i = 0; i < nl; i++) {
//	        nuevoArray[i] = x[i];
//	    }
//	    x = nuevoArray;
//	}
//	public Administrativo[] eliminarAdministrativoxPos(Administrativo a[], int pos) {
//		int dx,i;
//		dx = a.length;
//		if(dx == 0 ) {
//			System.out.println("Vector vacio");
//		}
//		if(pos >= 0 && pos < dx){
//			for(i = pos ; i < dx - 1 ;i++) {
//				a[i] = a[i + 1]; 
//			}
//			redimensionar(dx - 1);
//		}else {
//			 System.out.println("Posicion fuera de rango");
//	       return a;
//		}
//		return a;		
//	}
//	public Administrativo editarAdministrativo(Administrativo edit,int opc) {
//		boolean flag = false;
//		String nombre;
//		int id;
//		String cargo;
//		String email;
//		if(opc == 1) {
//			flag = true;
//		}
//		if(opc == 2 || flag) {
//			System.out.print("Nombre ---> ");
//			nombre = Leer.dato();
//			edit.setNombre(nombre);
//		}
//		if(opc == 3 || flag) {
//			System.out.print("Identificación ---> ");
//			id=Leer.datoInt();
//			edit.setId(id);
//		}
//		if(opc == 4 || flag) {
//			System.out.print("Cargo   ---> ");
//			cargo = Leer.dato();
//			edit.setCargo(cargo);
//		}
//		if(opc == 5 || flag) {
//			System.out.print("Email   ---> ");
//			email = Leer.dato();
//			edit.setEmail(email);
//		}
//		return edit;
//	}
//	
//}