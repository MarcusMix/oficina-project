package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

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
	private JButton btnNewButton;
	private JTextField inputBairro;

	public CadastroCliente() {
		setLayout(null);
		setBounds(100, 100, 746, 412);
//		
//		if(email.indexOf(“@”) == -1 || s.indexOf(“.”) == -1) {
//			
//		}
		
		try {
			inputCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			inputTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
			inputCEP = new JFormattedTextField(new MaskFormatter("#####-###"));
//			inputD
		} catch (ParseException e) {
			e.printStackTrace();
		}

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(29, 72, 46, 14);
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
		lblCpf.setBounds(29, 106, 46, 14);
		add(lblCpf);


		inputCpf.setColumns(10);
		inputCpf.setBounds(115, 103, 210, 20);
		add(inputCpf);

		lblDataNascimento = new JLabel("Data Nasc:");
		lblDataNascimento.setBounds(29, 138, 55, 14);
		add(lblDataNascimento);

		inputDataNasc = new JTextField();
		inputDataNasc.setColumns(10);
		inputDataNasc.setBounds(115, 138, 210, 20);
		add(inputDataNasc);

		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(29, 173, 55, 14);
		add(lblTelefone);

		lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(29, 198, 55, 14);
		add(lblEmail);

		lblRua = new JLabel("Rua:");
		lblRua.setBounds(29, 233, 55, 14);
		add(lblRua);

		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(29, 299, 55, 14);
		add(lblBairro);

		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(29, 265, 55, 14);
		add(lblEstado);

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

		inputCEP.setColumns(10);
		inputCEP.setBounds(115, 330, 210, 20);
		add(inputCEP);

		lblModeloCarro = new JLabel("Modelo Carro:");
		lblModeloCarro.setBounds(431, 75, 68, 14);
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

		String[] estados = {
				"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", 
				"Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais",
				"Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", 
				"Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"
		};

		comboBoxEstado = new JComboBox(estados);
		comboBoxEstado.setBounds(115, 264, 210, 22);
		add(comboBoxEstado);

		inputModelo = new JTextField();
		inputModelo.setColumns(10);
		inputModelo.setBounds(509, 72, 210, 20);
		add(inputModelo);

		inputMarca = new JTextField();
		inputMarca.setColumns(10);
		inputMarca.setBounds(509, 106, 210, 20);
		add(inputMarca);

		inputAno = new JTextField();
		inputAno.setColumns(10);
		inputAno.setBounds(509, 138, 210, 20);
		add(inputAno);

		inputPlaca = new JTextField();
		inputPlaca.setColumns(10);
		inputPlaca.setBounds(509, 173, 210, 20);
		add(inputPlaca);
		
		

		btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//criar pessoa com os dados dgitados
				Pessoa novaPessoa = new Pessoa();
				novaPessoa.setNome(inputNome.getText().trim());
				novaPessoa.setCpf(inputCpf.getText());
				novaPessoa.setDtNascimento(inputDataNasc.getText());
				novaPessoa.setTelefone(inputTelefone.getText());
				novaPessoa.setEmail(inputEmail.getText());

				//criar cliente com os dados digitados
				Cliente novoCliente = new Cliente();
				novoCliente.setRua(inputRua.getText());
				novoCliente.setEstado((String) comboBoxEstado.getSelectedItem());
				novoCliente.setBairro(inputCEP.getText());
				novoCliente.setCep(inputCEP.getText());


				//criar automovel
				Automovel novoAutomovel = new Automovel();
				novoAutomovel.setModelo(inputModelo.getText());
				novoAutomovel.setMarca(inputMarca.getText());
				novoAutomovel.setAno(inputAno.getText());
				novoAutomovel.setPlaca(inputPlaca.getText());

				PessoaController pessoaController = new PessoaController();
				ClienteController clienteController = new ClienteController();
				AutomovelController automovelController = new AutomovelController();
				//verificar campos obrigatorios
				if(pessoaController.verificarCamposObrigatorios(novaPessoa)
						&& clienteController.verificarCamposObrigatorios(novoCliente)
						&& automovelController.verificarCamposObrigatorios(novoAutomovel)
						) {

					// lógica de chamar o controller
					pessoaController.cadastrarPessoa(novaPessoa);
					clienteController.cadastrarCliente(novoCliente);
					automovelController.cadastrarAutomovel(novoAutomovel);
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", 
							"Sucess", JOptionPane.DEFAULT_OPTION);
				}
			}



		});
		btnNewButton.setBounds(539, 378, 89, 23);
		add(btnNewButton);

		JLabel lblCEP = new JLabel("CEP:");
		lblCEP.setBounds(29, 333, 46, 14);
		add(lblCEP);

		inputBairro = new JTextField();
		inputBairro.setBounds(115, 296, 210, 20);
		add(inputBairro);
		inputBairro.setColumns(10);

	}
}
