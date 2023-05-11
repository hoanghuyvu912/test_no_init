package com.nonit.QuanLyHangKhongJPA.service.mapper;

import com.nonit.QuanLyHangKhongJPA.entity.ChungNhan;
import com.nonit.QuanLyHangKhongJPA.service.dto.ChungNhanDTO;
import com.nonit.QuanLyHangKhongJPA.service.dto.ChungNhanRestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ChungNhanMapper {
    ChungNhanMapper INSTANCE = Mappers.getMapper(ChungNhanMapper.class);

    ChungNhanRestDTO toRestDTO(ChungNhan chungNhan);

    List<ChungNhanRestDTO> toRestDTOs(List<ChungNhan> chungNhans);

    ChungNhanDTO toDTO(ChungNhan chungNhan);

    List<ChungNhanDTO> toDTOs(List<ChungNhan> chungNhans);
}
