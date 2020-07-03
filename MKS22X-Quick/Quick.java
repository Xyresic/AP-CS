import java.util.*;
public class Quick{
  private static int[] partition(int[] data, int start, int end){
    int[] range = new int[2];
    int pivot = Math.max(Math.min(data[start],data[(start+end)/2]),Math.min(Math.max(data[start],data[(start+end)/2]),data[end]));
    int pivotInd=0;
    if(pivot==data[start]){
      pivotInd=start;
    }
    if(pivot==data[(start+end)/2]){
      pivotInd=(start+end)/2;
    }
    if(pivot==data[end]){
      pivotInd=end;
    }
    if(pivotInd!=0){
      data[pivotInd] = data[start];
      data[start] = pivot;
    }
    int hole = end;
    int equalBound = start+1;
    for(int i = start+1; i < end+1; i++){
      while(data[i]!=pivot && hole>i){
        int temp = data[i];
        if(data[i]>pivot){
          data[i] = data[hole];
          data[hole] = temp;
          hole--;
        } else{
          data[i]=pivot;
          data[equalBound] = temp;
          equalBound++;
          break;
        }
      }
      if(hole==i){
        range[0]=equalBound;
        if(data[i]>=pivot){
          data[start] = data[i-1];
          data[i-1] = pivot;
          range[1] = i-1;
          return range;
        } else {
          data[start] = data[i];
          data[i] = pivot;
          range[1] = i;
          return range;
        }
      }
    }
    range[0] = pivotInd;
    range[1] = pivotInd;
    return range;
  }
  public static int quickselect(int[] data, int k){
    int[] temp=new int[2];
    int start=0;
    int end=data.length-1;
    do{
      temp = partition(data,start,end);
      if(k<temp[0]){
        end = temp[0]-1;
      } else if(k>temp[1]){
        start = temp[1]+1;
      }
    } while(k<temp[0]||k>temp[1]);
    return data[k];
  }
  public static void quicksort(int[] data){
    quickHelper(data,0,data.length-1);
  }
  private static void quickHelper(int[] data, int lo, int hi){
    if((hi-lo)<=10){
      insertion(data,lo,hi);
      return;
    }
    int[] k = partition(data,lo,hi);
    quickHelper(data,lo,k[0]-1);
    quickHelper(data,k[1]+1,hi);
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
        Quick.quicksort(data2);
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
