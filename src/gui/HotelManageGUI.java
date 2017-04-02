/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.Hotel;
import entities.Room;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import repository.DbRepositoryImpl;

/**
 *
 * @author Ivan Zhu <ivanzhujunwei@gmail.com>
 */
public class HotelManageGUI extends javax.swing.JFrame implements ListSelectionListener
{

    Statement stmt = null;
    ResultSet rset = null;

    GuiUtilityImpl guiUtility = null;
    DbRepositoryImpl reposity = null;

    Object columnHeaders_hotel[] = {"Hote id", "name", "Type", "Country", "City"};
    Object columnHeaders_room[] = {"ROOM_NUMBER", "HOTEL_ID", "TYPE", "PRICE"};
    Object columnHeaders_guest[] = {"ROOM_NUMBER", "HOTEL_ID", "TYPE", "PRICE"};
    Object data[][] = {};
    DefaultTableModel dtmHotel = new DefaultTableModel(data, columnHeaders_hotel);
    DefaultTableModel dtmRoom = new DefaultTableModel(data, columnHeaders_room);
    DefaultTableModel dtmGuest = new DefaultTableModel(data, columnHeaders_room);

    /**
     * Creates new form HotelManageGUI
     */
    public HotelManageGUI()
    {
        initComponents();
        reposity = new DbRepositoryImpl();
        guiUtility = new GuiUtilityImpl();
        this.hotelTable.getSelectionModel().addListSelectionListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        hotelTable = new javax.swing.JTable();
        showAllHotels = new javax.swing.JButton();
        addHotelBtn = new javax.swing.JButton();
        updateHotelBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        searchByTypeCom = new javax.swing.JComboBox<>();
        findByTypeBtn = new javax.swing.JButton();
        hotelIdLabel = new javax.swing.JLabel();
        hotelIdField = new javax.swing.JTextField();
        hotelNameLabel = new javax.swing.JLabel();
        hotelNameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        hotelTypeCombox = new javax.swing.JComboBox<>();
        constructYearLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        countryField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cityField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        constructYearFormatField = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        roomTable = new javax.swing.JTable();
        showAllRoomBtn = new javax.swing.JButton();
        addRoomBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        roomIdField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        hotelNameCombox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        roomTypeCombox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        roomPriceField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        roomDesField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        roomOccupancyField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        guestTable = new javax.swing.JTable();
        showAllGuests = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        hotelTable.setModel(dtmHotel);
        jScrollPane1.setViewportView(hotelTable);

        showAllHotels.setText("Show All");
        showAllHotels.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                showAllHotelsActionPerformed(evt);
            }
        });

        addHotelBtn.setText("Add");
        addHotelBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                addHotelBtnActionPerformed(evt);
            }
        });

        updateHotelBtn.setText("Update");
        updateHotelBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                updateHotelBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deleteBtnActionPerformed(evt);
            }
        });

        searchByTypeCom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5 star", "4 star", "3 star", "2 star" }));

        findByTypeBtn.setText("FindByType");
        findByTypeBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                findByTypeBtnActionPerformed(evt);
            }
        });

        hotelIdLabel.setText("Hotel ID");

        hotelNameLabel.setText("Hotel name");

        jLabel1.setText("Hotel type");

        hotelTypeCombox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5 star", "4 star", "3 star", "2 star" }));

        constructYearLabel.setText("Construct year");

        jLabel2.setText("Country");

        jLabel3.setText("City");

        jLabel4.setText("Address");

        jLabel5.setText("Contact phone");

        jLabel6.setText("Contact email");

        constructYearFormatField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(showAllHotels)
                                    .addComponent(hotelIdLabel)
                                    .addComponent(hotelNameLabel)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(addHotelBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(updateHotelBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(deleteBtn))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(hotelTypeCombox, javax.swing.GroupLayout.Alignment.LEADING, 0, 154, Short.MAX_VALUE)
                                        .addComponent(hotelNameField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(hotelIdField, javax.swing.GroupLayout.Alignment.LEADING))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(constructYearLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(constructYearFormatField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(searchByTypeCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emailField)
                                    .addComponent(phoneField)
                                    .addComponent(addressField)
                                    .addComponent(cityField)
                                    .addComponent(countryField))
                                .addGap(164, 164, 164))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(findByTypeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showAllHotels)
                    .addComponent(addHotelBtn)
                    .addComponent(updateHotelBtn)
                    .addComponent(deleteBtn)
                    .addComponent(searchByTypeCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(findByTypeBtn))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hotelIdLabel)
                    .addComponent(hotelIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(countryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hotelNameLabel)
                    .addComponent(hotelNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hotelTypeCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(constructYearLabel)
                        .addComponent(constructYearFormatField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(141, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hotel", jPanel1);

        jPanel2.setToolTipText("");

        roomTable.setModel(dtmRoom);
        jScrollPane2.setViewportView(roomTable);

        showAllRoomBtn.setText("Show All");
        showAllRoomBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                showAllRoomBtnActionPerformed(evt);
            }
        });

        addRoomBtn.setText("Add");
        addRoomBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                addRoomBtnActionPerformed(evt);
            }
        });

        jLabel7.setText("Room ID");

        jLabel8.setText("Hotel");

        hotelNameCombox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1104-jj", "1103-uu" }));

        jLabel9.setText("Room Type");

        roomTypeCombox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Room Price");

        jLabel11.setText("Room Description");

        jLabel12.setText("Room Occupancy");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roomDesField)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(showAllRoomBtn)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hotelNameCombox, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addRoomBtn)
                                    .addComponent(roomIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roomTypeCombox, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(roomOccupancyField, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(roomPriceField))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showAllRoomBtn)
                    .addComponent(addRoomBtn))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(roomIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(hotelNameCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(roomPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(roomTypeCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roomDesField, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(roomOccupancyField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Room", jPanel2);

        guestTable.setModel(dtmGuest);
        jScrollPane3.setViewportView(guestTable);

        showAllGuests.setText("Show all");
        showAllGuests.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                showAllGuestsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(showAllGuests)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showAllGuests)
                .addContainerGap(308, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Guest", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showAllHotelsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_showAllHotelsActionPerformed
    {//GEN-HEADEREND:event_showAllHotelsActionPerformed
        String sql = "SELECT HT_ID, HT_NAME, HT_TYPE, COUNTRY, CITY FROM HOTEL";
        guiUtility.displayTable(hotelTable, sql, dtmHotel);
    }//GEN-LAST:event_showAllHotelsActionPerformed


    private void showAllRoomBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_showAllRoomBtnActionPerformed
    {//GEN-HEADEREND:event_showAllRoomBtnActionPerformed
        String sql = "SELECT * FROM ROOM";
        guiUtility.displayTable(roomTable, sql, dtmRoom);
    }//GEN-LAST:event_showAllRoomBtnActionPerformed

    private void addHotelBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addHotelBtnActionPerformed
    {//GEN-HEADEREND:event_addHotelBtnActionPerformed
        // detect if the hotel id is already existed
        String hotelIdStr = hotelIdField.getText();
        int hoteId = Integer.parseInt(hotelIdStr);
        // if not, then add the hote info
        if (!reposity.isHotelExisted(hoteId)) {
            Hotel hotel = new Hotel();
            hotel.setHotelId(hoteId);
            assembleHotel(hotel);
            reposity.addHotel(hotel);
            // give user response saying the hotel is already existed
            JOptionPane.showMessageDialog(this, "✔ Add successfully");
            // display hotel table
            showAllHotelsActionPerformed(evt);
            clearHotelInputs();
        } else {
            // give user response saying the hotel is already existed
            JOptionPane.showMessageDialog(this, "Hotel id exists!", "Add hotel warning",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_addHotelBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteBtnActionPerformed
    {//GEN-HEADEREND:event_deleteBtnActionPerformed
        if (guiUtility.isRowSelected(hotelTable)) {
            int dialogResult = JOptionPane.showConfirmDialog(this, "Really delete the selected row?", "Warning", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                int hotelId = guiUtility.getSelectedRowId(hotelTable);
                reposity.deleteHotel(hotelId);
                // show delete successfully
                JOptionPane.showMessageDialog(this, "✔ Delete successfully");
                showAllHotelsActionPerformed(evt);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a hotel first", "Delete hotel error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void findByTypeBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_findByTypeBtnActionPerformed
    {//GEN-HEADEREND:event_findByTypeBtnActionPerformed
        String type = searchByTypeCom.getSelectedItem().toString();
        String sql = "SELECT HT_ID, HT_NAME, HT_TYPE, COUNTRY, CITY FROM HOTEL WHERE HT_TYPE = '" + type +"'";
        guiUtility.displayTable(hotelTable, sql, dtmHotel);
    }//GEN-LAST:event_findByTypeBtnActionPerformed

    private void updateHotelBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_updateHotelBtnActionPerformed
    {//GEN-HEADEREND:event_updateHotelBtnActionPerformed
        // detect if the hotel id is already existed
        String hotelIdStr = hotelIdField.getText();
        int hoteId = Integer.parseInt(hotelIdStr);
        // only can update the hotel that is already existed 
        if (reposity.isHotelExisted(hoteId)) {
            Hotel hotel = reposity.getHotelById(hoteId);
            assembleHotel(hotel);
            reposity.updateHotel(hotel);
            // show update successfully
            JOptionPane.showMessageDialog(this, "✔ Update successfully");
            // display hotel table
            showAllHotelsActionPerformed(evt);
            clearHotelInputs();
        } else {
            // give user response saying the hotel does not exist
            JOptionPane.showMessageDialog(this, "Hotel id does not exist, you can only update a hotel that exists!", "Update hotel warning",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_updateHotelBtnActionPerformed

    private void addRoomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoomBtnActionPerformed
// detect if the hotel id is already existed
        String roomIdStr = roomIdField.getText();
        int rm_num = Integer.parseInt(roomIdStr);
        // if not, then add the hote info
        if (!reposity.isRoomExisted(rm_num)) {
            Room room = new Room();
            room.setRm_num(rm_num);
            assembleRoom(room);
            reposity.addRoom(room);
            // give user response saying the hotel is already existed
            JOptionPane.showMessageDialog(this, "✔ Add successfully");
            // display room table
            showAllRoomBtnActionPerformed(evt);
            clearRoomInputs();
        } else {
            // give user response saying the hotel is already existed
            JOptionPane.showMessageDialog(this, "Room id exists!", "Add Room warning",
                    JOptionPane.WARNING_MESSAGE);
        }        // TODO add your handling code here:
        
    }//GEN-LAST:event_addRoomBtnActionPerformed

    private void showAllGuestsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_showAllGuestsActionPerformed
    {//GEN-HEADEREND:event_showAllGuestsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showAllGuestsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HotelManageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new HotelManageGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addHotelBtn;
    private javax.swing.JButton addRoomBtn;
    private javax.swing.JTextField addressField;
    private javax.swing.JTextField cityField;
    private javax.swing.JFormattedTextField constructYearFormatField;
    private javax.swing.JLabel constructYearLabel;
    private javax.swing.JTextField countryField;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField emailField;
    private javax.swing.JButton findByTypeBtn;
    private javax.swing.JTable guestTable;
    private javax.swing.JTextField hotelIdField;
    private javax.swing.JLabel hotelIdLabel;
    private javax.swing.JComboBox<String> hotelNameCombox;
    private javax.swing.JTextField hotelNameField;
    private javax.swing.JLabel hotelNameLabel;
    private javax.swing.JTable hotelTable;
    private javax.swing.JComboBox<String> hotelTypeCombox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField phoneField;
    private javax.swing.JTextField roomDesField;
    private javax.swing.JTextField roomIdField;
    private javax.swing.JTextField roomOccupancyField;
    private javax.swing.JTextField roomPriceField;
    private javax.swing.JTable roomTable;
    private javax.swing.JComboBox<String> roomTypeCombox;
    private javax.swing.JComboBox<String> searchByTypeCom;
    private javax.swing.JButton showAllGuests;
    private javax.swing.JButton showAllHotels;
    private javax.swing.JButton showAllRoomBtn;
    private javax.swing.JButton updateHotelBtn;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(ListSelectionEvent event)
    {
        if (event.getSource() == hotelTable.getSelectionModel()) {
            if (guiUtility.isRowSelected(hotelTable)) {
                int hotelId = guiUtility.getSelectedRowId(hotelTable);
                Hotel hotel = reposity.getHotelById(hotelId);
                displayHotelDetail(hotel);
            }
        }
    }

    /**
     * *
     * Display hotel details after select one row in hotel table
     *
     * @param hotel Hotel object
     */
    private void displayHotelDetail(Hotel hotel)
    {
        hotelIdField.setText(hotel.getHotelId() + "");
        hotelNameField.setText(hotel.getHotelName());
        hotelTypeCombox.setSelectedIndex(guiUtility.getHotelTypeIndexForCombox(hotel));
        constructYearFormatField.setText(hotel.getYear() + "");
        countryField.setText(hotel.getCountry());
        cityField.setText(hotel.getCity());
        addressField.setText(hotel.getAddress());
        phoneField.setText(hotel.getContact_phone());
        emailField.setText(hotel.getContact_email());
    }

    /**
     * *
     * Clear the text fields about hotel info
     */
    private void clearHotelInputs()
    {
        hotelIdField.setText("");
        hotelNameField.setText("");
        constructYearFormatField.setText("");
        countryField.setText("");
        cityField.setText("");
        addressField.setText("");
        phoneField.setText("");
        emailField.setText("");

    }
    
    private void clearRoomInputs()
    {
        roomDesField.setText("");
        roomPriceField.setText("");
        roomOccupancyField.setText("");
    }

    /**
     * *
     * Assemble hotel object based on the input text
     */
    private void assembleHotel(Hotel hotel)
    {
        hotel.setHotelName(hotelNameField.getText());
        hotel.setHotelType(hotelTypeCombox.getSelectedItem().toString());
        hotel.setYear(Integer.parseInt(constructYearFormatField.getText()));
        hotel.setCountry(countryField.getText());
        hotel.setCity(cityField.getText());
        hotel.setAddress(addressField.getText());
        hotel.setContact_phone(phoneField.getText());
        hotel.setContact_email(emailField.getText());
    }
    
     private void assembleRoom(Room room)
    {
        room.setRm_des(roomDesField.getText());
        room.setRm_price(Double.parseDouble(roomPriceField.getText()));
        room.setRm_type(roomTypeCombox.getSelectedItem().toString());
        String hotelInfo = hotelNameCombox.getSelectedItem().toString();
        String[] hotelDetail = hotelInfo.split("-");
        int hotelId = Integer.parseInt(hotelDetail[0]);
        room.setHotel(reposity.getHotelById(hotelId));
        room.setRm_occupancy(Integer.parseInt(roomOccupancyField.getText()));
    }
}
