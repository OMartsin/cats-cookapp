package dev.cats.cookapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "name", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String role = "USER";

    @Column
    private Timestamp created_at = new Timestamp(System.currentTimeMillis());

    @OneToMany(mappedBy = "user")
    private Set<FavoriteRecipes> favoriteRecipes = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserList> userLists = new HashSet<>();

    public User() {
    }

    public User(String email, String username) {
        this.email = email;
        this.username = username;
    }

    public User(Long id, String email, String username) {
        this.id = id;
        this.email = email;
        this.username = username;
    }

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    @OneToMany(mappedBy = "createdBy")
    private Set<Recipe> recipes = new HashSet<>();

}