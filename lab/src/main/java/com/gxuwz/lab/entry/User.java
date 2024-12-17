package com.gxuwz.lab.entry;


/**
 * @author Fonrye
 * @version 1.0
 * @creat by IntelliJ IDEA
 * @date 2021/6/4 21:16
 **/

public class User implements java.io.Serializable {


    // Fields    

    private Integer id;
    private String userId;
    private String userName;
    private String pwd;
    private String phoneNum;
    private Integer roleId;
    private Integer sectionId;
    private String labName;
    private String major;
    private String college;
    private String clas;
    private String phone;
    private String email;
    private String sectionName;
    private String grade;

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public User() {
    }


    /**
     * full constructor
     */
    public User(String userId, String userName, String pwd, String phoneNum, Integer roleId, Integer sectionId,
                String major, String college,String clas,String phone,String email,String grade) {
        this.userId = userId;
        this.userName = userName;
        this.pwd = pwd;
        this.phoneNum = phoneNum;
        this.roleId = roleId;
        this.sectionId = sectionId;
        this.major = major;
        this.college = college;
        this.clas = clas;
        this.phone = phone;
        this.email = email;
        this.grade = grade;
    }


    // Property accessors

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getphoneNum() {
        return this.phoneNum;
    }

    public void setphoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getSectionId() {
        return this.sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", roleId=" + roleId +
                ", sectionId=" + sectionId +
                ", major='" + major + '\'' +
                ", college='" + college + '\'' +
                ", clas='" + clas + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }


}