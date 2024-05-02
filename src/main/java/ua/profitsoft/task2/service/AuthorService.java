package ua.profitsoft.task2.service;

import org.springframework.stereotype.Service;
import ua.profitsoft.task2.exceptions.ResourceNotFoundException;
import ua.profitsoft.task2.model.data.Author;
import ua.profitsoft.task2.repository.AuthorRepository;

import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public Optional<Author> findByName(String name) {
        return authorRepository.findByName(name);
    }

    public Author update(Long id, Author authorDetails) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found"));
        author.setName(authorDetails.getName());
        return authorRepository.save(author);
    }

    public void delete(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found"));
        authorRepository.delete(author);
    }
}
