package com.group.libraryapp.domain.user;

import javax.persistence.*;

@Entity
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    //UserLoanHistory : 여러개
    //User : 1개
    @ManyToOne
    private User user;

    private String bookName;

    private boolean isReturn;
    //boolean 으로 처리할 경우 tinyint 와 대응된다.

    protected UserLoanHistory() { };

    public UserLoanHistory(User user, String bookName) {
        this.user = user;
        this.bookName = bookName;
        this.isReturn = false;
    }


    public void doReturn() {
        this.isReturn = true;
    }

    public String getBookName() {
        return this.bookName;
    }

    public boolean isReturn() {
        return this.isReturn;
    }
}
