package com.test.testjava;

import java.util.ArrayList;
import java.util.List;
import com.test.testjava.Employee;
import static com.test.testjava.Employee.listeEmployeeSalaireDecroi;


public class Test_java {

    public static void main(String[] args) {
        System.out.println("bonjour");
        
        List<Employee> employes = new ArrayList<>();
        
        Employee employee1 = new Employee("gloire" ,"DEveloppeur" ,300000 ) ;
        Employee employee2 = new Employee("KOMBO" ,"managers" ,200000 ) ;
        Employee employee3 = new Employee("MABIALA" ,"Data science" ,400000 ) ;
        
        employes.add(employee1);
        employes.add(employee2);
        employes.add(employee3);
        
        List <Employee> listeEmployee = listeEmployeeSalaireDecroi(employes) ;
        
        System.out.println("------------- La liste d’employés triée par salaire décroissant-------------------- ");
        
        for(Employee decroi : listeEmployee){
            System.out.println("Nom:"+decroi.name+"| position:"+decroi.position+"|salaire:"+decroi.salary+"FCFA");
        }
        
        System.err.println("--------------------PRIME ANNUELLE------------------");
        for(Employee decroi : listeEmployee){
            System.out.println("Nom: "+decroi.name+"| Position "+ decroi.position+ "| prime annuelle de: "+decroi.CalculePrimeAnnuel()+ "FCFA");
        }
        
    }
}
