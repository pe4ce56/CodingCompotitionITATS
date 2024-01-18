package Model;

public class Information {
    private int age;
    private String name;
    private String picture;
    private String selfieWithIdentityCard;

    public Information(int age, String name, String picture, String selfieWithIdentityCard) {
        this.age = age;
        this.name = name;
        this.picture = picture;
        this.selfieWithIdentityCard = selfieWithIdentityCard;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getSelfieWithIdentityCard() {
        return selfieWithIdentityCard;
    }

    public void setSelfieWithIdentityCard(String selfieWithIdentityCard) {
        this.selfieWithIdentityCard = selfieWithIdentityCard;
    }
}
