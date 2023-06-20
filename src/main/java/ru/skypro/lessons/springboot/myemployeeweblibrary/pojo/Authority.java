package ru.skypro.lessons.springboot.myemployeeweblibrary.pojo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "authorities")
public class Authority {


    @Column (name = "authority")
    private String authority ;

    @Id
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private User user;
}
