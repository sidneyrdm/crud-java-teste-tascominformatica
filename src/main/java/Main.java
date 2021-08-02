import java.sql.Connection;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DevDAO devDAO = new DevDAO();

        //listando devs
        List<Dev> devs = devDAO.list();
        devs.stream().forEach(System.out::println);

        /*criando um novo dev
        Dev dev1 = new Dev();
        dev1.setNome("Eduardo");
        dev1.setProjeto("projeto2");
        dev1.setIdade(20);

        devDAO.create(dev1);*/
        devs = devDAO.list();
        devs.stream().forEach(System.out::println);

        /*editando um dev
        Dev devAtualizado = devDAO.getByID(1);

        devAtualizado.setProjeto("projeto3");
        devDAO.update(devAtualizado);

        devs = devDAO.list();
        devs.stream().forEach(System.out::println);*/

        //deletando um dev
        devDAO.delete(1);
        devs = devDAO.list();
        devs.stream().forEach(System.out::println);

    }
}