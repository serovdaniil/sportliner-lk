package by.sportliner.lk.core.support.json.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;

public class JacksonObjectMappers {

    public static ObjectMapper defaultStrict() {
        return new Jackson2ObjectMapperBuilder()

            .featuresToDisable(
                SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
                MapperFeature.ALLOW_COERCION_OF_SCALARS
            )

            .featuresToEnable(
                JsonParser.Feature.STRICT_DUPLICATE_DETECTION,
                DeserializationFeature.FAIL_ON_TRAILING_TOKENS,
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY
            )

            .deserializerByType(String.class, new StrictStringDeserializer())

            .build();
    }

    public static ObjectMapper repositoryStrict() {
        return new Jackson2ObjectMapperBuilder()
            .deserializerByType(String.class, new StrictStringDeserializer())

            .featuresToEnable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)

            .build();
    }


    private static class StrictStringDeserializer extends StringDeserializer {

        @Override
        public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

            // super method tries type coercion to string
            // this prevents auto-conversion to strings
            if (!p.hasToken(JsonToken.VALUE_STRING)) {
                return (String) ctxt.handleUnexpectedToken(_valueClass, p);
            }

            return super.deserialize(p, ctxt);
        }

    }

}
