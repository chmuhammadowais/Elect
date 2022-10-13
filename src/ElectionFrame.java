import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ElectionFrame extends JFrame implements ActionListener {
    JLabel elect_heading;
    ImageIcon icon;
    ImageIcon header_icon;
    JLabel main_title;
    JPanel upper_line;
    JLabel time_span_label;
    JTextField time_span_textfield;
    JButton set_time_btn;
    JButton back_btn;
    ImageIcon back_icon;
    JPanel pic_panel;
    ImageIcon avatar;
    JLabel pic_panel_def_pic;

    public ElectionFrame(){
    this.setSize(800,500);
    this.setTitle("Time Panel");
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

    main_title = new JLabel();
    main_title.setText("Election Time Setup");
    main_title.setFont(new Font("Calibri",Font.BOLD,20));
    //main_title.setBorder(BorderFactory.createLineBorder(Color.red));
    main_title.setBounds(315,130,170,60);

    upper_line = new JPanel();
    upper_line.setBounds(100,210,600,3);
    upper_line.setBorder(BorderFactory.createRaisedBevelBorder());

    time_span_label = new JLabel();
    time_span_label.setText("Time span");
    time_span_label.setFont(new Font("Calibri",Font.BOLD,18));
    //time_span_label.setBorder(BorderFactory.createLineBorder(Color.red));
    time_span_label.setBounds(325,290,100,20);
    JPanel time_span_line= new JPanel();
    time_span_line.setBounds(325,310,350,3);
    time_span_line.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
    time_span_textfield = new JTextField();
    time_span_textfield.setFont(new Font("Calibri",Font.PLAIN,15));
    time_span_textfield.setBorder(null);
    time_span_textfield.setBounds(410,290,265,20);

    set_time_btn = new JButton();
    set_time_btn.setText("Set Time");
    set_time_btn.setFocusable(false);
    set_time_btn.setContentAreaFilled(false);
    set_time_btn.setOpaque(false);
    set_time_btn.setFont(new Font("Calibri",Font.BOLD,17));
    set_time_btn.setBounds(400,360,200,30);
    set_time_btn.setBorder(new RoundedBorder(20));
    set_time_btn.addActionListener(this);

    avatar = new ImageIcon("time span.png");
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
    this.add(main_title);
    this.add(upper_line);
    this.add(time_span_label);
    this.add(time_span_textfield);
    this.add(time_span_line);
    this.add(set_time_btn);
    this.add(pic_panel);
    this.add(back_btn);
    this.setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == set_time_btn){
            String time = time_span_textfield.getText();
            System.out.println(time);
        }
        else if(e.getSource() == back_btn){
            new MainFrame();
            this.dispose();

        }
    }
}
