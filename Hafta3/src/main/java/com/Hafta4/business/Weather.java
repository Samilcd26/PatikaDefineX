package com.Hafta4.business;

import com.Hafta4.model.IWeather;
import com.Hafta4.model.dto.Root;
import com.Hafta4.model.dto.weatherStatusDto.weatherStatusDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;


@Controller
public class Weather implements IWeather {
    @Autowired
    private ModelMapper modelMapper;
    @Value ("${openweathermap.key}")
    private String key;
    private RestTemplate restTemplate = new RestTemplate();
    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping({"/index","/"})
    public String index(ModelMap map){

        return "index";
    }

    //I removed the country query as I thought it was unnecessary
    @GetMapping("/weather/{city}")
    @ResponseBody
    public weatherStatusDto.Root[] getWeather(ModelMap map, @PathVariable String city) {
        ArrayList coordinates= getGeolocation(city);
        //coordinates.get(0) ->lat
        //coordinates.get(1) ->lon
        //fetch weather information based on coordinates;
        String url ="https://api.openweathermap.org/data/2.5/forecast?lat="+coordinates.get(0)+"&lon="+coordinates.get(1)+"&appid="+key;

        String cityJson = restTemplate.getForObject(url,String.class);
        weatherStatusDto.Root[] status = weatherStatusDto("["+cityJson+"]");

        return status;
    }


    @Override
    public ArrayList getGeolocation(String City) {
        String url = "https://api.openweathermap.org/geo/1.0/direct?q="+City+"&limit=1&appid="+key;

        ArrayList coordinateStore=new ArrayList();
        //get json
        String cityJson = restTemplate.getForObject(url,String.class);
        //convert to json
        com.Hafta4.model.dto.Root cityInfo =EntityToDto(cityJson);

        coordinateStore.add(cityInfo.lat);
        coordinateStore.add(cityInfo.lon);

        return coordinateStore;
    }




    //Json Convert DTO
    //Model Mapper Entity ==> Dto
    @Override
    public Root EntityToDto(String json) {
        try {

            Root[] root = objectMapper.readValue(json, Root[].class);
            return root[0];
        }catch (final Exception e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public weatherStatusDto.Root[] weatherStatusDto(String json){
        try {
            weatherStatusDto.Root[] weatherStatus = objectMapper.readValue(json, weatherStatusDto.Root[].class);
            return weatherStatus;
        }catch (final Exception e){
            System.out.println(e);
            return null;
        }
    }

}
