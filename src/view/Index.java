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
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Index extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu menuOrcamento;
	private JMenu menuRelatorios;
	private JMenu menuSobre;
	
	private CadastroCliente cadastroPainel;
	private CadastroProfissionais cadastroPro;
	private TelaOrcamento telaOrcamento;
	private JMenuItem subMenuCliente;
	private JMenuItem subMenuPro;
	private JMenu menuCadastro;
	private JLabel lblTitulo;
	private JMenuItem mntmNewMenuItem;
	private JLabel imageBackground;

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
		setBounds(100, 100, 746, 480);
		setLocationRelativeTo(null);
		setTitle("Oficina Mecânica");
		setResizable(false);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		menuCadastro = new JMenu("Cadastro");

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
		
		mntmNewMenuItem = new JMenuItem("Novo orçamento");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaOrcamento = new TelaOrcamento();
				setContentPane(telaOrcamento);
				revalidate();
			}
		});
		menuOrcamento.add(mntmNewMenuItem);
		
		menuRelatorios = new JMenu("Relatórios");
		menuBar.add(menuRelatorios);
		
		menuSobre = new JMenu("Sobre");
		menuBar.add(menuSobre);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitulo = new JLabel("Oficina Mecânica");
		lblTitulo.setBounds(182, 10, 365, 60);
		lblTitulo.setFont(new Font("Poppins Black", Font.PLAIN, 40));
		contentPane.add(lblTitulo);
		
		imageBackground = new JLabel("Golf");
		imageBackground.setIcon(new ImageIcon(Index.class.getResource("/icons/golf.jpg")));
		imageBackground.setBounds(-158, -89, 890, 512);
		contentPane.add(imageBackground);
	}
}
