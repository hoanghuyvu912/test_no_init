package com.nonit.QuanLyHangKhongJPA.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chuyenbay")
@NamedQueries({
        @NamedQuery(
                name = "ChuyeBay.getByGaDi",
                query = "select cb from ChuyenBay cb where cb.gaDi = :gaDi"
        ),
        @NamedQuery(name = "ChuyenBay.getByGaDiContain",
                query = "select cb from ChuyenBay cb where cb.gaDi like ?1")
        ,
        @NamedQuery(name = "ChuyenBay.getByDoDaiGreaterThan",
                query = "select cb from ChuyenBay cb where cb.doDai>?1")
        ,
        @NamedQuery(
                name = "ChuyenBay.getByGaDiAndGaDen",
                query = "select cb from ChuyenBay cb where cb.gaDi = :gaDi and cb.gaDen = :gaDen"
        )
})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "ChuyenBay.getByLoaiMayBay",
                query = "select cb.* from chuyenbay cb, maybay mb where mb.loai = :loai and mb.tambay > cb.dodai",
                resultClass = ChuyenBay.class
        ),
        @NamedNativeQuery(
                name = "ChuyenBay.getByBoeing",
                query = "select *\n" +
                        "from chuyenbay c\n" +
                        "where c.dodai  <= (select min(m.tambay)\n" +
                        "from maybay m\n" +
                        "where m.loai like '%Boeing%')",
                resultClass = ChuyenBay.class
        )
})
public class ChuyenBay {
    @Id
    @Column(name = "macb")
    private String maCB;

    @Column(name = "gadi")
    private String gaDi;

    @Column(name = "gaden")
    private String gaDen;

    @Column(name = "dodai")
    private Integer doDai;

    @Column(name = "giodi")
    private LocalTime gioDi;

    @Column(name = "gioden")
    private LocalTime gioDen;

    @Column(name = "chiphi")
    private Integer chiPhi;
}
