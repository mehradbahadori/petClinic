public class Pet {
        String type;
        String name;
        int age;
        String ownerName;

        public Pet(String ownerName, String type, String name, int age) {
            this.type = type;
            this.name = name;
            this.age = age;
            this.ownerName = ownerName;
        }

    @Override
    public String toString() {
        return "Pet{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}


