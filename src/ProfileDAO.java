import dbWorker.Query;

public class ProfileDAO {

    private String login;
    private int userId;
    Query query = new Query();

    public ProfileDAO(String login, int userId) {
        this.login = login;
        this.userId = userId;
    }
    public ProfileDAO() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserAge(){
        int age = query.getUserAge(login);
        return age;
    }

    public String getFirstName(){
        String firstName = query.getUserFirstName(login);
        return firstName;
    }

    public String getSecondName(){
        String secondName = query.getUserSecondName(login);
        return secondName;
    }

    public Double getAvarageRaiting(){
        Double avarageRaiting = query.getUserAvarageRaiting(login);
        return avarageRaiting;
    }

    public int getTeamId(){
        int teamId = query.getTeam(userId);
        return teamId;
    }

    public boolean checkTeamId(){
        Boolean answer = query.checkTeam(userId);
        return answer;
    }

    public void editData(String firstName, String secondName, int age){
        query.editData(firstName,secondName,age);
    }
}
