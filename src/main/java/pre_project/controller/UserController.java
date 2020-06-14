package pre_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pre_project.entity.User;
import pre_project.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String userList(ModelMap model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "user";
    }
    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String getCreatePage() {
        return "user-create";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@RequestParam String firstName,
                          @RequestParam String lastName,
                          @RequestParam String email) {
        userService.add(new User(firstName, lastName, email));
        return "redirect:/users";
    }

    @RequestMapping(value = "/{id}/delete")
    public String deleteUser(@PathVariable(name = "id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @RequestMapping(path = "/{id}/update", method = RequestMethod.GET)
    public String getUpdatePage(@PathVariable(name = "id") Long id, Model model) {
        User user = userService.getUser(id);

        model.addAttribute("firstName",user.getFirstName());
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("email",user.getEmail());
        model.addAttribute("id",user.getId());

        return "user-update";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(@PathVariable(name = "id") Long id,
                         @RequestParam(name = "firstName") String firstName,
                         @RequestParam(name = "lastName") String lastName,
                         @RequestParam(name = "email") String email) {
        User user = userService.getUser(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        userService.updateUser(user);
        return "redirect:/users";
    }
}