import java.util.*;
public class Quickselect{
  public static int partition(int[] data, int start, int end){
    Random rng = new Random();
    int pivotInd = Math.abs(rng.nextInt())%data.length;
    int pivot = data[pivotInd];
    data[pivotInd] = data[start];
    data[start] = pivot;
    int hole = end;
    for(int i = start+1; i < end+1; i++){
      while(data[i]>pivot && hole>i){
        int temp = data[i];
        data[i] = data[hole];
        data[hole] = temp;
        hole--;
      }
      if(hole==i){
        if(data[i]>pivot){
          data[start] = data[i-1];
          data[i-1] = pivot;
          return i-1;
        } else {
          data[start] = data[i];
          data[i] = pivot;
          return i;
        }
      }
    }
    return -1;
  }
  public static void main(String[] args){
    int[] test = new int[]{17,61,67,47,93,12,20,4,44,68};
    partition(test,0,9);
  }
}
