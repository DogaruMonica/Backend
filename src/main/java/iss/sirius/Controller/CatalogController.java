package iss.sirius.Controller;

import iss.sirius.DTO.CatalogDTO;
import iss.sirius.Model.Catalog;
import iss.sirius.Model.Classroom;
import iss.sirius.Repository.CatalogRepository;
import iss.sirius.Repository.ClassroomRepository;
import iss.sirius.Service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CatalogController {
    @Autowired
    CatalogRepository catalogRepository;
    @Autowired
    ClassroomRepository classroomRepository;
    @Autowired
    CatalogService catalogService;

    @RequestMapping(value = "/catalog/{classroomid}", method = RequestMethod.POST, consumes = "application/json")
    public Object addCatalog(@RequestBody Catalog catalog, @PathVariable int classroomid) throws Exception {
        Optional<Classroom> classroom = classroomRepository.findById(classroomid);
        if (classroom.isPresent()) {
            catalog.setClassroom(classroom.get());
            return catalogRepository.save(catalog);
        }
        else {
            throw new Exception("invalid classroom");
        }
    }

    @RequestMapping(value = "/catalog/{id}", method = RequestMethod.GET)
    public Object getCatalog(@PathVariable int id) throws Exception {
        CatalogDTO catalogDTO = catalogService.findById(id);
        catalogDTO.setClassroom(classroomRepository.findById(catalogRepository.findById(id).get().getClassroom().getId()).get());
        return catalogDTO;
    }

    @RequestMapping(value = "/catalog/{id}", method = RequestMethod.DELETE)
    public void removeCatalog(@PathVariable int id) throws Exception {
        if (catalogRepository.findById(id).equals(Optional.empty())) {
            throw new Exception("Why remove something that doesn't exist ????");
        } else {
            catalogRepository.delete(catalogRepository.findById(id).get());
        }
    }

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public Object getAllCatalogs() {
        return catalogRepository.findAll();
    }
}
