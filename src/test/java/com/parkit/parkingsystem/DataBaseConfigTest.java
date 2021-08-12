package com.parkit.parkingsystem;

import com.parkit.parkingsystem.config.DataBaseConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@ExtendWith(MockitoExtension.class)
public class DataBaseConfigTest {

    private DataBaseConfig dataBaseConfig;
    
    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;

    @BeforeEach
    private void setUpPerTest() {
    	dataBaseConfig = new DataBaseConfig();
    }

    @Test
    public void testCloseConnection(){

    	dataBaseConfig.closeConnection(connection);
    	
    	try {
			verify(connection, times(1)).close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @Test
    public void testClosePreparedStatement(){

    	dataBaseConfig.closePreparedStatement(preparedStatement);
 	
    	try {
			verify(preparedStatement, times(1)).close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }

    @Test
    public void test_closeResultSet_verifyResultSetClose(){

    	dataBaseConfig.closeResultSet(resultSet);
	
    	try {
			verify(resultSet, times(1)).close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}