import java.util.*;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class WorldClockControl extends BorderPane {
  // Obtain all available locales and time zone ids
  private Locale[] availableLocales = Locale.getAvailableLocales();
  private String[] availableTimeZones = TimeZone.getAvailableIDs();

  // Comboxes to display available locales and time zones
  private ComboBox<String> cboLocales = new ComboBox<>();
  private ComboBox<String> cboTimeZones = new ComboBox<>();

  // Create a clock
  private WorldClock clock = new WorldClock();

  public WorldClockControl() {
    // Initialize cboLocales with all available locales
    setAvailableLocales();

    // Initialize cboTimeZones with all available time zones
    setAvailableTimeZones();

    // Initialize locale and time zone
    clock.setLocale(
      availableLocales[cboLocales.getSelectionModel()
        .getSelectedIndex()]);
    clock.setTimeZone(TimeZone.getTimeZone(
      availableTimeZones[cboTimeZones.getSelectionModel()
        .getSelectedIndex()]));

    GridPane pane = new GridPane();
    pane.setHgap(5);
    pane.add(new Label("Locale"), 0, 0);
    pane.add(new Label("Time Zone"), 0, 1);
    pane.add(cboLocales, 1, 0);
    pane.add(cboTimeZones, 1, 1);

    setTop(pane);
    setCenter(clock);
    BorderPane.setAlignment(pane, Pos.CENTER);
    BorderPane.setAlignment(clock, Pos.CENTER);

    cboLocales.setOnAction(e ->
      clock.setLocale(availableLocales[cboLocales.
        getSelectionModel().getSelectedIndex()]));
    cboTimeZones.setOnAction(e ->
      clock.setTimeZone(TimeZone.getTimeZone(
        availableTimeZones[cboTimeZones.
          getSelectionModel().getSelectedIndex()])));
  }

  private void setAvailableLocales() {
    for (int i = 0; i < availableLocales.length; i++) 
      cboLocales.getItems().add(availableLocales[i]
       .getDisplayName() + " " + availableLocales[i].toString());

    cboLocales.getSelectionModel().selectFirst();
  }

  private void setAvailableTimeZones() {
    // Sort time zones
    Arrays.sort(availableTimeZones);
    for (int i = 0; i < availableTimeZones.length; i++) {
      cboTimeZones.getItems().add(availableTimeZones[i]);
    }
    cboTimeZones.getSelectionModel().selectFirst();
  }
}
