package pre_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pre_project.dao.RoleDao;
import pre_project.entity.Role;

@Service
public class RoleServiceIml implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    @Transactional(readOnly = true)
    public Role getByName(String name) {
        return roleDao.getByName(name);
    }
}
