package ch_17.exercise17_09;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ***17.9 (Address book) Write a program that stores, retrieves, adds, and updates addresses
 * as shown in Figure 17.20. Use a fixed-length string for storing each attribute in the
 * address. Use random access file for reading and writing an address. Assume that
 * the size of name, street, city, state, and zip is 32, 32, 20, 2, 5 bytes, respectively.
 * FIGURE 17.20 The application can store, retrieve, and update addresses rom a file.
 */
public class Exercise17_09 extends Application {
    static String[] packageParts = Exercise17_09.class.getPackage().getName().split("\\.");
    final static String path = packageParts[0] + File.separator + packageParts[1] + File.separator + "address_store" +
            ".dat";
    static File storage;

    static int pointer;
    static List<String> addresses = new ArrayList<>();

    static final int NAME_SIZE = 32;
    static final int STREET_SIZE = 32;
    static final int CITY_SIZE = 20;
    static final int STATE_SIZE = 2;
    static final int ZIP_SIZE = 5;
    static final int TOTAL = 91;

    static TextField nameField;
    static TextField streetField;
    static TextField cityField;
    static TextField stateField;
    static TextField zipField;

    @Override
    public void start(Stage primaryStage) {
        storage = new File(path);
        String s = retrieve(storage);
        initAddressList(s);

        VBox rootBox = initUserInterface();
        Scene scene = new Scene(rootBox, 500, 170);

        primaryStage.setTitle("Exercise-17.09");
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(event -> {
            System.out.println("Window close requested, saving Addresses now...");
            try {
                store(storage);
            } catch (IOException ioException) {
                ioException.printStackTrace();
                displayError("Something went wrong storing the address file. Please check the log messages in the " +
                        "console output.");
            }
        });
        primaryStage.setOnShowing(event -> {
            if (addresses.size() > 0) {
                setCurrentAddress(addresses.get(0));
            }
        });
        primaryStage.show();
    }

    /**
     * Create the List<String> addresses by
     * parsing the String read from storage file
     *
     * @param s String which contains the contents of our storage File.
     */
    private void initAddressList(String s) {
        int len = s.length();
        while (len > 0) {
            len = len - TOTAL;
            addresses.add(s.substring(len));
            s = s.substring(0, len);
        }
    }


    private VBox initUserInterface() {
        VBox showBox = new VBox(5.0);

        Label name = new Label("Name");
        Exercise17_09.nameField = new TextField();

        Exercise17_09.nameField.setMinWidth(400);
        HBox topBox = new HBox(name, Exercise17_09.nameField);
        topBox.setSpacing(10);
        topBox.setPadding(new Insets(5, 5, 5, 5));

        showBox.getChildren().add(topBox);

        Label street = new Label("Street");
        Exercise17_09.streetField = new TextField();

        Exercise17_09.streetField.setMinWidth(400);
        HBox midBox = new HBox(street, Exercise17_09.streetField);
        midBox.setSpacing(10);
        midBox.setPadding(new Insets(5, 5, 5, 5));

        showBox.getChildren().add(midBox);

        Label city = new Label("City");
        Exercise17_09.cityField = new TextField();

        HBox h1 = new HBox(city, Exercise17_09.cityField);
        h1.setPadding(new Insets(2, 2, 2, 2));
        h1.setSpacing(10);

        Label state = new Label("State");
        Exercise17_09.stateField = new TextField();

        Exercise17_09.stateField.setMaxWidth(45);

        HBox h2 = new HBox(state, Exercise17_09.stateField);
        h2.setPadding(new Insets(2, 2, 2, 2));
        h2.setSpacing(10);

        Label zip = new Label("Zip");
        Exercise17_09.zipField = new TextField();

        Exercise17_09.zipField.setMaxWidth(65);
        HBox h3 = new HBox(zip, Exercise17_09.zipField);
        h3.setPadding(new Insets(2, 2, 2, 2));
        h3.setSpacing(10);

        HBox bottomBox = new HBox(h1, h2, h3);
        bottomBox.setAlignment(Pos.CENTER);

        showBox.getChildren().add(bottomBox);

        Button addButton = new Button("Add");
        addButton.setOnAction(event -> add());

        Button firstButton = new Button("First");
        firstButton.setOnAction(event -> first());

        Button nextButton = new Button("Next");
        nextButton.setOnAction(event -> next());

        Button previousButton = new Button("Previous");
        previousButton.setOnAction(event -> previous());

        Button lastButton = new Button("Last");
        lastButton.setOnAction(event -> last());

        Button updateButton = new Button("Update");
        updateButton.setOnAction(event -> update(pointer));
        HBox buttonBox = new HBox(addButton, firstButton, nextButton, previousButton, lastButton, updateButton);
        buttonBox.setSpacing(10.0);
        buttonBox.setAlignment(Pos.CENTER);

        showBox.getChildren().add(buttonBox);

        return showBox;
    }

