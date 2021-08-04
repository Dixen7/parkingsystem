package com.parkit.parkingsystem.constants;

public class DBConstants {

    public static final String GET_NEXT_PARKING_SPOT = "select min(PARKING_NUMBER) from parking where AVAILABLE = true and TYPE = ?";
    public static final String UPDATE_PARKING_SPOT = "update parking set available = ? where PARKING_NUMBER = ?";

    public static final String SAVE_TICKET = "insert into ticket(PARKING_NUMBER, VEHICLE_REG_NUMBER, PRICE, IN_TIME, OUT_TIME) values(?,?,?,?,?)";
    public static final String UPDATE_TICKET = "update ticket set PRICE=?, OUT_TIME=? where ID=?";
    public static final String GET_TICKET = "select t.PARKING_NUMBER, t.ID, t.PRICE, t.IN_TIME, t.OUT_TIME, p.TYPE from ticket t,parking p where p.parking_number = t.parking_number and t.VEHICLE_REG_NUMBER=? order by t.IN_TIME  limit 1";
    
	public static final String COUNT_BY_VEHICLE_REG_NUMBER = "SELECT COUNT(*) as quantity FROM ticket WHERE ticket.VEHICLE_REG_NUMBER = ?";
	public static final String TICKET_EXISTS_FOR_VEHICLE_REG_NUMBER = "SELECT COUNT(*) as quantity FROM ticket WHERE ticket.VEHICLE_REG_NUMBER = ?";
	public static final String SLOT_AVAILABLE = "SELECT * FROM parking WHERE PARKING_NUMBER = ?;";
	public static final String CHECK_PRICE_AND_OUT_TIME_NOT_NULL = "SELECT COUNT(*) as quantity FROM ticket WHERE VEHICLE_REG_NUMBER = ? and price is not null and out_time is not null;";
	public static final String COUNT_RECURENT = "select count(*) from ticket where vehicle_reg_number= ?"; ;
}
