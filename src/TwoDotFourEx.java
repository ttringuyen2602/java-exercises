import java.util.Arrays;

public class TwoDotFourEx {

	// Tìm các phần tử biên
	static int[] searchBoundary(int array[][], int n, int m, int size) {

		int[] arr = new int[size];

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < m; j++) {

				if (i == 0 || j == 0 || i == n - 1 || j == m - 1)
					for (int k = 0; k < arr.length; k++) {
						if (arr[k] == 0) {
							arr[k] = array[i][j];
							break;
						}
					}
			}
		}
		return arr;
	}

	// Tìm phần tử lớn thứ 2 của biên
	static int findSecondLargestElement(int array[][], int n, int m, int size) {
		int[] arr = new int[size];
		arr = searchBoundary(array, n, m, size);
		Arrays.sort(arr);
		return arr[size - 2];
	}

	// Tìm phần tử nhỏ nhất của biên
	static int findSmallestElement(int array[][], int n, int m, int size) {
		int[] arr = new int[size];
		arr = searchBoundary(array, n, m, size);
		Arrays.sort(arr);
		return arr[0];
	}

	static int[][] replaceNotBoundaryElement(int array[][], int n, int m, int size) {

		int length = n;
		int largestMainDiagonalElement = 0; // Phần tử lớn nhất nằm trên đường chéo chính

		// Nếu coi ma trận là một hình chữ nhật thì
		// Số phần tử nằm trên đường chéo chính luôn bằng chiều rộng hình chữ nhật
		if (m < n)
			length = n;

		// Tìm phần tử lớn nhất nằm trên đường chéo chính
		largestMainDiagonalElement = array[0][0];
		for (int i = 1; i < length; i++) {
			int j = i;
			if (largestMainDiagonalElement < array[i][j])
				largestMainDiagonalElement = array[i][j];
		}

		// Thay thế các phần tử nằm bên trong biên bằng
		// phần tử lớn nhất nằm trên đường chéo chính
		for (int i = 1; i < n - 1; i++) {

			for (int j = 1; j < m - 1; j++)
				array[i][j] = largestMainDiagonalElement;
		}

		return array;
	}

	public static void main(String[] args) {
		int n = 4;
		int m = 4;
		int[][] array = {
				{ 1, 2, 3, 4 },
				{ 5, 6, 7, 8 },
				{ 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };

		// Tìm số phần tử biên của mảng hai chiều ***********
		int size = (n - 1 + m - 1) * 2;
		if (n == 1)
			size = m;
		else if (m == 1)
			size = n;
		// ************************

		int secondLargest = findSecondLargestElement(array, n, m, size);
		System.out.println("Phần tử biên lớn thứ 2 là: " + secondLargest);

		int smallest = findSmallestElement(array, n, m, size);
		System.out.println("Phần tử biên nhỏ nhất là: " + smallest);

		int[][] replace = new int[n][m];
		replace = replaceNotBoundaryElement(array, n, m, size);
		System.out.println(
				"Mảng mới sau khi thay thế các phần tử bị thiếu bằng phần tử lớn nhất trên đường chéo chính: ");
		for (int[] row : replace)
			System.out.println(Arrays.toString(row));
	}
}
