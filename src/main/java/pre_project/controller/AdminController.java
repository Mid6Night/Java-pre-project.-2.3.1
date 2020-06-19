package pre_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pre_project.dao.RoleDao;
import pre_project.entity.Role;
import pre_project.entity.User;
import pre_project.service.RoleService;
import pre_project.service.UserService;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

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
                          @RequestParam String password,
                          @RequestParam String email) {
        User user = new User(firstName, lastName, email);
        user.setPassword(password);
        user.setRoles(new HashSet<>());
        user.getRoles().add(roleService.getByName("USER"));
        userService.add(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/{id}/delete")
    public String deleteUser(@PathVariable(name = "id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @RequestMapping(path = "/{id}/update", method = RequestMethod.GET)
    public String getUpdatePage(@PathVariable(name = "id") Long id, Model model) {
        User user = userService.getUser(id);

        model.addAttribute("firstName",user.getFirstName());
        model.addAttribute("lastName",user.getLastName());
        model.addAttribute("email",user.getEmail());
        model.addAttribute("password",user.getPassword());
        model.addAttribute("id",user.getId());
        return "user-update";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(@PathVariable(name = "id") Long id,
                         @RequestParam(name = "firstName") String firstName,
                         @RequestParam(name = "lastName") String lastName,
                         @RequestParam(name = "password") String password,
                         @RequestParam(name = "email") String email,
                         @RequestParam(name = "admin", required = false) boolean admin) {
        User user = userService.getUser(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        userService.updateUser(user);
        return "redirect:/admin";
    }
}