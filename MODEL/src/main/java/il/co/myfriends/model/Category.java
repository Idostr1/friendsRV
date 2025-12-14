package il.co.myfriends.model;

import java.util.Objects;

public class Category extends BaseEntity{
    private String Name;

    public  Category(){}

    public Category(String name) {
        Name = name;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Category)) return false;
        if (!super.equals(o)) return false;
        Category category = (Category) o;
        return Objects.equals(Name, category.Name);
    }
}
