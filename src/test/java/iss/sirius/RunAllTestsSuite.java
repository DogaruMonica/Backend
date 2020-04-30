package iss.sirius;

import iss.sirius.Controller.UserControllerTest;
import iss.sirius.Repository.CatalogRepositoryTest;
import iss.sirius.Repository.ClassroomRepositoryTest;
import iss.sirius.Repository.GradeRepositoryTest;
import iss.sirius.Repository.PupilRepositoryTest;
import iss.sirius.Repository.SubjectRepository;
import iss.sirius.Repository.SubjectRepositoryTest;
import iss.sirius.Repository.TeacherRepositoryTest;
import iss.sirius.Repository.UserRepositoryTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserRepositoryTest.class,
        TeacherRepositoryTest.class,
        PupilRepositoryTest.class,
        SubjectRepositoryTest.class,
        GradeRepositoryTest.class,
        CatalogRepositoryTest.class,
        ClassroomRepositoryTest.class,
        UserControllerTest.class
})
public class RunAllTestsSuite {
}
