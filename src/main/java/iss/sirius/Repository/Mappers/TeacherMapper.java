package iss.sirius.Repository.Mappers;

import iss.sirius.Model.Teacher;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherMapper implements RowMapper<Teacher> {
    @Override
    public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Teacher(rs.getInt("id"),
                rs.getString("firstname"),
                rs.getString("lastname"));
    }
}
