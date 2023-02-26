package com.Hafta4.model;

import com.Hafta4.model.dto.Root;
import com.Hafta4.model.dto.weatherStatusDto.weatherStatusDto;

import java.util.ArrayList;

public interface IWeather {
    public ArrayList getGeolocation( String city);
    public Root EntityToDto(String Json);
    public weatherStatusDto.Root[] weatherStatusDto(String json);
}
