package application.data.repository;

import application.data.model.BookRank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRankRepository extends JpaRepository<BookRank,Integer> {

    @Query("select br from tbl_book_rank br where br.id = :id")
    BookRank findById(@Param("id") int id);
}
