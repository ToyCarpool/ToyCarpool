package kt.carpool.config.auth;

import kt.carpool.domain.Member;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Data
public class PrincipalDetails implements UserDetails, OAuth2User{

    private Optional<Member> member;
    private Map<String, Object> attributes;

    // 일반 로그인 생성자
    public PrincipalDetails(Optional<Member> member) { this.member = member; }

    // OAuth 로그인 생성자
    public PrincipalDetails(Optional<Member> member, Map<String, Object> attributes){
        this.member = member;
        this.attributes = attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return member.get().getRole();
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return member.get().getPassword();
    }

    @Override
    public String getUsername() {
        return member.get().getUsername();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
