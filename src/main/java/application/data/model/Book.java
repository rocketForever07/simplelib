package application.data.model;


import javax.persistence.*;
import java.util.Date;

@Entity(name = "tbl_book")
public class Book {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "short_desc")
    private String shortDesc;

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

    @Column(name = "detail_desc")
    private String detailDesc;

    @Column(name = "year_of_public")
    private Date yearOfPublic;





}
