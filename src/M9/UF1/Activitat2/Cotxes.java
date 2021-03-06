package M9.UF1.Activitat2;
/**
 *
 * @author alexp
 */
import java.io.Serializable;

public class Cotxes implements Serializable {
   
    private String marca;
    private String model;
    private int any;
    private String matricula;
    
   public Cotxes(String marca,String model,int any, String matricula){
       this.marca=marca;
       this.model=model;
       this.any=any;
       this.matricula=matricula;
   }

    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
}
