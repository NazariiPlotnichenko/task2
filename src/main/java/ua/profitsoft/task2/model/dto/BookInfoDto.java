package ua.profitsoft.task2.model.dto;

import jakarta.persistence.ManyToOne;
import ua.profitsoft.task2.model.data.Author;

public class BookInfoDto {
    private Long id;
    private Author author;
    private String title;
    private int yearPublished;
    private String genre;
}
