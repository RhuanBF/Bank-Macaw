import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TelaExtrato extends JFrame {

    // Definição da paleta de cores baseada na imagem
    //Teste
    private static final Color COLOR_ORANGE = new Color(255, 106, 0);
    private static final Color COLOR_BACKGROUND = new Color(247, 249, 250);
    private static final Color COLOR_CARD_BG = Color.WHITE;
    private static final Color COLOR_TEXT_DARK = new Color(17, 17, 17);
    private static final Color COLOR_TEXT_MUTED = new Color(136, 136, 136);
    private static final Color COLOR_GREEN = new Color(46, 184, 114);

    public TelaExtrato() {
        setTitle("Macaw Bank - Desktop");
        setSize(1200, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(COLOR_BACKGROUND);
        setLayout(new BorderLayout());

        // 1. BARRA LATERAL (SIDEBAR)
        add(createSidebar(), BorderLayout.WEST);

        // 2. PAINEL PRINCIPAL DE CONTEÚDO
        JPanel mainContent = new JPanel(new GridLayout(1, 2, 30, 0));
        mainContent.setBackground(COLOR_BACKGROUND);
        mainContent.setBorder(new EmptyBorder(30, 30, 30, 30));

        // Coluna Esquerda: Saldo e Ações
        mainContent.add(createLeftColumn());

        // Coluna Direita: Banner e Extrato
        mainContent.add(createRightColumn());

        add(mainContent, BorderLayout.CENTER);
    }

    // Método para criar a barra lateral laranja
    private JPanel createSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setBackground(COLOR_ORANGE);
        sidebar.setPreferredSize(new Dimension(240, 750));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBorder(new EmptyBorder(30, 20, 30, 20));

        // Logo / Header da Sidebar
        JLabel lblLogo = new JLabel("🦅 Macaw Bank");
        lblLogo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblLogo.setForeground(Color.WHITE);
        lblLogo.setAlignmentX(Component.LEFT_ALIGNMENT);
        sidebar.add(lblLogo);
        
        sidebar.add(Box.createRigidArea(new Dimension(0, 40)));

        // Menu de Navegação
        String[] menuItems = {"🏠  Início", "💳  Conta", "🎁  Benefícios", "💬  Mais"};
        for (int i = 0; i < menuItems.length; i++) {
            JButton btnMenu = new JButton(menuItems[i]);
            btnMenu.setFont(new Font("Segoe UI", i == 0 ? Font.BOLD : Font.PLAIN, 16));
            btnMenu.setForeground(Color.WHITE);
            btnMenu.setBackground(COLOR_ORANGE);
            btnMenu.setFocusPainted(false);
            btnMenu.setBorderPainted(false);
            btnMenu.setHorizontalAlignment(SwingConstants.LEFT);
            btnMenu.setAlignmentX(Component.LEFT_ALIGNMENT);
            btnMenu.setMaximumSize(new Dimension(200, 40));
            
            // Destaque para o item ativo ("Início")
            if (i == 0) {
                btnMenu.setBackground(new Color(255, 255, 255, 40));
                btnMenu.setOpaque(true);
            }
            
            sidebar.add(btnMenu);
            sidebar.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        // Rodapé do usuário na sidebar
        sidebar.add(Box.createVerticalGlue());
        JLabel lblUser = new JLabel("Olá, Carlos! 🔔");
        lblUser.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblUser.setForeground(Color.WHITE);
        lblUser.setAlignmentX(Component.LEFT_ALIGNMENT);
        sidebar.add(lblUser);

        return sidebar;
    }

    // Método para criar a coluna da esquerda
    private JPanel createLeftColumn() {
        JPanel leftCol = new JPanel();
        leftCol.setBackground(COLOR_BACKGROUND);
        leftCol.setLayout(new BoxLayout(leftCol, BoxLayout.Y_AXIS));

        // --- Card de Saldo ---
        JPanel cardBalance = new JPanel();
        cardBalance.setBackground(COLOR_CARD_BG);
        cardBalance.setLayout(new BoxLayout(cardBalance, BoxLayout.Y_AXIS));
        cardBalance.setBorder(new EmptyBorder(25, 25, 25, 25));
        cardBalance.setMaximumSize(new Dimension(600, 160));

        JLabel lblSaldoTitle = new JLabel("Saldo em conta  👁️");
        lblSaldoTitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSaldoTitle.setForeground(COLOR_TEXT_MUTED);
        
        JLabel lblSaldoValue = new JLabel("R$ 4.250,00");
        lblSaldoValue.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lblSaldoValue.setForeground(COLOR_TEXT_DARK);
        
        JLabel lblAccountInfo = new JLabel("Agência 0001  •  Conta 12345-6");
        lblAccountInfo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblAccountInfo.setForeground(COLOR_TEXT_MUTED);

        cardBalance.add(lblSaldoTitle);
        cardBalance.add(Box.createRigidArea(new Dimension(0, 10)));
        cardBalance.add(lblSaldoValue);
        cardBalance.add(Box.createRigidArea(new Dimension(0, 10)));
        cardBalance.add(lblAccountInfo);
        
        leftCol.add(cardBalance);
        leftCol.add(Box.createRigidArea(new Dimension(0, 25)));

        // --- Grid de Quatro Botões Principais ---
        JPanel gridActions = new JPanel(new GridLayout(1, 4, 15, 0));
        gridActions.setBackground(COLOR_BACKGROUND);
        gridActions.setMaximumSize(new Dimension(600, 90));

        gridActions.add(createActionButton("❖ Pix"));
        gridActions.add(createActionButton("║▌ Pagar"));
        gridActions.add(createActionButton("⇄ Transf."));
        gridActions.add(createActionButton("💳 Cartões"));

        leftCol.add(gridActions);
        leftCol.add(Box.createRigidArea(new Dimension(0, 25)));

        // --- Seção de Acesso Rápido ---
        JPanel accessHeader = new JPanel(new BorderLayout());
        accessHeader.setBackground(COLOR_BACKGROUND);
        accessHeader.setMaximumSize(new Dimension(600, 25));
        JLabel lblAccess = new JLabel("Acesso rápido");
        lblAccess.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblAccess.setForeground(COLOR_TEXT_DARK);
        JLabel lblVerTodos1 = new JLabel("Ver todos");
        lblVerTodos1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblVerTodos1.setForeground(COLOR_ORANGE);
        accessHeader.add(lblAccess, BorderLayout.WEST);
        accessHeader.add(lblVerTodos1, BorderLayout.EAST);
        
        leftCol.add(accessHeader);
        leftCol.add(Box.createRigidArea(new Dimension(0, 15)));

        JPanel gridQuick = new JPanel(new GridLayout(1, 4, 15, 0));
        gridQuick.setBackground(COLOR_BACKGROUND);
        gridQuick.setMaximumSize(new Dimension(600, 90));
        
        gridQuick.add(createQuickItem("📄 Extrato"));
        gridQuick.add(createQuickItem("📱 Recarga"));
        gridQuick.add(createQuickItem("🧾 Boletos"));
        gridQuick.add(createQuickItem("⚙️ Config."));

        leftCol.add(gridQuick);
        
        return leftCol;
    }

    // Método para criar a coluna da direita
    private JPanel createRightColumn() {
        JPanel rightCol = new JPanel();
        rightCol.setBackground(COLOR_BACKGROUND);
        rightCol.setLayout(new BoxLayout(rightCol, BoxLayout.Y_AXIS));

        // --- Banner de Crédito Laranja ---
        JPanel banner = new JPanel(new BorderLayout());
        banner.setBackground(COLOR_ORANGE);
        banner.setBorder(new EmptyBorder(20, 25, 20, 25));
        banner.setMaximumSize(new Dimension(600, 140));

        JPanel bannerTextPanel = new JPanel();
        bannerTextPanel.setOpaque(false);
        bannerTextPanel.setLayout(new BoxLayout(bannerTextPanel, BoxLayout.Y_AXIS));

        JLabel lblBannerTitle = new JLabel("<html><b>Crédito sob medida</b><br>para seus planos.</html>");
        lblBannerTitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblBannerTitle.setForeground(Color.WHITE);
        
        JButton btnSimular = new JButton("Simular crédito");
        btnSimular.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnSimular.setForeground(COLOR_ORANGE);
        btnSimular.setBackground(Color.WHITE);
        btnSimular.setFocusPainted(false);
        btnSimular.setBorder(new EmptyBorder(8, 15, 8, 15));

        bannerTextPanel.add(lblBannerTitle);
        bannerTextPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        bannerTextPanel.add(btnSimular);

        JLabel lblBannerIcon = new JLabel("💰");
        lblBannerIcon.setFont(new Font("Segoe UI", Font.PLAIN, 48));

        banner.add(bannerTextPanel, BorderLayout.CENTER);
        banner.add(lblBannerIcon, BorderLayout.EAST);

        rightCol.add(banner);
        rightCol.add(Box.createRigidArea(new Dimension(0, 25)));

        // --- Seção de Últimas Movimentações ---
        JPanel transHeader = new JPanel(new BorderLayout());
        transHeader.setBackground(COLOR_BACKGROUND);
        transHeader.setMaximumSize(new Dimension(600, 25));
        JLabel lblTrans = new JLabel("Últimas movimentações");
        lblTrans.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTrans.setForeground(COLOR_TEXT_DARK);
        JLabel lblVerTodos2 = new JLabel("Ver todas");
        lblVerTodos2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblVerTodos2.setForeground(COLOR_ORANGE);
        transHeader.add(lblTrans, BorderLayout.WEST);
        transHeader.add(lblVerTodos2, BorderLayout.EAST);

        rightCol.add(transHeader);
        rightCol.add(Box.createRigidArea(new Dimension(0, 15)));

        // Painel Lista de Transações
        JPanel transList = new JPanel();
        transList.setBackground(COLOR_CARD_BG);
        transList.setLayout(new BoxLayout(transList, BoxLayout.Y_AXIS));
        transList.setBorder(new EmptyBorder(10, 10, 10, 10));

        transList.add(createTransactionItem("⬇️ Transferência recebida", "Maria Silva", "R$ 850,00", "Hoje, 08:30", COLOR_GREEN));
        transList.add(createTransactionItem("⬆️ Pagamento - Mercado", "Débito", "- R$ 120,00", "Hoje, 07:45", COLOR_TEXT_DARK));
        transList.add(createTransactionItem("⬆️ Pix enviado", "João Santos", "- R$ 200,00", "Ontem, 18:20", COLOR_TEXT_DARK));

        rightCol.add(transList);

        return rightCol;
    }

    // Auxiliar: Botões brancos de ação superior
    private JButton createActionButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setForeground(COLOR_TEXT_DARK);
        btn.setBackground(COLOR_CARD_BG);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230), 1));
        return btn;
    }

    // Auxiliar: Itens quadrados de acesso rápido
    private JPanel createQuickItem(String text) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(COLOR_CARD_BG);
        panel.setBorder(BorderFactory.createLineBorder(new Color(235, 235, 235), 1));
        
        JLabel lbl = new JLabel(text);
        lbl.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lbl.setForeground(COLOR_TEXT_DARK);
        panel.add(lbl);
        return panel;
    }

    // Auxiliar: Linha de Extrato / Transação
    private JPanel createTransactionItem(String title, String subtitle, String value, String time, Color valueColor) {
        JPanel row = new JPanel(new BorderLayout());
        row.setBackground(COLOR_CARD_BG);
        row.setBorder(new EmptyBorder(12, 10, 12, 10));
        row.setMaximumSize(new Dimension(600, 65));

        // Esquerda (Ícone, Título e Subtítulo)
        JPanel leftText = new JPanel(new GridLayout(2, 1));
        leftText.setOpaque(false);
        JLabel lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblTitle.setForeground(COLOR_TEXT_DARK);
        JLabel lblSub = new JLabel(subtitle);
        lblSub.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblSub.setForeground(COLOR_TEXT_MUTED);
        leftText.add(lblTitle);
        leftText.add(lblSub);

        // Direita (Valor e Horário)
        JPanel rightText = new JPanel(new GridLayout(2, 1));
        rightText.setOpaque(false);
        JLabel lblValue = new JLabel(value, SwingConstants.RIGHT);
        lblValue.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblValue.setForeground(valueColor);
        JLabel lblTime = new JLabel(time, SwingConstants.RIGHT);
        lblTime.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lblTime.setForeground(COLOR_TEXT_MUTED);
        rightText.add(lblValue);
        rightText.add(lblTime);

        row.add(leftText, BorderLayout.WEST);
        row.add(rightText, BorderLayout.EAST);

        // Linha divisória fina embaixo do item
        row.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(240, 240, 240)));

        return row;
    }

    public static void main(String[] args) {
        // Inicializa a aplicação garantindo a thread do Swing
        SwingUtilities.invokeLater(() -> {
            new TelaExtrato().setVisible(true);
        });
    }
}
