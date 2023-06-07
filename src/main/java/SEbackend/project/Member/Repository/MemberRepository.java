package SEbackend.project.Member.Repository;

import SEbackend.project.Member.Entitiy.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String name);
}