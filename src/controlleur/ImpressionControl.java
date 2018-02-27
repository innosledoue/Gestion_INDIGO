package controlleur;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import controlleur.donnee.Client;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ImpressionControl implements Initializable {
	
	
	private Modifi_ClientsControl main,main1;
	Stage exit,exit1;
	Client person;
	
	@FXML
	private TextField tx_code,tx_nom,tx_prenom,tx_addresse,tx_code_postal,tx_tel,tx_email,tx_ville,tx_mobile,tx_date;
	@FXML
	private TextArea tx_remarque;
	@FXML
	private Button bt_ok,bt_impr;
	@FXML
	private CheckBox ch_carte;
	@FXML
	private Label lb_dateactu;
	
	
	public ImpressionControl() {
		
	}
	
	
	public void setControl(Modifi_ClientsControl ert) {
		this.main=ert;
		try{	
         	//exit=main.getStage();
         	 bt_ok.setVisible(true);
         	 
         	 
         		//bt_ok.setVisible(true);
         	}
 		catch(Exception eee) {
 			System.err.println(" ERROR VERIFY YOUR FILE"); 	 	 		}
		
	
}
		public void setControl1(Modifi_ClientsControl ert) {
		this.main1=ert;
	
		
		try{	
         	//exit1=main1.getStage1();
         	bt_impr.setVisible(true);
         	tx_code.setText(person.getCode());
        	tx_nom.setText(person.getNom());
        	tx_prenom.setText(person.getPrenom());
        	
        	 ch_carte.setSelected(sensCarte(person.getCarteF()));
         	 
        	 tx_ville.setText(person.getVille());
        	 tx_code_postal.setText(person.getCode_postal());
        	tx_mobile.setText(person.getMobile());
        	 tx_tel.setText(person.getTel());
        	 tx_email.setText(person.getEmail());
        	 tx_addresse.setText(person.getAddresse());
        	 tx_remarque.setText(person.getRemarque());
        	
         		//bt_ok.setVisible(true);
         	}
 		catch(Exception eee) {
 			System.err.println(" ERROR VERIFY YOUR FILE"); 	 	 		}
		
	
}
		/* try{
			 OWN=main1.getTable();
	         	exit1=main1.getStage3();

	         	 
	         	
	         	 
	          date.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	         	 date.setEditable(true);
	         	date.addEventHandler(KeyEvent.ANY, new EventHandler<KeyEvent>() {
	     		    @Override
	     		    public void handle(KeyEvent event) {
	     		        event.consume();
	     		    }
	     		});
	     		date.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
	     		    @Override
	     		    public void handle(MouseEvent event) {
	     		        event.consume();
	     		    }
	     		});
	         	
	         	 bt_ajout.setVisible(true);
	         	}
	 		catch(Exception e) {System.err.println("ERROR ICI  modification");
	}}
*/
		public void setclient(Client er) {
			this.person=er;
		}


		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			bt_ok.setVisible(false);
			bt_impr.setVisible(false);
			lb_dateactu.setText(LocalDate.now().toString());
			insensible(tx_code);
			insensible(tx_nom);
			insensible(tx_prenom);
			insensible(tx_ville);
			insensible(tx_mobile);
			insensible(tx_tel);
			insensible(tx_email);
			insensible(tx_addresse);
			insensible(tx_date);
			insensible(tx_code_postal);
			insensible(ch_carte);
			insensible(tx_remarque);
	
			
		}
		
		public void insensible(TextField er) {
			er.addEventHandler(KeyEvent.ANY, new EventHandler<KeyEvent>() {
     		    @Override
     		    public void handle(KeyEvent event) {
     		        event.consume();
     		    }
     		});
     		er.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
     		    @Override
     		    public void handle(MouseEvent event) {
     		        event.consume();
     		    }
     		});
		}
		public void insensible(CheckBox er) {
			er.addEventHandler(KeyEvent.ANY, new EventHandler<KeyEvent>() {
     		    @Override
     		    public void handle(KeyEvent event) {
     		        event.consume();
     		    }
     		});
     		er.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
     		    @Override
     		    public void handle(MouseEvent event) {
     		        event.consume();
     		    }
     		});
		}
		public void insensible(TextArea er) {
			er.addEventHandler(KeyEvent.ANY, new EventHandler<KeyEvent>() {
     		    @Override
     		    public void handle(KeyEvent event) {
     		        event.consume();
     		    }
     		});
     		er.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
     		    @Override
     		    public void handle(MouseEvent event) {
     		        event.consume();
     		    }
     		});
		}
		
		
		public boolean sensCarte(int a) {
			boolean ter=false;
			if(a==1) {
				ter=true;
			}
			return ter;
		}
		
		
		@FXML
		public void ok() {
			exit.close();
		}
		
		@FXML
		public  void imprime() {
			// créer un objet de type javafx.print.PrinterJob qui vous servira à imprimer une arborescence de nœuds.
			
			final PrinterJob printerJob = PrinterJob.createPrinterJob(); 
			if (printerJob != null) { 
				
			    final Rectangle rectangle = new Rectangle(0, 0, 150, 100); 
			    rectangle.setFill(Color.RED); 
			    if (printerJob.printPage(rectangle)) { 
			        printerJob.endJob(); 
			    } 
			}
			
	        
	       /* try {
	            String lien = "C:\\Users\\TALA\\Documents\\ProjetJavaFx\\src\\proj\\gestapp\\dialogue\\clients.jrxml";
	            report = (JasperReport) JRLoader.loadObjectFromFile(lien);
	            jprint = JasperFillManager.fillReport(lien, null, conn);
	            viewer = new JasperViewer(jprint,false);
	            viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	            viewer.setVisible(true);
	        } catch (JRException ex) {
	            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
	        }*/
		}
		
	}

