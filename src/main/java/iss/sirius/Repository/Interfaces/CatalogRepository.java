package iss.sirius.Repository.Interfaces;

import iss.sirius.Model.Catalog;

import java.util.List;
import java.util.Optional;

public interface CatalogRepository {
    public Catalog save(Catalog Catalog) throws Exception;

    public Optional<Catalog> findById(int id);

    public List<Catalog> findAll();

    public void remove(Catalog Catalog);

}
