package com.group.library_app.domain.user;

import com.group.library_app.domain.user.loanhistory.UserLoanHistory;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    @Column(nullable = false, length = 25, name= "name")
    private String name;

    private Integer age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<UserLoanHistory> userLoanHistories = new ArrayList<>();//다 대 1



    protected  User() {

    }

    public User(String name, Integer age) {
    if (name == null || name.isBlank()) {
        throw new IllegalArgumentException(String.format("잘못된 이름(%s)입니다", name));
    }

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public long getId() {
        return id;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void loanBook(String bookName) {
        this.userLoanHistories.add(new UserLoanHistory(this, bookName, false));
    }
    public void returnBook(String bookName) {
        UserLoanHistory targetHistory = this.userLoanHistories.stream()
                .filter(userLoanHistory -> userLoanHistory.getBookName().equals(bookName)).
                findFirst().orElseThrow(IllegalArgumentException::new);
        targetHistory.doReturn();

    }

}
