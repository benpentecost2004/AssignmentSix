import java.util.*;
import java.io.*;

public class BubbleSort {

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void swap(int[] array, int n) {
		for(int i = 0; i < n-1; i++) {
			if(array[i] > array[i + 1]) {
				swap(array, i, i+1);
			}
		}
	}

	public static void bubbleSort(int[] array) {
		for(int i = array.length - 1; i >= 1; i--) {
			for(int j = 0; j < i; j++) {
				if(array[j] > array[j + 1]) {
					swap(array, j, j+1);
				}
			}
		}
	}

	public static boolean isSorted(int[] array) {
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i] > array[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static int[] createRandomArray(int arrayLength) {
		int[] array = new int[arrayLength];
		Random random = new Random();
		for(int i = 0; i < arrayLength; i ++) {
			array[i] = random.nextInt(100);
		}
		return array;
	}

	public static void writeArrayToFile(int[] array, String filename) {
		try (FileWriter fileWriter = new FileWriter(filename)) {
			for(int i = 0; i < array.length; i++) {
				fileWriter.write(array[i] + "\n");
			}
		} catch (IOException e) {

		}
	}


	public static int[] readFileToArray(String filename) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		try {
			File file = new File(filename); 
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
				String s = sc.nextLine();
				arrayList.add(Integer.parseInt(s));
			}
			sc.close();
		} catch (IOException e) {

		}
		int[] array = new int[arrayList.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = arrayList.get(i);
			System.out.println(array[i]);
		}
		return array;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input the array length: ");
		int arrayLength = sc.nextInt();
		System.out.println(" ");
		int[] array = createRandomArray(arrayLength);
		writeArrayToFile(array, "ArrayFile.txt");
		System.out.println("Here is your array:");
		readFileToArray("ArrayFile.txt");

		System.out.println(" ");
		System.out.println("Is the array sorted?\n" + isSorted(array));

		bubbleSort(array);

		System.out.println(" ");
		System.out.println("Is the array sorted?\n" + isSorted(array));

		sc.close();

	}
}




