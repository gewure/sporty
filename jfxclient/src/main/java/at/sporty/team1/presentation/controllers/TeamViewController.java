package at.sporty.team1.presentation.controllers;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import at.sporty.team1.communication.facades.CommunicationFacade;
import at.sporty.team1.communication.facades.api.IDepartmentControllerUniversal;
import at.sporty.team1.communication.facades.api.IMemberControllerUniversal;
import at.sporty.team1.communication.facades.api.ITeamControllerUniversal;
import at.sporty.team1.communication.util.RemoteCommunicationException;
import at.sporty.team1.presentation.controllers.core.ConsumerViewController;
import at.sporty.team1.presentation.util.GUIHelper;
import at.sporty.team1.shared.dtos.DepartmentDTO;
import at.sporty.team1.shared.dtos.MemberDTO;
import at.sporty.team1.shared.dtos.TeamDTO;
import at.sporty.team1.shared.exceptions.NotAuthorisedException;
import at.sporty.team1.shared.exceptions.UnknownEntityException;
import at.sporty.team1.shared.exceptions.ValidationException;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.util.StringConverter;

/**
 * Represents the View of a Team (Mannschaft)
 */
public class TeamViewController extends ConsumerViewController<MemberDTO> {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String SUCCESSFUL_TEAM_SAVE = "Team was successfully saved.";

    @FXML
    private ListView<MemberDTO> _membersListView;
    @FXML
    private ComboBox<TeamDTO> _chooseTeamComboBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        List<TeamDTO> resultList = new LinkedList<>();

        _membersListView.setCellFactory(m -> new ListCell<MemberDTO>() {
            @Override
            protected void updateItem(MemberDTO m, boolean bln) {
                super.updateItem(m, bln);

                if (m != null) {
                    String fullName = m.getFirstName() + " " + m.getLastName();
                    setText(fullName);

                    MenuItem deleteItem = new MenuItem();
                    deleteItem.textProperty().bind(Bindings.format("Delete \"%s\"", fullName));
                    deleteItem.setOnAction(event -> _membersListView.getItems().removeAll(getItem()));

                    ContextMenu contextMenu = new ContextMenu();
                    contextMenu.getItems().add(deleteItem);

                    emptyProperty().addListener((obs, wasEmpty, isNowEmpty) -> {
                        if (isNowEmpty) {
                            setContextMenu(null);
                        } else {
                            setContextMenu(contextMenu);
                        }
                    });
                } else {
                    //remove caption from list
                    setText("");
                }
            }
        });

        /**
         * Converter from TeamDTO to Team name (String)
         */
        StringConverter<TeamDTO> teamDTOConverter = GUIHelper.getDTOToStringConverter(TeamDTO::getTeamName);
        _chooseTeamComboBox.setConverter(teamDTOConverter);

        new Thread(() -> {

            try {

                IDepartmentControllerUniversal departmentController = CommunicationFacade.getInstance().lookupForDepartmentController();
                List<DepartmentDTO> departments = departmentController.searchAllDepartments();

                if (departments != null && !departments.isEmpty()) {

                    for (DepartmentDTO actualDepartment : departments) {

                        resultList.addAll(departmentController.loadDepartmentTeams(
                            actualDepartment.getDepartmentId()
                        ));

                        if (!resultList.isEmpty()) {

                            //loading values to comboBox
                            Platform.runLater(() -> _chooseTeamComboBox.setItems(
                                FXCollections.observableList(resultList)
                            ));
                        }
                    }
                }
            } catch (RemoteCommunicationException | UnknownEntityException e) {
                LOGGER.error("Error occurred while loading all Departments and their Teams.", e);
            }
        }).start();

