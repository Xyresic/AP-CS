public class Driver4 {
  public static void main(String[] args) {

    System.out.println("NOTE: IF SOMETHING TESTS, AND DOESN'T RETURN ANYTHING, ASSUME IT WORKS");

    //Case 0
    System.out.println("Instantianting Empty:");
    SuperArray testy = new SuperArray(0);
    System.out.println(testy.toStringDebug());

    //Case 1
    System.out.println("\n\nAdding only 3 items:");
    for (int x = 0; x < 3; x ++) {
      testy.add("" + x);
    }
    System.out.println(testy);
    testy.clear();

    //Case 2
    System.out.println("\n\nAdding 3000 Times:");
    for (int x = 0; x < 3000; x ++) {
      testy.add("test" + x);
    }
    System.out.println("Length should now be 3000:\n" + testy.size());

    //Case 3
    System.out.println("\n\nRemoving 200 Items:");
    for (int x = 2999; x > 2799; x --) {
      testy.remove(x);
    }
    System.out.println("Length should now be 2800:\n" + testy.size());

    //Case 4
    System.out.println("\n\nRemoving 200, and checking return values:");
    for(int x = 0; x < 200; x ++) {
      if (! testy.remove(0).equals("test" + x)) {
        throw new RuntimeException("Something has gone wrong, this test failed.");
      }
    }
    System.out.println("Congrats! No errors. Length should now be 2600:\n" + testy.size());
    testy.clear();

    //Case 5
    int c = 0;
    try {
      SuperArray seven = new SuperArray(-5);
    } catch (IllegalArgumentException e) {
      //System.out.println("Failed to make a SuperArray of size -5 (probably a good thing!)");
      c++;
    }
    try {
      testy.get(6);
    } catch (IndexOutOfBoundsException e) {
      //System.out.println("Failed to get item at too high an index");
      c++;
    }
    try {
      testy.get(-1);
    } catch (IndexOutOfBoundsException e) {
      //System.out.println("Failed to get item at negative index");
      c++;
    }
    //Adding five integers to testy
    for (int i = 0; i < 5; i++) {
      testy.add(Integer.toString(i));
    }
    try {
      testy.set(5, "lol");
    } catch (IndexOutOfBoundsException e) {
      //System.out.println("Failed to set value at too high an index");
      c++;
    }
    try {
      testy.set(-1, "yee");
    } catch (IndexOutOfBoundsException e) {
      //System.out.println("Failed to set value at negative index");
      c++;
    }
    try {
      testy.add(6, "lol");
    } catch (IndexOutOfBoundsException e) {
      //System.out.println("Failed to add value at too high an index");
      c++;
    }
    try {
      testy.add(-1, "yee");
    } catch (IndexOutOfBoundsException e) {
      //System.out.println("Failed to add value at negative index");
      c++;
    }
    try {
      testy.remove(6);
    } catch (IndexOutOfBoundsException e) {
      //System.out.println("Failed to remove value at too high an index");
      c++;
    }
    try {
      testy.remove(-1);
    } catch (IndexOutOfBoundsException e) {
      //System.out.println("Failed to remove value at negative index");
      c++;
    }
    if (c == 9) {
      System.out.println("All exceptions successfully caught");
    } else {
      System.out.println("c = "+c);
    }
    testy.clear();

    //Case 6
    System.out.println("Adding to 0 and using size() a few times:");
    testy.add(0, "test1");
    System.out.println(testy.size());
    testy.add(0, "test2");
    System.out.println(testy.size());
    testy.add(0, "test3");
    System.out.println(testy.size());
    testy.clear();

    //Case 7
    System.out.println("Testing indexOf Many Times(if there is nothing printed, you're good to go!):");
    testy.add("a");
    testy.add("a");
    boolean case7 = true;
    for (int i = 0; i < 100; i++) {
      if (testy.indexOf("a") != 0) {
        case7 = false;
      }
    }
    if (!case7) {
      System.out.println("Your indexOf isn't working");
    }

    //Case 8
    System.out.println("Testing LastIndex Many Times(if there is nothing printed, you're good to go!):");
    boolean case8 = true;
    for (int i = 0; i < 100; i++) {
      if (testy.lastIndexOf("a") != 1) {
        case8 = false;
      }
    }
    if (!case8) {
      System.out.println("Your lastIndexOf isn't working");
    }
    testy.clear();


    //Case 9
    System.out.println("\n\nTesting the speed and functionality of add:");
    for (int x = 0; x < 100; x ++) {
      testy.add("placeHolder");
    }
    for (int x = 0; x < 100; x ++) {
      try{
      testy.set(x, "jediNumber" + x);
      }
      catch(IndexOutOfBoundsException e) {
        System.out.println("An Index error was given here, check your set function.");
      }
    }
    System.out.println("If no errors were given, and the length is 100, you're good to go! Length:\n" + testy.size());

    //Case 10
    System.out.println ("Testing add and clear(if there is nothing printed, you're good to go!):");
    for (int i = 0; i < 1500; i++) {
      testy.add("churros");
    }
    testy.clear();
    for (int i = 0; i < 1500; i++) {
      testy.add("seven");
    }
    if (testy.get(1499).equals("churros")) {
      System.out.println("Your clear is messed up");
    } else if (!testy.get(1499).equals("seven")) {
      System.out.println("Your add seems to be faulty");
    }
    testy.clear();

    //Case 11
    System.out.println("Testing a LOT of set commands(if there is nothing printed, you're good to go!):");
    boolean case11 = true;
    for (int i = 0; i < 530; i++) {
      testy.add("Thanos");
    }
    for (int i = 0; i < 530; i++) {
      testy.set(i, "was right");
    }
    for (int i = 0; i < 530; i++) {
      if (!testy.get(i).equals("was right")) {
        case11 = false;
      }
    }
    if (!case11) {
      System.out.println("Go fix your set because it's stupid right now");
    }
  }
}
