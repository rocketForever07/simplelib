package application.model.dto;

import application.data.model.Book;
import application.data.model.Category;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

public class BookCategoryDTO {

    private int categoryId;

    public BookCategoryDTO(){};
    public BookCategoryDTO(int categoryId) {
        this.categoryId = categoryId;
    }


    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

}
