package com.group.libraryapp.repository.user;

import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserJDBCRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserJDBCRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveUser(String name, Integer age) {
        String sql = " INSERT INTO `user` (name, age) values (?,?) ";
        jdbcTemplate.update(sql, name, age);
    }

    public List<UserResponse> getUsers() {
        String sql = " SELECT * FROM user ";
        return jdbcTemplate.query(sql, new RowMapper<UserResponse>() {
            @Override
            public UserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
                //정보를 선언한 데이터 타입으로 가져오는 함수
                //resultSet : 결과정보

                long id = rs.getLong("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");


                return new UserResponse(id, name, age);
            }
        });
    }

    public boolean isUserNotExist(long id) {
        String readSql = " SELECT * FROM user WHERE id = ? ";
        return jdbcTemplate.query(readSql, (rs , rowNum) -> 0, id).isEmpty();
    }

    public void updateUserName (String name, long id) {
        String sql = " UPDATE user SET name = ? WHERE id = ? ";
        jdbcTemplate.update(sql, name, id);
    }

    public boolean isUserNotExist(String name) {
        String readSql = " SELECT * FROM user WHERE name = ? ";
        return jdbcTemplate.query(readSql, (rs , rowNum) -> 0, name).isEmpty();
    }

    public void deleteUser(String name) {
        String sql = " DELETE FROM user WHERE name = ? ";
        jdbcTemplate.update(sql, name);
    }


}
