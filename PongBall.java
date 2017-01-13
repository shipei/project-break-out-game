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
import java.awt.Rectangle;

public class PongBall 
{
  private int x;
  private int y;
  private int radius;
  private int dx = 1;
  private int dy = 1;
  
  public PongBall(int x, int y, int r)
  {
    this.radius = r;
    this.x = x;
    this.y = y;
  }

  public void draw(Graphics g)
  {
    g.setColor(Color.YELLOW);
    g.drawOval(this.x-this.radius, this.y-this.radius, radius*2, radius*2);
    g.setColor(new Color(102, 102, 255));
    g.fillOval(this.x-this.radius, this.y-this.radius, radius*2, radius*2);
  }
  public void move()
  {
    this.x += this.dx;
    this.y += this.dy;
  }
  
  public int getX() {
    return this.x;
  }
  
  public int getY() {
    return this.y;
  }
  
  public int getR() {
    return this.radius;
  }
  
   public int getDx() {
    return this.dx;
  }
   
    public int getDy() {
    return this.dy;
  }
   
   public void setDx(int a) {
      this.dx *= a;
   }
   
   public void addDx(int a) {
     this.dx += 1;
   }
   
   public void minDx(int a) {
     this.dx -= 1;
   }
   
    public void setDy(int a) {
     this.dy *= a;
   }
    
     public Rectangle getRect()
    {
      return new Rectangle(getX(), getY(), this.radius*2, this.radius*2);
    }

  
  public static void main(String[] args){} 
}
