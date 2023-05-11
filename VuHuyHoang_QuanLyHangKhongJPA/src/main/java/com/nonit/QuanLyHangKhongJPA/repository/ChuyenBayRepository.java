package com.nonit.QuanLyHangKhongJPA.repository;

import com.nonit.QuanLyHangKhongJPA.entity.ChuyenBay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface ChuyenBayRepository extends JpaRepository<ChuyenBay, String> {
    List<ChuyenBay> getByGaDi(String gaDi);

    List<ChuyenBay> getByGaDiContain(String s);

    List<ChuyenBay> getByDoDaiGreaterThan(Integer i);

    List<ChuyenBay> getByGaDiAndGaDen(String gaDi, String gaDen);

    List<ChuyenBay> getByLoaiMayBay(String loai);

    List<ChuyenBay> getByBoeing();

    @Query(value = "from ChuyenBay cb where cb.doDai < 10000 and cb.doDai > 8000")
    List<ChuyenBay> getByDoDaiLessThan10000AndGreaterThan8000();

    @Query(value = "Select cb from ChuyenBay cb where cb.doDai < :doDai")
    List<ChuyenBay> getByDoDaiLessThan(Integer doDai);

    @Query(value = "Select cb from ChuyenBay cb where cb.doDai = :doDai")
    List<ChuyenBay> getByDoDaiIs(@Param("doDai") Integer i);

    @Query(value = "SELECT cb from ChuyenBay cb where cb.doDai < :doDai1 and cb.doDai > :doDai2")
    List<ChuyenBay> getByDoDaiBetween(@Param("doDai1") Integer doDai1, @Param("doDai2") Integer doDai2);

    @Query(value = "SELECT cb.* from chuyenbay cb where cb.gadi = 'SGN' and cb.gaden = 'BMV'", nativeQuery = true)
    List<ChuyenBay> getByLoaiGaDiSGNAndGaDenBMV();

    @Query(value = "SELECT cb.* from chuyenbay cb,  maybay mb where mb.loai like '%Airbus A320%' and mb.tambay > cb.dodai", nativeQuery = true)
    List<ChuyenBay> getByAirbusA320();

    @Query(value = "SELECT cb from ChuyenBay cb where cb.gioDi < :gioDi")
    List<ChuyenBay> getByGioDiSoonerThanASpecificTime(@Param("gioDi") LocalTime gioDi);

    @Query(value = "select * from chuyenbay cb where cb.giodi < '12:00:00'", nativeQuery = true)
    List<ChuyenBay> getByGioDiBefore12();

    @Query(value = "select count(cb.maCB) from ChuyenBay cb where cb.gaDi = :gaDi")
    Integer getCountChuyenBayByGadi(@Param("gaDi") String gaDi);

    @Query(value = "select * from chuyenbay cb where cb.gadi like ?1", nativeQuery = true)
    List<ChuyenBay> timChuyenBayXuatPhatTu(String gaDi);
}
