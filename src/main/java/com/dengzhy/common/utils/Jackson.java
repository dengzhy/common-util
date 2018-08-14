package com.dengzhy.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.io.Writer;

/**
 * FileName: Jackson
 * Author: dengzhy
 * Date: 2016/9/9 16:36
 * Description:
 */
public class Jackson {
    private static volatile Base base;
    private static volatile Simple simple;
    private static volatile Mobile mobile;

    public Jackson() {
    }

    public static Base base() {
        if(base == null) {
            Class var0 = Jackson.class;
            synchronized(Jackson.class) {
                if(base == null) {
                    base = new Base();
                }
            }
        }

        return base;
    }

    public static Simple simple() {
        if(simple == null) {
            Class var0 = Jackson.class;
            synchronized(Jackson.class) {
                if(simple == null) {
                    simple = new Simple();
                }
            }
        }

        return simple;
    }

    public static Mobile mobile() {
        if(mobile == null) {
            Class var0 = Jackson.class;
            synchronized(Jackson.class) {
                if(mobile == null) {
                    mobile = new Mobile();
                }
            }
        }

        return mobile;
    }

    public static class Mobile extends Base {
        public Mobile() {
            this.mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            this.mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
            this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }
    }

    public static class Simple extends Base {
        public Simple() {
            this.mapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
            this.mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            this.mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
            this.mapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);
            this.mapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
            this.mapper.addMixInAnnotations(Object.class, DynamicFieldFilterProvider.class);
            this.mapper.setFilters(new DynamicFieldFilterProvider(this.mapper.getSerializationConfig().getFilterProvider(), SimpleBeanPropertyFilter.serializeAllExcept(new String[0])));
            this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }

        public String writeValueAsString(Object value, String[] includeFields) {
            try {
                if(includeFields != null && includeFields.length > 0) {
                    DynamicFieldFilterProvider e = new DynamicFieldFilterProvider(this.mapper.getSerializationConfig().getFilterProvider(), SimpleBeanPropertyFilter.filterOutAllExcept(includeFields));
                    return this.mapper.writer(e).writeValueAsString(value);
                } else {
                    return this.mapper.writeValueAsString(value);
                }
            } catch (IOException var4) {
                throw new RuntimeException("Jackson 出异常了：", var4);
            }
        }
    }

    public static class Base {
        protected ObjectMapper mapper = new ObjectMapper();

        public Base() {
            this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }

        public TypeFactory getTypeFactory() {
            return this.mapper.getTypeFactory();
        }

        public ObjectMapper getObjectMapper() {
            return this.mapper;
        }

        public <T> T readValue(String content, Class<T> valueType) {
            try {
                return this.mapper.readValue(content, valueType);
            } catch (IOException var4) {
                throw new RuntimeException("Jackson 出异常了：", var4);
            }
        }

        public <T> T readValue(String content, TypeReference<?> valueTypeRef) {
            try {
                return this.mapper.readValue(content, valueTypeRef);
            } catch (IOException var4) {
                throw new RuntimeException("Jackson 出异常了：", var4);
            }
        }

        public <T> T readValue(String content, JavaType valueType) {
            try {
                return this.mapper.readValue(content, valueType);
            } catch (IOException var4) {
                throw new RuntimeException("Jackson 出异常了：", var4);
            }
        }

        public void writeValue(Writer w, Object value) {
            try {
                this.mapper.writeValue(w, value);
            } catch (IOException var4) {
                throw new RuntimeException("Jackson 出异常了：", var4);
            }
        }

        public String writeValueAsString(Object value) {
            try {
                return this.mapper.writeValueAsString(value);
            } catch (IOException var3) {
                throw new RuntimeException("Jackson 出异常了：", var3);
            }
        }
    }
}