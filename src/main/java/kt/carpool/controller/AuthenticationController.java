package kt.carpool.controller;

import kt.carpool.config.auth.PrincipalDetails;
import kt.carpool.domain.Member;
import kt.carpool.dto.MemberDto;
import kt.carpool.repository.MemberRepository;
import kt.carpool.utils.MemberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthenticationController {

    private final MemberRepository memberRepository;

    private final MemberUtils memberUtils;

    @Autowired
    public AuthenticationController(MemberRepository memberRepository, MemberUtils memberUtils) {
        this.memberRepository = memberRepository;
        this.memberUtils = memberUtils;
    }

    @GetMapping("/api/auth")
    public @ResponseBody ResponseEntity member(@AuthenticationPrincipal PrincipalDetails principalDetails){
        if (principalDetails!=null) {
            Member member = principalDetails.getMember().get();
            Member memberEntity = memberRepository.findById(member.getId()).orElseThrow();
            MemberDto memberDto = memberUtils.toDto(memberEntity);
            return new ResponseEntity(memberDto, HttpStatus.OK);
        }else {
            return new ResponseEntity(null, HttpStatus.UNAUTHORIZED);
        }

    }
}
