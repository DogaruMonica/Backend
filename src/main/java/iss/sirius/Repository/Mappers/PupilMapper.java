package iss.sirius.Repository.Mappers;

import iss.sirius.Model.Pupil;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PupilMapper implements RowMapper<Pupil> {
    @Override
    public Pupil mapRow(ResultSet rs, int rowNum) throws SQLException {
        System.out.println("stuff din jpa-modificat +commit ");
        return new Pupil(rs.getInt("id"),
                rs.getString("firstname"),
                rs.getString("lastname"));

    }
}
