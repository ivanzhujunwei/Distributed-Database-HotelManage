/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Booking;
import entities.Hotel;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivan Zhu <ivanzhujunwei@gmail.com>
 */
public interface GuiUtility
{
    /***
     * Clear table content
     * @param table JTable
     */
    public void clearTable(JTable table);
    
    public void displayTable(JTable t, String sql, DefaultTableModel dtmHotel);
    
    /***
     * Get selected row id which is the primary id for that table
     * @param t table
     * @return row id
     */
    public int getSelectedRowId(JTable t);
    
    /***
     * Get selected row name which is the primary id for that table 
     * @param t
     * @return row header name
     */
    public String getSelectedRowName(JTable t);
    
    /***
     * Judge if the table row has been selected or not
     * @param t  table
     * @return return true if selected rows is more than one; return false if not
     */
    public boolean isRowSelected(JTable t);
    
    /***
     * Get the index of hotel type for combox in hotel tab
     * @param hotel Hotel object
     * @return index in combox
     */
    public int getHotelTypeIndexForCombox(Hotel hotel);
    
    /***
     * Update a booking by editing booking table row
     * @return 
     */
    public Booking getUpdatedBookingFromTable(JTable t);
    
    /***
     * Validate the text fields is empty or not
     * @param fields
     * @return return false if any one of them is empty
     */
    public boolean validateTextFieldEmpty(List<JTextField> fields);
    
    
}
