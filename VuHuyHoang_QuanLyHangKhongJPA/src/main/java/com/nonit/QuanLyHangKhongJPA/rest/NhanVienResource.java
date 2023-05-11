package com.nonit.QuanLyHangKhongJPA.rest;

import com.nonit.QuanLyHangKhongJPA.entity.NhanVien;
import com.nonit.QuanLyHangKhongJPA.exception.HangKhongException;
import com.nonit.QuanLyHangKhongJPA.service.NhanVienService;
import com.nonit.QuanLyHangKhongJPA.service.dto.NhanVienByNumOfPlanesDTO;
import com.nonit.QuanLyHangKhongJPA.service.dto.NhanVienRestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NhanVienResource implements NhanVienAPI {
    private final NhanVienService nhanVienService;

    @Override
    public ResponseEntity<List<NhanVienRestDTO>> getAllNV() {
        return ResponseEntity.ok(nhanVienService.getAllNV());
    }

    @Override
    public ResponseEntity<List<NhanVienRestDTO>> getByTen(String ten) {
        return ResponseEntity.ok(nhanVienService.getByTen(ten));
    }

    @Override
    public ResponseEntity<List<NhanVienRestDTO>> getByTenContain(String s) {
        return ResponseEntity.ok(nhanVienService.getByTenContain(s));
    }

    @Override
    public ResponseEntity<List<NhanVienRestDTO>> getByTenStartWith(String s) {
        return ResponseEntity.ok(nhanVienService.getByTenStartWith(s));
    }

    @Override
    public ResponseEntity<List<NhanVienRestDTO>> getByTenEndWith(String s) {
        return ResponseEntity.ok(nhanVienService.getByTenEndWith(s));
    }

    @Override
    public ResponseEntity<List<NhanVienRestDTO>> getByTenNotLike(String s) {
        return ResponseEntity.ok(nhanVienService.getByTenNotLike(s));
    }

    @Override
    public ResponseEntity<List<NhanVienRestDTO>> getByLuongBetween(String luong1, String luong2) {
        boolean valid = true;
        Integer luongInt1 = 0;
        Integer luongInt2 = 0;
        if (luong1 == null || luong1.trim().isBlank() || luong1.isEmpty() || luong2 == null || luong2.trim().isBlank() || luong2.isEmpty()) {
            valid = false;
        } else {
            try {
                luongInt1 = Integer.parseInt(luong1);
                luongInt2 = Integer.parseInt(luong2);
            } catch (Exception e) {
                valid = false;
            }
        }
        if (valid) {
            return ResponseEntity.ok(nhanVienService.getByLuongBetween(luongInt1, luongInt2));
        } else {
            throw HangKhongException.badRequest("InvalidInput", "Invalid Luong input!");
        }
    }

    @Override
    public ResponseEntity<List<NhanVienRestDTO>> getByLuongLessThan(String luong) {
        boolean valid = true;
        Integer luongInt = 0;
        if (luong == null || luong.trim().isBlank() || luong.isEmpty()) {
            valid = false;
        } else {
            try {
                luongInt = Integer.parseInt(luong);
            } catch (Exception e) {
                valid = false;
            }
        }
        if (valid) {
            return ResponseEntity.ok(nhanVienService.getByLuongLessThan(luongInt));
        } else {
            throw HangKhongException.badRequest("InvalidInput", "Invalid Luong input!");
        }
    }

    @Override
    public ResponseEntity<List<NhanVienRestDTO>> getByLuongIs(String luong) {
        boolean valid = true;
        Integer luongInt = 0;
        if (luong == null || luong.trim().isBlank() || luong.isEmpty()) {
            valid = false;
        } else {
            try {
                luongInt = Integer.parseInt(luong);
            } catch (Exception e) {
                valid = false;
            }
        }
        if (valid) {
            return ResponseEntity.ok(nhanVienService.getByLuongIs(luongInt));
        } else {
            throw HangKhongException.badRequest("InvalidInput", "Invalid Luong input!");
        }
    }

    @Override
    public ResponseEntity<List<NhanVienRestDTO>> getByLuongGreaterThan(String luong) {
        boolean valid = true;
        Integer luongInt = 0;
        if (luong == null || luong.trim().isBlank() || luong.isEmpty()) {
            valid = false;
        } else {
            try {
                luongInt = Integer.parseInt(luong);
            } catch (Exception e) {
                valid = false;
            }
        }
        if (valid) {
            return ResponseEntity.ok(nhanVienService.getByLuongGreaterThan(luongInt));
        } else {
            throw HangKhongException.badRequest("InvalidInput", "Invalid Luong input!");
        }
    }

    @Override
    public ResponseEntity<List<NhanVienRestDTO>> getByMaMB(Integer maMB) {
        return ResponseEntity.ok(nhanVienService.getByMaMB(maMB));
    }

    @Override
    public ResponseEntity<List<NhanVienByNumOfPlanesDTO>> getByNumberOfPlanesGreaterThan(Integer number) {
        return ResponseEntity.ok(nhanVienService.getByNumberOfPlanesGreaterThan(number));
    }
}
