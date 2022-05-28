package threedottwoex;

public class Main {

	public static void main(String[] args) {
		PublicationManager pm = new PublicationManager();

		// Thực hiện thêm dữ liệu ấn phẩm vào các instance
		pm.add();
		System.out.println(pm.checkPublicationType(2));
		System.out.println("Kiểm tra ấn phẩm bất kỳ có là Tạp Chí và xuất bản cách đây 10 năm? : "
				+ pm.checkPublicationTypeAndYear(1, PublicationType.MAGAZINE, 10));
		System.out
				.println("So sánh hai ấn phẩm có vừa cùng loại và vừa cùng tác giả? : " +
						pm.comparePublication(1, 2));
		System.out.println("Tổng tiền tất cả ấn phẩm hiện có: " +
				pm.getTotalPrice());
		System.out.println(PublicationManager.toString(pm.method7()));
		System.out.println(PublicationManager.toStringMList(pm.getMagazinesWithYear(2012)));
		pm.sortByTitle_ASC();
		pm.print();
		pm.sortByPYear_DES();
		pm.print();
		System.out.println(pm.countPublicationByYears(2010, 2022));
		pm.createGUI();
	}
}