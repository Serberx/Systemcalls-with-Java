module at.spengergasse.systemcalls {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens at.spengergasse.systemcalls to javafx.fxml;
    exports at.spengergasse.systemcalls;
}