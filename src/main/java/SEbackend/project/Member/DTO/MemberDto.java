package SEbackend.project.Member.DTO;

import SEbackend.project.Member.Entitiy.Member;
import lombok.Data;

@Data
public class MemberDto {
    private Long id;
    private String name;
    private String nickName;
    private String email;
    private String password;

    public MemberDto() {
    }

    public MemberDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.nickName = member.getNickName();
        this.email = member.getEmail();
        this.password = member.getPassword();
    }
}
