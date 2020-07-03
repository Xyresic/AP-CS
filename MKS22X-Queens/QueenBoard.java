public class QueenBoard{
  int[][] board;
  public QueenBoard(int size){
    board = new int[size][size];
  }
  public String toString(){
    String array = "";
    if(board.length==0){
      return array;
    }
    for(int i=0; i<board.length; i++){
      for(int j=0; j<board.length; j++){
        if(board[i][j]==-1)array+="Q ";
        else{array+=/*board[i][j];}*/"_ ";}
      }
      array+="\n";
    }
    return array.substring(0,array.length()-2);
  }
  public boolean solve(){
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board.length;j++){
        if(board[i][j]!=0){
          throw new IllegalStateException();
        }
      }
    }
    return solveHelper(board.length);
  }
  private boolean solveHelper(int queens){
    if(queens==0){
      return true;
    }
    int i=board.length-queens;
    for(int j=0;j<board.length;j++){
      if(board[i][j]>0){
        continue;
      }
      board[i][j]=-1;
      for(int k=1;k<board.length-i;k++){
        board[i+k][j]+=1;
        if(j-k>-1){
          board[i+k][j-k]+=1;
        }
        if(j+k<board.length){
          board[i+k][j+k]+=1;
        }
      }
      if(solveHelper(queens-1)){
        return true;
      }
      board[i][j]=0;
      for(int k=1;k<board.length-i;k++){
        board[i+k][j]-=1;
        if(j-k>-1){
          board[i+k][j-k]-=1;
        }
        if(j+k<board.length){
          board[i+k][j+k]-=1;
        }
      }
    }
    return false;
  }
  public int countSolutions(){
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board.length;j++){
        if(board[i][j]!=0){
          throw new IllegalStateException();
        }
      }
    }
    return countHelper(board.length,0);
  }
  private int countHelper(int queens,int solutions){
    if(queens==0){
      return solutions+1;
    }
    int i=board.length-queens;
    for(int j=0;j<board.length;j++){
      if(board[i][j]>0){
        continue;
      }
      board[i][j]=-1;
      for(int k=1;k<board.length-i;k++){
        board[i+k][j]+=1;
        if(j-k>-1){
          board[i+k][j-k]+=1;
        }
        if(j+k<board.length){
          board[i+k][j+k]+=1;
        }
      }
      solutions = countHelper(queens-1,solutions);
      board[i][j]=0;
      for(int k=1;k<board.length-i;k++){
        board[i+k][j]-=1;
        if(j-k>-1){
          board[i+k][j-k]-=1;
        }
        if(j+k<board.length){
          board[i+k][j+k]-=1;
        }
      }
    }
    return solutions;
  }
  public static void main(String[] args){
    for(int i=0;i<11;i++){
      QueenBoard board = new QueenBoard(i);
      System.out.println(board.solve());
      System.out.println(board);
      board = new QueenBoard(i);
      System.out.println(board.countSolutions());
      System.out.println(board);
    }
    try{
      QueenBoard board = new QueenBoard(8);
      board.solve();
      board.solve();
    } catch(IllegalStateException e){
      System.out.println("Succesfully threw error.");
    }
    try{
      QueenBoard board = new QueenBoard(8);
      board.solve();
      board.countSolutions();
    } catch(IllegalStateException e){
      System.out.println("Succesfully threw error.");
    }
  }
}
