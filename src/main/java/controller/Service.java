package controller;

import database.ConnectionMySQL;
import model.Customers;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Path("/customers")
public class Service {
    Connection con;
    PreparedStatement pstm;
    Statement statement;
    ResultSet rs;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customers> getCustomers() {
        List<Customers> customer = new ArrayList<>();
        try {
            con = ConnectionMySQL.getConnection();
            String query = "SELECT customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit FROM customers";
            statement = con.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                Customers customers = new Customers();
                customers.setCustomerNumber(rs.getInt("customerNumber"));
                customers.setCustomerName(rs.getString("customerName"));
                customers.setContactLastName(rs.getString("contactLastName"));
                customers.setContactFirstName(rs.getString("contactFirstName"));
                customers.setPhone(rs.getString("phone"));
                customers.setAddressLine1(rs.getString("addressLine1"));
                customers.setAddressLine2(rs.getString("addressLine2"));
                customers.setCity(rs.getString("city"));
                customers.setState(rs.getString("state"));
                customers.setPostalCode(rs.getString("postalCode"));
                customers.setCountry(rs.getString("country"));
                customers.setSalesRepEmployeeNumber(rs.getInt("salesRepEmployeeNumber"));
                customers.setCreditLimit(rs.getDouble("creditLimit"));
                customer.add(customers);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection();
        }
        return customer;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customers getCustomers(@PathParam("id") int customerNumber) {
        Customers customers = new Customers();
        try {
            con = ConnectionMySQL.getConnection();
            String query = "SELECT customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit FROM customers WHERE customerNumber=?";
            pstm = con.prepareStatement(query);
            pstm.setInt(1, customerNumber);
            rs = pstm.executeQuery();
            if (rs.next()) {
                customers.setCustomerNumber(rs.getInt("customerNumber"));
                customers.setCustomerName(rs.getString("customerName"));
                customers.setContactLastName(rs.getString("contactLastName"));
                customers.setContactFirstName(rs.getString("contactFirstName"));
                customers.setPhone(rs.getString("phone"));
                customers.setAddressLine1(rs.getString("addressLine1"));
                customers.setAddressLine2(rs.getString("addressLine2"));
                customers.setCity(rs.getString("city"));
                customers.setState(rs.getString("state"));
                customers.setPostalCode(rs.getString("postalCode"));
                customers.setCountry(rs.getString("country"));
                customers.setSalesRepEmployeeNumber(rs.getInt("salesRepEmployeeNumber"));
                customers.setCreditLimit(rs.getDouble("creditLimit"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection();
        }
        return customers;
    }

    @POST
    @Path("/{customerNumber}/{customerName}/{contactLastName}/{contactFirstName}/{phone}/{addressLine1}/{addressLine2}/{city}/{state}/{postalCode}/{country}/{salesRepEmployeeNumber}/{creditLimit}")
    @Produces(MediaType.APPLICATION_JSON)
    public String create(@PathParam("customerNumber") int customerNumber, @PathParam("customerName") String customerName, @PathParam("contactLastName") String contactLastName,
                         @PathParam("contactFirstName") String contactFirstName, @PathParam("phone") String phone, @PathParam("addressLine1") String addressLine1,
                         @PathParam("addressLine2") String addressLine2,
                         @PathParam("city") String city,
                         @PathParam("state") String state,
                         @PathParam("postalCode") String postalCode,
                         @PathParam("country") String country,
                         @PathParam("salesRepEmployeeNumber") int salesRepEmployeeNumber,
                         @PathParam("creditLimit") double creditLimit) {
        String stat = "...";
        try {
            con = ConnectionMySQL.getConnection();
            String query = "INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, customerNumber);
            pstm.setString(2, customerName);
            pstm.setString(3, contactLastName);
            pstm.setString(4, contactFirstName);
            pstm.setString(5, phone);
            pstm.setString(6, addressLine1);
            pstm.setString(7, addressLine2);
            pstm.setString(8, city);
            pstm.setString(9, state);
            pstm.setString(10, postalCode);
            pstm.setString(11, country);
            pstm.setInt(12, salesRepEmployeeNumber);
            pstm.setDouble(13, creditLimit);
            if (pstm.executeUpdate() == 1) {
                stat = "El registro fue exitoso";
            } else {
                stat = "ERROR...";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection();
        }
        return stat;
    }

    @PUT
    @Path("/{customerNumber}/{customerName}/{contactLastName}/{contactFirstName}/{phone}/{addressLine1}/{addressLine2}/{city}/{state}/{postalCode}/{country}/{salesRepEmployeeNumber}/{creditLimit}")
    @Produces(MediaType.APPLICATION_JSON)
    public String update(@PathParam("customerNumber") int customerNumber, @PathParam("customerName") String customerName, @PathParam("contactLastName") String contactLastName,
                         @PathParam("contactFirstName") String contactFirstName, @PathParam("phone") String phone, @PathParam("addressLine1") String addressLine1,
                         @PathParam("addressLine2") String addressLine2,
                         @PathParam("city") String city,
                         @PathParam("state") String state,
                         @PathParam("postalCode") String postalCode,
                         @PathParam("country") String country,
                         @PathParam("salesRepEmployeeNumber") int salesRepEmployeeNumber,
                         @PathParam("creditLimit") double creditLimit) {
        String stat = "...";
        try {
            con = ConnectionMySQL.getConnection();
            String query = "UPDATE customers SET customerName = ?, contactLastName = ?, contactFirstName = ?, phone = ?, addressLine1 = ?, addressLine2 = ?, city = ?, state = ?, postalCode = ?, country = ?, salesRepEmployeeNumber = ?, creditLimit = ? WHERE customerNumber = ?";
            pstm = con.prepareStatement(query);
            pstm.setString(1, customerName);
            pstm.setString(2, contactLastName);
            pstm.setString(3, contactFirstName);
            pstm.setString(4, phone);
            pstm.setString(5, addressLine1);
            pstm.setString(6, addressLine2);
            pstm.setString(7, city);
            pstm.setString(8, state);
            pstm.setString(9, postalCode);
            pstm.setString(10, country);
            pstm.setInt(11, salesRepEmployeeNumber);
            pstm.setDouble(12, creditLimit);
            pstm.setInt(13, customerNumber);
            if (pstm.executeUpdate() == 1) {
                stat = "La actualizacion fue exitosa";
            } else {
                stat = "ERROR...";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection();
        }
        return stat;
    }

    @DELETE
    @Path("/{customerNumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("customerNumber") int customerNumber) {
        String stat = "...";
        try {
            con = ConnectionMySQL.getConnection();
            String query = "DELETE FROM customers WHERE customerNumber = ?";
            pstm = con.prepareStatement(query);
            pstm.setInt(1, customerNumber);
            if (pstm.executeUpdate() == 1) {
                stat = "La eliminacion fue exitosa";
            } else {
                stat = "ERROR...";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection();
        }
        return stat;
    }


    public void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

}
