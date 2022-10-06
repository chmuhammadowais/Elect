import javax.swing.*;

public class Frame0 extends JFrame {
    public Frame0(){
        this.setSize(800,500);
        this.setTitle("Elect");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon("logo.png");
        this.setIconImage(icon.getImage());
        this.setVisible(true);
    }
}
