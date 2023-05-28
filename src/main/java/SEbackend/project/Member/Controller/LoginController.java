package SEbackend.project.Member.Controller;

import SEbackend.project.Member.DTO.LoginDto;
import SEbackend.project.Member.DTO.MemberDto;
import SEbackend.project.Member.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class LoginController {

    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<MemberDto> login(@RequestBody LoginDto loginDto, HttpServletRequest request) {
        MemberDto login = memberService.login(loginDto);
        if(login==null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
       else {
            HttpSession session = request.getSession();
            session.setAttribute("login",login);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(login);
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login?logout";
    }
}
