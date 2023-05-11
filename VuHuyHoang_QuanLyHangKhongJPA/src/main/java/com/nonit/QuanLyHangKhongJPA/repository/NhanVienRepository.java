package com.nonit.QuanLyHangKhongJPA.repository;

import com.nonit.QuanLyHangKhongJPA.entity.NhanVien;
import com.nonit.QuanLyHangKhongJPA.service.dto.NhanVienByNumOfPlanesDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
    List<NhanVien> getByTen(String ten);

    List<NhanVien> getByTenContain(String s);

    List<NhanVien> getByLuongGreaterThan(Integer i);

    List<NhanVien> getByLuongBetween(Integer i1, Integer i2);

    List<NhanVien> getByLuongLessThan(Integer i);

    List<NhanVien> getByLuongIs(Integer i);

    @Query(value = "SELECT * from nhanvien nv where nv.ten LIKE ?1%", nativeQuery = true)
    List<NhanVien> getByTenStartWith(String s);

    @Query(value = "SELECT * from nhanvien nv where nv.ten LIKE %?1", nativeQuery = true)
    List<NhanVien> getByTenEndWith(String s);

    @Query(value = "SELECT * from nhanvien nv where nv.ten NOT LIKE %?1%", nativeQuery = true)
    List<NhanVien> getByTenNotLike(String s);

    @Query(value = "SELECT nv.* from nhanvien nv join chungnhan cn on nv.manv = cn.manv where cn.mamb = :maMB", nativeQuery = true)
    List<NhanVien> getByMaMB(@Param("maMB") Integer maMB);

    @Query(value = "SELECT new com.nonit.QuanLyHangKhongJPA.service.dto.NhanVienByNumOfPlanesDTO(nv.maNV, nv.ten, count(cn.mayBay.maMB)) from NhanVien nv join ChungNhan cn on nv.maNV = cn.nhanVien.maNV group by nv.maNV having count(cn.mayBay.maMB) > :number")
    List<NhanVienByNumOfPlanesDTO> getByNumberOfPlanesGreaterThan(@Param("number") Integer number);
}
