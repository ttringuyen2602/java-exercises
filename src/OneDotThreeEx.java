import java.util.Arrays;

public class OneDotThreeEx {

	// Hàm tính tổng các phần tử ở vị trí chẵn trong mảng
	static int sumOfEvenIndexElement(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i += 2) {
			sum += arr[i];
		}
		return sum;
	}

	// Hàm kiểm tra một số trong mảng xuất hiện 2 lần
	static int checkNumberAppears_2nd(int[] arr, int x) {
		int count = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == x)
				count += 1;

			if (count == 2)
				return i;
		}
		return -1;
	}

	// Hàm kiểm tra các phần tử là bội số của 2
	static int[] multiplesOf_2(int[] arr) {
		int[] arr2 = new int[arr.length];
		int count = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] % 2 == 0) {

				for (int j = 0; j < arr2.length; j++) {
					if (arr2[j] == 0) {
						arr2[j] = arr[i];
						count++;
						break;
					}
				}
			}
		}

		// Phương thức nho nhỏ để bỏ đi những phần tử 0
		int[] arr3 = new int[count];
		for (int i = 0; i < arr3.length; i++) {
			arr3[i] = arr2[i];
		}

		return arr3;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 1, 5, 8, 2, 6, 9, 5, 6, 5, 7, 9 };
		int sum = sumOfEvenIndexElement(arr);
		System.out.println("Tổng các phần tử ở vị trí chẵn trong mảng là: " + sum);

		int x = 9;
		int second = checkNumberAppears_2nd(arr, x);
		System.out.println("Vị trí phần tử xuất hiện lần thứ 2 trong mảng là: " + second);

		System.out.println(
				"Mảng mới sau khi đã lấy ra các phần tử chia hết cho 2 là: " + Arrays.toString(multiplesOf_2(arr)));

	}
}
