package controlleur.donnee;





import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {
	private  StringProperty code;
	private  StringProperty nom;
	private  StringProperty prenom;
	private  StringProperty ville;
	private   StringProperty code_postal;
	private  StringProperty addresse;
	private  StringProperty mobile;
	private  StringProperty email;
	private  StringProperty tel;
	private  StringProperty remarque ;
	private  IntegerProperty carte_fidele;
	private  StringProperty date;
	
	
	
	public Client() {
	}

	public Client( String code,String nom,String prenom,String ville,String code_postal,String addresse,String mobile,
			String email,String remarque,String tel,Integer a,String temp) 
	{
		this.code=new SimpleStringProperty(code);
		this.nom=new SimpleStringProperty(nom);
		this.prenom=new SimpleStringProperty(prenom);
		this.ville=new SimpleStringProperty(ville);
		this.code_postal=new SimpleStringProperty(code_postal);
		this.mobile=new SimpleStringProperty(mobile);
		this.addresse=new SimpleStringProperty(addresse);
		this.tel=new SimpleStringProperty(tel);
		this.email=new SimpleStringProperty(email);
		this.remarque=new SimpleStringProperty(remarque);
		this.carte_fidele=new SimpleIntegerProperty(a);
		this.date=new SimpleStringProperty(temp);
	}

public String getCode() {
	return code.get();
	}

public void setCode(String esr) {
	this.code.set(esr);
}
public StringProperty getPropertyCode() {
	return code;
}

public String getNom() {
	return nom.get();}

public void setNom(String nom) {
	this.nom.set(nom);
}
public StringProperty getPropertyNom() {
	return nom;
}

public String getPrenom() {
	return prenom.get();}

public void setPrenom(String esr) {
	this.prenom.set(esr);
}
public StringProperty getPropertyPrenom() {
	return prenom;
}

public String getVille() {
	return ville.get();}

public void setVille(String esr) {
	this.ville.set(esr);
}
public StringProperty getPropertyVille() {
	return ville;
}
public String getAddresse() {
	return addresse.get();}

public void setAddresse(String esr) {
	this.addresse.set(esr);
}
public StringProperty getPropertyAddresse() {
	return addresse;
}

public String getMobile() {
	return mobile.get();}

public void setMobile(String esr) {
	this.mobile.set(esr);
}
public StringProperty getPropertyMobile() {
	return mobile;
}
public Integer getCarteF() {
	return carte_fidele.get();}

public void setCarteF(Integer esr) {
	this.carte_fidele.set(esr);
}
public IntegerProperty getPropertyCarte() {
	return carte_fidele;
}
public String getTel() {
	return tel.get();}

public void setTel(String esr) {
	this.tel.set(esr);
}
public StringProperty getPropertyTel() {
	return tel;
}

public String getEmail() {
	return email.get();}

public void setEmail(String esr) {
	this.email.set(esr);
}
public StringProperty getPropertyEmail() {
	return email;
}

public String getRemarque() {
	return remarque.get();}

public void setRemarque(String esr) {
	this.remarque.set(esr);
}
public StringProperty getPropertyRemarque() {
	return remarque;
}
public String getDate() {
	return date.get();}
public void setDate(String esr) {
	this.date.set(esr);
}
public StringProperty getPropertyDate() {
	return date;
}
public String getCode_postal() {
	return code_postal.get();
}
public void setCode_postal(String ert) {
	this.code_postal.set(ert);
}
public StringProperty getPropertyCode_postal() {
	return code_postal;
}
/*public Integer getCarte() {
return carte_fidele.get();}

public void setCarte(Integer esr) {
this.carte_fidele.set(esr);
}
public SimpleIntegerProperty getPropertyCarte() {
return carte_fidele ;
}*/

}
