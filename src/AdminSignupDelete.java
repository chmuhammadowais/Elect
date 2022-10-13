import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminSignupDelete extends JFrame implements ActionListener {
    JPanel upper_line;
    JButton admin_signup_btn;
    ImageIcon admin_signup_icon;
    JButton admin_delete_btn;
    ImageIcon admin_delete_icon;
    JButton back_btn;
    ImageIcon icon;
    ImageIcon header_icon;
    ImageIcon back_icon;
    JLabel elect_heading;
    JLabel main_title;
    public AdminSignupDelete(){
        this.setSize(800,500);
        this.setTitle("Admin Signup / Deletion Panel");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.white);
        icon = new ImageIcon("logo.png");
        this.setIconImage(icon.getImage());


        header_icon = new ImageIcon("heading.png");
        elect_heading = new JLabel();
        elect_heading.setText("Elect");
        elect_heading.setFont(new Font("Calibri",Font.BOLD,32));
        elect_heading.setIcon(header_icon);
        elect_heading.setIconTextGap(4);
        elect_heading.setVerticalTextPosition(JLabel.BOTTOM);
        elect_heading.setHorizontalTextPosition(JLabel.CENTER);
        //elect_heading.setBorder(border);
        elect_heading.setBounds(365,0,70,100);


        main_title = new JLabel();
        main_title.setText("Administrator Signup / Delete Panel");
        main_title.setFont(new Font("Calibri",Font.BOLD,20));
       // main_title.setBorder(BorderFactory.createLineBorder(Color.red));
        main_title.setBounds(245,130,310,60);

        upper_line= new JPanel();
        upper_line.setBounds(100,210,600,3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

        admin_signup_icon = new ImageIcon("admin_add.png");
        admin_signup_btn = new JButton();
        admin_signup_btn.setIcon(admin_signup_icon);
        admin_signup_btn.setText("Signup Administrator");
        admin_signup_btn.setFocusable(false);
        admin_signup_btn.setContentAreaFilled(false);
        admin_signup_btn.setOpaque(false);
        admin_signup_btn.setFont(new Font("Calibri",Font.BOLD,17));
        admin_signup_btn.setBounds(180,230,200,200);
        admin_signup_btn.setBorder(null);
        admin_signup_btn.setVerticalTextPosition(JButton.TOP);
        admin_signup_btn.setHorizontalTextPosition(JButton.CENTER);
        admin_signup_btn.setIconTextGap(18);
        admin_signup_btn.addActionListener(this);

        admin_delete_icon = new ImageIcon("admin_delete.png");
        admin_delete_btn = new JButton();
        admin_delete_btn.setIcon(admin_delete_icon);
        admin_delete_btn.setText("Delete Administrator");
        admin_delete_btn.setFocusable(false);
        admin_delete_btn.setContentAreaFilled(false);
        admin_delete_btn.setOpaque(false);
        admin_delete_btn.setFont(new Font("Calibri",Font.BOLD,17));
        admin_delete_btn.setBounds(420,230,200,200);
        admin_delete_btn.setBorder(null);
        admin_delete_btn.setVerticalTextPosition(JButton.TOP);
        admin_delete_btn.setHorizontalTextPosition(JButton.CENTER);
        admin_delete_btn.setIconTextGap(20);
        admin_delete_btn.addActionListener(this);



        back_btn = new JButton();
        back_icon = new ImageIcon("back.png");
        back_btn.setIcon(back_icon);
        back_btn.setFocusable(false);
        back_btn.setContentAreaFilled(false);
        back_btn.setOpaque(false);
        back_btn.setFont(new Font("Calibri",Font.BOLD,17));
        back_btn.setBounds(30,410,30,30);
        back_btn.setBorder(null);
        back_btn.addActionListener(this);

        this.add(elect_heading);
        this.add(upper_line);
        this.add(main_title);
        this.add(admin_signup_btn);
        this.add(admin_delete_btn);
        this.add(back_btn);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == admin_signup_btn){
            new AdminSignup();
            this.dispose();
        }
        else if(e.getSource() == admin_delete_btn){
            new AdminDelete();
            this.dispose();
        }
        else if(e.getSource() == back_btn){
            new MainFrame();
            this.dispose();
        }
        else if(e.getSource() == back_btn){
            new AdminSignupDelete();
            this.dispose();
        }
    }
}
