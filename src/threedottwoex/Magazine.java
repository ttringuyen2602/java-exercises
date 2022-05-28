package threedottwoex;

class Magazine extends Publication {
    private String name;

    public Magazine() {
        super(2);
    }

    public Magazine(int id, String title, int pageNumber, int publicationYear, String author, double price,
            String name) {
        super(id);
        this.title = title;
        this.pageNumber = pageNumber;
        this.publicationYear = publicationYear;
        this.author = author;
        this.price = price;
        this.name = name;
    }

    public Magazine(Magazine magazine) {
        super(magazine.getId());
        this.title = magazine.title;
        this.pageNumber = magazine.pageNumber;
        this.publicationYear = magazine.publicationYear;
        this.author = magazine.author;
        this.price = magazine.price;
        this.name = magazine.name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PublicationType getType() {
        return PublicationType.MAGAZINE;
    }
}