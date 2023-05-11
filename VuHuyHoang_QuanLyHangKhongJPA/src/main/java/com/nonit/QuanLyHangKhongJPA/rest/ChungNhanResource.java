package com.nonit.QuanLyHangKhongJPA.rest;

import com.nonit.QuanLyHangKhongJPA.entity.ChungNhan;
import com.nonit.QuanLyHangKhongJPA.service.ChungNhanService;
import com.nonit.QuanLyHangKhongJPA.service.dto.ChungNhanDTO;
import com.nonit.QuanLyHangKhongJPA.service.dto.ChungNhanRestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChungNhanResource implements ChungNhanAPI {
    private final ChungNhanService chungNhanService;

    @Override
    public ResponseEntity<List<ChungNhanRestDTO>> getAllChungNhan() {
        return ResponseEntity.ok(chungNhanService.getAllChungNhan());
    }

    @Override
    public ResponseEntity<ChungNhanRestDTO> createChungNhan(ChungNhanDTO chungNhanDTO) {
        ChungNhanRestDTO chungNhanRestDTO = chungNhanService.createChungNhan(chungNhanDTO);
        return ResponseEntity.created(URI.create("/api/chungnhan/manv/" + chungNhanRestDTO.getNhanVien().getMaNV() + "/mamb/" + chungNhanRestDTO.getMayBay().getMaMB())).body(chungNhanRestDTO);
    }
}
