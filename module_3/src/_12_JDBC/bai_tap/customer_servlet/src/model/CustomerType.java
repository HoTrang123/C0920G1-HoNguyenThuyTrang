package model;

public class CustomerType {
    private int customerTypeId;
    private String customerTypeName;

    public CustomerType() {

    }

    public CustomerType(int customer_type_id, String customer_type_name) {
        this.customerTypeId = customer_type_id;
        this.customerTypeName = customer_type_name;
    }

    public int getCustomer_type_id() {
        return customerTypeId;
    }

    public void setCustomer_type_id(int customer_type_id) {
        this.customerTypeId = customer_type_id;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }
}
