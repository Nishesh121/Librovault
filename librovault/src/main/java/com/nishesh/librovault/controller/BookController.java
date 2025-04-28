package com.nishesh.librovault.controller;

import com.nishesh.librovault.model.Book;
import com.nishesh.librovault.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Create a new Book
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book savedBook = bookService.saveBook(book);
        return ResponseEntity.ok(savedBook);
    }

    // Get all Books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    // Get a Book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id)
                .map(book -> ResponseEntity.ok(book))
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a Book by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    // Get Books by Author
    @GetMapping("/author")
    public ResponseEntity<List<Book>> getBooksByAuthor(@RequestParam String name) {
        List<Book> books = bookService.getBooksByAuthor(name);
        return ResponseEntity.ok(books);
    }

    // Get Books by Genre
    @GetMapping("/genre")
    public ResponseEntity<List<Book>> getBooksByGenre(@RequestParam String name) {
        List<Book> books = bookService.getBooksByGenre(name);
        return ResponseEntity.ok(books);
    }

    // Get Books by Price Range
    @GetMapping("/price")
    public ResponseEntity<List<Book>> getBooksByPriceRange(
            @RequestParam Double min,
            @RequestParam Double max) {
        List<Book> books = bookService.getBooksByPriceRange(min, max);
        return ResponseEntity.ok(books);
    }
}
