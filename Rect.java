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
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics;

class Rect extends Shape
{
  int length;
  int width;
  
  public Rect(Color fillColor, Color borderColor, int x, int y, int l, int w)
{
  super(fillColor, borderColor, x, y);
  this.length = l;
  this.width = w;
  }
public Rect(Color fillColor, int x, int y, int l, int w)
{
 super(fillColor, x,y);
 this.length = l;
 this.width = w;
}
public Rect(int x, int y, int l, int w)
{
 super(x,y);
 this.length = l;
 this.width = w;
}
public double getPerimeter() 
{
  double result = (this.length + this.width) * 2;
  return result;
}
public double getArea()
{
  double result = this.length * this.width;
  return result;
}

 public void draw(Graphics g)
  {
    int a  = super.getX();
    int b  = super.getY();
    g.setColor(getBorderColor());
    g.drawRoundRect(a, b, width, length, 5, 5);
    g.setColor(getFillColor());
    g.fillRoundRect(a, b, width, length, 5, 5);
  }
 
 public void move() {
   super.move();
   if(this.getX() + width + 1 >= 600) {
     this.changeXDir();
     
   }
   else if (this.getY() + length + 1 >= 600) {
     this.changeYDir();
   }
 }
 
 
   /*public void move(){
    super.move();
  center.setLocation(center.getX() + super.dx,center.getY() + super.dy); 
  }*/
 
  public Rectangle getRect()
  {
    return new Rectangle(getX(), getY(), this.width, this.length);
  }
  
  
  
public String toString()
  {
    return "Rectangle location: " + this.getLocation();
  }

  public static void main(String[] args)
  {
    Rectangle a = new Rectangle(5, 4, 3, 4);
    System.out.println(a);
  }
}
