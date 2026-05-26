package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.Cursor;
import Backendverificacao.Verificacao;
public class TelaLogin extends JFrame {
    
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JButton btnEntrar;
    private JLabel lblCadastrar;
    private JLabel lblTitulo;
    
    public TelaLogin() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Macaw Bank - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 480); // Altura aumentada para 480
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        criarComponentes();
        posicionarComponentes();
        adicionarAcoes();
    }
    
    private void criarComponentes() {
        lblTitulo = new JLabel("Macaw Bank");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 32));
        lblTitulo.setForeground(new Color(255, 102, 0));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        
        txtUsuario = new JTextField();
        txtUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
        txtUsuario.setForeground(Color.BLACK);
        txtUsuario.setBackground(Color.WHITE);
        txtUsuario.setBorder(BorderFactory.createLineBorder(new Color(255, 102, 0)));
        
        txtSenha = new JPasswordField();
        txtSenha.setFont(new Font("Arial", Font.PLAIN, 14));
        txtSenha.setForeground(Color.BLACK);
        txtSenha.setBackground(Color.WHITE);
        txtSenha.setBorder(BorderFactory.createLineBorder(new Color(255, 102, 0)));
        
        btnEntrar = new JButton("Entrar");
        btnEntrar.setFont(new Font("Arial", Font.BOLD, 14));
        btnEntrar.setBackground(new Color(255, 102, 0));
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setBorder(BorderFactory.createLineBorder(new Color(200, 80, 0)));
        btnEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        lblCadastrar = new JLabel("Cadastre-se");
        lblCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
        lblCadastrar.setForeground(new Color(100, 100, 100));
        lblCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
        lblCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    private void posicionarComponentes() {
        lblTitulo.setBounds(50, 30, 350, 50);
        
        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setFont(new Font("Arial", Font.BOLD, 14));
        lblUsuario.setForeground(Color.BLACK);
        lblUsuario.setBounds(60, 120, 100, 25);
        add(lblUsuario);
        
        txtUsuario.setBounds(60, 150, 330, 35);
        
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("Arial", Font.BOLD, 14));
        lblSenha.setForeground(Color.BLACK);
        lblSenha.setBounds(60, 210, 100, 25);
        add(lblSenha);
        
        txtSenha.setBounds(60, 240, 330, 35);
        
        btnEntrar.setBounds(150, 320, 150, 40);
        
        // Cadastre-se com posição ajustada
        lblCadastrar.setBounds(150, 390, 150, 25);
        
        add(lblTitulo);
        add(txtUsuario);
        add(txtSenha);
        add(btnEntrar);
        add(lblCadastrar);
    }
    
    private void adicionarAcoes() {
        btnEntrar.addActionListener(e -> fazerLogin());
        
        lblCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                abrirCadastro();
            }
            
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                lblCadastrar.setForeground(new Color(255, 102, 0));
                lblCadastrar.setFont(new Font("Arial", Font.BOLD, 12));
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                lblCadastrar.setForeground(new Color(100, 100, 100));
                lblCadastrar.setFont(new Font("Arial", Font.PLAIN, 12));
            }
        });
    }
    
   private void fazerLogin() {

    String usuario = txtUsuario.getText();
    String senha = new String(txtSenha.getPassword());

    Verificacao verificacao = new Verificacao();
    String msg = verificacao.vitao(usuario, senha);

    System.out.println("MSG = " + msg);

    if (msg.equals("Login realizado com sucesso!")) {

    JOptionPane.showMessageDialog(null, msg);

    new TelaExtrato().setVisible(true);

    dispose();

} else {

    JOptionPane.showMessageDialog(
            null,
            msg,
            "Erro",
            JOptionPane.ERROR_MESSAGE
    );

    txtSenha.setText("");
    txtUsuario.setText("");
}
}
    
   private void abrirCadastro() {

    // Abre a tela de cadastro
    new TelaCadastro().setVisible(true);

    // Fecha a tela de login
    dispose();

}
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaLogin().setVisible(true);
        });
    }
}