package Practices.ChatRoom;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ChatRoom extends AbstractChatRoom {
//    private List<User> users = new ArrayList<>();
//
//    public void register(User user){
//        users.add(user);
//    }
//
//    @Override
//    public void notice(String message, User user){
//        for (User u : users){
//            if (u != user){
//                u.getMessage(message);
//            }
//        }
//    }
//}

import java.util.ArrayList;
import java.util.List;

public class ChatRoom implements AbstractChatRoom{
    private List<User> users = new ArrayList<>();

    public ChatRoom(){}

    @Override
    public void register(User user) {
            users.add(user);
    }

    @Override
    public void notice(String message, User user) {
        for(User u : users){
            if (u != user){
                u.getMessage(message);
            }
        }
    }
}