package iss.sirius.Controller;

import iss.sirius.Model.Catalog;
import iss.sirius.Repository.Interfaces.CatalogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CatalogController {
    @Autowired
    CatalogRepository catalogRepository;

    @RequestMapping(value = "/catalog/{id}", method = RequestMethod.GET)
    public Object getCatalog(@PathVariable int id) {
        return catalogRepository.findById(id);
    }

    @RequestMapping(value = "/catalog", method = RequestMethod.POST, consumes = "application/json")
    public void addCatalog(@RequestBody Catalog catalog) throws Exception {
        catalogRepository.save(catalog);
    }

    @RequestMapping(value = "/catalog/{id}", method = RequestMethod.DELETE)
    public void removeCatalog(@PathVariable int id) throws Exception {
        if (catalogRepository.findById(id).equals(Optional.empty())) {
            throw new Exception("Why remove something that doesn't exist ????");
        } else {
            catalogRepository.remove(catalogRepository.findById(id).get());
        }
    }

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public Object getAllCatalogs() {
        return catalogRepository.findAll();
    }
}
