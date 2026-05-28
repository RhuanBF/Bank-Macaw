package Interface;
import BancoDados.ClienteBD;
import BancoDados.ModeloCliente;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author gusta
 */
public class TelaCadastro extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaCadastro.class.getName());

    /**
     * Creates new form TelaCadastro
     */
    public TelaCadastro() {
        initComponents();
    }

   private boolean validarMaiorIdade(String dataNascimento) {

    try {

        DateTimeFormatter formato =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate nascimento =
                LocalDate.parse(dataNascimento, formato);

        int idade =
                Period.between(nascimento, LocalDate.now()).getYears();

        return idade >= 18;

    } catch (Exception e) {

        return false;

    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        logoMCB = new javax.swing.JLabel();
        label2 = new java.awt.Label();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        email = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        nome = new javax.swing.JTextPane();
        buttoncadastrar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        senha = new javax.swing.JPasswordField();
        confirmsenha = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        label3 = new java.awt.Label();
        celular = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        nascimento = new javax.swing.JFormattedTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        nome1 = new javax.swing.JTextPane();

        jLabel5.setText("Celular:");

        jLabel3.setText("Nome:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 0));

        label1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        label1.setText("Cadastro");

        logoMCB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SistemaBancarioFrontEnd/Logo Macaw PNG 100px.png"))); // NOI18N
        logoMCB.setText("jLabel2");

        label2.setFont(new java.awt.Font("Perpetua", 0, 8)); // NOI18N
        label2.setText("Macaw Bank - Liberdade para voar mais alto com o seu futuro financeiro.");

        jLabel1.setText("Nome:");

        jLabel2.setText("E-mail:");

        jLabel4.setText("Celular:");

        jLabel7.setText("Data de Nascimento:");

        email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailFocusGained(evt);
            }
        });
        jScrollPane5.setViewportView(email);

        nome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nomeFocusGained(evt);
            }
        });
        jScrollPane6.setViewportView(nome);

        buttoncadastrar.setBackground(new java.awt.Color(255, 102, 0));
        buttoncadastrar.setText("Cadastrar");
        buttoncadastrar.addActionListener(this::buttoncadastrarActionPerformed);

        jButton4.setText("Cancelar");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        senha.setText("jPasswordField1");
        senha.addActionListener(this::senhaActionPerformed);

        confirmsenha.setText("jPasswordField1");
        confirmsenha.addActionListener(this::confirmsenhaActionPerformed);

        jLabel6.setText("Senha:");

        jLabel8.setText("Confirmar senha:");

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\gusta\\Downloads\\ave.png")); // NOI18N
        jLabel9.setText("jLabel9");

        label3.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        label3.setText("Preencha os dados para criar o seu usuário.");

        try {
            celular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        celular.addActionListener(this::celularActionPerformed);

        jLabel10.setText("CPF:");

        try {
            nascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        nascimento.addActionListener(this::nascimentoActionPerformed);

        nome1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nome1FocusGained(evt);
            }
        });
        jScrollPane7.setViewportView(nome1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(logoMCB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(buttoncadastrar)
                                .addGap(62, 62, 62)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(senha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(celular, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(confirmsenha, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel10)
                            .addComponent(nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(logoMCB))
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel7)
                .addGap(12, 12, 12)
                .addComponent(nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttoncadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttoncadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttoncadastrarActionPerformed
       StringBuilder erros = new StringBuilder();


// EMAIL
//Valida se o email digitado tem "@" e ".com"
String textoemail = email.getText();

if (!textoemail.contains("@") || !textoemail.contains(".com")) {
    erros.append("- Email inválido\n");
}


// CELULAR
//Valida se tem 11 numeros
String textocelular = celular.getText().replaceAll("\\D", "");

if (textocelular.length() < 10 || textocelular.length() > 11) {
    erros.append("- Celular inválido\n");
}


// NOME
//Valida se tem nome e sobrenome
String textoNome = nome.getText();

if (textoNome.trim().isEmpty()) {
    erros.append("- Digite seu nome\n");
} else if (!textoNome.contains(" ")) {
    erros.append("- Digite nome e sobrenome\n");
}


// DATA DE NASCIMENTO
//Valida se o campo esta vazio
String textoData = nascimento.getText();

if (textoData.contains(" ") || textoData.trim().isEmpty()) {
    erros.append("- Data de nascimento incompleta\n");
}
else if (!validarMaiorIdade(textoData)) {
    erros.append("- É necessário ser maior de 18 anos\n");
}


// SENHA
//Valida se a senha bate com o "confirmar senha" e se tem 1 letra maiuscula e 1 numero 
String senhaValor = senha.getText();
String confirmSenhaValor = confirmsenha.getText();

// senhas iguais
if (!senhaValor.equals(confirmSenhaValor)) {
    erros.append("- As senhas não estão compatíveis\n");
}

//Senha forte
String senhaRegex = "^(?=.*[A-Z])(?=.*\\d).+$";

if (!senhaValor.matches(senhaRegex)) {
    erros.append("- A senha deve ter pelo menos 1 letra maiúscula e 1 número\n");
}

// Exibe caixa mostrando os erros
if (erros.length() > 0) {

    JOptionPane.showMessageDialog(null, erros.toString());

} else {ModeloCliente.Cliente novo = new ModeloCliente().new Cliente();

    novo.setNome(nome.getText());
    novo.setCpf(nome1.getText());
    novo.setEmail(email.getText());
    novo.setCelular(celular.getText());
    novo.setSenha(new String(senha.getPassword()));
    novo.setDtnascimento(nascimento.getText());

    ClienteBD registro = new ClienteBD();
    registro.addCliente(novo);

    JOptionPane.showMessageDialog(
            null,
            "Cadastro realizado com sucesso!"
    );

    new TelaLogin().setVisible(true);
    dispose();
}
    }//GEN-LAST:event_buttoncadastrarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaActionPerformed


    }//GEN-LAST:event_senhaActionPerformed

    private void nomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomeFocusGained
      // TODO add your handling code here:
    }//GEN-LAST:event_nomeFocusGained

    private void emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusGained
          // TODO add your handling code here:
    }//GEN-LAST:event_emailFocusGained

    private void celularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_celularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_celularActionPerformed

    private void confirmsenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmsenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmsenhaActionPerformed

    private void nascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nascimentoActionPerformed

    private void nome1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nome1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_nome1FocusGained

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new TelaCadastro().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttoncadastrar;
    private javax.swing.JFormattedTextField celular;
    private javax.swing.JPasswordField confirmsenha;
    private javax.swing.JTextPane email;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private javax.swing.JLabel logoMCB;
    private javax.swing.JFormattedTextField nascimento;
    private javax.swing.JTextPane nome;
    private javax.swing.JTextPane nome1;
    private javax.swing.JPasswordField senha;
    // End of variables declaration//GEN-END:variables
}
