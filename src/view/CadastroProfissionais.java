package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.github.lgooddatepicker.components.DatePicker;

import controller.ClienteController;
import controller.PessoaController;
import controller.ProfissionalController;
import model.vo.Cliente;
import model.vo.Pessoa;
import model.vo.Profissional;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class CadastroProfissionais extends JPanel {
	private JTextField inputNome;
	private JTextField inputCpf;
	private DatePicker inputDataNasc;
	private JTextField inputTelefone;
	private JTextField inputEmail;
	private JTextField inputRua;
	private JTextField inputBairro;
	private JLabel lblNome;
	private JLabel lblNewLabel;
	private JLabel lblCpf;
	private JLabel lblDataNascimento;
	private JLabel lblTelefone;
	private JLabel lblEmail;
	private JLabel lblRua;
	private JLabel lblBairro;
	private JLabel lblEstado;
	private JComboBox comboBoxEstado;
	private JComboBox cbFuncao;
	private JButton btnCadastrar;
	private JTextField inputCep;
	private JLabel lblCep;
	private JLabel lblFuncao;
	private Pessoa novaPessoa;
	private Profissional novoProfissional;
	private ProfissionalController profissionalController;
	private PessoaController pessoaController;

	public CadastroProfissionais() {
		setLayout(null);
		setBounds(100, 100, 746, 412);

		try {
			inputCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			inputTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
			inputCep = new JFormattedTextField(new MaskFormatter("#####-###"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(29, 72, 46, 14);
		add(lblNome);

		inputNome = new JTextField();
		inputNome.setBounds(147, 69, 210, 20);
		add(inputNome);
		inputNome.setColumns(10);

		lblNewLabel = new JLabel("Cadastro de Profissionais");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setBounds(238, 22, 335, 28);
		add(lblNewLabel);

		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(29, 106, 46, 14);
		add(lblCpf);


		inputCpf.setColumns(10);
		inputCpf.setBounds(147, 103, 210, 20);
		add(inputCpf);

		lblDataNascimento = new JLabel("Data Nascimento:");
		lblDataNascimento.setBounds(29, 138, 105, 14);
		add(lblDataNascimento);

		inputDataNasc = new DatePicker();
		inputDataNasc.getComponentDateTextField().setLocation(162, 0);
		inputDataNasc.setBounds(147, 138, 210, 20);
		add(inputDataNasc);

		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(29, 173, 55, 14);
		add(lblTelefone);

		lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(29, 206, 55, 14);
		add(lblEmail);

		lblRua = new JLabel("Rua:");
		lblRua.setBounds(401, 73, 55, 14);
		add(lblRua);

		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(401, 142, 40, 14);
		add(lblBairro);

		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(401, 106, 55, 14);
		add(lblEstado);

		inputTelefone.setColumns(10);
		inputTelefone.setBounds(147, 170, 210, 20);
		add(inputTelefone);

		inputEmail = new JTextField();
		inputEmail.setColumns(10);
		inputEmail.setBounds(147, 203, 210, 20);
		add(inputEmail);

		inputRua = new JTextField();
		inputRua.setColumns(10);
		inputRua.setBounds(494, 69, 210, 20);
		add(inputRua);

		inputBairro = new JTextField();
		inputBairro.setColumns(10);
		inputBairro.setBounds(494, 138, 210, 20);
		add(inputBairro);

		String[] estados = {
				"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", 
				"Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais",
				"Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", 
				"Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"
		};

		comboBoxEstado = new JComboBox(estados);
		comboBoxEstado.setBounds(494, 102, 210, 22);
		add(comboBoxEstado);


		lblCep = new JLabel("CEP:");
		lblCep.setBounds(401, 174, 40, 14);
		add(lblCep);

		inputCep.setColumns(10);
		inputCep.setBounds(494, 170, 210, 20);
		add(inputCep);

		lblFuncao = new JLabel("Função:");
		lblFuncao.setBounds(401, 206, 55, 14);
		add(lblFuncao);

		String[] funcao = {"Mecânico", "Funileiro", "Eletricista"};
		cbFuncao = new JComboBox(funcao);
		cbFuncao.setBounds(494, 202, 210, 22);
		add(cbFuncao);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//criar profissional
				novoProfissional = new Profissional();
				novoProfissional.setNome(inputNome.getText().trim());
				novoProfissional.setCpf(inputCpf.getText().trim());
				novoProfissional.setDtNascimento(inputDataNasc.getDate());
				novoProfissional.setTelefone(inputTelefone.getText().trim());
				novoProfissional.setEmail(inputEmail.getText().trim());
				novoProfissional.setFuncao((String) cbFuncao.getSelectedItem());

				pessoaController = new PessoaController();
				String mensagemValidacao = pessoaController.verificarCamposObrigatorios(novoProfissional);

				profissionalController = new ProfissionalController();
				mensagemValidacao += profissionalController.validarDadosProfissional(novoProfissional);

				if(mensagemValidacao.isBlank()) {
					profissionalController.cadastrarProfissional(novoProfissional);
					JOptionPane.showMessageDialog(null, "Profissional cadastrado com sucesso!", 
							"Sucess", JOptionPane.DEFAULT_OPTION);
					
					//zerar inputs
					limparInputs();
				} else {
					JOptionPane.showMessageDialog(null, mensagemValidacao, "Atenção", JOptionPane.WARNING_MESSAGE, null);
				}
			}
		});
		btnCadastrar.setBounds(539, 378, 100, 23);
		add(btnCadastrar);
	}
	
	private void limparInputs() {
		inputNome.setText("");
		inputCpf.setText("");
		inputDataNasc.setText("");
		inputTelefone.setText("");
		inputEmail.setText("");
		inputBairro.setText("");
		inputCep.setText("");
		inputRua.setText("");
	}
	
}
