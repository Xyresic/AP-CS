import java.util.ArrayList;
public class NoNullArrayList<t> extends ArrayList<t>{
  public NoNullArrayList(){
  }
  public NoNullArrayList(int initSize){
    super(initSize);
  }
  public t set(int index, t value){
    if(value==null){
      throw new IllegalArgumentException();
    }
    super.set(index, value);
    return super.get(index);
  }
  public boolean add(t value){
    if(value==null){
      throw new IllegalArgumentException();
    }
    super.add(value);
    return true;
  }
  public void add(int index, t value){
    if(value==null){
      throw new IllegalArgumentException();
    }
    super.add(index, value);
  }
}
