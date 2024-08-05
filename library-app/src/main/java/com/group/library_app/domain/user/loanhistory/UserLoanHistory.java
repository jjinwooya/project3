package com.group.library_app.domain.user.loanhistory;

import com.group.library_app.domain.user.User;
import jakarta.persistence.*;


@Entity
public class UserLoanHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User user; //N대1 관계
    private String bookName;
    private boolean isReturn;

    public UserLoanHistory(User user, String bookName, boolean isReturn) {

        this.user = user;
        this.bookName = bookName;
        this.isReturn = isReturn;
    }

    protected UserLoanHistory() {

    }
    public void doReturn() {
        this.isReturn = true;
    }

    public String getBookName() {
        return this.bookName;
    }
}
