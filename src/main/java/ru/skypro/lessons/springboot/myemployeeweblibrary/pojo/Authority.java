//package ru.skypro.lessons.springboot.myemployeeweblibrary.pojo;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.Objects;
//
//@Entity
//@Table(name = "authorities")
//public class Authority {
//
//
//    @Column (name = "authority")
//    private String authority ;
//
//    @Id
//    @ManyToOne (fetch = FetchType.EAGER)
//    @JoinColumn(name = "username")
//    private User user;
//
//
//    public String getAuthority() {
//        return authority;
//    }
//
//    public void setAuthority(String authority) {
//        this.authority = authority;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Authority authority1)) return false;
//        return authority.equals(authority1.authority) && user.equals(authority1.user);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(authority, user);
//    }
//}
