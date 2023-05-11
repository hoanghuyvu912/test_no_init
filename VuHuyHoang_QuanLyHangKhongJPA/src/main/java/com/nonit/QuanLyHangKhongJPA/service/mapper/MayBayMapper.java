package com.nonit.QuanLyHangKhongJPA.service.mapper;

import com.nonit.QuanLyHangKhongJPA.entity.MayBay;
import com.nonit.QuanLyHangKhongJPA.service.dto.MayBayDTO;
import com.nonit.QuanLyHangKhongJPA.service.dto.MayBayRestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MayBayMapper {
    MayBayMapper INSTANCE = Mappers.getMapper(MayBayMapper.class);

    MayBayRestDTO toRestDTO(MayBay mayBay);

    List<MayBayRestDTO> toRestDTOs(List<MayBay> mayBays);

    MayBayDTO toDTO(MayBay mayBay);

    List<MayBayDTO> toDTOs(List<MayBay> mayBays);
}
