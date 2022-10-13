import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AdminDelete extends JFrame implements ActionListener {
    JLabel elect_heading;
    ImageIcon icon;
    ImageIcon header_icon;
    JLabel admin_delete_title;
    JButton delete_btn;
    JButton back_btn;
    JPanel upper_line;
    JPanel pic_panel;
    JLabel pic_panel_def_pic;
    ImageIcon avatar;
    JLabel admin_username;
    JTextField admin_username_textfield;
    JLabel admin_password;
    JTextField admin_password_textfield;
    public AdminDelete() {
        this.setSize(800, 500);
        this.setTitle("Admin Deletion Panel");
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

        admin_delete_title = new JLabel();
        admin_delete_title.setText("Admin Deletion Panel");
        admin_delete_title.setFont(new Font("Calibri", Font.BOLD, 20));
        //admin_delete_title.setBorder(BorderFactory.createLineBorder(Color.red));
        admin_delete_title.setBounds(306, 130, 188, 60);

        upper_line = new JPanel();
        upper_line.setBounds(100, 210, 600, 3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

        avatar = new ImageIcon(new ImageIcon("admin_delete.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
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

        delete_btn = new JButton();
        delete_btn.setText("Delete");
        delete_btn.setFocusable(false);
        delete_btn.setContentAreaFilled(false);
        delete_btn.setOpaque(false);
        delete_btn.setFont(new Font("Calibri", Font.BOLD, 17));
        delete_btn.setBounds(400, 400, 200, 30);
        delete_btn.setBorder(new RoundedBorder(20));
        delete_btn.addActionListener(this);


        this.add(elect_heading);
        this.add(admin_delete_title);
        this.add(upper_line);
        this.add(pic_panel);
        this.add(admin_username);
        this.add(admin_username_line);
        this.add(admin_username_textfield);
        this.add(admin_password);
        this.add(admin_password_line);
        this.add(admin_password_textfield);
        this.add(delete_btn);
        this.add(back_btn);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == delete_btn){
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Elect", "root", "admin");
                String username_textfieldText = admin_username_textfield.getText();

                PreparedStatement ps0 = con.prepareStatement("select Username, Password from Admin where Username=?");
                try {
                    ps0.setString(1, username_textfieldText);
                    ResultSet rs0 = ps0.executeQuery();
                    rs0.next();
                    String username = rs0.getString("Username");
                    String password = rs0.getString("Password");

                    if(admin_username_textfield.getText().equals(username) && admin_password_textfield.getText().equals(password)){
                        PreparedStatement ps1 = con.prepareStatement("delete from Admin where Username=?");
                        try{
                            ps1.setString(1,admin_username_textfield.getText());
                            ps1.executeUpdate();
                            JOptionPane.showMessageDialog(null, "Administrator deleted", "Success",JOptionPane.INFORMATION_MESSAGE);
                            admin_username_textfield.setText(null);
                            admin_password_textfield.setText(null);

                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Administrator Not Found", "Success",JOptionPane.ERROR_MESSAGE);
                            System.out.println("Exception : "+ex);
                        }
                    }

                    else if((admin_username_textfield.getText().equals(username) && !admin_password_textfield.getText().equals(password))){
                        JOptionPane.showMessageDialog(null, "Invalid Credentials", "Success",JOptionPane.ERROR_MESSAGE);
                    }



                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Administrator Not Found ", "Success",JOptionPane.ERROR_MESSAGE);
                    System.out.println("Exception : "+ex);
                }
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Exception : "+ex);
            }
        }
        else if(e.getSource() == back_btn){
            new AdminSignupDelete();
            this.dispose();
        }
    }
}