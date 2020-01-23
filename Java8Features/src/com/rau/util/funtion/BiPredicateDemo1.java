package com.rau.util.funtion;

import java.util.function.BiPredicate;
import java.util.function.Predicate;
import static java.lang.System.out;

public interface BiPredicateDemo1 {
	public static void main(String[] args) {
                String[] names = {"raushan","amit kumar Singh", "chandan","rahul-kumar"};
                
                BiPredicate<String,String> p1 = (name,country) ->  name.contains("kumar") && country.contains("India");
                BiPredicate<String,String> p2 = (name,country) ->  name.length()>15 && country.contains("India");
                
                out.println("name contain kumar  & country: India");
                for (String name: names){
                	if(p1.test(name,"India")){
                		out.println(name);
                	}
                }
                
                //supply chain:  .and() /.or() / .negate()
                out.println("name contain kumar  & country: India & lenght>15 :");
                for (String name: names){
                	if(p1.and(p2).test(name,"India")){
                		out.println(name);
                	}
                }
                
                
                out.println("name contain kumar & country: India or  lenght>15 :");
                for (String name: names){
                	if(p1.or(p2).test(name,"India")){
                		out.println(name);
                	}
                }
                
                out.println("name not contain kumar & country: India");
                for (String name: names){
                	if(p1.negate().test(name,"India")){
                		out.println(name);
                	}
                }
                
	}
}
