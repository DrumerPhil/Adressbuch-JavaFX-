package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends Application {

    String username;

    List<Contact> contacts = new ArrayList<>();
    // contacts.add(Contact c1 = new Contact("Leo", "Junkes", "", "", "", "", "", ""));

    File data = new File("data.txt");

    FileWriter writer;
    Scanner scanner;
    // Scanner scanner = new Scanner(data);

    public void saveData(String username) {
        try {
            writer = new FileWriter(data, false);
            scanner = new Scanner(data);
            // System.out.print(scanner.nextLine());
            // funktioniert nicht
            writer.write("username=" + username);
            // writer.write(System.getProperty("line.seperator"));
            // Aus irgendeinem Grund funktioniert die Zeile nicht.
            writer.flush();
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    // Diese Methode soll in die Datei data.txt den Vor- und Nachnamen reinschreiben. Aber irgendwie funktioniert das nicht.


    
    @Override
    public void start(Stage primaryStage) {

        // Konfiguration von grid:

        primaryStage.setTitle("Adressbuch");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        Text greeting = new Text("Herzlich Willkommen!");
        greeting.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        grid.add(greeting, 0, 0, 2, 1);

        Label vorname = new Label("Vorname:");
        grid.add(vorname, 0, 1);

        TextField eingabeVorname = new TextField();
        grid.add(eingabeVorname, 1, 1);

        Label nachname = new Label("Nachname:");
        grid.add(nachname, 0, 2);

        TextField eingabeNachname = new TextField();
        grid.add(eingabeNachname, 1, 2);

        Button btn = new Button("Anmelden");
        grid.add(btn, 0, 4);

        Text ziel = new Text();
        grid.add(ziel, 0, 6, 3, 1);

        // Konfiguration von grid2:

        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(10, 10, 10, 10));

        Text title = new Text("Kontakte");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        List<Label> contactLabels = new ArrayList<Label>();
        Button createContactButton = new Button("Neuen Kontakt erstellen");
        grid2.add(createContactButton, 4, 0);

        // if(!contacts.isEmpty()) {
        //     for(int i = 0; i <= contacts.size(); i++) {
        //         grid2.add(contacts.listIterator(i).name, 0, 1, 2, 1);
        //         System.out.println(contacts.listIterator(i).name);
        //     }
        // } else {
        //     grid2.add();
        // }

        grid2.add(title, 0, 0, 2, 1);
        title.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        // grid2.add(c1.name, 0, 1, 2, 1);

        // Konfiguration von scene und primaryStage:

        Scene scene = new Scene(grid, 480, 360);
        Scene scene2 = new Scene(grid2, 480, 360);
        primaryStage.setMinWidth(480);
        primaryStage.setMinHeight(388); // Anscheinend muss man hier immer 28 Pixel mehr angeben, um auf die richtige Größe zu kommen.
        primaryStage.setScene(scene);
        primaryStage.show();

        // Wenn der Button gedrückt wird:

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                ziel.setText("Sie sind angemeldet!");
                String vorname = eingabeVorname.getText();
                String nachname = eingabeNachname.getText();
                String name;
                if((vorname == "" || vorname.startsWith(" ")) && (nachname != "" || nachname.startsWith(" "))) {
                    name = nachname;
                } else if((nachname == "" || nachname.startsWith(" ")) && (vorname != "" || vorname.startsWith(" "))) {
                    name = vorname;
                } else if((vorname == "" || vorname.startsWith(" ")) && (nachname == "" || nachname.startsWith(" "))) {
                    name = "";
                } else {
                    name = vorname + " " + nachname;
                }
                // Hier wird geprüft, ob ein Textfeld leer ist (oder beide), um dann nur einen der Namen zu verwenden oder, ob keins ausgefüllt ist, um den Nutzer zu informieren, dass er/sie sich ohne Namen nicht anmelden kann.
                username = name;
                saveData(username);
                if(name == "") {
                    ziel.setText("Geben sie einen Namen an.");
                } else {
                    ziel.setText("Sie sind angemeldet, " + name + "!");
                }



                // zu scene2 wechseln
                primaryStage.setScene(scene2);



                // Konfiguration von grid3:
                GridPane grid3 = new GridPane();
                grid3.setAlignment(Pos.CENTER);
                grid3.setHgap(10);
                grid3.setVgap(10);
                grid3.setPadding(new Insets(10, 10, 10, 10));


                // Konfiguration von Scene3:
                Scene scene3 = new Scene(grid3, 480, 360);
                primaryStage.setScene(scene3);


            }
        });

    }

    public static void main(String[] args) {

        launch(args);

    }

}
