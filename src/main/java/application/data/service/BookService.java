package application.data.service;

import application.data.model.Book;
import application.data.repository.BookRepository;
import application.model.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> getBooksList(){

        return repository.findAll();

    }

    public Book getById(int id){
        return repository.findOne(id);
    }

    public boolean addNewBook(Book book) throws Exception{
        try {
            repository.save(book);
            return true;
        }catch (Exception e){
            throw e;
        }

    }

    public boolean editBook(Book book) throws Exception{
        try {
            repository.save(book);
            return true;
        }catch (Exception e){
            throw e;
        }

    }

    public boolean delete(int id){
        if(repository.findOne(id) != null){
            repository.delete(id);
            return true;
        }else{
            return false;
        }
    }

//    public long getTotalBookByNameAndCategoryAndPublisher(String bookName, int cateId,int publisherId){
//        return repository.getTotalBookByNameAndCategoryAndPublisher(cateId,bookName,publisherId);
//    }

//    public List<Book> getBooksByCategory(int cateId){
//
//    }


}
