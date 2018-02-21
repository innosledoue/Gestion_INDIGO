package controlleur.donnee;
public class Personne {
	private String speudo;
	private String mot_passe;
	private Integer code;
	
	public Personne() {
		this.speudo=null;
		this.mot_passe=null;
		this.code=null;
	}
	public Personne(Integer z,String et,String es) {
		this.code=z;
		this.speudo=et;
		this.mot_passe= es;
	}
public String getspeudo() {
	return speudo;
}
	public void setSpeudo(String speudo) {
		this.speudo=speudo;
	}
	public String getMot_passe() {
		return mot_passe;
	}
	public void setMot_passe(String mot_passe) {
		this.mot_passe=mot_passe;
	}
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	
	
	
	
	
}
