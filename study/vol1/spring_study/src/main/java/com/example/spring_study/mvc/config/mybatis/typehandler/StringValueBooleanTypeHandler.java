package com.example.spring_study.mvc.config.mybatis.typehandler;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jeaha on 2023/07/06
 */
@Slf4j
@MappedTypes(Boolean.class)
@MappedJdbcTypes(JdbcType.CHAR)
public class StringValueBooleanTypeHandler implements TypeHandler<Boolean> {
    @Override
    public void setParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType) throws SQLException {
        //log.debug("\nsetParameter -> PreparedStatement {}, int {}, Boolean {}, JdbcType {}", ps, i, parameter, jdbcType);
        try {
            ps.setString(i, BooleanUtils.toString(parameter, "Y", "N"));
        } catch (Exception e) {
            log.error("StringValueBooleanTypeHandler -> MSG : {}, CUZ : {}", e.getMessage(), e.getCause());
            e.printStackTrace();
        }
    }
    
    @Override
    public Boolean getResult(ResultSet rs, String columnName) throws SQLException {
        //log.debug("\ngetResult -> ResultSet {}, String {}", rs, columnName);
        try {
            return BooleanUtils.toBoolean(rs.getString(columnName));
        } catch (Exception e) {
            log.error("StringValueBooleanTypeHandler -> MSG : {}, CUZ : {}", e.getMessage(), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public Boolean getResult(ResultSet rs, int columnIndex) throws SQLException {
        //log.debug("\ngetResult -> ResultSet {}, int {}", rs, columnIndex);
        try {
            return BooleanUtils.toBoolean(rs.getString(columnIndex));
        } catch (Exception e) {
            log.error("StringValueBooleanTypeHandler -> MSG : {}, CUZ : {}", e.getMessage(), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
    
    @Override
    public Boolean getResult(CallableStatement cs, int columnIndex) throws SQLException {
        //log.debug("\ngetResult -> CallableStatement {}, int {}", cs, columnIndex);
        try {
            return BooleanUtils.toBoolean(cs.getString(columnIndex));
        } catch (Exception e) {
            log.error("StringValueBooleanTypeHandler -> MSG : {}, CUZ : {}", e.getMessage(), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
