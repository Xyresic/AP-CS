public class Point{
  private double abscissa,ordinate;
  public Point(){
    abscissa=0.0;
    ordinate=0.0;
  }
  public Point(double x, double y){
    abscissa=x;
    ordinate=y;
  }
  public Point(Point p){
    abscissa = p.abscissa;
    ordinate = p.ordinate;
  }
  public double getX(){
    return abscissa;
  }
  public double getY(){
    return ordinate;
  }
  public double distanceTo(){
    return Math.sqrt(Math.pow(abscissa,2.0)+Math.pow(ordinate,2.0));
  }
  public double distanceTo(Point a){
    return Math.sqrt(Math.pow(abscissa-a.abscissa,2.0)+Math.pow(ordinate-a.ordinate,2.0));
  }
  public static double distance(Point a){
    return Math.sqrt(Math.pow(a.abscissa,2.0)+Math.pow(a.ordinate,2.0));
  }
  public static double distance(Point a, Point b){
    return Math.sqrt(Math.pow(a.abscissa-b.abscissa,2.0)+Math.pow(a.ordinate-b.ordinate,2.0));
  }
  public String toString(){
    return "("+abscissa+","+ordinate+")";
  }
}
