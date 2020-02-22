//design pattern: mediator pattern

package Practices.ChatRoom;
//
//public class Client {
//    public static void main(String[] args){
//        ChatRoom chatRoom = new ChatRoom();
//        UserA userA = new UserA(chatRoom);
//        UserB userB = new UserB(chatRoom);
//        chatRoom.register(userA);
//        chatRoom.register(userB);
//        userA.sendMessage("Hello!");
//        userB.sendMessage("GoodBye!");
//    }
//}

public class Client{
    public static void main(String[] args){
        ChatRoom chatRoom = new ChatRoom();
        User userA = new UserA(chatRoom);
        User userB = new UserB(chatRoom);
        userA.sendMessage("Hello!");
        userB.sendMessage("GoodBye!");
    }
}