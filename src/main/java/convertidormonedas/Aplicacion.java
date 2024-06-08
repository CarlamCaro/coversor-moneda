
package convertidormonedas;

import java.util.ArrayList;


public class Aplicacion {
    
    private ArrayList<Convertidor> listaConverticiones;
    

    public Aplicacion() {
        this.listaConverticiones = new ArrayList<>();
    }
    
    public void agragarRegistro(Convertidor registro){
        if (registro.getCodigoBase() != null && registro.getCodigoDestino()!= null) {
            listaConverticiones.add(registro);
        }
    }
    
    public void mostrarLista(){
        for (Convertidor listaConverticione : listaConverticiones) {
            System.out.println(listaConverticione.getCantidadConvetir()+" "+ listaConverticione.getCodigoBase()+" Equivalen a : "+ listaConverticione.getCantidadConvetida()+" "+listaConverticione.getCodigoDestino());
            }        
        }

    @Override
    public String toString() {
        return "Aplicacion{" + ", listaConverticiones=" + listaConverticiones + '}';
    }
    
}
