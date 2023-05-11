package com.nonit.QuanLyHangKhongJPA.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienByNumOfPlanesDTO {
    private String maNV;
    private String ten;
    private Long numberOfPlanes;
}
