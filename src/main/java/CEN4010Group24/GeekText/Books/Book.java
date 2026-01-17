package CEN4010Group24.GeekText.Books;

//NOTE: using region NAME endregion to compress code in IntelliJ IDE
//AI Usage: None
public class Book {
    //ALL THE INFORMATION VARIABLES FOR BOOKS
    long bookISBN;
    String bookName;
    String bookDescription;
    float bookPrice;
    String bookAuthor;
    String bookGenre;
    String bookPublisher;
    int bookYearPublished;
    int bookCopiesSold;

    //basic Constructor
    public Book(){

    }
    //book Constructor for All Information
    public Book(long bookISBN, String bookName,
                String bookDescription, float bookPrice, String bookAuthor,
                String bookGenre, String bookPublisher, int bookYearPublished, int bookCopiesSold) {

        this.bookISBN = bookISBN;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.bookPrice = bookPrice;
        this.bookAuthor = bookAuthor;
        this.bookGenre = bookGenre;
        this.bookPublisher = bookPublisher;
        this.bookYearPublished = bookYearPublished;
        this.bookCopiesSold = bookCopiesSold;

    }

    //region Getters
    public long getBookISBN() {
        return bookISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public float getBookPrice() {
        return bookPrice;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public int getBookYearPublished() {
        return bookYearPublished;
    }

    public int getBookCopiesSold() {
        return bookCopiesSold;
    }
    //endregion

    //region Setters
    public void setBookISBN(long bookISBN) {
        this.bookISBN = bookISBN;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public void setBookPrice(float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public void setBookYearPublished(int bookYearPublished) {
        this.bookYearPublished = bookYearPublished;
    }

    public void setBookCopiesSold(int bookCopiesSold) {
        this.bookCopiesSold = bookCopiesSold;
    }
    //endregion

    @Override
    public String toString() {
        return "Book{" +
                "bookISBN=" + bookISBN +
                ", bookName='" + bookName + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookGenre='" + bookGenre + '\'' +
                ", bookPublisher='" + bookPublisher + '\'' +
                ", bookYearPublished=" + bookYearPublished +
                ", bookCopiesSold=" + bookCopiesSold +
                '}';
    }
}
