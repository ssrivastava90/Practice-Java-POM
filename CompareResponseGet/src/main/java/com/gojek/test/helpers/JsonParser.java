package com.gojek.test.helpers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class JsonParser {

  private static ObjectMapper objectMapper = new ObjectMapper();

  public static JsonNode parseJson(String jsonString) throws IOException {
      return objectMapper.readTree(jsonString);
  }

}
