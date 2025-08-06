package com.example.student_library_management_system.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "gender",nullable = false)
    private String gender;
    @Column(name = "country",nullable = false)
    private String country;
    @Column(name = "rating",nullable = false)
    private String rating;
    @JsonManagedReference
    @OneToMany(mappedBy = "author")
    private List<Book> booksByAuthor;

    public List<Book> getBooksByAuthor() {
        return booksByAuthor;
    }

    public void setBooksByAuthor(List<Book> booksByAuthor) {
        this.booksByAuthor = booksByAuthor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


}
