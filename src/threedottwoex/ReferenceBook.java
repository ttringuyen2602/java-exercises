package threedottwoex;

import java.util.ArrayList;

class ReferenceBook extends Publication {
    private String field;
    private Chapter chapter = new Chapter();
    private ArrayList<Chapter> chapterList = new ArrayList<>();

    public ReferenceBook() {
        super(0);
    }

    public ReferenceBook(int id, String title, int publicationYear,
            String author, double price, String field, String chapterTitle[], int chapterPageNumber[]) {
        super(id);

        this.title = title;
        this.publicationYear = publicationYear;
        this.author = author;
        this.price = price;
        this.field = field;

        for (int i = 0; i < chapterTitle.length; i++) {
            chapter = new Chapter(chapterTitle[i], chapterPageNumber[i]);
            chapterList.add(chapter);
        }

        for (Chapter chapter : chapterList)
            this.pageNumber += chapter.pageNumber;
    }

    public ReferenceBook(ReferenceBook refbook) {
        super(refbook.getId());
        this.title = refbook.title;
        this.pageNumber = refbook.pageNumber;
        this.publicationYear = refbook.publicationYear;
        this.author = refbook.author;
        this.price = refbook.price;
        this.field = refbook.field;
        this.chapter.title = refbook.chapter.title;
        this.chapter.pageNumber = refbook.chapter.pageNumber;
    }

    public String getField() {
        return this.field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public ArrayList<Chapter> getChapterList() {
        return this.chapterList;
    }

    public PublicationType getType() {
        return PublicationType.REFERENCEBOOK;
    }

    class Chapter {
        private String title;
        private int pageNumber;

        Chapter() {
        }

        Chapter(String title, int pageNumber) {
            this.title = title;
            this.pageNumber = pageNumber;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String chapterTitle) {
            this.title = chapterTitle;
        }

        public int getPageNumber() {
            return this.pageNumber;
        }

        public void setPageNumber(int chapterPageNumber) {
            this.pageNumber = chapterPageNumber;
        }
    }
}