package com.nonit.QuanLyHangKhongJPA.rest;

import com.nonit.QuanLyHangKhongJPA.entity.NhanVien;
import com.nonit.QuanLyHangKhongJPA.service.dto.NhanVienByNumOfPlanesDTO;
import com.nonit.QuanLyHangKhongJPA.service.dto.NhanVienRestDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping(value = "/api/nhanvien")
public interface NhanVienAPI {
    @GetMapping
    ResponseEntity<List<NhanVienRestDTO>> getAllNV();

    @GetMapping(value = "/getByTen")
    ResponseEntity<List<NhanVienRestDTO>> getByTen(@RequestParam("ten") String ten);

    @GetMapping(value = "/getByTenContain")
    ResponseEntity<List<NhanVienRestDTO>> getByTenContain(@RequestParam("s") String s);

    @GetMapping(value = "/getByLuongGreaterThan")
    ResponseEntity<List<NhanVienRestDTO>> getByLuongGreaterThan(@RequestParam("luong") String luong);


    @GetMapping(value = "/getByLuongBetween")
    ResponseEntity<List<NhanVienRestDTO>> getByLuongBetween(@Param("luong1") String luong1, @Param("luong2") String luong2);


    @GetMapping(value = "/getByLuongLessThan")
    ResponseEntity<List<NhanVienRestDTO>> getByLuongLessThan(@RequestParam("luong") String luong);


    @GetMapping(value = "/getByLuongIs")
    ResponseEntity<List<NhanVienRestDTO>> getByLuongIs(@RequestParam("luong") String luong);

    @GetMapping(value = "/getByTenStartWith")
    ResponseEntity<List<NhanVienRestDTO>> getByTenStartWith(@RequestParam("s") String s);

    @GetMapping(value = "/getByTenEndWith")
    ResponseEntity<List<NhanVienRestDTO>> getByTenEndWith(@RequestParam("s") String s);

    @GetMapping(value = "/getByTenNotLike")
    ResponseEntity<List<NhanVienRestDTO>> getByTenNotLike(@RequestParam("s") String s);

    @GetMapping(value = "/getByMaMB")
    ResponseEntity<List<NhanVienRestDTO>> getByMaMB(@RequestParam("maMB") Integer maMB);

    @GetMapping(value = "/getByNumberOfPlanesGreaterThan")
    ResponseEntity<List<NhanVienByNumOfPlanesDTO>> getByNumberOfPlanesGreaterThan(@RequestParam("number") Integer number);
}
