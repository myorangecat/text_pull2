public class User  implements UserServe{
    public String name;
    public String sex;
    public String phone_number;
    public String address;
    UserInfo user=new UserInfo();

    @Override
    public void setUserName() {
        this.name=user.getNAME();
    }

    @Override
    public void setSex() {
        this.sex=user.getSEX();
    }

    @Override
    public void setPhoneNumber() {
        this.phone_number=user.getPhoneNumber();
    }

    @Override
    public void setAddress() {
        this.address=user.getADDRESS();
    }
}
