package com.nonit.QuanLyHangKhongJPA.rest;

import com.nonit.QuanLyHangKhongJPA.entity.MayBay;
import com.nonit.QuanLyHangKhongJPA.entity.MayBay;
import com.nonit.QuanLyHangKhongJPA.exception.HangKhongException;
import com.nonit.QuanLyHangKhongJPA.service.MayBayService;
import com.nonit.QuanLyHangKhongJPA.service.dto.CustomMayBayDTO;
import com.nonit.QuanLyHangKhongJPA.service.dto.CustomMayBayInterfaceDTO;
import com.nonit.QuanLyHangKhongJPA.service.dto.MayBayRestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MayBayResource implements MayBayAPI {
    private final MayBayService mayBayService;

    @Override
    public ResponseEntity<List<MayBayRestDTO>> getAllMayBay() {
        return ResponseEntity.ok(mayBayService.getAllMayBay());
    }


    @Override
    public ResponseEntity<MayBayRestDTO> getByLoai(String loai) {
        return ResponseEntity.ok(mayBayService.getByLoai(loai));
    }

    @Override
    public ResponseEntity<List<MayBayRestDTO>> getByLoaiContain(String s) {
        return ResponseEntity.ok(mayBayService.getByLoaiContain(s));
    }

    @Override
    public ResponseEntity<List<MayBayRestDTO>> getByLoaiStartWith(String s) {
        return ResponseEntity.ok(mayBayService.getByLoaiStartWith(s));
    }

    @Override
    public ResponseEntity<List<MayBayRestDTO>> getByLoaiEndWith(String s) {
        return ResponseEntity.ok(mayBayService.getByLoaiEndWith(s));
    }

    @Override
    public ResponseEntity<List<MayBayRestDTO>> getByLoaiNotLike(String s) {
        return ResponseEntity.ok(mayBayService.getByLoaiNotLike(s));
    }

    @Override
    public ResponseEntity<List<MayBayRestDTO>> getByTamBayBetween(String tamBay1, String tamBay2) {
        boolean valid = true;
        Integer tamBayInt1 = 0;
        Integer tamBayInt2 = 0;
        if (tamBay1 == null || tamBay1.trim().isBlank() || tamBay1.isEmpty() || tamBay2 == null || tamBay2.trim().isBlank() || tamBay2.isEmpty()) {
            valid = false;
        } else {
            try {
                tamBayInt1 = Integer.parseInt(tamBay1);
                tamBayInt2 = Integer.parseInt(tamBay2);
            } catch (Exception e) {
                valid = false;
            }
        }
        if (valid) {
            return ResponseEntity.ok(mayBayService.getByTamBayBetween(tamBayInt1, tamBayInt2));
        } else {
            throw HangKhongException.badRequest("InvalidInput", "Invalid Tam Bay input!");
        }
    }

    @Override
    public ResponseEntity<List<MayBayRestDTO>> getByTamBayLessThan(String tamBay) {
        boolean valid = true;
        Integer tamBayInt = 0;
        if (tamBay == null || tamBay.trim().isBlank() || tamBay.isEmpty()) {
            valid = false;
        } else {
            try {
                tamBayInt = Integer.parseInt(tamBay);
            } catch (Exception e) {
                valid = false;
            }
        }
        if (valid) {
            return ResponseEntity.ok(mayBayService.getByTamBayLessThan(tamBayInt));
        } else {
            throw HangKhongException.badRequest("InvalidInput", "Invalid Tam Bay input!");
        }
    }

    @Override
    public ResponseEntity<List<MayBayRestDTO>> getByTamBayIs(String tamBay) {
        boolean valid = true;
        Integer tamBayInt = 0;
        if (tamBay == null || tamBay.trim().isBlank() || tamBay.isEmpty()) {
            valid = false;
        } else {
            try {
                tamBayInt = Integer.parseInt(tamBay);
            } catch (Exception e) {
                valid = false;
            }
        }
        if (valid) {
            return ResponseEntity.ok(mayBayService.getByTamBayIs(tamBayInt));
        } else {
            throw HangKhongException.badRequest("InvalidInput", "Invalid Tam Bay input!");
        }
    }

    @Override
    public ResponseEntity<List<MayBayRestDTO>> getByTamBayGreaterThan(String tamBay) {
        boolean valid = true;
        Integer tamBayInt = 0;
        if (tamBay == null || tamBay.trim().isBlank() || tamBay.isEmpty()) {
            valid = false;
        } else {
            try {
                tamBayInt = Integer.parseInt(tamBay);
            } catch (Exception e) {
                valid = false;
            }
        }
        if (valid) {
            return ResponseEntity.ok(mayBayService.getByTamBayGreaterThan(tamBayInt));
        } else {
            throw HangKhongException.badRequest("InvalidInput", "Invalid Tam Bay input!");
        }
    }

    @Override
    public ResponseEntity<List<MayBayRestDTO>> getByMaNV(String maNV) {
        return ResponseEntity.ok(mayBayService.getByMaNV(maNV));
    }

    @Override
    public ResponseEntity<List<CustomMayBayInterfaceDTO>> getMaMBAndTamBayByLoaiLike(String loai) {
        return ResponseEntity.ok(mayBayService.getMaMBAndTamBayByLoaiLike(loai));
    }

    @Override
    public ResponseEntity<List<CustomMayBayDTO>> getMaMBAndLoaiMBByLoaiLike(String loai) {
        return ResponseEntity.ok(mayBayService.getMaMBAndLoaiMBByLoaiLike(loai));
    }
}
