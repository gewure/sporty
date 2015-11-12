package at.sporty.team1.rmi.api;

import at.sporty.team1.rmi.dtos.DepartmentDTO;
import at.sporty.team1.rmi.dtos.MemberDTO;
import at.sporty.team1.rmi.dtos.TeamDTO;
import at.sporty.team1.rmi.exceptions.UnknownEntityException;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by f00 on 03.11.15.
 */
public interface IDepartmentController extends Remote, Serializable {

    /**
     * Search for all Departments.
     *
     * @return List<DepartmentDTO> List of all departments
     * @throws RemoteException
     */
    List<DepartmentDTO> searchAllDepartments()
    throws RemoteException;

    /**
     * Returns a list of all teams assigned to the given department.
     *
     * @param departmentDTO target department (will be used for search)
     * @return List<TeamDTO> List of all teams
     * @throws RemoteException
     */
    List<TeamDTO> loadDepartmentTeams(DepartmentDTO departmentDTO)
    throws RemoteException;

    /**
     * Assigns department to selected head.
     *
     * @param deptDTO department that will be assigned to the given head.
     * @param memberDTO target head to which department will be assigned.
     * @throws RemoteException
     */
    void assignDepartmentToHead(DepartmentDTO deptDTO, MemberDTO memberDTO)
    throws RemoteException, UnknownEntityException;
}
