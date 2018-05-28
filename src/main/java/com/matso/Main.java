package com.matso;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Which serialization format do you choose? Type a number");
        System.out.println("1: JSON");
        System.out.println("2: Properties");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println();

        if (input.equals("1")) toJSON(Employee.getEmployee());
        else if (input.equals("2")) toProperties(Employee.getEmployee());
        else System.out.println("Wrong input");

    }


    static void toProperties(Object employee) throws Exception {
        Properties p = new Properties();

        writeProperties(employee, p, "");
        Map<Object, Object> map = new TreeMap<Object, Object>();
        for (Map.Entry<Object, Object> entry : p.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<Object, Object> entry : map.entrySet()) {

            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

    }

    static void writeProperties(Object employee, Properties p, String perviousName) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(employee.getClass());

        for (PropertyDescriptor pd : beanInfo.getPropertyDescriptors()) {
            String name = pd.getName();
            if (name.equals("class")) continue;
            if (perviousName.equals("")) name = pd.getName();
            else name = perviousName + "." + pd.getName();
            Object o = pd.getReadMethod().invoke(employee);

            //Here I check if object property is also an object (but not String object)
            if (pd.getPropertyType().toString().contains("class") && !pd.getPropertyType().toString().contains("String")) {
                writeProperties(o, p, name);
            } else {
                p.setProperty(name, o == null ? null : o.toString());
            }
        }

    }

    static private void toJSON(Employee employee) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
        mapper.writeValue(System.out, employee);
    }

}

