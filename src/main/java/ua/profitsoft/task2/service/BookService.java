package ua.profitsoft.task2.service;

import org.springframework.stereotype.Service;
import ua.profitsoft.task2.exceptions.ResourceNotFoundException;
import ua.profitsoft.task2.model.data.Author;
import ua.profitsoft.task2.model.data.BookDAO;
import ua.profitsoft.task2.model.dto.BookDto;
import ua.profitsoft.task2.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookDAO save(BookDto book) {
        BookDAO bookDAO = toBookDAO(book);
        return bookRepository.save(bookDAO);
    }

    public Optional<BookDAO> findById(Long id) {
        return bookRepository.findById(id);
    }

    public List<BookDAO> findByAuthor(Author author) {
        return bookRepository.findByAuthor(author);
    }

    public BookDAO update(Long id, BookDAO bookDAODetails) {
        BookDAO bookDAO = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        bookDAO.setTitle(bookDAODetails.getTitle());
        bookDAO.setYearPublished(bookDAODetails.getYearPublished());
        bookDAO.setGenre(bookDAODetails.getGenre());
        bookDAO.setAuthor(bookDAODetails.getAuthor());
        return bookRepository.save(bookDAO);
    }

    public void delete(Long id) {
        BookDAO bookDAO = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        bookRepository.delete(bookDAO);
    }

    private BookDAO toBookDAO(BookDto bookDto) {
        return BookDAO.builder()
                .author(bookDto.getAuthor())
                .genre(bookDto.getGenre())
                .title(bookDto.getTitle())
                .yearPublished(bookDto.getYearPublished())
                .build();
    }
}
