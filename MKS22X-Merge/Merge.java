import java.util.*;
public class Merge{
  public static void mergesort(int[] data){
    int[] temp = data.clone();
    mergeHelper(data,temp,0,data.length-1);
  }
  private static void mergeHelper(int[] data, int[] temp, int lo, int hi){
    if((hi-lo)<=100){
      insertion(data,lo,hi);
      return;
    }
    mergeHelper(temp,data,lo,(lo+hi+1)/2-1);
    mergeHelper(temp,data,(lo+hi+1)/2,hi);
    int split = (lo+hi+1)/2;
    int start = lo;
    for(int i = lo; i<hi+1; i++){
      if(lo>=(start+hi+1)/2 || split<hi+1 && temp[lo]>temp[split]){
        data[i] = temp[split];
        split++;
      } else {
        data[i] = temp[lo];
        lo++;
      }
    }
  }
  private static void insertion(int[] data, int lo, int hi){
    for(int i = lo+1; i<hi+1; i++){
      int temp = data[i];
      int j = i;
      while(j>lo && data[j-1]>temp){
        data[j]=data[j-1];
        data[j-1]=temp;
        j--;
      }
    }
  }
  public static void main(String[] args){
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          mergesort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            for(int val : data2){
              System.out.print(val+" ");
            }
            System.out.println();
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
  }
}
