package com.nonit.QuanLyHangKhongJPA.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MayBayRestDTO {
    private Integer maMB;
    private String loai;
    private Integer tamBay;
}
