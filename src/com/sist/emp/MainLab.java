package com.sist.emp;

import com.sist.dao.DeptDTO;
import com.sist.dao.EmpDAO;
import com.sist.dao.EmpDTO;

import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Created by sist on 2016-03-07.
 */
public class MainLab {
    public static void main(String[] args){
        EmpDAO empDAO=new EmpDAO();
/*        ArrayList<EmpDTO> arrayList=empDAO.empAllData();
        try{
            *//*
                private int empno;
                private String ename;
                private String job;
                private int mgr;
                private Date hiredate;
                private int sal;
                private int comm;
                private int deptno;
             *//*
            String printData="empno,ename,job,mgr,hiredate,sal,comm,deptno\n";
            for(EmpDTO empDTO:arrayList){
                printData+=empDTO.getEmpno()+","
                        +empDTO.getEname()+","
                        +empDTO.getJob()+","
                        +empDTO.getMgr()+","
                        +empDTO.getHiredate().toString()+","
                        +empDTO.getSal()+","
                        +empDTO.getComm()+","
                        +empDTO.getDeptno()+"\n";
            }
            System.out.println(printData);

            FileWriter fileWriter=new FileWriter("data/emp.csv");
            fileWriter.write(printData);
            fileWriter.close();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }*/

        ArrayList<DeptDTO> arrayList=empDAO.deptAllData();
        try{
            String printData="deptno,dname,loc\n";
            for(DeptDTO deptDTO:arrayList){
                printData+=deptDTO.getDeptno()+","
                        +deptDTO.getDname()+","
                        +deptDTO.getLoc()+"\n";
            }
            System.out.println(printData);

            FileWriter fileWriter=new FileWriter("data/dept.csv");
            fileWriter.write(printData);
            fileWriter.close();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}































































