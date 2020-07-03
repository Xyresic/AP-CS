public class SuperArray{
  private String[] data;
  private int size;
  public SuperArray(){
    data = new String[10];
  }
  public SuperArray(int startSize){
    if(startSize<0){
      throw new IllegalArgumentException();
    }
    data = new String[startSize];
  }
  public void clear(){
    size = 0;
    data = new String[this.data.length];
  }
  public int size(){
    return size;
  }
  public boolean isEmpty(){
    return size==0;
  }
  public boolean add(String str){
    if(size==data.length){
      resize();
      add(str);
    }
    else{
      data[size]=str;
      size++;
    }
    return true;
  }
  public void add(int index, String target){
    if(index<0 || index>size()){
      throw new IndexOutOfBoundsException();
    }
    else{
      resize();
      for(int x = size; x>-1; x--){
        if(x==index){
          data[x]=target;
          break;
        }
        else{
          data[x]=data[x-1];
        }
      }
    }
    size++;
  }
  public String remove(int index){
    if(index<0 || index>=size()){
      throw new IndexOutOfBoundsException();
    }
    String result = data[index];
    for(int x = index; x<size; x++){
      if(index==size-1){
        data[index]=null;
        break;
      }
      data[x]=data[x+1];
    }
    size--;
    return result;
  }
  public boolean remove(String target){
    for(int x = 0; x<size; x++){
      if(data[x].equals(target)){
        remove(x);
        return true;
      }
    }
    return false;
  }
  public String get(int index){
    if(index<0 || index>=size()){
      throw new IndexOutOfBoundsException();
    }
    return data[index];
  }
  public String set(int index, String str){
    if(index<0 || index>=size()){
      throw new IndexOutOfBoundsException();
    }
    String old = data[index];
    data[index]=str;
    return old;
  }
  public void resize(){
    String[] newArray = new String[2*data.length+1];
    for(int x = 0; x<data.length; x++){
      newArray[x]=data[x];
    }
    data = newArray;
  }
  public boolean contains(String target){
    for(int x = 0; x<size; x++){
      if(data[x].equals(target)){
        return true;
      }
    }
    return false;
  }
  public int indexOf(String target){
    for(int x = 0; x<size; x++){
      if(data[x].equals(target)){
        return x;
      }
    }
    return -1;
  }
  public int lastIndexOf(String target){
    for(int x = size-1; x>-1; x--){
      if(data[x].equals(target)){
        return x;
      }
    }
    return -1;
  }
  public String toString(){
    String result = "[";
    for(int x = 0; x<size; x++){
      result+=data[x]+(x==size-1? "":", ");
    }
    return result+="]";
  }
  public String toStringDebug(){
    String result = "[";
    for(int x = 0; x<data.length; x++){
      result+=(data[x]==null? "null":data[x])+(x==data.length-1? "":", ");
    }
    return result+="]";
  }
}
