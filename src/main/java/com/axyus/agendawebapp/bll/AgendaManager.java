package com.axyus.agendawebapp.bll;

import com.axyus.agendawebapp.bo.Address;
import com.axyus.agendawebapp.bo.Customer;
import com.axyus.agendawebapp.utils.JdbcUtils;
import com.axyus.jdbc.PStmtBinder;
import com.axyus.jdbc.RowMapper;
import com.axyus.jdbc.pool.PoolManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgendaManager {

    //Get all customers
    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> allCustomers = new ArrayList<>();
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            final StringBuilder sql = new StringBuilder();
            final PStmtBinder.SimplePStmtBinderBuilder binder = new PStmtBinder.SimplePStmtBinderBuilder();
            sql.append("SELECT * \n ");
            sql.append("    FROM \n");
            sql.append("        customers");
            sql.append("           ORDER BY customer_id ASC");
            allCustomers = (List<Customer>) JdbcUtils.queryObjects(connection, sql.toString(), new RowMapper.ClassRowMapper(Customer.class));
        }
        return allCustomers;
    }

    //Get all Addresses
    public List<Address> getAllAddresses() throws SQLException {
        List<Address> allAddresses = new ArrayList<>();
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            final StringBuilder sql = new StringBuilder();
            final PStmtBinder.SimplePStmtBinderBuilder binder = new PStmtBinder.SimplePStmtBinderBuilder();
            sql.append("SELECT * \n ");
            sql.append("    FROM \n");
            sql.append("        addresses");
            allAddresses = (List<Address>) JdbcUtils.queryObjects(connection, sql.toString(), new RowMapper.ClassRowMapper(Address.class));
        }
        return allAddresses;
    }

    //get all data
    public List<Customer> getAlldata() throws SQLException {
        List<Customer> allData = new ArrayList<>();
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            final StringBuilder sql = new StringBuilder();
            final PStmtBinder.SimplePStmtBinderBuilder binder = new PStmtBinder.SimplePStmtBinderBuilder();
            sql.append("SELECT \n");
            sql.append("    c.customer_id, c.lst_name, c.first_name, c.username, c.email, c.phone_number, c.address_id, \n");
            sql.append("        a.street_number, a.street_name, a.city, a.postal_code, a.country \n");
            sql.append("            FROM \n");
            sql.append("                customers c \n");
            sql.append("                    INNER JOIN \n");
            sql.append("                            addresses a \n");
            sql.append("                                on c.address_id = a.address_id");
            allData = (List<Customer>) JdbcUtils.queryObjects(connection, sql.toString(), new RowMapper.ClassRowMapper(Customer.class));
        }
        return allData;

    }

    //Create Customer
    public void createCustomer(Customer customer) throws SQLException {
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            final StringBuilder sql = new StringBuilder();
            final PStmtBinder.SimplePStmtBinderBuilder binder = new PStmtBinder.SimplePStmtBinderBuilder();
            sql.append(" INSERT INTO \n");
            sql.append("    customers \n");
            sql.append("        (lst_name, first_name, username, email, phone_number, address_id) \n");
            sql.append("            VALUES(?,?,?,?,?,?)");
            binder.add(customer.getLastName());
            binder.add(customer.getFirstName());
            binder.add(customer.getUsername());
            binder.add(customer.getEmail());
            binder.add(customer.getPhoneNumber());
            binder.add(customer.getAddressId());
            JdbcUtils.executeUpdate(connection, sql.toString(), binder.toPStmtBinder());
            connection.commit();
        }
    }

    //Create Address
    public Integer createAddress(Address address) throws SQLException {
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            final StringBuilder sql = new StringBuilder();
            final PStmtBinder.SimplePStmtBinderBuilder binder = new PStmtBinder.SimplePStmtBinderBuilder();
            sql.append(" INSERT INTO \n");
            sql.append("    addresses \n");
            sql.append("        (street_number, street_name, city, postal_code, country) \n");
            sql.append("            VALUES(?,?,?,?,?)");
            binder.add(address.getStreetNumber());
            binder.add(address.getStreetName());
            binder.add(address.getCity());
            binder.add(address.getPostalCode());
            binder.add(address.getCountry());
            JdbcUtils.executeUpdate(connection, sql.toString(), binder.toPStmtBinder());
            connection.commit();
        }
        return address.getAddressId();
    }

    //Update Customer 
    public Customer updateCustomer(Customer customer) throws SQLException {
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            final StringBuilder sql = new StringBuilder();
            final PStmtBinder.SimplePStmtBinderBuilder binder = new PStmtBinder.SimplePStmtBinderBuilder();
            sql.append(" UPDATE \n");
            sql.append("    customers \n");
            sql.append("        SET lst_name=?, \n");
            binder.add(customer.getLastName());
            sql.append("            first_name=?, \n");
            binder.add(customer.getFirstName());
            sql.append("                username=?, \n");
            binder.add(customer.getUsername());
            sql.append("                    email=?, \n");
            binder.add(customer.getEmail());
            sql.append("                        phone_number=? \n");
            binder.add(customer.getPhoneNumber());
            sql.append("                            WHERE \n");
            sql.append("                                customer_id=?");
            binder.add(customer.getCustomerId());
            JdbcUtils.executeUpdate(connection, sql.toString(), binder.toPStmtBinder());
            connection.commit();
        }
        return customer;
    }

    //Update Address 
    public Address updateAddress(Address address) throws SQLException {
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            final StringBuilder sql = new StringBuilder();
            final PStmtBinder.SimplePStmtBinderBuilder binder = new PStmtBinder.SimplePStmtBinderBuilder();
            sql.append(" UPDATE \n");
            sql.append("    addresses \n");
            sql.append("        SET street_number=?, \n");
            binder.add(address.getStreetNumber());
            sql.append("            street_name=?, \n");
            binder.add(address.getStreetName());
            sql.append("                city=?, \n");
            binder.add(address.getCity());
            sql.append("                    postal_code=?, \n");
            binder.add(address.getPostalCode());
            sql.append("                        country=? \n");
            binder.add(address.getCountry());
            sql.append("                            WHERE \n");
            sql.append("                                address_id=?");
            binder.add(address.getAddressId());
            JdbcUtils.executeUpdate(connection, sql.toString(), binder.toPStmtBinder());
            connection.commit();
        }
        return address;
    }

    //delete customer by id
    public void deleteById(int id) throws SQLException {
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            final StringBuilder sql = new StringBuilder();
            final PStmtBinder.SimplePStmtBinderBuilder binder = new PStmtBinder.SimplePStmtBinderBuilder();
            sql.append(" DELETE FROM \n");
            sql.append("    customers \n");
            sql.append("        WHERE \n");
            sql.append("            customer_id=? \n");
            binder.add(id);
            JdbcUtils.executeUpdate(connection, sql.toString(), binder.toPStmtBinder());
            connection.commit();
        }
    }

    //delete address by id
    public void deleteAddressById(int id) throws SQLException {
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            final StringBuilder sql = new StringBuilder();
            final PStmtBinder.SimplePStmtBinderBuilder binder = new PStmtBinder.SimplePStmtBinderBuilder();
            sql.append(" DELETE FROM \n");
            sql.append("    addresses \n");
            sql.append("        WHERE \n");
            sql.append("            address_id=? \n");
            binder.add(id);
            JdbcUtils.executeUpdate(connection, sql.toString(), binder.toPStmtBinder());
            connection.commit();
        }
    }

    //get customer by id
    public Customer findCustomerbyId(int customerId) throws SQLException {
        Customer customer = new Customer();
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            final StringBuilder sql = new StringBuilder();
            final PStmtBinder.SimplePStmtBinderBuilder binder = new PStmtBinder.SimplePStmtBinderBuilder();
            sql.append(" SELECT * FROM \n");
            sql.append("    customers \n");
            sql.append("        WHERE \n");
            sql.append("            customer_id=? \n");
            binder.add(customerId);
            customer = (Customer) JdbcUtils.queryObject(connection, sql.toString(), new RowMapper.ClassRowMapper(Customer.class), binder.toPStmtBinder());
            connection.commit();
        }
        return customer;
    }

    //get address by id
    public Address findAddressbyId(int addressId) throws SQLException {
        Address address = new Address();
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            final StringBuilder sql = new StringBuilder();
            final PStmtBinder.SimplePStmtBinderBuilder binder = new PStmtBinder.SimplePStmtBinderBuilder();
            sql.append(" SELECT * FROM \n");
            sql.append("    addresses \n");
            sql.append("        WHERE \n");
            sql.append("            address_id=? \n");
            binder.add(addressId);
            address = (Address) JdbcUtils.queryObject(connection, sql.toString(), new RowMapper.ClassRowMapper(Address.class), binder.toPStmtBinder());
            connection.commit();
        }
        return address;
    }

    //get latest id
    public Address getLastAddress() throws SQLException {
        Address address = new Address();
        try (Connection connection = PoolManager.getInstance().getConnection()) {
            final StringBuilder sql = new StringBuilder();
            final PStmtBinder.SimplePStmtBinderBuilder binder = new PStmtBinder.SimplePStmtBinderBuilder();
            sql.append("SELECT * FROM \n");
            sql.append(     "addresses \n");
            sql.append(         "ORDER BY address_id \n");
            sql.append(                 "DESC LIMIT 1 \n");
            address = (Address) JdbcUtils.queryObject(connection, sql.toString(), new RowMapper.ClassRowMapper(Address.class), binder.toPStmtBinder());
            connection.commit();
        }
        return address;
    }

}
