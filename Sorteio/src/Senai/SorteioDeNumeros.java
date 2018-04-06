package Senai;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JTextField;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SorteioDeNumeros {

	static JFrame frmSorteioDeNmeros;
	private JTextField tvValorMaximo;
	private JLabel lblValorGerado;
	private JLabel lblValorSelect;
	private JLabel lblRodadaSelect;
	private JLabel lblGanhadorSelect;
	private JLabel lblRodadaAtual;
	private JButton btnSelecionar;
	private JButton btnAvanar;
	Connection conexao = null;
	ResultSet dados;
	private JButton btnVoltar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SorteioDeNumeros window = new SorteioDeNumeros();
					window.frmSorteioDeNmeros.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SorteioDeNumeros() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSorteioDeNmeros = new JFrame();
		frmSorteioDeNmeros.setTitle("Sorteio de N\u00FAmeros");
		frmSorteioDeNmeros.setBounds(100, 100, 529, 487);
		frmSorteioDeNmeros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSorteioDeNmeros.getContentPane().setLayout(null);
		frmSorteioDeNmeros.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("GERADOR DE N\u00DAMEROS");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 493, 39);
		frmSorteioDeNmeros.getContentPane().add(lblNewLabel);
		
		JLabel lblValorMaximo = new JLabel("Valor Maximo: ");
		lblValorMaximo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValorMaximo.setBounds(343, 165, 108, 14);
		frmSorteioDeNmeros.getContentPane().add(lblValorMaximo);
		
		tvValorMaximo = new JTextField();
		tvValorMaximo.setHorizontalAlignment(SwingConstants.RIGHT);
		tvValorMaximo.setText("100");
		tvValorMaximo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tvValorMaximo.setBounds(451, 162, 52, 20);
		frmSorteioDeNmeros.getContentPane().add(tvValorMaximo);
		tvValorMaximo.setColumns(10);
		
		JButton btnGerar = new JButton("GERAR N\u00DAMERO");
		btnGerar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGerar.setBounds(10, 61, 493, 52);
		frmSorteioDeNmeros.getContentPane().add(btnGerar);
		
		JLabel lblRodada = new JLabel("Rodada: ");
		lblRodada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRodada.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRodada.setBounds(10, 135, 249, 28);
		frmSorteioDeNmeros.getContentPane().add(lblRodada);
		
		lblRodadaAtual = new JLabel("0");
		lblRodadaAtual.setForeground(Color.BLUE);
		lblRodadaAtual.setHorizontalAlignment(SwingConstants.LEFT);
		lblRodadaAtual.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRodadaAtual.setBounds(261, 135, 242, 28);
		frmSorteioDeNmeros.getContentPane().add(lblRodadaAtual);
		
		lblValorGerado = new JLabel("0");
		lblValorGerado.setForeground(Color.BLUE);
		lblValorGerado.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblValorGerado.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorGerado.setBounds(10, 161, 493, 61);
		frmSorteioDeNmeros.getContentPane().add(lblValorGerado);
		
		JLabel lblRodadasAnteriores = new JLabel("Rodadas Anteriores");
		lblRodadasAnteriores.setForeground(Color.BLUE);
		lblRodadasAnteriores.setHorizontalAlignment(SwingConstants.CENTER);
		lblRodadasAnteriores.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRodadasAnteriores.setBounds(10, 230, 493, 28);
		frmSorteioDeNmeros.getContentPane().add(lblRodadasAnteriores);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 220, 493, 2);
		frmSorteioDeNmeros.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 51, 493, 2);
		frmSorteioDeNmeros.getContentPane().add(separator_1);
		
		btnVoltar = new JButton(" VOLTAR <|");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVoltar.setBounds(10, 315, 160, 52);
		frmSorteioDeNmeros.getContentPane().add(btnVoltar);
		
		
		btnSelecionar = new JButton("|SELECIONAR|");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSelecionar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSelecionar.setBounds(177, 315, 160, 52);
		frmSorteioDeNmeros.getContentPane().add(btnSelecionar);
		
		btnAvanar = new JButton("|> AVAN\u00C7AR");
		btnAvanar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAvanar.setBounds(343, 315, 160, 52);
		frmSorteioDeNmeros.getContentPane().add(btnAvanar);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 378, 493, 2);
		frmSorteioDeNmeros.getContentPane().add(separator_2);
		
		JButton btnZerar = new JButton("ZERAR (Reiniciar)");
		btnZerar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnZerar.setBounds(10, 385, 493, 52);
		frmSorteioDeNmeros.getContentPane().add(btnZerar);
		
		JLabel lblRodada_1 = new JLabel("Rodada:");
		lblRodada_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRodada_1.setBounds(10, 269, 84, 20);
		frmSorteioDeNmeros.getContentPane().add(lblRodada_1);
		
		JLabel lblValor = new JLabel("Valor: ");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblValor.setBounds(136, 269, 59, 20);
		frmSorteioDeNmeros.getContentPane().add(lblValor);
		
		JLabel lblGanhador = new JLabel("Ganhador: ");
		lblGanhador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGanhador.setBounds(243, 269, 104, 20);
		frmSorteioDeNmeros.getContentPane().add(lblGanhador);
		
		lblRodadaSelect = new JLabel("000");
		lblRodadaSelect.setForeground(Color.BLUE);
		lblRodadaSelect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRodadaSelect.setBounds(89, 269, 52, 20);
		frmSorteioDeNmeros.getContentPane().add(lblRodadaSelect);
		
		lblValorSelect = new JLabel("000");
		lblValorSelect.setForeground(Color.BLUE);
		lblValorSelect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblValorSelect.setBounds(193, 269, 52, 20);
		frmSorteioDeNmeros.getContentPane().add(lblValorSelect);
		
		lblGanhadorSelect = new JLabel("Fulano");
		lblGanhadorSelect.setForeground(Color.BLUE);
		lblGanhadorSelect.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGanhadorSelect.setBounds(343, 269, 160, 20);
		frmSorteioDeNmeros.getContentPane().add(lblGanhadorSelect);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 124, 493, 2);
		frmSorteioDeNmeros.getContentPane().add(separator_3);
		

		
		
		
		
	}//fim do metodo inicialize
	
}//fim da classe
