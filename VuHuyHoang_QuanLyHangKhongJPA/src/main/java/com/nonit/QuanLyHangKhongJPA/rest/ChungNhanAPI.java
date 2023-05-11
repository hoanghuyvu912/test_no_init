package com.nonit.QuanLyHangKhongJPA.rest;

import com.nonit.QuanLyHangKhongJPA.entity.ChungNhan;
import com.nonit.QuanLyHangKhongJPA.service.dto.ChungNhanDTO;
import com.nonit.QuanLyHangKhongJPA.service.dto.ChungNhanRestDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/chungnhan")
public interface ChungNhanAPI {
    @GetMapping
    ResponseEntity<List<ChungNhanRestDTO>> getAllChungNhan();

    @PostMapping
    ResponseEntity<ChungNhanRestDTO> createChungNhan(@RequestBody ChungNhanDTO chungNhanDTO);
}
