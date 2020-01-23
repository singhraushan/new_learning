package com.rau.util.funtion;

import java.util.function.Predicate;
import static java.lang.System.out;

public interface PredicateDemo1 {
	public static void main(String[] args) {
                String[] names = {"raushan","amit kumar Singh", "chandan","rahul-kumar"};
                
                Predicate<String> p1 = name ->  name.contains("kumar");
                Predicate<String> p2 = name ->  name.length()>15;
                
                out.println("name contain kumar");
                for (String name: names){
                	if(p1.test(name)){
                		out.println(name);
                	}
                }
                
                //supply chain:  .and() /.or() / .negate()
                out.println("name contain kumar & lenght>15 :");
                for (String name: names){
                	if(p1.and(p2).test(name)){
                		out.println(name);
                	}
                }
                
                
                out.println("name contain kumar or  lenght>15 :");
                for (String name: names){
                	if(p1.or(p2).test(name)){
                		out.println(name);
                	}
                }
                
                out.println("name not contain kumar :");
                for (String name: names){
                	if(p1.negate().test(name)){
                		out.println(name);
                	}
                }
                
	}
}
