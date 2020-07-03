import java.util.*;
import java.io.*;
public class USACO{
  public static int bronze(String filename) throws FileNotFoundException{
    Scanner s = new Scanner(new File(filename));
    int rows = 0,cols = 0;
    int elevation = 0;
    int numInst = 0;
    int counter = 0;
    int[][] pasture = new int[0][0];
    int[][] instructions = new int[0][0];
    while(s.hasNext()){
      if(counter==0){
        rows = Integer.parseInt(s.next());
      } else if(counter==1){
        cols = Integer.parseInt(s.next());
      } else if(counter==2){
        elevation = Integer.parseInt(s.next());
      } else if(counter==3){
        numInst = Integer.parseInt(s.next());
      } else if(counter==4){
        pasture = new int[rows][cols];
        pasture[0][0] = Integer.parseInt(s.next());
      } else if(counter>4 && counter<=rows*cols+3){
        pasture[(counter-4)/cols][(counter-4)%cols] = Integer.parseInt(s.next());
      } else if(counter==rows*cols+4){
        instructions = new int[numInst][3];
        instructions[0][0] = Integer.parseInt(s.next());
      } else if(counter>rows*cols+4){
        instructions[(counter-rows*cols-4)/3][(counter-4-rows*cols)%3] = Integer.parseInt(s.next());
      }
      counter++;
    }
    for(int[] instruction : instructions){
      for(int i = 0; i<instruction[2]; i++){
        ArrayList<ArrayList<Integer>> heights = new ArrayList<ArrayList<Integer>>();
        for(int a = instruction[0]-1; a<instruction[0]+2; a++){
          for(int b = instruction[1]-1; b<instruction[1]+2; b++){
            ArrayList<Integer> height = new ArrayList<Integer>();
            height.add(Integer.valueOf(pasture[a][b]));
            height.add(Integer.valueOf(a));
            height.add(Integer.valueOf(b));
            heights.add(height);
          }
        }
        int max = 0;
        for(int j = 0; j<heights.size(); j++){
          if(heights.get(j).get(0)>max){
            max = heights.get(j).get(0);
          }
        }
        for(int j = 0; j<heights.size(); j++){
          if(heights.get(j).get(0)==max){
            pasture[heights.get(j).get(1)][heights.get(j).get(2)]-=1;
          }
        }
      }
    }
    int totalDepth = 0;
    for(int a=0;a<rows;a++){
      for(int b=0;b<cols;b++){
        totalDepth += elevation-pasture[a][b]>0? elevation-pasture[a][b]:0;
      }
    }
    return totalDepth*72*72;
  }
  public static int silver(String filename) throws FileNotFoundException{
    Scanner s = new Scanner(new File(filename));
    int rows = 0, cols = 0, time = 0;
    int[][] pasture = new int[0][0];
    int startX = 0, startY = 0, endX = 0, endY = 0;
    int counter = 0;
    while(s.hasNext()){
      if(counter==0){
        rows = Integer.parseInt(s.next());
      } else if(counter==1){
        cols = Integer.parseInt(s.next());
      } else if(counter==2){
        time = Integer.parseInt(s.next());
      } else if(counter==3){
        pasture = new int[rows][cols];
        String temp = s.next();
        for(int i = 0; i<temp.length(); i++){
          pasture[0][i] = temp.charAt(i)=='*'? -1:0;
        }
      } else if(counter>3 && counter<rows+3){
        String temp = s.next();
        for(int i = 0; i<temp.length(); i++){
          pasture[counter-3][i] = temp.charAt(i)=='*'? -1:0;
        }
      } else if(counter==rows+3){
        startX = Integer.parseInt(s.next());
      } else if(counter==rows+4){
        startY = Integer.parseInt(s.next());
      } else if(counter==rows+5){
        endX = Integer.parseInt(s.next());
      } else if(counter==rows+6){
        endY = Integer.parseInt(s.next());
      }
      counter++;
    }
    pasture[startX-1][startY-1] = 1;
    for(int i = 0; i<time; i++){
      int[][] copy = new int[rows][cols];
      for(int j = 0; j<rows; j++){
        copy[j] = pasture[j].clone();
      }
      for(int a = 0; a<rows; a++){
        for(int b = 0; b<cols; b++){
          if(copy[a][b]==-1)continue;
          if(copy[a][b]>0){
            pasture[a][b]=0;
          } else {
            int count = 0;
            if(a-1>=0 && copy[a-1][b]>0)count+=copy[a-1][b];
            if(a+1<rows && copy[a+1][b]>0)count+=copy[a+1][b];
            if(b-1>=0 && copy[a][b-1]>0)count+=copy[a][b-1];
            if(b+1<cols && copy[a][b+1]>0)count+=copy[a][b+1];
            pasture[a][b] = count;
          }
        }
      }
    }
    return pasture[endX-1][endY-1]==-1? 0:pasture[endX-1][endY-1];
  }
  public static void main(String[] args){
    try{
      System.out.println("Bronze:");
      for(int i = 1; i < 6; i++){
        File correct = new File("makelake."+i+".out");
        Scanner yes = new Scanner(correct);
        int yourAnswer = USACO.bronze("makelake."+i+".in");
        int correctAnswer = yes.nextInt();
        System.out.println(i+" Yours: "+yourAnswer+" Key: "+correctAnswer+" "+(yourAnswer==correctAnswer));
        yes.close();
      }
      System.out.println("Silver:");
      for (int i = 1; i < 6; i++) {
        File checkPlus = new File("ctravel."+i+".out");
        Scanner A = new Scanner(checkPlus);
        int yourAnswer = USACO.silver("ctravel."+i+".in");
        int correctAnswer = A.nextInt();
        System.out.println(i+" Yours: "+yourAnswer+" Key: "+correctAnswer+" "+(yourAnswer==correctAnswer));
        A.close();
      }
    } catch(FileNotFoundException e){
      System.out.println(e);
    }
  }
}
