
package com.test.testjava;

import java.util.List;

// Exercice 1 : Gestion des Employés 
public class Employee {
    
    protected String name ;
    protected String position ;
    protected  double salary ;
    
    public Employee(String name , String position , double salary){
        
        this.name = name ;
        this.position = position ;
        this.salary = salary ;   
    }



    // Exercice 2 : Calcul des Primes
    
    public static List<Employee> listeEmployeeSalaireDecroi(List<Employee> employes){
        
       employes.sort((a , b) -> Double.compare(b.salary, a.salary));
        
       return employes ;
             
    }
    
    
    public double CalculePrimeAnnuel(){
            double prime ;
            if (position.equals("Manage")){
                prime = salary*0.10;
                return prime ;
            }
            else{
                prime = salary*0.05 ;
                return prime ;
            }
            
        }
  }
    
    

