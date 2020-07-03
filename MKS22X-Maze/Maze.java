import java.io.*;
import java.util.*;
public class Maze{
  private char[][] maze;
  private boolean animate;
  private static int[][] moveOrder = new int[4][2];
  public Maze(String file) throws FileNotFoundException{
    Scanner inf = new Scanner(new File(file));
    int rows=0;
    int cols=0;
    String mazeCopy = "";
    while(inf.hasNextLine()){
      rows+=1;
      mazeCopy += inf.nextLine() + "\n";
      if(cols==0){
        cols = mazeCopy.length()-1;
      }
    }
    int sCount=0;
    int eCount=0;
    maze = new char[rows][cols];
    for(int i=0; i<mazeCopy.length(); i++){
      if(mazeCopy.charAt(i)=='S'){
        sCount++;
      }
      if(mazeCopy.charAt(i)=='E'){
        eCount++;
      }
      mazeCopy = mazeCopy.replaceAll("\n","");
      maze[i/cols][i%cols] = mazeCopy.charAt(i);
    }
    if(!(sCount==1&&eCount==1)){
      throw new IllegalStateException();
    }
    moveOrder[0] = new int[]{-1,0};
    moveOrder[1] = new int[]{1,0};
    moveOrder[2] = new int[]{0,-1};
    moveOrder[3] = new int[]{0,1};
  }
  public int solve(){
    for(int i = 1; i<maze.length; i++){
      for(int j = 1; j<maze[0].length; j++){
        if(maze[i][j]=='S'){
          maze[i][j]='@';
          return solve(i,j,1);
        }
      }
    }
    throw new IllegalStateException();
  }
  private int solve(int row, int col, int count){
    for(int[] move : moveOrder){
      if(maze[row+move[0]][col+move[1]]=='E'){
        return count;
      }
      if(maze[row+move[0]][col+move[1]]==' '){
        maze[row+move[0]][col+move[1]]='@';
        int temp = solve(row+move[0],col+move[1],count+1);
        if(temp!=-1){
          return temp;
        }
      }
      if(move[0]==0 && move[1]==1){
        maze[row][col]='.';
        return -1;
      }
    }
    return -1;
  }
  public String toString(){
    String array = "";
    for(int i = 0; i<maze.length; i++){
      for(int j = 0; j<maze[0].length; j++){
          array+=maze[i][j];
      }
      array+="\n";
    }
    return array;
  }
  public static void main(String args[]){
    for(int i = 1; i<5; i++){
      try{
        Maze test = new Maze("Maze"+i+".txt");
        System.out.println(test);
        System.out.println(test.solve());
        System.out.println(test);
      } catch(FileNotFoundException error){
        System.out.println("File Maze"+i+".txt not found.");
      }
    }
  }
}
