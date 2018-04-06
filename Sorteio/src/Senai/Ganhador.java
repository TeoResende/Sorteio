package Senai;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ganhador {

	private JFrame frmCadastroDoGanhador;
	private JTextField tvGanhador;
	private JLabel lblRodada;
	private JLabel lblValor;
	static String id,valor,ganhador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		id = args[0];
		valor = args[1];
		ganhador = args[2];
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ganhador window = new Ganhador();
					window.frmCadastroDoGanhador.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ganhador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDoGanhador = new JFrame();
		frmCadastroDoGanhador.setTitle("Cadastro do Ganhador");
		frmCadastroDoGanhador.setBounds(100, 100, 450, 180);
		frmCadastroDoGanhador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroDoGanhador.getContentPane().setLayout(null);
		frmCadastroDoGanhador.setLocationRelativeTo(null);
		
		JLabel label = new JLabel("Rodada:");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
		});
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(10, 11, 84, 20);
		frmCadastroDoGanhador.getContentPane().add(label);
		
		lblRodada = new JLabel("000");
		lblRodada.setForeground(Color.BLUE);
		lblRodada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRodada.setBounds(89, 11, 52, 20);
		frmCadastroDoGanhador.getContentPane().add(lblRodada);
		
		JLabel label_2 = new JLabel("Valor: ");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(249, 11, 59, 20);
		frmCadastroDoGanhador.getContentPane().add(label_2);
		
		lblValor = new JLabel("000");
		lblValor.setForeground(Color.BLUE);
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblValor.setBounds(309, 11, 52, 20);
		frmCadastroDoGanhador.getContentPane().add(lblValor);
		
		JLabel lblGanhador = new JLabel("Ganhador:");
		lblGanhador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGanhador.setBounds(10, 51, 106, 20);
		frmCadastroDoGanhador.getContentPane().add(lblGanhador);
		
		tvGanhador = new JTextField();
		tvGanhador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tvGanhador.setBounds(114, 49, 310, 26);
		frmCadastroDoGanhador.getContentPane().add(tvGanhador);
		tvGanhador.setColumns(10);
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSalvar.setBounds(10, 88, 414, 43);
		frmCadastroDoGanhador.getContentPane().add(btnSalvar);
	}

}
