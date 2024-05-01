package com.example.testeffective.data.data

import com.example.testeffective.data.model.Offers
import com.example.testeffective.data.model.Tickets
import com.example.testeffective.data.model.TicketsOffers
import com.google.gson.Gson

suspend fun getAllTravelOffers(): Offers {
    val gson = Gson()
    val response = gson.fromJson(responseStringTravelOffers(), Offers::class.java)
    return response
}

suspend fun getAllStraightFlights(): TicketsOffers {
    val gson = Gson()
    val response = gson.fromJson(responseStringStraightFlights(), TicketsOffers::class.java)
    return response
}

suspend fun getAllTickets(): Tickets {
    val gson = Gson()
    val response = gson.fromJson(responseStringAllTickets(), Tickets::class.java)
    return response
}

fun responseStringTravelOffers() = "{\n" +
        "  \"offers\": [\n" +
        "    {\n" +
        "      \"id\": 1,\n" +
        "      \"title\": \"Die Antwoord\",\n" +
        "      \"town\": \"Будапешт\",\n" +
        "      \"price\": {\n" +
        "        \"value\": 5000\n" +
        "      }\n" +
        "    },\n" +
        "    {\n" +
        "      \"id\": 2,\n" +
        "      \"title\": \"Socrat&Lera\",\n" +
        "      \"town\": \"Санкт-Петербург\",\n" +
        "      \"price\": {\n" +
        "        \"value\": 1999\n" +
        "      }\n" +
        "    },\n" +
        "    {\n" +
        "      \"id\": 3,\n" +
        "      \"title\": \"Лампабикт\",\n" +
        "      \"town\": \"Москва\",\n" +
        "      \"price\": {\n" +
        "        \"value\": 2390\n" +
        "      }\n" +
        "    }\n" +
        "  ]\n" +
        "}"

fun responseStringStraightFlights() = "{\n" +
        "  \"tickets_offers\": [\n" +
        "    {\n" +
        "      \"id\": 1,\n" +
        "      \"title\": \"Уральские авиалинии\",\n" +
        "      \"time_range\": [\n" +
        "        \"07:00\",\n" +
        "        \"09:10\",\n" +
        "        \"10:00\",\n" +
        "        \"11:30\",\n" +
        "        \"14:15\",\n" +
        "        \"19:10\",\n" +
        "        \"21:00\",\n" +
        "        \"23:30\"\n" +
        "      ],\n" +
        "      \"price\": {\n" +
        "        \"value\": 3999\n" +
        "      }\n" +
        "    },\n" +
        "    {\n" +
        "      \"id\": 10,\n" +
        "      \"title\": \"Победа\",\n" +
        "      \"time_range\": [\n" +
        "        \"09:10\",\n" +
        "        \"21:00\"\n" +
        "      ],\n" +
        "      \"price\": {\n" +
        "        \"value\": 4999\n" +
        "      }\n" +
        "    },\n" +
        "    {\n" +
        "      \"id\": 30,\n" +
        "      \"title\": \"NordStar\",\n" +
        "      \"time_range\": [\n" +
        "        \"07:00\"\n" +
        "      ],\n" +
        "      \"price\": {\n" +
        "        \"value\": 2390\n" +
        "      }\n" +
        "    }\n" +
        "  ]\n" +
        "}"

