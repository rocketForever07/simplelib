package application.data.repository;


import application.data.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {


    @Query("select count(b.id) from tbl_book b")
    long getTotalBooks();

//    @Query("select count(b.id) from tbl_book b " +
//            "inner join b.ca" +
//            "where bc.categoryId=:cateId")
////
//    @Query(
//            value = "SELECT * FROM dbo_product " +
//                    "ORDER BY created_date DESC " +
//                    "limit 3",
//            nativeQuery = true)
//    long getAmountByCategoryId(@Param("cateId") int cateId);

//    @Query("SELECT sum(b.quantity) FROM tbl_book b " +
//            "join tbl_book_category bc on bc.bookId=b.id "+
//            "join tbl_book_author ba on ba.bookId=b.id "+
//            "WHERE (:categoryId IS NULL OR (bc.categoryId = :categoryId)) " +
//            "AND (:bookName IS NULL OR UPPER(b.name) LIKE CONCAT('%',UPPER(:bookName),'%')) "+
//            "AND (:publisherId IS NULL OR (b.publisherId = :publisherId))")
//    long getTotalBookByNameAndCategoryAndPublisher(            @Param("categoryId") Integer categoryId,
//                                                               @Param("bookName") String bookName,
//                                                               @Param("publisherId") Integer publisherId);

}
