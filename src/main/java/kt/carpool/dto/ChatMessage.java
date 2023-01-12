package kt.carpool.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class ChatMessage {
    public enum MessageType{
        ENTER, TALK
    }

    private MessageType type; // ENTER, TALK
    private String roomId;
    private String sender; // 보내는 사람 닉네임
    private String message;

}
