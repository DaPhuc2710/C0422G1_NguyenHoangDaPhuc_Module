package com.example.work.model.contract;

import javax.persistence.*;


@Entity
@Table(name = "hop_dong_chi_tiet")
public class DetailContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hop_dong_chi_tiet")
    private Integer idDetailContract;
    @Column(name = "so_luong")
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "ma_hop_dong", referencedColumnName = "ma_hop_dong")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "ma_dich_vu_di_kem", referencedColumnName = "ma_dich_vu_di_kem")
    private AttachService attachService;

    public DetailContract() {
    }

    public DetailContract(Integer idDetailContract, Integer quantity, Contract contract, AttachService attachService) {
        this.idDetailContract = idDetailContract;
        this.quantity = quantity;
        this.contract = contract;
        this.attachService = attachService;
    }

    public DetailContract(Integer quantity, Contract contract, AttachService attachService) {
        this.quantity = quantity;
        this.contract = contract;
        this.attachService = attachService;
    }

    public Integer getIdDetailContract() {
        return idDetailContract;
    }

    public void setIdDetailContract(Integer idDetailContract) {
        this.idDetailContract = idDetailContract;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
