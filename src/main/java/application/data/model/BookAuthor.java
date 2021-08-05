package application.data.model;


import javax.persistence.*;

@Entity(name = "tbl_book_author")
public class BookAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    @Column(name = "book_id" , insertable = false, updatable = false)
    private int bookId;

    @ManyToOne(fetch = FetchType.LAZY,optional = true)
    private Author author;

    @Column(name = "author_id" , insertable = false, updatable = false)
    private int authorId;

    @Column(name = "short_desc")
    private String shortDesc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }
}
