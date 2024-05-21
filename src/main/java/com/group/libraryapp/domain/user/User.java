package com.group.libraryapp.domain.user;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//스프링이 User 객체와 users Table을 같은 것으로 바라보개 함다.
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 20, name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    //UserLoanHistory : 여러개
    //User : 1개
    //앞에가 현재 객체
    //UserLoanHistory 의 {{mappedBy}} 로 연결한다.
    //cascade = CascadeType.ALL 유저가 사라지면, 관련된 history 도 삭제
    //orphanRemoval 객체간의 관계가 끊어진 데이터를 자동으로 제거하는 옵션
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserLoanHistory> userLoanHistories = new ArrayList<>();

    protected User() {
    }

    public User(String name, Integer age) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다", name));
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

    // 서비스 계층에서 진행하지 않고, 도메인 내부에서 실행한다.
    // 이를 도메인 계층에 비지니스 로직이 들어갔다. 고 표현한다.
    public void loanBook(String bookName) {
        this.userLoanHistories.add(new UserLoanHistory(this, bookName));
    }

    public void returnBook(String bookName) {
        UserLoanHistory userLoanHistory = this.userLoanHistories.stream()
                .filter(history -> history.getBookName().equals(bookName) && ! history.isReturn() )
                .findFirst()
                .orElseThrow();

        userLoanHistory.doReturn();
    }
}
