public class Driver {
	private static String s(int[] array) {
		String out = "[";
		for (int i = 0; i < array.length; i++) {
			out += ""+array[i];
			if (i+1 != array.length) out += ", ";
		}
		return out+"]";
	}

	private static String s(int[][] array) {
		String out = "[";
		for (int i = 0; i < array.length; i++) {
			out += ""+s(array[i]);
			if (i+1 != array.length) out += ", ";
		}
		return out+"]";
	}

	public static void main(String[] args) {

		int[][] array0 = {{},{0,1,2,3,4},{4,3,2,1,0,4,4,4}};
		int[][] array1 = {{0,1,2,0},{3},{1,1,1}};

		int c = 0;

		try {
			try {
				if (ArrayMethods.rowSum(array0, 0) != 0) System.out.println(++c+". You are returning a non-0 number when rowSum is called on an empty array.");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(++c+". You are producing an ArrayIndexOutOfBoundsException when calling rowSum on an empty array. Count the missing values as 0 instead.");
			}
			try {
				if (ArrayMethods.rowSum(array0, 2) != 22) System.out.println(++c+". You are returning the wrong number when rowSum is called on a populated array.");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(++c+". You are producing an ArrayIndexOutOfBoundsException when calling rowSum on a populated array.");
			}
			/* Commented, as Mr K will not be testing negative indices.
			if (ArrayMethods.rowSum(array0, -1) != 0) System.out.println(++c+". You are returning a non-0 number when rowSum is called with a negative index.");
			*/
			try {
				if (ArrayMethods.rowSum(array0, 999) != 0) System.out.println(++c+". You are returning a non-0 number when rowSum is called with an out of range index.");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(++c+". You are producing an ArrayIndexOutOfBoundsException when rowSum is called with an out of range index. Count the missing values as 0 instead.\n\t-note: K may not be testing this.");
			}
		} catch (Exception e) {
			System.out.println(++c+". You are producing a "+e.getClass().getCanonicalName()+" when calling rowSum.");
		}

		try {
			try {
				if (ArrayMethods.columnSum(array0, 3) != 4) System.out.println(++c+". You are returning the wrong number when columnSum is called on a populated array.");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(++c+". You are producing an ArrayIndexOutOfBoundsException when calling columnSum on a jagged array. Count the missing values as 0 instead.");
			}/* Commented, as Mr K will not be testing negative indices.
			try {
				if (ArrayMethods.columnSum(array0, -1) != 0) System.out.println(++c+". You are returning a non-0 number when columnSum is called with a negative index.");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(++c+". You are producing an ArrayIndexOutOfBoundsException when calling columnSum on with a negative index. Count missing values as 0 instead.");
			}*/
			try {
				if (ArrayMethods.columnSum(array0, 999) != 0) System.out.println(++c+". You are returning a non-0 number when columnSum is called with an out of range index.");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(++c+". You are producing an ArrayIndexOutOfBoundsException when calling columnSum on with a negative index. Count missing values as 0 instead.");
			}
		} catch (Exception e) {
			System.out.println(++c+". You are producing a "+e.getClass().getCanonicalName()+" when calling columnSum.");
		}

		try {
			if (!s(ArrayMethods.allRowSums(array0)).equals("[0, 10, 22]")) {
				System.out.println(++c+". You are returning the wrong array when allRowSums is called.");
				System.out.println("\tinput:          "+s(array0));
				System.out.println("\tdesired result: [0, 10, 22]");
				System.out.println("\tyour result:    "+s(ArrayMethods.allRowSums(array0)));
			}
			if (!s(ArrayMethods.allRowSums(array1)).equals("[3, 3, 3]")) {
				System.out.println(++c+". You are returning the wrong array when allRowSums is called.");
				System.out.println("\tinput:          "+s(array1));
				System.out.println("\tdesired result: [3, 3, 3]");
				System.out.println("\tyour result:    "+s(ArrayMethods.allRowSums(array1)));
			}
		} catch (Exception e) {
			System.out.println(++c+". You are producing a "+e.getClass().getCanonicalName()+" when calling allRowSums.");
		}

		try {
			if (!s(ArrayMethods.allColSums(array0)).equals("[4, 4, 4, 4, 4, 4, 4, 4]")) {
				System.out.println(++c+". You are returning the wrong array when allColSums is called.");
				System.out.println("\tinput:          "+s(array0));
				System.out.println("\tdesired result: [4, 4, 4, 4, 4, 4, 4, 4]");
				System.out.println("\tyour result:    "+s(ArrayMethods.allColSums(array0)));
			}
			if (!s(ArrayMethods.allColSums(array1)).equals("[4, 2, 3, 0]")) {
				System.out.println(++c+". You are returning the wrong array when allColSums is called.");
				System.out.println("\tinput:          "+s(array1));
				System.out.println("\tdesired result: [4, 2, 3, 0]");
				System.out.println("\tyour result:    "+s(ArrayMethods.allColSums(array1)));
			}
		} catch (Exception e) {
			System.out.println(++c+". You are producing a "+e.getClass().getCanonicalName()+" when calling allColSums.");
		}

		try {
			if (ArrayMethods.isRowMagic(array0)) {
				System.out.println(++c+". You are saying that an array is RowMagic when it isn't.");
				System.out.println("\tinput:          "+s(array0));
				System.out.println("\tdesired result: false");
				System.out.println("\tyour result:    true");
			}
			if (!ArrayMethods.isRowMagic(array1)) {
				System.out.println(++c+". You are saying that an array isn't RowMagic when it is.");
				System.out.println("\tinput:          "+s(array1));
				System.out.println("\tdesired result: true");
				System.out.println("\tyour result:    false");
			}
		} catch (Exception e) {
			System.out.println(++c+". You are producing a "+e.getClass().getCanonicalName()+" when calling isRowMagic.");
		}

		try {
			if (ArrayMethods.isColumnMagic(array1)) {
				System.out.println(++c+". You are saying that an array is ColumnMagic when it isn't.");
				System.out.println("\tinput:          "+s(array1));
				System.out.println("\tdesired result: false");
				System.out.println("\tyour result:    true");
			}
			if (!ArrayMethods.isColumnMagic(array0)) {
				System.out.println(++c+". You are saying that an array isn't ColumnMagic when it is.");
				System.out.println("\tinput:          "+s(array0));
				System.out.println("\tdesired result: true");
				System.out.println("\tyour result:    false");
			}
		} catch (Exception e) {
			System.out.println(++c+". You are producing a "+e.getClass().getCanonicalName()+" when calling isColumnMagic.");
		}

		if (c == 0) System.out.println("Your code passed every test. Nice work.");
		else System.out.println("\nYou produced "+c+" unexpected result(s). Keep debugging!");
	}
}