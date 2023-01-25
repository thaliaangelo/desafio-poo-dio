import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args){

        Curso curso1 = new Curso();
        curso1.setTitulo("Curso java");
        curso1.setDescricao("Descricao curso java");
        curso1.setCargaHoraria(10);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso Python");
        curso2.setDescricao("Descrição curso python");
        curso2.setCargaHoraria(8);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria java");
        mentoria.setDescricao("Descrição mentoria java");
        mentoria.setData(LocalDate.now());


        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição do bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1); //Pegando um conteudo que está no set Conteudos e adicionando ao bootcamp
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev dev1 = new Dev();
        dev1.setNome("Thalia");
        dev1.entrarBootcamp(bootcamp);
        System.out.println("Conteudos inscritos Thalia:" + dev1.getConteudosInscritos());
        System.out.println("---");
        dev1.progredir();
        dev1.progredir();
        System.out.println("Conteudos inscritos Thalia:" + dev1.getConteudosInscritos());
        System.out.println("Conteudos finalizados Thalia: " + dev1.getConteudosFinalizados());
        System.out.println("XP: " + dev1.calcularTotalXp());

        System.out.println("------------");

        Dev dev2 = new Dev();
        dev2.setNome("Viny");
        dev2.entrarBootcamp(bootcamp);
        System.out.println("Conteudos inscritos Viny:" + dev2.getConteudosInscritos());
        System.out.println("XP: " + dev2.calcularTotalXp());
        
        
        /*
        System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);
        */
    }
}