package com.nonit.QuanLyHangKhongJPA.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ChungNhanId.class)
@Table(name = "chungnhan")
public class ChungNhan {
    @Id
    private NhanVien nhanVien;

    @Id
    private MayBay mayBay;
}
