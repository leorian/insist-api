package com.bozhong.insistapi.junit;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;  
  
public class TestMain {
  
    public static void main(String[] args) {  
        ParameterNameDiscoverer parameterNameDiscoverer =   
                new LocalVariableTableParameterNameDiscoverer();  
        try {  
            String[] parameterNames = parameterNameDiscoverer  
                    .getParameterNames(TestMain.class.getDeclaredMethod("test",
                            String.class, int.class));  
            System.out.print("test : ");  
            for (String parameterName : parameterNames) {  
                System.out.print(parameterName + ' ');  
            }  
        } catch (NoSuchMethodException | SecurityException e) {  
            e.printStackTrace();  
        }  
    }  
  
    public static void test(String param1, int param2) {  
        System.out.println(param1 + param2);  
    }  
}  
