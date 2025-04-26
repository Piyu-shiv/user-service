package com.prodev.user.userservice.utility;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ModelMapper<T, F> {

    public ModelMapper() {
        // TODO Auto-generated constructor stub
    }


    public String capitalizeString(String method) {
        return method.substring(0, 1).toUpperCase() + method.substring(1);
    }

    public T mapObject(T t, F f) {
        Class obj1 = f.getClass();
        Class obj2 = t.getClass();
        Field[] list1 = obj1.getDeclaredFields();
        Field[] list2 = obj2.getDeclaredFields();
        for (Field f1 : list1) {
            for (Field f2 : list2) {
                if (f1.getName() == f2.getName()) {
                    try {
                        System.out.println(f1.getName() + "   here what it is..................      "+ f2.getName());
                        System.out.println("it is comming here         " + f1.getName().substring(0, 1).toUpperCase() + f1.getName().substring(1));
                        Method method1 = obj1.getDeclaredMethod("get" + capitalizeString(f1.getName()));
                        Method method2 = obj2.getDeclaredMethod("set" + capitalizeString(f2.getName()), f1.getType());
                        try {
                            method2.invoke(t, method1.invoke(f));
                        } catch (IllegalAccessException e) {
                            // TODO Auto-generated catch blocky
                            e.printStackTrace();
                        } catch (IllegalArgumentException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                    } catch (NoSuchMethodException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (SecurityException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            }

        }
        return t;
    }
}