package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.ClienteController;
import model.vo.Cliente;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRelatorioCliente extends JPanel {
	private JTextField inputNome;
	private JTextField inputCPF;
	private JTextField inputCidade;
	private JLabel lblTitulo;
	private JLabel lblNome;
	private JLabel lblCPF;
	private JLabel lblCidade;
	private JTable tblClientes;
	private String[] nomesColunas = {"Nome", "CPF", "Estado", "Bairro", "CEP"};

	private List<Cliente> clientes = new ArrayList<>();

	public TelaRelatorioCliente() {
		setBounds(100, 100, 746, 412);
		setLayout(null);

		lblTitulo = new JLabel("Relatório Cliente");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo.setBounds(267, 11, 296, 74);
		add(lblTitulo);

		lblNome = new JLabel("Nome:");
		lblNome.setBounds(58, 113, 46, 14);
		add(lblNome);

		inputNome = new JTextField();
		inputNome.setBounds(108, 110, 211, 20);
		add(inputNome);
		inputNome.setColumns(10);

		inputCPF = new JTextField();
		inputCPF.setColumns(10);
		inputCPF.setBounds(468, 110, 217, 20);
		add(inputCPF);

		lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(401, 113, 46, 14);
		add(lblCPF);

		inputCidade = new JTextField();
		inputCidade.setColumns(10);
		inputCidade.setBounds(108, 151, 211, 20);
		add(inputCidade);

		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(58, 154, 46, 14);
		add(lblCidade);



		tblClientes = new JTable();
		tblClientes.setBounds(58, 206, 627, 195);
		add(tblClientes);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarTabela();
			}
		});
		btnBuscar.setBounds(478, 150, 194, 23);
		add(btnBuscar);

		DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();

		
	}
	//	
	//	public PainelListagemTelefone() {
	//		setLayout(new FormLayout(new ColumnSpec[] {
	//				FormSpecs.RELATED_GAP_COLSPEC,
	//				ColumnSpec.decode("default:grow"),},
	//			new RowSpec[] {
	//				FormSpecs.RELATED_GAP_ROWSPEC,
	//				FormSpecs.DEFAULT_ROWSPEC,
	//				FormSpecs.RELATED_GAP_ROWSPEC,
	//				RowSpec.decode("default:grow"),}));
	//		
	//		
	//		tblClientes = new JTable();
	//		add(tblClientes, "2, 4, fill, fill");
	//		buscarTelefones();
	//	}

	private void limparTabela() {
		tblClientes.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));
	}

	private void atualizarTabela() {
		this.limparTabela();


		DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();

		ClienteController clienteController = new ClienteController();
		
		String cpf = inputCPF.getText();
		String cidade = inputCidade.getText();
		String nome = inputNome.getText();
		
		List<Cliente> clienteBuscado = null;
		
		clienteBuscado = clienteController.consultar(nome, cpf, cidade);

		for (Cliente cliente : clienteBuscado) {
						
						
			Object[] novaLinhaDaTabela = new Object[5];
			novaLinhaDaTabela[0] = cliente.getNome();
			novaLinhaDaTabela[1] = cliente.getCpf();
			novaLinhaDaTabela[2] = cliente.getEstado();
			novaLinhaDaTabela[3] = cliente.getBairro();
			novaLinhaDaTabela[4] = cliente.getCep();
			model.addRow(novaLinhaDaTabela);
		}
	}
}
