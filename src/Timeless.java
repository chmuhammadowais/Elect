import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Timeless implements ActionListener {
    JLabel elect_heading;
    ImageIcon icon;
    ImageIcon header_icon;
    JLabel main_title;
    JPanel upper_line;
    JPanel lower_line;
    JButton back_btn;
    ImageIcon back_icon;
    JPanel image_panel;
    ImageIcon avatar;
    JLabel image_panel_piclabel;
    JFrame frame;

    public Timeless(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("Exception : "+ex);
        }
        frame = new JFrame();
        frame.setSize(800,500);
        frame.setTitle("Time Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.white);
        icon = new ImageIcon("logo.png");
        frame.setIconImage(icon.getImage());

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

        lower_line = new JPanel();
        lower_line.setBounds(338, 350, 318, 3);
        lower_line.setBorder(BorderFactory.createRaisedBevelBorder());

        avatar = new ImageIcon("time span.png");
        image_panel = new JPanel();
        image_panel.setLayout(null);
        image_panel_piclabel = new JLabel();
        image_panel_piclabel.setIcon(avatar);
        image_panel_piclabel.setBackground(Color.white);
        image_panel_piclabel.setOpaque(true);
        image_panel_piclabel.setBounds(0,0,150,150);
        image_panel.add(image_panel_piclabel);
        image_panel.setFocusable(false);
        image_panel.setOpaque(true);
        image_panel.setBorder(new RoundedBorder(10));
        image_panel.setBounds(125,230,150,150);

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

        frame.add(elect_heading);
        frame.add(main_title);
        frame.add(upper_line);
        frame.add(image_panel);
        frame.add(back_btn);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
//        if(){
//
//
//        }
//        else if(e.getSource() == back_btn){
//            new ElectionFrame();
//            frame.dispose();
//
//        }

    }
}
