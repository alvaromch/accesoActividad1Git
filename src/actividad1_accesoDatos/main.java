package actividad1_accesoDatos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
	static List<Coche> listaCoches = new ArrayList();
	static Coche coche = new Coche();
	static Scanner sc = new Scanner(System.in);
	static int opcion;
	static boolean continuar = true;
	static int id;
	static String matricula, marca, modelo, color;
	static String directionFile = "coches.dat";
	static String directionTxt = "Car_List.txt";
	static FileManager administrationFile = new FileManager(directionFile);
	
	public static void main(String[] args) {
		readFile();
		//Coche coche2 = new Coche(2, "4456", "marca", "modelo", "color");
		//Coche coche3 = new Coche(3, "4457", "marca", "modelo", "color");
		//listaCoches.add(coche3);
		//listaCoches.add(coche2);
		
		
		while (continuar == true) {
			System.out.println("Elige una de las siguientes opciones");
			System.out.println("1. Añadir coche.");
			System.out.println("2. Borrar coche por id.");
			System.out.println("3. Buscar coche por id .");
			System.out.println("4. Listado de los coches.");
			System.out.println("5. Exportar datos.");
			System.out.println("6. Salir del programa.");
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				addCar();

				break;

			case 2:
				clearCar();

				break;
			case 3:
				findCar();
				break;
			case 4:
				showCars();
				break;
			case 5:
				exportList();
				break;
			case 6:
				continuar = false;
				saveClose();
				break;
			default:
				System.out.println("Debe poner otro valor dentro de los permitidos.");
			}

		}

	}

	public static void readFile() {
		listaCoches = administrationFile.readFile();
		
	}

	public static void addCar() {
		System.out.println("Introduzca el id del coche");
		id = sc.nextInt();
		boolean numero = false;
		for (Coche c : listaCoches) {
			if (c.getId() == id) {
				System.out.println("El id tiene que ser Unico");
				numero = true;

			}
		}
		if (numero == false) {
			System.out.println("Introduzca la matricula del coche");
			matricula = sc.next();
			for (Coche c : listaCoches) {
				if (c.getMatricula().equalsIgnoreCase(matricula)) {
					System.out.println("La matricula tiene que ser unica");
					numero = true;
				}
			}
			if (numero == false) {
				System.out.println("Introduzca la marca del coche");
				marca = sc.next();
				System.out.println("Introduzca el modelo del coche");
				modelo = sc.next();
				System.out.println("Introduzca el color del coche");
				color = sc.next();
				Coche coche1 = new Coche(id, matricula, marca, modelo, color);
				listaCoches.add(coche1);
			}
		}

	}

	public static void clearCar() {
		System.out.println(listaCoches.size());
		System.out.println("Introduzca el id del coche que quiere borrar");
		id = sc.nextInt();
		boolean numero2 = false;
		 for(int i=0;i<listaCoches.size();i++){
		        if (listaCoches.get(i).getId()==id) {
		        	System.out.println("es igual");
		        	numero2= true;
		        	listaCoches.remove(i);
		        }
		    }
		
		if (numero2 == true) {
			System.out.println("El coche ha sido borrado");
		} else {
			System.out.println("El id del coche no existe");
		}
	}

	public static void findCar() {
		System.out.println("Introduzca el id del coche que quiere obtener");
		id = sc.nextInt();
		for (Coche c : listaCoches) {
			if (c.getId() == id) {
				System.out.println("Coche encontrado");
				System.out.println(c);
			}
		}

	}

	public static void exportList() {
		
		FileManager fileTxt = new FileManager(directionTxt);
		fileTxt.safeFileTxt(listaCoches);
	}
	public static void showCars() {
		System.out.println("Los coches de la lista son:");
		
		
		for (Coche c : listaCoches) {
			System.out.println(c);
		}
	}
	public static void saveClose() {
		administrationFile.safeFile(listaCoches);
		System.out.println("Salir de la aplicacion");
		
	}

}
