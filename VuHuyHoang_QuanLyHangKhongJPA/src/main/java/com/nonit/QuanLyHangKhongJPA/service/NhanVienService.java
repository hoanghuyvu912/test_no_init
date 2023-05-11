package com.nonit.QuanLyHangKhongJPA.service;

import com.nonit.QuanLyHangKhongJPA.entity.MayBay;
import com.nonit.QuanLyHangKhongJPA.entity.NhanVien;
import com.nonit.QuanLyHangKhongJPA.exception.HangKhongException;
import com.nonit.QuanLyHangKhongJPA.repository.MayBayRepository;
import com.nonit.QuanLyHangKhongJPA.repository.NhanVienRepository;
import com.nonit.QuanLyHangKhongJPA.service.dto.NhanVienByNumOfPlanesDTO;
import com.nonit.QuanLyHangKhongJPA.service.dto.NhanVienRestDTO;
import com.nonit.QuanLyHangKhongJPA.service.mapper.NhanVienMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NhanVienService {
    private final NhanVienRepository nhanVienRepository;
    private final MayBayRepository mayBayRepository;

    public List<NhanVienRestDTO> getAllNV() {
        return NhanVienMapper.INSTANCE.toRestDTOs(nhanVienRepository.findAll());
    }

    public List<NhanVienRestDTO> getByTen(String ten) {
        if (ten == null || ten.trim().isBlank() || ten.isEmpty()) {
            throw HangKhongException.badRequest("TenStringNotFound", "Search string for Ten is missing.");
        }
        return NhanVienMapper.INSTANCE.toRestDTOs(nhanVienRepository.getByTen(ten));
    }

    public List<NhanVienRestDTO> getByTenContain(String s) {
        if (s == null || s.trim().isBlank() || s.isEmpty()) {
            throw HangKhongException.badRequest("TenStringNotFound", "Search string for Ten is missing.");
        }
        return NhanVienMapper.INSTANCE.toRestDTOs(nhanVienRepository.getByTenContain("%" + s + "%"));
    }

    public List<NhanVienRestDTO> getByTenStartWith(String s) {
        if (s == null || s.trim().isBlank() || s.isEmpty()) {
            throw HangKhongException.badRequest("TenStringNotFound", "Search string for Ten is missing.");
        }
        return NhanVienMapper.INSTANCE.toRestDTOs(nhanVienRepository.getByTenStartWith(s));
    }

    public List<NhanVienRestDTO> getByTenEndWith(String s) {
        if (s == null || s.trim().isBlank() || s.isEmpty()) {
            throw HangKhongException.badRequest("TenStringNotFound", "Search string for Ten is missing.");
        }
        return NhanVienMapper.INSTANCE.toRestDTOs(nhanVienRepository.getByTenEndWith(s));
    }

    public List<NhanVienRestDTO> getByTenNotLike(String s) {
        if (s == null || s.trim().isBlank() || s.isEmpty()) {
            throw HangKhongException.badRequest("TenStringNotFound", "Search string for Ten is missing.");
        }
        return NhanVienMapper.INSTANCE.toRestDTOs(nhanVienRepository.getByTenNotLike(s));
    }

    public List<NhanVienRestDTO> getByMaMB(Integer maMB) {
        MayBay mayBay = mayBayRepository.findById(maMB).orElseThrow(HangKhongException::MayBayNotFound);
        return NhanVienMapper.INSTANCE.toRestDTOs(nhanVienRepository.getByMaMB(maMB));
    }

    public List<NhanVienRestDTO> getByLuongBetween(Integer luong1, Integer luong2) {
        if (luong1 <= 0 || luong2 <= 0) {
            throw HangKhongException.badRequest("NegativeLuongInput", "Luong must be a positive number.");
        }
        return NhanVienMapper.INSTANCE.toRestDTOs(nhanVienRepository.getByLuongBetween(luong1, luong2));
    }

    public List<NhanVienRestDTO> getByLuongLessThan(Integer luong) {
        if (luong <= 0) {
            throw HangKhongException.badRequest("NegativeLuongInput", "Luong must be a positive number.");
        }
        return NhanVienMapper.INSTANCE.toRestDTOs(nhanVienRepository.getByLuongLessThan(luong));
    }

    public List<NhanVienRestDTO> getByLuongIs(Integer luong) {
        if (luong <= 0) {
            throw HangKhongException.badRequest("NegativeLuongInput", "Luong must be a positive number.");
        }
        return NhanVienMapper.INSTANCE.toRestDTOs(nhanVienRepository.getByLuongIs(luong));
    }

    public List<NhanVienRestDTO> getByLuongGreaterThan(Integer luong) {
        if (luong <= 0) {
            throw HangKhongException.badRequest("NegativeLuongInput", "Luong must be a positive number.");
        }
        return NhanVienMapper.INSTANCE.toRestDTOs(nhanVienRepository.getByLuongGreaterThan(luong));
    }

    public List<NhanVienByNumOfPlanesDTO> getByNumberOfPlanesGreaterThan(Integer number) {
        return nhanVienRepository.getByNumberOfPlanesGreaterThan(number);
    }
}
