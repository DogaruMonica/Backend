package iss.sirius.Repository.Mappers;

import iss.sirius.Model.Catalog;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CatalogMapper implements RowMapper<Catalog> {
    @Override
    public Catalog mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Catalog(rs.getInt("id"));
    }
}