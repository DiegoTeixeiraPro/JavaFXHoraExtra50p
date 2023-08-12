package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class ViewController implements Initializable {

	@FXML
	private TextField txtValorSalario;
	@FXML
	private TextField txtQtdHoras;
	@FXML
	private TextField txtQtdMinutos;

	@FXML
	private Label labelResultadoCalculo;
	@FXML
	private Button btCalculo;
	@FXML
	private MenuItem menuItemFechar;
	@FXML
	private MenuItem menuItemLimpar;
	@FXML
	private MenuItem menuItemSobre;

	@FXML
	public void onBtCalculo() {
		try {
			String valorSalarioStr = txtValorSalario.getText().replace(',', '.');
			double valorSalario = Double.parseDouble(valorSalarioStr);

			String qtdHorasStr = txtQtdHoras.getText().replace(',', '.');
			double qtdHoras = qtdHorasStr.isEmpty() ? 0 : Double.parseDouble(qtdHorasStr);

			String qtdMinutosStr = txtQtdMinutos.getText().replace(',', '.');
			double qtdMinutos = qtdMinutosStr.isEmpty() ? 0 : Double.parseDouble(qtdMinutosStr);

			double somaMinutos = qtdHoras * 60 + qtdMinutos;
			double valorDoMinutoExtra = ((valorSalario / 220) * 1.50) / 60;
			double calculo = valorDoMinutoExtra * somaMinutos;

			labelResultadoCalculo.setText(String.format("%.2f", calculo));

		} catch (NumberFormatException e) {
			Alerts.showAlert("Erro", "Erro de validação", "Certifique-se de inserir valores numéricos válidos.",
					AlertType.ERROR);
		}
	}

	@FXML
	private void onMenuItemFecharAction(ActionEvent event) {
		Platform.exit();
	}

	@FXML
	private void onMenuItemLimparAction(ActionEvent event) {
		txtValorSalario.clear();
		txtQtdHoras.clear();
		txtQtdMinutos.clear();
		labelResultadoCalculo.setText("");
	}
	
    @FXML
    private void onMenuItemSobreAction(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Sobre");
        alert.setHeaderText(null);
        alert.setContentText("Desenvolvido por Diego Teixeira\nGitHub: https://github.com/DiegoTeixeiraPro");
        alert.showAndWait();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Constraints.setTextFieldSalario(txtValorSalario);
		Constraints.setTextField(txtQtdHoras);
		Constraints.setTextField(txtQtdMinutos);

		menuItemFechar.setOnAction(event -> onMenuItemFecharAction(event));
		menuItemLimpar.setOnAction(event -> onMenuItemLimparAction(event));
        menuItemSobre.setOnAction(event -> onMenuItemSobreAction(event));

	}
}