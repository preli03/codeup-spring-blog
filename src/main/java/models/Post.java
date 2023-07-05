package models;

import jakarta.persistence.*;

@Entity
@Table(name = "post")
public class Post {
    @Id
    private Long id;
private String name;
    private String title;

    private String content;
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
/*
@Entity
@Table(name = "texas_athletes")
public class TexasAthlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "sport")
    private String sport;

    @Column(name = "age")
    private int age;

    @Column(name = "hometown")
    private String hometown;
*/

    // Constructors, getters, and setters


