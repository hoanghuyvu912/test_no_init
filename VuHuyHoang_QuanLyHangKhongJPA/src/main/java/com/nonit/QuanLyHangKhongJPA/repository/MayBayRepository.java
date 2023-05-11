package com.nonit.QuanLyHangKhongJPA.repository;

import com.nonit.QuanLyHangKhongJPA.entity.MayBay;
import com.nonit.QuanLyHangKhongJPA.entity.NhanVien;
import com.nonit.QuanLyHangKhongJPA.service.dto.CustomMayBayDTO;
import com.nonit.QuanLyHangKhongJPA.service.dto.CustomMayBayInterfaceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MayBayRepository extends JpaRepository<MayBay, Integer> {
    MayBay getByLoai(String loai);

    List<MayBay> getByLoaiContain(String s);

    List<MayBay> getByTamBayGreaterThan(Integer i);

    List<MayBay> getByTamBayBetween(Integer i1, Integer i2);

    List<MayBay> getByTamBayLessThan(Integer i);

    List<MayBay> getByTamBayIs(Integer i);

    @Query(value = "SELECT * from maybay mb where mb.loai LIKE ?1%", nativeQuery = true)
    List<MayBay> getByLoaiStartWith(String s);

    @Query(value = "SELECT * from maybay mb where mb.loai LIKE %?1", nativeQuery = true)
    List<MayBay> getByLoaiEndWith(String s);

    @Query(value = "SELECT * from maybay mb where mb.loai NOT LIKE %?1%", nativeQuery = true)
    List<MayBay> getByLoaiNotLike(String s);

    @Query(value = "SELECT mb.* from maybay mb join chungnhan cn on mb.mamb = cn.mamb where cn.maNV = :maNV", nativeQuery = true)
    List<MayBay> getByMaNV(@Param("maNV") String maNV);

    @Query(value = "SELECT new com.nonit.QuanLyHangKhongJPA.service.dto.CustomMayBayDTO(m.maMB, m.loai) from MayBay m where m.loai LIKE %:loai%")
    List<CustomMayBayDTO> getMaMBAndLoaiMBByLoaiLike(@Param("loai") String loai);

    @Query(value = "SELECT m.mamb as maMB, m.tambay as tamBay from MayBay m where m.loai LIKE %?1%", nativeQuery = true)
    List<CustomMayBayInterfaceDTO> getMaMBAndTamBayByLoaiLike(String loai);
}
