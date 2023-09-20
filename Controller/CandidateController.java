package Controller;

import Model.Candidate;
import Model.Experience;
import Model.Fresher;
import Model.Intern;
import View.Menu;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Dai Nhan
 */
public class CandidateController extends Menu<String> {

    private Validation valid;
    private Util util;
    private ArrayList<Candidate> dataCandidate;

    public CandidateController() {
        super("==== Menu Manager Candidate ====", new String[]{
            "Print", "Add Candidate", "Searching", "Exit"
        });
        util = new Util();
        dataCandidate = new ArrayList<>();
        valid = new Validation();
    }

    @Override
    public void execute() {
        boolean exit = false;
        while (!exit) {
            dispplay();
            String choice = util.getInput("input choice:");
            switch (choice) {
                case "1":
                    printCandidate(dataCandidate);
                    break;
                case "2":
                    add();
                    break;
                case "3":
                    search();
                    break;
                case "4":
                    util.display("Exit....");
                    exit = true;
                    break;
                default:
                    util.display("Wrong choice!");
                    break;
            }
        }
    }
// =====================================================================================================

    public void search() {
        String[] mc = {"Search by id", "Search by name", "Search by birthyear", "Search by candidate type", "Exit"};
        Menu menu = new Menu("==== Search Menu ====", mc) {
            @Override
            public void execute() {
                boolean exit = false;
                while (!exit) {
                    dispplay();
                    String choice = util.getInput("Input choice: ");
                    switch (choice) {

                        case "1":
                            String id = util.getInput("Input id to search: ");
                            for (Candidate candidate : dataCandidate) {
                                if (candidate.getId().equals(id)) {
                                    util.display(candidate.toString());
                                }
                            }
                            break;
                        case "2":
                            String name = util.getInput("Input name to search: ");
                            for (Candidate candidate : dataCandidate) {
                                String fullname = candidate.getFirstName() + " " + candidate.getLastName();
                                if (fullname.contains(name)) {
                                    util.display(candidate.toString());
                                }
                            }
                            break;
                        case "3":
                            String year = util.getInput("Input birthyear to search: ");
                            for (Candidate candidate : dataCandidate) {
                                String candidateBirthYear = Integer.toString(candidate.getBirthdate().getYear());
                                if (candidateBirthYear.equals(year)) {
                                    util.display(candidate.toString());
                                }
                            }
                            break;
                        case "4":
                            int candidateType = Integer.parseInt(util.getInput("Input candidate type to search (1-Experience; 2-Fresher; 3-Intern): "));
                            for (Candidate candidate : dataCandidate) {
                                if (candidate.getCandidateType() == candidateType) {
                                    util.display(candidate.toString());
                                }
                                break;
                            }
                        case "5":
                            util.display("Exit...");
                            exit = true;
                            break;
                        default:
                            util.display("Wrong choice");
                            break;
                    }
                }
            }
        };
        menu.run();

    } //======================================================================================================

    public void add() {
        String id, firstName, lastName, phone, email, address;
        id = util.getInput("Input ID: ");
        firstName = util.getInput("Input first Name: ");
        lastName = util.getInput("Input last Name: ");
        LocalDate birthDate;
        do {
            birthDate = valid.checkDate(util.getInput("Input birthDate(dd/MM/yyyy): "));
            if (birthDate == null) {
                util.display("Wrong input!");
                birthDate = valid.checkDate(util.getInput("Input birthDate(dd/MM/yyyy): "));
            }
        } while (birthDate == null);
        do {
            phone = valid.checkPhone(util.getInput("Input phone (More than 10 numbers): "));
            if (phone == null) {
                util.display("Wrong input!");
                phone = valid.checkPhone(util.getInput("Input phone (More than 10 numbers): "));
            }
        } while (phone == null);
        do {
            email = util.getInput("Input email(has tail @gmail.com): ");
            if (valid.checkmail(email) == null) {
                util.display("Wrong input!");
                email = util.getInput("Input email(has tail @gmail.com): ");
            }
        } while (valid.checkmail(email) == null);
        
        address = util.getInput("Input address: ");
        String candidateTypeStr;
        do {
            candidateTypeStr = util.getInput("Input candidate type(1 - Experience; 2 - Fresher; 3 - Intern): ");
            if (!candidateTypeStr.equals("1") && !candidateTypeStr.equals("2") && !candidateTypeStr.equals("3")) {
                util.display("Wrong input!");
            }
        } while (!candidateTypeStr.equals("1") && !candidateTypeStr.equals("2") && !candidateTypeStr.equals("3"));

        int candidateType = Integer.parseInt(candidateTypeStr);
        switch (candidateType) {
            case 1:
                int yearOfExperience;
                do {
                    yearOfExperience = Integer.parseInt(util.getInput("Input year of experience : "));
                    if (valid.checkYearExperience(yearOfExperience) == false) {
                        util.display("Wrong input!");
                        yearOfExperience = Integer.parseInt(util.getInput("Input year of experience : "));
                    }
                } while (valid.checkYearExperience(yearOfExperience) == false);
                ArrayList<String> proSkillList = addProSkill();
                Experience expCandidate = new Experience(id, firstName, lastName, birthDate, phone, email, address, candidateType, yearOfExperience, proSkillList);
                dataCandidate.add(expCandidate);
                util.display("Add success!");
                break;
            case 2:
                LocalDate dateGraduate;
                do {
                    dateGraduate = valid.checkDate(util.getInput("Input graduation date(dd/MM/yyyy): "));
                    if (dateGraduate == null) {
                        util.display("Wrong input!");
                        dateGraduate = valid.checkDate(util.getInput("Input graduation date(dd/MM/yyyy): "));
                    }
                } while (dateGraduate == null);
                String rankOfGraduation;
                do {
                    rankOfGraduation = valid.checkRank(util.getInput("Input rank of graduation (excellence-good-fair-poor): "));
                    if (rankOfGraduation == null) {
                        util.display("Wrong input!");
                        rankOfGraduation = valid.checkRank(util.getInput("Input rank of graduation: "));
                    }
                } while (rankOfGraduation == null);
                String education = util.getInput("Input university from which candidate graduated: ");
                Fresher fresher = new Fresher(id, firstName, lastName, birthDate, phone, email, address, candidateType, dateGraduate, rankOfGraduation, education);
                dataCandidate.add(fresher);
                util.display("Add success!");
                break;
            case 3:
                String major = util.getInput("Input current major of intern: ");
                String semester = util.getInput("Input semester of intern: ");
                String university = util.getInput("Input university which intern studying: ");
                Intern intern = new Intern(id, firstName, lastName, birthDate, phone, email, address, candidateType, major, semester, university);
                dataCandidate.add(intern);
                util.display("Add success!");
                break;
        }
    }

//---------------------------------------------------------------------------------------------
    public ArrayList<String> addProSkill() {
        int numberProSkill = Integer.parseInt(util.getInput("Input number Professional Skill (input number): "));
        ArrayList<String> proSkillList = new ArrayList<>();
        for (int i = 0; i < numberProSkill; i++) {
            proSkillList.add(util.getInput("Input Professional Skill: "));
        }
        return proSkillList;
    }
//==========================================================================================================

    public void printCandidate(ArrayList<Candidate> list) {
        if (list.isEmpty()) {
            util.display("List null!");
        }
        for (Candidate candidate : list) {
            util.display(candidate.toString());
        }
    }
}
