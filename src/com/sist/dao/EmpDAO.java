package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by sist on 2016-03-07.
 *      수집 : sqoop, flume
 *      검색 : 루씬
 *      분석 : MapReduce,  사용자정의(형태소),  hive, pig
 *              =======================================
 *              zookipper
 *      디비 : 몽고디비, My-SQL(분산데이터베이스): HBASE
 *      통계 : R
 *      시각화 : d3
 *      ==============================================
 *      보안, 스파크, YARN
 *
 *
 */
public class EmpDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private final String URL="jdbc:oracle:thin:@211.238.142.20:1521:ORCL";

    public EmpDAO(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    //DBCP
    public void getConnection(){
        try{
            connection= DriverManager.getConnection(URL,"scott","tiger");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void disConnection(){
        try{
            if(preparedStatement!=null)
                preparedStatement.close();
            if(connection!=null)
                connection.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    //가능 추가- 전체 테이블 내용을 출력
    public ArrayList<EmpDTO> empAllData(){
        ArrayList<EmpDTO> arrayList=new ArrayList<>();
        try{
            getConnection();
            String sql="SELECT * FROM emp";
            preparedStatement=connection.prepareStatement(sql);

            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                EmpDTO empDTO=new EmpDTO();
                /*
                    private int empno;
                    private String ename;
                    private String job;
                    private int mgr;
                    private Date hiredate;
                    private int sal;
                    private int comm;
                    private int deptno;
                 */
                empDTO.setEmpno(resultSet.getInt(1));;
                empDTO.setEname(resultSet.getString(2));
                empDTO.setJob(resultSet.getString(3));
                empDTO.setMgr(resultSet.getInt(4));
                empDTO.setHiredate(resultSet.getDate(5));
                empDTO.setSal(resultSet.getInt(6));
                empDTO.setComm(resultSet.getInt(7));
                empDTO.setDeptno(resultSet.getInt(8));

                arrayList.add(empDTO);
            }
            resultSet.close();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            disConnection();
        }

        return arrayList;
    }

    //기능 추가-deptAllData()
    public ArrayList<DeptDTO> deptAllData(){
        ArrayList<DeptDTO> arrayList=new ArrayList<>();
        try {
            getConnection();
            String sql="SELECT * FROM dept";
            preparedStatement=connection.prepareStatement(sql);

            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                DeptDTO deptDTO=new DeptDTO();
                /*
                    private int deptno;
                    private String dname;
                    private String loc;
                 */
                deptDTO.setDeptno(resultSet.getInt(1));
                deptDTO.setDname(resultSet.getString(2));
                deptDTO.setLoc(resultSet.getString(3));
                arrayList.add(deptDTO);
            }
            resultSet.close();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            disConnection();
        }
        return arrayList;
    }

}
































