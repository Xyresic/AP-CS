public class OrderedArrayList<t extends Comparable<t>> extends NoNullArrayList<t>{
  public OrderedArrayList(){
  }
  public OrderedArrayList(int initSize){
    super(initSize);
  }
  public t set(int index, t value){
    if(value==null){
      super.add(value);
    }
    t oldVal = get(index);
    remove(index);
    add(value);
    return oldVal;
  }
  public boolean add(t value){
    if(value==null){
      super.add(null);
    }
    int oldSize = size();
    for(int x = 0; x<size(); x++){
      if(value.compareTo(get(x))<=0){
        super.add(x,value);
        break;
      }
    }
    if(oldSize == size()){
      super.add(value);
    }
    return true;
  }
  public void add(int index, t value){
    add(value);
  }
}
