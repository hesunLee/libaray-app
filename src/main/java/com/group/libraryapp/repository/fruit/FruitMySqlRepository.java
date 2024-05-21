package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.dto.fruit.response.FruitStatList;
import com.group.libraryapp.dto.fruit.response.FruitStatResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;


@Repository
public class FruitMySqlRepository implements FruitRepository {

    private final JdbcTemplate jdbcTemplate;

    public FruitMySqlRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveFruit(String name, LocalDate warehousingDate, long price) {
        String sql = " INSERT INTO `fruit` (name, warehousing_date, price, status) values (?,?, ?,?) ";
        jdbcTemplate.update(sql, name, warehousingDate, price, 1);
    }

    @Override
    public void updateFruit(long id) {
        String sql = " UPDATE fruit SET status = ? WHERE id = ? ";
        jdbcTemplate.update(sql, 2, id);
    }

    @Override
    public FruitStatResponse getFruitStat(String name) {
        String sql = String.format(" SELECT * FROM fruit where name = '%s' ", name);

        List<FruitStatList> datas = jdbcTemplate.query(sql, new RowMapper<FruitStatList>() {
            @Override
            public FruitStatList mapRow(ResultSet rs, int rowNum) throws SQLException {
                //정보를 선언한 데이터 타입으로 가져오는 함수
                //resultSet : 결과정보

                String name = rs.getString("name");
                long price = rs.getLong("price");
                int status = rs.getInt("status");

                return new FruitStatList(name, price, status);
            }
        });

        return new FruitStatResponse(datas);
    }
}
