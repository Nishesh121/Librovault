package com.nishesh.librovault.service;

import com.nishesh.librovault.model.Book;
import com.nishesh.librovault.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> getBooksByAuthor(String name) {
        return bookRepository.findByAuthorIgnoreCase(name);
    }

    public List<Book> getBooksByGenre(String name) {
        return bookRepository.findByGenreIgnoreCase(name);
    }

    public List<Book> getBooksByPriceRange(Double min, Double max) {
        return bookRepository.findByPriceBetween(min, max);
    }

    public List<String> getAllAuthors() {
        return bookRepository.findDistinctAuthors();
    }

    public List<String> getAllGenres() {
        return bookRepository.findDistinctGenres();
    }
}
