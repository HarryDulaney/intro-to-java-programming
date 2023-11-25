package ch_32;

import java.sql.*;

import ch_32.common.ChartModel;
import ch_32.common.BarChart;
import ch_32.common.Constants;
import ch_32.common.PieChart;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.application.Application;

/**
 * **32.2 (Visualize data) Write a program that displays the number of students in each
 * department in a pie chart and a bar chart, as shown in Figure 32.27b. The number
 * of students for each department can be obtained from the Student table (see
 * Figure 32.4) using the following SQL statement:
 * select deptId, count(*)
 * from Student
 * where deptId is not null
 * group by deptId;
 * <p>
 * <p>
 * Chapter 32 Exercises require DB setup see the ReadMe.md for detailed instructions.
 */
public class Exercise32_02 extends Application {
    private String[] dataName;
    private double[] data;

    @Override
    public void start(Stage primaryStage) {
        initializeDB();

        ChartModel chartModel = new ChartModel();
        chartModel.setChartData(dataName, data);

        PieChart pieChart = new PieChart();
        BarChart barChart = new BarChart();

        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(pieChart, barChart);

        Scene scene = new Scene(hBox, 420, 80);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

        pieChart.setModel(chartModel);
        barChart.setModel(chartModel);
    }

    private void initializeDB() {
        try {
            Connection conn = DriverManager.getConnection
        (Constants.MY_SQL_DB_URL, Constants.MY_SQL_DB_USERNAME, Constants.MY_SQL_DB_PASSWORD);
            System.out.println("Database connected\n");

            // Connect to the sample database
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select deptId, count(*) from Student where deptId is not null group by deptId;");

            // Count rows
            int count = 0;
            while (rs.next()) {
                count++;
            }

            dataName = new String[count];
            data = new double[count];

            // We have to obtain the result set again
            rs = stmt.executeQuery(
                    "select deptId, count(*) from Student where deptId is not null group by deptId;");
            int i = 0;
            while (rs.next()) {
                dataName[i] = rs.getString(1);
                data[i] = rs.getInt(2);
                i++;
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}

