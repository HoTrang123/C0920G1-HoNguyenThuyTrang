package com.codegym.model.employee;


import com.codegym.model.contract.Contract;
import com.codegym.model.user.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity
public class Employee implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Do Not Blank")
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;

    @NotBlank(message = "Do Not Blank")
    @Pattern(regexp = "^(\\d{9})|(\\d{12})$",
            message = "Invalid ID card ! Format: XXXXXXXXX or XXXXXXXXXXXX (X: 0-9)")
    private String idCard;

    private Float salary;

    @NotBlank(message = "Do Not Blank")
    @Pattern(regexp = "^(090|091|\\(84\\)(\\+90|\\+91))(\\d{7})$",
            message = "Invalid Phone ! Format:  090xxxxxxx || 091xxxxxxx || (84)+90xxxxxxx || (84)+91xxxxxxx (x: 0-9)")
    private String phone;

    @NotBlank(message = "Do Not Blank")
    @Email(message = "Invalid Email ! Example: abc@abc.com.vn")
    private String email;

    @NotBlank(message = "Do Not Blank")
    private String address;
    // ------------------------------ Tạo mối quan hệ ------------------------------

    @ManyToOne
    @JoinColumn(name = "position_id" , nullable=false)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id" , nullable=false)
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id" ,nullable=false)
    private Division division;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Contract> contractList;

    public Employee() {
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getBirthDay() {
//        return birthDay;
//    }
//
//    public void setBirthDay(String birthDay) {
//        this.birthDay = birthDay;
//    }
//
//    public String getIdCard() {
//        return idCard;
//    }
//
//    public void setIdCard(String idCard) {
//        this.idCard = idCard;
//    }
//
//    public Float getSalary() {
//        return salary;
//    }
//
//    public void setSalary(Float salary) {
//        this.salary = salary;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public Position getPosition() {
//        return position;
//    }
//
//    public void setPosition(Position position) {
//        this.position = position;
//    }
//
//    public EducationDegree getEducationDegree() {
//        return educationDegree;
//    }
//
//    public void setEducationDegree(EducationDegree educationDegree) {
//        this.educationDegree = educationDegree;
//    }
//
//    public Division getDivision() {
//        return division;
//    }
//
//    public void setDivision(Division division) {
//        this.division = division;
//    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;
        if(employee.salary == null){
            errors.rejectValue("salary", "salary.empty");
        } else if (employee.salary <= 0){
            errors.rejectValue("salary","salary.positive");
        }
    }


}