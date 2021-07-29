package com.parkit.parkingsystem.integration.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.NoSuchElementException;

import com.parkit.parkingsystem.config.DataBaseConfig;
import com.parkit.parkingsystem.constants.DBConstants;

public class DataBaseTestUtilities {

	/**
     * Connect to DB and send SQL request to find out if the vehicle plate exists
     * @param vehicleRegNumber
     * @return true or false
     */
    public boolean ticketExistsForVehicleRegNumber(final String vehicleRegNumber) {
        try (Connection connection = DataBaseConfig.getConnection()) {
            final PreparedStatement ps = connection.prepareStatement(DBConstants.TICKET_EXISTS_FOR_VEHICLE_REG_NUMBER);
            ps.setString(1, vehicleRegNumber);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("quantity") > 0;
            } else {
                throw new NoSuchElementException("Empty ResultSet");
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Connect to DB and send SQL request to find out if the slot is available or not
     * @param parkingNumber
     * @return true or false
     */
    public boolean slotAvailable(final int parkingNumber) {
        try (Connection connection = DataBaseConfig.getConnection()) {
            final PreparedStatement ps = connection.prepareStatement(DBConstants.SLOT_AVAILABLE);
            ps.setInt(1, parkingNumber);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("available") > 0;
            } else {
                throw new NoSuchElementException("Empty ResultSet");
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Connect to DB and send SQL request to find out if the column price and out time are well informed for the vehicle plate
     * @param vehicleRegNumber
     * @return true or false
     */
    public boolean checkPriceAndOutTimeNotNull(String vehicleRegNumber) {
        try (Connection connection = DataBaseConfig.getConnection()) {
            final PreparedStatement ps = connection.prepareStatement(DBConstants.CHECK_PRICE_AND_OUT_TIME_NOT_NULL);
            ps.setString(1, vehicleRegNumber);
            final ResultSet rs = ps.executeQuery();     
            if (rs.next()) {
                return rs.getInt("quantity") > 0;
            } else {
                throw new NoSuchElementException("Empty ResultSet");
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
