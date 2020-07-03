import java.util.*;
public class KnightBoard{
  public class Cell implements Comparable<Cell>{
    public int moveCount;
    public int x;
    public int y;
    public Cell(int initMove, int initX, int initY){
      moveCount = initMove;
      x = initX;
      y = initY;
    }
    public int compareTo(Cell other){
      if(other.x==this.x && other.y==this.y)return 0;
      if(moveBoard[this.x][this.y]==moveBoard[other.x][other.y])return 0;
      if(moveBoard[this.x][this.y]>=moveBoard[other.x][other.y])return 1;
      return -1;
    }
  }
  private int[][] board;
  private int[][] moveBoard;
  private static final int[][] moves = new int[8][2];
  public KnightBoard(int startingRows,int startingCols){
    if(startingRows<=0||startingCols<=0){
      throw new IllegalArgumentException();
    }
    board = new int[startingRows][startingCols];
    moves[0] = new int[]{-2,-1};
    moves[1] = new int[]{-2,1};
    moves[2] = new int[]{-1,-2};
    moves[3] = new int[]{-1,2};
    moves[4] = new int[]{1,-2};
    moves[5] = new int[]{1,2};
    moves[6] = new int[]{2,-1};
    moves[7] = new int[]{2,1};
    moveBoard = new int[startingRows][startingCols];
    if(startingRows>2 && startingCols>2){
      for(int i=0; i<startingRows; i++){
        for(int j=0; j<startingCols; j++){
          int totalDist = Math.min(i,startingRows-1-i)+Math.min(j,startingCols-1-j);
          if(totalDist==0){
            moveBoard[i][j]=2;
          } else if(totalDist==1){
            moveBoard[i][j]=3;
          } else if(totalDist==2){
            moveBoard[i][j]=4;
          } else if(totalDist==3){
            moveBoard[i][j]=6;
          } else {
            moveBoard[i][j]=8;
          }
        }
      }
    }
  }
  public String toString(){
    String output = "";
    for(int[] row : board){
      for(int val : row){
        if(val==0){
          output+="_ ";
        } else {
          output+= (board.length*row.length>=10 && val<10? " ":"") + val+" ";
        }
      }
      output = output.substring(0,output.length()-1)+"\n";
    }
    return output.substring(0,output.length()-1);
  }
  public String printMoves(){
    String output = "";
    for(int[] row : moveBoard){
      for(int val : row){
        output+=val+" ";
      }
      output=output.substring(0,output.length()-1)+"\n";
    }
    return output.substring(0,output.length()-1);
  }
  public boolean solve(int startingRow,int startingCol){
    if(startingRow<0||startingCol<0||startingRow>=board.length||startingCol>=board[0].length){
      throw new IllegalArgumentException();
    }
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[0].length;j++){
        if(board[i][j]!=0){
          throw new IllegalStateException();
        }
      }
    }
    return solveHelper(startingRow, startingCol, 1);
  }
  private boolean solveHelper(int row,int col,int step){
    board[row][col]=step;
    if(step==board.length*board[0].length){
      return true;
    }
    ArrayList<Cell> sortedMoves = new ArrayList<Cell>();
    for(int[] move : moves){
      if(row+move[0]<0||row+move[0]>=board.length||col+move[1]<0||col+move[1]>=board[0].length||
        board[row+move[0]][col+move[1]]!=0){
        continue;
      }
      moveBoard[row+move[0]][col+move[1]]-=1;
      sortedMoves.add(new Cell(moveBoard[row+move[0]][col+move[1]],row+move[0],col+move[1]));
    }
    Collections.sort(sortedMoves);
    for(int i=0; i<sortedMoves.size(); i++){
      if(solveHelper(sortedMoves.get(i).x,sortedMoves.get(i).y,step+1)){
        return true;
      } else {
        board[sortedMoves.get(i).x][sortedMoves.get(i).y]=0;
      }
    }
    for(int i=0; i<sortedMoves.size(); i++){
      moveBoard[sortedMoves.get(i).x][sortedMoves.get(i).y]+=1;
    }
    board[row][col]=0;
    return false;
  }
  public int countSolutions(int startingRow,int startingCol){
    if(startingRow<0||startingCol<0||startingRow>=board.length||startingCol>=board[0].length){
      throw new IllegalArgumentException();
    }
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[0].length;j++){
        if(board[i][j]!=0){
          throw new IllegalStateException();
        }
      }
    }
    return countHelper(startingRow, startingCol, 1, 0);
  }
  private int countHelper(int row,int col,int step,int solutions){
    board[row][col]=step;
    if(step==board.length*board[0].length){
      board[row][col]=0;
      return solutions+1;
    }
    for(int[] move : moves){
      if(row+move[0]<0||row+move[0]>=board.length||col+move[1]<0||col+move[1]>=board[0].length||
        board[row+move[0]][col+move[1]]!=0){
        continue;
      }
      solutions=countHelper(row+move[0],col+move[1],step+1,solutions);
      board[row+move[0]][col+move[1]]=0;
    }
    board[row][col]=0;
    return solutions;
  }
  public static void main(String[] args){
    for(int i=1; i<6; i++){
      KnightBoard board = new KnightBoard(i,i);
      System.out.println(board.printMoves());
      System.out.println(board.solve(0,0));
      System.out.println(board);
      System.out.println(board.printMoves());
      board = new KnightBoard(i,i);
      System.out.println(board.countSolutions(0,0));
      System.out.println(board);
    }
    for(int i=1; i<6; i++){
      KnightBoard board = new KnightBoard(i,i+1);
      System.out.println(board.printMoves());
      System.out.println(board.solve(0,0));
      System.out.println(board);
      System.out.println(board.printMoves());
      board = new KnightBoard(i,i+1);
      System.out.println(board.countSolutions(0,0));
      System.out.println(board);
    }
    for(int i=1; i<6; i++){
      KnightBoard board = new KnightBoard(i+1,i);
      System.out.println(board.printMoves());
      System.out.println(board.solve(0,0));
      System.out.println(board);
      System.out.println(board.printMoves());
      board = new KnightBoard(i+1,i);
      System.out.println(board.countSolutions(0,0));
      System.out.println(board);
    }
  }
}
