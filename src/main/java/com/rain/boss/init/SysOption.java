package com.rain.boss.init;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rain.boss.exception.system.SystemException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Component
public class SysOption implements InitializingBean {

    private static final Map<String, String> json = new HashMap<>();
    private static final Map<String, Object[]> objectMap = new HashMap<>();

    public static Object[] get(String opt) throws SystemException {
        Object[] j = objectMap.get(opt);
        if (j == null) {
            throw new SystemException("objectMap中无key为【" + opt + "】的对象");
        }
        return j;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Class<?>[] declaredClasses = SysOption.class.getDeclaredClasses();
        for (Class<?> declaredClass : declaredClasses) {
            Method method = declaredClass.getMethod("values");
            Object[] inter = (Object[]) method.invoke(null);

            String optJson = mapper.writeValueAsString(inter);
            String className = declaredClass.getSimpleName();
            className = Character.toLowerCase(className.charAt(0)) + className.substring(1);
            json.put(className, optJson);
            objectMap.put(className, inter);
            System.out.println(optJson);
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    private enum Enabled {
        TRUE("启用", 1), FALSE("禁用", 0);

        private String key;

        private String name;

        private int value;

        private int ordinal;

        private int enabled = 1;//默认启用

        Enabled(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public int getEnabled() {
            return enabled;
        }

        public void setEnabled(int enabled) {
            this.enabled = enabled;
        }

        public String getKey() {
            return this.name();
        }

        public void setKey(String key) {
            this.key = key;
        }

        public int getOrdinal() {
            return this.ordinal();
        }

        public void setOrdinal(int ordinal) {
            this.ordinal = ordinal;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Enabled{" +
                    "key='" + key + '\'' +
                    ", name='" + name + '\'' +
                    ", value=" + value +
                    ", ordinal=" + ordinal +
                    ", enabled=" + enabled +
                    '}';
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    private enum Gender {
        MAN("男", 1, 0), FEMALE("女", 2);

        private int ordinal;

        private String key;

        private String name;

        private int value;

        private int enabled = 1;//默认启用

        Gender(String name, int value) {
            this.name = name;
            this.value = value;
        }

        Gender(String name, int value, int enabled) {
            this.name = name;
            this.value = value;
            this.enabled = enabled;
        }

        public int getEnabled() {
            return enabled;
        }

        public void setEnabled(int enabled) {
            this.enabled = enabled;
        }

        public String getKey() {
            return this.name();
        }

        public void setKey(String key) {
            this.key = key;
        }

        public int getOrdinal() {
            return this.ordinal();
        }

        public void setOrdinal(int ordinal) {
            this.ordinal = ordinal;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Gender{" +
                    "ordinal=" + ordinal +
                    ", key='" + key + '\'' +
                    ", name='" + name + '\'' +
                    ", value=" + value +
                    ", enabled=" + enabled +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
//        ObjectMapper mapper = new ObjectMapper();
//
//        EnumSet<Gender> es1 = EnumSet.allOf(Gender.class);
//        Gender[] values = Gender.values();
//        String Json = mapper.writeValueAsString(values);
//        System.out.println(Json);
//
//        EnumSet<Enabled> es2 = EnumSet.allOf(Enabled.class);
//        Enabled[] values2 = Enabled.values();
//        String Json2 = mapper.writeValueAsString(values2);
//        System.out.println(Json2);

        SysOption sysOption = new SysOption();
        sysOption.afterPropertiesSet();

    }

}
