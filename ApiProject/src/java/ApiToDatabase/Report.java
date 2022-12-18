/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApiToDatabase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.*;
import org.json.simple.parser.*;

/**
 *
 * @author kant2
 */
public class Report {
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        String path = "C:\\Users\\kant2\\report.json";
        write(path);
        readData(path);
    }
    
    
    public static void parseObject(JSONObject data) throws Exception {

        System.out.println("------------------------------------");
        //JSONObject classworkObject = (JSONObject) data.get("");
        long year = (long) data.get("year");
        long weeknum = (long) data.get("weeknum");
        long new_case = (long) data.get("new_case");
        long total_case = (long) data.get("total_case"); 
        long new_case_excludeabroad = (long) data.get("new_case_excludeabroad");
        long total_case_excludeabroad = (long) data.get("total_case_excludeabroad");
        long new_death = (long) data.get("new_death");
        long total_death = (long) data.get("total_death");
        long new_recovered = (long) data.get("new_recovered");
        long total_recovered = (long) data.get("total_recovered");
        long case_foreign = (long) data.get("case_foreign");
        long case_prison = (long) data.get("case_prison");
        long case_walkin = (long) data.get("case_walkin");
        long case_new_prev = (long) data.get("case_new_prev");
        long case_new_diff = (long) data.get("case_new_diff");
        long death_new_prev = (long) data.get("death_new_prev");
        long death_new_diff = (long) data.get("death_new_diff");
        String update_date = (String) data.get("update_date");

         insertData(year, weeknum, new_case, total_case, new_case_excludeabroad,
                total_case_excludeabroad, new_death, total_death,new_recovered,total_recovered,
                case_foreign,case_prison,
                case_walkin,case_new_prev,
                case_new_diff,death_new_prev,death_new_diff,update_date);
    }
    
    public static ResultSet insertData(long year, long weeknum, long new_case, long total_case,long new_case_excludeabroad, long total_case_excludeabroad,
              long new_death, long total_death,long new_recovered,long total_recovered,long case_foreign,long case_prison,long 
                      case_walkin ,long case_new_prev,long case_new_diff,long death_new_prev,long death_new_diff,String update_date) throws Exception {
      //Getting the connection
      String mysqlUrl = "jdbc:derby://localhost:1527/CovidReport";
      Connection con = DriverManager.getConnection(mysqlUrl, "app", "app");
      System.out.println("Connection established......");
      //Creating the Statement
      Statement statement = con.createStatement();
      //Retrieving the records
      // insert the data
      statement.executeUpdate("INSERT INTO covid19_statistics"
              + "(years, weeknum, new_case, total_case, new_case_excludeabroad,"
              + "total_case_excludeabroad,new_recovered, total_recovered, new_death, total_death,case_foreign, "
              + "case_prison, case_walkin, case_new_prev, case_new_diff, death_new_prev, death_new_diff," 
              + "update_date)"
              + "VALUES ("
              + year + ","
              + weeknum + ","
              + new_case + "," 
              + total_case + "," 
              + new_case_excludeabroad + ","
              + total_case_excludeabroad + "," 
              + new_recovered + ","
              + total_recovered + ","
              + new_death + "," 
              + total_death + ","
              + case_foreign + "," 
              + case_prison + "," 
              + case_walkin + "," 
              + case_new_prev + "," 
              + case_new_diff + "," 
              + death_new_prev + ","
              + death_new_diff + "," 
              + "'" + update_date + "'"
              + ")");
      ResultSet rs = statement.executeQuery("Select * from covid19_statistics");
      return rs;
   }
    
    public static void readData(String filepath) {
    //JSON parser object to parse read file
    JSONParser jsonParser = new JSONParser();

    try (FileReader reader = new FileReader(filepath)){
        //Read JSON file
        Object obj = jsonParser.parse(reader);

        JSONArray list = (JSONArray) obj;

        //Iterate over employee array
        list.forEach( emp -> {
            try {
                parseObject( (JSONObject) emp );
            } catch (Exception ex) {
                Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
            }
        } );

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (org.json.simple.parser.ParseException ex) { 
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        } 

   }
    
   public static void write(String filepath){
        try {
            URL url = new URL("https://covid19.ddc.moph.go.th/api/Cases/timeline-cases-all");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : "+ conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            FileWriter file = new FileWriter(filepath);
            String output;
            System.out.println("Output from Server .... \n");
            //write output to json file 
            while ((output = br.readLine()) != null) {
               System.out.println(output);
               file.write(output);
            }
            file.close();

            System.out.println("JSON file created......");
            conn.disconnect();

        } catch (MalformedURLException e) {
           e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}
