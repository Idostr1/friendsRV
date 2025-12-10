package il.co.myfriends.model;

import java.util.Objects;

public class Friend extends BaseEntity{
    private String Family;
    private String Name;
    private String picture;
    private long birthDate;
    private String category;

    public  Friend(){}

    public Friend(String family, String name) {
        Family = family;
        Name = name;
    }
    public String getFamily() {
        return Family;
    }

    public void setFamily(String family) {
        Family = family;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Friend)) return false;
        if (!super.equals(o)) return false;
        Friend friend = (Friend) o;
        return birthDate == friend.birthDate && Objects.equals(Family, friend.Family) && Objects.equals(Name, friend.Name) && Objects.equals(picture, friend.picture) && Objects.equals(category, friend.category);
    }
}
