package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {

    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //아래 있는 함수가 시작될 때 startTransaction 을 실행한다(트랜젝션 시작)
    // 함수가 예외없이 잘 끝났다면 commit;
    // 혹시라도 문제가 있다면 rollback;
    @Transactional
    public void saveUser(UserCreateRequest request) {
        User u = userRepository.save(new User(request.getName(), request.getAge()));
        u.getId();
    }

    @Transactional(readOnly = true)
    public List<UserResponse> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());

    }

    @Transactional
    public void updateUser(UserUpdateRequest request) {
        User user = userRepository.findById(request.getId()) //id 기준으로 1개의 데이터 반환
            .orElseThrow(IllegalAccessError::new); //Optional 의 OrElseThrow 를 사용해 User 가 없다면 예외를 호출한다.

        user.updateName(request.getName()); //객체를 업데이트 해주고, save 를 호출한다. 자동으로 Update Sql 이 날라간다.
        //영속성 컨텍스트 의 기능인 변경감지 기능으로 인해, 영속성 컨텍스트 종료 시 변경사항이 반영된다.
        //userRepository.save(user);
    }

    @Transactional
    public void deleteUser(String name) {
        User user = userRepository.findByName(name);
        if (user == null) {
            throw new IllegalArgumentException();
        }

        userRepository.delete(user);
    }
}
