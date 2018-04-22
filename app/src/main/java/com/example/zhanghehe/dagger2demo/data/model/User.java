package com.example.zhanghehe.dagger2demo.data.model;

public class User {

    private Long id;
    private String name;
    private String address;
    private String createAt;
    private String updateAt;

    public User() {
    }

    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "User{"+
                "id="+id+
                ",name='"+name+'\''+
                ",address'"+address+'\''+
                ",createdAt='"+address+'\''+
                ",updateAt='"+address+'\''+
                '}';
    }
}
