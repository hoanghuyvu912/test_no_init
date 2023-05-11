package com.nonit.QuanLyHangKhongJPA.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ChungNhanId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "manv")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "mamb")
    private MayBay mayBay;
}
