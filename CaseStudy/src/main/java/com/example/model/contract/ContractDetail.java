package com.example.model.contract;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "contractId", referencedColumnName = "contractId")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "attachFacilityId", referencedColumnName = "attachFacilityId")
    private AttachFacility attachFacility;

    private int quantity;


    public ContractDetail() {
    }

    public ContractDetail(int id, Contract contract, AttachFacility attachFacility, int quantity) {
        this.id = id;
        this.contract = contract;
        this.attachFacility = attachFacility;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
