/*public class Driver{
  public static void main(String[] args){
    Point P1 = new Point();
    Point P2 = new Point(3.0,4.0);
    Point P3 = new Point(P2);
    System.out.println(P1);
    System.out.println(P2);
    System.out.println(P3);
    System.out.println(P1.getX());
    System.out.println(P1.getY());
    System.out.println(P2.getX());
    System.out.println(P3.getY());
    System.out.println(P2.distanceTo());
    System.out.println(P3.distanceTo(P2));
    System.out.println(Point.distance(new Point(8.0,15.0)));
    System.out.println(Point.distance(P1,P2));
    P3 = new Point(3.0,-4.0);
    Triangle triangle1 = new Triangle(1.0,1.0,-1.0,-1.0,1.0,-1.0);
    Triangle triangle2 = new Triangle(P2,P3);
    System.out.println(triangle1);
    System.out.println(triangle2);
    System.out.println(triangle1.getVertex(0));
    System.out.println(triangle1.getVertex(1));
    System.out.println(triangle1.getVertex(2));
    System.out.println(triangle1.getPerimeter());
    System.out.println(triangle2.getPerimeter());
    triangle1.setVertex(0,P1);
    triangle2.setVertex(1,7.0,24.0);
    System.out.println(triangle1.getPerimeter());
    System.out.println(triangle2.getPerimeter());
  }
}*/
public class Driver{

  public static double distance(Point a, Point b){
    return Math.sqrt(Math.pow(a.getX()-b.getX(),2)+Math.pow(a.getY()-b.getY(),2));
  }

  public static void main(String[]args){
    Point p1 = new Point(1,1);
    Point p2 = new Point(2,2);
    System.out.println("Testing the distance 3 ways, should all be sqrt(2)");
    System.out.println(  distance(p1,p2)); //static in the Driver class
    System.out.println(  Point.distance(p1,p2)); //static in the Point class
    System.out.println(  p1.distanceTo(p2)); //non-static in the Point class.

    System.out.println("\nTesting 2 identical traingles, perimeter is 2+sqrt(2)");
    Triangle t1 = new Triangle(0,0,0,1,1,0);
    Triangle t2 = new Triangle(new Point(0,0),new Point(0,1),new Point(1,0));
    System.out.println( t1 );
    System.out.println( t1.getPerimeter() );
    System.out.println( t2 );
    System.out.println( t2.getPerimeter() );

    System.out.println("\nTesting a 3/4/5 triangle");
    t1 = new Triangle(-1,-1, 2,3, 2,-1);
    System.out.println( t1 );
    System.out.println( t1.getPerimeter() );

    System.out.println("\nTesting getVertex in the 3/4/5 triangle");
    System.out.println( t1.getVertex(0) );
    System.out.println( t1.getVertex(1) );
    System.out.println( t1.getVertex(2) );

    System.out.println("\nTesting setPoint in the 3/4/5 triangle");
    t1.setVertex(0,new Point(9,9));
    t1.setVertex(1,new Point(-9,9));
    t1.setVertex(2,new Point(9,-9));
    System.out.println( t1 );
  }
 }
