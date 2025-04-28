package com.nishesh.librovault.repository;

import com.nishesh.librovault.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // Find books by author name (ignoring case)
    List<Book> findByAuthorIgnoreCase(String author);

    // Find books by genre name (ignoring case)
    List<Book> findByGenreIgnoreCase(String genre);

    // Find books within a price range
    List<Book> findByPriceBetween(Double min, Double max);

    // Find distinct authors
    @Query("SELECT DISTINCT b.author FROM Book b")
    List<String> findDistinctAuthors();

    // Find distinct genres
    @Query("SELECT DISTINCT b.genre FROM Book b")
    List<String> findDistinctGenres();
}
