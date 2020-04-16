package iss.sirius.Controller;

import iss.sirius.Model.Credentails;
import iss.sirius.Model.User;
import iss.sirius.Repository.Interfaces.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class LoginController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
    public Object login(@RequestBody Credentails credentails, HttpServletRequest request, HttpServletResponse response) throws ServletException, Exception {
        Optional<User> user = userRepository.findByEmailAndPassword(credentails.getEmail(), credentails.getPassword());
        if (credentails.getEmail() != null && credentails.getPassword() != null) {
            if (user.isPresent()) {
                response.setStatus(200);
                return user.get();
            } else {
                response.setStatus(400);
                return user.isPresent();
            }
        } else {
            response.setStatus(400);
            return user.isPresent();
        }
    }

}
