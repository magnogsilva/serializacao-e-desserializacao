import java.io.Serializable;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class Pessoa implements Serializable{
    public String nome;
    public int idade;

    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }
}

public class Main {
    public static void main(String[] args){
        Pessoa p = new Pessoa("Mônica",19);

        try{
            FileOutputStream arqSer = new FileOutputStream("info.ser");
            ObjectOutputStream out = new ObjectOutputStream(arqSer);

            out.writeObject(p);
            out.close();
            arqSer.close();

            System.out.println("Serialização");
        }

        catch(IOException erro){
            System.out.println("Erro");
        }

        Pessoa p1;

        try{
            FileInputStream arqDes = new FileInputStream("info.ser");
            ObjectInputStream in = new ObjectInputStream(arqDes);

            p1 = (Pessoa)in.readObject();
            in.close();
            arqDes.close();

            System.out.println("Desserialização");
            System.out.println(p1.nome);
            System.out.println(p1.idade);
        }

        catch(IOException erro){
            System.out.println("Erro 1");
        }
        
        catch (ClassNotFoundException erro){
            System.out.println("Erro 2");
        }
        
    }
}
