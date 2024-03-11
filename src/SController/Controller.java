package SController;

import SEncap.Encap;
import SUtil.Util;

public class Controller {
    private final Util util;
    public  Controller()
    {
        util=new Util();

    }
    public void addUser(String name,String email,String phone,String gender,String address,String fName,String mName)
    {
        Encap user=new Encap(name,email,phone,gender,address,fName, mName);
        util.addUser(user);
    }
    public void update(String name,String email,String phone,String gender,String address,String fName,String mName)
    {
        Encap user=new Encap(name,email,phone,gender,fName,address,mName);
        util.update(user);
    }
    public void delete(String email)
    {
        Encap user=new Encap(email);
        util.delete(user);
    }

}

