package com.nonit.QuanLyHangKhongJPA.rest;

import com.nonit.QuanLyHangKhongJPA.entity.ChuyenBay;
import com.nonit.QuanLyHangKhongJPA.exception.HangKhongException;
import com.nonit.QuanLyHangKhongJPA.service.ChuyenBayService;
import com.nonit.QuanLyHangKhongJPA.service.dto.ChuyenBayRestDTO;
import com.nonit.QuanLyHangKhongJPA.service.mapper.ChuyenBayMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChuyenBayResource implements ChuyenBayAPI {
    private final ChuyenBayService chuyenBayService;

    @Override
    public ResponseEntity<List<ChuyenBayRestDTO>> getAllChuyenBay() {
        return ResponseEntity.ok(chuyenBayService.getAllChuyenBay());
    }

    @Override
    public ResponseEntity<List<ChuyenBayRestDTO>> getByGaDi(String gaDi) {
        return ResponseEntity.ok(chuyenBayService.getByGaDi(gaDi));
    }

    @Override
    public ResponseEntity<List<ChuyenBayRestDTO>> getByGaDiContain(String s) {
        return ResponseEntity.ok(chuyenBayService.getByGaDiContain("%" + s + "%"));
    }

    @Override
    public ResponseEntity<List<ChuyenBayRestDTO>> getByDoDaiGreaterThan(String doDai) {
        boolean valid = true;
        Integer doDaiInt = 0;
        if (doDai == null || doDai.trim().isBlank() || doDai.isEmpty()) {
            valid = false;
        } else {
            try {
                doDaiInt = Integer.parseInt(doDai);
            } catch (Exception e) {
                valid = false;
            }
        }
        if (valid) {
            return ResponseEntity.ok(chuyenBayService.getByDoDaiGreaterThan(doDaiInt));
        } else {
            throw HangKhongException.badRequest("InvalidDoDaiInput", "Invalid Do dai input!");
        }
    }

    @Override
    public ResponseEntity<List<ChuyenBayRestDTO>> getByGaDiAndGaDen(String gaDi, String gaDen) {
        return ResponseEntity.ok(chuyenBayService.getByGaDiAndGaDen(gaDi, gaDen));
    }

    @Override
    public ResponseEntity<List<ChuyenBayRestDTO>> getByAirbusA320() {
        return ResponseEntity.ok(chuyenBayService.getByAirbusA320());
    }

    @Override
    public ResponseEntity<List<ChuyenBayRestDTO>> getByLoaiMayBay(String loai) {
        return ResponseEntity.ok(chuyenBayService.getByLoaiMayBay(loai));
    }

    @Override
    public ResponseEntity<List<ChuyenBayRestDTO>> getByBoeing() {
        return ResponseEntity.ok(chuyenBayService.getByBoeing());
    }

    @Override
    public ResponseEntity<List<ChuyenBayRestDTO>> getByDoDaiLessThan10000AndGreaterThan8000() {
        return ResponseEntity.ok(chuyenBayService.getByDoDaiLessThan10000AndGreaterThan8000());
    }

    @Override
    public ResponseEntity<List<ChuyenBayRestDTO>> getByDoDaiLessThan(String doDai) {
        boolean valid = true;
        Integer doDaiInt = 0;
        if (doDai == null || doDai.trim().isBlank() || doDai.isEmpty()) {
            valid = false;
        } else {
            try {
                doDaiInt = Integer.parseInt(doDai);
            } catch (Exception e) {
                valid = false;
            }
        }
        if (valid) {
            return ResponseEntity.ok(chuyenBayService.getByDoDaiLessThan(doDaiInt));
        } else {
            throw HangKhongException.badRequest("InvalidDoDaiInput", "Invalid Do dai input!");
        }
    }

    @Override
    public ResponseEntity<List<ChuyenBayRestDTO>> getByDoDaiIs(String doDai) {
        boolean valid = true;
        Integer doDaiInt = 0;
        if (doDai == null || doDai.trim().isBlank() || doDai.isEmpty()) {
            valid = false;
        } else {
            try {
                doDaiInt = Integer.parseInt(doDai);
            } catch (Exception e) {
                valid = false;
            }
        }
        if (valid) {
            return ResponseEntity.ok(chuyenBayService.getByDoDaiIs(doDaiInt));
        } else {
            throw HangKhongException.badRequest("InvalidDoDaiInput", "Invalid Do dai input!");
        }
    }

    @Override
    public ResponseEntity<List<ChuyenBayRestDTO>> getByDoDaiBetween(String doDai1, String doDai2) {
        boolean valid = true;
        Integer doDaiInt1 = 0;
        Integer doDaiInt2 = 0;

        if (doDai1 == null || doDai1.trim().isBlank() || doDai1.isEmpty() || doDai2 == null || doDai2.trim().isBlank() || doDai2.isEmpty()) {
            valid = false;
        } else {
            try {
                doDaiInt1 = Integer.parseInt(doDai1);
                doDaiInt2 = Integer.parseInt(doDai2);
            } catch (Exception e) {
                valid = false;
            }
        }
        if (valid) {
            return ResponseEntity.ok(chuyenBayService.getByDoDaiBetween(doDaiInt1, doDaiInt2));
        } else {
            throw HangKhongException.badRequest("InvalidDoDaiInput", "Invalid Do dai input!");
        }
    }

    @Override
    public ResponseEntity<List<ChuyenBayRestDTO>> getByLoaiGaDiSGNAndGaDenBMV() {
        return ResponseEntity.ok(chuyenBayService.getByLoaiGaDiSGNAndGaDenBMV());
    }

    @Override
    public ResponseEntity<List<ChuyenBayRestDTO>> getByGioDiBeforeASpecificTime(LocalTime time) {
        return ResponseEntity.ok(chuyenBayService.getByGioDiSoonerThanASpecificTime(time));
    }

    @Override
    public ResponseEntity<Integer> getCountChuyenBayByGadi(String gaDi) {
        return ResponseEntity.ok(chuyenBayService.getCountChuyenBayByGadi(gaDi));
    }

    @Override
    public ResponseEntity<List<ChuyenBayRestDTO>> getByGioDiBefore12() {
        return ResponseEntity.ok(chuyenBayService.getByGioDiBefore12());
    }

    @Override
    public ResponseEntity<List<ChuyenBayRestDTO>> timChuyenBayXuatPhatTu(String gaDi) {
        return ResponseEntity.ok(chuyenBayService.timChuyenBayXuatPhatTu(gaDi));
    }
}
