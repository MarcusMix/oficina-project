package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import controller.OrcamentoController;
import model.vo.Orcamento;
import model.vo.Profissional;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaOrcamento extends JPanel {
	private JTextField inputCliente;
	private JTextField inputTempo;
	private JTextField inputMaoObra;
	private JLabel lblCliente;
	private JLabel lblTempo;
	private JLabel lblPecas;
	private JTextPane inputPecas;
	private JLabel lblProfissional;
	private JComboBox cbProfissionais;
	private JLabel lblDeOra;
	private JLabel lvlValorMao;
	private JLabel lblValorTotal;
	private JComponent lblTitulo;
	private JButton btnSalvar;
	private JLabel lblSituacao;
	private JComboBox cbSituacao;
	private JTextField inputValorTotal;
	private Orcamento orcamento;

	public TelaOrcamento() {
		setBounds(100, 100, 746, 412);
		setLayout(null);
		
//		try {
//			inputValorTotal = new JFormattedTextField(new MaskFormatter("        "));
//			inputMaoObra = new JFormattedTextField(new MaskFormatter("          "));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(43, 67, 46, 14);
		add(lblCliente);
		
		inputCliente = new JTextField();
		inputCliente.setBounds(99, 64, 196, 20);
		add(inputCliente);
		inputCliente.setColumns(10);
		
		inputTempo = new JTextField();
		inputTempo.setColumns(10);
		inputTempo.setBounds(99, 104, 194, 20);
		add(inputTempo);
		
		lblTempo = new JLabel("Tempo:");
		lblTempo.setBounds(43, 107, 46, 14);
		add(lblTempo);
		
		lblPecas = new JLabel("Peças:");
		lblPecas.setBounds(43, 152, 46, 14);
		add(lblPecas);
		
		inputPecas = new JTextPane();
		inputPecas.setBounds(99, 152, 196, 134);
		add(inputPecas);
		
		lblProfissional = new JLabel("Profissional:");
		lblProfissional.setBounds(410, 67, 86, 14);
		add(lblProfissional);
		
		OrcamentoController orcamentoController = new OrcamentoController();
		ArrayList<Profissional> profissionais = orcamentoController.pegarProfissionais();
		
		cbProfissionais = new JComboBox(profissionais.toArray());
		cbProfissionais.setBounds(487, 63, 196, 22);
		add(cbProfissionais);
		
		lvlValorMao = new JLabel("R$ Mão");
		lvlValorMao.setHorizontalAlignment(SwingConstants.LEFT);
		lvlValorMao.setVerticalAlignment(SwingConstants.TOP);
		lvlValorMao.setBounds(410, 104, 46, 17);
		add(lvlValorMao);
		
		inputMaoObra = new JTextField();
		inputMaoObra.setColumns(10);
		inputMaoObra.setBounds(487, 104, 196, 20);
		add(inputMaoObra);
		
		lblDeOra = new JLabel("de Obra");
		lblDeOra.setVerticalAlignment(SwingConstants.TOP);
		lblDeOra.setHorizontalAlignment(SwingConstants.LEFT);
		lblDeOra.setBounds(410, 120, 46, 17);
		add(lblDeOra);
		
		inputValorTotal = new JTextField();
		inputValorTotal.setColumns(10);
		inputValorTotal.setBounds(487, 149, 196, 20);
		add(inputValorTotal);
		
		lblValorTotal = new JLabel("Valor total:");
		lblValorTotal.setBounds(410, 152, 86, 14);
		add(lblValorTotal);
		
		lblTitulo = new JLabel("Orçamento");
		lblTitulo.setFont(new Font("Poppins Black", Font.PLAIN, 21));
		lblTitulo.setBounds(285, 11, 187, 34);
		add(lblTitulo);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				//montar orçamento
				orcamento = new Orcamento();
				orcamento.setPecas(inputPecas.getText());
				orcamento.setSituacao((String) cbSituacao.getSelectedItem());
				orcamento.setTempoManutencao(inputTempo.getText());
				orcamento.setValorTotal(inputValorTotal.getText());
				orcamento.setValorTrabalho(inputMaoObra.getText());
				
				OrcamentoController orcamentoController = new OrcamentoController();
				String mensagemValidacao = orcamentoController.verificarCamposObrigatorios(orcamento);
				
				if(mensagemValidacao.isBlank()) {
					orcamentoController.cadastrarOrcamento(orcamento);
					JOptionPane.showMessageDialog(null, "Orcamento criado!", 
							"Sucess", JOptionPane.DEFAULT_OPTION);	
				} else {
					JOptionPane.showMessageDialog(null, mensagemValidacao, "Atenção", JOptionPane.WARNING_MESSAGE, null);
				}
			}
		});
		btnSalvar.setBounds(564, 359, 89, 23);
		add(btnSalvar);
		
		lblSituacao = new JLabel("Situação:");
		lblSituacao.setBounds(410, 189, 86, 14);
		add(lblSituacao);
		
		String[] estados = {
				"Em andamento", "Finalizado", "Pago", "Atrasado"
		};

		
		cbSituacao = new JComboBox(estados);
		cbSituacao.setBounds(487, 185, 196, 22);
		add(cbSituacao);
	}
}
