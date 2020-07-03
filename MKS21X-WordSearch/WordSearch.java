import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class WordSearch{
  private char[][] data;
  private int seed;
  private Random rng;
  private ArrayList<String> wordsToAdd = new ArrayList<String>();
  private ArrayList<String> wordsAdded = new ArrayList<String>();
  private Scanner s;
  private static String instructions = "Please give the following paramters in the order shown:\n"+
    "rows cols file [seed[ans]]\n"+
    "rows is the number of rows in the word search\n"+
    "cols is the number of cols in the word search\n"+
    "file is the name of a file containing the words, with the extension\n"+
    "seed is an optional paramter that generates the word search with the specified seed\n"+
    "input the string \"key\" for the optional paramater ans if you want the solution to the word search";
  public WordSearch(int rows,int cols,String filename,int randSeed, boolean ans){
    if(rows<0 || cols < 0){
      throw new IllegalArgumentException();
    }
    try{
      Scanner s = new Scanner(new File(filename));
      while(s.hasNext()){
        wordsToAdd.add(s.next().toUpperCase());
      }
    }
    catch(FileNotFoundException e){
      System.out.println("File "+filename+" not found.");
      System.exit(0);
    }
    data = new char[rows][cols];
    clear();
    seed = randSeed;
    rng = new Random(seed);
    addAllWords();
    if(!ans){
      fill();
    }
  }
  private void clear(){
    for(int x = 0; x < data.length; x++){
      for(int y = 0; y < data[x].length; y++){
        data[x][y] = '_';
      }
    }
  }
  public String toString(){
    String puzzle = "";
    for(int x = 0; x < data.length; x++){
      puzzle+="|";
      for(int y = 0; y < data[x].length; y++){
        puzzle+=data[x][y]+(y==data[x].length-1? "|\n":" ");
      }
    }
    puzzle+="Words: ";
    for(int x = 0; x < wordsAdded.size(); x++){
      puzzle+=wordsAdded.get(x)+", ";
    }
    return puzzle.substring(0,puzzle.length()-2)+" (seed: "+seed+")";
  }
  private boolean addWord(String word,int row, int col, int rowInc, int colInc){
    if(Math.abs(rowInc)>1 || Math.abs(colInc)>1){
      throw new IllegalArgumentException();
    }
    if(row < 0 || col < 0 || row >= data.length || col >= data[0].length || (rowInc==0 && colInc==0)){
      return false;
    }
    if((word.length()>data.length-row && rowInc>0) || (word.length()>data[0].length-col && colInc>0)){
      return false;
    }
    if((word.length()>row && rowInc<0) || (word.length()>col && colInc<0)){
      return false;
    }
    for(int x=0; x<word.length(); x++){
      if(data[row+x*rowInc][col+x*colInc]!='_' && data[row+x*rowInc][col+x*colInc]!=word.charAt(x)){
        return false;
      }
    }
    for(int x=0; x<word.length(); x++){
      data[row+x*rowInc][col+x*colInc]=word.charAt(x);
    }
    return true;
  }
  private boolean helper(String word, int rowInc, int colInc, ArrayList<int[]> starts){
    for(int c = 0; c < starts.size(); c++){
      int[] start = starts.remove(Math.abs(rng.nextInt())%starts.size());
      if(addWord(word,start[0],start[1],rowInc,colInc)){
        return true;
      }
    }
    return false;
  }
  private void addAllWords(){
    ArrayList<String> wordsToTry = wordsToAdd;
    for(int a = 0; a < wordsToTry.size(); a++){
      String word = wordsToTry.get(Math.abs(rng.nextInt()%wordsToTry.size()));
      wordsToTry.remove(word);
      ArrayList<int[]> orientations = new ArrayList<int[]>();
      for(int r = -1; r<2; r++){
        for(int c = -1; c<2; c++){
          if(r==0 && c==0){
            continue;
          }
          orientations.add(new int[]{r,c});
        }
      }
      for(int b = 0; b < 6; b++){
        int[] orientation = orientations.remove(Math.abs(rng.nextInt())%orientations.size());
        int rowInc = orientation[0];
        int colInc = orientation[1];
        ArrayList<int[]> starts = new ArrayList<int[]>();
        for(int x=(rowInc==-1? word.length()-1:0); x<(rowInc==1? data.length-word.length()+1:data.length); x++){
          for(int y=(colInc==-1? word.length()-1:0); y<(colInc==1? data[0].length-word.length()+1:data[0].length); y++){
            starts.add(new int[]{x,y});
          }
        }
        if(helper(word,rowInc,colInc,starts)){
          wordsToAdd.remove(word);
          wordsAdded.add(word);
          break;
        }
      }
    }
  }
  private void fill(){
      for(int x = 0; x < data.length; x++){
        for(int y = 0; y<data[0].length; y++){
          if(data[x][y]=='_'){
            data[x][y] = (char)((int)'A'+Math.abs(rng.nextInt())%26);
          }
        }
      }
  }
  public static void main(String[] args){
    try{
      if(args.length < 3){
        System.out.println(instructions);
        System.exit(0);
      }
      if(Integer.parseInt(args[0])<=0 || Integer.parseInt(args[1])<=0){
        System.out.println("rows and cols have to be greater than 0");
        System.exit(0);
      }
      if(args.length >= 4 && (Integer.parseInt(args[3])<0 || Integer.parseInt(args[3])>10000)){
        System.out.println("seed must be between 0 and 10000 inclusive");
        System.exit(0);
      }
      if(args.length >= 5){
        if(args[4].equals("key")){
          System.out.println(new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2],Integer.parseInt(args[3]),true));
          System.exit(0);
        }
      }
      if(args.length >= 4){
        System.out.println(new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2],Integer.parseInt(args[3]),false));
      }
      if(args.length == 3){
        Random genRng = new Random();
        int genSeed = Math.abs(genRng.nextInt())%10001;
        System.out.println(new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2],genSeed,false));
      }
    }
    catch(NumberFormatException e){
      System.out.println("rows, cols, and seed must be an integer");
      System.exit(0);
    }
  }
}
