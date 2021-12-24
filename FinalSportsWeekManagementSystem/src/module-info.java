module SportsWeekManagementSystem {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires java.sql;
	requires junit;
	
	opens application to javafx.graphics, javafx.fxml;
}
