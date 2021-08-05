package application.model.dto;

import javax.persistence.Column;
import java.util.Date;

public class BookRankDTO {

    private int id;

    private int rank;

    private double price;

    private Date createdDate;

    private String createdBy;


    public BookRankDTO(){};

    public BookRankDTO(int id, int rank, double price, Date createdDate, String createdBy) {
        this.id = id;
        this.rank = rank;
        this.price = price;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
