package ua.profitsoft.task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.profitsoft.task2.model.data.Author;
import ua.profitsoft.task2.model.data.BookDAO;

import java.util.List;

public interface BookRepository extends JpaRepository<BookDAO, Long> {
    List<BookDAO> findByAuthor(Author author);
}
