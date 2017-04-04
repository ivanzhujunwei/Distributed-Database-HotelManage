/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import repository.DbRepositoryImpl;

/**
 *
 * @author Ivan Zhu <ivanzhujunwei@gmail.com>
 */
public class GuiUtilityImpl implements GuiUtility
{

//    // FIT5148A database connection
//    Connection connA = null;
//    // FIT5148B database connection
//    Connection connB = null;
    Statement stmt = null;

    public GuiUtilityImpl()
    {
//        connA = DBConnection.getConnectionA();
//        connB = DBConnection.getConnectionB();
    }

    @Override
    public void clearTable(JTable t)
    {
        int numberOfRow = t.getModel().getRowCount();
        if (numberOfRow > 0) {
            DefaultTableModel tableModel = (DefaultTableModel) t.getModel();
            for (int index = (numberOfRow - 1); index >= 0; index--) {
                tableModel.removeRow(index);
            }
        }
    }

    @Override
    public void displayTable(JTable t, String sql, DefaultTableModel dtm)
    {
        System.out.println(sql);
        try {
            this.clearTable(t);
            // hotel table is in FIT5148A database
            if (sql.contains("HOTEL")) {
                stmt = DbRepositoryImpl.connA.createStatement();
            } else {
                stmt = DbRepositoryImpl.connB.createStatement();
            }
            ResultSet rset = stmt.executeQuery(sql);
            ResultSetMetaData mdata = rset.getMetaData();
            int numberOfColumns = mdata.getColumnCount();
            while (rset.next()) {
                Object[] rowData = new Object[numberOfColumns];
                for (int i = 0; i < rowData.length; i++) {
                    rowData[i] = rset.getObject(i + 1);
                }
                dtm.addRow(rowData);
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(GuiUtilityImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getHotelTypeIndexForCombox(Hotel hotel)
    {
        String type = hotel.getHotelType();
        switch (type) {
            case "5 star":
                return 0;
            case "4 star":
                return 1;
            case "3 star":
                return 2;
            case "2 star":
                return 3;
            default:
                return 3;
        }
    }

    public int getCustMembershipIndexForCombox(Customer customer)
    {
        String membership = customer.getMs().getMem_tier();
        switch (membership) {
            case "5 star":
                return 0;
            case "4 star":
                return 1;
            case "3 star":
                return 2;
            case "2 star":
                return 3;
            default:
                return 3;
        }
    }

    public int getRoomTypeIndexForCombox(Room room)
    {
        String type = room.getRm_type();
        switch (type) {
            case "suite":
                return 0;
            case "studio":
                return 1;
            case "double":
                return 2;
            case "single":
                return 3;
            default:
                return 4;
        }
    }

    @Override
    public int getSelectedRowId(JTable t)
    {
        int selectedRowIndex = t.getSelectedRow();
        String rowId = t.getValueAt(selectedRowIndex, 0).toString();
        return Integer.parseInt(rowId);
    }

    @Override
    public String getSelectedRowName(JTable t)
    {
        int selectedRowIndex = t.getSelectedRow();
        String rowname = t.getValueAt(selectedRowIndex, 0).toString();
        return rowname;
    }

    @Override
    public Booking getUpdatedBookingFromTable(JTable t)
    {
        int selectedRowIndex = t.getSelectedRow();
        String bookingId = t.getValueAt(selectedRowIndex, 0).toString();
        String contactPerson = t.getValueAt(selectedRowIndex, 6).toString();
        String contactEmail = t.getValueAt(selectedRowIndex, 7).toString();
        Booking b = new Booking();
        b.setBookingId(Integer.parseInt(bookingId));
        b.setPerson(contactPerson);
        b.setEmail(contactEmail);
        return b;

    }

    void iniCombox(String sql, JComboBox<String> custMemCombo)
    {
        try {
            stmt = DbRepositoryImpl.connB.createStatement();
            ResultSet rset = stmt.executeQuery(sql);
            custMemCombo.removeAllItems();
            while (rset.next()) {
                String item = rset.getString(1);
                custMemCombo.addItem(item);
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(GuiUtilityImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean isRowSelected(JTable t)
    {
        return t.getSelectedRow() >= 0;
    }

    public int getSelectedCustomerId(JComboBox chosenCustomerCombo)
    {
        String selectedCustomer = chosenCustomerCombo.getSelectedItem().toString();
        String cust_num = selectedCustomer.split("-")[0];
        return Integer.parseInt(cust_num);
    }

}
