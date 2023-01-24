package kt.carpool.controller;


import kt.carpool.config.auth.PrincipalDetails;
import kt.carpool.domain.Member;
import kt.carpool.dto.MemberDto;
import kt.carpool.repository.MemberRepository;
import kt.carpool.service.MemberService;
import kt.carpool.service.VerifyRecaptchaService;
import kt.carpool.utils.MemberUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class MemberController {

    private final MemberRepository memberRepository;
    private final MemberService memberService;

    private final MemberUtils memberUtils;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public MemberController(MemberRepository memberRepository, MemberUtils memberUtils, BCryptPasswordEncoder bCryptPasswordEncoder, MemberService memberService) {
        this.memberRepository = memberRepository;
        this.memberUtils = memberUtils;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.memberService = memberService;
    }

//    @GetMapping("/")
//    public String index() {
//        System.out.println("123 = " + 123);
//        return "index";
//    }
    @GetMapping("/admin")
    public @ResponseBody String admin() { return "admin";}
    @GetMapping("/manager")
    public @ResponseBody String manager() { return "manager";}
    @GetMapping("/login")
    public String loginForm() { return "loginForm";}
//    @PostMapping
//    @GetMapping("/joinForm")
//    public String joinForm() { return "joinForm";}
    @GetMapping("/user")
    public @ResponseBody ResponseEntity member(@AuthenticationPrincipal PrincipalDetails principalDetails){
        Long id = principalDetails.getMember().get().getId();
        Member memberPersist = memberRepository.findById(id).get();
        MemberDto memberDto = memberUtils.toDto(memberPersist);
        return new ResponseEntity(memberDto, HttpStatus.OK);
    }

    @PostMapping("/join")
    public String join(MemberDto memberDto){
        String encodedPassword = bCryptPasswordEncoder.encode(memberDto.getPassword());
        memberDto.setPassword(encodedPassword);
        Member member = memberUtils.toEntity(memberDto);

        if (memberService.signUp(member)==-1) {
            return "redirect:/login";
        } else {
            memberRepository.save(member);
            return "redirect:/login";
        }
    }

    @ResponseBody
    @PostMapping("/Recaptcha")
    public int VerifyRecaptchaService(HttpServletRequest request){
        VerifyRecaptchaService.setSecretKey("6LfHFZojAAAAAMcVup6lruKfYtz47io0fafrQ8fQ");
        String gRecaptchaResponse = request.getParameter("recaptcha");

        try{
            if(VerifyRecaptchaService.verify(gRecaptchaResponse))
                return 0; // 성공
            else return 1; // 실패
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // 에러
        }

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
