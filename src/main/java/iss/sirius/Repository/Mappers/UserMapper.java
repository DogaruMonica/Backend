package iss.sirius.Repository.Mappers;

import iss.sirius.Model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(rs.getInt("id"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("role"));
    }
}
