package Functionality;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AdminDelete  implements ActionListener {
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
    JPasswordField admin_password_textfield;
    JFrame frame;
    JButton show_password;
    int show_counter;
    public AdminDelete() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("OptionPane.background", Color.white);
            UIManager.put("Panel.background", Color.white);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("Exception : "+ex);
        }
        frame = new JFrame();
        frame.setSize(800, 500);
        frame.setTitle("Admin Deletion Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.white);
        icon = new ImageIcon("./src/Resources/logo.png");
        frame.setIconImage(icon.getImage());

        header_icon = new ImageIcon("./src/Resources/heading.png");
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

        avatar = new ImageIcon(new ImageIcon("./src/Resources/admin_delete.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
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
        admin_password_textfield = new JPasswordField();
        admin_password_textfield.setEchoChar('*');
        admin_password_textfield.setFont(new Font("Calibri", Font.PLAIN, 15));
        admin_password_textfield.setBorder(null);
        admin_password_textfield.setHorizontalAlignment(JTextField.CENTER);
        admin_password_textfield.setBounds(405, 310, 270, 20);

        back_btn = new JButton();
        ImageIcon back_icon = new ImageIcon("./src/Resources/back.png");
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

        ImageIcon eye_icon = new ImageIcon("./src/Resources/eye.png");
        show_password = new JButton();
        show_password.setIcon(eye_icon);
        show_password.setFocusable(false);
        show_password.setContentAreaFilled(false);
        show_password.setBorder(null);
        show_password.addActionListener(this);
        show_password.setBounds(675,310,20,20);

        frame.add(elect_heading);
        frame.add(admin_delete_title);
        frame.add(upper_line);
        frame.add(pic_panel);
        frame.add(admin_username);
        frame.add(admin_username_line);
        frame.add(admin_username_textfield);
        frame.add(admin_password);
        frame.add(admin_password_line);
        frame.add(admin_password_textfield);
        frame.add(delete_btn);
        frame.add(back_btn);
        frame.add(show_password);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == delete_btn) {
            verify_call(admin_username_textfield.getText(), String.copyValueOf(admin_password_textfield.getPassword()));
        }
        else if(e.getSource() == back_btn){
           back_call();
        }
        else if(e.getSource() == show_password){
            show_password_call();
        }
    }
    public boolean verify_call(String adm_username_textfield, String adm_password_textfield){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Elect", "root", "admin");

            PreparedStatement ps0 = con.prepareStatement("select count(Username) as Counted from Admin");
            try {
                ResultSet rs0 = ps0.executeQuery();
                rs0.next();
                int counted_admins = rs0.getInt("Counted");
                if (counted_admins > 1) {
                    PreparedStatement ps1 = con.prepareStatement("select Username, Password from Admin where Username=?");
                    try {
                        ps1.setString(1, adm_username_textfield);
                        ResultSet rs1 = ps1.executeQuery();
                        rs1.next();
                        String username = rs1.getString("Username");
                        String password = rs1.getString("Password");

                        if (adm_username_textfield.equals(username) && adm_password_textfield.equals(password)) {
                            delete_call(adm_username_textfield);
                            return true;
                        } else if (adm_username_textfield.equals(username)) {
                            JOptionPane.showMessageDialog(null, "Invalid Password", "Success", JOptionPane.ERROR_MESSAGE);
                        }

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Administrator Not Found ", "Success", JOptionPane.ERROR_MESSAGE);
                        System.out.println("Exception : " + ex);
                        return false;
                    }

                }
                else if(counted_admins == 1){
                    JOptionPane.showMessageDialog(null,"Cannot delete the only admin. You won't be able to log back into the system again.","Error",JOptionPane.ERROR_MESSAGE);
                    admin_username_textfield.setText(null);
                    admin_password_textfield.setText(null);
                    return false;
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Database returned Error","Error",JOptionPane.ERROR_MESSAGE);
                System.out.println("Exception : "+ex);
                return false;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Exception : "+ex);
            return false;
        }
        return false;
    }
    public boolean delete_call(String adm_to_del){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Elect", "root", "admin");
            PreparedStatement ps2 = con.prepareStatement("delete from Admin where Username=?");
            try {
                ps2.setString(1, adm_to_del);
                ps2.executeUpdate();
                JOptionPane.showMessageDialog(null, "Administrator deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
                admin_username_textfield.setText(null);
                admin_password_textfield.setText(null);
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Administrator Not Found", "Success", JOptionPane.ERROR_MESSAGE);
                System.out.println("Exception : " + ex);
                return false;
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Exception : "+e);
            return false;
        }
    }
    public boolean back_call(){
        try{
            new AdminSignupDelete();
            frame.dispose();
            return true;
        }
        catch (Exception e){
            System.out.println("Exception : "+e);
            return false;
        }

    }
    public boolean show_password_call(){
        try{
            if(show_counter%2 ==0){
                admin_password_textfield.setEchoChar('*');
            }
            else{
                admin_password_textfield.setEchoChar((char)0);
            }
            show_counter++;
            return true;
        }
        catch(Exception e){
            System.out.println("Exception : "+e);
            return false;
        }

    }

}
