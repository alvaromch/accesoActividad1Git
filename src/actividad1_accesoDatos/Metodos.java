package actividad1_accesoDatos;

import java.io.Serializable;
import java.util.List;

public class Metodos implements Serializable{

	
	private static final long serialVersionUID = 5314279370405575185L;
	private List<Coche> listaCoches;
	
	public void añadirCoche(Coche coche) {
		listaCoches.add(coche);
	}
	
	public Coche obtenerCoche(int id) {
		Coche coche = new Coche();
		for (Coche c : listaCoches) {
			if(c.getId()==id) {
				System.out.println("Coche encontrado");
				coche.setId(c.getId());
				coche.setColor(c.getColor());
				coche.setMarca(c.getMarca());
				coche.setMatricula(c.getMatricula());
				coche.setModelo(c.getModelo());
			}
		}
		return coche;
	}
	
	public String borrarCoche(int id) {
		String mensaje ="Coche no encontrado";
		for(Coche c : listaCoches) {
			if(c.getId()==id) {
				listaCoches.remove(c);
				mensaje = "Coche borrado";
			}
		}
		return mensaje;
	}
	
	

}



