import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame1 extends JFrame implements ActionListener {
JButton submit;
    public Frame1(){
        this.setSize(800,500);
        this.setTitle("Candidate Registration");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.white);
        Border border = BorderFactory.createLineBorder(Color.red);
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

        JLabel reg_title = new JLabel();
        reg_title.setText("Candidate Registration Panel");
        reg_title.setFont(new Font("Calibri",Font.BOLD,20));
        //reg_title.setBorder(border);
        reg_title.setBounds(274,130,248,60);

        JPanel upper_line = new JPanel();
        upper_line.setBounds(100,210,600,3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

        ImageIcon avatar = new ImageIcon("avatar.png");
        JPanel pic_panel = new JPanel();
        pic_panel.setLayout(null);
        JLabel pic_panel_def_pic = new JLabel();
        pic_panel_def_pic.setIcon(avatar);
        pic_panel_def_pic.setBounds(0,0,150,150);
        pic_panel.add(pic_panel_def_pic);
        pic_panel.setFocusable(false);
        pic_panel.setOpaque(true);
        pic_panel.setBorder(new RoundedBorder(10));
        pic_panel.setBounds(125,230,150,150);

        JLabel st_id = new JLabel();
        st_id.setText("Student ID");
        st_id.setFont(new Font("Calibri",Font.BOLD,18));
        //st_id.setBorder(border);
        st_id.setBounds(325,230,85,20);
        JPanel st_id_line= new JPanel();
        st_id_line.setBounds(325,250,350,3);
        st_id_line.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        JTextField st_id_textfield = new JTextField();
        st_id_textfield.setFont(new Font("Calibri",Font.PLAIN,15));
        st_id_textfield.setBorder(null);
        st_id_textfield.setBounds(410,230,265,20);

        JLabel st_name = new JLabel();
        st_name.setText("Student Name");
        st_name.setFont(new Font("Calibri",Font.BOLD,18));
        //st_name.setBorder(border);
        st_name.setBounds(325,290,115,20);
        JPanel st_name_line= new JPanel();
        st_name_line.setBounds(325,310,350,3);
        st_name_line.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        JTextField st_name_textfield = new JTextField();
        st_name_textfield.setFont(new Font("Calibri",Font.PLAIN,15));
        st_name_textfield.setBorder(null);
        st_name_textfield.setBounds(440,290,235,20);

        JLabel st_email = new JLabel();
        st_email.setText("Student Email");
        st_email.setFont(new Font("Calibri",Font.BOLD,18));
        //st_email.setBorder(border);
        st_email.setBounds(325,350,110,20);
        JPanel st_email_line = new JPanel();
        st_email_line.setBounds(325,370,350,3);
        st_email_line.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        JTextField st_email_textfield = new JTextField();
        st_email_textfield.setFont(new Font("Calibri",Font.PLAIN,15));
        st_email_textfield.setBorder(null);
        st_email_textfield.setBounds(435,350,240,20);


        JPanel bottom_line = new JPanel();
        bottom_line.setBounds(125,400,550,3);
        bottom_line.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));

        submit = new JButton();
        submit.setText("Register");
        submit.setFocusable(false);
        submit.setContentAreaFilled(false);
        submit.setOpaque(false);
        submit.setFont(new Font("Calibri",Font.BOLD,17));
        submit.setBounds(300,410,200,30);
        submit.setBorder(new RoundedBorder(20));

        this.add(elect_heading);
        this.add(reg_title);
        this.add(upper_line);
        this.add(pic_panel);
        this.add(st_id);
        this.add(st_id_line);
        this.add(st_id_textfield);
        this.add(st_name);
        this.add(st_name_line);
        this.add(st_name_textfield);
        this.add(st_email);
        this.add(st_email_line);
        this.add(st_email_textfield);
        //this.add(bottom_line);
        this.add(submit);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){

        }
    }
}
