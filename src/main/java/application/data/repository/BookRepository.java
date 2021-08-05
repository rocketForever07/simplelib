package application.data.repository;


import application.data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {


    @Query("select count(b.id) from tbl_book b")
    long getTotalBooks();

}
