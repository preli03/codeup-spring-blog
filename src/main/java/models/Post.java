package models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString



@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false)
    private String title;

    
    @Column(length = 1024)
    private String body;

    public Post(String id, String title, String body) {
    }


    public String getTitle(){
        return title;
    }
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


