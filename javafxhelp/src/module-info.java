module javafxhelp {
    // 1. Tell Java which JavaFX modules you are using
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
	requires javafx.base;

    // 2. Give JavaFX permission to access your classes
    // This is crucial for the Application.launch() method to work
    opens application to javafx.graphics, javafx.fxml;
    
    // 3. Export the package so other modules can see it
    exports application;
}