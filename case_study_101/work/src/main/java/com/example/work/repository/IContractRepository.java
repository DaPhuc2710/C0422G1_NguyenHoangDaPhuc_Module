package com.example.work.repository;

import com.example.work.dto.ContractPage;
import com.example.work.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IContractRepository extends JpaRepository<Contract, Integer> {
    Page<Contract> findAllByCustomer_NameCustomerContaining(String name, Pageable pageable);

    @Query(value = "select \n" +
            "hd.ma_hop_dong as idContract,\n" +
            "dv.ten_dich_vu as serviceName,\n" +
            "kh.ho_ten as customerName,\n" +
            "hd.ngay_lam_hop_dong as startDay,\n" +
            "hd.ngay_ket_thuc as endDay,\n" +
            "hd.tien_dat_coc as deposit,\n" +
            "\n" +
            "SUM(ifnull(hdct.so_luong * dvdk.gia,0))+dv.chi_phi_thue AS toTal\n" +
            "FROM hop_dong hd\n" +
            "LEFT JOIN khach_hang kh ON kh.ma_khach_hang = hd.ma_khach_hang\n" +
            "LEFT JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu\n" +
            "LEFT JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong\n" +
            "LEFT JOIN dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem\n" +
            "GROUP BY hd.ma_hop_dong", nativeQuery = true, countQuery = "SELECT count(*) FROM hop_dong")
    Page<ContractPage>showListContractIncludeTotalCost(Pageable pageable);
}
