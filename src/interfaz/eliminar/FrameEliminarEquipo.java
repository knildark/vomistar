package interfaz.eliminar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import colecciones.Compania;
import interfaz.FrameInterfaz;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class FrameEliminarEquipo extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEquipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Compania datosEmpresa) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameEliminarEquipo frame = new FrameEliminarEquipo(datosEmpresa);
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
	public FrameEliminarEquipo(Compania datosEmpresa) {
		setTitle("Eliminar Equipo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 138);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar equipo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreDelPlan = new JLabel("Nombre Equipo");
		lblNombreDelPlan.setBounds(10, 23, 84, 14);
		contentPane.add(lblNombreDelPlan);
		
		textFieldEquipo = new JTextField();
		textFieldEquipo.setBounds(104, 20, 136, 20);
		contentPane.add(textFieldEquipo);
		textFieldEquipo.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 56, 429, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				datosEmpresa.getPlanes().eliminar(textFieldEquipo.getText());
				JOptionPane.showMessageDialog(null, "Equipo Eliminado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				
				FrameInterfaz fInterfaz = new FrameInterfaz(datosEmpresa);
				fInterfaz.setVisible(true);
				dispose();
			}
		});
		btnEliminar.setBounds(330, 11, 89, 23);
		panel.add(btnEliminar);
		
		JLabel lblDatosDelEquipo = new JLabel("");
		lblDatosDelEquipo.setBounds(10, 11, 200, 14);
		panel.add(lblDatosDelEquipo);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			if (datosEmpresa.getEquipos().buscarEquipo(textFieldEquipo.getText())!=null){
			// PLAN EXISTE
			
			textFieldEquipo.setEnabled(false);
			btnEliminar.setEnabled(true);
			lblDatosDelEquipo.setBackground(Color.blue);
			lblDatosDelEquipo.setText("Se ha encontrado el equipo");
			
				}else {
					lblDatosDelEquipo.setBackground(Color.RED);
					lblDatosDelEquipo.setText("El equipo no existe");
					}
			
			}
			
			
		});
		btnBuscar.setBounds(250, 19, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameInterfaz fInterfaz = new FrameInterfaz(datosEmpresa);
				fInterfaz.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setBounds(350, 19, 89, 23);
		contentPane.add(btnCancelar);
	
	}
}
