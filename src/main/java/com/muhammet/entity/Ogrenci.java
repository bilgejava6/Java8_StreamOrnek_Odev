package com.muhammet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Ogrenci {
    String okulno;
    String ad;
    String sinif;
    List<OgrenciNotu> notlar;
}
