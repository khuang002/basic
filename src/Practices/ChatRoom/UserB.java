package Practices.ChatRoom;

public class UserB extends User{
    public UserB(ChatRoom chatRoom) {
        super(chatRoom);
    }

    @Override
    public void sendMessage(String msg) {
        System.out.println("UserB sends: "+msg);
        chatRoom.notice(msg, this);
    }

    @Override
    public void getMessage(String msg) {
        System.out.println("UserB receives: "+msg);
    }
}