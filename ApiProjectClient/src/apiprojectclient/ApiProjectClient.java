/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apiprojectclient;

import java.util.List;
import services.Covid19Statistics;

/**
 *
 * @author kant2
 */
public class ApiProjectClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List <Covid19Statistics> Covid = findCaseByWeeknum(5);
        for(Covid19Statistics value : Covid) {
        System.out.println(value.getCaseForeign());
        System.out.println(value.getCaseWalkin());
        }
        
    }

    private static java.util.List<services.Covid19Statistics> findCaseByWeeknum(int weeknum) {
        services.APIWebService_Service service = new services.APIWebService_Service();
        services.APIWebService port = service.getAPIWebServicePort();
        return port.findCaseByWeeknum(weeknum);
    }
    
}
