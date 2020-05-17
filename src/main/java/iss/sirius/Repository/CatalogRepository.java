package iss.sirius.Repository;

import iss.sirius.Model.Catalog;
import iss.sirius.Model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Integer> {
    Catalog findByClassroom(Classroom classroom);
}
