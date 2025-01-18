import javax.swing.*;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;



public class Conversor {

    public static void main(String[] args) {    
    
    // Opciones a elegir ya sea de temperatura o de divisas   
    String[] optionsConversiones = { "Conversor de moneda", "Conversor de temperatura"};
    String[] optionsdivisas = { "De Pesos Colombianos a Dólares", "De Pesos Colombianos a Euros", "De Pesos Colombianos a Libras Esterlinas", "De Pesos Colombianos a Won sul-coreano", "De  Yen Japonés a Pesos Colombianos", "De Dólares a Pesos Colombianos", "De Euros a Pesos Colombianos", "De Libras Esterlinas a Pesos Colombianos", "De Wol sul-coreano a Pesos Colombianos", "De Yen Japonés a Pesos Colombianos"};
    String[] optionsTempConversion = { "Centigrados a Fahrenheit" , "Fahrenheit a Centigrados" };

    // Valor entero para confirmar salida del programa
    int confirm = 1;
    

    while(confirm == 1 || confirm == 2) {
            var conversor = JOptionPane.showInputDialog(
                null,
                "Selecciona que conversor utilizar",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsConversiones,
                optionsConversiones[0]);

            if (conversor == null) {
                confirm =  0;
            }

        // Conversor de divisas ------------------------------------------------------------------------------------
        if (conversor == "Conversor de moneda") {          
                var divisa = JOptionPane.showInputDialog(
                    null,
                    "Selecciona la divisa a la cual quieres convertir",
                    "Divisas",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    optionsdivisas,
                    optionsdivisas[0]);

                String divisaResultado = (String)divisa;

            var cantidad = JOptionPane.showInputDialog(
                null,
                "Selecciona que monto a convertir",
                "Monto",
                0);
                System.out.println(cantidad);

            

            // Operacion de conversión basado en la seleccion de divisas
            try {          
                NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
                float monto = Integer.parseInt(cantidad);

                if (monto > 0) {
                       switch (divisaResultado) {
                    case "De Pesos Colombianos a Dólares":  
                        JOptionPane.showMessageDialog(null, nf.format(monto*ExchangeRates.colusa));
                        break;
                    case "De Pesos Colombianos a Euros": 
                        nf.setCurrency(Currency.getInstance("EUR"));
                        JOptionPane.showMessageDialog(null, nf.format(monto*ExchangeRates.coleur));
                        break;
                    case "De Pesos Colombianos a Libras Esterlinas": 
                        nf.setCurrency(Currency.getInstance("GBP"));
                        JOptionPane.showMessageDialog(null, nf.format(monto*ExchangeRates.colgbp));
                        break;
                    case "De Pesos Colombianos a Won sul-coreano": 
                        nf.setCurrency(Currency.getInstance("KRW"));
                        JOptionPane.showMessageDialog(null, nf.format(monto*ExchangeRates.colwol));
                        break;
                    case "De Pesos Colombianos a Yen Japonés": 
                        nf.setCurrency(Currency.getInstance("JPY"));
                        JOptionPane.showMessageDialog(null, nf.format(monto*ExchangeRates.colyen));
                        break;
                    case "De Dólares a Pesos Colombianos":  
                        nf.setCurrency(Currency.getInstance("COP"));
                        JOptionPane.showMessageDialog(null, nf.format(monto*ExchangeRates.usacol));
                        break;
                    case "De Euros a Pesos Colombianos": 
                        nf.setCurrency(Currency.getInstance("COP"));
                        JOptionPane.showMessageDialog(null, nf.format(monto*ExchangeRates.eurcol));
                        break;
                    case "De Libras Esterlinas a Pesos Colombianos": 
                        nf.setCurrency(Currency.getInstance("COP"));
                        JOptionPane.showMessageDialog(null, nf.format(monto*ExchangeRates.gbpcol));
                        break;
                    case "De Won sul-coreano a Pesos Colombianos": 
                        nf.setCurrency(Currency.getInstance("COP"));
                        JOptionPane.showMessageDialog(null, nf.format(monto*ExchangeRates.wolcol));
                        break;
                    case "De Yen Japonés a Pesos Colombianos": 
                        nf.setCurrency(Currency.getInstance("COP"));
                        JOptionPane.showMessageDialog(null, nf.format(monto*ExchangeRates.yencol));
                        break;
                    default:
                    JOptionPane.showMessageDialog(null, "No ingresaste un valor conocido amigo, intenta otra vez");
                    break;
                }  

            } else {
                JOptionPane.showMessageDialog(null, "No ingresaste un valor conocido amigo, intenta otra vez");
            }
               

            } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor de tipo inválido");
                confirm = 1;
            }
            confirm = JOptionPane.showConfirmDialog(null,"¿Te gustaría salir programa?");
            
            }
             

            // Si conversor es de temperatura se aplica esto
            else if(conversor == "Conversor de temperatura") {

                var temp = JOptionPane.showInputDialog(
                null,
                "Selecciona la temperatura a convertir",
                "Temperatura",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsTempConversion,
                optionsTempConversion[0]);
                
            if (temp == null) {
                confirm = 0;
            }   

            var valorTemp = JOptionPane.showInputDialog(
                null,
                "Ingresa la temperatura",
                "Temperatura");          


           try {
            float valorTempStr = Integer.parseInt(valorTemp);   
            String temperatura = (String)temp;
            if (valorTempStr > 0) {
                switch (temperatura) {
                case "Centigrados a Fahrenheit":
                    float CelsiusFarenheit = ((9*valorTempStr)/5)+32;
                    JOptionPane.showMessageDialog(null, CelsiusFarenheit + " grados farenheit");
                    break;
                case "Fahrenheit a Centigrados":
                    float FarenheitCelsius = (valorTempStr - 32)*5/9;
                    JOptionPane.showMessageDialog(null, FarenheitCelsius + " grados celcius");
                    break;
                default:
                JOptionPane.showMessageDialog(null,"No ingresaste un valor conocido amigo, intenta otra vez");
                    break;
            }
            } else {
                JOptionPane.showMessageDialog(null, "No ingresaste un valor conocido amigo, intenta otra vez");
            }
            
            

           } catch (java.lang.NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"No ingresaste un valor de tipo número, intenta otra vez");
                
           }
        
        confirm = JOptionPane.showConfirmDialog(null,"¿Te gustaría salir programa?");
            }
    }
            JOptionPane.showMessageDialog(null, "Programa terminado exitosamente!");
                
        }

    class ExchangeRates {

        public static float colusa = 0.000206528f;
        public static float usacol = 4841.97f;

        public static float coleur =  0.000195776f;
        public static float  eurcol=  5108.20f;

        public static float colgbp  =  0.000172832f;
        public static float gbpcol= 5785.98f;

        public static float wolcol = 0.271548f;
        public static float colwol  =  3.6827f; 

        public static float yencol = 0.0281865f;
        public static float colyen =  35.478f;

    }

    } 
    

