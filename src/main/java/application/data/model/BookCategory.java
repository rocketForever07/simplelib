package application.data.model;


import javax.persistence.*;

@Entity(name = "tbl_book_category")
public class BookCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne(optional = true)
    private Book book;

    @Column(name = "book_id",insertable = false,updatable = false)
    private int bookId;

    @ManyToOne(optional = true)
    private Category category;

    @Column(name = "category_id",insertable = false,updatable = false)
    private int categoryId;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }
}
