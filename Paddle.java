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

public class Paddle 
{
  private int length;
  private int width;
  private int x;
  private int y;
  private int dx = 1;
  
  public Paddle(int x, int y)
  {
    this.x = x;
    this.y = y;
    length = 100;
    width = 15;
  }
  
  public void draw(Graphics g)
  {
    g.setColor(Color.YELLOW);
    g.drawRoundRect(x, y, length, width, 15, 15);
    g.setColor(Color.BLUE);
    g.fillRoundRect(x, y, length, width, 15, 15);
  }
  
  public int getLen() {
    return this.length;
  }
  
  public int getWid() {
    return this.width;
  }
  
   public int getX() {
    return this.x;
  }
  
  public int getY() {
    return this.y;
  }
  
   public void move(int m)
  {
     this.x += m;
  }
  
  public static void main(String[] args){}
}