package com.concrete.desafio.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

public class JsonUtils {

  public static <T> T jsonParser(
      final String json, final Type type){

    return new Gson().fromJson(json, type);
  }

  public static String jsonToString(final String fileName) throws IOException {
    final Class parser = JsonUtils.class;
    final InputStream inputStream = parser.getResourceAsStream(String.format("/jsons/%s", fileName));

    return readFromInputStream(inputStream);
  }

  private static String readFromInputStream(final InputStream inputStream) throws IOException {
    final StringBuilder resultStringBuilder = new StringBuilder();
    try (final BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
      String line;
      while ((line = br.readLine()) != null) {
        resultStringBuilder.append(line).append("\n");
      }
    }
    return resultStringBuilder.toString();
  }
}
