package controlleur.donnee;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Articles {
	private  StringProperty code;
	private  StringProperty code_categorie;
	private  StringProperty designation;
	private  DoubleProperty prix_unitaire;
	private  IntegerProperty quantite ;
	private   StringProperty date;
	
	
	
	public Articles() {
		
	}
	 
	
	public Articles(String code,String C,String D,Integer a,Double prix,String date) {
		this.code=new SimpleStringProperty(code);
		this.code_categorie=new SimpleStringProperty(C);
		this.designation=new SimpleStringProperty(D);
		this.date=new SimpleStringProperty(date);
		this.quantite=new SimpleIntegerProperty(a);
		this.prix_unitaire=new SimpleDoubleProperty(prix);
	}
	
	public String getCode() {
		return code.get();
	}
	public void setCode(StringProperty code) {
		this.code = code;
	}
	public StringProperty getpropertyCode() {
		return code;
	}
	
	public String CodeCategorie() {
		return code_categorie.get();
	}
	public StringProperty getCode_categorie() {
		return code_categorie;
	}
	
	public void setCode_categorie(StringProperty code_categorie) {
		this.code_categorie = code_categorie;
	}
	
	
	public DoubleProperty getpropertyPrix() {
		return prix_unitaire;
	}
	public Double getPrix_unitaire() {
		return prix_unitaire.get();
	}
	public void setPrix_unitaire(DoubleProperty prix_unitaire) {
		this.prix_unitaire = prix_unitaire;
	}
	
	public IntegerProperty getPropertyQuantite() {
		return quantite;
	}
	
	public Integer getQuantite() {
		return quantite.get();
	}
	public void setQuantite(IntegerProperty quantite) {
		this.quantite = quantite;
	}
	
	public String getDate() {
		return date.get();
	}
	public StringProperty getDateL() {
		return date;
	}
	public void setDate(StringProperty date) {
		this.date = date;
	}


	public String getDesignation() {
		return designation.get();
	}
	public StringProperty getDesignatione() {
		return designation;
	}


	public void setDesignatione(StringProperty designatione) {
		this.designation = designatione;
	}

}
