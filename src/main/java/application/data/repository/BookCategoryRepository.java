package application.data.repository;

import application.data.model.BookAuthor;
import application.data.model.BookCategory;
import application.model.dto.BookCategoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory,Integer> {


    @Query("select new application.model.dto.BookCategoryDTO(bc.categoryId) " +
            "from tbl_book_category bc " +
            "where bc.bookId = :bookId")
    List<BookCategoryDTO> getBookCategoryByBook(@Param("bookId") int bookId);

    @Transactional
    @Modifying
    @Query("delete from tbl_book_category bc " +
            "where bc.bookId = :bookId")
    void deleteByBook(@Param("bookId") int bookId);

    


}
