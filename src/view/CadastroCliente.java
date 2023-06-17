package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ClienteController;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroCliente extends JPanel {
	private JTextField inputNome;
	private JTextField inputCpf;
	private JTextField inputDataNasc;
	private JTextField inputTelefone;
	private JTextField inputEmail;
	private JTextField inputRua;
	private JTextField inputBairro;
	private JTextField inputModelo;
	private JTextField inputMarca;
	private JTextField inputAno;
	private JTextField inputPlaca;
	private JLabel lblModeloCarro;
	private JLabel lblNome;
	private JLabel lblNewLabel;
	private JLabel lblCpf;
	private JLabel lblDataNascimento;
	private JLabel lblTelefone;
	private JLabel lblEmail;
	private JLabel lblRua;
	private JLabel lblBairro;
	private JLabel lblEstado;
	private JLabel lblMarca;
	private JLabel lblAno;
	private JLabel lblPlaca;
	private JComboBox comboBoxEstado;
	private JButton btnNewButton;

	public CadastroCliente() {
		setLayout(null);
		setBounds(100, 100, 746, 412);
		
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 75, 46, 14);
		add(lblNome);
		
		inputNome = new JTextField();
		inputNome.setBounds(115, 72, 210, 20);
		add(inputNome);
		inputNome.setColumns(10);
		
		lblNewLabel = new JLabel("Cadastro de Cliente");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setBounds(238, 22, 239, 28);
		add(lblNewLabel);
		
		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 109, 46, 14);
		add(lblCpf);
		
		inputCpf = new JTextField();
		inputCpf.setColumns(10);
		inputCpf.setBounds(115, 103, 210, 20);
		add(inputCpf);
		
		lblDataNascimento = new JLabel("Data Nasc:");
		lblDataNascimento.setBounds(10, 141, 55, 14);
		add(lblDataNascimento);
		
		inputDataNasc = new JTextField();
		inputDataNasc.setColumns(10);
		inputDataNasc.setBounds(115, 138, 210, 20);
		add(inputDataNasc);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 176, 55, 14);
		add(lblTelefone);
		
		lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 201, 55, 14);
		add(lblEmail);
		
		lblRua = new JLabel("Rua:");
		lblRua.setBounds(10, 236, 55, 14);
		add(lblRua);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 261, 55, 14);
		add(lblBairro);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 295, 55, 14);
		add(lblEstado);
		
		inputTelefone = new JTextField();
		inputTelefone.setColumns(10);
		inputTelefone.setBounds(115, 173, 210, 20);
		add(inputTelefone);
		
		inputEmail = new JTextField();
		inputEmail.setColumns(10);
		inputEmail.setBounds(115, 198, 210, 20);
		add(inputEmail);
		
		inputRua = new JTextField();
		inputRua.setColumns(10);
		inputRua.setBounds(115, 233, 210, 20);
		add(inputRua);
		
		inputBairro = new JTextField();
		inputBairro.setColumns(10);
		inputBairro.setBounds(115, 258, 210, 20);
		add(inputBairro);
		
		lblModeloCarro = new JLabel("Modelo Carro:");
		lblModeloCarro.setBounds(431, 75, 46, 14);
		add(lblModeloCarro);
		
		lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(431, 109, 46, 14);
		add(lblMarca);
		
		lblAno = new JLabel("Ano:");
		lblAno.setBounds(431, 141, 46, 14);
		add(lblAno);
		
		lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(431, 176, 46, 14);
		add(lblPlaca);
		
		comboBoxEstado = new JComboBox();
		comboBoxEstado.setBounds(115, 291, 210, 22);
		add(comboBoxEstado);
		
		inputModelo = new JTextField();
		inputModelo.setColumns(10);
		inputModelo.setBounds(483, 72, 210, 20);
		add(inputModelo);
		
		inputMarca = new JTextField();
		inputMarca.setColumns(10);
		inputMarca.setBounds(483, 106, 210, 20);
		add(inputMarca);
		
		inputAno = new JTextField();
		inputAno.setColumns(10);
		inputAno.setBounds(483, 138, 210, 20);
		add(inputAno);
		
		inputPlaca = new JTextField();
		inputPlaca.setColumns(10);
		inputPlaca.setBounds(483, 173, 210, 20);
		add(inputPlaca);
		
		btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// lógica de chamar o controller
				ClienteController.cadastrarCliente();
			}
		});
		btnNewButton.setBounds(539, 378, 89, 23);
		add(btnNewButton);

	}
}
