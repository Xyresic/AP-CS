import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;
  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 0;
    start = 0;
    end = 0;
  }
  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    size = 0;
    start = 0;
    end = 0;
  }
  public int size(){
    return size;
  }
  public String toString(){
    if(size==0){
      return "{}";
    }
    String string = "{";
    for(int i=start;i<(end<start? data.length:end+1);i++){
      string+=data[i]+" ";
    }
    for(int i=0;i<(end<start? end+1:0);i++){
      string+=data[i]+" ";
    }
    return string+"}";
  }
  public void addFirst(E element){
    if(element==null){
      throw new NullPointerException();
    }
    if(data[start]==null){
      data[start]=element;
    } else if(start-1>=0){
      if(data[start-1]!=null){
        resize();
      }
      data[start-1]=element;
      start--;
    } else {
      if(data[data.length-1]!=null){
        resize();
        data[start-1]=element;
        start--;
      } else{
        data[data.length-1] = element;
        start=data.length-1;
      }
    }
    size++;
  }
  public void addLast(E element){
    if(element==null){
      throw new NullPointerException();
    }
    if(data[end]==null){
      data[end]=element;
    } else if(end+1<data.length){
      if(data[end+1]!=null){
        resize();
      }
      data[end+1]=element;
      end++;
    } else {
      if(data[0]!=null){
        resize();
        data[end+1]=element;
        end++;
      } else{
        data[0] = element;
        end=0;
      }
    }
    size++;
  }
  public E removeFirst(){
    if(size==0){
      throw new NoSuchElementException();
    }
    E temp = data[start];
    data[start]=null;
    if((end<start && start+1<data.length) || start+1<end){
      start++;
    } else{
      for(int i=0;i<end+1;i++){
        if(data[i]!=null){
          start=i;
          break;
        }
      }
    }
    size--;
    return temp;
  }
  public E removeLast(){
    if(size==0){
      throw new NoSuchElementException();
    }
    E temp = data[end];
    data[end]=null;
    if(end-1>start || (end<start && end-1>=0)){
      end--;
    } else{
      for(int i=data.length-1;i>start-1;i--){
        if(data[i]!=null){
          end=i;
          break;
        }
      }
    }
    size--;
    return temp;
  }
  public E getFirst(){
    if(size==0){
      throw new NoSuchElementException();
    }
    return data[start];
  }
  public E getLast(){
    if(size==0){
      throw new NoSuchElementException();
    }
    return data[end];
  }
  @SuppressWarnings("unchecked")
  private void resize(){
    E[] copy = (E[])(new Object[data.length*2+1]);
    int upperBound = end<start? data.length:end+1;
    for(int i = start; i<upperBound; i++){
      copy[(copy.length-size)/2+i-start] = data[i];
    }
    if(end<start){
      for(int i = 0; i<end+1; i++){
        copy[(copy.length-size)/2+size-end-1+i] = data[i];
      }
    }
    start=(copy.length-size)/2;
    end=(copy.length-size)/2+size-1;
    data = copy;
  }
}
