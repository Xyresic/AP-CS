public class ArrayMethods{
  public static int rowSum(int[][] ary, int row){
    if(row > ary.length){
      return 0;
    }
    int sum = 0;
    for(int x = 0; x < ary[row].length; x++){
      sum+=ary[row][x];
    }
    return sum;
  }
  public static int columnSum(int[][] ary, int column){
    int sum = 0;
    for(int x = 0; x < ary.length; x++){
      try{
        int temp;
        temp = ary[x][column];
      }
      catch(Exception e){
        continue;
      }
      sum+=ary[x][column];
    }
    return sum;
  }
  public static int[] allRowSums(int[][] ary){
    int[] rowSums = new int[ary.length];
    for(int x=0; x < ary.length; x++){
      rowSums[x]=rowSum(ary, x);
    }
    return rowSums;
  }
  public static int[] allColSums(int[][] ary){
    int maxLen = 0;
    for(int x = 0; x < ary.length; x++){
      if(ary[x].length > maxLen){
        maxLen = ary[x].length;
      }
    }
    int[] colSums = new int[maxLen];
    for(int x = 0; x < maxLen; x++){
      colSums[x] = columnSum(ary, x);
    }
    return colSums;
  }
  public static boolean isRowMagic(int[][] ary){
    boolean result = true;
    int[] sums = allRowSums(ary);
    for(int x = 1; x < sums.length; x++){
      if(sums[x]!=sums[x-1]){
        result = false;
        break;
      }
    }
    return result;
  }
  public static boolean isColumnMagic(int[][] ary){
    boolean result = true;
    int[] sums = allColSums(ary);
    for(int x = 1; x < sums.length; x++){
      if(sums[x]!=sums[x-1]){
        result = false;
        break;
      }
    }
    return result;
  }
}
