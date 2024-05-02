package ua.profitsoft.task2.model.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    // інші поля...

    @OneToMany(mappedBy = "author")
    private List<BookDAO> bookDAOS;
}
