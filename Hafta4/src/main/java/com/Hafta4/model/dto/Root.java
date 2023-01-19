package com.Hafta4.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;


public class Root{
    public String name;
    public JsonNode local_names;
    public double lat;
    public double lon;
    public String country;
}