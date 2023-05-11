package com.nonit.QuanLyHangKhongJPA.service;

import com.nonit.QuanLyHangKhongJPA.entity.ChungNhan;
import com.nonit.QuanLyHangKhongJPA.entity.MayBay;
import com.nonit.QuanLyHangKhongJPA.entity.NhanVien;
import com.nonit.QuanLyHangKhongJPA.exception.HangKhongException;
import com.nonit.QuanLyHangKhongJPA.repository.ChungNhanRepository;
import com.nonit.QuanLyHangKhongJPA.repository.ChuyenBayRepository;
import com.nonit.QuanLyHangKhongJPA.repository.MayBayRepository;
import com.nonit.QuanLyHangKhongJPA.repository.NhanVienRepository;
import com.nonit.QuanLyHangKhongJPA.service.dto.ChungNhanDTO;
import com.nonit.QuanLyHangKhongJPA.service.dto.ChungNhanRestDTO;
import com.nonit.QuanLyHangKhongJPA.service.mapper.ChungNhanMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChungNhanService {
    private final ChungNhanRepository chungNhanRepository;
    private final NhanVienRepository nhanVienRepository;
    private final MayBayRepository mayBayRepository;

    public List<ChungNhanRestDTO> getAllChungNhan() {
        return ChungNhanMapper.INSTANCE.toRestDTOs(chungNhanRepository.findAll());
    }

    public ChungNhanRestDTO createChungNhan(ChungNhanDTO chungNhanDTO) {
        NhanVien nhanVien = nhanVienRepository.findById(chungNhanDTO.getMaNV()).orElseThrow(HangKhongException::NhanVienNotFound);
        MayBay mayBay = mayBayRepository.findById(chungNhanDTO.getMaMB()).orElseThrow(HangKhongException::MayBayNotFound);

        ChungNhan chungNhan = new ChungNhan();

        chungNhan.setNhanVien(nhanVien);

        chungNhan.setMayBay(mayBay);

        return ChungNhanMapper.INSTANCE.toRestDTO(chungNhanRepository.save(chungNhan));
    }
}
