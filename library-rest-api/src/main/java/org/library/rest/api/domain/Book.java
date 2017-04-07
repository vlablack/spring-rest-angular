package org.library.rest.api.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Books")
public class Book implements Serializable {

    private static final long serialVersionUID = -7953032111886173643L;

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    @Column(updatable = false, unique = true)
    @Length(max = 20)
    private String isbn;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Books_To_Authors",
            joinColumns = { @JoinColumn(name = "book_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "author_id", nullable = false, updatable = false) })
    private List<Author> authors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
