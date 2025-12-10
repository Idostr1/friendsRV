package il.co.myfriends.model;
public class Friends extends BaseList<Friend,Friend>{
    public Friends getAllFriends(){
        add(new Friend("knee", "hurts"));
        add(new Friend("hate", "etah"));
        add(new Friend("di", "skib"));
        add(new Friend("ras", "putin"));
        add(new Friend("nataniyahu", "bibi"));
        add(new Friend("clinton", "bill"));
        add(new Friend("di", "skib"));
        add(new Friend("ras", "putin"));
        add(new Friend("nataniyahu", "bibi"));
        add(new Friend("clinton", "bill"));
        return this;
    }
}

