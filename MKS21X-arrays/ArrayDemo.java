public class ArrayDemo{
  public static int[][] test = new int[3][3];
  public static int[][] emptyTest = new int[0][0];
  //0a
  public static void printArray(int[] ary){
    System.out.print("{");
    for(int x=0;x<ary.length;x++){
      System.out.print(ary[x]+(x==ary.length-1? "":", "));
    }
    System.out.print("}\n");
  }
  //0b
  public static void printArray(int[][] ary){
    System.out.print("{");
    for(int x=0;x<ary.length;x++){
      System.out.print("{");
      for(int y=0;y<ary[x].length;y++){
        System.out.print(ary[x][y]+(y==ary[x].length-1? "":", "));
      }
      System.out.print("}"+(x==ary.length-1? "":"\n"));
    }
    System.out.print("}\n");
  }
  //1
  public static int countZeros2D(int[][] nums){
    int zeros = 0;
    for(int r=0;r<nums.length;r++){
	for(int c=0;c<nums[r].length;c++){
	    if(nums[r][c]==0){
                zeros++;
	    }
        }
    }
    return zeros;
  }
  //2a
  public static void fill2D(int[][] vals){
    for(int r=0;r<vals.length;r++){
	for(int c=0;c<vals[r].length;c++){
	    if(r==c){
		vals[r][c]=3;
		continue;
	    }
	    vals[r][c]=1;
	}
    }
  }
  //2b
  public static int[][] fill2DCopy(int[][] vals){
    int[][] result = new int[vals.length][];
    for(int r=0;r<vals.length;r++){
	result[r]=vals[r];
	for(int c=0;c<vals[r].length;c++){
	    if(vals[r][c]<0){
		result[r][c]=3;
		continue;
	    }
	    vals[r][c]=1;
	}
    }
    return result;
  }
  //main
  public static void main(String[] args){
    printArray(new int[]{1,2,3,4,5,6,7,8,9,0});
    printArray(new int[0]);
    printArray(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    printArray(new int[0][0]);
    System.out.println(countZeros2D(new int[][]{{0,1,2},{3,0,0},{9,6,0},{7,5,0}}));
    System.out.println(countZeros2D(new int[0][0]));
    fill2D(test);
    printArray(test);
    fill2D(emptyTest);
    printArray(emptyTest);
    printArray(fill2DCopy(new int[][]{{0,-3,-5},{7,12,-29},{18,-6,0}}));
    printArray(fill2DCopy(new int[0][0]));
  }
}
