package lesson5;

public class Staff {
    protected String fullName;
    protected String position;
    protected String email;
    protected String phoneNumber;
    protected int salary;
    protected int age;


    public Staff(String fullName, String position, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    void showStaff() {

        System.out.println("Сотрудник, " +
                " ФИО - " + fullName + '.' +
                " Должность - " + position + '.' +
                " email - " + email + '.' +
                " номер телефона - " + phoneNumber + '.' +
                " зарплата - " + salary + '.' +
                " возраст - " + age);
    }


    public static void main(String[] args) {
        Staff[] staffArray = new Staff[5];
        staffArray[0] = new Staff("Федоренко Никита Алексеевич", "Директор", "fedorenko@mail.ru", "89132223355", 50000, 45);
        staffArray[1] = new Staff("Клименко Василий Иванович", "Менеджер", "klimenko@mail.ru", "89132743557", 40000, 40);
        staffArray[2] = new Staff("Потанин Александ Александрович", "Страховой Агент", "potanin@mail.ru", "89132743557", 40000, 47);
        staffArray[3] = new Staff("Столков Алексей Викторович", "Адвокат", "stolkov@mail.ru", "89132743557", 30000, 39);
        staffArray[4] = new Staff("Батищев Николай Сергеевич", "Помошник", "boshki@mail.ru", "89182233587", 20000, 43);

        for (int i = 0; i < staffArray.length; i++) {
            if (staffArray[i].age >= 40) {
                System.out.print("Старше 40 лет");
                staffArray[i].showStaff();
            }

        }
    }

}