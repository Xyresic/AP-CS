import java.util.*;
public class Radix{
  @SuppressWarnings ({"unchecked","rawtypes"})
  public static void radixsort(int[] data){
    MyLinkedList<Integer>[] buckets = new MyLinkedList[10];
    for(int i = 0; i<10; i++){
      buckets[i] = new MyLinkedList<Integer>();
    }
    int maxLength = 0;
    for(int val : data){
      if((Math.abs(val)+"").length()>maxLength){
        maxLength=(Math.abs(val)+"").length();
      }
    }
    for(int val : data){
      if(val>=0){
        buckets[val%10].addEnd(val);
      } else{
        buckets[-val%10].addFront(val);
      }
    }
    MyLinkedList<Integer> merged = new MyLinkedList<Integer>();
    for(MyLinkedList<Integer> bucket : buckets){
      merged.extend(bucket);
    }
    int i = 1;
    while(i<maxLength){
      for(int j = 0; j<10; j++){
        buckets[j].clear();
      }
      while(merged.size()>0){
        int front = merged.removeFront();
        if(front>=0){
          buckets[(front/(int)(Math.pow(10,i)))%10].addEnd(front);
        } else{
          buckets[(-front/(int)(Math.pow(10,i)))%10].addFront(front);
        }
      }
      for(MyLinkedList<Integer> bucket : buckets){
        merged.extend(bucket);
      }
      i++;
    }
    MyLinkedList<Integer> sorted = new MyLinkedList<Integer>();
    while(merged.size()>0){
      int front = merged.removeFront();
      if(front>=0){
        sorted.addEnd(front);
      } else{
        sorted.addFront(front);
      }
    }
    i=0;
    while(sorted.size()>0){
      data[i]=sorted.removeFront();
      i++;
    }
  }
  public static void main(String[]args){
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          radixsort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
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
