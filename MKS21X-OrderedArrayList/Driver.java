public class Driver {
	public static void main(String[] args) {

		int c = 0;

		NoNullArrayList<String> array = new NoNullArrayList<>();

		try {
			array.add("x");
			if (!(""+array).equals("[x]")) System.out.println(++c+". You aren't adding properly when NoNullArrayList.add(T) is called.");
			array.add(0,"y");
			if (!(""+array).equals("[y, x]")) System.out.println(++c+". You aren't adding properly when NoNullArrayList.add(index, T) is called.");
			array.set(1,"z");
			if (!(""+array).equals("[y, z]")) System.out.println(++c+". You aren't setting properly when NoNullArrayList.set(index, T) is called.");
		} catch (Exception e) {
			System.out.println(++c+". You are producing a "+e.getClass().getCanonicalName()+" when adding/setting to a NoNullArrayList.");
		}

		try {
			try {
				array.add(null);
				System.out.println(++c+". You aren't catching nulls properly when NoNullArrayList.add(T) is called.");
			} catch (IllegalArgumentException e) {}
			if (!(""+array).equals("[y, z]")) System.out.println(++c+". You are modifying the array when NoNullArrayList.add(null) is called.");
			try {
				array.add(0,null);
				System.out.println(++c+". You aren't catching nulls when NoNullArrayList.add(index, T) is called.");
			} catch (IllegalArgumentException e) {}
			if (!(""+array).equals("[y, z]")) System.out.println(++c+". You are modifying the array when NoNullArrayList.add(index, null) is called.");
			try {
				array.set(1,null);
				System.out.println(++c+". You aren't catching nulls when NoNullArrayList.set(index, T) is called.");
			} catch (IllegalArgumentException e) {}
			if (!(""+array).equals("[y, z]")) System.out.println(++c+". You are modifying the array when NoNullArrayList.set(index, null) is called.");
		} catch (Exception e) {
			System.out.println(++c+". You are producing a "+e.getClass().getCanonicalName()+" when adding/setting a null value to a NoNullArrayList. You should be throwing IllegalArgumentException instead.");
		}

		array = new OrderedArrayList<>();

		try {
			array.add("z");
			array.add("x");
			array.add("y");
			if (!(""+array).equals("[x, y, z]")) System.out.println(++c+". You aren't adding properly when OrderedArrayList.add(T) is called.");
			array.add(2,"c");
			array.add(1,"a");
			array.add(0,"b");
			if (!(""+array).equals("[a, b, c, x, y, z]")) {
				System.out.print(++c+". You aren't adding properly when OrderedArrayList.add(index, T) is called. ");
				if (array.size() == 6) System.out.println("Your elements are out of order. :(");
				else System.out.println("Some elements aren't getting added. They feel left out :(");
			}
			array.set(2,"r");
			array.set(1,"p");
			array.set(0,"q");
			if (!(""+array).equals("[p, q, r, x, y, z]")) {
				System.out.print(++c+". You aren't adding properly when OrderedArrayList.set(index, T) is called. ");
				if (array.size() > 6) System.out.println("You aren't removing elements properly!");
				else if (array.size() < 6) System.out.println("Some elements aren't getting added. They feel left out :(");
				else if ((""+array).contains("a") || (""+array).contains("b") || (""+array).contains("c")) System.out.println("You aren't removing elements properly!");
				else System.out.println("Your elements are out of order. :(");
			}
		} catch (Exception e) {
			System.out.println(++c+". You are producing a "+e.getClass().getCanonicalName()+" when adding/setting to an OrderedArrayList.");
		}

		try {
			try {
				array.add(null);
				System.out.println(++c+". You aren't catching nulls properly when OrderedArrayList.add(T) is called.");
			} catch (IllegalArgumentException e) {}
			if (!(""+array).equals("[p, q, r, x, y, z]")) System.out.println(++c+". You are modifying the array when OrderedArrayList.add(null) is called.");
			try {
				array.add(0,null);
				System.out.println(++c+". You aren't catching nulls when OrderedArrayList.add(index, T) is called.");
			} catch (IllegalArgumentException e) {}
			if (!(""+array).equals("[p, q, r, x, y, z]")) System.out.println(++c+". You are modifying the array when OrderedArrayList.add(index, null) is called.");
			try {
				array.set(1,null);
				System.out.println(++c+". You aren't catching nulls when OrderedArrayList.set(index, T) is called.");
			} catch (IllegalArgumentException e) {}
			if (!(""+array).equals("[p, q, r, x, y, z]")) System.out.println(++c+". You are modifying the array when OrderedArrayList.set(index, null) is called.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(++c+". You are producing a "+e.getClass().getCanonicalName()+" when adding/setting a null value to an OrderedArrayList. You should be throwing IllegalArgumentException instead.");
		}

		if (c == 0) System.out.println("Your code passed every test. Nice work.");
		else System.out.println("\nYou produced "+c+" unexpected results. Keep debugging!");
	}
}
