package application.data.service;

import application.data.model.BookAuthor;
import application.data.repository.BookAuthorRepository;
import application.data.repository.BookRepository;
import application.model.dto.BookAuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookAuthorService {

    @Autowired
    private BookAuthorRepository bookAuthorRepository;


    public List<BookAuthorDTO> getBookAuthorByBook(int id){
        return bookAuthorRepository.getBookAuthorByBook(id);
    }

    public boolean insert(BookAuthor bookAuthor){
        try{
            bookAuthorRepository.save(bookAuthor);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public void deleteByBookId(int bookId){

         bookAuthorRepository.deleteByBook(bookId);
    }
}
