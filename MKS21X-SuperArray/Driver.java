public class Driver {
    public static void main(String[] args) {

        //PHASE 1NE
        //PART 1 testing #0,2,3
        SuperArray mine = new SuperArray();
        System.out.println("PHASE 1\n\nPart 1\n" + mine.size() + " ?= 0");
        System.out.println(mine.isEmpty() + " ?= true");
        String myString = "your";
        for (int idx = 0; idx < myString.length(); idx++) {
            mine.add(myString.substring(idx, idx + 1));
        }
        System.out.println(mine.add("ssss") + " ?= true");
        System.out.println(mine.size() + " ?= 5");
        System.out.println(mine.isEmpty() + " ?= false\n");
        //PART 2 testing #4,5
        System.out.println("Part 2\n" + mine + " ?= [y, o, u, r, ssss]");
        System.out.println(mine.get(4) + mine.get(1) + mine.get(2) + mine.get(3) + " ?= ssssour");
        try{
          System.out.println(mine.get(5));
        }
        catch(IndexOutOfBoundsException error){
          System.out.println("Given index (5) is out of bounds.");
        }
        try{
          System.out.println(mine.get(6)+mine.get(7));
        }
        catch(IndexOutOfBoundsException error){
          System.out.println("Given index (6) is out of bounds");
        }
        System.out.println("YOU SHOULD SEE 2 ERROR MESSAGES ABOVE");
        System.out.println(mine.toStringDebug() + " ?= [y, o, u, r, ssss, null, null, null, null, null]\n");
        //PART 3 testing #1,6
        System.out.println("Part 3\n" + mine.set(0, "ssss") + mine.set(3, "pp") + " ?= yr");
        System.out.println(mine + " ?= [ssss, o, u, pp, ssss]");
        mine.clear(); //byebye mine you will be gladly missed :(((
        System.out.println(mine.size() + " ?= 0");
        try{
          System.out.println(mine.get(0) + " ?= null (with one error beforehand)\n\nPHASE 2\n\nPart 1");
        }
        catch(IndexOutOfBoundsException error){
          System.out.println("Given index (0) is out of bounds.");
        }
        System.out.println("YOU SHOULD SEE AN ERROR MESSAGE ABOVE");
        //PHASE 2WOO
        //PART 1 testing #3,7 once
        String KsString = "supercalifragilisticexpialidocious";
        SuperArray ligma = new SuperArray();
        for (int idx = 0; idx < 10; idx++) {
            ligma.add(KsString.substring(idx, idx + 1));
        }
        System.out.println(ligma.toStringDebug() + " ?= [s, u, p, e, r, c, a, l, i, f]"); //NO NULLS HERE
        ligma.add(KsString.substring(10, 11));
        System.out.println(ligma.size() + " ?= 11");
        System.out.println(ligma.toStringDebug() + " ?= [s, u, p, e, r, c, a, l, i, f, r, null,..., null]\nyes you have to count the nulls\nit depends on how you made your resize\nif you made it so when you resize it * 2, there should be 9 nulls\nif you made it so when you resize it * 2 + 1, there should be 10 nulls\nif you made it so when you resize it + 1, there should be 0 nulls");
        for (int idx = 11; idx < KsString.length(); idx++) {
            ligma.add(KsString.substring(idx, idx + 1));
        }
        System.out.println(ligma.size() + " ?= 34");
        System.out.println(ligma + " ?= it should spell super...docious");
        int count = 0;
        for (int idx = 0; idx < ligma.toStringDebug().length() - 3; idx++) {
            if (ligma.toStringDebug().substring(idx, idx + 4).equals("null")) {
                count++;
            }
        }
        System.out.println(count + " ?= using same rules as last time, should be 6, 9, or 0\n\nPart 2");
        //I hate the word supercalifragilisticexpialidocious now why does this word exist?????
        //PART 2 testing #3,7 again! i think? It's easier to pass I think
        SuperArray omg = new SuperArray();
        for (int idx = 0; idx < 20; idx += 2) {
            omg.add(idx + "");
        }
        System.out.println(omg.size() + " ?= 10");
        System.out.println(omg + " ?= [0, 2, 4, 6, 8, 10, 12, 14, 16, 18]");
        String wth = "pleasedontfailme";
        for (int idx = 0; idx < wth.length() - 1; idx += 2) {
            omg.add(wth.substring(idx, idx + 2));
        }
        System.out.println(omg.size() + " ?= 18\n\nPHASE 3\n\nPart 1");

        //PHASE 3HREEEE
        //PART 1 testing #8, 9
        SuperArray almostDone = new SuperArray();
        String alphabet = "abcdefghijklmnopqrst";
        for (int idx = 0; idx < alphabet.length() - 1; idx += 2) {
            almostDone.add(alphabet.substring(idx, idx + 2));
        }
        System.out.println(almostDone.contains("op") + " ?= true");
        System.out.println(almostDone.contains("fg") + " ?= false");
        System.out.println(almostDone.indexOf("op") + " ?= 7");
        System.out.println(almostDone.indexOf("fg") + " ?= -1");
        SuperArray herether = new SuperArray();
        for (int idx = 0; idx < 15; idx++) {
            herether.add(idx % 4 + "");
        }
        System.out.println(herether.lastIndexOf("3") + " ?= 11");
        System.out.println(herether.lastIndexOf("4") + " ?= -1");
        System.out.println(herether.lastIndexOf("0") + " ?= 12\n\nPart 2");
        //PART 2 testing #8,10
        almostDone.add(3, "happy birthday to me");
        System.out.println(almostDone + " ?= [ab, cd, ef, happy birthday to me, gh, ij, kl, mn, op, qr, st]");
        System.out.println(almostDone.contains("happy birthday to me") + " ?= true");
        System.out.println(almostDone.size() + " ?= 11");
        almostDone.add(11, "sad day to you");
        System.out.println(almostDone.size() + " ?= 12");
        System.out.println(almostDone + " ?= [ab, cd, ef, happy birthday to me, gh, ij, kl, mn, op, qr, st, sad day to you]");
        try{
          almostDone.add(21, "oh no");
        }
        catch(IndexOutOfBoundsException error){
          System.out.println("Given index (21) is out of bounds");
        }
        System.out.println("There should be an error message above");
        System.out.println(almostDone.size() + " ?= 12\n\nPart3");
        //PART 3 testing #8,11
        System.out.println(almostDone.remove(11) + " ?= sad day to you");
        System.out.println(almostDone.size() + " ?= 11");
        System.out.println(almostDone.remove(3) + " ?= happy birthday to me");
        System.out.println(almostDone.size() + " ?= 10");
        System.out.println(almostDone + " ?= [ab, cd, ef, gh, ij, kl, mn, op, qr, st]");
        try{
          System.out.println(almostDone.remove(69) + " ?= null");
        }
        catch(IndexOutOfBoundsException error){
          System.out.println("Given index (69) is out of bounds");
        }
        System.out.println("There should be an error message\n" + almostDone.size() + " ?= 10");
        //PART 4 testing #12
        System.out.println(almostDone.remove("cd") + " ?= true");
        System.out.println(almostDone.size() + " ?= 9");
        System.out.println(almostDone + " ?= [ab, ef, gh, ij, kl, mn, op, qr, st]");
        System.out.println(almostDone.remove("fg") + " ?= false");
        System.out.println(almostDone.size() + " ?= 9");
        System.out.println(almostDone + " ?= [ab, ef, gh, ij, kl, mn, op, qr, st]");
        try{
          SuperArray p = new SuperArray(-1);
        }
        catch(IllegalArgumentException e){
          System.out.println("Given size (-1) is invalid");
        }
    }
}
