package Practices.ChatRoom;
//
//public abstract class AbstractChatRoom {
//    public abstract void notice(String message, User user);
//}

public interface AbstractChatRoom{
    public abstract void register(User user);
    public abstract void notice(String message, User user);
}