package com.libary.my.repository;

import com.libary.my.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    @Query("SELECT b FROM Book b WHERE b.isbn = :isbn AND (b.title != :title OR b.author != :author)")
    List<Book> findBooksWithSameIsbnDifferentTitleOrAuthor(@Param("isbn") String isbn, @Param("title") String title, @Param("author")String author);
}
