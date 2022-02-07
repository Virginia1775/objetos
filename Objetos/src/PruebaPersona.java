import javax.swing.JOptionPane;

import modelo.Persona;

/**
 * 
 */

/**
 * @author David
 *
 */
public class PruebaPersona {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Persona p = new Persona();
		p.setNombre("David");
		p.setApellidos("Casas");
		p.setFechaNac(3, 6, 1979);
		//p.setDni("30000000");
		
		Persona p2 = new Persona("Ana", "Pérez", "40000000");
		
		JOptionPane.showMessageDialog(null, p);
		JOptionPane.showMessageDialog(null, p2);
		
		Persona p3 = new Persona("Pepe", "Gomez", "40000000");
		if (p2.equals(p3)) {
			JOptionPane.showMessageDialog(null, "p2 y p3 son iguales");
		} else {
			JOptionPane.showMessageDialog(null, "p2 y p3 son distintos");
		}
		

	}

}
