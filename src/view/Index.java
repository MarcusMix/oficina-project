package view;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuItem;

public class Index extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu menuOrcamento;
	private JMenu menuRelatorios;
	private JMenu menuSobre;
	
	private CadastroCliente cadastroPainel;
	private CadastroProfissionais cadastroPro;
	private JMenuItem subMenuCliente;
	private JMenuItem subMenuPro;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
//		setBounds(100, 100, 746, 412);
		setBounds(100, 100, 746, 480);
		setLocationRelativeTo(null);
		setTitle("Oficina Mecânica");
		setResizable(false);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		
//		CadastroCliente cadastrarCliente = new CadastroCliente();
	
		
		JMenu menuCadastro = new JMenu("Cadastro");
//		menuCadastro.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				cadastroPainel = new CadastroCliente();
//				setContentPane(cadastroPainel);
//				revalidate();
//			}
//		});
		menuBar.add(menuCadastro);
		
		subMenuCliente = new JMenuItem("Cliente");
		subMenuCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroPainel = new CadastroCliente();
				setContentPane(cadastroPainel);
				revalidate();
			}
		});
		menuCadastro.add(subMenuCliente);
		
		subMenuPro = new JMenuItem("Profissionais");
		subMenuPro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroPro = new CadastroProfissionais();
				setContentPane(cadastroPro);
				revalidate();
			}
		});
		menuCadastro.add(subMenuPro);
		
		menuOrcamento = new JMenu("Orçamento");
		menuBar.add(menuOrcamento);
		
		menuRelatorios = new JMenu("Relatórios");
		menuBar.add(menuRelatorios);
		
		menuSobre = new JMenu("Sobre");
		menuBar.add(menuSobre);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}
}
