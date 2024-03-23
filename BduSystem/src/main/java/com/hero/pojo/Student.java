package com.hero.pojo;

/**
 * @author Heroxin
 * @create 2022-03-30-14:53
 * @Description:
 */
public class Student {

    private int stuId;
    private String stuName;
    private String stuGender;
    private String stuHome;
    private String stuProfession;
    private String stuTel;
    private String stuAddress;

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuGender() {
        return stuGender;
    }

    public void setStuGender(String stuGender) {
        this.stuGender = stuGender;
    }

    public String getStuHome() {
        return stuHome;
    }

    public void setStuHome(String stuHome) {
        this.stuHome = stuHome;
    }

    public String getStuProfession() {
        return stuProfession;
    }

    public void setStuProfession(String stuProfession) {
        this.stuProfession = stuProfession;
    }

    public String getStuTel() {
        return stuTel;
    }

    public void setStuTel(String stuTel) {
        this.stuTel = stuTel;
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuGender='" + stuGender + '\'' +
                ", stuHome='" + stuHome + '\'' +
                ", stuProfession='" + stuProfession + '\'' +
                ", stuTel='" + stuTel + '\'' +
                ", stuAddress='" + stuAddress + '\'' +
                '}';
    }
}
