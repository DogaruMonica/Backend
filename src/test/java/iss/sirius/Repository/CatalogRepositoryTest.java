package iss.sirius.Repository;

import iss.sirius.Model.Catalog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CatalogRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CatalogRepository catalogRepository;

    @Test
    public void findCatalogByIdTest() {
        Catalog catalog = new Catalog();
        entityManager.persist(catalog);
        entityManager.flush();

        Catalog returnedCatalog = catalogRepository.findById(catalog.getId()).get();

        assertThat(returnedCatalog.getId()).isEqualTo(catalog.getId());
    }
}
