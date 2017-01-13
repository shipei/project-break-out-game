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
import java.awt.*;
import java.lang.Math;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Point;
import java.awt.Rectangle;
abstract class Shape {
  
  private Color fillColor; 
  private Color borderColor; 
  private Boolean isFilled;  
  private Point Location; 
   int dx = 1;
   int dy = 1;
  // the three constructors initialize the instance fields  
  public Shape(Color fillColor, Color borderColor, int x, int y) 
    {
    this.borderColor = borderColor;
    this.fillColor = fillColor;
    this.isFilled = true;
    this.Location = new Point(x,y);
  }
  // set borderColor to Black since not provided   
  public Shape(Color fillColor, int x, int y)
  {
    this.borderColor = Color.BLACK;
    this.Location = new Point(x, y);
  }
  // set fillColor to white and border color to black  
  public Shape(int x, int y)
  {
    this.Location = new Point(x, y);
    this.fillColor = Color.WHITE;
    this.borderColor = Color.BLACK;
  }
  public void setFillColor(Color c) 
  {
    this.fillColor = c;
  }      
  public Color getFillColor() 
  {
    return this.fillColor;
  }      
  public void setBorderColor(Color c)
  {
    this.borderColor = c;
  }    
  public Color getBorderColor() 
  {
    return this.borderColor;
  }     
  public Point getLocation() 
  {
   return this.Location; 
  }      
// Note:  subclasses of Shape do not inherent private members 
  // so we need methods the subclasses can use to get the x and y values
  // from the private Point instance field   
  public int getX() 
  { 
    return (int)Location.getX();
  }      
  public int getY() 
  {
    return (int) Location.getY();
  }     
  // if fillColor is white returns true, else returns false    
  public boolean isFilled() 
  { 
    if(fillColor == Color.WHITE)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  
 public void changeXDir()
 {
   this.dx *= -1;
 }
 
 public void changeYDir()
 {
   this.dy *= -1;
 }

  
// moves location by dx and dy    
  public void move()
  {
    this.Location = new Point (this.getX()+dx, this.getY()+dy); 
  }      
  abstract double getArea();  
  abstract double getPerimeter(); 
  abstract Rectangle getRect(); 
  abstract void draw(Graphics g);
  public static void main(String[] args)
  {  
  }
} 
  