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
	
	//BLABLABLA
	
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
		
		for (int i = 0 ; i < values.size(); i++){
			values.get(0).populateView();
		}
		
		TableColumn<InfoBean, String> regionCol = new TableColumn<InfoBean, String>(data.get(0).getRegionColumnName());
		regionCol.setMinWidth(50);
		regionCol.setCellValueFactory(new PropertyValueFactory<InfoBean, String>("region"));
		
		TableColumn<InfoBean, Integer> totalCol = new TableColumn<InfoBean, Integer>(data.get(0).getTotalColumnName());
		totalCol.setMinWidth(50);
		totalCol.setCellValueFactory(new PropertyValueFactory<InfoBean, Integer>("total"));

		TableColumn<InfoBean, Integer> specialOccupationCol = new TableColumn<InfoBean, Integer>(data.get(0).getSpecialOccupationColumnName());
		specialOccupationCol.setMinWidth(50);
		specialOccupationCol.setCellValueFactory(new PropertyValueFactory<InfoBean, Integer>("specialOccupation"));

		TableColumn<InfoBean, Integer> officialsCol = new TableColumn<InfoBean, Integer>(data.get(0).getOfficialsColumnName());
		officialsCol.setMinWidth(50);
		officialsCol.setCellValueFactory(new PropertyValueFactory<InfoBean, Integer>("officials"));

		TableColumn<InfoBean, Integer> professionalsCol = new TableColumn<InfoBean, Integer>(data.get(0).getProfessionalsColumnName());
		professionalsCol.setMinWidth(50);
		professionalsCol.setCellValueFactory(new PropertyValueFactory<InfoBean, Integer>("professionals"));

		TableColumn<InfoBean, Integer> techniciansCol = new TableColumn<InfoBean, Integer>(data.get(0).getTechniciansColumnName());
		techniciansCol.setMinWidth(50);
		techniciansCol.setCellValueFactory(new PropertyValueFactory<InfoBean, Integer>("technicians"));

		TableColumn<InfoBean, Integer> clerksCol = new TableColumn<InfoBean, Integer>(data.get(0).getClerksColumnName());
		clerksCol.setMinWidth(50);
		clerksCol.setCellValueFactory(new PropertyValueFactory<InfoBean, Integer>("clerks"));

		TableColumn<InfoBean, Integer> serviceWorkersCol = new TableColumn<InfoBean, Integer>(data.get(0).getServiceWorkersColumnName());
		serviceWorkersCol.setMinWidth(50);
		serviceWorkersCol.setCellValueFactory(new PropertyValueFactory<InfoBean, Integer>("ServiceWorkers"));

		TableColumn<InfoBean, Integer> farmersCol = new TableColumn<InfoBean, Integer>(data.get(0).getFarmersColumnName());
		farmersCol.setMinWidth(50);
		farmersCol.setCellValueFactory(new PropertyValueFactory<InfoBean, Integer>("farmers"));

		TableColumn<InfoBean, Integer> tradesCol = new TableColumn<InfoBean, Integer>(data.get(0).getTradesColumnName());
		tradesCol.setMinWidth(50);
		tradesCol.setCellValueFactory(new PropertyValueFactory<InfoBean, Integer>("trades"));

		TableColumn<InfoBean, Integer> operatorsCol = new TableColumn<InfoBean, Integer>(data.get(0).getOperatorsColumnName());
		operatorsCol.setMinWidth(50);
		operatorsCol.setCellValueFactory(new PropertyValueFactory<InfoBean, Integer>("operators"));

		TableColumn<InfoBean, Integer> laborersCol = new TableColumn<InfoBean, Integer>(data.get(0).getLaborersColumnName());
		laborersCol.setMinWidth(50);
		laborersCol.setCellValueFactory(new PropertyValueFactory<InfoBean, Integer>("laborers"));

		TableColumn<InfoBean, Integer> noneCol = new TableColumn<InfoBean, Integer>(data.get(0).getNoneColumnName());
		noneCol.setMinWidth(50);
		noneCol.setCellValueFactory(new PropertyValueFactory<InfoBean, Integer>("none"));

		TableColumn<InfoBean, Integer> noAnswerCol = new TableColumn<InfoBean, Integer>(data.get(0).getNoAnswerColumnName());
		noAnswerCol.setMinWidth(50);
		noAnswerCol.setCellValueFactory(new PropertyValueFactory<InfoBean, Integer>("noAnswer"));
		
		table.getColumns().addAll(regionCol, totalCol, specialOccupationCol, officialsCol, professionalsCol, techniciansCol, clerksCol, serviceWorkersCol, farmersCol, tradesCol, operatorsCol, laborersCol, noneCol, noAnswerCol );
		
		table.setItems(values);
		
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
