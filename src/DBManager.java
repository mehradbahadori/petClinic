import java.sql.*;
import java.util.ArrayList;

public class DBManager {
        Connection connection;
        private static DBManager instance;

        private DBManager() {
            String url = "jdbc:sqlite:petClinic.db";
            try {
                connection = DriverManager.getConnection(url);

            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }

        public static DBManager getInstance() {
            if (instance == null) {
                instance = new DBManager();
            }
            return instance;
        }
public boolean savePets(Pet pet){
    try {
        Statement st=connection.createStatement();
        String query=String.format("INSERT INTO Pet (ownerName,Type,name,age)" +
                " VALUES( '%s', '%s', '%s', '%d');", pet.ownerName, pet.type,pet.name,pet.age);
        st.execute(query);
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return false;
}
        public ArrayList<Pet> loadPets() {
            ArrayList<Pet> pets = new ArrayList<>();
            try {
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM Pet;";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    String ownerName=resultSet.getString("ownerName");
                    String petType=resultSet.getString("type");
                    String petName=resultSet.getString("name");
                    int petAge=resultSet.getInt("age");
                    Pet pet=new Pet(ownerName,petType,petName,petAge);
                    pets.add(pet);
                }
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
            return pets;
        }
    }

