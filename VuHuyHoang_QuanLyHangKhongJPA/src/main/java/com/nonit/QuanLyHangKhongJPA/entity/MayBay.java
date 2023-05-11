package com.nonit.QuanLyHangKhongJPA.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "maybay")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "maMB")
@NamedQueries({
        @NamedQuery(name = "MayBay.getByLoai",
                query = "select mb from MayBay mb where mb.loai = ?1")
        ,
        @NamedQuery(name = "MayBay.getByLoaiContain",
                query = "select mb from MayBay mb where mb.loai like ?1")
        ,
        @NamedQuery(name = "MayBay.getByTamBayGreaterThan",
                query = "select mb from MayBay mb where mb.tamBay>?1")
})

@NamedNativeQueries({
        @NamedNativeQuery(name = "MayBay.getByTamBayBetween",
                query = "select * from maybay mb where mb.tambay between ?1 and ?2", resultClass = MayBay.class)
        ,
        @NamedNativeQuery(name = "MayBay.getByLuongLessThan",
                query = "select * from maybay mb where mb.tambay  < ?1", resultClass = MayBay.class)
        ,
        @NamedNativeQuery(name = "MayBay.getByLuongIs",
                query = "select * from maybay mb where mb.tambay = ?1", resultClass = MayBay.class)
})
public class MayBay {
    @Id
    @Column(name = "mamb")
    private Integer maMB;

    @Column(name = "loai")
    private String loai;

    @Column(name = "tambay")
    private Integer tamBay;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mayBay")
//    @JsonIgnoreProperties(value = {"referenceList", "handler","hibernateLazyInitializer"}, allowSetters = true)
//    private List<ChungNhan> chungNhans = new ArrayList<>();
}
