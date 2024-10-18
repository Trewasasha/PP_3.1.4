package ru.kata.spring.boot_security.demo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AddUserAndRoleInTable {

    private final RoleService roleDao;
    private final UserService userService;

    @Autowired
    public AddUserAndRoleInTable(RoleService roleDao, UserService userService) {
        this.roleDao = roleDao;
        this.userService = userService;
    }

    @PostConstruct
    private void init() {//'1', '24', 'Alex@mail.ru', 'Alex', 'Ivanov', '$2a$10$haHdhBZgwDHTzCnNgMJqLecf3SkiGvTp2mfue0p1C4GAne6N/aEve'

        roleDao.saveRole(new Role(1L, "ROLE_ADMIN"));
        roleDao.saveRole(new Role(2L, "ROLE_USER"));
        Set<Role> adminRole = roleDao.findByIdRole(1L).stream().collect(Collectors.toSet());
        Set<Role> userRole = roleDao.findByIdRole(2L).stream().collect(Collectors.toSet());
        userService.saveUser(new User("Alex", "Ivanov", 24,
                "Alex@mail.ru", "Alex123", adminRole));

        userService.saveUser(new User("Vazhenin", "Sasha", 34,
                "vazheninsaha@gmail.com", "sasha123", userRole));
    }
}