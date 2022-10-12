import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AdminLogin extends JFrame implements ActionListener {
    JLabel elect_heading;
    ImageIcon icon;
    ImageIcon header_icon;
    JLabel admin_login_title;
    JButton login_btn;
    JPanel upper_line;
    JPanel pic_panel;
    JLabel pic_panel_def_pic;
    ImageIcon avatar;
    JLabel admin_username;
    JTextField admin_username_textfield;
    JLabel admin_password;
    JTextField admin_password_textfield;

    public AdminLogin() {
        this.setSize(800, 500);
        this.setTitle("Admin Login");
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
        elect_heading.setFont(new Font("Calibri", Font.BOLD, 32));
        elect_heading.setIcon(header_icon);
        elect_heading.setIconTextGap(4);
        elect_heading.setVerticalTextPosition(JLabel.BOTTOM);
        elect_heading.setHorizontalTextPosition(JLabel.CENTER);
        //elect_heading.setBorder(BorderFactory.createLineBorder(Color.red));
        elect_heading.setBounds(365, 0, 70, 100);

        admin_login_title = new JLabel();
        admin_login_title.setText("Admin Login Panel");
        admin_login_title.setFont(new Font("Calibri", Font.BOLD, 20));
        //admin_login_title.setBorder(BorderFactory.createLineBorder(Color.red));
        admin_login_title.setBounds(320, 130, 160, 60);

        upper_line = new JPanel();
        upper_line.setBounds(100, 210, 600, 3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

        avatar = new ImageIcon(new ImageIcon("lock.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        pic_panel = new JPanel();
        pic_panel.setLayout(null);
        pic_panel_def_pic = new JLabel();
        pic_panel_def_pic.setIcon(avatar);
        pic_panel_def_pic.setBackground(Color.white);
        pic_panel_def_pic.setOpaque(true);
        pic_panel_def_pic.setBounds(0, 0, 150, 150);
        pic_panel.add(pic_panel_def_pic);
        pic_panel.setFocusable(false);
        pic_panel.setOpaque(true);
        pic_panel.setBorder(new RoundedBorder(10));
        pic_panel.setBounds(125, 230, 150, 150);

        admin_username = new JLabel();
        admin_username.setText("Username");
        admin_username.setFont(new Font("Calibri", Font.BOLD, 18));
        //admin_username.setBorder(BorderFactory.createLineBorder(Color.red));
        admin_username.setBounds(325, 250, 80, 20);
        JPanel admin_username_line = new JPanel();
        admin_username_line.setBounds(325, 270, 350, 3);
        admin_username_line.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        admin_username_textfield = new JTextField();
        admin_username_textfield.setFont(new Font("Calibri", Font.PLAIN, 15));
        admin_username_textfield.setBorder(null);
        admin_username_textfield.setHorizontalAlignment(JTextField.CENTER);
        admin_username_textfield.setBounds(405, 250, 270, 20);

        admin_password = new JLabel();
        admin_password.setText("Password");
        admin_password.setFont(new Font("Calibri", Font.BOLD, 18));
        //admin_password.setBorder(BorderFactory.createLineBorder(Color.red));
        admin_password.setBounds(325, 310, 75, 20);
        JPanel admin_password_line = new JPanel();
        admin_password_line.setBounds(325, 330, 350, 3);
        admin_password_line.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        admin_password_textfield = new JTextField();
        admin_password_textfield.setFont(new Font("Calibri", Font.PLAIN, 15));
        admin_password_textfield.setBorder(null);
        admin_password_textfield.setHorizontalAlignment(JTextField.CENTER);
        admin_password_textfield.setBounds(405, 310, 270, 20);

        login_btn = new JButton();
        login_btn.setText("Login");
        login_btn.setFocusable(false);
        login_btn.setContentAreaFilled(false);
        login_btn.setOpaque(false);
        login_btn.setFont(new Font("Calibri", Font.BOLD, 17));
        login_btn.setBounds(400, 400, 200, 30);
        login_btn.setBorder(new RoundedBorder(20));
        login_btn.addActionListener(this);


        this.add(elect_heading);
        this.add(admin_login_title);
        this.add(upper_line);
        this.add(pic_panel);
        this.add(admin_username);
        this.add(admin_username_line);
        this.add(admin_username_textfield);
        this.add(admin_password);
        this.add(admin_password_line);
        this.add(admin_password_textfield);
        this.add(login_btn);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login_btn) {
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Elect", "root", "admin");
                String username_textfieldText = admin_username_textfield.getText();

                PreparedStatement ps = con.prepareStatement("select Username, Password from Admin where Username=?");
                try {
                    ps.setString(1, username_textfieldText);
                    ResultSet rs = ps.executeQuery();
                    rs.next();
                        String username = rs.getString("Username");
                        String password = rs.getString("Password");

                    if(admin_username_textfield.getText().equals(username) && admin_password_textfield.getText().equals(password)){
                       this.dispose();
                       new MainFrame();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Invalid Credentials", "Error",JOptionPane.ERROR_MESSAGE);
                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            } catch (SQLException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}

