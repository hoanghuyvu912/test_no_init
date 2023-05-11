package com.nonit.QuanLyHangKhongJPA.service;

import com.nonit.QuanLyHangKhongJPA.entity.ChuyenBay;
import com.nonit.QuanLyHangKhongJPA.exception.HangKhongException;
import com.nonit.QuanLyHangKhongJPA.repository.ChuyenBayRepository;
import com.nonit.QuanLyHangKhongJPA.service.dto.ChuyenBayRestDTO;
import com.nonit.QuanLyHangKhongJPA.service.mapper.ChuyenBayMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChuyenBayService {
    private final ChuyenBayRepository chuyenBayRepository;

    public List<ChuyenBayRestDTO> getByGaDi(String gaDi) {
        if (gaDi == null || gaDi.trim().isBlank() || gaDi.isEmpty()) {
            throw HangKhongException.badRequest("StringNotFound", "Search string is missing.");
        }
        return ChuyenBayMapper.INSTANCE.toRestDTOs(chuyenBayRepository.getByGaDi(gaDi));
    }

    public List<ChuyenBayRestDTO> getByGaDiContain(String s) {
        if (s == null || s.trim().isBlank() || s.isEmpty()) {
            throw HangKhongException.badRequest("StringNotFound", "Search string is missing.");
        }
        return ChuyenBayMapper.INSTANCE.toRestDTOs(chuyenBayRepository.getByGaDiContain(s));
    }

    public List<ChuyenBayRestDTO> getByDoDaiGreaterThan(Integer i) {
        if (i <= 0) {
            throw HangKhongException.badRequest("InvalidDoDaiNumber", "Do Dai must be a positive number.");
        }
        return ChuyenBayMapper.INSTANCE.toRestDTOs(chuyenBayRepository.getByDoDaiGreaterThan(i));
    }

    public List<ChuyenBayRestDTO> getByGaDiAndGaDen(String gaDi, String gaDen) {
        if (gaDi == null || gaDi.trim().isBlank() || gaDi.isEmpty()) {
            throw HangKhongException.badRequest("GaDiStringNotFound", "Search string for Ga Di is missing.");
        }
        if (gaDen == null || gaDen.trim().isBlank() || gaDen.isEmpty()) {
            throw HangKhongException.badRequest("GaDenStringNotFound", "Search string for Ga Den is missing.");
        }
        return ChuyenBayMapper.INSTANCE.toRestDTOs(chuyenBayRepository.getByGaDiAndGaDen(gaDi, gaDen));
    }

    public List<ChuyenBayRestDTO> getByLoaiMayBay(String loai) {
        if (loai == null || loai.trim().isBlank() || loai.isEmpty()) {
            throw HangKhongException.badRequest("StringNotFound", "Search string is missing.");
        }
        return ChuyenBayMapper.INSTANCE.toRestDTOs(chuyenBayRepository.getByLoaiMayBay(loai));
    }

    public List<ChuyenBayRestDTO> getByBoeing() {
        return ChuyenBayMapper.INSTANCE.toRestDTOs(chuyenBayRepository.getByBoeing());
    }

    public List<ChuyenBayRestDTO> getAllChuyenBay() {
        return ChuyenBayMapper.INSTANCE.toRestDTOs(chuyenBayRepository.findAll());
    }

    public List<ChuyenBayRestDTO> getByAirbusA320() {
        return ChuyenBayMapper.INSTANCE.toRestDTOs(chuyenBayRepository.getByAirbusA320());
    }

    public List<ChuyenBayRestDTO> getByDoDaiLessThan10000AndGreaterThan8000() {
        return ChuyenBayMapper.INSTANCE.toRestDTOs(chuyenBayRepository.getByDoDaiLessThan10000AndGreaterThan8000());
    }

    public List<ChuyenBayRestDTO> getByDoDaiLessThan(Integer doDai) {
        if (doDai <= 0) {
            throw HangKhongException.badRequest("InvalidDoDaiNumber", "Do Dai must be a positive number.");
        }
        return ChuyenBayMapper.INSTANCE.toRestDTOs(chuyenBayRepository.getByDoDaiLessThan(doDai));
    }

    public List<ChuyenBayRestDTO> getByDoDaiIs(Integer doDai) {
        if (doDai <= 0) {
            throw HangKhongException.badRequest("InvalidDoDaiNumber", "Do Dai must be a positive number.");
        }
        return ChuyenBayMapper.INSTANCE.toRestDTOs(chuyenBayRepository.getByDoDaiIs(doDai));
    }

    public List<ChuyenBayRestDTO> getByDoDaiBetween(Integer doDai1, Integer doDai2) {
        if (doDai1 <= 0 || doDai2 <= 0) {
            throw HangKhongException.badRequest("InvalidDoDaiNumber", "Do Dai must be a positive number.");
        }
        return ChuyenBayMapper.INSTANCE.toRestDTOs(chuyenBayRepository.getByDoDaiBetween(doDai1, doDai2));
    }

    public List<ChuyenBayRestDTO> getByLoaiGaDiSGNAndGaDenBMV() {
        return ChuyenBayMapper.INSTANCE.toRestDTOs(chuyenBayRepository.getByLoaiGaDiSGNAndGaDenBMV());
    }

    public List<ChuyenBayRestDTO> getByGioDiSoonerThanASpecificTime(LocalTime time) {
        return ChuyenBayMapper.INSTANCE.toRestDTOs(chuyenBayRepository.getByGioDiSoonerThanASpecificTime(time));
    }

    public List<ChuyenBayRestDTO> getByGioDiBefore12() {
        return ChuyenBayMapper.INSTANCE.toRestDTOs(chuyenBayRepository.getByGioDiBefore12());
    }

    public Integer getCountChuyenBayByGadi(String gaDi) {
        if (gaDi == null || gaDi.trim().isBlank() || gaDi.isEmpty()) {
            throw HangKhongException.badRequest("StringNotFound", "Search string is missing.");
        }
        return chuyenBayRepository.getCountChuyenBayByGadi(gaDi);
    }

    public List<ChuyenBayRestDTO> timChuyenBayXuatPhatTu(String gaDi) {
        if (gaDi == null || gaDi.trim().isBlank() || gaDi.isEmpty()) {
            throw HangKhongException.badRequest("StringNotFound", "Search string is missing.");
        }
        return ChuyenBayMapper.INSTANCE.toRestDTOs(chuyenBayRepository.timChuyenBayXuatPhatTu(gaDi));
    }
}
