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

public class FileManager {
	File fichero;
	static List<Coche> listaCoches = new ArrayList();
	public FileManager(String directionFile) {
		fichero = new File(directionFile);
	}

	
	public List<Coche> readFile(){
		
		if (fichero.exists()) {
			try (FileInputStream fis = new FileInputStream(fichero);
					ObjectInputStream ois = new ObjectInputStream(fis);) {

				listaCoches = (List<Coche>) ois.readObject();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return listaCoches;
	}  
	public void safeFile(List listaCoches) {
		try (FileOutputStream fos = new FileOutputStream(fichero);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {

			oos.writeObject(listaCoches);
			System.out.println("Archivo salvado");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void safeFileTxt(List listaCoches) {
		try {if(fichero.createNewFile()) {
			System.out.println("Se ha creado el fichero .txt");
			
			FileWriter fw = new FileWriter(fichero);
			 BufferedWriter escritura = new BufferedWriter(fw);
			    for(int i=0;i<listaCoches.size();i++){
			        escritura.write(((Coche) listaCoches.get(i)).toExport());
			        escritura.newLine();

			    }
			    escritura.close();
			
		}else {
			System.out.println("No se ha creado el fichero .txt");
		}
			
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
