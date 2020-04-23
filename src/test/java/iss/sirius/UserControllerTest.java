package iss.sirius;

import iss.sirius.Controller.UserController;
import iss.sirius.Model.User;
import iss.sirius.Repository.Interfaces.UserRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserControllerTest {

    public UserRepository repo;
    public UserController ctrl;

    @Test
    public void createUser() throws Exception {
        User user = new User(1,"test_email","test_password","pupil");
        repo.save(user);

        Object userCtrl = ctrl.getUser(1);

        assertTrue(userCtrl.equals(user));
    }

}
