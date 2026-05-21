package sistemabancariofrontend;

import javax.swing.*;
import java.awt.*;

public class SistemabancarioFrontEnd {
    public static void main(String[] args) {
        // Inicia a aplicação na thread de eventos do Swing
        SwingUtilities.invokeLater(() -> {
            new TelaLogin().setVisible(true);
        });
    }
}

// ========== TELA DE LOGIN ==========
class TelaLogin extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    
    public TelaLogin() {
        setTitle("Macaw Bank - Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Painel principal
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel.setBackground(new Color(240, 248, 255));
        
        // Título
        JLabel lblTitulo = new JLabel("Bem-vindo ao Macaw Bank");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setForeground(new Color(0, 102, 204));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0, 30, 0);
        panel.add(lblTitulo, gbc);
        
        // Usuário
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Usuário:"), gbc);
        
        txtUsuario = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(txtUsuario, gbc);
        
        // Senha
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Senha:"), gbc);
        
        txtSenha = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(txtSenha, gbc);
        
        // Botões
        JButton btnLogin = new JButton("Entrar");
        btnLogin.setBackground(new Color(0, 102, 204));
        btnLogin.setForeground(Color.WHITE);
        
        JButton btnSair = new JButton("Sair");
        
        JPanel panelBotoes = new JPanel(new FlowLayout());
        panelBotoes.add(btnLogin);
        panelBotoes.add(btnSair);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0, 10, 0);
        panel.add(panelBotoes, gbc);
        
        add(panel);
        
        // Ações dos botões
        btnLogin.addActionListener(e -> fazerLogin());
        btnSair.addActionListener(e -> System.exit(0));
    }
    
    private void fazerLogin() {
        String usuario = txtUsuario.getText();
        String senha = new String(txtSenha.getPassword());
        
        // Login simples (depois você conecta com banco de dados)
        if("admin".equals(usuario) && "123".equals(senha)) {
            new TelaMenuPrincipal().setVisible(true);
            dispose(); // Fecha a tela de login
        } else {
            JOptionPane.showMessageDialog(this, 
                "Usuário ou senha inválidos!", 
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}

// ========== MENU PRINCIPAL ==========
class TelaMenuPrincipal extends JFrame {
    
    public TelaMenuPrincipal() {
        setTitle("Macaw Bank - Menu Principal");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // MenuBar
        JMenuBar menuBar = new JMenuBar();
        
        JMenu mnContas = new JMenu("Contas");
        JMenuItem miAbrirConta = new JMenuItem("Abrir Conta");
        JMenuItem miListarContas = new JMenuItem("Listar Contas");
        mnContas.add(miAbrirConta);
        mnContas.add(miListarContas);
        
        JMenu mnTransacoes = new JMenu("Transações");
        JMenuItem miDepositar = new JMenuItem("Depositar");
        JMenuItem miSacar = new JMenuItem("Sacar");
        JMenuItem miTransferir = new JMenuItem("Transferir");
        mnTransacoes.add(miDepositar);
        mnTransacoes.add(miSacar);
        mnTransacoes.add(miTransferir);
        
        JMenu mnSair = new JMenu("Sistema");
        JMenuItem miLogout = new JMenuItem("Logout");
        mnSair.add(miLogout);
        
        menuBar.add(mnContas);
        menuBar.add(mnTransacoes);
        menuBar.add(mnSair);
        setJMenuBar(menuBar);
        
        // Painel central
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(240, 248, 255));
        
        JLabel lblWelcome = new JLabel("Bem-vindo ao Macaw Bank", JLabel.CENTER);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 24));
        lblWelcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel lblInfo = new JLabel("Selecione uma opção no menu acima", JLabel.CENTER);
        lblInfo.setFont(new Font("Arial", Font.PLAIN, 14));
        lblInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panel.add(Box.createVerticalStrut(80));
        panel.add(lblWelcome);
        panel.add(Box.createVerticalStrut(20));
        panel.add(lblInfo);
        
        add(panel);
        
        // Eventos
        miAbrirConta.addActionListener(e -> new TelaAbrirConta().setVisible(true));
        miLogout.addActionListener(e -> logout());
        
        // Placeholder para outras opções
        miDepositar.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidade em desenvolvimento"));
        miSacar.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidade em desenvolvimento"));
        miTransferir.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidade em desenvolvimento"));
        miListarContas.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidade em desenvolvimento"));
    }
    
    private void logout() {
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Deseja realmente sair?", "Logout", 
            JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION) {
            new TelaLogin().setVisible(true);
            dispose();
        }
    }
}

// ========== TELA ABRIR CONTA ==========
class TelaAbrirConta extends JDialog {
    private JTextField txtTitular, txtCpf;
    private JComboBox<String> cbTipoConta;
    
    public TelaAbrirConta() {
        setTitle("Abrir Nova Conta");
        setModal(true);
        setSize(400, 300);
        setLocationRelativeTo(null);
        initComponents();
    }
    
    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Título
        JLabel lblTitulo = new JLabel("Nova Conta Bancária");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(lblTitulo, gbc);
        
        // Campos
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        add(new JLabel("Titular:"), gbc);
        
        txtTitular = new JTextField(20);
        gbc.gridx = 1;
        add(txtTitular, gbc);
        
        gbc.gridy = 2;
        gbc.gridx = 0;
        add(new JLabel("CPF:"), gbc);
        
        txtCpf = new JTextField(20);
        gbc.gridx = 1;
        add(txtCpf, gbc);
        
        gbc.gridy = 3;
        gbc.gridx = 0;
        add(new JLabel("Tipo de Conta:"), gbc);
        
        cbTipoConta = new JComboBox<>(new String[]{"Corrente", "Poupança"});
        gbc.gridx = 1;
        add(cbTipoConta, gbc);
        
        // Botões
        JButton btnSalvar = new JButton("Salvar");
        JButton btnCancelar = new JButton("Cancelar");
        JPanel panelBotoes = new JPanel(new FlowLayout());
        panelBotoes.add(btnSalvar);
        panelBotoes.add(btnCancelar);
        
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(panelBotoes, gbc);
        
        btnSalvar.addActionListener(e -> salvarConta());
        btnCancelar.addActionListener(e -> dispose());
    }
    
    private void salvarConta() {
        JOptionPane.showMessageDialog(this, 
            "Conta criada com sucesso!\nTitular: " + txtTitular.getText() + 
            "\nTipo: " + cbTipoConta.getSelectedItem(),
            "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}