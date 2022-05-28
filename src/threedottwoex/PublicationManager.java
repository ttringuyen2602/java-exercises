package threedottwoex;

import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PublicationManager {
    private ArrayList<ReferenceBook> referenceBookList;
    private ArrayList<Magazine> magazineList;
    private ArrayList<Publication> publicationList;

    public PublicationManager() {
        referenceBookList = new ArrayList<>();
        magazineList = new ArrayList<>();
        publicationList = new ArrayList<>();
    }

    // Phương thức thêm dữ liệu bằng cách thủ công
    // Phương thức này chỉ là tạm thời để thay thế cho cách thêm bằng cách nhập dữ
    // liệu từ người dùng
    public void add() {
        String[] chapterTitle = { "first", "middle", "last" };
        int[] chapterPageNumber = { 56, 75, 60 };

        addMagazine(1, "Fashion is Person", 14, 2012, "Tri Nguyen", 10000, "God is stupid");
        addReferenceBook(2, "HOW TO GET PRO DEV?", 2022, "Tri Nguyen", 142000, "Computer Sience", chapterTitle,
                chapterPageNumber);
    }

    // Thêm Sách Tham Khảo
    public void addReferenceBook(int id, String title, int publicationYear, String author,
            double price,
            String field, String[] chapterTitle, int[] chapterPageNumber) {

        ReferenceBook referenceBook = new ReferenceBook(id, title, publicationYear, author, price,
                field, chapterTitle, chapterPageNumber);
        referenceBookList.add(referenceBook);
        publicationList.add(referenceBook);
    }

    // Thêm Tạp Chí
    public void addMagazine(int id, String title, int pageNumber, int publicationYear, String author, double price,
            String name) {

        Magazine magazine = new Magazine(id, title, pageNumber, publicationYear, author, price,
                name);
        magazineList.add(magazine);
        publicationList.add(magazine);
    }

    // Kiểm tra xem Ấn Phẩm là Tạp Chí hay là Sách Tham Khảo
    public String checkPublicationType(int id) {
        String str = "Không tìm thấy ID!";
        for (Publication publication : publicationList) {
            if (publication.getId() == id)
                if (publication.getType() == PublicationType.MAGAZINE)
                    str = "Ấn Phẩm Này Là Tạp Chí!!";
                else
                    str = "Ấn Phẩm Này Là Sách Tham Khảo!!";

        }
        return str;
    }

    // Kiểm tra ấn phẩm có thuộc loại nào và năm xuất bản của nó
    public boolean checkPublicationTypeAndYear(int id, PublicationType pt, int year) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        for (Publication publication : publicationList) {
            if (publication.getId() == id)
                if (publication.getType() == pt && currentYear - publication.getPublicationYear() == year)
                    return true;
        }

        return false;
    }

    // So sánh hai ấn phẩm có cùng loại hay không
    public boolean comparePublication(int id1, int id2) {
        PublicationType pt = null;
        for (Publication publication : publicationList) {
            if (publication.getId() == id1)
                pt = publication.getType();
            if (publication.getId() == id2)
                if (pt == publication.getType())
                    return true;
        }

        return false;
    }

    // Lấy ra tổng tiền tất cả các ấn phẩm có trong danh sách
    public long getTotalPrice() {
        long l = 0L;
        for (Publication publication : publicationList) {
            l += publication.getPrice();
        }
        return l;
    }

    // Tìm quyển sách tham khảo có nhiều chương nhất
    public ReferenceBook method7() {
        int pageNumber = 0;
        for (ReferenceBook referenceBook : referenceBookList) {
            for (ReferenceBook.Chapter rChapter : referenceBook.getChapterList()) {
                if (rChapter.getPageNumber() > pageNumber) {
                    pageNumber = rChapter.getPageNumber();
                    return referenceBook;
                }
            }
        }
        return null;
    }

    // Tìm trong danh sách các ấn phẩm chứa một tạp chí có tên cho trước
    public Magazine findMagazineWithName(String magazineName) {
        for (Magazine magazine : magazineList) {
            if (magazine.getName() == magazineName)
                return magazine;
        }
        return null;
    }

    // Lấy ra danh sách các tạp chí được xuất bản vào 1 năm cho trước
    public ArrayList<Magazine> getMagazinesWithYear(int year) {
        ArrayList<Magazine> mList = new ArrayList<>(magazineList);
        Iterator<Magazine> it = mList.iterator();

        while (it.hasNext()) {
            int x = it.next().getPublicationYear();
            if (x != year)
                it.remove();
        }
        return mList;
    }

    // Sắp xếp danh sách tăng dần theo tiêu đề
    public void sortByTitle_ASC() {
        Collections.sort(publicationList, new SortByTitle_ASC());
    }

    // Sắp xếp danh sách giảm dần theo năm xuất bản
    public void sortByPYear_DES() {
        Collections.sort(publicationList, new SortByPYear_DES());
    }

    // Thống kê số lượng ấn phẩm theo năm xuất bản. Ví dụ 2020: 5, 2021: 10, ...năm
    // 2020 có 5 ấn phẩm, năm 2021 có 10 ấn phẩm.
    public HashMap<Integer, Integer> countPublicationByYears(int startYear, int endYear) {
        HashMap<Integer, Integer> publicationByYear = new HashMap<Integer, Integer>();
        int count = 0;

        for (int i = startYear; i <= endYear; i++) {

            for (Publication publication : publicationList) {
                if (publication.getPublicationYear() == i)
                    count++;
            }
            publicationByYear.put(i, count);
            count = 0;
        }
        return publicationByYear;
    }

    // Xuất ra danh sách các ấn phẩm
    public void print() {
        for (Publication publication : publicationList) {
            if (publication.getType() == PublicationType.REFERENCEBOOK)
                System.out.println(toString((ReferenceBook) publication));
            if (publication.getType() == PublicationType.MAGAZINE)
                System.out.println(toString((Magazine) publication));
        }
    }

    // Chuyển đổi đối tượng thành String
    public static String toString(Magazine magazine) {
        return "ID: " + magazine.getId() + " | Title: " + magazine.getTitle()
                + " | Total Number Of Page: "
                + magazine.getPageNumber()
                + " | Publication Year: " + magazine.getPublicationYear() + " | Author: "
                + magazine.getAuthor()
                + " | Price: " + magazine.getPrice()
                + " | Magazine Name: " + magazine.getName();
    }

    // Chuyển đổi đối tượng thành String
    public static String toString(ReferenceBook referenceBook) {
        String chaps = "";

        for (ReferenceBook.Chapter rChapter : referenceBook.getChapterList())
            chaps += rChapter.getTitle() + " - " + rChapter.getPageNumber() + " pages, ";

        chaps = chaps.substring(0, chaps.length() - 2);

        return "ID: " + referenceBook.getId() + " | Title: " + referenceBook.getTitle()
                + " | Total Number Of Page: "
                + referenceBook.getPageNumber()
                + " | Publication Year: " + referenceBook.getPublicationYear() + " | Author: "
                + referenceBook.getAuthor()
                + " | Price: " + referenceBook.getPrice()
                + " | Field: " + referenceBook.getField() + " | Chapters: " + chaps;
    }

    // Chuyển đổi danh sách các đối tượng thành String
    public static String toStringRBList(ArrayList<ReferenceBook> referenceBooks) {
        String str = "";
        for (ReferenceBook referenceBook : referenceBooks) {
            str += toString(referenceBook) + "\n";
        }
        return str;
    }

    // Chuyển đổi danh sách các đối tượng thành String
    public static String toStringMList(ArrayList<Magazine> magazines) {
        String str = "";
        for (Magazine magazine : magazines) {
            str += toString(magazine) + "\n";
        }
        return str;
    }

    // Tạo giao diện để xuất danh sách các ấn phẩm
    public void createGUI() {
        String col[] = { "ID", "Title", "Page Number", "Publication Year", "Author", "Price", "PublicationType",
                "Magazine Name", "RBook Field", "Chapter Title", "Chapter PageNumber" };

        JFrame frame = new JFrame();
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        for (Publication publication : publicationList) {
            String id = String.valueOf(publication.getId());
            String title = publication.getTitle();
            String pageNumber = String.valueOf(publication.getPageNumber());
            String publicationYear = String.valueOf(publication.getPublicationYear());
            String author = publication.getAuthor();
            String price = String.valueOf(publication.getPrice());
            String type = "";

            String magazineName = "";
            String field = "";
            String chapterTitle = "";
            String chapterPageNumber = "";

            if (publication.getType() == PublicationType.MAGAZINE) {
                magazineName = ((Magazine) publication).getName();
                type = "Magazine";
                String[] data = { id, title, pageNumber, publicationYear, author, price, type, magazineName };
                tableModel.addRow(data);
            }

            else if (publication.getType() == PublicationType.REFERENCEBOOK) {

                field = ((ReferenceBook) publication).getField();
                type = "Reference Book";

                ReferenceBook rb = (ReferenceBook) publication;
                int count = 0;
                for (ReferenceBook.Chapter chapter : rb.getChapterList()) {
                    chapterTitle += chapter.getTitle();
                    chapterPageNumber += String.valueOf(chapter.getPageNumber());

                    count++;
                    if (count == rb.getChapterList().size())
                        break;
                    chapterTitle += ", ";
                    chapterPageNumber += ", ";
                }

                String[] data = { id, title, pageNumber, publicationYear, author, price, type, null, field,
                        chapterTitle, chapterPageNumber };
                tableModel.addRow(data);
            }
        }

        frame.add(scrollPane);

        frame.setTitle("Danh Sách Ấn Phẩm");
        table.setBounds(30, 40, 600, 300);
        frame.setBounds(70, 70, 1200, 600);
        frame.setVisible(true);
    }
}