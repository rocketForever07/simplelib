package application.model.dto;

import application.data.model.Author;
import application.data.model.Book;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

public class BookAuthorDTO {


    private int authorId;



    public BookAuthorDTO() {

    }

    public BookAuthorDTO(int authorId) {

        this.authorId = authorId;
    }


    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

}
