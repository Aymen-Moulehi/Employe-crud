package org.example.employe;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("employe")
public class EmployeResource {

    public static List<Employe> employes = new ArrayList<Employe>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employe> getAllEmployees() {
        return employes;
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(MediaType.APPLICATION_JSON)
    public Employe createEmployee(Employe employe) {
        employes.add(employe);
        return employe;
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(MediaType.APPLICATION_JSON)
    public Employe updateEmployee(Employe employe) {
       if(employes.remove(employe))
           employes.add(employe);
        return employe;
    }

    @DELETE
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteEmployeeByID(Integer id) {
        return employes.removeIf(employe -> employe.getId() == id);
    }

    @GET
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(MediaType.APPLICATION_JSON)
    public Employe findEmployeeByID(@PathParam("id") String id) {
        return employes.stream().filter(employe -> employe.getId() == Integer.parseInt(id)).findAny().get();
    }

}
