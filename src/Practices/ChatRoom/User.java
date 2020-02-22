package Practices.ChatRoom;
//
//public abstract class User {
//    protected AbstractChatRoom chatRoom;
//
//    public User(AbstractChatRoom chatRoom) {
//        this.chatRoom = chatRoom;
//    }
//
//    public abstract void sendMessage(String msg);
//
//    public abstract void getMessage(String msg);
//}
public abstract class User{
    protected ChatRoom chatRoom;

    public User(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
        chatRoom.register(this);
    }

    public abstract void sendMessage(String msg);
    public abstract void getMessage(String msg);
}