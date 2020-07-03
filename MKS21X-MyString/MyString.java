public class MyString implements CharSequence,Comparable<CharSequence>{
  private char[] data;
  public MyString(CharSequence s){
    data = new char[s.length()];
    for(int x = 0; x < s.length(); x++){
      data[x]=s.charAt(x);
    }
  }
  public char charAt(int index){
    if(index<0 || index >= data.length){
      throw new IndexOutOfBoundsException();
    }
    return data[index];
  }
  public int length(){
    return data.length;
  }
  public CharSequence subSequence(int start, int end){
    if(end<start || start<0 || end<0 || start>=data.length || end>data.length){
      throw new IndexOutOfBoundsException();
    }
    String s = "";
    for(int x  = start; x<end; x++){
      s+=data[x];
    }
    return s;
  }
  public int compareTo(CharSequence s){
    CharSequence shorter = s;
    if(this.length()<s.length()){
      shorter = this;
    }
    for(int x = 0; x<shorter.length();x++){
      if(this.charAt(x)!=s.charAt(x)){
        return this.charAt(x)-s.charAt(x);
      }
    }
    return this.length()-s.length();
  }
  public String toString(){
    return (String)subSequence(0,data.length);
  }
  public static void main(String[] args){
    MyString ref = new MyString("test");
    System.out.println(ref);
    System.out.println(ref.length());
    for(int x = 0; x<ref.length(); x++){
      System.out.println(ref.charAt(x));
    }
    for(int x = 0; x<ref.length(); x++){
      System.out.println(ref.subSequence(0,x+1));
    }
    System.out.println(ref.compareTo("a")+"=="+"test".compareTo("a"));
    System.out.println(ref.compareTo("z")+"=="+"test".compareTo("z"));
    System.out.println(ref.compareTo("tes")+"=="+"test".compareTo("tes"));
    System.out.println(ref.compareTo("test")+"=="+"test".compareTo("test"));
    System.out.println(ref.compareTo("aests")+"=="+"test".compareTo("aests"));
    System.out.println(ref.compareTo("zests")+"=="+"test".compareTo("zests"));
    System.out.println(ref.compareTo("tests")+"=="+"test".compareTo("tests"));
    System.out.println(ref.compareTo("")+"=="+"test".compareTo(""));
    try{
      System.out.println(ref.charAt(100));
    }
    catch(IndexOutOfBoundsException e){
      System.out.println("Succesfully threw charAt IndexOutOfBoundsException");
    }
    ref = new MyString("ab");
    try{
      for(int x = -1; x<4; x++){
        for(int y = -1; y<4; y++){
          System.out.println(ref.subSequence(x,y));
        }
      }
    }
    catch(IndexOutOfBoundsException e){
      System.out.println("Succesfully threw subSequence IndexOutOfBoundsException");
    }
  }
}
