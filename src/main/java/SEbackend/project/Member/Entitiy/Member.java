package SEbackend.project.Member.Entitiy;

import SEbackend.project.Member.DTO.MemberDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id@GeneratedValue
    private Long id;
    private String name;
    private String nickName;
    private String email;
    private String password;

    public Member(MemberDto memberDto) {
        this.name = memberDto.getName();
        this.nickName = memberDto.getNickName();
        this.email = memberDto.getEmail();
        this.password = memberDto.getPassword();
    }
}
