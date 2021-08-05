package application.mapper;

import application.data.model.Book;
import application.data.model.BookCategory;
import application.model.dto.BookCategoryDTO;
import application.model.dto.BookDTO;

public class Mapper {


    public BookDTO bookToDto(Book book){

        BookDTO bookDTO=new BookDTO();

        bookDTO.setId(book.getId());
        bookDTO.setCode(book.getCode());
        bookDTO.setName(book.getName());
        bookDTO.setQuantity(book.getQuantity());
        bookDTO.setBookRankId(book.getBookRank().getId());
        bookDTO.setLanguageId(book.getLanguage().getId());
        bookDTO.setPublisherId(book.getPublisher().getId());
        bookDTO.setShortDesc(book.getShortDesc());
        bookDTO.setDetailDesc(book.getDetailDesc());
        bookDTO.setYearOfPublic(book.getYearOfPublic());

        return bookDTO;

    }


    public void transfer(Book book1, BookDTO book2){
        book1.setCode(book2.getCode());
        book1.setName(book2.getName());
        book1.setQuantity(book2.getQuantity());
        book1.setBookRankId(book2.getBookRank().getId());
        book1.setLanguageId(book2.getLanguage().getId());
        book1.setPublisherId(book2.getPublisher().getId());
        book1.setShortDesc(book2.getShortDesc());
        book1.setDetailDesc(book2.getDetailDesc());
        book1.setYearOfPublic(book2.getYearOfPublic());
    }

    public Book dtoToBook(BookDTO bookDTO){



        Book book=new Book();


        book.setName(bookDTO.getName());
        book.setCode(bookDTO.getCode());
        book.setQuantity(bookDTO.getQuantity());
        book.setBookRankId(bookDTO.getBookRankId());
        book.setLanguageId(bookDTO.getLanguageId());
        book.setPublisherId(bookDTO.getPublisherId());
        book.setShortDesc(bookDTO.getShortDesc());
        book.setDetailDesc(bookDTO.getDetailDesc());
        book.setYearOfPublic(bookDTO.getYearOfPublic());

        return book;
    }

    public BookCategoryDTO bookCategoryToDto(BookCategory bookCategory){

        BookCategoryDTO dto=new BookCategoryDTO();

        return dto;

    }


}
