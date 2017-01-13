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
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Rectangle;


public class PongPanel extends JPanel implements ActionListener, KeyListener
{
  public static final int WIDTH = 500;
  public static final int HEIGHT = 500;
 
  public int count;
  private Timer timer;
  private int move;
  private int paddleX = 300;
  private int paddleY = 460;
  private int ballX = 200;
  private int ballY = 300;
  private int radius = 15;
  
  PongBall ball;
  Paddle paddle;
  
  Color c1;
  Color c2;
  Color c3;
  
  ArrayList<Rect> bricks;
  ArrayList<Color> colors;
  
  int brickLen;
  int brickWid;
  int brickX;
  int brickY;
  Rect brick;
 
  public PongPanel()
  {
      
    brickLen = 50;
    brickWid = 20;
    
    c1 = new Color(102, 178, 255);
    c2 = new Color(102, 102, 255);
    c3 = new Color(178, 102, 255);
    
    bricks = new ArrayList<Rect>();
    colors = new ArrayList<Color>();
    colors.add(c1);
    colors.add(c2);
    colors.add(c3);
    
    ball = new PongBall(ballX, ballY, radius);
    paddle = new Paddle(paddleX, paddleY);
    this.move = 5;
    count = 0;

    this.addKeyListener(this);
    timer = new Timer(5, this);
    
    setPreferredSize(new Dimension(HEIGHT, WIDTH));
    setBackground(new Color(204, 204, 255));
    this.setFocusable(true);
    timer.start();
    
    brickX = 20;
    brickY = 10;
    Random randomizer = new Random();
    brickLen = 50; 
    brickWid = 20;
    
    for(; brickY < HEIGHT / 2; brickY += 21)
    {
      brickX = 20;
      for(; brickX < WIDTH - 50; brickX += 51)
      {
        brick = new Rect(colors.get(randomizer.nextInt(3)), Color.BLACK, brickX, brickY, brickWid, brickLen);
        bricks.add(brick);
      }
    }
   
  }
  
    public void paintComponent(Graphics g)
    {
      super.paintComponent(g);
      paddle.draw(g);
      ball.draw(g);
      ballCollision();
      bricksCollision();
      
      for (Rect r : bricks) 
      {
        r.draw(g); 
      }
    }
    
    public void bricksCollision(){
        for(Rect r: bricks) 
        {
          if(r.getRect().contains(ball.getX() - ball.getR(), ball.getY()))
          {
            bricks.remove(r);
            ball.setDx(-1);
            return;
          }
          else if(r.getRect().contains(ball.getX() + ball.getR(), ball.getY()))
          {
            bricks.remove(r);
            ball.setDx(-1);
            return;
          }
          else if(r.getRect().contains(ball.getX(), ball.getY() - ball.getR()))
          {
            bricks.remove(r);
            ball.setDy(-1);
            return;
          }
          else if(r.getRect().contains(ball.getX(), ball.getY() + ball.getR()))
          {
            bricks.remove(r);
            ball.setDy(-1);
            return;
          }
          
        }
    
    }
    
    public void ballCollision()
    {
      ball.move();
        
        if(ball.getX() + ball.getR() == WIDTH)
        {
          ball.setDx(-1);
        }
        else if(ball.getX() - ball.getR() <= 0)
        {
          ball.setDx(-1);
        }
        else if (ball.getY() - ball.getR() <= 0)
        {
          ball.setDy(-1);
        }
        /*else if(ball.getX() - ball.getR() >= paddle.getX() &&
                ball.getX() + ball.getR() <= paddle.getX() + paddle.getLen() &&
                paddle.getY() - ball.getY() <= ball.getR())
        {
          ball.setDy(-1);
        }*/
        else if(ball.getY() + ball.getR() >= HEIGHT)
        {
          bricks.clear();
          timer.stop();
          JOptionPane.showMessageDialog(this, "GameOver", "BreakOut", JOptionPane.PLAIN_MESSAGE);
        } 
        else if(ball.getX() >= paddle.getX()
                  && ball.getX() <= paddle.getX() + 30 
                  && paddle.getY() - ball.getY() <= ball.getR())
        {
          ball.minDx(1);
          ball.setDy(-1);
          
        }
        else if(ball.getX() >= paddle.getX() + 30
                  && ball.getX() <= paddle.getX() + 70 
                  && paddle.getY() - ball.getY() <= ball.getR())
        {
          ball.setDx(0);
          ball.setDy(-1);
        }
        else if(ball.getX() >= paddle.getX() + 70
                  && ball.getX() <= paddle.getX() + 100 
                  && paddle.getY() - ball.getY() <= ball.getR())
        {
          ball.addDx(1);
          ball.setDy(-1); 
        }
    }

      public void actionPerformed(ActionEvent e)
      {  
        if(bricks.isEmpty())
          {
            timer.stop();
            JOptionPane.showMessageDialog(this, "You win!", "BreakOut", JOptionPane.PLAIN_MESSAGE);  
        }
        repaint();  
     }

     public void keyPressed(KeyEvent e)
     {
       switch (e.getKeyCode())
       {
         case KeyEvent.VK_LEFT:
           if(paddle.getX() <= 0)
         {
           paddle.move(0);
           break;
         }
           else
           {
             paddle.move(-10);
             break;
           }
         case KeyEvent.VK_RIGHT:
            if(paddle.getX() + paddle.getLen() >= WIDTH)
         {
           paddle.move(0);
           break;
         }
           else
           {
             paddle.move(10);
             break;
           } 
         default: break;
       }
       repaint();
     }
     
     public void keyTyped(KeyEvent e){}
     public void keyReleased(KeyEvent e){}
     
    }





    

       
       
       
       
   
   