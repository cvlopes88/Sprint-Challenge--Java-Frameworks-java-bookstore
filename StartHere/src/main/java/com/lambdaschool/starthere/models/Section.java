package com.lambdaschool.starthere.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sections")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sectionId;
    @Column(nullable = false, unique = true)
    private String sectionName;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();


    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "books", joinColumns = @JoinColumn(name = "sectionId"), inverseJoinColumns = @JoinColumn(name = "bookId"))
    private List<Author> authorsS = new ArrayList<>();
///////////////
//public void addAuthor(Author author) {
//    author.add(author);
//    author.getSection().add(this);
//}
//
//    public void removeTag(Tag tag) {
//        tags.remove(tag);
//        tag.getPosts().remove(this);
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Post)) return false;
//        return id != null && id.equals(((Post) o).getId());
//    }

    ////////////////////////////////////////



    public Section(String sectionName) {
        this.sectionName = sectionName;
    }

    public Section() {
    }

    public long getSectionId() {
        return sectionId;
    }

    public void setSectionId(long sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    @Override
    public String toString() {
        return "Section{" +
                "sectionId=" + sectionId +
                ", sectionName='" + sectionName + '\'' +
                '}';
    }
}
