package Interface;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class TelaCadastro extends JFrame {

    private JTextField txtNome;
    private JFormattedTextField txtCPF;
    private JTextField txtEmail;
    private JFormattedTextField txtCelular;
    private JFormattedTextField txtDataNascimento;
    private JPasswordField txtSenha;
    private JCheckBox chkTermos;

    public TelaCadastro() {
        initComponents();
    }

    // Aplica um estilo simples e moderno aos campos
    private void estilizarCampo(JComponent campo) {
        campo.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(210, 210, 210), 1, true),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        campo.setFont(new Font("Arial", Font.PLAIN, 14));
    }

    // Verifica se foi informado nome e sobrenome
    private boolean validarNome(String nome) {
        String[] partes = nome.trim().split("\\s+");
        return partes.length >= 2;
    }

  // Validação completa do CPF utilizando os dígitos verificadores
private boolean validarCPF(String cpf) {

    cpf = cpf.replaceAll("\\D", "");

    // CPF precisa ter exatamente 11 números
    if (cpf.length() != 11) {
        return false;
    }

    // Elimina CPFs com todos os números iguais
    if (cpf.matches("(\\d)\\1{10}")) {
        return false;
    }

    try {

        // Cálculo do primeiro dígito verificador
        int soma = 0;

        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }

        int resto = 11 - (soma % 11);

        int digito1;

        if (resto >= 10) {
            digito1 = 0;
        } else {
            digito1 = resto;
        }

        // Cálculo do segundo dígito verificador
        soma = 0;

        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }

        resto = 11 - (soma % 11);

        int digito2;

        if (resto >= 10) {
            digito2 = 0;
        } else {
            digito2 = resto;
        }

        // Compara os dígitos calculados com os informados
        return digito1 == Character.getNumericValue(cpf.charAt(9))
                && digito2 == Character.getNumericValue(cpf.charAt(10));

    } catch (Exception e) {

        return false;

    }
}

    // Verifica se o celular possui 11 números
    private boolean validarCelular(String celular) {
        celular = celular.replaceAll("\\D", "");
        return celular.length() == 11;
    }

    // Validação simples de e-mail
    private boolean validarEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    // Verifica se o usuário possui 18 anos ou mais
    private boolean validarMaiorIdade(String dataNascimento) {
        try {
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("dd/MM/yyyy");

            LocalDate nascimento =
                    LocalDate.parse(dataNascimento, formatter);

            int idade =
                    Period.between(nascimento, LocalDate.now()).getYears();

            return idade >= 18;

        } catch (Exception e) {
            return false;
        }
    }

    private void initComponents() {

        setTitle("Macaw Bank - Cadastro");
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel painel = new JPanel(null);
        painel.setBackground(new Color(235, 235, 235));

        // Logo do sistema
        ImageIcon iconeOriginal = new ImageIcon(
                getClass().getResource("/SistemaBancarioFrontEnd/Logo Macaw PNG 100px.png")
        );

        Image imagem = iconeOriginal.getImage()
                .getScaledInstance(90, 90, Image.SCALE_SMOOTH);

        JLabel lblLogo = new JLabel(new ImageIcon(imagem));
        lblLogo.setBounds(270, 35, 90, 90);
        painel.add(lblLogo);

        JLabel lblTitulo = new JLabel("Cadastro");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 40));
        lblTitulo.setBounds(390, 40, 300, 45);
        painel.add(lblTitulo);

        JLabel lblSubtitulo = new JLabel("Preencha os dados para criar o seu usuário.");
        lblSubtitulo.setFont(new Font("Arial", Font.PLAIN, 15));
        lblSubtitulo.setBounds(390, 90, 400, 25);
        painel.add(lblSubtitulo);

        // Card central do formulário
        JPanel card = new JPanel(null);
        card.setBackground(Color.WHITE);
        card.setBorder(new CompoundBorder(
                new LineBorder(new Color(220, 220, 220)),
                new EmptyBorder(15, 15, 15, 15)
        ));

        card.setBounds(340, 145, 600, 430);
        painel.add(card);

        int x = 35;
        int largura = 520;
        int alturaCampo = 32;

        Font fonteLabel = new Font("Arial", Font.PLAIN, 14);

        try {

            JLabel lblNome = new JLabel("Nome");
            lblNome.setFont(fonteLabel);
            lblNome.setBounds(x, 15, 150, 20);
            card.add(lblNome);

            txtNome = new JTextField();
            txtNome.setBounds(x, 38, largura, alturaCampo);
            estilizarCampo(txtNome);
            card.add(txtNome);

            JLabel lblCPF = new JLabel("CPF");
            lblCPF.setFont(fonteLabel);
            lblCPF.setBounds(x, 75, 150, 20);
            card.add(lblCPF);

            MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
            cpfMask.setPlaceholderCharacter('_');

            txtCPF = new JFormattedTextField(cpfMask);
            txtCPF.setBounds(x, 98, 220, alturaCampo);
            estilizarCampo(txtCPF);
            card.add(txtCPF);

            JLabel lblEmail = new JLabel("E-mail");
            lblEmail.setFont(fonteLabel);
            lblEmail.setBounds(x, 135, 150, 20);
            card.add(lblEmail);

            txtEmail = new JTextField();
            txtEmail.setBounds(x, 158, largura, alturaCampo);
            estilizarCampo(txtEmail);
            card.add(txtEmail);

            JLabel lblCelular = new JLabel("Celular");
            lblCelular.setFont(fonteLabel);
            lblCelular.setBounds(x, 195, 150, 20);
            card.add(lblCelular);

            MaskFormatter celularMask = new MaskFormatter("(##) #####-####");
            celularMask.setPlaceholderCharacter('_');

            txtCelular = new JFormattedTextField(celularMask);
            txtCelular.setBounds(x, 218, 220, alturaCampo);
            estilizarCampo(txtCelular);
            card.add(txtCelular);

            JLabel lblData = new JLabel("Data de Nascimento");
            lblData.setFont(fonteLabel);
            lblData.setBounds(x, 255, 180, 20);
            card.add(lblData);

            MaskFormatter dataMask = new MaskFormatter("##/##/####");
            dataMask.setPlaceholderCharacter('_');

            txtDataNascimento = new JFormattedTextField(dataMask);
            txtDataNascimento.setBounds(x, 278, 160, alturaCampo);
            estilizarCampo(txtDataNascimento);
            card.add(txtDataNascimento);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setFont(fonteLabel);
        lblSenha.setBounds(x, 315, 150, 20);
        card.add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(x, 338, largura, alturaCampo);
        estilizarCampo(txtSenha);
        card.add(txtSenha);

        chkTermos = new JCheckBox("Li e aceito os Termos de Uso");
        chkTermos.setBackground(Color.WHITE);
        chkTermos.setBounds(x, 380, 250, 20);
        card.add(chkTermos);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(470, 600, 130, 35);
        btnCadastrar.setBackground(new Color(255, 102, 0));
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.setFocusPainted(false);
        btnCadastrar.setFont(new Font("Arial", Font.BOLD, 13));

        btnCadastrar.addActionListener(e -> {

    String nome = txtNome.getText().trim();
    String cpf = txtCPF.getText();
    String email = txtEmail.getText().trim();
    String celular = txtCelular.getText();
    String dataNascimento = txtDataNascimento.getText();
    String senha = new String(txtSenha.getPassword());

    // Aqui serão armazenados todos os erros encontrados
    String erros = "";

    if (!validarNome(nome)) {
        erros += "- Digite nome e sobrenome.\n";
    }

    if (!validarCPF(cpf)) {
        erros += "- CPF inválido.\n";
    }

    if (!validarEmail(email)) {
        erros += "- Digite um e-mail válido.\n";
    }

    if (!validarCelular(celular)) {
        erros += "- Celular deve possuir 11 números.\n";
    }

    if (!validarMaiorIdade(dataNascimento)) {
        erros += "- É necessário ter 18 anos ou mais.\n";
    }

    if (senha.length() < 8) {
        erros += "- A senha deve possuir no mínimo 8 caracteres.\n";
    }

    if (!chkTermos.isSelected()) {
        erros += "- Você deve aceitar os Termos de Uso.\n";
    }

    // Se houver qualquer erro, mostra todos de uma vez
    if (!erros.isEmpty()) {

        JOptionPane.showMessageDialog(
                this,
                "Foram encontrados os seguintes problemas:\n\n" + erros,
                "Erro no cadastro",
                JOptionPane.ERROR_MESSAGE);

    } else {
JOptionPane.showMessageDialog(
        this,
        "Cadastro realizado com sucesso!\nFaça login para acessar sua conta.",
        "Sucesso",
        JOptionPane.INFORMATION_MESSAGE);

// Abre a tela de login
new TelLogin().setVisible(true);

// Fecha a tela de cadastro
dispose();

    }

});

        painel.add(btnCadastrar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(650, 600, 130, 35);
        btnCancelar.setFont(new Font("Arial", Font.BOLD, 13));
        

       btnCancelar.addActionListener(e -> {

    // Abre a tela de login
    new TelLogin().setVisible(true);

    // Fecha a tela de cadastro
    dispose();

});

        painel.add(btnCancelar);

        add(painel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaCadastro().setVisible(true);
        });
    }
}
