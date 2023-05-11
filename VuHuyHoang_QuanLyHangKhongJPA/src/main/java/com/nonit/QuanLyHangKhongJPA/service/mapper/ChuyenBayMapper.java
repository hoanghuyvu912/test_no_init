package com.nonit.QuanLyHangKhongJPA.service.mapper;

import com.nonit.QuanLyHangKhongJPA.entity.ChuyenBay;
import com.nonit.QuanLyHangKhongJPA.service.dto.ChuyenBayDTO;
import com.nonit.QuanLyHangKhongJPA.service.dto.ChuyenBayRestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ChuyenBayMapper {
    ChuyenBayMapper INSTANCE = Mappers.getMapper(ChuyenBayMapper.class);

    ChuyenBayRestDTO toRestDTO(ChuyenBay chuyenBay);
    List<ChuyenBayRestDTO> toRestDTOs (List<ChuyenBay> chuyenBays);

    ChuyenBayDTO toDTO(ChuyenBay chuyenBay);
    List<ChuyenBayDTO> toDTOs (List<ChuyenBay> chuyenBays);
}
