package kt.carpool.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import kt.carpool.dto.ChatMessage;
import kt.carpool.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@RequiredArgsConstructor
@Component
public class WebSocketHandler extends TextWebSocketHandler {
    private final ObjectMapper objectMapper;
    private final ChatService chatService;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
        // 메시지 들어오면
        String payload = message.getPayload();
        log.info("{}",payload);

        // json으로 들어온 내용을 ChatMessage에 맞게 변환 'type, roomId, sender, message'
        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);

        ChatRoom chatRoom = chatService.findRoomById(chatMessage.getRoomId());
        // 참여자가 현재 이미 채팅방에 접속된 상태인지, 채팅에 참여해있는지를 판별하여, 처음 참여하는거라면 session을 연결해줌과 동시에 메시지를 보낸다.
        chatRoom.handlerActions(session, chatMessage, chatService);

    }
}
