package com.sourav.starter.core.jsonObject;

import io.vertx.core.json.JsonObject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonObjectExample {
  @Test
  void jsonObjectCanBeMapped() {
    JsonObject entries = new JsonObject();
    entries.put("id", 1);
    entries.put("name", "Sourav");
    entries.put("is_in_love", false);

    String encode = entries.encode();
    assertEquals("{\"id\":1,\"name\":\"Sourav\",\"is_in_love\":false}", encode);

    JsonObject decodedEntries = new JsonObject(encode);

    assertEquals(entries, decodedEntries);
  }

  @Test
  void jsonObjectCanBeCreatedFromMap() {
    Map<String, Object> entries = new HashMap();
    entries.put("id", 1);
    entries.put("name", "Sourav");
    entries.put("is_in_love", false);

    JsonObject asJsonObject = new JsonObject(entries);
    assertEquals(entries, asJsonObject.getMap());

    assertEquals(1, asJsonObject.getInteger("id"));
    assertEquals("Sourav", asJsonObject.getString("name"));
    assertEquals(false, asJsonObject.getBoolean("is_in_love"));
    assertEquals("false", asJsonObject.getString("is_in_love"));

  }
}