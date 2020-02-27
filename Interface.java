import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Interface implements ActionListener{
    private int answer; 
    private int a;
    private int b;
    private int c;
    private int d;
    private JFrame frame = new JFrame("Maths Tutor");
    private JPanel panel = new JPanel();
    private JPanel buttonpanel = new JPanel();
    private BorderLayout layout = new BorderLayout();
    private GridLayout buttonlayout = new GridLayout(1, 3);
    private JButton lessButton = new JButton("<");
    private JButton greaterButton = new JButton(">");
    private JButton equalButton = new JButton("=");
    private JLabel qLabel = new JLabel("Welcome to Maths Tutor!");
    private JButton qButton = new JButton("Ask me a question!");

    public Interface(){
        frame.setVisible(true);
        frame.setSize(400,200);

        panel.setLayout(layout);
        buttonpanel.setLayout(buttonlayout);

        
        lessButton.addActionListener(this);
        greaterButton.addActionListener(this);
        equalButton.addActionListener(this);
        buttonpanel.add(lessButton);
        buttonpanel.add(greaterButton);
        buttonpanel.add(equalButton);

        panel.add("North", qLabel);
        panel.add("Center", buttonpanel);
        
        qButton.addActionListener(this);
        panel.add("South", qButton);

        frame.setContentPane(panel);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == qButton){
            a = (int)(Math.random() * 10 + 1);
            b = (int)(Math.random() * 10 + 1);
            c = (int)(Math.random() * 10 + 1);
            d = (int)(Math.random() * 10 + 1);
            qLabel.setText(String.format("is %2d + %2d greater than, less than or equal to %2d + %2d ?", a, b, c, d));
            if ((a+b)<(c+d)){
                answer = 0;
            }
            else if ((a+b)>(c+d)){
                answer = 1;
            }
            else{
                answer = 2;
            }
        }
        if (e.getSource() == lessButton){
            if (answer == 0){
                qLabel.setText("Correct!");
            }
            else{
                qLabel.setText("Wrong! Idiot!");
            }
        }
        if (e.getSource() == greaterButton){
            if (answer == 1){
                qLabel.setText("Correct!");
            }
            else{
                qLabel.setText("Wrong! Idiot!");
            }
        }
        if (e.getSource() == equalButton){
            if (answer == 2){
                qLabel.setText("Correct!");
            }
            else{
                qLabel.setText("Wrong! Idiot!");
            }
        }
    }
}