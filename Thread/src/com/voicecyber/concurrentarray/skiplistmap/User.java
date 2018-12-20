package com.voicecyber.concurrentarray.skiplistmap;

/**
 * Created by Sean on 2018/12/18
 *
 * @author Sean
 */
public class User implements Comparable<User> {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        if (this.getAge() < o.getAge()) {
            return -1;
        }
        if (this.getAge() > o.getAge()) {
            return 1;
        }
        return 0;
    }

    @Override
    public int hashCode() {
       User user= this;
       return user.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof User) {
            User user = (User) obj;
            return user.getName().equals(name);
        }

        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
