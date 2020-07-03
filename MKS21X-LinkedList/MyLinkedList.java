public class MyLinkedList{
  private class Node{
    private Integer data;
    private Node prev,next;
    public Node(){
      data = 0;
    }
    public Node(Integer val){
      data = val;
    }
    public Node(Integer val, Node preceding, Node following){
      data = val;
      prev = preceding;
      next= following;
    }
    public Node(Node other){
      data = other.getData();
    }
    public Integer getData(){
      return data;
    }
    public Node prev(){
      return prev;
    }
    public Node next(){
      return next;
    }
    public Integer setData(Integer val){
      Integer temp = data;
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
  public int size(){
    return size;
  }
  public Integer get(Integer index){
    if(index<0 || index>=size){
      throw new IndexOutOfBoundsException();
    }
    if(index<0 || index>=size){
      throw new IndexOutOfBoundsException();
    }
    if(index==size-1){
      return end.getData();
    }
    if(index==0){
      return start.getData();
    }
    int curInd = 0;
    Node cur = start;
    while(curInd<index){
      cur=cur.next();
      curInd++;
    }
    return cur.getData();
  }
  public Integer set(int index, Integer value){
    if(index<0 || index>=size){
      throw new IndexOutOfBoundsException();
    }
    if(index == 0){
      Node temp = start;
      start = new Node(value);
      start.setNext(temp.next());
      start.next().setPrev(start);
      return temp.getData();
    }
    if(index == size-1){
      Node temp = end;
      end = new Node(value);
      end.setPrev(temp.prev());
      end.prev().setNext(end);
      return temp.getData();
    }
    int ind = 0;
    Node cur = start;
    while(ind<index-1){
      cur=cur.next();
      ind++;
    }
    Node temp = cur.next();
    cur.setNext(new Node(value,cur,cur.next().next()));
    cur.next().next().setPrev(cur.next());
    return temp.getData();
  }
  public boolean add(Integer value){
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
  public void add(int index, Integer value){
    if(index<0 || index>size){
      throw new IndexOutOfBoundsException();
    }
    Node created = new Node(value);
    if(index==size){
      add(value);
    }
    else if(index==0){
      start.setPrev(created);
      created.setNext(start);
      start=created;
      size++;
    }
    else{
      int temp = 0;
      Node cur = start;
      while(temp<index){
        cur = cur.next();
        temp++;
      }
      created.setNext(cur);
      created.setPrev(cur.prev());
      cur.prev().setNext(created);
      cur.setPrev(created);
      size++;
    }
  }
  public Integer remove(int index){
    if(index<0 || index>=size){
      throw new IndexOutOfBoundsException();
    }
    if(index==0){
      int temp = start.getData();
      start = start.next();
      start.setPrev(null);
      size--;
      return temp;
    }
    if(index==size-1){
      int temp = end.getData();
      end = end.prev();
      end.setNext(null);
      size--;
      return temp;
    }
    else{
      int temp = 0;
      Node cur = start;
      while(temp<index-1){
        cur = cur.next();;
        temp++;
      }
      int val = cur.next().getData();
      cur.setNext(cur.next().next());
      cur.next().setPrev(cur);
      size--;
      return val;
    }
  }
  public boolean remove(Integer val){
    Node cur = start;
    if(cur.getData().equals(val)){
      start = start.next();
      start.setPrev(null);
      size--;
      return true;
    }
    while(cur.next()!=null){
      if(cur.getData().equals(val)){
        cur.prev().setNext(cur.next());
        cur.next().setPrev(cur.prev());
        size--;
        return true;
      }
      cur = cur.next();
    }
    if(cur.getData().equals(val)){
      end=cur.prev();
      end.setNext(null);
      size--;
      return true;
    }
    return false;
  }
  public void extend(MyLinkedList other){
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
    other.start=null;
    other.end=null;
    other.size=0;
    }
  }
  public boolean contains(Integer val){
    Node cur = start;
    while(cur.next()!=null){
      if(cur.getData().equals(val)){
        return true;
      }
      cur = cur.next();;
    }
    if(cur.getData().equals(val)){
      return true;
    }
    return false;
  }
  public int indexOf(Integer val){
    Node cur = start;
    int index = 0;
    while(cur.next()!=null){
      if(cur.getData().equals(val)){
        return index;
      }
      cur = cur.next();;
      index++;
    }
    if(cur.getData().equals(val)){
      return index;
    }
    return -1;
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
    /*String list = "]";
    Node cur = end;
    while(cur.prev()!=null){
      list = ", "+cur.getData()+list;
      cur = cur.prev();
    }
    list = cur.getData()+list;
    return "["+list;*/
  }
}
