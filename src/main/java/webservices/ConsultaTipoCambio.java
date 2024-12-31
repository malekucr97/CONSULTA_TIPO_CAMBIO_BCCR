/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.net.ssl.HttpsURLConnection;
import models.Model_Parametros;

/**
 *
 * @author Dell
 */
@WebService(serviceName = "ConsultaTipoCambio", targetNamespace = "http://inra.com/")
public class ConsultaTipoCambio {

    @WebMethod(operationName = "Compra")
    @WebResult(name = "respuesta")
    public String Compra(@WebParam(name = "oReq", targetNamespace = "") Model_Parametros oReq) {
        
        Model_Parametros parametros = new Model_Parametros();
        String respuesta = "Respuesta Oracle WebService";
        
        parametros = oReq;
        
        URL urlHttps;
        String httpsParameters;
        
        String output;
        
        try{
            
            httpsParameters = "Indicador=" + parametros.getIndicador() + "&" + 
                    "FechaInicio=" + parametros.getFechaInicio() + "&" + 
                    "FechaFinal=" + parametros.getFechaFinal() + "&" + 
                    "Nombre=" + parametros.getNombre() + "&" + 
                    "SubNiveles=" + parametros.getSubnivel() + "&" +
                    "CorreoElectronico=" + parametros.getCorreo() + "&" + 
                    "Token=" + parametros.getToken();
            
            urlHttps = new URL("https://gee.bccr.fi.cr/Indicadores/Suscripciones/WS/wsindicadoreseconomicos.asmx/ObtenerIndicadoresEconomicos?" +  httpsParameters);
                    
            HttpsURLConnection conn = (HttpsURLConnection) urlHttps.openConnection();
            conn.setRequestMethod("GET");
            
            conn.setRequestProperty("Content-Type","text/xml; charset=UTF-8");
            conn.setRequestProperty("Https-Agent", ""); 
            conn.setRequestProperty("Dest-Port", "443"); 
            
            conn.setRequestProperty("Accept", "application/xml,text/xml,application/xhtml+xml");
            
            if (conn.getResponseCode() == 200) {
                
                InputStreamReader in = new InputStreamReader(conn.getInputStream());
                BufferedReader br = new BufferedReader(in);
                
                while ((output = br.readLine()) != null) {
                    respuesta = respuesta + output;
                }
                
                conn.disconnect();
                
            } else {
                respuesta = "Failed : HTTP Error code: " + conn.getResponseCode();
            }
                 
        } catch(IOException e){
        
            respuesta = "Exception in NetClientGet: " + e.getMessage();
        }
    
        return respuesta;
    }
}