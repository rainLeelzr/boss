package com.rain.boss.interceptor.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

public class AnnotationCache {

    private static final Map<Class<?>, Map<Method, Set<Class<?>>>> cache = Collections.synchronizedMap(new
            HashMap<Class<?>, Map<Method, Set<Class<?>>>>());

    public static boolean hasAnnotation(ProceedingJoinPoint p, Class<?> targetAnnotation) throws NoSuchMethodException {
        Signature signature = p.getSignature();
        if (!(signature instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        MethodSignature methodSignature = (MethodSignature) signature;
        Class<?> targetClass = p.getTarget().getClass();
        Method targetMethod = targetClass.getMethod(methodSignature.getName(), methodSignature.getParameterTypes());

        Map<Method, Set<Class<?>>> methodsInClass = cache.get(targetClass);
        if (methodsInClass == null) {
            methodsInClass = addMethodsInClass(targetClass);
        }

        Set<Class<?>> annotationsInTargetMethod = methodsInClass.get(targetMethod);
        for (Class<?> annotation : annotationsInTargetMethod) {
            if (annotation.equals(targetAnnotation)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 添加类中的所有方法到缓存
     *
     * @param targetClass 需要添加的类
     * @return 添加后的map
     */
    private static synchronized Map<Method, Set<Class<?>>> addMethodsInClass(Class<?> targetClass) {
        Map<Method, Set<Class<?>>> methodsInClass = cache.get(targetClass);
        if (methodsInClass == null) {
            methodsInClass = Collections.synchronizedMap(new HashMap<Method,
                    Set<Class<?>>>());
            Method[] allMethodsInTargetClass = targetClass.getDeclaredMethods();
            for (Method tempMethod : allMethodsInTargetClass) {
                Annotation[] declaredAnnotations = tempMethod.getDeclaredAnnotations();
                Set<Class<?>> annotationsInMethod = Collections.synchronizedSet(new HashSet<Class<?>>());
                for (Annotation annotation : declaredAnnotations) {
                    Class<?> annotationClass = annotation.annotationType();
                    annotationsInMethod.add(annotationClass);
                }
                methodsInClass.put(tempMethod, annotationsInMethod);
            }

            cache.put(targetClass, methodsInClass);
        }

        return methodsInClass;
    }

}
