package pre_project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pre_project.entity.Role;
import pre_project.entity.User;

@Service
public interface RoleService {

    Role getByName(String name);
}
