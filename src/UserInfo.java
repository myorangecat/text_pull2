public class UserInfo {
    UserInfo(){};
    private static String NAME="李晓辉";
    private static String SEX="男";
    private static String PHONE_NUMBER="17693360684";
    private static String ADDRESS="湖北省武汉市";
    private static UserInfo user;
    public synchronized UserInfo getUserStance(){
        if(user==null){
            user=new UserInfo();
        }
        return user;
    }
    public  String getNAME() {
        return NAME;
    }

    public  String getSEX() {
        return SEX;
    }

    public String getPhoneNumber() {
        return PHONE_NUMBER;
    }

    public String getADDRESS() {
        return ADDRESS;
    }
}
