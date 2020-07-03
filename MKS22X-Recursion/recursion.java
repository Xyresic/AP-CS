import java.util.*;
public class recursion{
  public static double sqrt(double n, double tolerance){
    return sqrtH(n,tolerance,n/2);
  }
  private static double sqrtH(double n, double tolerance, double guess){
    if(Math.abs((guess*guess-n)/n)<=tolerance || n==0){
      return guess;
    }
    return sqrtH(n,tolerance,(n/guess+guess)/2);
  }
  public static int fib(int n){
    return fibH(n,0,1);
  }
  private static int fibH(int n, int current, int next){
    if(n==0){
      return current;
    }
    return fibH(n-1,next,current+next);
  }
  public static ArrayList<Integer> makeAllSums(int n){
    ArrayList<Integer> array = new ArrayList<Integer>();
    makeAllSumsH(n,0,array);
    return array;
  }
  private static void makeAllSumsH(int n, int partialSum, ArrayList<Integer> array){
    if(n==0){
      array.add(Integer.valueOf(partialSum));
    } else{
      makeAllSumsH(n-1,partialSum+n,array);
      makeAllSumsH(n-1,partialSum,array);
    }
  }
  public static void main(String[] args){
    //System.out.println(sqrt(0.0,0.00001));
    //System.out.println(sqrt(1.0,0.00001));
    //System.out.println(sqrt(2.0,0.00001));
    //System.out.println(sqrt(4.0,0.00001));
    //System.out.println(sqrt(0.5,0.00001));
    //System.out.println(sqrt(9.0,0.00001));
    // System.out.println(fib(0));
    // System.out.println(fib(1));
    // System.out.println(fib(2));
    // System.out.println(fib(3));
    // System.out.println(fib(4));
    // System.out.println(fib(5));
    // System.out.println(fib(20));
    // System.out.println(fib(46));
    // System.out.println(makeAllSums(0));
    // System.out.println(makeAllSums(1));
    // System.out.println(makeAllSums(3));
    // System.out.println(makeAllSums(5));
    // System.out.println(makeAllSums(10));
  }
}
