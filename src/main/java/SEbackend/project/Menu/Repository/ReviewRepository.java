package SEbackend.project.Menu.Repository;

import SEbackend.project.Menu.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByMenuId(Long menuId);
}