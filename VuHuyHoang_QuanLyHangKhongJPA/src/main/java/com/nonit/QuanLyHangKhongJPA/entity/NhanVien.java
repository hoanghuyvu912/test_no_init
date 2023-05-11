package com.nonit.QuanLyHangKhongJPA.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "nhanvien")
@NamedQueries({
        @NamedQuery(name = "NhanVien.getByTen",
                query = "select nv from NhanVien nv where nv.ten = ?1")
        ,
        @NamedQuery(name = "NhanVien.getByTenContain",
                query = "select nv from NhanVien nv where nv.ten like ?1")
        ,
        @NamedQuery(name = "NhanVien.getByLuongGreaterThan",
                query = "select nv from NhanVien nv where nv.luong > ?1")
})

@NamedNativeQueries({
        @NamedNativeQuery(name = "NhanVien.getByLuongBetween",
                query = "select * from nhanvien nv where nv.luong between ?1 and ?2", resultClass = NhanVien.class)
        ,
        @NamedNativeQuery(name = "NhanVien.getByLuongLessThan",
                query = "select * from nhanvien nv where nv.luong  < ?1", resultClass = NhanVien.class)
        ,
        @NamedNativeQuery(name = "NhanVien.getByLuongIs",
                query = "select * from nhanvien nv where nv.luong = ?1", resultClass = NhanVien.class)
})

public class NhanVien {
    @Id
    @Column(name = "manv")
    private String maNV;

    @Column(name = "ten")
    private String ten;

    @Column(name = "luong")
    private Integer luong;
}
