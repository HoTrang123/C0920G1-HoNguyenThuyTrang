package model;

public class ContractDetail {
    int contract_detail_id;
    int contract_id;
    int attach_service;
    int quantity;

    public ContractDetail() {
    }

    public ContractDetail(int contract_id, int attach_service, int quantity) {
        this.contract_id = contract_id;
        this.attach_service = attach_service;
        this.quantity = quantity;
    }

    public ContractDetail(int contract_detail_id, int contract_id, int attach_service, int quantity) {
        this.contract_detail_id = contract_detail_id;
        this.contract_id = contract_id;
        this.attach_service = attach_service;
        this.quantity = quantity;
    }

    public int getContract_detail_id() {
        return contract_detail_id;
    }

    public void setContract_detail_id(int contract_detail_id) {
        this.contract_detail_id = contract_detail_id;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public int getAttach_service() {
        return attach_service;
    }

    public void setAttach_service(int attach_service) {
        this.attach_service = attach_service;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
