import java.util.Random;
public class Sorts{
  /*public static boolean isSorted(int[] ary){
    for(int x = 0; x<ary.length-1; x++){
      if(ary[x]>ary[x+1]){
        return false;
      }
    }
    return true;
  }*/
  public static void selectionSort(int[] ary){
    //System.out.println(aryToString(ary));
    for(int x = 0; x<ary.length;x++){
      int smallest = ary[x];
      int index = x;
      for(int y = x+1; y<ary.length;y++){
        if(ary[y]<smallest){
          smallest = ary[y];
          index = y;
        }
      }
      ary[index]=ary[x];
      ary[x]=smallest;
      //System.out.println(aryToString(ary));
    }
  }
  public static void bubbleSort(int[] ary){
    boolean madeSwaps = true;
    while(madeSwaps){
      //System.out.println(aryToString(ary));
      madeSwaps = false;
      for(int x = 0; x<ary.length-1; x++){
        if(ary[x]>ary[x+1]){
          int temp = ary[x];
          ary[x] = ary[x+1];
          ary[x+1] = temp;
          madeSwaps = true;
        }
      }
    }
    //System.out.println(aryToString(ary));
  }
  public static void insertionSort(int[] ary){
    for(int x = 1; x<ary.length; x++){
      //System.out.println(aryToString(ary));
      if(ary[x]<ary[x-1]){
        int temp = ary[x];
        for(int y = x; y>0; y--){
          ary[y]=ary[y-1];
          if(y==1||ary[y-2]<temp){
            ary[y-1]=temp;
            break;
          }
        }
      }
    }
    //System.out.println(aryToString(ary));
  }
  public static String aryToString(int[] ary){
    String array = "[";
    for(int x = 0; x<ary.length; x++){
      array+=ary[x]+" ";
    }
    return array.substring(0,array.length()-1)+"]";
  }
  public static void main(String[] args){
    Random rng = new Random();
    int[] array = new int[Integer.parseInt(args[0])];
    for(int x = 0; x<array.length; x++){
      array[x]=rng.nextInt()%100;
    }
    if(args[1].equals("selection"))selectionSort(array);
    if(args[1].equals("bubble"))bubbleSort(array);
    if(args[1].equals("insertion"))insertionSort(array);
  }
}
