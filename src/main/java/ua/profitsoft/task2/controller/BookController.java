package ua.profitsoft.task2.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.profitsoft.task2.exceptions.ResourceNotFoundException;
import ua.profitsoft.task2.model.data.BookDAO;
import ua.profitsoft.task2.model.dto.BookDto;
import ua.profitsoft.task2.service.BookService;

import java.util.HashMap;
import java.util.Map;
//import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/book")
public class BookController {
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public RestResponse createUser(@RequestBody BookDto bookDto) {
//        int id = bookService.createBook(bookDto);
//        return new RestResponse(String.valueOf(id));
//    }
    @Autowired
    private BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDAO createBook(@Valid @RequestBody BookDto book) {
        return bookService.save(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDAO> getBookById(@PathVariable Long id) {
        BookDAO bookDAO = bookService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        return ResponseEntity.ok().body(bookDAO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDAO> updateBook(@PathVariable Long id, @Valid @RequestBody BookDAO bookDAODetails) {
        BookDAO updatedBookDAO = bookService.update(id, bookDAODetails);
        return ResponseEntity.ok(updatedBookDAO);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
