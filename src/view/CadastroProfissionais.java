package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ClienteController;
import controller.PessoaController;
import controller.ProfissionalController;
import model.vo.Cliente;
import model.vo.Pessoa;
import model.vo.Profissional;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class CadastroProfissionais extends JPanel {
	private JTextField inputNome;
	private JTextField inputCpf;
	private JTextField inputDataNasc;
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
	private JButton btnNewButton;
	private JTextField inputCep;
	private Pessoa novaPessoa;
	private Profissional novoProfissional;

	public CadastroProfissionais() {
		setLayout(null);
		setBounds(100, 100, 746, 412);

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(29, 72, 46, 14);
		add(lblNome);

		inputNome = new JTextField();
		inputNome.setBounds(115, 72, 210, 20);
		add(inputNome);
		inputNome.setColumns(10);

		lblNewLabel = new JLabel("Cadastro de Profissionais");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setBounds(238, 22, 335, 28);
		add(lblNewLabel);

		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(29, 106, 46, 14);
		add(lblCpf);

		inputCpf = new JTextField();
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
		lblRua.setBounds(397, 72, 55, 14);
		add(lblRua);

		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(397, 138, 40, 14);
		add(lblBairro);

		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(397, 109, 55, 14);
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
		inputRua.setBounds(447, 72, 210, 20);
		add(inputRua);

		inputBairro = new JTextField();
		inputBairro.setColumns(10);
		inputBairro.setBounds(447, 135, 210, 20);
		add(inputBairro);

		String[] estados = {
				"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", 
				"Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais",
				"Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", 
				"Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"
		};

		comboBoxEstado = new JComboBox(estados);
		comboBoxEstado.setBounds(447, 106, 210, 22);
		add(comboBoxEstado);
		
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(397, 173, 40, 14);
		add(lblCep);
		
		inputCep = new JTextField();
		inputCep.setColumns(10);
		inputCep.setBounds(447, 170, 210, 20);
		add(inputCep);
		
		JLabel lblFuncao = new JLabel("Função:");
		lblFuncao.setBounds(382, 201, 55, 14);
		add(lblFuncao);
		
		String[] funcao = {"Mecânico", "Funileiro", "Eletricista"};
		JComboBox cbFuncao = new JComboBox(funcao);
		cbFuncao.setBounds(447, 201, 210, 22);
		add(cbFuncao);
		
		btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {

			private ProfissionalController profissionalController;
			private PessoaController pessoaController;

			public void actionPerformed(ActionEvent e) {
				//criar profissional
				novoProfissional = new Profissional();
				novoProfissional.setNome(inputNome.getText().trim());
				novoProfissional.setCpf(inputCpf.getText());
				novoProfissional.setDtNascimento(inputDataNasc.getText());
				novoProfissional.setTelefone(inputTelefone.getText());
				novoProfissional.setEmail(inputEmail.getText());
				novoProfissional.setFuncao((String) cbFuncao.getSelectedItem());

				pessoaController = new PessoaController();
				String mensagemValidacao = pessoaController.verificarCamposObrigatorios(novoProfissional);
				
				profissionalController = new ProfissionalController();
				mensagemValidacao += profissionalController.validarDadosProfissional(novoProfissional);
				
				if(mensagemValidacao.isBlank()) {
					//TODO chamar o salvar/cadastrar/inserir
				}else {
					JOptionPane.showMessageDialog(null, mensagemValidacao, "Atenção", JOptionPane.WARNING_MESSAGE, null);
				}
			}
		});
		btnNewButton.setBounds(539, 378, 100, 23);
		add(btnNewButton);
	
	}
}
