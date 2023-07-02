package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DatePicker;

import controller.AutomovelController;
import controller.ClienteController;
import controller.PessoaController;
import model.vo.Automovel;
import model.vo.Cliente;
import model.vo.Pessoa;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class CadastroCliente extends JPanel {
	private JTextField inputNome;
	private JTextField inputCpf;
	private JTextField inputDataNasc;
	private JTextField inputTelefone;
	private JTextField inputEmail;
	private JTextField inputRua;
	private JTextField inputCEP;
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
	private JButton btnCadastro;
	private JTextField inputBairro;
	private JLabel lblCEP;
	private DatePicker dtNasc;
	
	//classes pca
	private Pessoa novaPessoa;
	private Cliente novoCliente;
	private Automovel novoAutomovel;

	public CadastroCliente() {
		setLayout(null);
		setBounds(100, 100, 746, 412);
		
		try {
			inputCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			inputTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
			inputCEP = new JFormattedTextField(new MaskFormatter("#####-###"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(29, 72, 46, 14);
		add(lblNome);

		inputNome = new JTextField();
		inputNome.setBounds(142, 69, 210, 20);
		add(inputNome);
		inputNome.setColumns(10);

		lblNewLabel = new JLabel("Cadastro de Cliente");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setBounds(238, 22, 239, 28);
		add(lblNewLabel);

		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(29, 108, 46, 14);
		add(lblCpf);

		
		inputCpf.setColumns(10);
		inputCpf.setBounds(142, 105, 210, 20);
		add(inputCpf);

		lblDataNascimento = new JLabel("Data Nascimento:");
		lblDataNascimento.setBounds(29, 141, 448, 14);
		add(lblDataNascimento);

		dtNasc = new DatePicker();
		dtNasc.getComponentDateTextField().setLocation(0, 138);
		dtNasc.setBounds(142, 138, 210, 20);
		add(dtNasc);

		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(29, 173, 55, 14);
		add(lblTelefone);

		lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(29, 207, 55, 14);
		add(lblEmail);

		lblRua = new JLabel("Rua:");
		lblRua.setBounds(29, 244, 55, 14);
		add(lblRua);

		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(29, 315, 55, 14);
		add(lblBairro);

		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(29, 280, 55, 14);
		add(lblEstado);

		inputTelefone.setColumns(10);
		inputTelefone.setBounds(142, 173, 210, 20);
		add(inputTelefone);

		inputEmail = new JTextField();
		inputEmail.setColumns(10);
		inputEmail.setBounds(142, 204, 210, 20);
		add(inputEmail);

		inputRua = new JTextField();
		inputRua.setColumns(10);
		inputRua.setBounds(142, 241, 210, 20);
		add(inputRua);

		inputCEP.setColumns(10);
		inputCEP.setBounds(142, 348, 210, 20);
		add(inputCEP);

		lblModeloCarro = new JLabel("Modelo Carro:");
		lblModeloCarro.setBounds(392, 72, 68, 14);
		add(lblModeloCarro);

		lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(392, 108, 46, 14);
		add(lblMarca);

		lblAno = new JLabel("Ano:");
		lblAno.setBounds(392, 141, 85, 14);
		add(lblAno);

		lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(392, 176, 46, 14);
		add(lblPlaca);

		String[] estados = {
				"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", 
				"Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais",
				"Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", 
				"Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"
		};

		comboBoxEstado = new JComboBox(estados);
		comboBoxEstado.setBounds(142, 276, 210, 22);
		add(comboBoxEstado);

		inputModelo = new JTextField();
		inputModelo.setColumns(10);
		inputModelo.setBounds(509, 69, 210, 20);
		add(inputModelo);

		inputMarca = new JTextField();
		inputMarca.setColumns(10);
		inputMarca.setBounds(509, 105, 210, 20);
		add(inputMarca);

		inputAno = new JTextField();
		inputAno.setColumns(10);
		inputAno.setBounds(509, 138, 210, 20);
		add(inputAno);

		inputPlaca = new JTextField();
		inputPlaca.setColumns(10);
		inputPlaca.setBounds(509, 173, 210, 20);
		add(inputPlaca);
		
		

		btnCadastro = new JButton("Cadastrar");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//criar cliente com os dados digitados
				novoCliente = new Cliente();
				novoCliente.setNome(inputNome.getText().trim());
				novoCliente.setCpf(inputCpf.getText().trim());
				novoCliente.setDtNascimento(dtNasc.getDate());
				novoCliente.setTelefone(inputTelefone.getText().trim());
				novoCliente.setEmail(inputEmail.getText().trim());
				novoCliente.setRua(inputRua.getText());
				novoCliente.setEstado((String) comboBoxEstado.getSelectedItem());
				novoCliente.setBairro(inputCEP.getText().trim());
				novoCliente.setCep(inputCEP.getText().trim());

				//criar automovel
				novoAutomovel = new Automovel();
				novoAutomovel.setModelo(inputModelo.getText().trim());
				novoAutomovel.setMarca(inputMarca.getText().trim());
				novoAutomovel.setAno(inputAno.getText().trim());
				novoAutomovel.setPlaca(inputPlaca.getText().trim());

				PessoaController pessoaController = new PessoaController();
				ClienteController clienteController = new ClienteController();
				AutomovelController automovelController = new AutomovelController();
				
				
				//verificar campos obrigatorios
//				String mensagemValidacao = pessoaController.verificarCamposObrigatorios(novoCliente);
				
				String mensagemValidacao = clienteController.verificarCamposObrigatorios(novoCliente);
				
				mensagemValidacao +=  automovelController.verificarCamposObrigatorios(novoAutomovel);
				
				
				if(mensagemValidacao.isBlank()) {
					clienteController.cadastrarCliente(novoCliente, novoAutomovel);
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", 
							"Sucess", JOptionPane.DEFAULT_OPTION);
					
					limparInputs();
				} else {
					JOptionPane.showMessageDialog(null, mensagemValidacao, "Atenção", JOptionPane.WARNING_MESSAGE, null);
				}		
			}
		});
		btnCadastro.setBounds(539, 378, 89, 23);
		add(btnCadastro);

		lblCEP = new JLabel("CEP:");
		lblCEP.setBounds(29, 351, 46, 14);
		add(lblCEP);

		inputBairro = new JTextField();
		inputBairro.setBounds(142, 312, 210, 20);
		add(inputBairro);
		inputBairro.setColumns(10);

	}
	
	private void limparInputs() {
		inputNome.setText("");
		inputCpf.setText("");
		inputTelefone.setText("");
		inputEmail.setText("");
		inputRua.setText("");
		inputBairro.setText("");
		inputCEP.setText("");
		inputModelo.setText("");
		inputMarca.setText("");
		inputAno.setText("");
		inputPlaca.setText("");
	}
}
