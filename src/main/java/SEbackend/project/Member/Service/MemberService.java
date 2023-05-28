package SEbackend.project.Member.Service;

import SEbackend.project.Member.DTO.LoginDto;
import SEbackend.project.Member.DTO.MemberDto;
import SEbackend.project.Member.DTO.UpdateDto;
import SEbackend.project.Member.Entitiy.Member;
import SEbackend.project.Member.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {


        private final MemberRepository memberRepository;


        //회원 가입
        public MemberDto Join(MemberDto memberDto){
            validateDuplicateMember(memberDto);
            return memberDto;
        }
    private void validateDuplicateMember(MemberDto memberDto) {
        Member findMembers = memberRepository.findByEmail(memberDto.getEmail());
        if(findMembers!=null){
            throw new IllegalStateException("이메일이 중복된 회원입니다.");
        }else {
            Member member = new Member(memberDto);
            memberRepository.save(member);
        }
    }

    //회원 가입
    public void DeleteMember(Long id){
        Optional<Member> member = memberRepository.findById(id);
        memberRepository.delete(member.get());
    }


        //회원 전체 조회
        public List<MemberDto> findMembers(){
            List<Member> memberList = memberRepository.findAll();
            List<MemberDto> memberDtoList = new ArrayList<>();
            for (Member member : memberList) {
                memberDtoList.add(new MemberDto(member));
            }
            return memberDtoList;
        }



        public MemberDto login(LoginDto loginDto){
            Member member = memberRepository.findByEmail(loginDto.getEmail());
            if(member==null)  return null;
            if(member.getPassword().equals(loginDto.getPassword())) {
                Member member1 = memberRepository.findByEmail(loginDto.getEmail());
                MemberDto memberDto = new MemberDto(member1);
                return memberDto;
            }
            else return null;
        }
        public MemberDto update(Long id, UpdateDto updateDto) {
            Member member = memberRepository.findById(id).get();
            member.setNickName(updateDto.getNickName());
            member.setPassword(updateDto.getPassword());
            MemberDto Dto = new MemberDto(member);
            return Dto;
        }
    }


