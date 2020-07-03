public class MyLinkedList<E>{
  private class Node{
    private E data;
    private Node prev,next;
    public Node(E val){
      data = val;
    }
    public Node(E val, Node preceding, Node following){
      data = val;
      prev = preceding;
      next= following;
    }
    public Node(Node other){
      data = other.getData();
    }
    public E getData(){
      return data;
    }
    public Node prev(){
      return prev;
    }
    public Node next(){
      return next;
    }
    public E setData(E val){
      E temp = data;
      data=val;
      return temp;
    }
    public void setPrev(Node preceding){
      prev=preceding;
    }
    public void setNext(Node following){
      next=following;
    }
    public String toString(){
      return ""+data;
    }
  }
  private int size;
  private Node start,end;
  public MyLinkedList(){
    size=0;
  }
  public void clear(){
    size=0;
    start=null;
    end=null;
  }
  public int size(){
   return size;
  }
  public boolean addEnd(E value){
    Node node = new Node(value);
    if(size==0){
      start=node;
      end=node;
      size++;
      return true;
    }
    end.setNext(node);
    node.setPrev(end);
    end=node;
    size++;
    return true;
  }
  public boolean addFront(E value){
    Node node = new Node(value);
    if(size==0){
      start=node;
      end=node;
      size++;
      return true;
    }
    start.setPrev(node);
    node.setNext(start);
    start=node;
    size++;
    return true;
  }
  public E removeFront(){
    E temp = start.getData();
    if(start.next()!=null){
      start=start.next();
    }
    size--;
    return temp;
  }
  public void extend(MyLinkedList<E> other){
    if(size==0){
      start=other.start;
    }
    else if(other.size()!=0){
      end.setNext(other.start);
      other.start.setPrev(end);
    }
    if(other.size()!=0){
    end = other.end;
    size = size+other.size();
    other.clear();
    }
  }
  public String toString(){
    if(size==0){
      return "[]";
    }
    String list = "[";
    Node cur = start;
    while(cur.next()!=null){
      list+=cur.getData()+", ";
      cur = cur.next();
    }
    list+=cur.getData();
    return list+"]";
  }
}
