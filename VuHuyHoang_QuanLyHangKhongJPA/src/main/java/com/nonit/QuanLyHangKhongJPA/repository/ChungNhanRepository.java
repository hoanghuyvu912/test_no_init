package com.nonit.QuanLyHangKhongJPA.repository;

import com.nonit.QuanLyHangKhongJPA.entity.ChungNhan;
import com.nonit.QuanLyHangKhongJPA.entity.ChungNhanId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChungNhanRepository extends JpaRepository<ChungNhan, ChungNhanId> {
}
