package sample;

import sample.PersistenceManager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.persistence.EntityManager;

public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ticketService.fxml"));
        primaryStage.setTitle("Ticket Service");
        primaryStage.setScene(new Scene(root, 1160, 650));
        primaryStage.show();
    }

    public static void main(String[] args) {
//        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
//
//            em.getTransaction().begin();
//            em.persist();
//            em.getTransaction().commit();
//        }
//        em.close();
//        PersistenceManager.INSTANCE.close();
    }
}
