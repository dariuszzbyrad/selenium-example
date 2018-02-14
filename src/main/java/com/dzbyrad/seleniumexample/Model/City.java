package com.dzbyrad.seleniumexample.Model;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class City {
    private String name;
    private String voivodeship;
    private String community;
    private String county;
}
