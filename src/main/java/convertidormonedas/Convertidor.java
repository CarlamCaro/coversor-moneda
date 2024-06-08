
package convertidormonedas;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;


public class Convertidor {
    
    @SerializedName("base_code")
    private String codigoBase;
    @SerializedName("target_code")
    private String codigoDestino;
    @SerializedName("conversion_result")
    private double cantidadConvetida;
    private double cantidadConvetir;
    private ApiConection apiConection;

    public Convertidor() {
        this.apiConection = new ApiConection();
//       
    }

    public void setCantidadConvetir(double cantidadConvetir) {
        this.cantidadConvetir = cantidadConvetir;
    }
    
    public String getCodigoBase() {
        return codigoBase;
    }

    public String getCodigoDestino() {
        return codigoDestino;
    }

    public double getCantidadConvetida() {
        return cantidadConvetida;
    }
    
     public double getCantidadConvetir() {
        return cantidadConvetir;
    }
    
    public Convertidor convertirMoneda(String codigoBase, String codigoDestino, double cantidadConvertir) throws Exception{
       
        String key = "b4ae269c7269b60922ac1c4f";
        String url = "https://v6.exchangerate-api.com/v6/" + key +"/pair/" + codigoBase+"/"+ codigoDestino +"/"+ cantidadConvertir ;
                
        String jsonRespuesta = apiConection.getApiResponse(url);
               
        Gson gson = new Gson();
        Convertidor miConver = gson.fromJson(jsonRespuesta, Convertidor.class);
        
        if (validarRespuesta( miConver )) {
            miConver.setCantidadConvetir(cantidadConvertir);
            mostrarValor(miConver, cantidadConvertir);
        } else {
            System.out.println(" El codigo base o codigo destino no son parte de la lista...");
        }
        
        return miConver;
    }

    private void mostrarValor(Convertidor convertido, double  cantidad){
        System.out.println(cantidad + " " + convertido.codigoBase+ " = "+convertido.cantidadConvetida+" "+convertido.codigoDestino);
        
    }
    

    @Override
    public String toString() {
        return "Convertidor{" + "codigoBase=" + codigoBase + ", codigoDestino=" + codigoDestino + ", cantidadConvetida=" + cantidadConvetida +  '}';
    }

    private boolean validarRespuesta(Convertidor miConver) {
        boolean isVerdadero= false;
        if (miConver.getCodigoBase() != null &&   miConver.getCodigoDestino()!= null) {
            isVerdadero = true ; 
        }
        return isVerdadero;
    }
    
    
}
