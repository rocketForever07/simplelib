package application.data.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "tbl_book")
public class Book {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Id
    private int id;

    @Column(name = "code")
    private String code;


    @Column(name = "name")
    private String name;

    @Column(name="img_link")
    private String imgLink;


    @Column(name = "quantity")
    private int quantity;

    @Column(name = "short_desc")
    private String shortDesc;

    @Column(name = "detai_desc")
    private String detailDesc;

    @Column(name = "year_of_public")
    private Date yearOfPublic;

    @Column(name = "publisher_id",insertable = false,updatable = false)
    private int publisherId;

    @Column(name = "book_rank_id" ,insertable = false,updatable = false)
    private int bookRankId;

    @Column(name = "language_id",insertable = false,updatable = false)
    private int languageId;

    /*
    * relation table
    * */

    //one to many with book_author
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
    private List<BookAuthor> bookAuthorList=new ArrayList<>();

    //one to many with book_category
    @OneToMany(mappedBy = "book")
    private List<BookCategory> bookCategoryList=new ArrayList<>();


    //one to many with borrow_book
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "book")
    private List<BorrowBook> borrowBookList=new ArrayList<>();

    // -------------many t one

    //many to one with book_rank
    @ManyToOne(optional = true)
    private BookRank bookRank;

    //many to one with publisher
    @ManyToOne
    private Publisher publisher;

    //many to on with language
    @ManyToOne(optional = true)
    private Language language;

    /*
    * end relation table
    * */


    //getter setter
    public List<BookCategory> getBookCategoryList() {
        return bookCategoryList;
    }

    public void setBookCategoryList(List<BookCategory> bookCategoryList) {
        this.bookCategoryList = bookCategoryList;
    }


    public List<BookAuthor> getBookAuthorList() {
        return bookAuthorList;
    }

    public void setBookAuthorList(List<BookAuthor> bookAuthorList) {
        this.bookAuthorList = bookAuthorList;
    }

    public List<BorrowBook> getBorrowBookList() {
        return borrowBookList;
    }

    public void setBorrowBookList(List<BorrowBook> borrowBookList) {
        this.borrowBookList = borrowBookList;
    }

    public BookRank getBookRank() {
        return bookRank;
    }

    public void setBookRank(BookRank bookRank) {
        this.bookRank = bookRank;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }

    public Date getYearOfPublic() {
        return yearOfPublic;
    }

    public void setYearOfPublic(Date yearOfPublic) {
        this.yearOfPublic = yearOfPublic;
    }

    public int getBookRankId() {
        return bookRankId;
    }

    public void setBookRankId(int bookRankId) {
        bookRankId = bookRankId;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    //end getter setter

}
