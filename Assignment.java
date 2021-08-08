/**
 * Write a description of Assignment here.
 * 
 * @author (your naersion number or a date)
 *me) 
 * @version 
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class Assignment {
    public void Tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
//        String countryInfo = countryInfo(parser, "Nauru");
//        System.out.println(countryInfo);
//        listExportersTwoProducts(parser, "gold", "diamonds");
        bigExporters(parser,"$1000,000,000,000");
//        System.out.println(numberOfExporters(parser, "gold"));        
    } 

    public String countryInfo(CSVParser parser, String country){
        String result = "";
        for(CSVRecord record : parser){
            String s = record.get("Country");  
            if(s.compareTo(country)==0){
                String s1 = record.get("Exports");
                String s2 = record.get("Value (dollars)");
                if(s1.isEmpty() && s2.isEmpty()){
                    result = "NOT FOUND";
                    break;
                }
                result = s +": "+s1+": "+s2; 
            }
        }
        return result; 
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        for(CSVRecord record : parser){
            String s1 = record.get("Exports");
            int check1 = s1.indexOf(exportItem1);
            int check2 = s1.indexOf(exportItem2);
            if(check1 !=-1 && check2 != -1){
                System.out.println(record.get("Country"));
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        int count = 0; 
        for(CSVRecord record : parser){
           int check = record.get("Exports").indexOf(exportItem);
           if(check != -1){
               count++;
           }
        }
        return count;
    }

    public void bigExporters(CSVParser parser, String amount){
        String amountNew = amount.replaceAll("[^0-9]","");        
        long amountInt = Long.parseLong(amountNew);
        for(CSVRecord record : parser){
            String s = record.get("Value (dollars)");            
            String s1 = s.replaceAll("[^0-9]", "");            
            long value = Long.parseLong(s1);
            if(amountInt <= value){
                System.out.println(record.get("Country")+" "+record.get("Value (dollars)"));
            }                         
        }        
    }    
}