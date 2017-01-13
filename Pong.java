////////////////////////////////////////////////////////////////////////////////////
//
//  C212 Spring 16
//
//  Final Project
//  Due: Friday 4/22 11:59 pm
//  @Author  Earl Dean
//  Name: Shiyue Pei
//  Username: shipei
//
///////////////////////////////////////////////////////////////////////////////////
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Pong extends JFrame
{
  public Pong()
  {
    JFrame f = new JFrame("BreakOut");
    f.pack();
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    PongPanel x = new PongPanel();
    f.addKeyListener(x);
    f.getContentPane().add(x);
    f.setSize(500, 500);
    x.setFocusable(true);
  }
  public static void main(String[] args) 
  {
    Pong pong = new Pong();
  }
}
  