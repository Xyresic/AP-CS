public class Triangle{
  private Point p1,p2,p3;
  public Triangle(Point v1, Point v2){
    p1 = new Point(0.0,0.0);
    p2 = new Point(v1);
    p3 = new Point(v2);
  }
  public Triangle(Point v1, Point v2, Point v3){
    p1 = new Point(v1);
    p2 = new Point(v2);
    p3 = new Point(v3);
  }
  public Triangle(double v1x, double v1y, double v2x, double v2y, double v3x, double v3y){
    p1 = new Point(v1x,v1y);
    p2 = new Point(v2x,v2y);
    p3 = new Point(v3x,v3y);
  }
  public Triangle(Triangle triangle){
    p1 = triangle.p1;
    p2 = triangle.p2;
    p3 = triangle.p3;
  }
  public Point getVertex(int vnum){
    return vnum==0? p1:vnum==1? p2:p3;
  }
  public double getPerimeter(){
    return p1.distanceTo(p2) + p2.distanceTo(p3) + p3.distanceTo(p1);
  }
  public void setVertex(int vnum, Point newv){
    if(vnum==0){
      p1=newv;
    }
    if(vnum==1){
      p2=newv;
    }
    if(vnum==2){
      p3=newv;
    }
  }
  public void setVertex(int vnum, double newx, double newy){
    if(vnum==0){
      p1 = new Point(newx,newy);
    }
    if(vnum==1){
      p2 = new Point(newx,newy);
    }
    if(vnum==2){
      p3 = new Point(newx,newy);
    }
  }
  public String toString(){
    return "Triangle: A"+p1.toString()+" B"+p2.toString()+" C"+p3.toString();
  }
}
