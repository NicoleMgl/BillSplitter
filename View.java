package billSplitter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class View implements EventHandler<ActionEvent>{

	Model BS;
	TextField calculatedAmount;
	TextField total;
	TextField people;
	double splitTotal;
	
	public View(TextField c, TextField totalAmount, TextField splitAmount) {
		this.calculatedAmount = c;
		this.total = totalAmount;
		this.people = splitAmount;
	}

	public void calculate() {
		
		double dTotal = Double.parseDouble(total.getText());
		int iPeople = Integer.parseInt(people.getText());
		double calculation = dTotal/iPeople;
		double fixed = Math.round(calculation * 100d) / 100d;
		this.splitTotal = fixed;
	}
	
	public double getSplitTotal() {
		calculate();
		return this.splitTotal;
	}
	
	@Override
	public void handle(ActionEvent e) {
		double calculated = getSplitTotal();
		String calcString = Double.toString(calculated);
		this.calculatedAmount.setText(calcString);
		
	}
	


}
