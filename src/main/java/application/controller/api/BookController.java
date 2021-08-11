package application.controller.api;

import application.data.model.*;
import application.data.repository.*;
import application.data.service.*;
import application.mapper.Mapper;
import application.model.api.BaseApiResult;
import application.model.api.DataApiResult;
import application.model.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookAuthorService bookAuthorService;

    @Autowired
    private BookCategoryService bookCategoryService;

    @Autowired
    private BookRankRepository bookRankRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorRepository authorRepository;


    private Mapper mapper=new Mapper();


    //get list book from db
    @GetMapping(value = "")
    public BaseApiResult getBooks(){


        DataApiResult result=new DataApiResult();

        try {
            List<Book> bookList = bookService.getBooksList();
            List<BookDTO> dtoList = new ArrayList<>();


            if (bookList != null) {

                bookList.forEach(book -> {
                    BookDTO dto = new BookDTO();
                    dto.setId(book.getId());
                    dto.setName(book.getName());

                    dtoList.add(dto);
                });
            }

            result.setMessage("done");
            result.setSuccess(true);
            result.setData(dtoList);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }


        return result;

    }

    @GetMapping("/{id}")
    public DataApiResult getBookById(@PathVariable int id){

        DataApiResult result=new DataApiResult();
        try{
            Book book = bookService.getById(id);
            List<BookAuthorDTO> bookAuthorDTOList=bookAuthorService.getBookAuthorByBook(id);
            List<BookCategoryDTO> bookCategoryDTOList=bookCategoryService.getBookCategoryByBook(id);

            BookDTO bookDTO= mapper.bookToDto(book);

            bookDTO.setAuthorList(bookAuthorDTOList);
            bookDTO.setCategoryList(bookCategoryDTOList);

            result.setData(bookDTO);
            result.setMessage("done");
            result.setSuccess(true);

        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }

        return result;

    }

//    @PostMapping("/getAmount")
//    public DataApiResult getAmontBy(@RequestBody GetAmountDTO dto) {
//
//        DataApiResult result = new DataApiResult();
//
//        long amount = bookService.getTotalBookByNameAndCategoryAndPublisher(dto.getBookName(), dto.getCateId(), dto.getPublisherId());
//        result.setData(amount);
//        result.setMessage("done");
//
//        return result;
//    }
    //thêm mới sách
    @PostMapping(value = "")
    public DataApiResult insertBook(@RequestBody BookDTO bookDTO){

        DataApiResult result=new DataApiResult();

        Book book=mapper.dtoToBook(bookDTO);
        //set cho book những quan hệ many to one
        book.setBookRank(bookRankRepository.findById(bookDTO.getBookRankId()));
        book.setLanguage(languageRepository.findOne(bookDTO.getLanguageId()));
        book.setPublisher(publisherRepository.findOne(bookDTO.getPublisherId()));

        //save book
        try {
            bookService.addNewBook(book);

            for(BookCategoryDTO dto:bookDTO.getCategoryList()){
                BookCategory bookCategory=new BookCategory();
                bookCategory.setBook(book);
                bookCategory.setCategory(categoryRepository.findOne(dto.getCategoryId()));
                bookCategoryService.insert(bookCategory);
            }

            for(BookAuthorDTO dto:bookDTO.getAuthorList()){
                BookAuthor bookAuthor=new BookAuthor();
                bookAuthor.setBook(book);
                bookAuthor.setAuthor(authorRepository.findOne(dto.getAuthorId()));
                bookAuthorService.insert(bookAuthor);
            }


            result.setMessage("done");
            result.setSuccess(true);
            result.setData(getBookById(book.getId()).getData());

        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
        }

        return result;
    }


    //sửa sách
    @PutMapping(value = "/{id}")
    public DataApiResult editBook(@PathVariable int id,@RequestBody BookDTO bookDTO){

        DataApiResult result=new DataApiResult();

        Book curBook=bookService.getById(id);
        if(curBook == null){
            result.setMessage("book's not found");

        }else {

            Book book = mapper.dtoToBook(bookDTO);
            book.setId(id);

            //set lại book những quan hệ many to one
            book.setBookRank(bookRankRepository.findById(bookDTO.getBookRankId()));
            book.setLanguage(languageRepository.findOne(bookDTO.getLanguageId()));
            book.setPublisher(publisherRepository.findOne(bookDTO.getPublisherId()));

            //save book
            try {
                bookService.editBook(book);

                //Xóa những quan hệ one to many cũ và set lại cho nó
                bookCategoryService.deleteByBookId(id);
                for (BookCategoryDTO dto : bookDTO.getCategoryList()) {
                    BookCategory bookCategory = new BookCategory();
                    bookCategory.setBook(curBook);
                    bookCategory.setCategory(categoryRepository.findOne(dto.getCategoryId()));
                    bookCategoryService.insert(bookCategory);
                }

                //
                bookAuthorService.deleteByBookId(id);
                for (BookAuthorDTO dto : bookDTO.getAuthorList()) {
                    BookAuthor bookAuthor = new BookAuthor();
                    bookAuthor.setBook(curBook);
                    bookAuthor.setAuthor(authorRepository.findOne(dto.getAuthorId()));
                    bookAuthorService.insert(bookAuthor);
                }

                result.setMessage("done");
                result.setSuccess(true);
                result.setData(getBookById(id).getData());

            } catch (Exception e) {
                result.setSuccess(false);
                result.setMessage(e.getMessage());
            }
        }

        return result;
    }

    //Xóa sách
    @DeleteMapping("/{id}")
    public DataApiResult remove(@PathVariable int id){
        DataApiResult result=new DataApiResult();

        boolean isDeleted=bookService.delete(id);
        result.setSuccess(isDeleted);
        if(isDeleted){
            result.setMessage("book "+id+" has deleted");
        }else{
            result.setMessage("some error");
        }

        return result;
    }

    @GetMapping("/config")
    public DataApiResult config(){

        DataApiResult result=new DataApiResult();

        for(Book book: bookService.getBooksList()){

        }

        return result;

    }

}
