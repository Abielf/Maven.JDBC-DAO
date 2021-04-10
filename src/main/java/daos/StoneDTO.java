package daos;

public class StoneDTO implements DTO{
    private int id;
    private String make;
    private String model;
    private String color;
    private int vin;

    public StoneDTO() {
    }

    public StoneDTO(String mak, String mod, String col, int v) {
        this.make=mak;
        this.model=mod;
        this.color=col;
        this.vin=v;
    }

    public StoneDTO(Integer id, String mak, String mod, String col, int v) {
        this.id = id;
        this.make=mak;
        this.model=mod;
        this.color=col;
        this.vin=v;
    }

    //The getters
    public int getid(){return id;}
    public String getMake(){return make;}
    public String getModel(){return model;}
    public String getColor(){return color;}
    public Integer getVin(){return vin;}

    public void setId(int id){this.id=id;}
    public void setMake(String mak){make = mak;}
    public void setModel(String mod){model=mod;}
    public void setColor(String col){color=col;}
    public void setVin(int v){vin=v;}


}
