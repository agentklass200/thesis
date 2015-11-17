import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;
import struct.Node;
import javafx.stage.FileChooser;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage; 

import java.util.List;
import java.io.*;
import java.util.ArrayList;

import CSVProcess.CSVProcessing;
import CSVProcess.CSVListProcessing;
import CSVProcess.CSVRow;
import CSVProcess.CSVTable;
import CSVProcess.CSVColumn;
import CSVProcess.InfoBean;
import data.Corpus;
import data.Sort;
import data.determiner;
import data.tableObject;
import incremental.initializeTree;
import incremental.nodeObject;
import incremental.treeTraversal;

import simplenlg.framework.*;
import simplenlg.lexicon.*;
import simplenlg.realiser.english.*;
import simplenlg.phrasespec.*;
import java.util.Arrays;
import simplenlg.features.*;

import user.Config;



public class main extends Application{
	
	Button getCSVFile, next, prev, saveToText, newSession;
	
	boolean isTextGenerated = false;
	boolean isTreeViewGenerated = false;
	Config user = new Config();
	
	Lexicon lexicon = Lexicon.getDefaultLexicon();
    NLGFactory nlgFactory = new NLGFactory(lexicon);
    Realiser realiser = new Realiser(lexicon);
	TreeView<String> treeView;
	HBox buttonContainer;	
	
	Stage window, saveStage;
	Scene scene[], activeScene;
	File activeFile;
	public static ArrayList<InfoBean> data;
	public List<InfoBean> list;
	public int sceneNo = 0;
	private Text actionStatus;
	TextArea output;
	TreeView<String> tree;
	
	String outputString = "";
	
	ArrayList<InfoBean> topPopulation =  new ArrayList<InfoBean>();
	ArrayList<InfoBean> topNone = new ArrayList<InfoBean>();
	
	public CSVTable csvData;
	
	
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
		
		Scene scene[] = new Scene[4];
		
		
		scene[0] = new Scene(layout, 700, 500);
		activeScene = scene[sceneNo];
		activeScene.getStylesheets().add("style.css");
		
		//Layout Scene 2
				
		VBox layout1 = new VBox();
		VBox layout2 = new VBox();
		VBox layout3 = new VBox();
				
		scene[1] = new Scene(layout1, 700, 500);
		scene[2] = new Scene(layout3, 700, 500);
		scene[3] = new Scene(layout2, 700, 500);
		
		prev = new Button("Previous");
		
		saveToText = new Button("Save to Text File");
		
		newSession = new Button("New");
		
		buttonContainer = new HBox();
				
		//Initializing Stage Hello World!
		
		//MODE TOGGLE
		
		final ToggleGroup modeSelectGroup = new ToggleGroup();
		
		RadioButton haho = new RadioButton("Highest Area | Highest Occupation");
		haho.setToggleGroup(modeSelectGroup);
		haho.setUserData(Config.HIGHEST_AREA_HIGHEST_OCCU);
		haho.setSelected(true);
		RadioButton halo = new RadioButton("Highest Area | Lowest Occupation");
		halo.setToggleGroup(modeSelectGroup);
		halo.setUserData(Config.HIGHEST_AREA_LOWEST_OCCU);
		RadioButton laho = new RadioButton("Lowest Area | Highest Occupation");
		laho.setToggleGroup(modeSelectGroup);
		laho.setUserData(Config.LOWEST_AREA_HIGHEST_OCCU);
		RadioButton lalo = new RadioButton("Lowest Area | Lowest Occupation");
		lalo.setToggleGroup(modeSelectGroup);
		lalo.setUserData(Config.LOWEST_AREA_LOWEST_OCCU);
		
		modeSelectGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
		      public void changed(ObservableValue<? extends Toggle> ov,
		          Toggle old_toggle, Toggle new_toggle) {
		        if (modeSelectGroup.getSelectedToggle() != null) {
		          user.setModeVariants(Integer.parseInt(modeSelectGroup.getSelectedToggle().getUserData().toString()));
		          System.out.println(user.getModeVariants());
		        }
		      }
		 });
		
		VBox radioVBox = new VBox();
		HBox radioHBox = new HBox();
		
		radioVBox.getChildren().addAll(haho,halo,laho,lalo);
		radioVBox.setSpacing(10);
		
		radioHBox.getChildren().add(radioVBox);
		radioHBox.setSpacing(50);
		radioHBox.setPadding(new Insets(20, 10, 10, 20));
		radioHBox.setAlignment(Pos.CENTER);
		
		window.setScene(activeScene);
		window.show();
		
		getCSVFile.setOnAction(e -> {
			File CSVFile = CSVFileChooser.showOpenDialog(primaryStage);
				if (CSVFile != null){
					CSVFileLocation.setText(CSVFile.getAbsolutePath());
					activeFile = CSVFile;
					
					layout.getChildren().add(radioHBox);
					
					layout.getChildren().add(npContainer);
					
					
					
				}
				else{
					System.out.println("Nah!");
				}
		});
		
		saveToText.setOnAction(e -> {
			FileChooser fileLocation = new FileChooser();
			fileLocation.setTitle("Save Text File");
			fileLocation.setInitialFileName("text-description.txt");
			File savedFile = fileLocation.showSaveDialog(saveStage);
			
			if (savedFile != null) {

				try {
					saveFileRoutine(savedFile);
				}
				catch(IOException e1) {
				
					e1.printStackTrace();
					return;
				}
			}
			
		});
		
		prev.setOnAction(e -> {
			activeScene = prevScene(scene, sceneNo);
			sceneNo = sceneNo - 1;
			window.setScene(activeScene);
			
			
			if(sceneNo == 1){
				layout1.getChildren().remove(2);
				buttonContainer = new HBox();
				buttonContainer.setSpacing(50);					
				buttonContainer.getChildren().add(next);
				buttonContainer.setAlignment(Pos.CENTER);
				layout1.getChildren().add(buttonContainer);
			}
			else if(sceneNo == 2){
				layout3.getChildren().remove(2);
				buttonContainer = new HBox();
				buttonContainer.setSpacing(50);	
				buttonContainer.getChildren().add(prev);
				buttonContainer.getChildren().add(next);
				buttonContainer.setAlignment(Pos.CENTER);
				layout3.getChildren().add(buttonContainer);
			}
			else if(sceneNo == 3){
				layout2.getChildren().remove(1);
				buttonContainer = new HBox();
				buttonContainer.setSpacing(50);			
				buttonContainer.getChildren().add(prev);
				buttonContainer.getChildren().add(next);
				layout2.getChildren().add(buttonContainer);
			}
			
			buttonContainer.setPadding(new Insets(20, 10, 10, 20));
			
			
		});
		
		newSession.setOnAction(e -> {
			activeScene = toNewScene(scene, sceneNo);
			sceneNo = 0;
			window.setScene(activeScene);
			layout.getChildren().remove(radioHBox);
		});
		
		
		
		next.setOnAction(e -> {
			activeScene = nextScene(scene, sceneNo);
			sceneNo = sceneNo + 1;
			window.setScene(activeScene);
			activeScene.getStylesheets().add("style.css");
			ArrayList<CSVRow> rowData = new ArrayList<CSVRow>(); 
			if(sceneNo == 1){
				Label sn1 = new Label("Text Planning");
				Image algoImage1 = new Image("2a.png");
				ImageView iv1 = new ImageView();
				iv1.setImage(algoImage1);
				iv1.autosize();
				iv1.setFitHeight(300);
				VBox ic1 = new VBox();
				ic1.setAlignment(Pos.CENTER);
				ic1.getChildren().add(iv1);
				ic1.setPadding(new Insets(0, 5, 0, 5));
				HBox centerView1 = new HBox();
				
				data = new ArrayList<InfoBean>();
				try {
					rowData = CSVListProcessing.readCSV(activeFile.getAbsolutePath());
					data = CSVProcessing.readCSV(activeFile.getAbsolutePath(), data);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				csvData = new CSVTable(rowData);
				layout1.setAlignment(Pos.CENTER);
				layout1.getChildren().add(sn1);
				layout1.getChildren().add(centerView1);
				centerView1.getChildren().add(ic1);
				centerView1.getChildren().add(this.createTableView(data));
				buttonContainer = new HBox();
				buttonContainer.setSpacing(50);					
				buttonContainer.getChildren().add(next);
				buttonContainer.setAlignment(Pos.CENTER);
				buttonContainer.setPadding(new Insets(20, 10, 10, 20));
				
				layout1.getChildren().add(buttonContainer);
				
				this.loadTree(this.data, this.user);
				
			}
			else if(sceneNo == 2){
				if(!isTreeViewGenerated){
					Label sn2 = new Label("Sentence Planning and Linguistic Realization");
					Image algoImage2 = new Image("3a.png");
					ImageView iv2 = new ImageView();
					iv2.setImage(algoImage2);
					iv2.autosize();
					iv2.setFitHeight(300);
					VBox ic2 = new VBox();
					ic2.setAlignment(Pos.CENTER);
					ic2.getChildren().add(iv2);
					ic2.setPadding(new Insets(0, 5, 0, 5));
					HBox centerView2 = new HBox();
					centerView2.setAlignment(Pos.CENTER);
					
					VBox bc =  new VBox();

					StackPane treeViewContainer = new StackPane();
					
					
					determiner values = new determiner(data, user);
					TreeItem<String> root, regionBranch, noOccupationBranch, areaBranch;
					//Root
					
					root = new TreeItem<>();
					root.setExpanded(true);
					
					//Region
					regionBranch = makeBranch("Name of Region: " + values.getMajorRegion().getRegion() , root);
					makeBranch("1st Occupation: " + values.getMajorOccupation().get(0).getObjectName(), regionBranch);
					makeBranch("2nd Occupation: " + values.getMajorOccupation().get(1).getObjectName(), regionBranch);
					
					// No Occupation Branch
					noOccupationBranch = makeBranch("No Occupation: " + values.getMajorRegion().getRegion(), root);
					makeBranch("1st No Occupation Area: " + values.getNoOccupationList().get(0).getRegion(), noOccupationBranch);
					makeBranch("2nd No Occupation Area: " + values.getNoOccupationList().get(1).getRegion(), noOccupationBranch);
					makeBranch("3rd No Occupation Area: " + values.getNoOccupationList().get(2).getRegion(), noOccupationBranch);
					makeBranch("4th No Occupation Area: " + values.getNoOccupationList().get(3).getRegion(), noOccupationBranch);
					makeBranch("5th No Occupation Area: " + values.getNoOccupationList().get(4).getRegion(), noOccupationBranch);
					
					//Highest Area Branch
					if(user.getModeVariants() == Config.HIGHEST_AREA_HIGHEST_OCCU ||  user.getModeVariants() ==  Config.HIGHEST_AREA_LOWEST_OCCU){
						areaBranch = makeBranch("Highest area : " + values.getOccupationList().get(0).getRegion(), root);	
					}
					else{
						areaBranch = makeBranch("Lowest area : " + values.getOccupationList().get(0).getRegion(), root);
					}
					makeBranch("1st Occupation: " + values.getTopOccupation().get(0).getObjectName(), areaBranch);
					makeBranch("2nd Occupation: " + values.getTopOccupation().get(1).getObjectName(), areaBranch);
					makeBranch("3rd Occupation: " + values.getTopOccupation().get(2).getObjectName(), areaBranch);
					
					//Tree
					treeView = new TreeView<String>(root);
					treeView.setShowRoot(false);
					
					buttonContainer = new HBox();
					buttonContainer.setSpacing(50);					
					buttonContainer.getChildren().add(prev);
					buttonContainer.getChildren().add(next);
					buttonContainer.setAlignment(Pos.CENTER);
					buttonContainer.setPadding(new Insets(20, 10, 10, 20));
					
					
					
					treeViewContainer.getChildren().add(treeView);
					
					centerView2.getChildren().add(iv2);
					treeView.setMinWidth(500);
					bc.getChildren().add(treeView);
					centerView2.getChildren().add(bc);
					layout3.setAlignment(Pos.CENTER);
					layout3.getChildren().add(sn2);
					layout3.getChildren().add(centerView2);
					layout3.getChildren().add(buttonContainer);
				}
				else{
					layout3.getChildren().remove(2);
					buttonContainer = new HBox();
					buttonContainer.setSpacing(50);		
					buttonContainer.getChildren().add(prev);
					buttonContainer.getChildren().add(next);
					buttonContainer.setAlignment(Pos.CENTER);
					buttonContainer.setPadding(new Insets(20, 10, 10, 20));
					layout3.getChildren().add(buttonContainer);
				}
				isTreeViewGenerated = true;
			}
			else if(sceneNo == 3){
				if(!isTextGenerated){
					Image algoImage3 = new Image("4a.png");
					ImageView iv3 = new ImageView();
					iv3.setImage(algoImage3);
					iv3.autosize();
					iv3.setFitHeight(300);
					VBox ic3 = new VBox();
					ic3.setAlignment(Pos.CENTER);
					ic3.getChildren().add(iv3);
					ic3.setPadding(new Insets(0, 5, 0, 5));
					HBox centerView3 = new HBox();
					output = new TextArea();
					output.setMinWidth(300);
					output.setMaxWidth(600);
					output.setPrefHeight(400);
					output.setWrapText(true);
					output.setText(outputString);
					output.setEditable(false);
					Label modeLabel = new Label();
					modeLabel.setText("Output Description - "+ user.getMode());
					centerView3.getChildren().add(ic3);
					centerView3.getChildren().add(output);
					layout2.setAlignment(Pos.CENTER);
					layout2.getChildren().add(modeLabel);
					layout2.getChildren().add(centerView3);
					buttonContainer = new HBox();
					buttonContainer.setSpacing(50);					
					buttonContainer.getChildren().add(prev);
					buttonContainer.getChildren().add(saveToText);
					buttonContainer.setAlignment(Pos.CENTER);
					buttonContainer.setPadding(new Insets(20, 10, 10, 20));
					layout2.getChildren().add(buttonContainer);
				}
				else{
					layout2.getChildren().remove(2);
					buttonContainer = new HBox();
					buttonContainer.setSpacing(50);					
					buttonContainer.getChildren().add(prev);
					buttonContainer.getChildren().add(saveToText);
					buttonContainer.setAlignment(Pos.CENTER);
					buttonContainer.setPadding(new Insets(20, 10, 10, 20));
					layout2.getChildren().add(buttonContainer);
				}
				isTextGenerated = true;
			}
			
		});
	}
	
	public static TreeItem<String> makeBranch(String title, TreeItem<String> parent){
		TreeItem<String> item = new TreeItem<String>(title);
		item.setExpanded(true);
		parent.getChildren().add(item);
		return item;
	}
	
	public static ArrayList<InfoBean> cloneArrayList(ArrayList<InfoBean> list){
		ArrayList<InfoBean> clone = new ArrayList<InfoBean>();
		for(InfoBean newList: list){
			InfoBean a = new InfoBean();
			a = newList.clone();
			clone.add(a);
		}
		return clone;
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

		
		return table;
	}
	
	private void saveFileRoutine(File file)
			throws IOException{
		// Creates a new file and writes the txtArea contents into it
		String txt = this.output.getText();
		file.createNewFile();
		FileWriter writer = new FileWriter(file);
		writer.write(txt);
		writer.close();
	}
	
	public Scene nextScene(Scene[] scene, int counter){
		if(scene.length - 1 == counter){
			return scene[0];
		}
		return scene[counter + 1];
	}
	
	public Scene prevScene(Scene[] scene, int counter){
		if(0 == counter){
			return scene[scene.length - 1];
		}
		return scene[counter - 1];
	}
	
	public Scene toNewScene(Scene[] scene, int counter){
		return scene[0];
	}
	
	
	
	public void loadTree(ArrayList<InfoBean> data, Config user){
		initializeTree loader = new initializeTree(data, user);
		ArrayList<Node<nodeObject>> traversalList;
		traversalList = loader.getList();
		ArrayList<DocumentElement> doElement = new ArrayList<DocumentElement>();
		for(int i = 0; i < traversalList.size(); i++){
			if(traversalList.get(i).getData().getValue() != null){
				doElement.add(nlgFactory.createSentence(traversalList.get(i).getData().getValue().toString()));
				outputString = outputString + traversalList.get(i).getData().getValue();
			}
		}
		DocumentElement par1 = nlgFactory.createParagraph(doElement);
		
		realiser.realise(par1).getRealisation();
		
	}

	
}
