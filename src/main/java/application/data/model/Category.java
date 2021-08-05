package application.data.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "tbl_category")
public class Category {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Id
    private int id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<BookCategory> bookCategoryList = new ArrayList<>();

    @Column(name="name")
    private String name;

    public List<BookCategory> getBookCategoryList() {
        return bookCategoryList;
    }

    public void setBookCategoryList(List<BookCategory> bookCategoryList) {
        this.bookCategoryList = bookCategoryList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "created_date")
    private Date createdDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
