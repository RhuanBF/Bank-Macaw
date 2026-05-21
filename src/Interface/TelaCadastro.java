package Interface;

import javax.swing.*;
import java.awt.*;

public class TelaCadastro extends JFrame {

    private JTextField txtNome;
    private JTextField txtCpf;
    private JTextField txtNumero;
    private JTextField txtData;
    private JPasswordField txtSenha;
    private JPasswordField txtConfirmarSenha;

    private JButton btnCadastrar;
    private JLabel lblVoltar;

    public TelaCadastro() {
        initComponents();
    }

    private void initComponents() {

        // CONFIGURAÇÕES DA JANELA
        setTitle("Macaw Bank - Cadastro");
        setSize(550, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // PAINEL PRINCIPAL
        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBackground(new Color(240, 240, 240));

        // TÍTULO
        JLabel lblTitulo = new JLabel("Cadastro");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 40));
        lblTitulo.setForeground(new Color(255, 102, 0));
        lblTitulo.setBounds(160, 40, 250, 50);

        // NOME
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Arial", Font.BOLD, 24));
        lblNome.setBounds(60, 130, 200, 30);

        txtNome = new JTextField();
        txtNome.setFont(new Font("Arial", Font.PLAIN, 18));
        txtNome.setBounds(60, 170, 420, 45);
        txtNome.setBorder(BorderFactory.createLineBorder(new Color(255, 102, 0)));

        // CPF
        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setFont(new Font("Arial", Font.BOLD, 24));
        lblCpf.setBounds(60, 230, 200, 30);

        txtCpf = new JTextField();
        txtCpf.setFont(new Font("Arial", Font.PLAIN, 18));
        txtCpf.setBounds(60, 270, 420, 45);
        txtCpf.setBorder(BorderFactory.createLineBorder(new Color(255, 102, 0)));

        // NÚMERO
        JLabel lblNumero = new JLabel("Número:");
        lblNumero.setFont(new Font("Arial", Font.BOLD, 24));
        lblNumero.setBounds(60, 330, 200, 30);

        txtNumero = new JTextField();
        txtNumero.setFont(new Font("Arial", Font.PLAIN, 18));
        txtNumero.setBounds(60, 370, 420, 45);
        txtNumero.setBorder(BorderFactory.createLineBorder(new Color(255, 102, 0)));

        // DATA
        JLabel lblData = new JLabel("Data de Nascimento:");
        lblData.setFont(new Font("Arial", Font.BOLD, 24));
        lblData.setBounds(60, 430, 300, 30);

        txtData = new JTextField();
        txtData.setFont(new Font("Arial", Font.PLAIN, 18));
        txtData.setBounds(60, 470, 420, 45);
        txtData.setBorder(BorderFactory.createLineBorder(new Color(255, 102, 0)));

        // SENHA
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("Arial", Font.BOLD, 24));
        lblSenha.setBounds(60, 530, 200, 30);

        txtSenha = new JPasswordField();
        txtSenha.setFont(new Font("Arial", Font.PLAIN, 18));
        txtSenha.setBounds(60, 570, 420, 45);
        txtSenha.setBorder(BorderFactory.createLineBorder(new Color(255, 102, 0)));

        // CONFIRMAR SENHA
        JLabel lblConfirmarSenha = new JLabel("Confirmar Senha:");
        lblConfirmarSenha.setFont(new Font("Arial", Font.BOLD, 24));
        lblConfirmarSenha.setBounds(60, 630, 250, 30);

        txtConfirmarSenha = new JPasswordField();
        txtConfirmarSenha.setFont(new Font("Arial", Font.PLAIN, 18));
        txtConfirmarSenha.setBounds(60, 670, 420, 45);
        txtConfirmarSenha.setBorder(BorderFactory.createLineBorder(new Color(255, 102, 0)));

        // BOTÃO CADASTRAR
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(165, 740, 200, 50);
        btnCadastrar.setBackground(new Color(255, 102, 0));
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.setFont(new Font("Arial", Font.BOLD, 22));
        btnCadastrar.setFocusPainted(false);
        btnCadastrar.setBorderPainted(false);
        btnCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // VOLTAR
        lblVoltar = new JLabel("Voltar para login");
        lblVoltar.setFont(new Font("Arial", Font.PLAIN, 18));
        lblVoltar.setForeground(Color.DARK_GRAY);
        lblVoltar.setBounds(185, 810, 200, 30);
        lblVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // ADICIONAR COMPONENTES
        painel.add(lblTitulo);

        painel.add(lblNome);
        painel.add(txtNome);

        painel.add(lblCpf);
        painel.add(txtCpf);

        painel.add(lblNumero);
        painel.add(txtNumero);

        painel.add(lblData);
        painel.add(txtData);

        painel.add(lblSenha);
        painel.add(txtSenha);

        painel.add(lblConfirmarSenha);
        painel.add(txtConfirmarSenha);

        painel.add(btnCadastrar);
        painel.add(lblVoltar);

        add(painel);

        setSize(550, 900);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaCadastro().setVisible(true);
        });
    }
}