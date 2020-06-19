package pre_project.dao;

import pre_project.entity.Role;

public interface RoleDao {
    Role getByName(String name);
}
