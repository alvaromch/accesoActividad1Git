package actividad1_accesoDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class main {

	public static void main(String[] args) {

		List<Coche> listaCoches = new ArrayList();
		Coche coche = new Coche();
		Scanner sc = new Scanner(System.in);
		int opcion;
		boolean continuar = true;
		int id;
		String matricula, marca, modelo, color;

		File fichero = new File("coches.dat");
		if (fichero.exists()) {
			try (FileInputStream fis = new FileInputStream(fichero);
					ObjectInputStream ois = new ObjectInputStream(fis);) {
				
				listaCoches = (List<Coche>) ois.readObject();
				
			}catch(Exception e) {
				System.out.println(e);
			}
		} else {
			
		}
		while (continuar == true) {
			System.out.println("Elige una de las siguientes opciones");
			System.out.println("Añadir coche --> pulsar el 1");
			System.out.println("Borrar coche por id --> pulsar el 2");
			System.out.println("Buscar coche por id --> pulsar el 3");
			System.out.println("Listado de los coches --> pulsar el 4");
			System.out.println("Exportar datos --> pulsa el 5");
			System.out.println("Salir del programa --> pulsa el 6");
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:

				System.out.println("Introduzca el id del coche");
				id = sc.nextInt();
				boolean numero = false;
				for (Coche c : listaCoches) {
					if (c.getId() == id) {
						System.out.println("El id tiene que ser único");
						numero = true;

					}
				}
				if (numero == false) {
					System.out.println("Introduzca la matricula del coche");
					matricula = sc.next();
					for (Coche c : listaCoches) {
						if (c.getMatricula().equalsIgnoreCase(matricula)) {
							System.out.println("La matricula tiene que ser única");
							numero = true;
						}
					}
					if (numero == false) {
						System.out.println("Introduzca el la marca del coche");
						marca = sc.next();
						System.out.println("Introduzca el modelo del coche");
						modelo = sc.next();
						System.out.println("Introduzca el color del coche");
						color = sc.next();
						Coche coche1 = new Coche(id, matricula, marca, modelo, color);
						listaCoches.add(coche1);
					}
				}

				break;

			case 2:
				System.out.println("Introduzca el id del coche que quiere borrar");
				id = sc.nextInt();
				boolean numero2 = false;
				for (Coche c : listaCoches) {
					if (c.getId() == id) {

						listaCoches.remove(c);
						numero2 = true;
					}
				}
				if (numero2 == true) {
					System.out.println("El coche ha sido borrado");
				} else {
					System.out.println("El id del coche no existe");
				}
				break;
			case 3:
				System.out.println("Introduzca el id del coche que quiere obtener");
				id = sc.nextInt();
				for (Coche c : listaCoches) {
					if (c.getId() == id) {
						System.out.println("Coche encontrado");
						System.out.println(c);
					}
				}

				break;
			case 4:
				System.out.println("Los coches de la lista son:");
				for (Coche c : listaCoches) {
					System.out.println(c);
				}
				break;
			case 5:
				try (FileOutputStream fos = new FileOutputStream(fichero);
						 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
					
						oos.writeObject(listaCoches);
						System.out.println("Datos exportados");
					} catch (IOException e) {
						e.printStackTrace();
					} 
				break;
			case 6:
				continuar = false;
				
				try (FileOutputStream fos = new FileOutputStream(fichero);
						 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
					
						oos.writeObject(listaCoches);
						System.out.println("Archivo salvado");
					} catch (IOException e) {
						e.printStackTrace();
					} 
				System.out.println("Salir de la aplicación");
				break;

			}
		
		}

	}
}
