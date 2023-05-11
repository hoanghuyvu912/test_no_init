package com.nonit.QuanLyHangKhongJPA.rest;

import com.nonit.QuanLyHangKhongJPA.entity.ChuyenBay;
import com.nonit.QuanLyHangKhongJPA.service.dto.ChuyenBayRestDTO;
import org.springframework.cglib.core.Local;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalTime;
import java.util.List;

@RequestMapping(value = "/api/chuyenbay")
public interface ChuyenBayAPI {
    @GetMapping
    ResponseEntity<List<ChuyenBayRestDTO>> getAllChuyenBay();

    @GetMapping(value = "/getByGaDi")
    ResponseEntity<List<ChuyenBayRestDTO>> getByGaDi(@RequestParam("gaDi") String gaDi);

    @GetMapping(value = "/getByGaDiContain")
    ResponseEntity<List<ChuyenBayRestDTO>> getByGaDiContain(@RequestParam("s") String s);

    @GetMapping(value = "/getByDoDaiGreaterThan")
    ResponseEntity<List<ChuyenBayRestDTO>> getByDoDaiGreaterThan(@RequestParam("doDai") String doDai);

    @GetMapping(value = "/getByGaDiAndGaDen")
    ResponseEntity<List<ChuyenBayRestDTO>> getByGaDiAndGaDen(@Param("gaDi") String gaDi, @Param("gaDen") String gaDen);

    @GetMapping(value = "/getByLoaiMayBay")
    ResponseEntity<List<ChuyenBayRestDTO>> getByLoaiMayBay(@Param("loai") String loai);

    @GetMapping(value = "/getByBoeing")
    ResponseEntity<List<ChuyenBayRestDTO>> getByBoeing();

    @GetMapping(value = "/getByAirbusA320")
    ResponseEntity<List<ChuyenBayRestDTO>> getByAirbusA320();

    @GetMapping(value = "/getByDoDaiLessThan10000AndGreaterThan8000")
    ResponseEntity<List<ChuyenBayRestDTO>> getByDoDaiLessThan10000AndGreaterThan8000();

    @GetMapping(value = "/getByDoDaiLessThan")
    ResponseEntity<List<ChuyenBayRestDTO>> getByDoDaiLessThan(@Param("doDai") String doDai);

    @GetMapping(value = "/getByDoDaiIs")
    ResponseEntity<List<ChuyenBayRestDTO>> getByDoDaiIs(@Param("doDai") String doDai);

    @GetMapping(value = "/getByDoDaiBetween")
    ResponseEntity<List<ChuyenBayRestDTO>> getByDoDaiBetween(@Param("doDai1") String doDai1, @Param("doDai2") String doDai2);

    @GetMapping(value = "/getByLoaiGaDiSGNAndGaDenBMV")
    ResponseEntity<List<ChuyenBayRestDTO>> getByLoaiGaDiSGNAndGaDenBMV();

    @GetMapping(value = "/getByGioDiSoonerThanASpecificTime")
    ResponseEntity<List<ChuyenBayRestDTO>> getByGioDiBeforeASpecificTime(@RequestParam("time") LocalTime time);

    @GetMapping(value = "/getCountChuyenBayByGadi")
    ResponseEntity<Integer> getCountChuyenBayByGadi(@Param("gaDi") String gaDi);

    @GetMapping(value = "/getByGioDiBefore12")
    ResponseEntity<List<ChuyenBayRestDTO>> getByGioDiBefore12();

    @GetMapping(value = "/timChuyenBayXuatPhatTu")
    ResponseEntity<List<ChuyenBayRestDTO>> timChuyenBayXuatPhatTu(@RequestParam("gaDi") String gaDi);
}
