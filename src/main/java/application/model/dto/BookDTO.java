package application.model.dto;

import application.data.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookDTO {

    private int id;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String name;

    private String imgLink;

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    private int quantity;

    private String shortDesc;

    private String detailDesc;

    private Date yearOfPublic;

    private int publisherId;

    private String publisherName;

    private int bookRankId;

    private int languageId;

    private String languageName;

    private List<BookAuthorDTO> authorList=new ArrayList<>();

    private List<BookCategoryDTO> categoryList=new ArrayList<>();

    private List<BorrowBookDTO> borrowList=new ArrayList<>();

    private Language language;

    private BookRank bookRank;

    private Publisher publisher;

    //-----getter setter

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

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<BookAuthorDTO> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<BookAuthorDTO> authorList) {
        this.authorList = authorList;
    }

    public List<BookCategoryDTO> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<BookCategoryDTO> categoryList) {
        this.categoryList = categoryList;
    }

    public List<BorrowBookDTO> getBorrowBookList() {
        return borrowList;
    }

    public void setBorrowBookList(List<BorrowBookDTO> borrowBookList) {
        this.borrowList = borrowBookList;
    }

    public BookRank getBookRank() {
        return bookRank;
    }

    public void setBookRank(BookRank bookRank) {
        this.bookRank = bookRank;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public int getBookRankId() {
        return bookRankId;
    }

    public void setBookRankId(int bookRankId) {
        this.bookRankId = bookRankId;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
}
