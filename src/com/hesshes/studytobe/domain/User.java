package com.hesshes.studytobe.domain;

// list 5-4
public class User {

    String id;
    String name;
    String password;

    Level level;
    int login;
    int recoomend;

    public User() {
    }

    public User(String id, String name, String password, Level level, int login, int recoomend) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.level = level;
        this.login = login;
        this.recoomend = recoomend;
    }

    public User(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public int getRecoomend() {
        return recoomend;
    }

    public void setRecoomend(int recoomend) {
        this.recoomend = recoomend;
    }

}
