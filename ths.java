package gui.wizard;  

import org.eclipse.jface.wizard.WizardDialog; 
import org.eclipse.swt.events.ShellAdapter; 
import org.eclipse.swt.events.ShellEvent; 
import org.eclipse.swt.widgets.Display; 
import org.eclipse.swt.widgets.Shell;  

public class WizardGUI extends Shell {  
public WizardGUI() {   
setText("Table Describer Wizard");  }  
protected Shell shell;  
 /**   * Launch the application.   * @param args   */  

 public static void main(String[] args) {   
 try {    
 WizardGUI window = new WizardGUI();    
 window.open();   } 
 catch (Exception e) {    
 e.printStackTrace();   }  }  
 /**   * Open the window.   */  
 public void open() {   
 Display display = Display.getDefault();   
 createContents();   
 shell.open(); 
 //  shell.layout();   
 while (!shell.isDisposed()) {    
 if (!display.readAndDispatch()) {     
 display.sleep();    
 }   
 }  
 }  
 /**   * Create contents of the window.   */  
 protected void createContents() {   
 shell = new Shell();   
 shell.addShellListener(new ShellAdapter() {    
 @Override 
   public void shellActivated(ShellEvent e) {     
   shell.dispose();     
   WizardDialog wizardDialog = new WizardDialog(shell, new Wizard());     wizardDialog.open();    
   }   
   });  
   }  
 @Override  
 protected void checkSubclass() {   
 // Disable the check that prevents subclassing of SWT components  }  
}   

package gui.wizard;   
public class Wizard extends org.eclipse.jface.wizard.Wizard {  
 protected Page1 page1;  
 protected Page2 page2;  
 protected Page3 page3;  
 protected Page4 page4;  
 protected Page5 page5;    
 public Wizard() {   
 setWindowTitle("Table Describer Wizard");  }  
 @Override  
 public void addPages() {   
 page1 = new Page1();   
 page2 = new Page2();   
 page3 = new Page3();   
 page4 = new Page4();   
 page5 = new Page5();      
 addPage(page1);   
 addPage(page2);   
 addPage(page3);   
 addPage(page4);   
 addPage(page5);  
 }  
 @Override  
 public boolean performFinish() {   
 if(page1.isPageComplete() && page2.isPageComplete()     && page3.isPageComplete() && page4.isPageComplete() 
     && page5.isPageComplete() && page5.isVisible())   return true;   
     else return false;  }  
 @Override  
 public boolean canFinish() {   
 if(page5.isVisible())    return super.canFinish();   
 else return false;  }   
 }   
package dataanalysis;  
/**  * TABLE  *  */ 
public class RawTable {    
String region;  
int total, specialOccupation, officials, professionals;  
int technicians, clerks, serviceWorkers, farmers, trades;  
int operators, laborers, none, noAnswer;  
TableRow tableRow = new TableRow();    
public TableRow getTableRow() {   
return tableRow;  
}    
public String getRegion() {   
return region;  
}    
public int getTotal() {   
return total;  
}    
public int getSpecialOccupation() {   
return specialOccupation;  
}    
public int getOfficials() {   
return officials;  
}    
public int getProfessionals() {   
return professionals;  
}    
public int getTechnicians() {   
return technicians;  
}    
public int getClerks() {   
return clerks;  
}    
public int getServiceWorkers() { 
  return serviceWorkers;  
  }    
  public int getFarmers() {   
  return farmers;  
  }    
  public int getTrades() {   
  return trades;  
  }    
  public int getOperators() {   
  return operators;  
  }    
  public int getLaborers() {   
  return laborers;  
  }    
  public int getNone() {   
  return none;  
  }    
  public int getNoAnswer() {   
  return noAnswer;  
  }    
  public void setRegion(String region) {   
  this.region = region;  
 tableRow.setRegion(region);  
 }    
 public void setTotal(int total) {   
 this.total = total;   
 tableRow.setTotal(total);   
 TableColumn tableColumn = new TableColumn("total", region, total, total);  
 tableRow.setSumTotal(tableColumn) ;  
 }    
 public void setSpecialOccupation(int specialOccupation) {   
 this.specialOccupation = specialOccupation;   
 TableColumn tableColumn = new TableColumn("workers with special occupation", region, specialOccupation, total);  
 tableRow.setSpecialOccupation(tab leColumn);  
 }    
 public void setOfficials(int officials) {   this.officials = officials;   TableColumn tableColumn = new TableColumn("gov't and special interest organization officials", region, officials, total);  
 tableRow.setOfficials(tableColumn ); 
}    
public void setProfessionals(int professionals) {   this.professionals = professionals;   
TableColumn tableColumn = new TableColumn("professionals", region, professionals, total);  
 tableRow.setProfessionals(tableCo lumn);  
 }    
 public void setTechnicians(int technicians) {   
 this.technicians = technicians;   TableColumn tableColumn = new TableColumn("technicians and associate professionals", region, technicians, total);  
 tableRow.setTechnicians(tableColu mn);  
 }    
 public void setClerks(int clerks) {   
 this.clerks = clerks;   
 TableColumn tableColumn = new TableColumn("clerks", region, clerks, total);  
 tableRow.setClerks(tableColumn);  
 }    
 public void setServiceWorkers(int serviceWorkers) {   
 this.serviceWorkers = serviceWorkers;   
 TableColumn tableColumn = new TableColumn("service workers and shops and market sales workers", region, serviceWorkers, total);  
 tableRow.setServiceWorkers(tableC olumn);  
 }    
 public void setFarmers(int farmers) {   
 this.farmers = farmers;   
 TableColumn tableColumn = new TableColumn("farmers, forestry workers and fishermen", region, farmers, total);  
 tableRow.setFarmers(tableColumn);  
 }    
 public void setTrades(int trades) {   
 this.trades = trades;   
 TableColumn tableColumn = new TableColumn("trades and related works", region, trades, total);  
 tableRow.setTrades(tableColumn);  } 
   public void setOperators(int operators) {   
   this.operators = operators;   TableColumn tableColumn = new TableColumn("plants and machine operators and assemblers", region, operators, total);  
 tableRow.setOperators(tableColumn );  
 }    
 public void setLaborers(int laborers) {   
 this.laborers = laborers;   
 TableColumn tableColumn = new TableColumn("laborers and unskilled workers", region, laborers, total);  
 tableRow.setLaborers(tableColumn) ;  
 }    
 public void setNone(int none) {   
 this.none = none;   
 TableColumn tableColumn = new TableColumn("none", region, none, total);  
 tableRow.setNone(tableColumn);  
 }    
 public void setNoAnswer(int noAnswer) {   
 this.noAnswer = noAnswer;   
 TableColumn tableColumn = new TableColumn("no answer", region, noAnswer, total);  
 tableRow.setNoAnswer(tableColumn) ;  
 }  
}   
package dataanalysis;  
import java.text.DecimalFormat; 
import java.text.DecimalFormatSymbols;  
public class TableColumn extends Object{  
 String columnName, region;  double value, total;  
 double percentage;    
 public TableColumn(String columnName, String region, int value, int total) {   
 this.columnName = columnName;   
 this.value = value;   
 this.total = total;   
 this.region = region;   
 computePercentage();  }   
public void computePercentage() {   
percentage = (value/total)*100;  
}    
public double getPercentage() {   
return (double)Math.round(percentage*100)/100;  
}    
public String getColumnName() {   
return columnName;  
}    
public double getValue() {   
return value;  
}    
public double getTotal() {   
return total;  
}    
public String getRegion() {   
return region;  
}    
public String getValueFormat() {   
DecimalFormat valueFormat = new DecimalFormat();   
DecimalFormatSymbols dfs = new DecimalFormatSymbols();  
 dfs.setGroupingSeparator(',');  
 valueFormat.setDecimalFormatSymbo ls(dfs);   
 return valueFormat.format((int)value);  
 }   
 }   
package dataanalysis;  
import java.io.FileReader; 
import java.util.ArrayList; 
import java.util.List;  
import org.supercsv.cellprocessor.ParseInt; 
import org.supercsv.cellprocessor.ift.CellProces sor; 
import org.supercsv.io.CsvBeanReader; 
import org.supercsv.io.ICsvBeanReader; 
import org.supercsv.prefs.CsvPreference;  
public class TableProcess {    
private String fileInput;  private int tableSize;    
public TableProcess() { }    
public TableProcess(String fileInput) {   
this.fileInput = fileInput;  
} 
   static final CellProcessor[] userProcessors = new CellProcessor[] {   null, new ParseInt(), new ParseInt(), new ParseInt(), new ParseInt(),   new ParseInt(), new ParseInt(), new ParseInt(), new ParseInt(),   new ParseInt(), new ParseInt(), new ParseInt(), new ParseInt(),   new ParseInt(),  };  
 public int getTableSize() {   
 return tableSize;  
 }    
 public List<TableRow> populateTable() throws Exception{   
 ICsvBeanReader inFile = this.getFileInput();   
 final String[] header = new String[] {     "region", "total", "specialOccupation", "officials", "professionals",     "technicians", "clerks", "serviceWorkers", "farmers", "trades",     "operators", "laborers", "none", "noAnswer"};   
 inFile.getCSVHeader(true);   
 RawTable rawTable;   
 List<TableRow> tableRowList = new ArrayList<TableRow>();   
 while( 
 (rawTable = inFile.read(RawTable.class, header, userProcessors)) != null) {    
 tableRowList.add(rawTable.getTabl eRow());   
 }   
 inFile.close();   
 tableSize = tableRowList.size();   
 return tableRowList;  
 }  
 public void setFileInput(String fileInput) {   
 this.fileInput = fileInput;  
 }    
 public ICsvBeanReader getFileInput() throws Exception{   
 ICsvBeanReader inFile = new CsvBeanReader(new FileReader(fileInput), CsvPreference.EXCEL_PREFERENCE);   
 return inFile;  
 }  
 public String[] getTableHeader() throws Exception{   ICsvBeanReader inFile = this.getFileInput(); 
  return inFile.getCSVHeader(true);  
  }  
 public TableRow getTableRow(String region) throws Exception{   
 List<TableRow> list = populateTable();   
 for (TableRow tableRow : list) {    
 if(tableRow.getRegion().equals(re gion)) {     
 return tableRow;    
 }   
 }   
 return null; //if not found  
 }  
 public List<TableColumn> getTableColumns(String occupation) throws Exception{   
 List<TableRow> list = populateTable();   
 List<TableColumn> tableColumns = new ArrayList<TableColumn>();   
 for (TableRow tableRow : list) {    
 if(tableRow.getRegion().equals("U rban Area") || tableRow.getRegion().equals("Rural Area")      || tableRow.getTotal()==sortTotal()[list.siz e()-1].getTotal())     continue;    if(tableRow.getSpecialOccupation( ).getColumnName().equals(occupation))     tableColumns.add(tableRow.getSpec ialOccupation());    else if(tableRow.getOfficials().getColumnName( ).equals(occupation))     tableColumns.add(tableRow.getOffi cials());    else if(tableRow.getProfessionals().getColumnN ame().equals(occupation))     tableColumns.add(tableRow.getProf essionals());    else if(tableRow.getTechnicians().getColumnNam e().equals(occupation))     tableColumns.add(tableRow.getTech nicians());    
 else if(tableRow.getClerks().getColumnName().e quals(occupation))     tableColumns.add(tableRow.getCler ks()); 
   else if(tableRow.getServiceWorkers().getColumn Name().equals(occupation))     tableColumns.add(tableRow.getServ iceWorkers());    
   else if(tableRow.getFarmers().getColumnName(). equals(occupation))     tableColumns.add(tableRow.getFarm ers());    
   else if(tableRow.getTrades().getColumnName().e quals(occupation))     tableColumns.add(tableRow.getTrad es());    
   else if(tableRow.getOperators().getColumnName( ).equals(occupation))     tableColumns.add(tableRow.getOper ators());    
   else if(tableRow.getLaborers().getColumnName() .equals(occupation))     tableColumns.add(tableRow.getLabo rers());    
   else if(tableRow.getNone().getColumnName().equ als(occupation))     tableColumns.add(tableRow.getNone ());    
   else if(tableRow.getNoAnswer().getColumnName() .equals(occupation))     tableColumns.add(tableRow.getNoAn swer());   
   }   
   return tableColumns;  
   }    
   public TableColumn[] sortRow(TableRow tableRow) throws Exception {   
  TableColumn[] tableColumn = new TableColumn[12];  
  tableColumn[0] = tableRow.getSpecialOccupation();   
  tableColumn[1] = tableRow.getOfficials();   
  tableColumn[2] = tableRow.getProfessionals();   
  tableColumn[3] = tableRow.getTechnicians();   
  tableColumn[4] = tableRow.getClerks();   
  tableColumn[5] = tableRow.getServiceWorkers();   
  tableColumn[6] = tableRow.getFarmers();   
  tableColumn[7] = tableRow.getTrades();   
  tableColumn[8] = tableRow.getOperators(); 
  tableColumn[9] = tableRow.getLaborers();   
  tableColumn[10] = tableRow.getNone();   
  tableColumn[11] = tableRow.getNoAnswer();  
  tableColumn = bubbleSort(tableColumn);  
  return tableColumn;  
  }  
 public TableColumn[] sortColumn(List<TableColumn> tableColumns) {   
 TableColumn[] tableCols = new TableColumn[tableColumns.size()];   
 int i = 0;   
 for (TableColumn tableColumn : tableColumns) {    
 tableCols[i] = tableColumn;    
 i++;   
 }      
 tableCols = bubbleSort(tableCols);   
 return tableCols;  
 }    
 private TableColumn[] sortTotal(List<TableColumn> tableColumns) {   
 TableColumn[] tableCols = new TableColumn[tableColumns.size()];   
 int i = 0;   
 for (TableColumn tableColumn : tableColumns) {    
 tableCols[i] = tableColumn;    
 i++;   
 }      
 tableCols = sort(tableCols);   
 return tableCols;  
 }    
 public TableColumn[] sortTotal() throws Exception{   
 List<TableRow> list = populateTable();   
 List<TableColumn> tableColumns = new ArrayList<TableColumn>();   
 for (TableRow tableRow : list) {    
 tableColumns.add(tableRow.getSumT otal());   
 }   
 return sortTotal(tableColumns);  
 }  
 private TableColumn[] bubbleSort(TableColumn[] arr) {   
 boolean swapped = true;   
 int j = 0; 
  TableColumn tmp;   
  while (swapped) {   
   swapped = false;    
   j++;    
  for (int i = 0; i < arr.length - j; i++) {                                            
  if (arr[i].getPercentage() > arr[i + 1].getPercentage()) {                                
  tmp = arr[i];      
  arr[i] = arr[i + 1];      
  arr[i + 1] = tmp;      
  swapped = true;     
  }    
  }                   
  }   
  return arr;  
  }    
  private TableColumn[] sort(TableColumn[] arr) {   
  boolean swapped = true;   
  int j = 0;   
  TableColumn tmp;   
  while (swapped) {    
  swapped = false;    
  j++;    
  for (int i = 0; i < arr.length - j; i++) {                                            
  if (arr[i].getValue() > arr[i + 1].getValue()) {                                
  tmp = arr[i];      
  arr[i] = arr[i + 1];      
  arr[i + 1] = tmp;      
  swapped = true;     
  }    
  }                   
  }   
  return arr;  
  }  
}   
package dataanalysis;  
public class TableRow {    
String region;  
int total;  
TableColumn sumTotal;  
TableColumn specialOccupation, officials, professionals;  
TableColumn technicians, clerks, serviceWorkers, farmers, trades;  TableColumn operators, laborers, none, noAnswer;    
public void setSumTotal(TableColumn sumTotal) {   
this.sumTotal = sumTotal; 
 }    
public TableColumn getSumTotal() {   
return sumTotal;  
 }    
public String toString(){   
return region;  
}    
public String getRegion() {   
return region;  
}    
public int getTotal() {   
return total;  
}    
public TableColumn getSpecialOccupation() {   
return specialOccupation;  
}    
public TableColumn getOfficials() {   
return officials;  
}    
public TableColumn getProfessionals() {   
return professionals;  
}    
public TableColumn getTechnicians() {   
return technicians;  
}    
public TableColumn getClerks() {   
return clerks;  
}    
public TableColumn getServiceWorkers() {   
return serviceWorkers;  
}    
public TableColumn getFarmers() {   
return farmers;  
}    
public TableColumn getTrades() {   
return trades;  
}    
public TableColumn getOperators() {   
return operators;  
}    
public TableColumn getLaborers() {   
return laborers;  
}    
public TableColumn getNone() {   
return none;  
}   
public TableColumn getNoAnswer() {   
return noAnswer;  
}    
public void setRegion(String region) {   
this.region = region;  
}    
public void setTotal(int total) {   
this.total = total;  
}    
public void setSpecialOccupation(TableColumn specialOccupation) {   
this.specialOccupation = specialOccupation;  
}    
public void setOfficials(TableColumn officials) {   
this.officials = officials;  
}    
public void setProfessionals(TableColumn professionals) {   
this.professionals = professionals;  
}    
public void setTechnicians(TableColumn technicians) {   
this.technicians = technicians;  
}    
public void setClerks(TableColumn clerks) {   
this.clerks = clerks;  
}    
public void setServiceWorkers(TableColumn serviceWorkers) {   
this.serviceWorkers = serviceWorkers;  
}    
public void setFarmers(TableColumn farmers) {   
this.farmers = farmers;  
}    
public void setTrades(TableColumn trades) {   
this.trades = trades;  
}    
public void setOperators(TableColumn operators) {   
this.operators = operators;  
}    
public void setLaborers(TableColumn laborers) { 
  this.laborers = laborers;  
}    
public void setNone(TableColumn none) {   
this.none = none;  
}   
public void setNoAnswer(TableColumn noAnswer) {   
this.noAnswer = noAnswer;  
}  
}   

package documentplan;  
import java.util.List;  
public class ConstituentSet implements DPNode {  
// public static final String SEQUENCE = "sequence"; 
// public static final String EXEMPLIFICATION = "exemplification"; 
// public static final String CONTRAST = "contrast";    
private String relation;  
private DPNode parent;  
private List<DPNode> constituents;    
public ConstituentSet(List<DPNode> constituents){ 
//  
this.relation = relation;   
this.constituents = constituents;  
}  
 public DPNode getParent() {   
 return parent;  
 }    
 public void setParent(DPNode parent) {   
 this.parent = parent;  
 }  
 public String getRelation() {   
 return relation;  
 }  
 public List<DPNode> getConstituents() {   
 return constituents;  
 }    
 public void setConstituents(List<DPNode> constituents) {   
 this.constituents = constituents;  
 }  
 public void setRelation(String relation) { 
  this.relation = relation;  
  }    
  // public String toString(){ 
  //  return("\n Relation = " + this.relation); 
  // } }   

package documentplan;  
import java.util.ArrayList; 
import java.util.List;  
import dataanalysis.TableColumn; 
import dataanalysis.TableProcess; 
import documentplan.messages.HighestOccupationMs g; 
import documentplan.messages.HighestRegionMsg; 
import documentplan.messages.Message; 
import documentplan.messages.NoOccupationMsg;  
public class ContentDeterminer {  
 private List<Message> messageList;  
 private int tableSize;  
 private TableColumn[] tableColumns;    
 public TableColumn[] getTableColumns() {   
 return tableColumns;  }    
 public ContentDeterminer() throws Exception {   
 messageList = new ArrayList<Message>();  
 }    
 public List<Message> determineMessages(String fileInput) throws Exception{   getSortedRows(fileInput);      
 HighestRegionMsg highestRegionMsg = new HighestRegionMsg(null, tableColumns[tableSize-1].getRegion(), 0, fileInput);  
 if(highestRegionMsg.isNoOccupatio n()) {    
 messageList.add(new NoOccupationMsg(null, tableColumns[tableSize-1].getRegion(), fileInput));    
 int num;        
 if(tableSize <= 5) num = tableSize - 2;    else num = 5; 
       for (int i = 0; i < num; i++) {     
       messageList.add(new HighestOccupationMsg(null, "none", i, fileInput));    
       }   
       }  
 messageList.add(highestRegionMsg) ;   
 messageList.add(new HighestRegionMsg(null, tableColumns[tableSize-1].getRegion(), 1, fileInput));   
 for (int i = 0; i < 3; i++) {    
 messageList.add(new HighestRegionMsg(null, tableColumns[tableSize-2].getRegion(), i, fileInput));    
 messageList.add(new HighestRegionMsg(null, tableColumns[tableSize-3].getRegion(), i, fileInput));   
 }  
  return messageList;  }    
  private void getSortedRows(String fileInput) throws Exception {   TableProcess tableProcess = new TableProcess(fileInput);   
  this.tableColumns = tableProcess.sortTotal();   
  this.tableSize = tableColumns.length;  
  }   
  }   

package documentplan;    
public class DocumentPlan implements DPNode {  
 private DPNode children;  
 private DPNode parent;  
 private String title;  
 public DocumentPlan(String title, DPNode parent, DPNode children) {   
 this.parent = parent;   
 this.children = children;   
 this.title = title;  
 }  
 public String getTitle() {   
 return title;  
 }  
 public DPNode getChildren() {   
 return children; 
 }   
 public DPNode getParent() {   
 return parent;  
 }  
 public void setParent(DPNode parent) {   
 this.parent = parent;  
 }  
 public void setChildren(DPNode children) {   
 this.children = children;  
 }  
 public void setTitle(String title) {   
 this.title = title;  
 }    
 public String toString() {   
 String string = "\n Title = " + this.getTitle(); 
 //  for (DPNode dpNodes : children) { 
 //   string = string + dpNodes.toString(); 
 //  }   return string;  
 }    
}   

package documentplan;  
import java.util.ArrayList; 
import java.util.List;  
import dataanalysis.TableColumn; 
import documentplan.messages.HighestOccupationMs g; 
import documentplan.messages.HighestRegionMsg; 
import documentplan.messages.Message; 
import documentplan.messages.NoOccupationMsg;  
public class DocumentStructurer {  
 private List<Message> messages;  
 private TableColumn[] tableColumns;  
 private int tableSize;    
 public DocumentStructurer(List<Message> messages, TableColumn[] tableColumns) {   
 this.messages = messages;   
 this.tableColumns = tableColumns;   
 this.tableSize = tableColumns.length;  
 }    
 private DPNode describePhilippines() { 
  DocumentPlan highest = (DocumentPlan) describeHighestTwo();   DocumentPlan location = (DocumentPlan) describeLocation();   
  DocumentPlan noneph = (DocumentPlan) describeNoOccupationPhil();   DocumentPlan none = (DocumentPlan) describeNoOccupation();   
  DocumentPlan philippines = new DocumentPlan("Highest", null, null);      List<DPNode> constituents = new ArrayList<DPNode>();  
 constituents.add(location);   
 constituents.add(highest);   
 constituents.add(noneph);   
 constituents.add(none);   
 ConstituentSet constituentSet = new ConstituentSet(constituents);  
 constituentSet.setParent(philippi nes);  
 philippines.setChildren(constitue ntSet);      
 return philippines;  
 }    
 private DPNode describeLocation() {   
 List<DPNode> constituents = new ArrayList<DPNode>();   
 for (Message message : messages) {    
 if(message instanceof NoOccupationMsg &&      ((NoOccupationMsg) message).getRegion().equals(tableColumns[ tableSize-1].getRegion())) {     constituents.add(message);
  }   
}   
 ConstituentSet constituentSet = new ConstituentSet(constituents);   
 return new DocumentPlan("Location", null, constituentSet);  
       }    
       private DPNode describeHighestTwo() {   
       List<DPNode> constituents = new ArrayList<DPNode>();   
       for (Message message : messages) {    
       if(message instanceof HighestRegionMsg &&      ((HighestRegionMsg) message).getRegion().equals(tableColumns[ tableSize-1].getRegion())) {     
       constituents.add(message); 
     }   }   
     ConstituentSet constituentSet = new ConstituentSet(constituents);   return new DocumentPlan("Highest two occupation", null, constituentSet);  
     }    
     private DPNode describeNoOccupationPhil() {   
     List<DPNode> constituents = new ArrayList<DPNode>();   
     for (Message message : messages) {    
     if(message instanceof NoOccupationMsg &&      ((NoOccupationMsg) message).getRegion().equals(tableColumns[ tableSize-1].getRegion())) {     
     constituents.add(message);
         }   
         }   
         ConstituentSet constituentSet = new ConstituentSet(constituents);   
         return new DocumentPlan("No occupation", null, constituentSet);  }    
         private DPNode describeNoOccupation() {   
         List<DPNode> constituents = new ArrayList<DPNode>();   
         for (Message message : messages) 
         {    
         if(message instanceof HighestOccupationMsg &&      ((HighestOccupationMsg) message).getColumn().equals("none")) {     constituents.add(message);    
         }   
         }   
         ConstituentSet constituentSet = new ConstituentSet(constituents);   
         return new DocumentPlan("Places with high no occupation", null, constituentSet);  
         }    
         private DPNode describeUrbanRural() {   
         DocumentPlan urban = (DocumentPlan) describeUrban();   DocumentPlan rural = (DocumentPlan) describeRural();   DocumentPlan urbanRural = new DocumentPlan("Highest two places", null, null);      
  List<DPNode> constituents = new ArrayList<DPNode>();   
  constituents.add(urban); 
  constituents.add(rural);   ConstituentSet constituentSet = new ConstituentSet(constituents);  
 constituentSet.setParent(urbanRur al);  
 urbanRural.setChildren(constituen tSet);      
 return urbanRural;  
 }    
 private DPNode describeUrban() {   
 List<DPNode> constituents = new ArrayList<DPNode>();   
 for (Message message : messages) {    
 if(message instanceof HighestRegionMsg &&      ((HighestRegionMsg) message).getRegion().equals(tableColumns[ tableSize-2].getRegion())) {     constituents.add(message);    
 }   
 }   
 ConstituentSet constituentSet = new ConstituentSet(constituents);   
 return new DocumentPlan("Highest number of occupation in area 1", null, constituentSet);  
 }    
 private DPNode describeRural() {   
 List<DPNode> constituents = new ArrayList<DPNode>();   
 for (Message message : messages) {    
 if(message instanceof HighestRegionMsg &&      ((HighestRegionMsg) message).getRegion().equals(tableColumns[ tableSize-3].getRegion())) {     constituents.add(message);    
 }   
 }   
 ConstituentSet constituentSet = new ConstituentSet(constituents);   
 return new DocumentPlan("Highest number of occupation in area 2", null, constituentSet);  
 }    
 private DPNode describeParent() {   
 return new DocumentPlan("Who/Where are the poor households.", null, null);  
 }    
 public DocumentPlan arrangeTree() { 
  DocumentPlan philippines = (DocumentPlan) describePhilippines();   DocumentPlan urbanRural = (DocumentPlan) describeUrbanRural();   DocumentPlan parent = (DocumentPlan) describeParent();         
  List<DPNode> constituents = new ArrayList<DPNode>();  
 constituents.add(philippines);  
 constituents.add(urbanRural);   
 ConstituentSet constituentSet = new ConstituentSet(constituents);  
 constituentSet.setParent(parent);  
 parent.setChildren(constituentSet );   return parent;  
 }   
 }   

package documentplan;  
public interface DPNode {  
 public DPNode getParent();   
 }   
package documentplan.messages;  
import java.util.ArrayList; 
import java.util.List;  
import dataanalysis.TableColumn; 
import dataanalysis.TableProcess; 
import documentplan.DPNode;  
public class HighestOccupationMsg extends Message{    
private String column;  
private int number;  
private TableColumn message;    
public HighestOccupationMsg(DPNode parent, String column, int number, String fileInput) throws Exception{   super(parent);   this.column = column;   this.number = number;   
this.message = createMessage(fileInput);  
}  
 private TableColumn createMessage(String fileInput) throws Exception {   TableProcess tableProcess = new TableProcess(fileInput); 
  TableColumn[] columns = tableProcess.sortColumn(tableProcess.getT ableColumns(column));   
  List<TableColumn> tableColumns = new ArrayList<TableColumn>();   
  for (int i = 0,j=1; i < columns.length; i++,j++) {    
  tableColumns.add(columns[columns. length-j]);   
  } 
  //  System.out.println(number);   
  return tableColumns.get(number);  
  }    
  public TableColumn getMessage() {   
  return message;  
  }    
  public String getColumn() {   
  return column;  
  }    
  public String toString() {   
  return getMessage().getRegion();  
  }
  }   


package documentplan.messages;  
import java.util.ArrayList; 
import java.util.List;  
import dataanalysis.TableColumn; 
import dataanalysis.TableProcess; 
import documentplan.DPNode;  
public class HighestRegionMsg extends Message {  
 private String region;  
 private int number;  
 private boolean noOccupation = false;  
 private TableColumn message;  
 public HighestRegionMsg(DPNode parent, String region, int number, String fileInput) throws Exception{   super(parent);   
 this.region = region;   
 this.number = number;   
 message = createMessage(fileInput);  
 }  
 public TableColumn createMessage(String fileInput) throws Exception {   TableProcess tableProcess = new TableProcess(fileInput);   
 TableColumn[] columns = tableProcess.sortRow(tableProcess.getTabl eRow(region)); 
  List<TableColumn> tableColumns = new ArrayList<TableColumn>();   
  for (int i = 0,j=1; i < number+1; i++,j++) {    
  if(columns[columns.lengthj].getColumnName().equals("none") ||      columns[columns.lengthj].getColumnName().equals("no answer")) {     if(columns[columns.lengthj].getColumnName().equals("none") ){      setNoOccupation(true);
       } 
       //    System.out.println(i +", " + j);     i--;     continue;    }    
       tableColumns.add(columns[columns. length-j]);   
       }   
       return tableColumns.get(number);  
       }  
 public TableColumn getMessage() {   
 return message;  
 }    
 public boolean isNoOccupation() {   
 return noOccupation;  
 }  
 public String getRegion() {   
 return region;  }  
 public void setNoOccupation(boolean noOccupation) {   
 this.noOccupation = noOccupation;  
 }  
 public String toString() {   
 return getMessage().getColumnName();  
 } 
 }   
package documentplan.messages;  
import documentplan.DPNode;  
public abstract class Message implements DPNode{    
private DPNode parent;    
public Message(DPNode parent){   
this.parent = parent;  
}  
 public DPNode getParent() {   
 return parent; 
}  
 public void setParent(DPNode parent) {   
 this.parent = parent;  
 } 
 }   
package documentplan.messages;  
import dataanalysis.TableProcess; 
import dataanalysis.TableRow; 
import documentplan.DPNode;  
public class NoOccupationMsg extends Message{    
private String region;  
private TableRow message;  
 public NoOccupationMsg(DPNode parent, String region, String fileInput) throws Exception{   
 super(parent);   
 this.region = region;   
 this.message = createMessage(fileInput);  
 }    
 private TableRow createMessage(String fileInput) throws Exception {   TableProcess tableProcess = new TableProcess(fileInput);   
 TableRow tableRow = tableProcess.getTableRow(region); 
 //  List<TableColumn> tableColumns = new ArrayList<TableColumn>(); 
 //  for (int i = 0,j=1; i < 10; i++,j++) { 
 //   tableColumns.add(columns[columns. length-j]); 
 //  }   return tableRow;  }    public TableRow getMessage() {   return message;  }    public String getRegion() {   return region;  }    public String toString() {   return getRegion();  }   }   


package microplanning;  
import java.util.List;  
public class Aggregator {  
 public static PPSAbstractSyntax aggregatePreposition(PPSAbstractSyntax main, List<PPSAbstractSyntax> list, String conjunction, String premodifier, String title) {   
 PPSAbstractSyntax syntax = new PPSAbstractSyntax();   
 syntax.setTitle(title);  
 syntax.setHead(conjunction);   
 syntax.setSubject(main);   
 syntax.addModifier(new PSCannedText(premodifier));   
 for (PPSAbstractSyntax ppsAbstractSyntax : list) {    
 syntax.addConjuctions(ppsAbstract Syntax);   
 }   
 return syntax;  
 } 
 }   


package microplanning;   
public class FeatureValue {  
 private String feature;  
 private Object value;      
 public FeatureValue(String feature, Object value) {   
 this.feature = feature;   
 this.value = value;    
 }    
 public String getFeature() {   
 return feature;  
 }    
 public Object getValue() {   
 return value;  
 }    
 public void setFeature(String feature) {   
 this.feature = feature;  
 }    
 public void setValue(Object value) {   
 this.value = value;  
 } 
 }  

package microplanning;  
import java.util.ArrayList; 
import java.util.List;  
import microplanning.phrasespecs.HighestOccupati onPhrase; 
import microplanning.phrasespecs.NoOccupationPhr ase; 
import microplanning.phrasespecs.PrepositionalPh rase; 
import microplanning.phrasespecs.UrbanOrdinalPhr ase; 
import microplanning.phrasespecs.UrbanRuralPhras e; 
import microplanning.phrasespecs.UrbanSecondPhra se; 
import documentplan.ConstituentSet; 
import documentplan.DPNode; 
import documentplan.DocumentPlan; 
import documentplan.messages.HighestOccupationMs g; 
import documentplan.messages.HighestRegionMsg; 
import documentplan.messages.Message; 
import documentplan.messages.NoOccupationMsg;  
public class Lexicalization {    
private List<PPSAbstractSyntax> map = new ArrayList<PPSAbstractSyntax>(); 
// private List<PPSAbstractSyntax> phrase = new ArrayList<PPSAbstractSyntax>();  
private int i = 0;    
public List<PPSAbstractSyntax> traverse(List<DPNode> constituentSets, String parent) {     
 PPSAbstractSyntax ppsAbstractSyntax = new PPSAbstractSyntax();     
 for (DPNode dpNode : constituentSets) {    
 if(!(dpNode instanceof Message)) {  
 //    System.out.println(" -" + ((DocumentPlan)dpNode).getTitle());     
 String title = ((DocumentPlan)dpNode).getTitle();     
 ConstituentSet cons = (ConstituentSet) ((DocumentPlan)dpNode).getChildren();     
 List<DPNode> list = cons.getConstituents();     
 traverse(list, title);    
 }    
 else { 
 //    System.out.println("   -" + dpNode);     
 if((dpNode instanceof HighestRegionMsg && parent.equals("Highest two occupation")) || (dpNode instanceof HighestOccupationMsg && parent.equals("Places with high no occupation"))){      
 PrepositionalPhrase prepositionalPhrase = new PrepositionalPhrase();      
 ppsAbstractSyntax = prepositionalPhrase.lexicalise((Message)d pNode); 
 //     phrase.add(ppsAbstractSyntax); 
 //     i++; 
 //     if(i == constituentSets.size()) {     
  ppsAbstractSyntax.setTitle(parent );      
  map.add(ppsAbstractSyntax); 
  //      i = 0; 
  //     }     
  }          
  else if((dpNode instanceof NoOccupationMsg && parent.equals("Location"))) {      
  HighestOccupationPhrase noOccupationPhrase = new HighestOccupationPhrase();      
  ppsAbstractSyntax = noOccupationPhrase.lexicalise((NoOccupati onMsg)dpNode);      
  ppsAbstractSyntax.setTitle(parent );      
  map.add(ppsAbstractSyntax);     
  }          
  else if((dpNode instanceof NoOccupationMsg && parent.equals("No occupation"))) {      
  NoOccupationPhrase noOccupationPhrase = new NoOccupationPhrase();      
  ppsAbstractSyntax = noOccupationPhrase.lexicalise((NoOccupati onMsg)dpNode);      
  ppsAbstractSyntax.setTitle(parent );      
  map.add(ppsAbstractSyntax);     
  }          
  else if ((dpNode instanceof HighestRegionMsg && parent.equals("Highest number of occupation in area 1")) || (dpNode instanceof HighestRegionMsg && parent.equals("Highest number of occupation in area 2"))) {            
  if(i==0) {       
  UrbanRuralPhrase urbanRuralPhrase = new UrbanRuralPhrase();       
  ppsAbstractSyntax = urbanRuralPhrase.lexicalise((HighestRegio nMsg)dpNode);      
  }      
  if(i==1) {       
  UrbanSecondPhrase urbanSecondPhrase = new UrbanSecondPhrase();       
  ppsAbstractSyntax = urbanSecondPhrase.lexicalise((HighestRegi onMsg)dpNode);      
  }      
  else if (i > 1) {       
  UrbanOrdinalPhrase urbanOrdinalPhrase = new UrbanOrdinalPhrase();       
  ppsAbstractSyntax = urbanOrdinalPhrase.lexicalise((HighestReg ionMsg)dpNode, i);      
  }      
  i+1;      
  ppsAbstractSyntax.setTitle(parent );      
  map.add(ppsAbstractSyntax);            
  if (i == constituentSets.size()) {       
  i = 0;      
  }     
  }              
  }   
  }   
  return map;  
  }    
  public List<PPSAbstractSyntax> getMap() {   
  return map;  
  }   
  }  


package microplanning;  
public abstract class Modifier {  
 public static final String PREPOSITIONALPHRASE = "prepositional_phrase";  public static final String PREMODIFIER = "premodifier";  
 public static final String POSTMODIFIER = "postmodifier";  
 public static final String FRONTMODIFIER = "frontmodifier";  
 public static final String ADJECTIVE = "adjective";  
 public static final String ADVERB = "adverb";  
 public static final String CONJUNCTION = "conjunction";  
 public static final String NOUNPHRASE= "noun_phrase";  
 public static final String FORPHRASE= "for_phrase";   
 }   


package microplanning;   
public abstract class PhraseSpec extends Spec{    
}   
package microplanning;  
import java.util.ArrayList; 
import java.util.List;   
public class PPSAbstractSyntax extends PhraseSpec{   
 private String head;  
 private List<FeatureValue> features;  
 private PhraseSpec subject;  
 private PhraseSpec predicate;  
 private Object object;  
 private PhraseSpec indirectObject;  
 private List<PhraseSpec> modifiers;  
 private List<PhraseSpec> conjunctions;  
 private String title;  
 private String type;  
 private String specifier;    
 public String toString() {   
 return title;  
 }    
 public String getSpecifier() {   
 return specifier;  
 }    
 public void setSpecifier(String specifier) {   
  this.specifier = specifier;  
  }    
  public void setType(String type) {   
  this.type = type;  
  }    
  public String getType() {   
  return type;  
  }    
  public String getTitle() {   
  return title;  
  }    
  public void setTitle(String title) {   
  this.title = title;  
  }    
  public List<PhraseSpec> getConjunctions() {   
  return conjunctions;  
  }    
  public void setConjunctions(List<PhraseSpec> conjuctions) {   
  this.conjunctions = conjuctions;  
  }    
  public void addConjuctions(PhraseSpec phraseSpec) {   
  if(conjunctions == null) {    
  conjunctions = new ArrayList<PhraseSpec>();    
  conjunctions.add(phraseSpec);   
  }   
  else conjunctions.add(phraseSpec);  
  }    
  public String getHead() {   
  return head;  
  }    
  public List<FeatureValue> getFeatures() {   
  return features;  
  }    
  public PhraseSpec getIndirectObject() {   
  return indirectObject;  
  }    
  public void addFeature(FeatureValue featureValue) {   
  if(features == null) {    
  features = new ArrayList<FeatureValue>();    
  features.add(featureValue);   
  }   
  else features.add(featureValue); 
 }    
 public List<PhraseSpec> getModifiers() {   
 return modifiers;  
 }    
 public Object getObject() {   
 return object;  
 }    
 public PhraseSpec getSubject() {   
 return subject;  
 }    
 public PhraseSpec getPredicate() {   
 return predicate;  
 }    
 public void setPredicate(PhraseSpec predicate) {   
 this.predicate = predicate;  
 }    
 public void setHead(String head) {   
 this.head = head;  
 }    
 public void setFeatures(List<FeatureValue> features) {   
 this.features = features;  
 }    
 public void setIndirectObject(PhraseSpec inderectObject) {   
 this.indirectObject = inderectObject;  
 }    
 public void setModifiers(List<PhraseSpec> modifiers) {   
 this.modifiers = modifiers;  
 }    
 public void addModifier(PhraseSpec phraseSpec) {   
 if(this.modifiers == null) {    
 this.modifiers = new ArrayList<PhraseSpec>();    
 modifiers.add(phraseSpec);   
 }   
 else modifiers.add(phraseSpec);  
 }    
 public void setObject(Object object) {   
 this.object = object;  
 }   
 public void setSubject(PhraseSpec subject) {   
 this.subject = subject;  
 }    
 public boolean equals(Object obj) {   
 if (this == obj)    
 return true; 
 //  if (!super.equals(obj)) //   return false;   
 if (getClass() != obj.getClass())    
 return false;   
 PPSAbstractSyntax other = (PPSAbstractSyntax) obj;   
 if (head == null) {    
 if (other.head != null)     
 return false;   
 } 
 else if (!head.equals(other.head))    
 return false;   
 if (features == null) {    
 if (other.features != null)     
 return false;   
 } 
 else if (!features.equals(other.features))    
 return false;   
 if (subject == null) {    
 if (other.subject != null)     
 return false;   
 } 
 else if (!subject.equals(other.subject))    
 return false;   
 if (predicate == null) {    
 if (other.predicate != null)     
 return false;   
 } 
 else if (!predicate.equals(other.predicate))    
 return false;   
 if (object == null) {    
 if (other.object != null)     
 return false;   
 } 
 else if (!object.equals(other.object))    
 return false;   
 if (indirectObject == null) {    
 if (other.indirectObject != null)     
 return false;   
 } 
 else if (!indirectObject.equals(other.indirectObj ect))    
 return false;   
 if (modifiers == null) {    
 if (other.modifiers != null) 
    return false;   
    } 
    else if (!modifiers.equals(other.modifiers))    
    return false;   
    if (conjunctions == null) {    
    if (other.conjunctions != null)     
    return false;   
    } 
    else if (!conjunctions.equals(other.conjunctions) )    
    return false;   
    if (title == null) {    
    if (other.title != null)     
    return false;   
    } 
    else if (!title.equals(other.title))    
    return false;   
    if (type == null) {    
    if (other.type != null)     
    return false;   
    } 
    else if (!type.equals(other.type))    
    return false;   
    if (specifier == null) {    
    if (other.specifier != null)     
    return false;   
    } 
    else if (!specifier.equals(other.specifier))    
    return false;   
    return true;  
    } 
    }   


package microplanning;  
import java.util.ArrayList; 
import java.util.List;  
public class PSCannedText extends PhraseSpec{  
 private String text;  
 private String type;  
 private List<PSCannedText> modifier;  
 private FeatureValue featureValue;    
 public FeatureValue getFeatureValue() {   
 return featureValue;  
 }    
 public void setFeatureValue(FeatureValue featureValue) {   
 this.featureValue = featureValue;  
 } 
   public void setType(String type) {   
   this.type = type;  
   }    
   public String getType() {   
   return type;  
   }    
   public PSCannedText(String text) {   
   this.text = text;  
   }    
   public String getText() {   
   return text;  
   }    
   public void setText(String text) {   
   this.text = text;  
   }    
   public List<PSCannedText> getModifier() {   
   return modifier;  
   }    
   public void setModifier(List<PSCannedText> modifier) {   
   this.modifier = modifier;  
   }    
   public void addModifier(PSCannedText psCannedText) {   
   if(this.modifier == null) {    
   this.modifier = new ArrayList<PSCannedText>();    
   modifier.add(psCannedText);   
   }   
   else modifier.add(psCannedText);  
   } 
   }   


package microplanning;  
import java.util.ArrayList; 
import java.util.List;  
public class TextSpec extends Spec{  
 private List<Spec> children; 
  private TextSpec parent;  
  private String title;    
  public TextSpec (String title, TextSpec parent, List<Spec> children) {   this.title = title;   
  this.parent = parent;   
  this.children = children;  
  }    
  public TextSpec (String title, TextSpec parent) { 
  this.title = title;   
  this.parent = parent;  
  }    
  public String toString() {   
  return title;  
  }    
  public void setChildren(List<Spec> children) {   
  this.children = children;  
  }    
  public void setParent(TextSpec parent) {   
  this.parent = parent;  
  }    
  public void setTitle(String title) {   
  this.title = title;  
  }    
  public String getTitle() {   
  return title;  
  }    
  public TextSpec getParent() {   
  return parent;  
  }    
  public List<Spec> getChildren() {   
  return children;  
  }    
  public void addChildren(Spec spec) {   
  if(this.children == null) {    
  this.children = new ArrayList<Spec>();    
  this.children.add(spec);   
  }   
  else this.children.add(spec);  
  }   
  }   


package microplanning;  
import java.util.ArrayList; 
import java.util.List;  
import microplanning.phrasespecs.NoOccuModPhrase ;  
public class TextStructurer {  
 private List<PPSAbstractSyntax> syntax;    
 public TextStructurer(List<PPSAbstractSyntax> syntax){   
 this.syntax = syntax;  
 }   
   private TextSpec describePhilippines() throws Exception {   TextSpec philippines = new TextSpec("Highest", null);   
   TextSpec highest =  describeHighestTwo();   
   TextSpec none =  describeNoOccupation(); 
   //  List<Spec> s = new ArrayList<Spec>(); 
   //  s.add(ppsAbstractSyntax); 
   //  noOccu.setChildren(s);     
 highest.setParent(philippines);  
 none.setParent(philippines);      
 List<Spec> constituents = new ArrayList<Spec>();   
 constituents.add(highest);   
 constituents.add(none);  
 philippines.setChildren(constitue nts);      
 return philippines;  
 }    
 private TextSpec describeHighestTwo() {   
 List<PPSAbstractSyntax> constituents = new ArrayList<PPSAbstractSyntax>();   
 List<PPSAbstractSyntax> loc = new ArrayList<PPSAbstractSyntax>();   String title = "Highest two occupation";    
 //  HighestOccupationPhrase highestOccupationPhrase = new HighestOccupationPhrase(); 
 //  constituents.add(highestOccupatio nPhrase.lexicalise());      
 for (PPSAbstractSyntax abstractSyntax : syntax) {    
 if(abstractSyntax.getTitle().equa ls(title)) {     
 constituents.add(abstractSyntax);    
 }    
 if(abstractSyntax.getTitle().equa ls("Location")) {     
 loc.add(abstractSyntax);    
 }   
 }      
 PPSAbstractSyntax ppsAbstractSyntax = Aggregator.aggregatePreposition(loc.get(0 ),     constituents, "or", "are","Highest Occupation Phrase"); 
     List<Spec> list = new ArrayList<Spec>();  
 list.add(ppsAbstractSyntax);      
 return new TextSpec(title, null, list);  
 }    
 private TextSpec describeNoOccupation() {   
 List<PPSAbstractSyntax> constituents = new ArrayList<PPSAbstractSyntax>();   
 String title = "Places with high no occupation";      
 NoOccuModPhrase noOccuModPhrase = new NoOccuModPhrase(); 
 //  constituents.add(noOccuModPhrase. lexicalise());   
 List<Spec> list = new ArrayList<Spec>();      
 for (PPSAbstractSyntax abstractSyntax : syntax) {    
 if(abstractSyntax.getTitle().equa ls(title)) {     
 constituents.add(abstractSyntax);    
 }    
 if(abstractSyntax.getTitle().equa ls("No occupation")) {     abstractSyntax.setTitle("No Occupation Phrase");     
 list.add(abstractSyntax);    
 }   
 }  
 if(!(constituents.isEmpty() || list.isEmpty())) {    
 PPSAbstractSyntax ppsAbstractSyntax = Aggregator.aggregatePreposition(noOccuMod Phrase.lexicalise(),     constituents, "and", "in","No Occupation Places Phrase");    list.add(ppsAbstractSyntax);   
 }   
 return new TextSpec(title, null, list);  
 }    
 private TextSpec describeUrbanRural() {   
 TextSpec urbanRural = new TextSpec("Highest two places", null);   TextSpec urban =  describeUrban();   
 TextSpec rural =  describeRural();       
 urban.setParent(urbanRural);  
 rural.setParent(urbanRural);      
 List<Spec> constituents = new ArrayList<Spec>();   
 constituents.add(urban);   
 constituents.add(rural);  
 urbanRural.setChildren(constituen ts);      
 return urbanRural;  }    
 private TextSpec describeUrban() {   
 List<Spec> constituents = new ArrayList<Spec>();   
 String title = "Highest number of occupation in area 1";   
 for (PPSAbstractSyntax abstractSyntax : syntax) {    
 if(abstractSyntax.getTitle().equa ls(title)) {     
 abstractSyntax.setTitle("Occupati ons in Area 1 Phrase");     
 constituents.add(abstractSyntax);    
 }   
 }   
 return new TextSpec(title, null, constituents);  
 }    
 private TextSpec describeRural() {   
 List<Spec> constituents = new ArrayList<Spec>();   
 String title = "Highest number of occupation in area 2";   
 for (PPSAbstractSyntax abstractSyntax : syntax) {    
 if(abstractSyntax.getTitle().equa ls(title)) {     
 abstractSyntax.setTitle("Occupati ons in Area 2 Phrase");     
 constituents.add(abstractSyntax);    
 }   
 }   
 return new TextSpec(title, null, constituents);  
 }   
  public TextSpec arrangeTree() throws Exception {   
  TextSpec philippines = describePhilippines();   
  TextSpec urbanRural = describeUrbanRural();   
  TextSpec parent = new TextSpec("Who/Where are the poor households.", null);     
 philippines.setParent(parent);  
 urbanRural.setParent(parent);      
 List<Spec> constituents = new ArrayList<Spec>();  
 constituents.add(philippines);  
 constituents.add(urbanRural);  
 parent.setChildren(constituents);      
 return parent;  }   }   


package microplanning.phrasespecs;  
import java.util.ArrayList; 
import java.util.List;  
import documentplan.messages.NoOccupationMsg;  
import microplanning.FeatureValue; 
import microplanning.Modifier; 
import microplanning.PPSAbstractSyntax; 
import microplanning.PSCannedText; 
import microplanning.PhraseSpec; 
import simplenlg.features.Feature; 
import simplenlg.features.NumberAgreement;  
public class HighestOccupationPhrase{    
public PPSAbstractSyntax lexicalise(NoOccupationMsg msg) {   
PPSAbstractSyntax highestOccupation = new PPSAbstractSyntax();  
 highestOccupation.setHead("in");      
 List<FeatureValue> features = new ArrayList<FeatureValue>();   
 FeatureValue featureValue = new FeatureValue(Feature.NUMBER, NumberAgreement.PLURAL);  
 features.add(featureValue);  
 highestOccupation.setFeatures(fea tures);    
 //  PSCannedText primarily = new PSCannedText("primarily"); 
 //  primarily.setType(Modifier.PREMOD IFIER); 
 //  highestOccupation.addModifier(pri marily);     
highestOccupation.setSubject(gene rateSubject()); 
highestOccupation.setObject(new PSCannedText(msg.getRegion()));      
return highestOccupation;  
}    
private PPSAbstractSyntax generateSubject() {   
PPSAbstractSyntax ppsAbstractSyntax = new PPSAbstractSyntax();  
 ppsAbstractSyntax.setHead("occupa tion");  
 ppsAbstractSyntax.setSpecifier("t he");   
 List<PhraseSpec> modifiers = new ArrayList<PhraseSpec>();   
 PSCannedText poor = new PSCannedText("primary");  
 poor.setType(Modifier.ADJECTIVE);   modifiers.add(poor);      
 PPSAbstractSyntax modifier = new PPSAbstractSyntax();   
 modifier.setHead("of");      
 PPSAbstractSyntax object = new PPSAbstractSyntax();   
 object.setHead("poor households");  
 object.setType(Modifier.NOUNPHRAS E);  
 modifier.setType(Modifier.PREPOSI TIONALPHRASE);  
 modifier.setObject(object);      
 modifiers.add(modifier);  
 ppsAbstractSyntax.setModifiers(mo difiers);         
 return ppsAbstractSyntax;  
 }   
 // private PPSAbstractSyntax generateHead() { 
 //  PPSAbstractSyntax ppsAbstractSyntax = new PPSAbstractSyntax(); 
 //   //  ppsAbstractSyntax.setHead("source "); //  return ppsAbstractSyntax; // }   }   

package microplanning.phrasespecs;  
import simplenlg.features.Feature; 
import simplenlg.features.NumberAgreement; 
import simplenlg.features.Tense; 
import microplanning.FeatureValue; 
import microplanning.Modifier; 
import microplanning.PPSAbstractSyntax; 
import microplanning.PSCannedText;  
public class NoOccuModPhrase {  
 private PSCannedText members = new PSCannedText("poor households");     
 public PPSAbstractSyntax lexicalise() {   
 PPSAbstractSyntax ppsAbstractSyntax = new PPSAbstractSyntax();     
 ppsAbstractSyntax.setSubject(gene rateSubject());  
 ppsAbstractSyntax.setObject(gener ateObject());      
 return ppsAbstractSyntax;  
 }    
 private PPSAbstractSyntax generateSubject() {   
 PPSAbstractSyntax ppsAbstractSyntax = new PPSAbstractSyntax();   
 PPSAbstractSyntax modifier = new PPSAbstractSyntax();  
 modifier.setObject(members);  
 modifier.setType(Modifier.PREPOSI TIONALPHRASE);  
 ppsAbstractSyntax.setHead(" ");  
 ppsAbstractSyntax.addModifier(mod ifier);   
 return ppsAbstractSyntax;  
 }    
 private PPSAbstractSyntax generateObject() {   
 PPSAbstractSyntax ppsAbstractSyntax = new PPSAbstractSyntax();  
 ppsAbstractSyntax.setHead("be");  
 ppsAbstractSyntax.setSubject(new PSCannedText("no occupation"));      
 FeatureValue featureValue = new FeatureValue(Feature.NUMBER, NumberAgreement.PLURAL);  
 ppsAbstractSyntax.addFeature(feat ureValue);     
 ppsAbstractSyntax.setObject("foun d"); 
 PPSAbstractSyntax modifier = new PPSAbstractSyntax();  
 modifier.setHead("declare");   
 modifier.addFeature(new FeatureValue(Feature.TENSE, Tense.PAST));  
 modifier.setType(Modifier.FRONTMO DIFIER);      
 modifier.addModifier(new PSCannedText("have"));     
 ppsAbstractSyntax.addModifier(mod ifier);      
 return ppsAbstractSyntax;  
 } 
 }


package microplanning.phrasespecs;  
import java.util.ArrayList; 
import java.util.List;  
import microplanning.FeatureValue; 
import microplanning.Modifier; 
import microplanning.PPSAbstractSyntax; 
import microplanning.PSCannedText; 
import simplenlg.features.Feature; 
import simplenlg.features.NumberAgreement; 
import simplenlg.features.Tense; 
import documentplan.messages.NoOccupationMsg;  
public class NoOccupationPhrase {    
private PSCannedText members = new PSCannedText("poor households");   
 public PPSAbstractSyntax lexicalise(NoOccupationMsg message) {   
 PPSAbstractSyntax ppsAbstractSyntax  = new PPSAbstractSyntax();  
 ppsAbstractSyntax.setHead("declar e");      
 List<FeatureValue> features = new ArrayList<FeatureValue>();   
 FeatureValue featureValue = new FeatureValue(Feature.TENSE, Tense.PAST);  
 features.add(featureValue);  
 ppsAbstractSyntax.setFeatures(fea tures);     
 ppsAbstractSyntax.setSubject(gene rateSubject());  
 ppsAbstractSyntax.addModifier(gen eratePredicate(message)); 
     return ppsAbstractSyntax;  
     }      
 private PPSAbstractSyntax generateSubject() {   
 PPSAbstractSyntax ppsAbstractSyntax = new PPSAbstractSyntax();      
 PPSAbstractSyntax subject = new PPSAbstractSyntax();      
 PPSAbstractSyntax modifier = new PPSAbstractSyntax();   
 modifier.setHead("of");  
 modifier.setObject(members);  
 modifier.setSpecifier("the");  
 modifier.setType(Modifier.PREPOSI TIONALPHRASE);     
 subject.addModifier(modifier);   
 subject.setSubject(new PSCannedText("majority"));     
 ppsAbstractSyntax.setSubject(subj ect);         
 return ppsAbstractSyntax;  
 }    
 private PPSAbstractSyntax generatePredicate(NoOccupationMsg message) {      
 PPSAbstractSyntax ppsAbstractSyntax = new PPSAbstractSyntax();  
 ppsAbstractSyntax.setHead("compri se");      
 PSCannedText modifier = new PSCannedText("having");  
 modifier.setType(Modifier.PREMODI FIER);      
 PPSAbstractSyntax subject = new PPSAbstractSyntax();   
 subject.setHead("no occupation");  
 subject.addModifier(modifier);  
 ppsAbstractSyntax.setSubject(subj ect);      
 PSCannedText which = new PSCannedText("which");  
 which.setType(Modifier.PREMODIFIE R);   
 ppsAbstractSyntax.addModifier(whi ch); 
 //  ppsAbstractSyntax.setPredicate(ne w PSCannedText("comprises"));      
 PPSAbstractSyntax object = new PPSAbstractSyntax();  
 object.setType(Modifier.CONJUNCTI ON);   
 object.setHead("or");   
 object.addConjuctions(new PSCannedText((double)Math.round(message.g etMessage().getNone().getPercentage()*100 )/100 + "%"));   
 object.addConjuctions(new PSCannedText(message.getMessage().getNone ().getValueFormat()));  
 object.addModifier(generateModifi er());     
 ppsAbstractSyntax.setObject(objec t);  
 ppsAbstractSyntax.setType(Modifie r.POSTMODIFIER);   
 return ppsAbstractSyntax;  
 }    
 private PPSAbstractSyntax generateModifier() {   
 PPSAbstractSyntax ppsAbstractSyntax = new PPSAbstractSyntax();      
 PPSAbstractSyntax subject= new PPSAbstractSyntax();   
 subject.addFeature(new FeatureValue(Feature.NUMBER, NumberAgreement.PLURAL));  
 subject.setHead("respondent");  
 ppsAbstractSyntax.setSubject(subj ect);     
 ppsAbstractSyntax.setSpecifier("t he");      
 PSCannedText of = new PSCannedText("of");  
 of.setType(Modifier.FRONTMODIFIER );  
 ppsAbstractSyntax.addModifier(of) ;  
 ppsAbstractSyntax.setType(Modifie r.POSTMODIFIER);   
 return ppsAbstractSyntax;  
 }   
 }



package microplanning.phrasespecs;  
import microplanning.PPSAbstractSyntax; 
import documentplan.messages.Message;  
public class PrepositionalPhrase{    
public PPSAbstractSyntax lexicalise(Message message) {   
PPSAbstractSyntax ppsAbstractSyntax = new PPSAbstractSyntax();  
 ppsAbstractSyntax.setObject(messa ge);   
 return ppsAbstractSyntax;  
 }   
 }



package microplanning.phrasespecs;  
import java.util.ArrayList; 
import java.util.List;  
import microplanning.FeatureValue; 
import microplanning.Modifier; 
import microplanning.PPSAbstractSyntax; 
import microplanning.PSCannedText; 
import microplanning.PhraseSpec; 
import simplenlg.features.Feature; 
import simplenlg.features.NumberAgreement; 
import documentplan.messages.HighestRegionMsg;  
public class UrbanOrdinalPhrase {    
private String[] ordinal = new String[]{"first", "second","third","fourth","fifth","sixth" ,"seventh","eighth","ninth",    "tenth","eleventh","twelveth"};    public PPSAbstractSyntax lexicalise(HighestRegionMsg message, int number) {   
PPSAbstractSyntax highestOccupation = new PPSAbstractSyntax();  
 highestOccupation.setHead("be");  
  List<FeatureValue> features = new ArrayList<FeatureValue>();   
  FeatureValue featureValue = new FeatureValue(Feature.NUMBER, NumberAgreement.SINGULAR);  
 features.add(featureValue);  
 highestOccupation.setFeatures(fea tures);     
 highestOccupation.setSubject(gene rateSubject(number)); 
highestOccupation.setObject(new PSCannedText(message.getMessage().getColu mnName() + " ("     + message.getMessage().getValueFormat() + " or " + message.getMessage().getPercentage() + "%)"));  
  return highestOccupation;  
  }    
  private PPSAbstractSyntax generateSubject(int number) {   
  PPSAbstractSyntax ppsAbstractSyntax = new PPSAbstractSyntax();  
 ppsAbstractSyntax.setHead("type") ;      
 List<PhraseSpec> modifiers = new ArrayList<PhraseSpec>();   
 PSCannedText poor = new PSCannedText("common");  
 poor.setType(Modifier.ADJECTIVE);   
 modifiers.add(poor);   
 PSCannedText ord = new PSCannedText(ordinal[number]);  
 ord.setType(Modifier.ADJECTIVE);   
 poor.addModifier(ord);  
 ppsAbstractSyntax.setModifiers(mo difiers);      
 return ppsAbstractSyntax;  
 }  
}



package microplanning.phrasespecs;  
import java.util.ArrayList; 
import java.util.List;  
import microplanning.FeatureValue; 
import microplanning.Modifier; 
import microplanning.PPSAbstractSyntax; 
import microplanning.PSCannedText; 
import microplanning.PhraseSpec; 
import simplenlg.features.Feature; 
import simplenlg.features.NumberAgreement; 
import documentplan.messages.HighestRegionMsg;  
public class UrbanRuralPhrase {    
public PPSAbstractSyntax lexicalise(HighestRegionMsg message) {   
PPSAbstractSyntax highestOccupation = new PPSAbstractSyntax();  
 highestOccupation.setHead("be"); 
     List<FeatureValue> features = new ArrayList<FeatureValue>();   
     FeatureValue featureValue = new FeatureValue(Feature.NUMBER, NumberAgreement.PLURAL);  
 features.add(featureValue);  
 highestOccupation.setFeatures(fea tures);     
 highestOccupation.setSubject(gene rateSubject(message));  
 highestOccupation.setObject(new PSCannedText(message.getMessage().getColu mnName()));     
 highestOccupation.addModifier(gen eratePreModifier(message));      
 return highestOccupation;  
 }    
 private PPSAbstractSyntax generateSubject(HighestRegionMsg message) {   
 PPSAbstractSyntax ppsAbstractSyntax = new PPSAbstractSyntax();  
 ppsAbstractSyntax.setHead(message .getMessage().getValueFormat() + " ("     + message.getMessage().getPercentage() + "%)");      
 List<PhraseSpec> modifiers = new ArrayList<PhraseSpec>();   
 PPSAbstractSyntax modifier = new PPSAbstractSyntax();   
 modifier.setHead("of");      
 PPSAbstractSyntax object = new PPSAbstractSyntax();  
 object.setHead("respondent");  
 object.setSpecifier("the");  
 object.setType(Modifier.NOUNPHRAS E);   
 object.addFeature(new FeatureValue(Feature.NUMBER, NumberAgreement.PLURAL));  
 modifier.setObject(object);      
 modifiers.add(modifier);  
 modifier.setType(Modifier.PREPOSI TIONALPHRASE);  
 ppsAbstractSyntax.setModifiers(mo difiers);      
 return ppsAbstractSyntax; 
 }    
 private PPSAbstractSyntax generatePreModifier(HighestRegionMsg message) {   
 PPSAbstractSyntax ppsAbstractSyntax = new PPSAbstractSyntax();  
 if(message.getRegion().equals("Ur ban Area") || message.getRegion().equals("Rural Area") ) 
 //   ppsAbstractSyntax.setSpecifier("t he");    
 ppsAbstractSyntax.setObject(messa ge.getRegion()+"s");   
 else    ppsAbstractSyntax.setObject(messa ge.getRegion());  
 ppsAbstractSyntax.setType(Modifie r.FORPHRASE);   return ppsAbstractSyntax;  }   }  



package microplanning.phrasespecs;  
import java.util.ArrayList; 
import java.util.List;  
import microplanning.FeatureValue; 
import microplanning.PPSAbstractSyntax; 
import microplanning.PSCannedText; 
import simplenlg.features.Feature; 
import simplenlg.features.NumberAgreement; 
import documentplan.messages.HighestRegionMsg;  
public class UrbanSecondPhrase {  
 public PPSAbstractSyntax lexicalise(HighestRegionMsg message) {   
 PPSAbstractSyntax highestOccupation = new PPSAbstractSyntax();  
 highestOccupation.setHead("be");  
  List<FeatureValue> features = new ArrayList<FeatureValue>();   
  FeatureValue featureValue = new FeatureValue(Feature.NUMBER, NumberAgreement.PLURAL);  
 features.add(featureValue);  
 highestOccupation.setFeatures(fea tures);      
 PSCannedText next = new PSCannedText("next"); 
  next.setFeatureValue(new FeatureValue(Feature.NUMBER, NumberAgreement.SINGULAR));     
 highestOccupation.setSubject(next );   
 highestOccupation.setObject(new PSCannedText(message.getMessage().getColu mnName() + " ("     + message.getMessage().getValueFormat() + " or " + message.getMessage().getPercentage() + "%)"));  
  return highestOccupation;  }  
}   



package realiser;  
import java.util.ArrayList; 
import java.util.List;  
import microplanning.FeatureValue; 
import microplanning.Modifier; 
import microplanning.PPSAbstractSyntax; 
import microplanning.PSCannedText; 
import microplanning.PhraseSpec; 
import microplanning.Spec; 
import microplanning.TextSpec; 
import simplenlg.framework.CoordinatedPhraseElem ent; 
import simplenlg.framework.NLGFactory; 
import simplenlg.framework.PhraseElement; 
import simplenlg.lexicon.Lexicon; 
import simplenlg.lexicon.XMLLexicon; 
import simplenlg.phrasespec.AdjPhraseSpec; 
import simplenlg.phrasespec.NPPhraseSpec; 
import simplenlg.phrasespec.PPPhraseSpec; 
import simplenlg.phrasespec.SPhraseSpec; 
import simplenlg.phrasespec.VPPhraseSpec;  
public class Realise {  
 private Lexicon lexicon;  
 private NLGFactory nlgFactory;  private ArrayList<ArrayList<SPhraseSpec>> list;  
 public Realise() {   
 lexicon = new XMLLexicon("default-lexicon.xml");   
 nlgFactory = new NLGFactory(lexicon);   
 list = new ArrayList<ArrayList<SPhraseSpec>>();  
 }  
 public SPhraseSpec realisePreposition(PPSAbstractSyntax ppsAbstractSyntax) {  
  SPhraseSpec sPhraseSpec = nlgFactory.createClause();  
  //  sPhraseSpec.setFrontModifier(ppsA bstractSyntax.getHead());   
  NPPhraseSpec mesg = nlgFactory.createNounPhrase(ppsAbstractSy ntax.getObject().toString());  
 sPhraseSpec.setSubject(mesg);  
  return sPhraseSpec;  
  }  
 public SPhraseSpec realisePhrase(PPSAbstractSyntax ppsAbstractSyntax) {  
  SPhraseSpec sPhraseSpec = nlgFactory.createClause();  
  NPPhraseSpec npPhraseSpec = nlgFactory.createNounPhrase();  
 if(ppsAbstractSyntax.getSubject() instanceof PPSAbstractSyntax) {    
 npPhraseSpec = createNounPhrase((PPSAbstractSyntax)ppsAb stractSyntax.getSubject());   
 }   
 else if (ppsAbstractSyntax.getSubject() instanceof PSCannedText) {    
 npPhraseSpec.setNoun(((PSCannedTe xt)ppsAbstractSyntax.getSubject()).getTex t());   
 }   
 if(ppsAbstractSyntax.getSubject() !=null)    
 sPhraseSpec.setSubject(npPhraseSp ec);     
 if(ppsAbstractSyntax.getHead()!=n ull)    
 sPhraseSpec.setVerb(ppsAbstractSy ntax.getHead());     
 if(ppsAbstractSyntax.getFeatures( )!=null) {    
 addFeatures(sPhraseSpec, ppsAbstractSyntax);   
 }   
 if(ppsAbstractSyntax.getObject()! =null) {    
 if(ppsAbstractSyntax.getObject() instanceof PSCannedText)     
 sPhraseSpec.setObject(((PSCannedText)ppsAbstractSyntax.getObject()).getText());        
 else if ((ppsAbstractSyntax.getObject() instanceof PPSAbstractSyntax)) {     
 if(((PPSAbstractSyntax)ppsAbstrac tSyntax.getObject()).getType().equals(Mod ifier.CONJUNCTION)) {      
 sPhraseSpec.setObject(createPrepo sitionalPhrase((PPSAbstractSyntax)ppsAbst ractSyntax.getObject()));     
 }     
 if(((PPSAbstractSyntax)ppsAbstrac tSyntax.getObject()).getModifiers()!=null ) {      
 addModifiers(sPhraseSpec, (PPSAbstractSyntax)ppsAbstractSyntax.getO bject());     
 }    
 }        
 else sPhraseSpec.setObject(ppsAbstract Syntax.getObject());        
 }   
 if(ppsAbstractSyntax.getModifiers ()!=null) {    
 addModifiers(sPhraseSpec, ppsAbstractSyntax);   
 }     
 if(ppsAbstractSyntax.getSpecifier ()!=null)     
 npPhraseSpec.setSpecifier(ppsAbst ractSyntax.getSpecifier());  
  return sPhraseSpec;  
  }  
 private PhraseElement addFeatures(PhraseElement phraseElement, PPSAbstractSyntax ppsAbstractSyntax) {   
 List<FeatureValue> featureValues = ppsAbstractSyntax.getFeatures();   
 for (FeatureValue featureValue : featureValues) {    
 phraseElement.setFeature(featureV alue.getFeature(), featureValue.getValue());   
 }   
 return phraseElement;  
 }  
 private NPPhraseSpec createNounPhrase(PPSAbstractSyntax ppsAbstractSyntax) { 
  NPPhraseSpec npPhraseSpec = nlgFactory.createNounPhrase();   
  PPSAbstractSyntax subject = (PPSAbstractSyntax)ppsAbstractSyntax;     
 if(subject.getHead()!=null)    
 npPhraseSpec.setNoun(subject.getHead());   
 if(subject.getFeatures()!=null)     
 addFeatures(npPhraseSpec, subject);   
 if(subject.getSpecifier()!=null)     
 npPhraseSpec.setSpecifier(subject .getSpecifier());   
 if(subject.getModifiers()!=null)     
 addModifiers(npPhraseSpec, subject);     
 if(subject.getSubject()!=null) {    
 SPhraseSpec subjectPhraseSpec = realisePhrase((PPSAbstractSyntax)subject. getSubject()); 
 //   npPhraseSpec.addModifier(subject. getHead());    
 npPhraseSpec.setNoun(subjectPhras eSpec);   
 }  
  return npPhraseSpec;  
  }  
 private PhraseElement addModifiers(PhraseElement npPhraseSpec, PPSAbstractSyntax subject) {   for (int j = 0; j < subject.getModifiers().size(); j++) {  
   if(subject.getModifiers().get(j) instanceof PSCannedText) {     
   AdjPhraseSpec adjPhraseSpec = nlgFactory.createAdjectivePhrase();     
   if(((PSCannedText)subject.getModi fiers().get(j)).getType().equals(Modifier .ADJECTIVE)) {      
   adjPhraseSpec = createAdjectivePhrase((PSCannedText)subje ct.getModifiers().get(j));      
   npPhraseSpec.addModifier(adjPhras eSpec);     
   } 
    else if (((PSCannedText)subject.getModifiers().ge t(j)).getType().equals(Modifier.PREMODIFI ER)) {      
    npPhraseSpec.setPreModifier(((PSC annedText)subject.getModifiers().get(j)). getText());     
    }     
    else if (((PSCannedText)subject.getModifiers().ge t(j)).getType().equals(Modifier.FRONTMODI FIER)) {      
    npPhraseSpec.setFrontModifier(((P SCannedText)subject.getModifiers().get(j) ).getText());     
    }    
    }  
   else if (subject.getModifiers().get(j) instanceof PPSAbstractSyntax) {     
   if(((PPSAbstractSyntax)subject.ge tModifiers().get(j)).getType().equals(Mod ifier.PREPOSITIONALPHRASE)){      
   PPPhraseSpec ppPhraseSpec = nlgFactory.createPrepositionPhrase();      
   PPSAbstractSyntax subjectModifier = (PPSAbstractSyntax)subject.getModifiers() .get(j);      
   if(subjectModifier.getHead()!=nul l)       ppPhraseSpec.setPreposition(subje ctModifier.getHead());      
   NPPhraseSpec npModifier = nlgFactory.createNounPhrase();      
   if(subjectModifier.getObject() instanceof PSCannedText)       
   npModifier.setNoun(((PSCannedText )subjectModifier.getObject()).getText());      
   else if(subjectModifier.getObject() instanceof PPSAbstractSyntax) {       
   if(((PPSAbstractSyntax)subjectMod ifier.getObject()).getType().equals(Modif ier.NOUNPHRASE))       
 npModifier.setNoun(createNounPhra se((PPSAbstractSyntax)subjectModifier.get Object()));      
 }      
 else npModifier.setNoun(subjectModifie r.getObject()); 
//     npModifier.setSpecifier("the");      
ppPhraseSpec.setObject(npModifier );      
npPhraseSpec.addModifier(ppPhrase Spec);     
}     
else if(((PPSAbstractSyntax)subject.getModifie rs().get(j)).getType().equals(Modifier.FR ONTMODIFIER)){      
PPSAbstractSyntax modifier = (PPSAbstractSyntax)subject.getModifiers() .get(j);      
VPPhraseSpec vpPhraseSpec = nlgFactory.createVerbPhrase(modifier.getH ead());      
addFeatures(vpPhraseSpec, modifier);      
vpPhraseSpec.setPreModifier(((PSC annedText)modifier.getModifiers().get(0)) .getText());      
npPhraseSpec.setFrontModifier(vpP hraseSpec);    
 }     
else if(((PPSAbstractSyntax)subject.getModifie rs().get(j)).getType().equals(Modifier.PO STMODIFIER)){      
SPhraseSpec modifier = realisePhrase((PPSAbstractSyntax)subject. getModifiers().get(j));      
npPhraseSpec.setPostModifier(modi fier);     
}     
else if(((PPSAbstractSyntax)subject.getModifie rs().get(j)).getType().equals(Modifier.FO RPHRASE)){      
SPhraseSpec modifier = realiseUrbanRuralCP((PPSAbstractSyntax)su bject.getModifiers().get(j));      
npPhraseSpec.setFrontModifier(mod ifier);     
}    
}   
}      
return npPhraseSpec;  
}  
 private AdjPhraseSpec createAdjectivePhrase(PSCannedText psCannedText) {   
 AdjPhraseSpec adjPhraseSpec = nlgFactory.createAdjectivePhrase();  
 adjPhraseSpec.setAdjective(psCann edText.getText());   
 if(psCannedText.getModifier()!=nu ll ) {    
 List<PSCannedText> list = psCannedText.getModifier();    
 for (PSCannedText phraseSpec : list) {     
 createAdjectivePhrase(adjPhraseSp ec,phraseSpec);    
 }   
 }   
 return adjPhraseSpec;  
 }    
 private AdjPhraseSpec createAdjectivePhrase(AdjPhraseSpec adjPhraseSpec, PSCannedText psCannedText) {  
 adjPhraseSpec.addModifier(psCanne dText.getText());   
 if(psCannedText.getModifier()!=nu ll ) {    
 List<PSCannedText> list = psCannedText.getModifier();    
 for (PSCannedText phraseSpec : list) {     
 createAdjectivePhrase(phraseSpec) ;    
 }   
 }   
 return adjPhraseSpec;  
 }    
 private CoordinatedPhraseElement createPrepositionalPhrase(PPSAbstractSynt ax ppsAbstractSyntax){   CoordinatedPhraseElement coordinatedPhraseElement = nlgFactory.createCoordinatedPhrase();   
 List<PhraseSpec> list = ppsAbstractSyntax.getConjunctions();   
 for (PhraseSpec phraseSpec : list) {    
 if(phraseSpec instanceof PPSAbstractSyntax)     
 coordinatedPhraseElement.addCoord inate(realisePreposition((PPSAbstractSynt ax)phraseSpec));    
 else if(phraseSpec instanceof PSCannedText)     
 coordinatedPhraseElement.addCoord inate(((PSCannedText)phraseSpec).getText( ));   
 }  
 if(ppsAbstractSyntax.getHead()!=null) 
   coordinatedPhraseElement.setConju nction(ppsAbstractSyntax.getHead());   
   return coordinatedPhraseElement;  
   }   
 public SPhraseSpec realiseUrbanRuralCP(PPSAbstractSyntax ppsAbstractSyntax) {   
 SPhraseSpec sPhraseSpec = nlgFactory.createClause();  
 sPhraseSpec.setFrontModifier("for ");   
 NPPhraseSpec npPhraseSpec = nlgFactory.createNounPhrase(); 
 //  PPSAbstractSyntax subject = (PPSAbstractSyntax) ppsAbstractSyntax.getSubject();  
 npPhraseSpec.setNoun(ppsAbstractS yntax.getObject()+",");  
 if(ppsAbstractSyntax.getSpecifier ()!=null)     
 npPhraseSpec.setSpecifier(ppsAbst ractSyntax.getSpecifier());  
 sPhraseSpec.setSubject(npPhraseSp ec);   
 return sPhraseSpec;  
 }  
 private SPhraseSpec realiseNoOccuModifier(PPSAbstractSyntax ppsAbstractSyntax) {   
 SPhraseSpec sPhraseSpec = nlgFactory.createClause();   
 NPPhraseSpec npPhraseSpec = createNounPhrase((PPSAbstractSyntax)ppsAb stractSyntax.getSubject());   
 SPhraseSpec spec = realisePhrase((PPSAbstractSyntax)ppsAbstr actSyntax.getObject());  
 sPhraseSpec.setSubject(npPhraseSp ec);  
 sPhraseSpec.setObject(spec);   
 return sPhraseSpec;  
 }  
 public SPhraseSpec realiseAggregate(PPSAbstractSyntax ppsAbstractSyntax) {   
 CoordinatedPhraseElement coordinatedPhraseElement = createPrepositionalPhrase(ppsAbstractSynt ax);  
 coordinatedPhraseElement.addPreMo difier(((PSCannedText)ppsAbstractSyntax.g etModifiers().get(0)).getText());   
 SPhraseSpec main;  
 if(ppsAbstractSyntax.getTitle().equals("Places with high no occupation") || ppsAbstractSyntax.getTitle().equa ls("No Occupation Places Phrase"))     
 main = realiseNoOccuModifier((PPSAbstractSyntax) ppsAbstractSyntax.getSubject());   else main = realisePhrase((PPSAbstractSyntax)ppsAbstr actSyntax.getSubject());  
 main.setPostModifier(coordinatedP hraseElement);   
 return main;  
 }  
 public ArrayList<ArrayList<SPhraseSpec>> realiseText(TextSpec textSpec) {   List<Spec> specs = textSpec.getChildren();   int i = 0;   ArrayList<SPhraseSpec> s = new ArrayList<SPhraseSpec>();   
 ArrayList<SPhraseSpec> noOccupation = new ArrayList<SPhraseSpec>();  
  for (Spec spec : specs) {    
  if(!(spec instanceof PPSAbstractSyntax)) {    
   realiseText((TextSpec)spec);    
   }    
  else if(spec instanceof PPSAbstractSyntax && spec!=null){     
  if(((PPSAbstractSyntax)spec).getT itle().equals("Highest Occupation Phrase") || ((PPSAbstractSyntax)spec).getTitl e().equals("No Occupation Places Phrase")) {      
  SPhraseSpec sPhraseSpec = realiseAggregate((PPSAbstractSyntax)spec) ;      
  if(((PPSAbstractSyntax)spec).getT itle().equals("No Occupation Places Phrase")) {       
  noOccupation.add(sPhraseSpec);       
  list.add(noOccupation);      
  }      
  else if (((PPSAbstractSyntax)spec).getTitle().equ als("Highest Occupation Phrase")) {       
  s.add(sPhraseSpec);       
  list.add(s);      }     }      
  else if(((PPSAbstractSyntax)spec).getTitle().e quals("No Occupation Phrase")) {      
  SPhraseSpec sPhraseSpec = realisePhrase((PPSAbstractSyntax)spec);      
  noOccupation.add(sPhraseSpec); 
  //     list.add(noOccupation);     
  }  
    else if (((PPSAbstractSyntax)spec).getTitle().equ als("Occupations in Area 1 Phrase") || ((PPSAbstractSyntax)spec).getTitl e().equals("Occupations in Area 2 Phrase")) {  
     if(i==0) {       
     SPhraseSpec sPhraseSpec = realisePhrase((PPSAbstractSyntax)spec); 
     //      sPhraseSpec.addFrontModifier(real iseUrbanRuralCP((PPSAbstractSyntax)spec)) ; 
      s.add(sPhraseSpec);      
      }      
      if(i == 1) s.add(realisePhrase((PPSAbstractSyntax)sp ec));      
      if(i > 1) s.add(realisePhrase((PPSAbstractSyntax)sp ec));      
      i++;  
     if (i == specs.size()) {       
     list.add(s);       
     i = 0;       
     //s.clear();      
     }     
     }    
     }   
     }   
     return list;  
     } 
     }

