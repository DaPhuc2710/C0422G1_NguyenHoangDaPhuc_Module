package com.example.work.model.contract;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dich_vu_di_kem")
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_dich_vu_di_kem")
    private Integer idAttachService;
    @Column(name = "ten_dich_vu_di_kem")
    private String nameAttachService;
    @Column(name = "gia")
    private Double attachPrice;
    @Column(name = "don_vi")
    private String unit;
    @Column(name = "trang_thai")
    private String status;
    @OneToMany (mappedBy = "attachService")
    List<DetailContract> detailContracts;

    public AttachService() {
    }

    public AttachService(String nameAttachService, Double attachPrice, String unit, String status, List<DetailContract> detailContracts) {
        this.nameAttachService = nameAttachService;
        this.attachPrice = attachPrice;
        this.unit = unit;
        this.status = status;
        this.detailContracts = detailContracts;
    }

    public AttachService(Integer idAttachService, String nameAttachService, Double attachPrice, String unit, String status, List<DetailContract> detailContracts) {
        this.idAttachService = idAttachService;
        this.nameAttachService = nameAttachService;
        this.attachPrice = attachPrice;
        this.unit = unit;
        this.status = status;
        this.detailContracts = detailContracts;
    }

    public Integer getIdAttachService() {
        return idAttachService;
    }

    public void setIdAttachService(Integer idAttachService) {
        this.idAttachService = idAttachService;
    }

    public String getNameAttachService() {
        return nameAttachService;
    }

    public void setNameAttachService(String nameAttachService) {
        this.nameAttachService = nameAttachService;
    }

    public Double getAttachPrice() {
        return attachPrice;
    }

    public void setAttachPrice(Double attachPrice) {
        this.attachPrice = attachPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DetailContract> getDetailContracts() {
        return detailContracts;
    }

    public void setDetailContracts(List<DetailContract> detailContracts) {
        this.detailContracts = detailContracts;
    }
}
