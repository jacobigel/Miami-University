import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author jacobigel
 *
 */
public class AdderMachine extends JFrame {

    private JPanel contentPane;
    /**
     * Track sum/total
     */
    private int sum = 0;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdderMachine frame = new AdderMachine();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AdderMachine() {
        setTitle("Adder Machine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JLabel lblNewLabel = new JLabel("Sum: 0");
        lblNewLabel.setToolTipText("This is the current Sum");
        contentPane.add(lblNewLabel, BorderLayout.WEST);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.EAST);
        panel.setLayout(new GridLayout(2, 2, 0, 0));
        
        JButton btnNewButton = new JButton("1");
        btnNewButton.addActionListener(e -> sum += 1);
        panel.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("2");
        btnNewButton_1.addActionListener(e -> sum += 2);
        panel.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("3");
        btnNewButton_2.addActionListener(e -> sum += 3);
        panel.add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("4");
        btnNewButton_3.addActionListener(e -> sum += 4);
        panel.add(btnNewButton_3);
        
        JButton okButton = new JButton("OK");
        okButton.addActionListener(e ->  lblNewLabel.setText("Sum: " + sum));
        contentPane.add(okButton, BorderLayout.SOUTH);
    }

}
