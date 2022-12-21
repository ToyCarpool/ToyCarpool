package kt.carpool.config.auth;

import kt.carpool.domain.Member;
import kt.carpool.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> memberEntity = memberRepository.findByUsername(username);
        if(memberEntity.isPresent()){
            return new PrincipalDetails(memberEntity);
        }
        return null;
    }
}
