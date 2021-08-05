package application.controller.api;

import application.data.model.Author;
import application.data.service.AuthorService;
import application.model.api.DataApiResult;
import application.model.dto.AuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController("/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("")
    public DataApiResult getAuthors(){

        DataApiResult result=new DataApiResult();

        List<Author> authors=authorService.getAuthor();

        List<AuthorDTO> dtoList=new ArrayList<>();
        for(Author author: authors){

            AuthorDTO dto=new AuthorDTO(author.getId(),author.getFullName(),author.getNickName(),author.getDoB());
            dtoList.add(dto);
        }

        result.setData(dtoList);
        result.setMessage("Done");

        return result;
    }

    @GetMapping("/{id}")
    public DataApiResult getDetail(@PathVariable int id){

        DataApiResult result=new DataApiResult();

        Author author=authorService.getById(id);

        if(author == null){
            result.setMessage("some error");
        }else {
            AuthorDTO dto=new AuthorDTO(author.getId(),author.getFullName(),author.getNickName(),author.getDoB());
            result.setData(dto);
            result.setMessage("done");

        }

        return result;
    }

    @PostMapping("")
    public DataApiResult addAuthor(@RequestBody AuthorDTO authorDTO){

        DataApiResult result=new DataApiResult();

        Author author=new Author();
        author.setFullName(authorDTO.getFullName());
        author.setNickName(authorDTO.getNickName());
        author.setDoB(authorDTO.getDoB());

        authorService.add(author);

        result.setData(author);
        result.setSuccess(true);

        return result;
    }

    @PutMapping("/{id}")
    public DataApiResult editAuthor(@PathVariable int id,@RequestBody AuthorDTO authorDTO){

        DataApiResult result=new DataApiResult();

        Author author=authorService.getById(id);

        if(author == null){
            result.setMessage("some error");
        }else {
            author.setFullName(authorDTO.getFullName());
            author.setNickName(authorDTO.getNickName());
            author.setDoB(authorDTO.getDoB());

            authorService.add(author);
            result.setData(author);
            result.setSuccess(true);
        }

        return result;
    }

    @DeleteMapping("/{id}")
    public DataApiResult removeAuthor(@PathVariable int id){
        DataApiResult result=new DataApiResult();

        Author author=authorService.getById(id);

        if(author == null){
            result.setMessage("some error");
        }else {

            authorService.delete(id);
            result.setMessage("Done");
            result.setSuccess(true);
        }

        return result;

    }
}
