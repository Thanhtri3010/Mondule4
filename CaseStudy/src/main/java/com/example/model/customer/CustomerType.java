package com.example.model.customer;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerTypeId;
    private String customerTypeName;

    @OneToMany(mappedBy = "customerType", cascade = CascadeType.ALL)
    private Set<Customer> customerSet;

    public CustomerType() {
    }

    public CustomerType(int customerTypeId, String customerTypeName, Set<Customer> customerSet) {
        this.customerTypeId = customerTypeId;
        this.customerTypeName = customerTypeName;
        this.customerSet = customerSet;
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }
}
