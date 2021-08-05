package application.data.service;

import application.data.model.Book;
import application.data.model.BookAuthor;
import application.data.model.BookCategory;
import application.data.repository.BookAuthorRepository;
import application.data.repository.BookCategoryRepository;
import application.model.dto.BookAuthorDTO;
import application.model.dto.BookCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCategoryService {

    @Autowired
    private BookCategoryRepository bookCategoryRepository;



    public BookCategory findById(int id){
        return bookCategoryRepository.findOne(id);
    }

    public List<BookCategoryDTO> getBookCategoryByBook(int bookId) throws Exception{


        try{
            return bookCategoryRepository.getBookCategoryByBook(bookId);
        }catch (Exception e){
            throw e;
        }
    }


    public boolean insert(BookCategory bookCategory){
        try {
            bookCategoryRepository.save(bookCategory);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public void deleteByBookId(int bookId){
        bookCategoryRepository.deleteByBook(bookId);
    }
}
