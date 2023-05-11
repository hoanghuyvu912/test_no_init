package com.nonit.QuanLyHangKhongJPA.rest;

import com.nonit.QuanLyHangKhongJPA.entity.MayBay;
import com.nonit.QuanLyHangKhongJPA.entity.MayBay;
import com.nonit.QuanLyHangKhongJPA.service.dto.CustomMayBayDTO;
import com.nonit.QuanLyHangKhongJPA.service.dto.CustomMayBayInterfaceDTO;
import com.nonit.QuanLyHangKhongJPA.service.dto.MayBayRestDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping(value = "/api/maybay")
public interface MayBayAPI {
    @GetMapping
    ResponseEntity<List<MayBayRestDTO>> getAllMayBay();

    @GetMapping(value = "/getByLoai")
    ResponseEntity<MayBayRestDTO> getByLoai(@RequestParam("loai") String loai);

    @GetMapping(value = "/getByLoaiContain")
    ResponseEntity<List<MayBayRestDTO>> getByLoaiContain(@RequestParam("s") String s);

    @GetMapping(value = "/getByTamBayGreaterThan")
    ResponseEntity<List<MayBayRestDTO>> getByTamBayGreaterThan(@RequestParam("tamBay") String tamBay);

    @GetMapping(value = "/getByTamBayBetween")
    ResponseEntity<List<MayBayRestDTO>> getByTamBayBetween(@Param("tamBay1") String tamBay1, @Param("tamBay2") String tamBay2);

    @GetMapping(value = "/getByTamBayLessThan")
    ResponseEntity<List<MayBayRestDTO>> getByTamBayLessThan(@RequestParam("tamBay") String tamBay);

    @GetMapping(value = "/getByTamBayIs")
    ResponseEntity<List<MayBayRestDTO>> getByTamBayIs(@RequestParam("tamBay") String tamBay);

    @GetMapping(value = "/getByLoaiStartWith")
    ResponseEntity<List<MayBayRestDTO>> getByLoaiStartWith(@RequestParam("s") String s);

    @GetMapping(value = "/getByLoaiEndWith")
    ResponseEntity<List<MayBayRestDTO>> getByLoaiEndWith(@RequestParam("s") String s);

    @GetMapping(value = "/getByLoaiNotLike")
    ResponseEntity<List<MayBayRestDTO>> getByLoaiNotLike(@RequestParam("s") String s);

    @GetMapping(value = "/getByMaNV")
    ResponseEntity<List<MayBayRestDTO>> getByMaNV(@RequestParam("maNV") String maNV);

    @GetMapping(value = "/getMaMBAndTamBayByLoai")
    ResponseEntity<List<CustomMayBayInterfaceDTO>> getMaMBAndTamBayByLoaiLike(@RequestParam("loai") String loai);

    @GetMapping(value = "/getMaMBAndLoaiMBByLoai")
    ResponseEntity<List<CustomMayBayDTO>> getMaMBAndLoaiMBByLoaiLike(@RequestParam("loai") String loai);
}
