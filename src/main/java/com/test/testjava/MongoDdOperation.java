package com.test.testjava;

import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class MongoDdOperation {

    //Exercice 3 : Connexion et Insertion 

    private static final String URI = "mongodb+srv://gloire:1234@cluster0.5jygq0j.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private static MongoDatabase database;

    public static void main(String[] args) {
    try (MongoClient mongoClient = MongoClients.create(URI)) {
        database = mongoClient.getDatabase("gestion_employes");

        MongoCollection<Document> collection = database.getCollection("employees");

        Document emp1 = new Document("name", "Gloire Kombo")
                .append("position", "Développeur")
                .append("salary", 8000);

        Document emp2 = new Document("name", "Sarah Mbayo")
                .append("position", "Designer")
                .append("salary", 6000);

        Document emp3 = new Document("name", "Jean Mavungu")
                .append("position", "Développeur")
                .append("salary", 7500);

        Document emp4 = new Document("name", "Elie Bosolo")
                .append("position", "Manager")
                .append("salary", 9500);


        collection.insertMany(List.of(emp1, emp2, emp3, emp4));

        System.out.println("Données enregistrer avec  succès ");
        
        rechercheParPosition("Designer");
        mettreAjoutSalaire("Gloire Kombo", 9000);
        supprimerEmploye("Sarah Mbayo");
        
       

    } catch (Exception e) {
        System.out.println("Erreur de connexion MongoDB : " + e.getMessage());
    }
}



// Exercice 4 : Opérations CRUD 

    
    public static void rechercheParPosition(String position) {
        MongoCollection<Document> collection = database.getCollection("employees");
        Bson filter = Filters.eq("position", position);
        FindIterable<Document> results = collection.find(filter);
    
        boolean trouver = false;
        for (Document doc : results) {
            System.out.println("Employé trouvé : " + doc.toJson());
            trouver = true; 
        }
    
        if (!trouver) {
            System.out.println("Aucun employé trouvé avec la position : " + position);
        }
    }
    

  
    public static void mettreAjoutSalaire(String name, double newSalary) {
        MongoCollection<Document> collection = database.getCollection("employees");

        Bson filter = Filters.eq("name", name);
        Document employee = collection.find(filter).first();

        if (employee != null) {
            collection.updateOne(filter, Updates.set("salary", newSalary));
            System.out.println("Salaire mis à jour pour " + name + " à " + newSalary);
        } else {
            System.out.println("Aucun employé trouvé avec le nom : " + name);
        }
    }


    public static void supprimerEmploye(String name) {
        MongoCollection<Document> collection = database.getCollection("employees");

        Bson filter = Filters.eq("name", name);
        Document employee = collection.find(filter).first();

        if (employee != null) {
            collection.deleteOne(filter);
            System.out.println("Employé supprimé : " + name);
        } else {
            System.out.println("Aucun employé trouvé avec le nom : " + name);
        }
    }
}
