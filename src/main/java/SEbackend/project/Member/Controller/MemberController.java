package SEbackend.project.Member.Controller;

import SEbackend.project.Member.DTO.MemberDto;
import SEbackend.project.Member.DTO.UpdateDto;
import SEbackend.project.Member.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
   private final  MemberService memberService;

    /**
     * 회원 추가 기능
     * [POST] member/join
     * @return Response.body(MemberDto)
     */
    @PostMapping("/join")
    public ResponseEntity<MemberDto> create(@RequestBody MemberDto memberDto){
        memberService.Join(memberDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(memberDto);
    }

    /**
     * 개인정보 변경(비밀번호, 닉네임 변경)
     * [PATCH] member/update/{memberId}
     *
     * @param memberId
     * @param Dto
     * @return ResponseEntity<MemberDTO>
     */
    @PatchMapping("/update/{memberId}")
    public ResponseEntity<MemberDto> updateMemberDto(@PathVariable Long memberId, @RequestBody UpdateDto Dto) {
        MemberDto update = memberService.update(memberId, Dto);
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }
    /**
     * DB에 저장된 회원 전체 조회, 실제 기능 아님
     * [GET] /member/list
     * @return List<MemberDto>
     */
    @GetMapping("/list")
    public ResponseEntity<List<MemberDto>> findAll(){
        List<MemberDto> memberDTOList = memberService.findMembers();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTOList);
    }

    /**
     * 회원 탈퇴
     * [DELETE] /member/{memberId}
     * @param memberId
     * @return ResponseEntity body("Delete Success")
     */
    @DeleteMapping("/{memberId}")
    public ResponseEntity<?> deleteById(@PathVariable Long memberId){
        memberService.DeleteMember(memberId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Delete Success");
    }


}
