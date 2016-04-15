package net.xwdoor.superadapter.mock;

/**
 * Created by XWdoor on 2016/4/15 015 13:43.
 * 博客：http://blog.csdn.net/xwdoor
 */
public class MockModel {
    private String name;
    private int age;

    public MockModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
