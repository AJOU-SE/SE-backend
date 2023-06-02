package SEbackend.project.Menu.Repository;

import SEbackend.project.Menu.Entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByDate(Integer date);
}