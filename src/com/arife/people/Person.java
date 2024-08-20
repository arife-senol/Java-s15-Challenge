package com.arife.people;

public abstract class Person {
   private String name;
   public abstract void whoAreYou();

   public Person(String name){
       this.name=name;
   }
   public Person(){

   }
   public String getName(){
       return name;
   }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
