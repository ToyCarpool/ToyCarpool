package kt.carpool.controller;


import kt.carpool.config.auth.PrincipalDetails;
import kt.carpool.domain.Member;
import kt.carpool.dto.MemberDto;
import kt.carpool.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/")
    public String index() {
        System.out.println("123 = " + 123);
        return "index";
    }
    @GetMapping("/admin")
    public @ResponseBody String admin() { return "admin";}
    @GetMapping("/manager")
    public @ResponseBody String manager() { return "manager";}
    @GetMapping("/loginForm")
    public String loginForm() { return "loginForm";}
    @GetMapping("/joinForm")
    public String joinForm() { return "joinForm";}
    @GetMapping("/user")
    public @ResponseBody Optional<Member> member(@AuthenticationPrincipal PrincipalDetails principalDetails){
        System.out.println("principalDetails.getUsername() = " + principalDetails.getMember());
        return principalDetails.getMember();
    }

    @PostMapping("/join")
    public String join(MemberDto memberDto){
        Member member = Member.builder() // 여기서 new가 왜 안되지..?
                .username(memberDto.getUsername())
                .password(memberDto.getPassword())
                .name(memberDto.getName())
                .email(memberDto.getEmail())
                .role(memberDto.getRole())
                .provider(memberDto.getProvider())
                .providerId(memberDto.getProviderId())
                .createDate(memberDto.getCreateDate())
                .build();
        memberRepository.save(member);
        return "redirect:/loginForm";
    }

//    @PostMapping("/signup")
//    public String SingUp(@RequestBody MemberDto memberdto){
//        Member member = new Member().builder()
//                .username(memberdto.getUsername())
//                .password(memberdto.getPassword())
//                .name(memberdto.getName())
//                .email(memberdto.getEmail())
//                .role(memberdto.getRole())
//                .provider(memberdto.getProvider())
//                .providerId(memberdto.getProviderId())
//                .createDate(memberdto.getCreateDate())
//                .build();
//        if (memberService.signUp(member)==-1) {
//            return "fail";
//        };
//        return "ok_success";
//    }
//
//    @PostMapping("/signin")
//    public String SignIn(@RequestBody MemberDto memberdto){
//        Member member = new Member().builder()
//                .username(memberdto.getUsername())
//                .password(memberdto.getPassword())
//                .build();
//        Integer status = memberService.signIn(member);
//        if(status == 0) return "ok_success";
//        else return "fail";
//    }
}
