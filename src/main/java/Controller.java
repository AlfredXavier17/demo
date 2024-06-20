
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Controller {



        @FXML
        private BarChart<String, Number> barChart;

        @FXML
        private CategoryAxis xAxis;

        @FXML
        private NumberAxis yAxis;

        public void initialize() {
            loadDataFromDatabase();
        }

        private void loadDataFromDatabase() {
            try {
                Connection conn = DBConnector.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT month, sales_amount FROM sales");

                XYChart.Series<String, Number> series = new XYChart.Series<>();
                while (rs.next()) {
                    series.getData().add(new XYChart.Data<>(rs.getString("month"), rs.getDouble("sales_amount")));
                }

                barChart.getData().add(series);

                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


