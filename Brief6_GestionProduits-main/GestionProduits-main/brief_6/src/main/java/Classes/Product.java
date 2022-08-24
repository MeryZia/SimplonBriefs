package Classes;


public class Product {
	protected int idp;

	protected String titre;
	protected String  description;
	protected float  prix;
	protected int idc;
	
	public Product() {
		super();
	}
	public Product (int idp,String titre,String  description,float  prix) {
		super();
		this.idp=idp;
		this.titre=titre;
		this.description=description;
		this.prix=prix;
	}
	
	public Product(int idp, String titre, String description, float prix, int idc) {
		super();
		this.idp = idp;
		this.titre = titre;
		this.description = description;
		this.prix = prix;
		this.idc = idc;
	}
	
	public int getIdp() {
		return idp;
	}
	public void setIdp(int idp) {
		this.idp = idp;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getIdc() {
		return idc;
	}
	public void setIdc(int idc) {
		this.idc = idc;
	}

	@Override
	public String toString() {
		return  + idp + " | " + titre + "   | " + description + " | " + prix
				+  " | " + idc;
	}
	
}
