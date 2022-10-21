import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class VoterVerification implements ActionListener {
    JLabel elect_heading;
    ImageIcon icon;
    ImageIcon header_icon;
    JLabel user_ID;
    JPanel upper_line;
    ImageIcon avatar;
    JPanel pic_panel;
    JLabel pic_panel_def_pic;
    JTextField user_ID_textfield;
    JTextField user_password_textfield;
    JButton login_btn;
    JButton back_btn;
    ImageIcon back_icon;
    JFrame frame;
    public VoterVerification(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("Exception : "+ex);
        }
        frame = new JFrame();
        frame.setSize(800, 500);
        frame.setTitle("User Verification");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.white);
        icon = new ImageIcon("logo.png");
        frame.setIconImage(icon.getImage());

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

        JLabel verification_title = new JLabel();
        verification_title.setText("User verification panel");
        verification_title.setFont(new Font("Calibri", Font.BOLD, 20));
        //verification_title.setBorder(BorderFactory.createLineBorder(Color.red));
        verification_title.setBounds(303, 130, 195, 60);

        upper_line = new JPanel();
        upper_line.setBounds(100, 210, 600, 3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

        avatar = new ImageIcon("verify.png");
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

        user_ID = new JLabel();
        user_ID.setText("User ID");
        user_ID.setFont(new Font("Calibri", Font.BOLD, 18));
        // user_ID.setBorder(BorderFactory.createLineBorder(Color.red));
        user_ID.setBounds(325, 250, 80, 20);
        JPanel user_ID_line = new JPanel();
        user_ID_line.setBounds(325, 270, 350, 3);
        user_ID_line.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        user_ID_textfield = new JTextField();
        user_ID_textfield.setFont(new Font("Calibri", Font.PLAIN, 15));
        user_ID_textfield.setBorder(null);
        user_ID_textfield.setHorizontalAlignment(JTextField.CENTER);
        user_ID_textfield.setBounds(405, 250, 270, 20);

        JLabel user_password = new JLabel();
        user_password.setText("Password");
        user_password.setFont(new Font("Calibri", Font.BOLD, 18));
        // user_password.setBorder(BorderFactory.createLineBorder(Color.red));
        user_password.setBounds(325, 310, 80, 20);
        JPanel user_password_line = new JPanel();
        user_password_line.setBounds(325, 330, 350, 3);
        user_password_line.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        user_password_textfield = new JTextField();
        user_password_textfield.setFont(new Font("Calibri", Font.PLAIN, 15));
        user_password_textfield.setBorder(null);
        user_password_textfield.setHorizontalAlignment(JTextField.CENTER);
        user_password_textfield.setBounds(405, 310, 270, 20);

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

        login_btn = new JButton();
        login_btn.setText("Login");
        login_btn.setFocusable(false);
        login_btn.setContentAreaFilled(false);
        login_btn.setOpaque(false);
        login_btn.setFont(new Font("Calibri", Font.BOLD, 17));
        login_btn.setBounds(400, 400, 200, 30);
        login_btn.setBorder(new RoundedBorder(20));
        login_btn.addActionListener(this);


        frame.add(elect_heading);
        frame.add(verification_title);
        frame.add(upper_line);
        frame.add(pic_panel);
        frame.add(user_ID);
        frame.add(user_ID_line);
        frame.add(user_ID_textfield);
        frame.add(user_password);
        frame.add(user_password_line);
        frame.add(user_password_textfield);
        frame.add(login_btn);
        frame.add(back_btn);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login_btn){
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Elect", "root", "admin");
                String username_textfieldText = user_ID_textfield.getText();
                PreparedStatement ps = con.prepareStatement("select ID, Password from Users where ID=?");
                try {
                    ps.setString(1, username_textfieldText);
                    ResultSet rs = ps.executeQuery();
                    rs.next();
                    String ID = rs.getString("ID");
                    String password = rs.getString("Password");
                    System.out.println(ID+password);
                    if(user_ID_textfield.getText().equals(ID) && user_password_textfield.getText().equals(password)){

                        JOptionPane.showMessageDialog(null, "Credentials Match", "Match",JOptionPane.INFORMATION_MESSAGE);
                        new Positions();
                        frame.dispose();

                    }
                    else if(user_ID_textfield.getText().equals(ID) && !user_password_textfield.getText().equals(password)){
                        JOptionPane.showMessageDialog(null, "Invalid Password", "Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Invalid Credentials", "Error",JOptionPane.ERROR_MESSAGE);
                    }

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Credentials", "Error",JOptionPane.ERROR_MESSAGE);
                    user_ID_textfield.setText(null);
                    user_password_textfield.setText(null);
                    System.out.println("Exception : "+ex);

                }
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Exception : "+ex);
            }
        }
        else if (e.getSource() == back_btn){
            frame.dispose();
        }
    }
}
