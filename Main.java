import java.util.Scanner;
public class Main {
public static void main(String args[]) {
Scanner scan = new Scanner(System.in);
while (true) {
System.out.println("\nSelect a shape to 
calculate its area and volume:");
 System.out.println("1. Circle");
 System.out.println("2. Rectangle");
 System.out.println("3. Square");
 System.out.println("4. Sphere");
 System.out.println("5. Cylinder");
 System.out.println("6. Pyramid");
 System.out.println("7. Exit");
 int choice = scan.nextInt();
 scan.nextLine(); // Consume newline
 if (choice == 7) {
 System.out.println("Exited.");
 break;
 }
 
 Shape shape = null;
 
 switch (choice) {
 case 1:
 System.out.print("Enter the radius of the 
circle: ");
 double radius = scan.nextDouble();
 shape = new Circle(radius);
 break;
 case 2:
 System.out.print("Enter the length: ");
 double length = scan.nextDouble();
 System.out.print("Enter the breadth: ");
 double width = scan.nextDouble();
 shape = new Rectangle(length, width);
 break;
 case 3:
 System.out.print("Enter the side length: ");
 double side = scan.nextDouble();
 shape = new Square(side);
 break;
 case 4:
 System.out.print("Enter the radius: ");
 double sphereRadius = scan.nextDouble();
 shape = new Sphere(sphereRadius);
 break;
 case 5:
 System.out.print("Enter the radius: ");
1
 double cylinderRadius = scan.nextDouble();
 System.out.print("Enter the height: ");
 double cylinderHeight = scan.nextDouble();
 shape = new Cylinder(cylinderRadius, 
cylinderHeight);
 break;
 case 6:
 System.out.print("Enter base length: ");
 double baseLength = scan.nextDouble();
 System.out.println("Enter base width: ");
 double baseWidth = scan.nextDouble();
 System.out.print("Enter the height: ");
 double pyramidHeight = scan.nextDouble();
 shape = new Pyramid(baseLength, baseWidth, 
pyramidHeight);
 break;
 default:
 System.out.println("Invalid choice. Choose 
again.");
 continue;
 }
 if (shape != null) {
 shape.showShape(shape.getClass().getSimpleName());
 System.out.println("Area: " + 
shape.calculateShape());
 if (shape instanceof Volume) {
 System.out.println("Volume: " + ((Volume) 
shape).calculateVolume());
 } else {
 System.out.println("Volume not applicable for 
this shape.");
 }
 }
}
}
}



public interface Volume {
double calculateVolume();
}


public abstract class Shape {
public void showShape(String shape) {
System.out.println("Shape selected: " + shape);
}
public abstract double calculateShape();
}


public class Circle extends Shape implements Volume{
private double radius;
public Circle(double radius) {
this.radius = radius;
}
@Override
public double calculateVolume() {
// TODO Auto-generated method stub
// volume of a circle doesn't exist
return 0;
}
@Override
public double calculateShape() {
// TODO Auto-generated method stub
// Calculating perimeter
return 3.14 * radius * radius;
}
} 



import java.math.*;
public class Pyramid extends Shape implements Volume {
private double bL; //base Length
private double bW; //base Width
private double height; 
public Pyramid(double bL, double bW, double height) {
this.bL = bL;
this.bW = bW;
this.height = height;
}
@Override
public double calculateVolume() {
// TODO Auto-generated method stub
return (1.0 * bL * bW * height)/3.0;
}
@Override
public double calculateShape() {
// TODO Auto-generated method stub
return (bL * bW) + (bL * Math.sqrt(Math.pow(bW/2, 2) 
+ Math.pow(height, 2)))
+ (bW * Math.sqrt(Math.pow(bL/2, 2) + 
Math.pow(height, 2)));
}
} 



public class Rectangle extends Shape implements Volume {
private double length;
private double breadth;
public Rectangle(double length, double breadth) {
this.length = length;
this.breadth = breadth;
}
@Override
public double calculateVolume() {
// TODO Auto-generated method stub
// volume not possible
return 0;
}
@Override
public double calculateShape() {
// TODO Auto-generated method stub
return length * breadth;
}
} 

public class Sphere extends Shape implements Volume {
private double radius;
public Sphere(double radius) {
this.radius = radius;
}
@Override
public double calculateVolume() {
// TODO Auto-generated method stub
return (4.0 * 3.14 * (radius * radius * radius));
}
@Override
public double calculateShape() {
// TODO Auto-generated method stub
return 4 * 3.14 * radius * radius;
}
}





public class Square extends Rectangle {
public Square(double side) {
super(side, side);
}
} 