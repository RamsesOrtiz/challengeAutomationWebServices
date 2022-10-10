package com.challenge.config;

public class PropertiesPage {

    public static final String URI = "https://petstore.swagger.io/v2/pet";

    public static final String getURI = "https://petstore.swagger.io/v2/pet/";

    public static String SERVER_RESPONSE = "";

    public static int id = (int) (Math.random() * 10000 + 1);

    public static String bodyPet =
            "{\n" +
                    "  \"id\": " + id + ",\n" +
                    "  \"category\": {\n" +
                    "    \"id\": 0,\n" +
                    "    \"name\": \"dogs\"\n" +
                    "  },\n" +
                    "  \"name\": \"doggie\",\n" +
                    "  \"photoUrls\": [\n" +
                    "    \"string\"\n" +
                    "  ],\n" +
                    "  \"tags\": [\n" +
                    "    {\n" +
                    "      \"id\": 0,\n" +
                    "      \"name\": \"dog\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"status\": \"available\"\n" +
                    "}";

    public static String bodyUpdate =
            "{\n" +
                    "  \"id\": " + id + ",\n" +
                    "  \"category\": {\n" +
                    "    \"id\": 0,\n" +
                    "    \"name\": \"doggy\"\n" +
                    "  },\n" +
                    "  \"name\": \"puppy\",\n" +
                    "  \"photoUrls\": [\n" +
                    "    \"string\"\n" +
                    "  ],\n" +
                    "  \"tags\": [\n" +
                    "    {\n" +
                    "      \"id\": 0,\n" +
                    "      \"name\": \"doggy\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"status\": \"available\"\n" +
                    "}";
}
