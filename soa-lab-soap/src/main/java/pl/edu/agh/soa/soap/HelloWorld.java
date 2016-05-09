package pl.edu.agh.soa.soap;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jboss.ejb3.annotation.SecurityDomain;
import org.jboss.ws.api.annotation.AuthMethod;
import org.jboss.ws.api.annotation.TransportGuarantee;
import org.jboss.ws.api.annotation.WebContext;

@Stateless
@SecurityDomain("other")
@WebContext(authMethod = "BASIC",transportGuarantee = "NONE")
@RolesAllowed("managers")
@WebService
public class HelloWorld {

    Student marcin=new Student("Marcin","Jedrzejczyk","AGH",1994);
    Student darek=new Student("D","D","UJ",1994);

    List<Student> studentList=new ArrayList<>(Arrays.asList(marcin,darek));


    @WebMethod
    public String hello(@WebParam(name = "name") String name) {
        return "Hello " + name;
    }


    @XmlElementWrapper(name="Studenci")
    @XmlElement(name="Student")
    @WebMethod
    public List<Student> getStudentList(){
        return studentList;
    }
    @WebMethod
    public String zwrocCos() {
        return marcin.getName();
    }


}
