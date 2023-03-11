package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Aprobador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class AprobadorMateria extends JFrame {

	private JPanel contentPane;
	private JTextArea texto;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AprobadorMateria frame = new AprobadorMateria();
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
	public AprobadorMateria() {
		setTitle("Aprobador de Materias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("¡Bienvenido! En esta aplicacion los estudiantes");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(94, 23, 278, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("INICIAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Aprobador.aprobador(btnNewButton, texto);	
				} catch(Exception e1) {	
					System.out.println("Cancel button");
				}		
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(159, 92, 112, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblPodranGestionarLas = new JLabel(" podran gestionar las notas de su materia.");
		lblPodranGestionarLas.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPodranGestionarLas.setBounds(104, 50, 268, 16);
		contentPane.add(lblPodranGestionarLas);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textArea.setEditable(false);
		textArea.setBounds(39, 137, 358, 98);
		contentPane.add(textArea);
		texto = textArea;
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
