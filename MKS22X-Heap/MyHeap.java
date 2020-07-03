public class MyHeap{
  private static void swap(int[] data, int a, int b){
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }
  public static void pushDown(int[] data, int size, int index){
    while((2*index+1)<size){
      if((2*index+2)<size && data[index]<data[2*index+2] && data[2*index+2]>data[2*index+1]){
        swap(data,index,2*index+2);
        index = 2*index+2;
      } else if(data[index]<data[2*index+1]){
        swap(data,index,2*index+1);
        index = 2*index+1;
      } else{
        break;
      }
    }
  }
  public static void pushUp(int[] data, int index){
    while((index-1)/2>=0 && data[index]>data[(index-1)/2]){
      swap(data,index,(index-1)/2);
      index = (index-1)/2;
    }
  }
  public static void heapify(int[] data){
    for(int i=data.length-1;i>=0;i--){
      pushDown(data,data.length,i);
    }
  }
  public static void heapsort(int[] data){
    heapify(data);
    int boundary = data.length-1;
    for(int i=0;i<data.length-1;i++){
      swap(data,0,boundary);
      pushDown(data,boundary,0);
      boundary--;
    }
  }
  public static void main(String[] args){
  }
}
