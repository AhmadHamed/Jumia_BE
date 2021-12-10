package com.jumia.utils;

import com.jumia.dto.CustomerResponseDto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherUtil {
  public static String matchCountry(String countryCode) {
    switch (countryCode) {
      case "237":
        return "Cameroon";
      case "251":
        return "Ethiopia";
      case "212":
        return "Morocco";
      case "258":
        return "Mozambique";
      case "256":
        return "Uganda";
      default:
        return "";
    }
  }

  public static boolean matchState(CustomerResponseDto customerResponseDto) {
    switch (customerResponseDto.getCountryCode()) {
      case "237":
        {
          Pattern pattern = Pattern.compile("\\(237\\) ?[2368]\\d{7,8}$");
          Matcher matcher = pattern.matcher(customerResponseDto.getPhone());
          return matcher.matches();
        }
      case "251":
        {
          Pattern pattern = Pattern.compile("\\(251\\) ?[1-59]\\d{8}$");
          Matcher matcher = pattern.matcher(customerResponseDto.getPhone());
          return matcher.matches();
        }
      case "212":
        {
          Pattern pattern = Pattern.compile("\\(212\\) ?[5-9]\\d{8}$");
          Matcher matcher = pattern.matcher(customerResponseDto.getPhone());
          return matcher.matches();
        }
      case "258":
        {
          Pattern pattern = Pattern.compile("\\(258\\) ?[28]\\d{7,8}$");
          Matcher matcher = pattern.matcher(customerResponseDto.getPhone());
          return matcher.matches();
        }
      case "256":
        {
          Pattern pattern = Pattern.compile("\\(256\\) ?\\d{9}$");
          Matcher matcher = pattern.matcher(customerResponseDto.getPhone());
          return matcher.matches();
        }
      default:
        return false;
    }
  }
}
