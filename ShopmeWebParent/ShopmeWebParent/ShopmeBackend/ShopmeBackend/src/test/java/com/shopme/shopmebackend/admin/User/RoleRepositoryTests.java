package com.shopme.shopmebackend.admin.User;

import com.shopme.shopmebackend.User.RoleRepository;
import com.shopme.shopmecommon.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testCreateFirstRole() {
        Role roleAdmin = new Role("Admin", "Manage Everything");
        Role savedRole = roleRepository.save(roleAdmin);
        assertThat(savedRole.getId()).isGreaterThan(0);
    }


    @Test
    public void testCreateFRestUsers() {
        Role roleSalesperson = new Role("Salesperson", "Manage Product price,"
                +"customers, shipping, orders and sales report");
        Role roleEditor = new Role("Editor", "Manage categories,"
                +" brands, products, articles and menus,");
        Role roleShipper = new Role("Shipper", "view products,"
                +"view orders and update order status");
        Role roleAssistant = new Role("Assistant", "manage questions and reviews");
        roleRepository.saveAll(List.of(roleSalesperson, roleEditor, roleShipper, roleAssistant));
    }
}

