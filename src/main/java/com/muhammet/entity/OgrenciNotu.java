package com.muhammet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OgrenciNotu {
    String ders;
    Long not_no;
    Integer not;
}
