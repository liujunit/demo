package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationParse {
    public static void main(String[] args) {
        try {
            Method[] methods = AnnotationParse.class.getClassLoader().loadClass("annotation.AnnotationExample").getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(MyFirstAnnotaion.class)) {
                    Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                    for (Annotation declaredAnnotation : declaredAnnotations) {
                        System.out.println(method + ":" + declaredAnnotation);
                    }
                    MyFirstAnnotaion annotation = method.getAnnotation(MyFirstAnnotaion.class);
                    if (annotation.name().equals("zhangsan")) {
                        System.out.println(annotation.data());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
