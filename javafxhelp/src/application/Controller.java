package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.TextFlow;
import java.lang.Math;
import java.lang.*;

import application.study.Graph;

public class Controller {

	@FXML
	
	private Circle myCircle;
	private double x;
	private double y;
	public Pane drawingPane;
	public Line newLine;

	public double detail = 1; //disproportional
	public double scale  = 20; //
	
	
	public void bottom() {

		for(double i=-384;i<=384;i=i+detail) { //i is like the x axis
			double y , nexty ; 					//nexty is to calculate the line's ending
			y = -1*scale*MathFunction(i/scale);
			nexty = -1*scale*MathFunction((i+detail)/scale);
			
			if (nexty == Double.POSITIVE_INFINITY || nexty == Double.NEGATIVE_INFINITY || nexty == Double.NaN || y == Double.NaN) {
								// this is supposed to check if values are defined
				y = 0;			// but it doesnt work like i thought for some reason
				nexty = 0;		
								
				break;			
			} else {				
				
				Line newLine = new Line((i)+384 , y+384 , (i+detail)+384 , nexty+384 );
				
				newLine.setStroke(Color.WHITE);
				newLine.setOpacity(0.5);
				newLine.setScaleX(scale/10);
				newLine.setScaleY(scale/10);
				newLine.setId("sigmaLine");
				
				drawingPane.getChildren().add(newLine);
			}
		}
	}
	public double MathFunction(double x){ // the mathematical function to plot
		double y;    
		
		y = 10*Math.sin(0.1*x*Math.PI);
		
		return y;   
	}
			
			
			
	public void increaseScale(){
		scale = scale + 1;
		drawingPane.getChildren().removeIf(node -> "sigmaLine".equals(node.getId()));
		bottom();
	}
	public void decreaseScale(){
		scale = scale - 1;
		drawingPane.getChildren().removeIf(node -> "sigmaLine".equals(node.getId()));
		bottom();
	}
	public void increaseDetail(){
		detail = detail - 1;
		drawingPane.getChildren().removeIf(node -> "sigmaLine".equals(node.getId()));
		bottom();
	}
	public void decreaseDetail(){
		detail = detail + 1;
		drawingPane.getChildren().removeIf(node -> "sigmaLine".equals(node.getId()));
		bottom();
	}
	public void moveUp() {
		double i = newLine.getTranslateX();
		System.out.println(i);
	}
	
	 
}
