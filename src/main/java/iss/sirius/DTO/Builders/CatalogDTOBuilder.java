package iss.sirius.DTO.Builders;

import iss.sirius.DTO.CatalogDTO;
import iss.sirius.Model.Catalog;

public class CatalogDTOBuilder {
    public static CatalogDTO generateDTOFromEntity(Catalog catalog) {
        return new CatalogDTO(
                catalog.getId()
        );
    }

    public static Catalog generateEntityFromDTO(CatalogDTO catalogDTO) {
        return new Catalog(
                catalogDTO.getId()
        );
    }
}