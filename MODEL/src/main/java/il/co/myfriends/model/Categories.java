package il.co.myfriends.model;
public class Categories extends BaseList<Category,Categories>{
    public Categories getAllCategories(){
        add(new Category("family"));
        add(new Category("work"));
        add(new Category("friends"));
        add(new Category("school"));
        add(new Category("other"));
        add(new Category("family"));
        add(new Category("work"));
        add(new Category("friends"));
        add(new Category("school"));
        add(new Category("other"));
        add(new Category("family"));
        add(new Category("work"));
        add(new Category("friends"));
        add(new Category("school"));
        add(new Category("other"));
        return this;
    }
}

