import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeregistrationFrame extends JFrame implements ActionListener {
    JLabel elect_heading;
    ImageIcon icon;
    ImageIcon header_icon;
    JLabel dereg_title;
    JPanel upper_line;
    JLabel st_id;
    JTextField st_id_textfield;
    JButton dereg_btn;
    JButton back_btn;
    ImageIcon back_icon;
    JPanel pic_panel;
    ImageIcon avatar;
    JLabel pic_panel_def_pic;
    public DeregistrationFrame(){
        this.setSize(800,500);
        this.setTitle("Candidate Registration");
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
        //elect_heading.setBorder(BorderFactory.createLineBorder(Color.red));
        elect_heading.setBounds(365,0,70,100);

        dereg_title = new JLabel();
        dereg_title.setText("Candidate Deregister Panel");
        dereg_title.setFont(new Font("Calibri",Font.BOLD,20));
        //dereg_title.setBorder(BorderFactory.createLineBorder(Color.red));
        dereg_title.setBounds(283,130,234,60);

        upper_line = new JPanel();
        upper_line.setBounds(100,210,600,3);
        upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

        st_id = new JLabel();
        st_id.setText("Student ID");
        st_id.setFont(new Font("Calibri",Font.BOLD,18));
        //st_id.setBorder(BorderFactory.createLineBorder(Color.red));
        st_id.setBounds(325,290,85,20);
        JPanel st_name_line= new JPanel();
        st_name_line.setBounds(325,310,350,3);
        st_name_line.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        st_id_textfield = new JTextField();
        st_id_textfield.setFont(new Font("Calibri",Font.PLAIN,15));
        st_id_textfield.setBorder(null);
        st_id_textfield.setBounds(410,290,265,20);

        dereg_btn = new JButton();
        dereg_btn.setText("Deregister");
        dereg_btn.setFocusable(false);
        dereg_btn.setContentAreaFilled(false);
        dereg_btn.setOpaque(false);
        dereg_btn.setFont(new Font("Calibri",Font.BOLD,17));
        dereg_btn.setBounds(400,360,200,30);
        dereg_btn.setBorder(new RoundedBorder(20));
        dereg_btn.addActionListener(this);

        avatar = new ImageIcon(new ImageIcon("shredder.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        pic_panel = new JPanel();
        pic_panel.setLayout(null);
        pic_panel_def_pic = new JLabel();
        pic_panel_def_pic.setIcon(avatar);
        pic_panel_def_pic.setBackground(Color.white);
        pic_panel_def_pic.setOpaque(true);
        pic_panel_def_pic.setBounds(0,0,150,150);
        pic_panel.add(pic_panel_def_pic);
        pic_panel.setFocusable(false);
        pic_panel.setOpaque(true);
        pic_panel.setBorder(new RoundedBorder(10));
        pic_panel.setBounds(125,230,150,150);

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
        this.add(dereg_title);
        this.add(upper_line);
        this.add(st_id);
        this.add(st_id_textfield);
        this.add(st_name_line);
        this.add(dereg_btn);
        this.add(pic_panel);
        this.add(back_btn);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == dereg_btn){

        } else if (e.getSource() == back_btn) {
            this.dispose();
            new RegDeregFrame();
        }
    }
}
