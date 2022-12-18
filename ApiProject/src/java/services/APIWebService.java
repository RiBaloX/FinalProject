/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Covid19Statistics;

/**
 *
 * @author kant2
 */
@WebService(serviceName = "APIWebService")
public class APIWebService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ApiProjectPU");
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "Find_case_by_weeknum")
     public  List<model.Covid19Statistics> Find_case_by_weeknum(@WebParam(name = "weeknum") int weeknum) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ApiProjectPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Covid19Statistics.findByWeeknum");
        query.setParameter("weeknum", weeknum);
        List<model.Covid19Statistics> cc = (List<model.Covid19Statistics>) query.getResultList();
        em.close();
        return cc;
    }  
}
