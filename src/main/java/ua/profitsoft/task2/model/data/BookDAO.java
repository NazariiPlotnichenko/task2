package ua.profitsoft.task2.model.data;

import jakarta.persistence.*;
import lombok.*;


@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BookDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Author author;

    private String title;
    private int yearPublished;
    private String genre;

}
