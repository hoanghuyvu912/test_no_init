package com.nonit.QuanLyHangKhongJPA.service;

import com.nonit.QuanLyHangKhongJPA.entity.MayBay;
import com.nonit.QuanLyHangKhongJPA.entity.NhanVien;
import com.nonit.QuanLyHangKhongJPA.exception.HangKhongException;
import com.nonit.QuanLyHangKhongJPA.repository.MayBayRepository;
import com.nonit.QuanLyHangKhongJPA.repository.NhanVienRepository;
import com.nonit.QuanLyHangKhongJPA.service.dto.CustomMayBayDTO;
import com.nonit.QuanLyHangKhongJPA.service.dto.CustomMayBayInterfaceDTO;
import com.nonit.QuanLyHangKhongJPA.service.dto.MayBayRestDTO;
import com.nonit.QuanLyHangKhongJPA.service.mapper.MayBayMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MayBayService {
    private final MayBayRepository mayBayRepository;
    private final NhanVienRepository nhanVienRepository;

    public List<MayBayRestDTO> getAllMayBay() {
        return MayBayMapper.INSTANCE.toRestDTOs(mayBayRepository.findAll());
    }

    public MayBayRestDTO getByLoai(String loai) {
        if (loai == null || loai.trim().isBlank() || loai.isEmpty()) {
            throw HangKhongException.badRequest("StringNotFound", "Search string is missing.");
        }
        return MayBayMapper.INSTANCE.toRestDTO(mayBayRepository.getByLoai(loai));
    }

    public List<MayBayRestDTO> getByLoaiContain(String s) {
        if (s == null || s.trim().isBlank() || s.isEmpty()) {
            throw HangKhongException.badRequest("StringNotFound", "Search string is missing.");
        }
        return MayBayMapper.INSTANCE.toRestDTOs(mayBayRepository.getByLoaiContain("%" + s + "%"));
    }

    public List<MayBayRestDTO> getByLoaiStartWith(String s) {
        if (s == null || s.trim().isBlank() || s.isEmpty()) {
            throw HangKhongException.badRequest("StringNotFound", "Search string is missing.");
        }
        return MayBayMapper.INSTANCE.toRestDTOs(mayBayRepository.getByLoaiStartWith(s));
    }

    public List<MayBayRestDTO> getByLoaiEndWith(String s) {
        if (s == null || s.trim().isBlank() || s.isEmpty()) {
            throw HangKhongException.badRequest("StringNotFound", "Search string is missing.");
        }
        return MayBayMapper.INSTANCE.toRestDTOs(mayBayRepository.getByLoaiEndWith(s));
    }

    public List<MayBayRestDTO> getByLoaiNotLike(String s) {
        if (s == null || s.trim().isBlank() || s.isEmpty()) {
            throw HangKhongException.badRequest("StringNotFound", "Search string is missing.");
        }
        return MayBayMapper.INSTANCE.toRestDTOs(mayBayRepository.getByLoaiNotLike(s));
    }

    public List<MayBayRestDTO> getByMaNV(String maNV) {
        if (maNV == null || maNV.trim().isBlank() || maNV.isEmpty()) {
            throw HangKhongException.badRequest("MaNVNotFound", "Search string is missing.");
        }
        NhanVien nhanVien = nhanVienRepository.findById(maNV).orElseThrow(HangKhongException::NhanVienNotFound);
        return MayBayMapper.INSTANCE.toRestDTOs(mayBayRepository.getByMaNV(maNV));
    }


    public List<MayBayRestDTO> getByTamBayBetween(Integer i1, Integer i2) {
        if (i1 <= 0 || i2 <= 0) {
            throw HangKhongException.badRequest("InvalidNumber", "Tam bay must be a positive number.");
        }
        return MayBayMapper.INSTANCE.toRestDTOs(mayBayRepository.getByTamBayBetween(i1, i2));
    }

    public List<MayBayRestDTO> getByTamBayLessThan(Integer i) {
        if (i <= 0) {
            throw HangKhongException.badRequest("InvalidNumber", "Tam bay must be a positive number.");
        }
        return MayBayMapper.INSTANCE.toRestDTOs(mayBayRepository.getByTamBayLessThan(i));
    }

    public List<MayBayRestDTO> getByTamBayIs(Integer i) {
        if (i <= 0) {
            throw HangKhongException.badRequest("InvalidNumber", "Tam bay must be a positive number.");
        }
        return MayBayMapper.INSTANCE.toRestDTOs(mayBayRepository.getByTamBayIs(i));
    }

    public List<MayBayRestDTO> getByTamBayGreaterThan(Integer i) {
        if (i <= 0) {
            throw HangKhongException.badRequest("InvalidNumber", "Tam bay must be a positive number.");
        }
        return MayBayMapper.INSTANCE.toRestDTOs(mayBayRepository.getByTamBayGreaterThan(i));
    }

    public List<CustomMayBayInterfaceDTO> getMaMBAndTamBayByLoaiLike(String loai) {
        if (loai == null || loai.trim().isBlank() || loai.isEmpty()) {
            throw HangKhongException.badRequest("StringNotFound", "Search string is missing.");
        }
        return mayBayRepository.getMaMBAndTamBayByLoaiLike(loai);
    }

    public List<CustomMayBayDTO> getMaMBAndLoaiMBByLoaiLike(String loai) {
        if (loai == null || loai.trim().isBlank() || loai.isEmpty()) {
            throw HangKhongException.badRequest("StringNotFound", "Search string is missing.");
        }
        return mayBayRepository.getMaMBAndLoaiMBByLoaiLike(loai);
    }
}
