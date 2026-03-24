import javax.swing.*;
import java.awt.*;

public class LibrasApp extends JFrame {

    private JLabel imagemLabel;

    public LibrasApp() {
        setTitle("Sinais de Libras");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel logo = new JLabel();
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        carregarImagemNoLabel(logo, "imagens/libras.png", 350, 350);

        JPanel botoes = new JPanel(new GridLayout(5, 1, 10, 10));

        JButton btnAprender = new JButton("1- Aprender");
        JButton btnEstudar = new JButton("2- Estudar");
        JButton btnExplicar = new JButton("3- Explicar");
        JButton btnEnsinar = new JButton("4- Ensinar");
        JButton btnRevisar = new JButton("5- Revisar");

        botoes.add(btnAprender);
        botoes.add(btnEstudar);
        botoes.add(btnExplicar);
        botoes.add(btnEnsinar);
        botoes.add(btnRevisar);

        imagemLabel = new JLabel(" <== ESCOLHA A OPÇÃO AO LADO", SwingConstants.CENTER);

        painel.add(logo, BorderLayout.NORTH);
        painel.add(botoes, BorderLayout.WEST);
        painel.add(imagemLabel, BorderLayout.CENTER);

        add(painel);

        btnAprender.addActionListener(e -> mostrarImagem("imagens/aprendendo.png"));
        btnEstudar.addActionListener(e -> mostrarImagem("imagens/estudar.png"));
        btnExplicar.addActionListener(e -> mostrarImagem("imagens/explicar.png"));
        btnEnsinar.addActionListener(e -> mostrarImagem("imagens/ensinar.png"));
        btnRevisar.addActionListener(e -> mostrarImagem("imagens/revisar.png"));
    }

    private void mostrarImagem(String caminho) {
        System.out.println("Carregando: " + caminho);

        java.net.URL imgURL = getClass().getResource("/" + caminho);

        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);

            Image img = icon.getImage().getScaledInstance(
                    imagemLabel.getWidth() > 0 ? imagemLabel.getWidth() : 500,
                    imagemLabel.getHeight() > 0 ? imagemLabel.getHeight() :500,
                    Image.SCALE_SMOOTH
            );

            imagemLabel.setIcon(new ImageIcon(img));
            imagemLabel.setText("");
        } else {
            imagemLabel.setText("Imagem não encontrada!");
            imagemLabel.setIcon(null);
            System.out.println("ERRO ao carregar: " + caminho);
        }
    }

    private void carregarImagemNoLabel(JLabel label, String caminho, int largura, int altura) {
        java.net.URL imgURL = getClass().getResource("/" + caminho);

        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            Image img = icon.getImage().getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(img));
        } else {
            label.setText("Logo não encontrada");
            System.out.println("ERRO logo: " + caminho);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibrasApp().setVisible(true));
    }
}
