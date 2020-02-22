package Practices.ChatRoom;
//
//public class UserA extends User {
//    public UserA(AbstractChatRoom chatRoom) {
//        super(chatRoom);
//    }
//
//    @Override
//    public void sendMessage(String msg){
//        System.out.println("User A sends: "+msg);
//        chatRoom.notice(msg, this);
//    }
//
//    @Override
//    public void getMessage(String msg){
//        System.out.println("User A received: "+msg);
//    }
//}
public class UserA extends User{
    public UserA(ChatRoom chatRoom) {
        super(chatRoom);
    }

    @Override
    public void sendMessage(String msg) {
        System.out.println("UserA sends: "+msg);
        chatRoom.notice(msg, this);
    }

    @Override
    public void getMessage(String msg) {
        System.out.println("UserA receives: "+msg);
    }
}