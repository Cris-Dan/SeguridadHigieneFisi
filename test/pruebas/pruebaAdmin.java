/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import com.mycompany.dao.AdministratorDao;
import com.mycompany.dao.Dao;
import com.mycompany.models.Administrator;
import java.util.List;

/**
 *
 * @author cristian
 */
public class pruebaAdmin {

    public static void main(String[] args) {
        Dao admindao = new AdministratorDao();
        /*Administrator ad = new Administrator();
        ad.setEmail("curly@awa.com");
        ad.setFirstname("curly");
        ad.setLastname("qwerty");
        ad.setPassword("opresor");
        admindao.save(ad);*/
        
        
        
        /*Administrator ad = new Administrator();
        ad.setEmail("curlya@awa.com");
        ad.setFirstname("modificado");
        ad.setLastname("qwerty");
        ad.setPassword("opresor");
        ad.setIdAdministrator(1);
        admindao.update(ad);*/
        
        admindao.delete(1);
        
        List<Administrator> lista = admindao.getAll();
        for (Administrator administrator : lista) {
            System.out.println(administrator.getFirstname()+" id: "+administrator.getIdAdministrator());
            
        }
        
        
    }
}
