import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Timed implements ActionListener {
    JLabel elect_heading;
    ImageIcon icon;
    ImageIcon header_icon;
    JLabel main_title;
    JPanel upper_line;
    JPanel lower_line;
    JLabel hour_label;
    JLabel min_label;
    JButton set_time_btn;
    JButton back_btn;
    ImageIcon back_icon;
    JPanel image_panel;
    ImageIcon avatar;
    JLabel image_panel_piclabel;
    JComboBox<Object> hour_box;
    JComboBox<Object> min_box;
    JFrame frame;
    JFrame time_confirmation_frame;
    JButton set_time_button;
    Timer timer;
    JProgressBar progressBar;


    public Timed(){
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

        hour_label = new JLabel();
        hour_label.setText("Hours");
        hour_label.setFont(new Font("Calibri",Font.BOLD,20));
    //    hour_label.setBorder(BorderFactory.createLineBorder(Color.red));
        hour_label.setBounds(338,290,55,35);


        String[] Hours = {"00","01","02","03","04","05"};
        hour_box = new JComboBox<>(Hours);
        hour_box.setFocusable(false);
        hour_box.setFont(new Font("Calibri",Font.PLAIN,15));
        hour_box.setBorder(new RoundedBorder(5));
        hour_box.addActionListener(this);
        hour_box.setBounds(393,290,90,35);

        min_label = new JLabel();
        min_label.setText("Minutes");
        min_label.setFont(new Font("Calibri",Font.BOLD,20));
       // min_label.setBorder(BorderFactory.createLineBorder(Color.red));
        min_label.setBounds(493,290,73,35);

        String[] Minutes = {"01","15","30","45","50"};//dynamic using arraylist
        min_box = new JComboBox<>(Minutes);
        min_box.setFocusable(false);
        min_box.setFont(new Font("Calibri",Font.PLAIN,15));
        min_box.setBorder(new RoundedBorder(5));
        min_box.addActionListener(this);
        min_box.setBounds(566,290,90,35);

        lower_line = new JPanel();
        lower_line.setBounds(338, 350, 318, 3);
        lower_line.setBorder(BorderFactory.createRaisedBevelBorder());

        set_time_btn = new JButton();
        set_time_btn.setText("Set Time");
        set_time_btn.setFocusable(false);
        set_time_btn.setContentAreaFilled(false);
        set_time_btn.setOpaque(false);
        set_time_btn.setFont(new Font("Calibri",Font.BOLD,17));
        set_time_btn.setBounds(400,360,200,30);
        set_time_btn.setBorder(new RoundedBorder(20));
        set_time_btn.addActionListener(this);

        avatar = new ImageIcon("timed.png");
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
        image_panel.setBounds(135,250,150,150);

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
        frame.add(hour_label);
        frame.add(set_time_btn);
        frame.add(image_panel);
        frame.add(back_btn);
        frame.add(hour_box);
        frame.add(min_box);
        frame.add(min_label);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == set_time_btn){

            System.out.println("Hour : "+hour_box.getSelectedItem()+" "+"Minutes : "+min_box.getSelectedItem());
            int hour = Integer.parseInt((String) Objects.requireNonNull(hour_box.getSelectedItem()));
            int minutes = Integer.parseInt((String) Objects.requireNonNull(min_box.getSelectedItem()));
            int in_min = hour*60+minutes;
            int in_sec =  in_min*60;
            System.out.println("In Minutes : "+in_min);
            System.out.println("In Seconds : "+in_sec);

            time_confirmation_frame = new JFrame();
            time_confirmation_frame.setSize(400,200);
            time_confirmation_frame.setLayout(null);
            time_confirmation_frame.setIconImage(null);
            time_confirmation_frame.setTitle("Time Confirmation Box");
            time_confirmation_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            time_confirmation_frame.setLocationRelativeTo(null);

            JLabel hour_label = new JLabel("Hours",SwingConstants.CENTER);
            hour_label.setFont(new Font("Calibri",Font.BOLD,12));
           // hour_label.setBorder(BorderFactory.createLineBorder(Color.yellow));
            hour_label.setBounds(95, 60, 100, 20);

            JLabel hour_label_time = new JLabel((String) hour_box.getSelectedItem(),SwingConstants.CENTER);
            hour_label_time.setFont(new Font("Calibri",Font.BOLD,50));
           // hour_label_time.setBorder(BorderFactory.createLineBorder(Color.yellow));
            hour_label_time.setBounds(95, 0, 100, 60);

            JLabel min_label = new JLabel("Minutes",SwingConstants.CENTER);
            min_label.setFont(new Font("Calibri",Font.BOLD,12));
           // min_label.setBorder(BorderFactory.createLineBorder(Color.yellow));
            min_label.setBounds(205, 60, 100, 20);

            JLabel min_label_time = new JLabel((String) min_box.getSelectedItem(),SwingConstants.CENTER);
            min_label_time.setFont(new Font("Calibri",Font.BOLD,50));
          //  min_label_time.setBorder(BorderFactory.createLineBorder(Color.yellow));
            min_label_time.setBounds(205, 0, 100, 60);

            JLabel label_colon = new JLabel(":",SwingConstants.CENTER);
          //  label_colon.setBorder(BorderFactory.createLineBorder(Color.red));
            label_colon.setFont(new Font("Calibri",Font.BOLD,30));
            label_colon.setBounds(195,0,10,60);

            set_time_button = new JButton("Set Time");
            set_time_button.setFocusable(false);
            set_time_button.setContentAreaFilled(false);
            set_time_button.setOpaque(false);
            set_time_button.setFont(new Font("Calibri",Font.BOLD,17));
            set_time_button.setBorder(new RoundedBorder(5));
            set_time_button.addActionListener(this);
            set_time_button.setBounds(100,95,200,30);


           // CastVote.frame.add(button);
            progressBar = new JProgressBar();
            progressBar.setBounds(0,452,800,10);
            ActionListener updateProBar = actionEvent -> {
                int val = progressBar.getValue();
                if (val >= 100) {
                    timer.stop();
                    JOptionPane.showMessageDialog(null,"Election Time ended.","Time up",JOptionPane.INFORMATION_MESSAGE);
                    if(CastVote.frame != null){
                        CastVote.frame.dispose();
                    }
                    return;
                }
                progressBar.setValue(++val);
            };

            timer = new Timer(in_sec*10, updateProBar);
            set_time_button.addActionListener(e1 -> {
                if (timer.isRunning()) {
                    timer.stop();
                } else  {
                    timer.start();
                }
            });
            time_confirmation_frame.add(set_time_button);
            time_confirmation_frame.add(hour_label);
            time_confirmation_frame.add(min_label);
            time_confirmation_frame.add(hour_label_time);
            time_confirmation_frame.add(min_label_time);
            time_confirmation_frame.add(label_colon);
            time_confirmation_frame.setVisible(true);


        }
        else if(e.getSource() == back_btn){
            new ElectionFrame();
            frame.dispose();

        } else if (e.getSource() == set_time_button) {
            new CastVote("Timed");
            frame.dispose();
            time_confirmation_frame.dispose();
            CastVote.frame.add(progressBar);
        }
    }
}
