package application.data.repository;

import application.data.model.BookAuthor;
import application.model.dto.BookAuthorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BookAuthorRepository extends JpaRepository<BookAuthor, Integer> {

    @Query("select new application.model.dto.BookAuthorDTO(ba.authorId) " +
            "from tbl_book_author ba " +
            "where ba.bookId = :bookId")
    List<BookAuthorDTO> getBookAuthorByBook(@Param("bookId") int bookId);

    @Transactional
    @Modifying
    @Query("delete from tbl_book_author ba " +
            "where ba.bookId = :bookId"
    )
    void deleteByBook(@Param("bookId") int bookId);

}
