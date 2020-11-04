package com.liuqi.test;

public class Threadlocal2 {
    public static void main(String[] args) {
        new Service().procese();
    }
}

class Service{
    public void procese(){
        User user= new User("zhasnghh");
        UserContexHolder.holder.set(user);
        new Service1().procese();
    }
}
class Service1{
    public void procese(){
        User user = UserContexHolder.holder.get();
        System.out.println("Service1=="+user.getUserName());
        new Service2().procese();
    }
}
class Service2{
    public void procese(){
        User user = UserContexHolder.holder.get();
        System.out.println("Service1=="+user.getUserName());
        UserContexHolder.holder.remove();
    }
}
class UserContexHolder{
    public static ThreadLocal<User> holder = new ThreadLocal();
}



class User{
    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}