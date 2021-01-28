package com.codegym.model.customer;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity(name = "customer")
public class Customer {
    @Id
    @NotBlank(message = "Do Not Blank")
    @Pattern(regexp = "^(KH-)\\d{4}$", message = "Invalid ID ! Format: KH-XXXX (X: 0- 9)")
    private String id;

    @NotBlank(message = "Do Not Blank")
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @NotBlank(message = "Do Not Blank")
    private String gender;

    @Pattern(regexp = "^(\\d{9})|(\\d{12})$",
            message = "Invalid ID card ! Format: XXXXXXXXX or XXXXXXXXXXXX (X: 0-9)")
    private String idCard;

    @Pattern(regexp = "^(090|091|\\(84\\)(\\+90|\\+91))(\\d{7})$",
            message = "Invalid Phone ! Format:  090xxxxxxx || 091xxxxxxx || (84)+90xxxxxxx || (84)+91xxxxxxx (x: 0-9)")
    private String phone;

    @NotBlank(message = "Do Not Blank")
    @Email(message = "Invalid Email ! Example: abc@abc.com.vn")
    private String email;

    @NotBlank(message = "Do Not Blank")
    private String address;


    //    ------------------------------------ Tạo Mối Quan Hệ ---------------------------------------------

    @ManyToOne
    @JoinColumn(name = "type_customer_id", referencedColumnName = "id")
    private TypeCustomer typeCustomer;
//    ---------------------------------------------------------------------------------------------------


    public Customer() {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public TypeCustomer getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(TypeCustomer typeCustomer) {
        this.typeCustomer = typeCustomer;
    }
}
