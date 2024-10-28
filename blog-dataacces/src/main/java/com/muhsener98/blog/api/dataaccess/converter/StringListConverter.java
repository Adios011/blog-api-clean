package com.muhsener98.blog.api.dataaccess.converter;

import java.util.*;
import java.util.stream.Collectors;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;


@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {

    public static final String DELIMITER = ",";

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return String.join(DELIMITER, attribute);
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        return  Arrays.asList(dbData.split(DELIMITER));
    }
}
