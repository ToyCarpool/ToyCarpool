package kt.carpool.utils;

import kt.carpool.domain.Board;
import kt.carpool.domain.Member;
import kt.carpool.dto.BoardDto;
import kt.carpool.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BoardUtils {
    private final MemberRepository memberRepository;

    @Autowired
    public BoardUtils(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Board toEntity(BoardDto dto) {
        Board entity = new Board().builder()
                .member(memberRepository.findById(dto.getMember_id()).orElse(null))
                .title(dto.getTitle())
                .startTime(dto.getStartTime())
                .cost(dto.getCost())
                .description(dto.getDescription())
                .departure(dto.getDeparture())
                .destination(dto.getDestination())
                .negotiable(dto.getNegotiable())
                .open(dto.getOpen())
                .build();
        return entity;
    }

    public BoardDto toDto(Board entity) {
        PropertyMap<Board, BoardDto> boardMap = new PropertyMap<Board, BoardDto>() {
            protected void configure() {
                map().setMember_id(source.getMember().getId());
            }
        };
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(boardMap);
        return modelMapper.map(entity, BoardDto.class);
    }
}
