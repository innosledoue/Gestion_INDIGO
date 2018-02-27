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
	private  StringProperty date;
	
	
	
	public Articles() {
		
	}
	 
	
	public Articles(String code,String cc,String dg,Integer a,Double prix,String date) {
		this.code=new SimpleStringProperty(code);
		this.code_categorie=new SimpleStringProperty(cc);
		this.designation=new SimpleStringProperty(dg);
		this.date=new SimpleStringProperty(date);
		this.quantite=new SimpleIntegerProperty(a);
		this.prix_unitaire=new SimpleDoubleProperty(prix);
	}
	
	public String getCode() {
		return code.get();
	}
	public void setCode(String code) {
		this.code.set(code);
	}
	public StringProperty getpropertyCode() {
		return code;
	}
	
	public String CodeCategorie() {
		return code_categorie.get();
	}
	
	public StringProperty getCodecategorieProperty() {
		return code_categorie;
	}
	
	public void setCodecategorie(String code_categorie) {
		this.code_categorie.set(code_categorie);
	}
	
	
	
	public Double getPrix_unitaire() {
		return prix_unitaire.get();
	}
	public void setPrix_unitaire(Double prix_unitaire) {
		this.prix_unitaire.set(prix_unitaire);
	}
	
	
	
	public Integer getQuantite() {
		return quantite.get();
	}
	public void setQuantite(Integer quantite) {
		this.quantite.set(quantite);
	}
	
	public String getDate() {
		return date.get();
	}
	public StringProperty getDateProperty() {
		return date;
	}
	public void setDate(String date) {
		this.date.set(date);
	}


	public String getDesignation() {
		return designation.get();
	}
	public StringProperty getDesignationProperty() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation.set(designation);
	}

}
