import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegUnregFrame extends JFrame implements ActionListener {
    JButton reg_btn;
    JButton unreg_btn;
    JButton back_btn;
    public RegUnregFrame(){
        this.setSize(800,500);
        this.setTitle("Admin Panel");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.white);
        // Border border = BorderFactory.createLineBorder(Color.red);
        ImageIcon icon = new ImageIcon("logo.png");
        this.setIconImage(icon.getImage());


        ImageIcon header_icon = new ImageIcon("heading.png");
        JLabel elect_heading = new JLabel();
        elect_heading.setText("Elect");
        elect_heading.setFont(new Font("Calibri",Font.BOLD,32));
        elect_heading.setIcon(header_icon);
        elect_heading.setIconTextGap(4);
        elect_heading.setVerticalTextPosition(JLabel.BOTTOM);
        elect_heading.setHorizontalTextPosition(JLabel.CENTER);
        //elect_heading.setBorder(border);
        elect_heading.setBounds(365,0,70,100);


        JLabel main_title = new JLabel();
        main_title.setText("Candidate Register / Unregister Panel");
        main_title.setFont(new Font("Calibri",Font.BOLD,20));
        //main_title.setBorder(BorderFactory.createLineBorder(Color.red));
        main_title.setBounds(240,130,320,60);

        ImageIcon reg_icon = new ImageIcon("register.png");
        reg_btn = new JButton();
        reg_btn.setIcon(reg_icon);
        reg_btn.setText("Register Candidate");
        reg_btn.setFocusable(false);
        reg_btn.setContentAreaFilled(false);
        reg_btn.setOpaque(false);
        reg_btn.setFont(new Font("Calibri",Font.BOLD,17));
        reg_btn.setBounds(150,230,200,200);
        reg_btn.setBorder(null);
        reg_btn.setVerticalTextPosition(JButton.BOTTOM);
        reg_btn.setHorizontalTextPosition(JButton.CENTER);
        reg_btn.setIconTextGap(16);
        reg_btn.addActionListener(this);

        ImageIcon unreg_icon = new ImageIcon("unregister.png");
        unreg_btn = new JButton();
        unreg_btn.setIcon(unreg_icon);
        unreg_btn.setText("Unregister Candidate");
        unreg_btn.setFocusable(false);
        unreg_btn.setContentAreaFilled(false);
        unreg_btn.setOpaque(false);
        unreg_btn.setFont(new Font("Calibri",Font.BOLD,17));
        unreg_btn.setBounds(450,230,200,200);
        unreg_btn.setBorder(null);
        unreg_btn.setVerticalTextPosition(JButton.BOTTOM);
        unreg_btn.setHorizontalTextPosition(JButton.CENTER);
        unreg_btn.addActionListener(this);

        back_btn = new JButton();
        ImageIcon back_icon = new ImageIcon("back.png");
        back_btn.setIcon(back_icon);
        back_btn.setFocusable(false);
        back_btn.setContentAreaFilled(false);
        back_btn.setOpaque(false);
        back_btn.setFont(new Font("Calibri",Font.BOLD,17));
        back_btn.setBounds(30,410,30,30);
        back_btn.setBorder(null);
        back_btn.addActionListener(this);

        this.add(elect_heading);
        this.add(main_title);
        this.add(reg_btn);
        this.add(unreg_btn);
        this.add(back_btn);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == reg_btn){
            this.dispose();
            new RegistrationFrame();
        }
        else if(e.getSource() == unreg_btn){
            this.dispose();
        }
        else if(e.getSource() == back_btn){
            this.dispose();
            new MainFrame();
        }
    }
}
