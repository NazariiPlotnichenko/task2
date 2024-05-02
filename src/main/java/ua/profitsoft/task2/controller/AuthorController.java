package ua.profitsoft.task2.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.profitsoft.task2.exceptions.ResourceNotFoundException;
import ua.profitsoft.task2.model.data.Author;
import ua.profitsoft.task2.service.AuthorService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @PostMapping
    public Author createAuthor(@Valid @RequestBody Author author) {
        return authorService.save(author);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        Author author = authorService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found"));
        return ResponseEntity.ok().body(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @Valid @RequestBody Author authorDetails) {
        Author updatedAuthor = authorService.update(id, authorDetails);
        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteAuthor(@PathVariable Long id) {
        authorService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
