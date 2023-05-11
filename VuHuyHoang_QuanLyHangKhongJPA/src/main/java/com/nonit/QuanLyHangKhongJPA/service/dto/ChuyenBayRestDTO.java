package com.nonit.QuanLyHangKhongJPA.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChuyenBayRestDTO {
    private String maCB;

    private String gaDi;

    private String gaDen;

    private Integer doDai;

    private LocalTime gioDi;

    private LocalTime gioDen;

    private Integer chiPhi;
}
