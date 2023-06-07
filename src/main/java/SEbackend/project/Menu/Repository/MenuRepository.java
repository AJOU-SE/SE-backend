package SEbackend.project.Menu.Repository;

import SEbackend.project.Menu.Entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    Menu findByMenuId(Long menuId);
    List<Menu> findByDateOrDate(Integer date1, Integer date2);
    List<Menu> findByMenuContainingOrCafeteriaContainingOrHashtagContaining(String key1, String key2, String key3);
    List<Menu> findByHashtagContaining(String tag);
}