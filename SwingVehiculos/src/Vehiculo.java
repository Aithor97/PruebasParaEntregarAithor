import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Vehiculo extends JFrame implements ActionListener {

	JLabel Marca;
	JComboBox<String> desplegable1;
	JLabel Modelo;
	JTextField cajatexto1;
	JLabel Motor;
	JComboBox<String> desplegable2;
	JLabel Potencia;
	JTextField cajatexto2;
	JButton agregar;
	JButton eliminar;
	JButton limpiar;
	JButton guardar;
	JTable tabla;

	public Vehiculo() {
		super("Vehiculos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		JPanel p = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));
		p3.setLayout(new FlowLayout());
		Marca = new JLabel("Marca:");
		p.add(Marca);
		desplegable1 = new JComboBox();
		p.add(desplegable1);
		Modelo = new JLabel("Modelo:");
		p.add(Modelo);
		cajatexto1 = new JTextField();
		p.add(cajatexto1);
		Motor = new JLabel("Motor:");
		p.add(Motor);
		desplegable2 = new JComboBox<String>();
		desplegable2.addItem("Gasolina");
		desplegable2.addItem("Híbrido");
		desplegable2.addItem("Diesel");
		desplegable2.addItem("Eléctrico");
		p.add(desplegable2);
		Potencia = new JLabel("Potencia:");
		p.add(Potencia);
		cajatexto2 = new JTextField();
		p.add(cajatexto2);

		agregar = new JButton("Agregar");
		agregar.addActionListener(this);
		agregar.setActionCommand("Agregar");
		p2.add(agregar);
		eliminar = new JButton("Eliminar");
		eliminar.addActionListener(this);
		eliminar.setActionCommand("Eliminar");
		p2.add(eliminar);
		limpiar = new JButton("Limpiar");
		limpiar.addActionListener(this);
		limpiar.setActionCommand("Limpiar");
		p2.add(limpiar);
		guardar = new JButton("Guardar");
		guardar.addActionListener(this);
		guardar.setActionCommand("Guardar");
		p2.add(guardar);
		tabla = new JTable(new DefaultTableModel(new String[] { "Marca", "Modelo", "Motor", "Potencia"

		}, 0));
		tabla.setFillsViewportHeight(true);
		p3.add(new JScrollPane(tabla));

		c.add(p);
		c.add(p2);
		c.add(p3);

		pack();
		leerFichero();

	}

	public void leerFichero(){
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(
					new InputStreamReader(
					getClass().getResourceAsStream("/marcas.txt")));
			System.out.println("Leyendo fichero...");
			String linea;
			while ((linea = br.readLine()) != null) {
				desplegable1.addItem((linea));
			}



		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != br) {
					br.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Vehiculo().setVisible(true);
			}

		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Agregar")) {
			if(!cajatexto1.getText().trim().equals("") && !cajatexto2.getText().trim().equals("")) {
			Object[] row= {desplegable1.getSelectedItem(),cajatexto1.getText(),desplegable2.getSelectedItem(),cajatexto2.getText()};
			((DefaultTableModel)tabla.getModel()).addRow(row);
			}else {
				JOptionPane.showMessageDialog(null, "Por favor, añada campos","Error",JOptionPane.ERROR_MESSAGE);
			}
		} else if (actionCommand.equals("Eliminar")) {
			if(tabla.getSelectedRow()>=0) {
				((DefaultTableModel)tabla.getModel()).removeRow(tabla.getSelectedRow());
			}else {
				JOptionPane.showMessageDialog(null, "Por favor, seleccione una columna","Aviso",JOptionPane.WARNING_MESSAGE);
			}

		} else if (actionCommand.equals("Limpiar")) {
			if(!cajatexto1.getText().trim().equals("") && !cajatexto2.getText().trim().equals("")) {
				cajatexto1.setText(null);
				cajatexto2.setText(null);
				
			}else {
				JOptionPane.showMessageDialog(null, "Rellene los campos para poder limpiar","Aviso",JOptionPane.WARNING_MESSAGE);
			}

		} else if (actionCommand.equals("Guardar")) {
			guardarLista();
		}

	}
	private void guardarLista() {
		JFileChooser fc = new JFileChooser();
		int resultado = fc.showSaveDialog(this);
		if (resultado == JFileChooser.APPROVE_OPTION) {
			BufferedOutputStream out = null;
			try {
				out =  new BufferedOutputStream(new FileOutputStream("Tabla.txt"));
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}finally {
				if (out != null)
					try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}
	}
	
}
