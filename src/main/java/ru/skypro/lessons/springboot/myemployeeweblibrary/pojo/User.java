package ru.skypro.lessons.springboot.myemployeeweblibrary.pojo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @Column (name = "username")
    private String username ;

    @Column (name = "password")
    private String password ;

    @Column (name = "enabled")
    private int enabled;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Authority> authorities;
}