fun responseStringAllTickets() = "{\n" +
        "  \"tickets\": [\n" +
        "    {\n" +
        "      \"id\": 100,\n" +
        "      \"badge\": \"Самый удобный\",\n" +
        "      \"price\": {\n" +
        "        \"value\": 1999\n" +
        "      },\n" +
        "      \"provider_name\": \"На сайте Купибилет\",\n" +
        "      \"company\": \"Якутия\",\n" +
        "      \"departure\": {\n" +
        "        \"town\": \"Москва\",\n" +
        "        \"date\": \"2024-02-23T03:15:00\",\n" +
        "        \"airport\": \"VKO\"\n" +
        "      },\n" +
        "      \"arrival\": {\n" +
        "        \"town\": \"Сочи\",\n" +
        "        \"date\": \"2024-02-23T07:10:00\",\n" +
        "        \"airport\": \"AER\"\n" +
        "      },\n" +
        "      \"has_transfer\": false,\n" +
        "      \"has_visa_transfer\": false,\n" +
        "      \"luggage\": {\n" +
        "        \"has_luggage\": false,\n" +
        "        \"price\": {\n" +
        "          \"value\": 1082\n" +
        "        }\n" +
        "      },\n" +
        "      \"hand_luggage\": {\n" +
        "        \"has_hand_luggage\": true,\n" +
        "        \"size\": \"55x20x40\"\n" +
        "      },\n" +
        "      \"is_returnable\": false,\n" +
        "      \"is_exchangable\": true\n" +
        "    },\n" +
        "    {\n" +
        "      \"id\": 101,\n" +
        "      \"price\": {\n" +
        "        \"value\": 9999\n" +
        "      },\n" +
        "      \"provider_name\": \"На сайте Победа\",\n" +
        "      \"company\": \"Победа\",\n" +
        "      \"departure\": {\n" +
        "        \"town\": \"Москва\",\n" +
        "        \"date\": \"2024-02-23T04:00:00\",\n" +
        "        \"airport\": \"VKO\"\n" +
        "      },\n" +
        "      \"arrival\": {\n" +
        "        \"town\": \"Сочи\",\n" +
        "        \"date\": \"2024-02-23T08:30:00\",\n" +
        "        \"airport\": \"AER\"\n" +
        "      },\n" +
        "      \"has_transfer\": false,\n" +
        "      \"has_visa_transfer\": false,\n" +
        "      \"luggage\": {\n" +
        "        \"has_luggage\": false,\n" +
        "        \"price\": {\n" +
        "          \"value\": 1602\n" +
        "        }\n" +
        "      },\n" +
        "      \"hand_luggage\": {\n" +
        "        \"has_hand_luggage\": true,\n" +
        "        \"size\": \"36x30x27\"\n" +
        "      },\n" +
        "      \"is_returnable\": false,\n" +
        "      \"is_exchangable\": true\n" +
        "    },\n" +
        "    {\n" +
        "      \"id\": 102,\n" +
        "      \"price\": {\n" +
        "        \"value\": 8500\n" +
        "      },\n" +
        "      \"provider_name\": \"На сайте Turkish Airlines\",\n" +
        "      \"company\": \"Турецкие авиалинии\",\n" +
        "      \"departure\": {\n" +
        "        \"town\": \"Москва\",\n" +
        "        \"date\": \"2024-02-23T15:00:00\",\n" +
        "        \"airport\": \"VKO\"\n" +
        "      },\n" +
        "      \"arrival\": {\n" +
        "        \"town\": \"Сочи\",\n" +
        "        \"date\": \"2024-02-23T18:40:00\",\n" +
        "        \"airport\": \"AER\"\n" +
        "      },\n" +
        "      \"has_transfer\": false,\n" +
        "      \"has_visa_transfer\": false,\n" +
        "      \"luggage\": {\n" +
        "        \"has_luggage\": true\n" +
        "      },\n" +
        "      \"hand_luggage\": {\n" +
        "        \"has_hand_luggage\": true,\n" +
        "        \"size\": \"55x20x40\"\n" +
        "      },\n" +
        "      \"is_returnable\": false,\n" +
        "      \"is_exchangable\": false\n" +
        "    },\n" +
        "    {\n" +
        "      \"id\": 103,\n" +
        "      \"badge\": \"Рекомендуемый\",\n" +
        "      \"price\": {\n" +
        "        \"value\": 8086\n" +
        "      },\n" +
        "      \"provider_name\": \"На сайте Уральские авиалинии\",\n" +
        "      \"company\": \"Уральские авиалинии\",\n" +
        "      \"departure\": {\n" +
        "        \"town\": \"Москва\",\n" +
        "        \"date\": \"2024-02-23T11:30:00\",\n" +
        "        \"airport\": \"VKO\"\n" +
        "      },\n" +
        "      \"arrival\": {\n" +
        "        \"town\": \"Сочи\",\n" +
        "        \"date\": \"2024-02-23T15:00:00\",\n" +
        "        \"airport\": \"AER\"\n" +
        "      },\n" +
        "      \"has_transfer\": false,\n" +
        "      \"has_visa_transfer\": false,\n" +
        "      \"luggage\": {\n" +
        "        \"has_luggage\": false,\n" +
        "        \"price\": {\n" +
        "          \"value\": 1570\n" +
        "        }\n" +
        "      },\n" +
        "      \"hand_luggage\": {\n" +
        "        \"has_hand_luggage\": true,\n" +
        "        \"size\": \"55x20x40\"\n" +
        "      },\n" +
        "      \"is_returnable\": true,\n" +
        "      \"is_exchangable\": true\n" +
        "    },\n" +
        "    {\n" +
        "      \"id\": 104,\n" +
        "      \"price\": {\n" +
        "        \"value\": 11560\n" +
        "      },\n" +
        "      \"provider_name\": \"На сайте Aeroflot\",\n" +
        "      \"company\": \"Аэрофлот\",\n" +
        "      \"departure\": {\n" +
        "        \"town\": \"Москва\",\n" +
        "        \"date\": \"2024-02-23T11:50:00\",\n" +
        "        \"airport\": \"VKO\"\n" +
        "      },\n" +
        "      \"arrival\": {\n" +
        "        \"town\": \"Сочи\",\n" +
        "        \"date\": \"2024-02-23T15:20:00\",\n" +
        "        \"airport\": \"AER\"\n" +
        "      },\n" +
        "      \"has_transfer\": true,\n" +
        "      \"has_visa_transfer\": false,\n" +
        "      \"luggage\": {\n" +
        "        \"has_luggage\": false,\n" +
        "        \"price\": {\n" +
        "          \"value\": 999\n" +
        "        }\n" +
        "      },\n" +
        "      \"hand_luggage\": {\n" +
        "        \"has_hand_luggage\": true,\n" +
        "        \"size\": \"55x20x40\"\n" +
        "      },\n" +
        "      \"is_returnable\": false,\n" +
        "      \"is_exchangable\": true\n" +
        "    },\n" +
        "    {\n" +
        "      \"id\": 105,\n" +
        "      \"price\": {\n" +
        "        \"value\": 15600\n" +
        "      },\n" +
        "      \"provider_name\": \"На сайте Aeroflot\",\n" +
        "      \"company\": \"Аэрофлот\",\n" +
        "      \"departure\": {\n" +
        "        \"town\": \"Москва\",\n" +
        "        \"date\": \"2024-02-23T13:50:00\",\n" +
        "        \"airport\": \"VKO\"\n" +
        "      },\n" +
        "      \"arrival\": {\n" +
        "        \"town\": \"Сочи\",\n" +
        "        \"date\": \"2024-02-23T17:20:00\",\n" +
        "        \"airport\": \"AER\"\n" +
        "      },\n" +
        "      \"has_transfer\": true,\n" +
        "      \"has_visa_transfer\": true,\n" +
        "      \"luggage\": {\n" +
        "        \"has_luggage\": false,\n" +
        "        \"price\": {\n" +
        "          \"value\": 1999\n" +
        "        }\n" +
        "      },\n" +
        "      \"hand_luggage\": {\n" +
        "        \"has_hand_luggage\": true,\n" +
        "        \"size\": \"55x20x40\"\n" +
        "      },\n" +
        "      \"is_returnable\": true,\n" +
        "      \"is_exchangable\": true\n" +
        "    },\n" +
        "    {\n" +
        "      \"id\": 106,\n" +
        "      \"price\": {\n" +
        "        \"value\": 9500\n" +
        "      },\n" +
        "      \"provider_name\": \"На сайте Aeroflot\",\n" +
        "      \"company\": \"Аэрофлот\",\n" +
        "      \"departure\": {\n" +
        "        \"town\": \"Москва\",\n" +
        "        \"date\": \"2024-02-23T21:00:00\",\n" +
        "        \"airport\": \"VKO\"\n" +
        "      },\n" +
        "      \"arrival\": {\n" +
        "        \"town\": \"Сочи\",\n" +
        "        \"date\": \"2024-02-24T00:20:00\",\n" +
        "        \"airport\": \"AER\"\n" +
        "      },\n" +
        "      \"has_transfer\": false,\n" +
        "      \"has_visa_transfer\": false,\n" +
        "      \"luggage\": {\n" +
        "        \"has_luggage\": false,\n" +
        "        \"price\": {\n" +
        "          \"value\": 5999\n" +
        "        }\n" +
        "      },\n" +
        "      \"hand_luggage\": {\n" +
        "        \"has_hand_luggage\": false\n" +
        "      },\n" +
        "      \"is_returnable\": false,\n" +
        "      \"is_exchangable\": false\n" +
        "    }\n" +
        "  ]\n" +
        "}"