        _chooseTeamComboBox.setOnAction((event) -> {
            _membersListView.getItems().clear();
            displayTeamData(_chooseTeamComboBox.getSelectionModel().getSelectedItem());
        });
    }

    private static TeamDTO _activeTeamDTO;

    @Override
    public void loadDTO(MemberDTO memberDTO) {
        addNewMemberToTeam(memberDTO);
    }

    /**
     * Pre-loads data into all view fields.
     *
     * @param teamDTO TeamDTO that will be preloaded.
     */
    private void displayTeamData(TeamDTO teamDTO) {
        if (teamDTO != null) {
            _activeTeamDTO = teamDTO;

            try {

                ITeamControllerUniversal teamController = CommunicationFacade.getInstance().lookupForTeamController();

                List<MemberDTO> memberList = teamController.loadTeamMembers(
                    _activeTeamDTO.getTeamId(),
                    CommunicationFacade.getInstance().getActiveSession()
                );

                if (memberList != null && !memberList.isEmpty()) {
                    _membersListView.setItems(FXCollections.observableList(memberList));
                }

            } catch (RemoteCommunicationException e) {
                LOGGER.error("Error occurred while displaying team data.", e);
            } catch (UnknownEntityException e) {
                LOGGER.error("DTO was not saved in Data Storage before loading all Members from Team.", e);
            } catch (NotAuthorisedException e) {
                String context = "Client load (Team Members) request was rejected. Not enough permissions.";

                LOGGER.error(context, e);
                GUIHelper.showErrorAlert(context);
            }
        }
    }

    public void addNewMemberToTeam(MemberDTO memberDTO) {
        if (memberDTO != null && !_membersListView.getItems().contains(memberDTO)) {
            _membersListView.getItems().add(memberDTO);
        }
    }

    @FXML
    private void removeSelectedMember(ActionEvent event) {
        MemberDTO memberDTO = _membersListView.getSelectionModel().getSelectedItem();

        try {
            IMemberControllerUniversal memberController = CommunicationFacade.getInstance().lookupForMemberController();

            if ((_activeTeamDTO != null) && (memberDTO != null)) {

                memberController.removeMemberFromTeam(
                    memberDTO.getMemberId(),
                    _activeTeamDTO.getTeamId(),
                    CommunicationFacade.getInstance().getActiveSession()
                );

                _membersListView.getItems().remove(memberDTO);

            } else if (memberDTO != null) {

                //Simply remove from list view, this part of the code
                //will be executed only when new team will be created
                _membersListView.getItems().remove(memberDTO);

            }
        } catch (RemoteCommunicationException e) {
            LOGGER.error("Error occurred while removing member from the team.", e);
        } catch (UnknownEntityException e) {
            LOGGER.error("DTO was not saved in Data Storage before removing Member from Team.", e);
        } catch (NotAuthorisedException e) {
            String context = "Client delete (Member) request was rejected. Not enough permissions.";

            LOGGER.error(context, e);
            GUIHelper.showErrorAlert(context);
        }
    }

    @FXML
    private void saveTeam(ActionEvent event) {

        ObservableList<MemberDTO> memberList = _membersListView.getItems();

        if (memberList != null && !memberList.isEmpty()) {

            try {

                ITeamControllerUniversal teamController = CommunicationFacade.getInstance().lookupForTeamController();
                teamController.createOrSaveTeam(
                    _activeTeamDTO,
                    CommunicationFacade.getInstance().getActiveSession()
                );

                for (MemberDTO member : memberList) {
                    CommunicationFacade.getInstance().lookupForMemberController().assignMemberToTeam(
                        member.getMemberId(),
                        _activeTeamDTO.getTeamId(),
                        CommunicationFacade.getInstance().getActiveSession()
                    );
                }

                GUIHelper.showSuccessAlert(SUCCESSFUL_TEAM_SAVE);

                //Logging and closing the tab
                LOGGER.info("Team \"{}\" was successfully saved.", _activeTeamDTO.getTeamName());
                dispose();

            } catch (RemoteCommunicationException e) {
                LOGGER.error("Error occurred while saving the team.", e);
            } catch (ValidationException e) {
                String context = String.format("Validation exception %s while saving team.", e.getCause());

                GUIHelper.showValidationAlert(context);
                LOGGER.error(context, e);
            } catch (UnknownEntityException e) {
                LOGGER.error("Unable to assign Member to Team", e);
            } catch (NotAuthorisedException e) {
                String context = "Client save (Team) request was rejected. Not enough permissions.";

                LOGGER.error(context, e);
                GUIHelper.showErrorAlert(context);
            }
        }
    }
}
