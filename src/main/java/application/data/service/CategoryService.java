package application.data.service;

import application.data.model.Category;
import application.data.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> getCategories(){
        return repository.findAll();
    }

    public Category getById(int id){
        return repository.findOne(id);
    }

    public void add(Category category){
        repository.save(category);
    }

    public void delete(int id){
        repository.delete(id);
    }

}
