package iss.sirius.Repository.Mappers;

import iss.sirius.Model.Classroom;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassroomMapper implements RowMapper<Classroom> {
    @Override
    public Classroom mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Classroom(rs.getInt("id"),
                rs.getString("name"));
    }
}