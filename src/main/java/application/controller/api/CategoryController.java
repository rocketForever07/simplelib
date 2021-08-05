package application.controller.api;


import application.data.model.Category;
import application.data.service.CategoryService;
import application.model.api.DataApiResult;
import application.model.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/category")

public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public DataApiResult getCategories(){

        DataApiResult result=new DataApiResult();

        List<Category> categories=categoryService.getCategories();

        List<CategoryDTO> dtoList=new ArrayList<>();
        for(Category category: categories){

            CategoryDTO dto=new CategoryDTO();
            dto.setId(category.getId());
            dto.setName(category.getName());
            dtoList.add(dto);
        }

        result.setData(dtoList);
        result.setMessage("Done");

        return result;
    }

    @PostMapping("")
    public DataApiResult addNewCate(@RequestBody CategoryDTO categoryDTO){


        DataApiResult result=new DataApiResult();


        Category category=new Category();
        category.setName(categoryDTO.getName());
        category.setCreatedDate(new Date());

        categoryService.add(category);

        result.setData(category);
        result.setSuccess(true);

        return result;

    }

    @PutMapping("/{id}")
    public DataApiResult editCate(@PathVariable int id,@RequestBody CategoryDTO categoryDTO){
        DataApiResult result=new DataApiResult();

        Category curCategory=categoryService.getById(id);

        if(curCategory == null){
            result.setMessage("some error");
        }else {

            curCategory.setName(categoryDTO.getName());
            curCategory.setCreatedDate(new Date());

            categoryService.add(curCategory);

            result.setData(curCategory);
            result.setSuccess(true);
        }

        return result;

    }

    @DeleteMapping("/{id}")
    public DataApiResult deleteCate(@PathVariable int id){
        DataApiResult result=new DataApiResult();

        Category curCategory=categoryService.getById(id);

        if(curCategory == null){
            result.setMessage("some error");
        }else {

            categoryService.delete(id);
            result.setMessage("Done");
            result.setSuccess(true);
        }

        return result;

    }

}
