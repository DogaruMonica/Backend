package iss.sirius.Service;

import iss.sirius.DTO.Builders.CatalogDTOBuilder;
import iss.sirius.DTO.CatalogDTO;
import iss.sirius.Model.Catalog;
import iss.sirius.Repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogService {
    @Autowired
    CatalogRepository catalogRepository;

    public CatalogDTO findById(int id) throws Exception {
        Optional<Catalog> catalog  = catalogRepository.findById(id);

        if (!catalog.isPresent()) {
            throw new Exception("Catalog doesn't exist");
        }
        return CatalogDTOBuilder.generateDTOFromEntity(catalog.get());
    }
}