    static void displayError(String error) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(error);
        alert.show();
    }


    private void add() {
        System.out.println(getAddressString());
        addresses.add(getAddressString());
    }

    private void first() {
        if (addresses.size() > 0) {
            pointer = 0;
            setCurrentAddress(addresses.get(pointer));
        } else {
            displayError("Create an address to add to the list.");
        }

    }

    private void next() {
        if (pointer < addresses.size() - 1) {
            ++pointer;
            setCurrentAddress(addresses.get(pointer));
        } else {
            displayError("End of address list reached.");
        }

    }

    private void previous() {
        if (pointer > 0) {
            --pointer;
            setCurrentAddress(addresses.get(pointer));
        } else {
            displayError("Beginning of address list reached.");

        }
    }


    private void last() {
        setCurrentAddress(addresses.get(addresses.size() - 1));
    }

    /**
     * Sets the UI TextField values to the address values from the fixed-length
     * String.
     *
     * @param fixLenStr String, of fixed length, holding the address values
     */
    private void setCurrentAddress(String fixLenStr) {
        Exercise17_09.nameField.setText(fixLenStr.substring(0, 32));
        Exercise17_09.streetField.setText(fixLenStr.substring(32, 64));
        Exercise17_09.cityField.setText(fixLenStr.substring(64, 84));
        Exercise17_09.stateField.setText(fixLenStr.substring(84, 86));
        Exercise17_09.zipField.setText(fixLenStr.substring(86));

    }

    private void update(int pointer) {
        addresses.set(pointer, getAddressString());
        displayInfo("Updated the address!");

    }

    private void displayInfo(String updated) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(updated);
        alert.show();
    }

    /**
     * Creates and writes to the File which acts as a
     * persistent data storage for the class.
     *
     * @param f the File to store address values in.
     */
    protected void store(File f) throws IOException {
        boolean b = false;
        if (!f.exists()) {
            try {
                b = f.createNewFile();
            } catch (Exception e) {
                try {
                    f.setWritable(true);
                    b = f.createNewFile();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

        try {
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            for (String address : addresses) {
                raf.writeUTF(address);
            }

            raf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param file The address storage file
     * @return a String holding the contents of the file
     */
    protected String retrieve(File file) {
        String read = "";
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                displayError("File does note exist and encountered an error while creating it.");
            }
        } else {
            try {
                RandomAccessFile raf = new RandomAccessFile(file, "r");
                while (true) {
                    read = read.concat(raf.readUTF());
                }

            } catch (EOFException eof) {
                System.out.println("End of File reached!");
                return read;
            } catch (IOException ioException) {
                displayError(ioException.getMessage());
            }
        }
        return read;
    }

    /**
     * @return A fixed length String containing the values of each
     * TextField, pulled from the the UI.
     */
    protected String getAddressString() {
        String address = "";
        String name = nameField.getText();

        for (int i = name.length(); i < NAME_SIZE; i++) {
            name += " ";
        }
        address += name;

        String street = streetField.getText();
        for (int i = street.length(); i < STREET_SIZE; i++) {
            street += " ";
        }
        address += street;

        String city = cityField.getText();
        for (int i = city.length(); i < CITY_SIZE; i++) {
            city += " ";
        }
        address += city;

        String state = stateField.getText();
        for (int i = state.length(); i < STATE_SIZE; i++) {
            state += " ";
        }
        address += state;

        String zip = zipField.getText();

        for (int i = zip.length(); i < ZIP_SIZE; i++) {
            zip += " ";
        }
        address += zip;

        return address;

    }

}