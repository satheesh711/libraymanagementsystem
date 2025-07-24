/* doesn't work with source level 1.8:
module library.libraryManagementSystem {
    requires javafx.controls;
    requires javafx.fxml;

    opens library.libraryManagementSystem to javafx.fxml;
    exports library.libraryManagementSystem;
}
*/
