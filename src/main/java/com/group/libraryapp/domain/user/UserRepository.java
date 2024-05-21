package com.group.libraryapp.domain.user;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name); //반드시 함수명을 조립해서 작성해줘야 한다.

    //find : 1개의 데이터만 가져온다.
    //by: 뒤에 붙는 필드 명으로 Select 쿼리의 Where 가 작성된다.
}
