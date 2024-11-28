
import model.Human;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author KhanhDzai - https://www.facebook.com/khanhdepzai.pro/
 */
public class Main {

    static {
//        CLibrary.INSTANCE.toString();
        System.setProperty("jna.library.path", "lib");
//        MyLib.INSTANCE.toString();
//        System.setProperty("jna.library.path", "lib2");
//        MyLib2.INSTANCE.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        MyLib.INSTANCE.helloWorld();
        Human person = new Human();

        // Gán giá trị cho name dưới dạng mảng byte
        String personName = "Mayf nhin cai cho gi ?";
        System.arraycopy(personName.getBytes(), 0, person.name, 0, personName.length());

        person.age = 30;
        MyLib.INSTANCE.handleHuman(person);
    }
}
