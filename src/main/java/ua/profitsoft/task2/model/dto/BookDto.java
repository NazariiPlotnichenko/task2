package ua.profitsoft.task2.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;
import ua.profitsoft.task2.model.data.Author;

@Jacksonized
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    @NotBlank(message = "Author is required")
    private Author author;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Year of publishing is required")
    private int yearPublished;

    @NotBlank(message = "Genre is required")
    private String genre;
}
