package com.nonit.QuanLyHangKhongJPA.service.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienRestDTO {
    private String maNV;
    private String ten;
    private Integer luong;
}
