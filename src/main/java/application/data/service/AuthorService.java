package application.data.service;

import application.data.model.Author;
import application.data.model.Category;
import application.data.repository.AuthorRepository;
import application.data.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    public List<Author> getAuthor(){
        return repository.findAll();
    }

    public Author getById(int id){
        return repository.findOne(id);
    }

    public void add(Author author){
        repository.save(author);
    }

    public void delete(int id){
        repository.delete(id);
    }
}
