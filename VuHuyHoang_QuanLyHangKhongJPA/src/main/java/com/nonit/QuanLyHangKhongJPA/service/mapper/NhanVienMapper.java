package com.nonit.QuanLyHangKhongJPA.service.mapper;

import com.nonit.QuanLyHangKhongJPA.entity.NhanVien;
import com.nonit.QuanLyHangKhongJPA.service.dto.NhanVienDTO;
import com.nonit.QuanLyHangKhongJPA.service.dto.NhanVienRestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NhanVienMapper {
    NhanVienMapper INSTANCE = Mappers.getMapper(NhanVienMapper.class);

    NhanVienRestDTO toRestDTO(NhanVien nhanVien);

    List<NhanVienRestDTO> toRestDTOs(List<NhanVien> nhanViens);

    NhanVienDTO toDTO(NhanVien nhanVien);

    List<NhanVienDTO> toDTOs(List<NhanVien> nhanViens);
}
