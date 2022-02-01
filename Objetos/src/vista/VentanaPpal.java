package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Persona;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaPpal extends JFrame {

	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField txtA�o;
	private final JLabel label = new JLabel("/");
	private JButton btnNewButton;
	private JLabel lblNewLabel_6;
	private JTextArea txtPersonas;
	private JScrollPane scrollPane;
	private ArrayList<Persona> listaPersonas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPpal frame = new VentanaPpal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPpal() {
		// Se crea la nueva lista
		listaPersonas = new ArrayList<Persona>();
		setTitle("Gesti\u00F3n de personas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow][][][][][]", "[][][][][][grow]"));
		
		JLabel lblNewLabel = new JLabel("Introducir Personas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblNewLabel, "cell 0 0 8 1");
		
		JLabel lblNewLabel_1 = new JLabel("DNI:");
		contentPane.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		
		txtDni = new JTextField();
		contentPane.add(txtDni, "cell 1 1 4 1,growx");
		txtDni.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		contentPane.add(lblNewLabel_2, "cell 6 1,alignx trailing");
		
		txtNombre = new JTextField();
		contentPane.add(txtNombre, "cell 7 1,growx");
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellidos:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel_3, "cell 0 2,alignx trailing");
		
		txtApellidos = new JTextField();
		txtApellidos.setText("");
		contentPane.add(txtApellidos, "cell 1 2 7 1,growx");
		txtApellidos.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha Nacimiento:");
		contentPane.add(lblNewLabel_4, "cell 0 3,alignx trailing");
		
		txtDia = new JTextField();
		contentPane.add(txtDia, "cell 1 3 2 1,growx");
		txtDia.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("/");
		contentPane.add(lblNewLabel_5, "cell 3 3");
		
		txtMes = new JTextField();
		contentPane.add(txtMes, "cell 4 3,growx");
		txtMes.setColumns(10);
		contentPane.add(label, "cell 5 3");
		
		txtA�o = new JTextField();
		contentPane.add(txtA�o, "cell 6 3,growx");
		txtA�o.setColumns(10);
		
		btnNewButton = new JButton("Insertar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarPersona();
			}
		});
		contentPane.add(btnNewButton, "cell 0 4 8 1,alignx center");
		
		lblNewLabel_6 = new JLabel("Personas:");
		contentPane.add(lblNewLabel_6, "cell 0 5,alignx right,aligny top");
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 2 5 6 1,grow");
		
		txtPersonas = new JTextArea();
		txtPersonas.setEditable(false);
		scrollPane.setViewportView(txtPersonas);
	}

	public void insertarPersona() {
		Persona p1 = new Persona();
		txtPersonas.setText(null);
		
		if (txtNombre.getText()==null || txtNombre.getText().equals("") ||
			txtApellidos.getText()==null || txtApellidos.getText().equals("") ||
			txtDni.getText()==null || txtDni.getText().equals("") ||
			txtDia.getText()==null || txtDia.getText().equals("") ||
			txtMes.getText()==null || txtMes.getText().equals("") ||
			txtA�o.getText()==null || txtA�o.getText().equals("") ) {
			JOptionPane.showMessageDialog(null, "Debe rellenar todo los campos");
			return;
		}
		
		p1.setNombre(txtNombre.getText());
		p1.setApellidos(txtApellidos.getText());
		p1.setDni(txtDni.getText());
		int dia= Integer.parseInt(txtDia.getText());
		int mes= Integer.parseInt(txtMes.getText());
		int a�o= Integer.parseInt(txtA�o.getText());
		p1.setFechaNac(dia, mes, a�o );
		
		if (listaPersonas.contains(p1)) {
			JOptionPane.showMessageDialog(null, "La persona ya est� en la lista. Inserte otra");
		} else {
			listaPersonas.add(p1);

		}
		
		for (Persona persona : listaPersonas) {
			txtPersonas.setText(txtPersonas.getText()+persona+"\n");
		}
		
		
	}

}