package iss.sirius.Repository;

import iss.sirius.Model.Catalog;
import iss.sirius.Repository.Interfaces.CatalogRepository;
import iss.sirius.Repository.Mappers.CatalogMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CatalogImpl implements CatalogRepository {
    @Autowired
    JdbcTemplate template;

    @Override
    public Catalog save(Catalog catalog) throws Exception {
        int id = insert(catalog);
        catalog.setId(id);
        return catalog;
    }

    @Override
    public Optional<Catalog> findById(int id) {
        List<Catalog> catalogs = template.query("SELECT * FROM Catalogs WHERE id = ?", new CatalogMapper(), id);
        return catalogs.isEmpty() ? Optional.empty() : Optional.of(catalogs.get(0));
    }

    @Override
    public List<Catalog> findAll() {
        return template.query("SELECT * FROM Catalogs", new CatalogMapper());
    }

    @Override
    public void remove(Catalog catalog) {
        template.update("DELETE FROM Catalogs WHERE id = ?", catalog.getId());
    }

    private Integer insert(Catalog catalog) {
        return template.update("INSERT INTO Catalogs VALUES (default)");
    }
}
