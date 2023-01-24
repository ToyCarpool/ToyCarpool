package kt.carpool.utils;

import kt.carpool.domain.Board;
import kt.carpool.domain.Member;
import kt.carpool.dto.BoardDto;
import kt.carpool.dto.MemberDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class MemberUtils {
    public Member toEntity(MemberDto dto) {
        return new Member().builder()
                .username(dto.getUsername())
                .name(dto.getName())
                .password(dto.getPassword())
                .build();
    }
    public MemberDto toDto(Member entity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, MemberDto.class);
    }
}
