package com.k15t.pat.registration;

import java.util.HashMap;
import java.util.Map;

public class AddressSplit {

    public Map<String, String> partsOfAddress(String address1, String address2) {
        Map<String, String> parts = new HashMap<>();

        final String houseNumber;
        final String street;
        final String postcode;
        final String city;
        final String country;

        address1.trim();
        houseNumber = address1.substring(0, address1.indexOf(' '));
        postcode = address1.substring(address1.lastIndexOf(' '), address1.length());
        street = address1.substring(address1.indexOf(' '), address1.lastIndexOf(' '));

        parts.put("houseNumber",houseNumber);
        parts.put("street", street);
        parts.put("postcode", postcode);

        address2.trim();
        city = address2.substring(0, address2.indexOf(','));
        country = address2.substring(((address2.indexOf(',')) + 1), address2.length() );

        parts.put("city", city);
        parts.put("country", country);
        System.out.println(parts);
        return parts;
    }
}