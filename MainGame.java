 
import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel.*;
import java.awt.event.*;
import java.awt.Color.*;

/**
 * Write a description of class SimpleFrame here.
 *
 * @author fa358
 * @version March-2019
 */
public class Panels extends JFrame 
             implements ActionListener
{
    private final int ROWS = 2;
    private final int COLS = 5;
    private final int GAP = 1;
    private final int NUM = 9;
    private int x;
    
    private JPanel pane = new JPanel(new GridLayout(ROWS,COLS, GAP,GAP));
    private JPanel [] panel1 = new JPanel[NUM];//an array of panels
    private Color col1 = Color.RED;
    
    private Component clicked;
    private Color tempColor;
    
    private JPanel panel2 = new JPanel();    
    private JPanel panel3 = new JPanel();
    
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    
    private JTextArea textField = new JTextArea();
    
    int score = 0;
    int goal = 5;
    
    public Panels() //constructor
    {
        super("My frame with panels");
        setSize(400,300);
        setBoard();
        makeFrame();
        
        
        setVisible(true);
    }

    
    public void makeFrame() //makes frame
    {
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout());
        
        
        
        
        JButton button1 = new JButton("Play the game");
        JButton button2 = new JButton("Exit");
        
        JButton button3 = new JButton("Easy");
        JButton button4 = new JButton("Intermediate");
        JButton button5 = new JButton("Difficult");
        
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                 
                    resetGame();
                    textField.setText("");
                
            }
        });
        
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                goal = 5;
            }
        });
        
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                goal = 7;
            }
        });
        
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                goal = 9;
            }
        });
        add(pane);
        add(panel2, new FlowLayout());
        
        
        
        add(panel3);
        
        
        
        
        
        
        panel2.add(button1);
        panel2.add(button2);
        panel2.add(textField);
        panel3.add(button3);
        panel3.add(button4);
        panel3.add(button5);
        
        
        panel2.setBackground(Color.BLUE);
        panel3.setBackground(Color.GREEN);
        
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        String greet;
        Object source = e.getSource(); //very handy when you have multiple buttons
        
    }
    
    
    public void resetGame(){ //resets game
        for(int x = 0; x < NUM; x++) {
            panel1[x].setBackground(col1);
        }
        score = 0;
        panel1[8].setBackground(col1);
    }
    
    public void setBoard() //sets board
    {    
        for(int x = 0; x < NUM; x++) {
           panel1[x] = new JPanel();
           pane.add(panel1[x]);
           int rem = COLS % 2;
        
           panel1[x].setBackground(col1);
           
           panel1[x].addMouseListener( new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) { //class for clickable panels
                   
                   clicked = (Component)e.getSource();
                   clicked.setBackground(Color.yellow);
                   
                   score++;
                   textField.setText("Score: " + score);
                   
                   
                   if(score == goal)
                   {
                       textField.setText("You win! You got " + score + "Points");
                   }
                }
            });
        }
        panel1[8] = new JPanel();
           pane.add(panel1[8]);
           panel1[8].setBackground(col1);
           panel1[8].setName("bomb");
           panel1[8].addMouseListener( new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) { //class for bomb panel
                   
                   clicked = (Component)e.getSource();
                  
                   if (clicked.getName() == "bomb")
                   {
                       clicked.setBackground(Color.black);
                       textField.setText("You lose! You got" + score + "points ");
                       
                   }
                }
            });
    }
}
