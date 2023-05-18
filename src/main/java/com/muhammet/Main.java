package com.muhammet;

import com.muhammet.entity.Ogrenci;
import com.muhammet.entity.OgrenciNotu;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static List<OgrenciNotu> notlar = List.of(
            OgrenciNotu.builder().ders("JAVA").not_no(1L).not(60).build(),
            OgrenciNotu.builder().ders("JAVA").not_no(2L).not(50).build(),
            OgrenciNotu.builder().ders("JAVA").not_no(3L).not(20).build(),
            OgrenciNotu.builder().ders("JAVA").not_no(4L).not(80).build(),
            OgrenciNotu.builder().ders("JAVA").not_no(5L).not(65).build(),
            OgrenciNotu.builder().ders("JAVA").not_no(6L).not(78).build(),
            OgrenciNotu.builder().ders("JAVA").not_no(7L).not(91).build(),
            OgrenciNotu.builder().ders("JAVA").not_no(8L).not(48).build(),
            OgrenciNotu.builder().ders("JAVA").not_no(9L).not(54).build(),
            OgrenciNotu.builder().ders("JAVA").not_no(10L).not(20).build(),
            OgrenciNotu.builder().ders("JAVA").not_no(11L).not(19).build(),
            OgrenciNotu.builder().ders("JAVA").not_no(12L).not(87).build(),
            OgrenciNotu.builder().ders("JAVA").not_no(13L).not(62).build(),
            OgrenciNotu.builder().ders("JAVA").not_no(14L).not(77).build(),
            OgrenciNotu.builder().ders("JAVA").not_no(15L).not(83).build()

            );
    private static List<Ogrenci> ogrenciler = List.of(
            Ogrenci.builder().okulno("okl001").ad("Ali").sinif("1-A").notlar(notlar.subList(0,3)).build(),
            Ogrenci.builder().okulno("okl002").ad("Bahar").sinif("2-B").notlar(notlar.subList(3,6)).build(),
            Ogrenci.builder().okulno("okl003").ad("Deniz").sinif("4-A").notlar(notlar.subList(12,15)).build(),
            Ogrenci.builder().okulno("okl004").ad("Tuğba").sinif("5-C").notlar(Arrays.asList(notlar.get(10),notlar.get(14),notlar.get(5))).build()

            );

    public static void main(String[] args) {
        /**
         * Öğrenci Listesi olduğunu öngörüyorum. 10 kişilik bir sınıf. bu sınıf içinde
         * Java dersinin notları girilmiş ve her öğrenci için n adet not girilmiş.
         * buna göre elinizde bulunan bu liste üzerinde
         * 1- Öğrencilerin java dan aldığı notların ve ortalamasının Map<OkulNo, List<Notlar>>
         *     şeklinde tutulması
         * 2- Ortalaması 50 den büyük olan öğrencilerin listesi
         * 3- Her bir öğrenci aldığı notun rakamlar olarak tam tersini almış olsa idi notlistesi
         *    nasıl olurdu? Örn: Ali, [87,90,16] -> [78,9,61] gibi
         */

        Map<String,List<OgrenciNotu>> ogrNot = ogrenciler.stream()
                .collect(Collectors.toMap(ogr-> ogr.getOkulno(),ogr -> ogr.getNotlar()));
        System.out.println(ogrNot);
        Map<String,List<OgrenciNotu>> ogrNot2 = ogrenciler.stream()
                .collect(Collectors.toMap(Ogrenci::getOkulno,Ogrenci::getNotlar));
        System.out.println("*****************************************************");
        System.out.println(ogrNot2);

        System.out.println("*****************************************************");

        ogrenciler.get(0).getNotlar().stream().mapToInt(OgrenciNotu::getNot).average().ifPresent(System.out::println);

        List<Ogrenci> gecenOgrenciListesi = ogrenciler.stream()
                .filter(ogr-> ogr.getNotlar().stream().mapToInt(OgrenciNotu::getNot).average().getAsDouble()>50)
                .collect(Collectors.toList());

        System.out.println("*****************************************************");
        System.out.println(gecenOgrenciListesi);

        System.out.println("*****************************************************");

        ogrenciler.forEach(ogr->{
            ogr.getNotlar().forEach(not->{
                not.setNot(reverseNumber(not.getNot()));
            });
        });
        System.out.println(ogrenciler);
    }

    private static Integer reverseNumber(Integer number){
        String numberStr = number.toString();
        String reverseNumberStr = new StringBuilder(numberStr).reverse().toString();
        return Integer.parseInt(reverseNumberStr);
    }
}