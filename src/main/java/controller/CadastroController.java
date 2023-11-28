package controller;

import dao.UsersDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Users;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CadastroController implements Initializable {

    @FXML
    TextField textID;
    @FXML
    TextField textName;
    @FXML
    TextField textAge;
    @FXML
    TextField textLogin;
    @FXML
    TextField textPassword;
    @FXML
    TableView<Users> usersTable;
    @FXML
    TableColumn<Users, String> columnName;
    @FXML
    TableColumn<Users, Integer> columnAge;
    @FXML
    TableColumn<Users, String> columnID;

    public void save(ActionEvent event) throws SQLException {
        Users user = new Users();
        UsersDAO usersDAO = new UsersDAO();
        user.setAge(Integer.parseInt(textAge.getText()));
        user.setName(textName.getText());
        user.setLogin(textLogin.getText());
        user.setPassword(textPassword.getText());
        usersDAO.create(user);
        preencheTabela();
    }
    public void retrieve(ActionEvent event) throws SQLException {
        if(!textID.getText().isEmpty()){
            int id = Integer.parseInt(textID.getText().toString());
            UsersDAO usersDAO = new UsersDAO();
            Users user = usersDAO.select(id);
            textName.setText(user.getName());
            textID.setText(String.valueOf(user.getId()));
            textLogin.setText(user.getLogin());
            textPassword.setText(user.getPassword());
        }else{
            System.out.println("Error");
        }

    }
    public void cancel(ActionEvent event){
        //clear all fields
        textName.setText("");
        textID.setText("");
        textAge.setText("");
        textLogin.setText("");
        textPassword.setText("");
    }
    public void delete(ActionEvent event){
        //Falta implementar
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        preencheTabela();
    }
    private ObservableList<Users> usersList() throws SQLException {
        return FXCollections.observableArrayList(new UsersDAO().listAll());
    }

    public void preencheTabela(){
        columnAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        try {
            usersTable.setItems(usersList());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
