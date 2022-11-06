/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wallacewagner.algorito2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author T-Gamer
 */
public class ArquivosObjetos {

    public void criarObjeto(Object object) throws Exception {
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File("database.db"));
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
        }
    }

    public Object lerObjeto() throws Exception {
        try (FileInputStream fileInputStream = new FileInputStream(new File("database.db"));
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return objectInputStream.readObject();
        }
    }

    public static void main(String[] args) {
        
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("João da Silva");
        pessoa.setIdade(24);
        pessoa.setAltura(1.75);
        pessoa.setPeso(60.0);

        ArquivosObjetos arquivosObjetos = new ArquivosObjetos();
        try {
            arquivosObjetos.criarObjeto(pessoa);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }

        Pessoa aluno = null;
        try {
            aluno = (Pessoa) arquivosObjetos.lerObjeto();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        System.out.println(aluno.getNome());
        System.out.println(aluno.getIdade());
        System.out.println(aluno.getAltura());
        System.out.println(aluno.getPeso());
    }
    
}
