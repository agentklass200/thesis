import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import java.io.*;
import java.util.ArrayList;

import CSVProcess.CSVProcessing;
import CSVProcess.InfoBean;



public class main extends Application{
	
	Button getCSVFile, next, prev;
	
	
	Stage window;
	Scene scene[], activeScene;
	File activeFile;
	ArrayList<InfoBean> data;
	
	
	public static void main(String[] args){
		launch(args);
	}
	
	public ArrayList<InfoBean> getData() {
		return data;
	}

	public void setData(ArrayList<InfoBean> data) {
		this.data = data;
	}

	@Override
	
	public void start(Stage primaryStage) throws Exception{
		window = primaryStage;
		
		window.setTitle("Table to Text");
		
		//Label
		Label headerTitle = new Label("Table to Text");
		headerTitle.getStyleClass().add("header");
		
		//Text Field
		TextField CSVFileLocation = new TextField();
		CSVFileLocation.setMaxWidth(500);
		CSVFileLocation.setStyle("-fx-background-color: #fff; -fx-border-color: black;");
		CSVFileLocation.setEditable(false);
		
		//getCSVButton
		getCSVFile = new Button();
		getCSVFile.setText("Browse");
		
		
		FileChooser CSVFileChooser = new FileChooser();
		CSVFileChooser.setTitle("Choose a CSV File");
		
		
		//next button
		
		next = new Button("Next");
		
		//NP Container
		
		HBox npContainer = new HBox();
		npContainer.getChildren().add(next);
		npContainer.setAlignment(Pos.BASELINE_CENTER);
		
		//Layout Scene 1
		VBox layout = new VBox();
		layout.getChildren().addAll(headerTitle, CSVFileLocation, getCSVFile);
		VBox.setMargin(getCSVFile,new Insets(20,0,0,0));
		VBox.setMargin(npContainer,new Insets(50,0,0,0));
		layout.setAlignment(Pos.CENTER);
		
		//Initializing Scene
		
		Scene scene[] = new Scene[3];
		int sceneNo = 0;
		
		scene[0] = new Scene(layout, 700, 500);
		activeScene = scene[sceneNo];
		activeScene.getStylesheets().add("style.css");
		
		//Layout Scene 2
		Label scene2Label = new Label("Hello World!");
				
		VBox layout1 = new VBox();
				
		scene[1] = new Scene(layout1, 700, 500);
				
		//Initializing Stage
		
		window.setScene(activeScene);
		window.show();
		
		getCSVFile.setOnAction(e -> {
			File CSVFile = CSVFileChooser.showOpenDialog(primaryStage);
				if (CSVFile != null){
					CSVFileLocation.setText(CSVFile.getAbsolutePath());
					activeFile = CSVFile;
					
					layout.getChildren().add(npContainer);
					
					
				}
				else{
					System.out.println("Nah!");
				}
		});
		
		next.setOnAction(e -> {
			activeScene = changeScene(scene, sceneNo);
			window.setScene(activeScene);
			activeScene.getStylesheets().add("style.css");
			data = new ArrayList<InfoBean>();
			try {
				data = CSVProcessing.readCSV(activeFile.getAbsolutePath(), data);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			layout1.getChildren().add(this.createTableView(data));
			
//			for(int i = 0; i < data.size(); i++){
//				System.out.println(data.get(i).toString());
//			}
//			
//			System.out.println(data.size());
		});
	}
	
	public TableView createTableView(ArrayList<InfoBean> data){
		TableView<InfoBean> table = new TableView<InfoBean>();
		ObservableList<InfoBean> values = FXCollections.observableArrayList(data);
		table.setEditable(false);
		
		TableColumn regionCol = new TableColumn(data.get(0).getRegionColumnName());
		regionCol.setCellValueFactory(new PropertyValueFactory<InfoBean, String>("region"));
		
		TableColumn totalCol = new TableColumn(data.get(0).getTotalColumnName());
		TableColumn specialWorkersCol = new TableColumn(data.get(0).getServiceWorkersColumnName());
		TableColumn officialsCol = new TableColumn(data.get(0).getOfficialsColumnName());
		TableColumn professionalsCol = new TableColumn(data.get(0).getProfessionalsColumnName());
		TableColumn techniciansCol = new TableColumn(data.get(0).getTechniciansColumnName());
		TableColumn clerksCol = new TableColumn(data.get(0).getClerksColumnName());
		TableColumn serviceWorkersCol = new TableColumn(data.get(0).getServiceWorkersColumnName());
		TableColumn farmersCol = new TableColumn(data.get(0).getFarmersColumnName());
		TableColumn tradesCol = new TableColumn(data.get(0).getTradesColumnName());
		TableColumn operatorsCol = new TableColumn(data.get(0).getOperatorsColumnName());
		TableColumn laborersCol = new TableColumn(data.get(0).getLaborersColumnName());
		TableColumn noneCol = new TableColumn(data.get(0).getNoneColumnName());
		TableColumn noAnswerCol = new TableColumn(data.get(0).getNoAnswerColumnName());
		
		table.getColumns().addAll(regionCol, totalCol, specialWorkersCol, officialsCol, professionalsCol, techniciansCol, clerksCol, serviceWorkersCol, farmersCol, tradesCol, operatorsCol, laborersCol, noneCol, noAnswerCol );
		
		for(int i = 0; i < values.size(); i++){
			System.out.println(values.get(i).toString());
		}
	
		System.out.println(values.size());
		
		return table;
	}
	
	public Scene changeScene(Scene[] scene, int counter){
		if(scene.length - 1 == counter){
			return scene[0];
		}
		return scene[counter + 1];
	}
	
}
