public class Calculator{
  public static double eval(String s){
    MyDeque<Double> stack = new MyDeque<Double>();
    String holder = "";
    for(int i = 0; i < s.length(); i++){
      if(Character.isDigit(s.charAt(i)) || s.charAt(i)=='.' ||
        (s.charAt(i)=='-' && i+1<s.length() && Character.isDigit(s.charAt(i+1)))){
        holder+=s.charAt(i);
      } else if(s.charAt(i)!=' '){
        double a = stack.removeFirst();
        double b = stack.removeFirst();
        if(s.charAt(i)=='+'){
          stack.addFirst(a+b);
        } else if(s.charAt(i)=='-'){
          stack.addFirst(b-a);
        } else if(s.charAt(i)=='*'){
          stack.addFirst(a*b);
        } else if(s.charAt(i)=='/'){
          stack.addFirst(b/a);
        } else if(s.charAt(i)=='%'){
          stack.addFirst(b%a);
        }
        i++;
      } else{
        stack.addFirst(Double.parseDouble(holder));
        holder="";
      }
    }
    return stack.removeFirst();
  }
  public static void main(String[] args){
    System.out.println(eval("10 2.0 +"));
    System.out.println(eval("11 3 - 4 + 2.5 *"));
    System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    System.out.println(eval("1 2 3 4 5 + * - -"));
  }
}
