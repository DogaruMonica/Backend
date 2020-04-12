package iss.sirius.Repository.Mappers;
import iss.sirius.Model.Subject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;

public class SubjectMapper implements RowMapper<Subject>{
    @Override
    public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Subject(rs.getInt("id"),
                rs.getString("name"));
    }
}
