package com.example.work.repository;

import com.example.work.dto.DetailContractQuantity;
import com.example.work.model.contract.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IAttachServiceRepository extends JpaRepository<AttachService, Integer> {
    @Query(value = "select \n" +
            "dvdk.ten_dich_vu_di_kem,\n" +
            "dvdk.gia,\n" +
            "dvdk.don_vi\n" +
            "from dich_vu_di_kem dvdk\n" +
            "left join hop_dong_chi_tiet hdct on hdct.ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem\n" +
            "where hdct.ma_hop_dong=:idContract", nativeQuery = true)
    List<AttachService> showListOfAttach(@Param("idContract") Integer id);

    @Query(value = "select\n" +
            "dvdk.ma_dich_vu_di_kem as idAttach, \n" +
            "dvdk.ten_dich_vu_di_kem as nameAttach,\n" +
            "dvdk.gia as price,\n" +
            "dvdk.don_vi as unit,\n" +
            "dvdk.trang_thai as `status`,\n" +
            "sum(hdct.so_luong) as quantity\n" +
            "from dich_vu_di_kem dvdk\n" +
            "left join hop_dong_chi_tiet hdct on hdct.ma_dich_vu_di_kem=dvdk.ma_dich_vu_di_kem\n" +
            "where hdct.ma_hop_dong=:idContract\n" +
            "group by dvdk.ma_dich_vu_di_kem",nativeQuery = true)
    List<DetailContractQuantity> showListOfAttachTotal(@Param("idContract") Integer id);
}
