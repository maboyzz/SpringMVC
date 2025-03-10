package vn.hoidanit.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hoidanit.laptopshop.domain.Role;
import java.util.List;

@Repository
public interface roleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
