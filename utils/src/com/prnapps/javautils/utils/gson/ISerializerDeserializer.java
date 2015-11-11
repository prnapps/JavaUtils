package com.prnapps.javautils.utils.gson;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;

/**
 * Created by James on 11/10/2015.
 */
public interface ISerializerDeserializer<D> extends JsonSerializer<D>, JsonDeserializer<D> {
}
